/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.serialization;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.model.JsFunction;
import com.haulmont.charts.gui.model.JsonEnum;
import com.haulmont.charts.gui.amcharts.model.Color;
import com.haulmont.charts.gui.amcharts.model.Rule;
import com.haulmont.charts.gui.amcharts.model.Settings;
import com.haulmont.charts.web.serialization.JsFunctionSerializer;
import com.haulmont.charts.web.serialization.JsonEnumSerializer;

import java.util.Date;

public class ChartSettingsSerializer {

    protected final static Gson gson;

    static {
        // GSON is thread safe so we can use shared GSON instance
        gson = createGsonBuilder().create();
    }

    /**
     * Returns default GSON builder for configuration serializer.
     */
    public static GsonBuilder createGsonBuilder() {
        GsonBuilder builder = new GsonBuilder();
        builder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                Expose expose = f.getAnnotation(Expose.class);
                return expose != null && !expose.serialize();
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });
        setDefaultProperties(builder);
        return builder;
    }

    protected static void setDefaultProperties(GsonBuilder builder) {
        // uncomment if you wish to debug generated json
        // builder.setPrettyPrinting();
        builder.registerTypeHierarchyAdapter(JsonEnum.class, new JsonEnumSerializer());
        builder.registerTypeHierarchyAdapter(Color.class, new ColorSerializer());
        builder.registerTypeHierarchyAdapter(JsFunction.class, new JsFunctionSerializer());
        builder.registerTypeHierarchyAdapter(Date.class, new ConfigDateSerializer());
        builder.registerTypeHierarchyAdapter(Rule.class, new ResponsiveRuleSerializer());
    }

    public String serialize(Settings settings) {
        return gson.toJson(settings);
    }
}