/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.amcharts.model.charts.GanttChart;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.chile.core.datatypes.impl.EnumClass;
import com.haulmont.chile.core.model.Instance;
import com.haulmont.chile.core.model.utils.InstanceUtils;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Messages;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
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

    protected Messages messages;

    @Inject
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public JsonArray serialize(List<DataItem> items, ChartJsonSerializationContext context) {
        JsonArray serialized = new JsonArray();

        Function<DataItem, String> itemKeyMapper = context.getItemKeyMapper();

        SimpleDateFormat dateFormat = new SimpleDateFormat(ChartJsonSerializationContext.DEFAULT_DATE_FORMAT);
        for (DataItem item : items) {
            JsonObject itemElement = new JsonObject();

            String itemKey = itemKeyMapper.apply(item);
            if (itemKey != null) {
                itemElement.add(ITEM_KEY_PROPERTY_NAME, context.serialize(itemKey));
            }

            for (String property : context.getProperties()) {
                Object propertyValue = item.getValue(property);

                addProperty(itemElement, property, propertyValue, dateFormat, context);
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
                                addProperty(segment, field, propertyValue, dateFormat, context);
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

    protected void addField(List<String> fields, @Nullable String field) {
        if (StringUtils.isNotEmpty(field) && !fields.contains(field)) {
            fields.add(field);
        }
    }

    protected void addProperty(JsonObject jsonObject, String property, Object value,
                               SimpleDateFormat dateFormat, JsonSerializationContext context) {
        Object formattedValue;
        if (value instanceof Entity) {
            formattedValue = InstanceUtils.getInstanceName((Instance) value);
        } else if (value instanceof EnumClass) {
            formattedValue = messages.getMessage((Enum) value);
        } else if (value instanceof Date) {
            formattedValue = dateFormat.format((Date) value);
        } else {
            formattedValue = value;
        }
        jsonObject.add(property, context.serialize(formattedValue));
    }
}