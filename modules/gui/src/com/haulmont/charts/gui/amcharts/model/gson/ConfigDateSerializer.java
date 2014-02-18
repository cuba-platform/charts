/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author artamonov
 * @version $Id$
 */
public class ConfigDateSerializer implements JsonSerializer<Date> {

    String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:S";

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

        return new JsonPrimitive(df.format(src));
    }
}