/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.*;
import com.haulmont.charts.gui.amcharts.model.data.DataItem;
import com.haulmont.charts.gui.amcharts.model.data.DataProvider;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                if (value instanceof Date) {
                    value = dateFormat.format((Date) value);
                }

                itemElement.add(property, context.serialize(value));
            }
            dataProviderElement.add(itemElement);
        }

        return dataProviderElement;
    }
}