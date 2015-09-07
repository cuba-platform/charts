/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.*;
import com.haulmont.charts.gui.amcharts.model.charts.GanttChart;
import com.haulmont.charts.gui.amcharts.model.data.DataItem;
import com.haulmont.charts.gui.amcharts.model.data.DataProvider;
import com.haulmont.cuba.core.entity.Entity;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author artamonov
 * @version $Id$
 */
public class DataProviderSerializer implements JsonSerializer<DataProvider> {
    @Override
    public JsonElement serialize(DataProvider src, Type typeOfSrc, JsonSerializationContext context) {
        JsonArray dataProviderElement = new JsonArray();
        SimpleDateFormat dateFormat = new SimpleDateFormat(src.getDateFormat());
        for (DataItem item : src.getItems()) {
            JsonObject itemElement = new JsonObject();
            for (String property: item.getProperties()) {
                Object value = item.getValue(property);
                addPropertty(itemElement, property, value, dateFormat, context);
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
                            addPropertty(segment, field, dataItem.getValue(field), dateFormat, context);
                        }
                    }
                    segments.add(segment);
                }
                itemElement.add(segmentsField, segments);
            }

            dataProviderElement.add(itemElement);
        }

        // Prevent errors on client for empty dataprovider
        if (dataProviderElement.size() == 0) {
            dataProviderElement.add(new JsonObject());
        }

        return dataProviderElement;
    }

    protected void addPropertty(JsonObject jsonObject, String property, Object value,
                                SimpleDateFormat dateFormat, JsonSerializationContext context) {
        if (value instanceof Date) {
            value = dateFormat.format((Date) value);
        }
        jsonObject.add(property, context.serialize(value));
    }
}