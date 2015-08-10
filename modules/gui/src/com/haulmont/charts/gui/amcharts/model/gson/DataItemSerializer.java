/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.haulmont.charts.gui.amcharts.model.data.DataItem;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gorelov
 * @version $Id$
 */
public class DataItemSerializer implements JsonSerializer<DataItem> {

    String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:S";

    @Override
    public JsonElement serialize(DataItem src, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        JsonObject itemElement = new JsonObject();
        for (String property : src.getProperties()) {
            Object value = src.getValue(property);
            if (value instanceof Date) {
                value = dateFormat.format((Date) value);
            }

            itemElement.add(property, context.serialize(value));
        }
        return itemElement;
    }
}
