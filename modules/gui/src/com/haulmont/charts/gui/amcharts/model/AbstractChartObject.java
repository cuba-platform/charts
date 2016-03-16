/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.amcharts.model.gson.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Abstract base class for model classes to be serialized to JSON.
 *
 */
public abstract class AbstractChartObject implements Serializable {

    protected final static Gson gson;

    static {
        // GSON is thread safe so we can use shared GSON instance
        gson = createGsonBuilder().create();
    }

    public static Gson getSharedGson() {
        return gson;
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
        builder.registerTypeHierarchyAdapter(ChartEnum.class, new ChartEnumSerializer());
        builder.registerTypeHierarchyAdapter(Color.class, new ColorSerializer());
        builder.registerTypeHierarchyAdapter(JsFunction.class, new JsFunctionSerializer());
        builder.registerTypeHierarchyAdapter(Date.class, new ConfigDateSerializer());
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}