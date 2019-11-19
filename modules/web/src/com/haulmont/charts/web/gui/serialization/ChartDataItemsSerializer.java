/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.web.gui.serialization;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.amcharts.model.charts.GanttChart;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.web.widgets.amcharts.serialization.ChartJsonSerializationContext;
import com.haulmont.chile.core.datatypes.impl.EnumClass;
import com.haulmont.chile.core.model.Instance;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.Metadata;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component(ChartDataItemsSerializer.NAME)
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ChartDataItemsSerializer {

    public static final String NAME = "charts_ChartDataItemsSerializer";

    protected static final String ITEM_KEY_PROPERTY_NAME = "$k";
    protected static final FastDateFormat DATE_FORMATTER
            = FastDateFormat.getInstance(ChartJsonSerializationContext.DEFAULT_DATE_FORMAT);

    protected Messages messages;
    protected Metadata metadata;

    @Inject
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    @Inject
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public JsonArray serialize(List<DataItem> items, ChartJsonSerializationContext context) {
        JsonArray serialized = new JsonArray();

        Function<DataItem, String> itemKeyMapper = context.getItemKeyMapper();

        for (DataItem item : items) {
            JsonObject itemElement = new JsonObject();

            String itemKey = itemKeyMapper.apply(item);
            if (itemKey != null) {
                itemElement.add(ITEM_KEY_PROPERTY_NAME, context.serialize(itemKey));
            }

            for (String property : context.getProperties()) {
                Object propertyValue = item.getValue(property);

                addProperty(itemElement, property, propertyValue, context);
            }

            if (context.getChartModel() instanceof GanttChart) {
                GanttChart chart = (GanttChart) context.getChartModel();

                String segmentsField = chart.getSegmentsField();

                Object value = item.getValue(segmentsField);
                if (value != null && !(value instanceof Collection)) {
                    throw new RuntimeException("Gantt chart segments field must be a collection");
                }

                List<String> fields = new ArrayList<>();

                addField(fields, chart.getStartField());
                addField(fields, chart.getDurationField());
                addField(fields, chart.getColorField());
                addField(fields, chart.getEndField());
                addField(fields, chart.getColumnWidthField());
                addField(fields, chart.getStartDateField());
                addField(fields, chart.getEndDateField());
                if (chart.getGraph() != null) {
                    addField(fields, chart.getGraph().getAlphaField());
                }

                if (CollectionUtils.isNotEmpty(chart.getAdditionalSegmentFields())) {
                    for (String field : chart.getAdditionalSegmentFields()) {
                        addField(fields, field);
                    }
                }

                JsonArray segments = new JsonArray();

                if (value != null) {
                    int segmentIndex = 0;
                    //noinspection unchecked
                    for (DataItem dataItem : (Collection<DataItem>) value) {
                        JsonObject segment = new JsonObject();
                        segment.add("$i", context.serialize(segmentIndex));

                        for (String field : fields) {
                            Object propertyValue = dataItem.getValue(field);

                            if (propertyValue != null) {
                                addProperty(segment, field, propertyValue, context);
                            }
                        }
                        segments.add(segment);

                        segmentIndex++;
                    }
                }
                itemElement.add(segmentsField, segments);
            }

            serialized.add(itemElement);
        }

        return serialized;
    }

    protected void addProperty(JsonObject jsonObject, String property, Object value, JsonSerializationContext context) {
        Object formattedValue;
        if (value instanceof Entity) {
            formattedValue = metadata.getTools().getInstanceName((Instance) value);
        } else if (value instanceof EnumClass) {
            formattedValue = messages.getMessage((Enum) value);
        } else if (value instanceof Date) {
            formattedValue = DATE_FORMATTER.format((Date) value);
        } else {
            formattedValue = value;
        }
        jsonObject.add(property, context.serialize(formattedValue));
    }

    protected void addField(List<String> fields, @Nullable String field) {
        if (StringUtils.isNotEmpty(field) && !fields.contains(field)) {
            fields.add(field);
        }
    }
}