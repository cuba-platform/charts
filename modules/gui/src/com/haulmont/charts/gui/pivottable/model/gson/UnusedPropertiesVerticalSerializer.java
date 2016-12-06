/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.haulmont.charts.gui.pivottable.model.UnusedPropertiesVertical;

import java.lang.reflect.Type;

public class UnusedPropertiesVerticalSerializer implements JsonSerializer<UnusedPropertiesVertical> {
    @Override
    public JsonElement serialize(UnusedPropertiesVertical src, Type typeOfSrc, JsonSerializationContext context) {
        if (src.getIntVal() != null) {
            return new JsonPrimitive(src.getIntVal());
        } else {
            return new JsonPrimitive(src.getBoolVal());
        }
    }
}
