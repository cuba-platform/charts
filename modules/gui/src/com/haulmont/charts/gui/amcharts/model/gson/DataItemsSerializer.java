/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.amcharts.model.charts.GanttChart;
import com.haulmont.charts.gui.amcharts.model.data.DataItem;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class DataItemsSerializer {

    public List<JsonObject> serialize(List<DataItem> items, JsonSerializationContext context) {
        List<JsonObject> serialized = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat(ChartJsonSerializationContext.DEFAULT_DATE_FORMAT);
        if (context instanceof ChartJsonSerializationContext) {
            ChartJsonSerializationContext chartContext = (ChartJsonSerializationContext) context;
            for (DataItem item : items) {
                JsonObject itemElement = new JsonObject();
                for (String property : chartContext.getProperties()) {
                    Object value = item.getValue(property);
                    addProperty(itemElement, property, value, dateFormat, context);
                }

                if (chartContext.getChartModel() instanceof GanttChart) {
                    GanttChart chart = (GanttChart) chartContext.getChartModel();

                    String segmentsField = chart.getSegmentsField();

                    Object value = item.getValue(segmentsField);
                    if (value != null && !(value instanceof Collection)) {
                        throw new RuntimeException("Gantt chart segments field must be a collection");
                    }

                    List<String> fields = new ArrayList<>();

                    addField(fields, "id");
                    addField(fields, chart.getStartField());
                    addField(fields, chart.getDurationField());
                    addField(fields, chart.getColorField());
                    addField(fields, chart.getEndField());
                    addField(fields, chart.getColumnWidthField());
                    addField(fields, chart.getStartDateField());
                    addField(fields, chart.getEndDateField());
                    if (CollectionUtils.isNotEmpty(chart.getAdditionalSegmentFields())) {
                        fields.addAll(chart.getAdditionalSegmentFields());
                    }

                    JsonArray segments = new JsonArray();

                    for (DataItem dataItem : (Collection<DataItem>) value) {
                        JsonObject segment = new JsonObject();
                        for (String field : fields) {
                            if (StringUtils.isNotEmpty(field)) {
                                if (dataItem.getValue(field) != null) {
                                    addProperty(segment, field, dataItem.getValue(field), dateFormat, context);
                                }
                            }
                        }
                        segments.add(segment);
                    }
                    itemElement.add(segmentsField, segments);
                }

                serialized.add(itemElement);
            }
        }

        return serialized;
    }

    protected void addField(List<String> fields, @Nullable String field) {
        if (field != null) {
            fields.add(field);
        }
    }

    protected void addProperty(JsonObject jsonObject, String property, Object value,
                               SimpleDateFormat dateFormat, JsonSerializationContext context) {
        if (value instanceof Date) {
            value = dateFormat.format((Date) value);
        }
        jsonObject.add(property, context.serialize(value));
    }
}