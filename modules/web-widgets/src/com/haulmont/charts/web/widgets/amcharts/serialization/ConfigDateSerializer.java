/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.apache.commons.lang3.time.FastDateFormat;

import java.lang.reflect.Type;
import java.util.Date;

public class ConfigDateSerializer implements JsonSerializer<Date> {

    protected static final FastDateFormat DATE_FORMATTER
            = FastDateFormat.getInstance(ChartJsonSerializationContext.DEFAULT_DATE_FORMAT);

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(DATE_FORMATTER.format(src));
    }
}