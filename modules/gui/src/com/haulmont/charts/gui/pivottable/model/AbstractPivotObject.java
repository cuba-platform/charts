/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.model.JsFunction;
import com.haulmont.charts.gui.model.JsonEnum;
import com.haulmont.charts.gui.serialization.JsFunctionSerializer;
import com.haulmont.charts.gui.serialization.JsonEnumSerializer;
import com.haulmont.charts.gui.pivottable.model.gson.*;

import java.io.Serializable;

public abstract class AbstractPivotObject implements Serializable {

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
        builder.registerTypeHierarchyAdapter(JsonEnum.class, new JsonEnumSerializer());
        builder.registerTypeHierarchyAdapter(JsFunction.class, new JsFunctionSerializer());
        builder.registerTypeHierarchyAdapter(DerivedProperties.class, new DerivedPropertiesSerializer());
        builder.registerTypeHierarchyAdapter(UnusedPropertiesVertical.class, new UnusedPropertiesVerticalSerializer());
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
