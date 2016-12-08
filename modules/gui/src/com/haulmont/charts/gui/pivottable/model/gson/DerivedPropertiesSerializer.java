/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.haulmont.charts.gui.model.JsFunction;
import com.haulmont.charts.gui.pivottable.model.DerivedProperties;

import java.lang.reflect.Type;
import java.util.Map;

public class DerivedPropertiesSerializer implements JsonSerializer<DerivedProperties> {

    private static final String SUFFIX = "Function";

    @Override
    public JsonElement serialize(DerivedProperties src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject derivedAttributes = new JsonObject();
        for (Map.Entry<String, JsFunction> entry : src.getProperties().entrySet()) {
            derivedAttributes.add(entry.getKey() + SUFFIX, context.serialize(entry.getValue()));
        }
        return derivedAttributes;
    }
}
