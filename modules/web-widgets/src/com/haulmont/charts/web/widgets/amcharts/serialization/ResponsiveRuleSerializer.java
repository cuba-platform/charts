/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.haulmont.charts.gui.amcharts.model.Rule;

import java.lang.reflect.Type;

public class ResponsiveRuleSerializer implements JsonSerializer<Rule> {

    @Override
    public JsonElement serialize(Rule src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject ruleJson = new JsonObject();

        ruleJson.add("minHeight", context.serialize(src.getMinHeight()));
        ruleJson.add("maxHeight", context.serialize(src.getMaxHeight()));
        ruleJson.add("minWidth", context.serialize(src.getMinWidth()));
        ruleJson.add("maxWidth", context.serialize(src.getMaxWidth()));
        ruleJson.add("overrides", src.getOverridesJson());

        return ruleJson;
    }
}