/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.haulmont.charts.gui.amcharts.model.ChartEnum;

import java.lang.reflect.Type;

/**
 */
public class ChartEnumSerializer implements JsonSerializer<ChartEnum> {

    @Override
    public JsonElement serialize(ChartEnum src, Type typeOfSrc,
                                 JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}