/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.amcharts.model.charts.GanttChart;
import com.haulmont.charts.gui.amcharts.model.data.DataItem;
import com.haulmont.charts.gui.amcharts.model.data.DataProvider;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author gorelov
 * @version $Id$
 */
public class DataItemsSerializer {
    public List<JsonObject> serialize(DataProvider src, List<DataItem> items, JsonSerializationContext context) {
        List<JsonObject> serialized = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat(src.getDateFormat());
        for (DataItem item : items) {
            JsonObject itemElement = new JsonObject();
            for (String property: item.getProperties()) {
                Object value = item.getValue(property);
                addProperty(itemElement, property, value, dateFormat, context);
            }

            if (src.getChart() instanceof GanttChart) {
                GanttChart chart = (GanttChart) src.getChart();

                String segmentsField = chart.getSegmentsField();

                Object value = item.getValue(segmentsField);
                if (value != null && !(value instanceof Collection)) {
                    throw new RuntimeException("Gantt chart segments field must be a collection");
                }

                List<String> fields = new ArrayList<>();
                fields.add(chart.getStartField());
                fields.add(chart.getDurationField());
                fields.add(chart.getColorField());
                if (CollectionUtils.isNotEmpty(chart.getAdditionalSegmentFields())) {
                    fields.addAll(chart.getAdditionalSegmentFields());
                }

                JsonArray segments = new JsonArray();

                for (DataItem dataItem : (Collection<DataItem>) value) {
                    JsonObject segment = new JsonObject();
                    for (String field : fields) {
                        if (StringUtils.isNotEmpty(field)) {
                            addProperty(segment, field, dataItem.getValue(field), dateFormat, context);
                        }
                    }
                    segments.add(segment);
                }
                itemElement.add(segmentsField, segments);
            }

            serialized.add(itemElement);
        }

        return serialized;
    }

    protected void addProperty(JsonObject jsonObject, String property, Object value,
                               SimpleDateFormat dateFormat, JsonSerializationContext context) {
        if (value instanceof Date) {
            value = dateFormat.format((Date) value);
        }
        jsonObject.add(property, context.serialize(value));
    }
}