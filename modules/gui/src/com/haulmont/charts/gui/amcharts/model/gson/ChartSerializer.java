/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.amcharts.model.Color;
import com.haulmont.charts.gui.amcharts.model.Rule;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.gui.model.JsFunction;
import com.haulmont.charts.gui.model.JsonEnum;
import com.haulmont.charts.gui.serialization.JsFunctionSerializer;
import com.haulmont.charts.gui.serialization.JsonEnumSerializer;
import com.haulmont.cuba.core.global.AppBeans;

import java.util.Date;
import java.util.function.Function;

public class ChartSerializer {
    protected final static Gson chartGson;

    static {
        // GSON is thread safe so we can use shared GSON instance
        chartGson = createChartGsonBuilder().create();
    }

    protected static GsonBuilder createChartGsonBuilder() {
        GsonBuilder builder = new GsonBuilder();
        builder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                Expose expose = f.getAnnotation(Expose.class);
                return expose != null && !expose.serialize() || "dataProvider".equals(f.getName());
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });
        // uncomment if you wish to debug generated json
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

    protected Function<DataItem, String> itemKeyMapper;

    public ChartSerializer(Function<DataItem, String> itemKeyMapper) {
        this.itemKeyMapper = itemKeyMapper;
    }

    public String serialize(AbstractChart chart) {
        JsonElement jsonTree = chartGson.toJsonTree(chart);

        DataProvider dataProvider = chart.getDataProvider();
        if (dataProvider != null) {
            ChartJsonSerializationContext context = new ChartJsonSerializationContext(chartGson, chart, itemKeyMapper);
            ChartDataItemsSerializer serializer = getDataItemsSerializer();

            JsonArray dataProviderElement = serializer.serialize(dataProvider.getItems(), context);

            // Prevent errors on client for empty data provider
            if (dataProviderElement.size() == 0) {
                dataProviderElement.add(new JsonObject());
            }

            jsonTree.getAsJsonObject().add("dataProvider", dataProviderElement);
        }

        return chartGson.toJson(jsonTree);
    }

    public String serializeChanges(AbstractChart chart, ChartIncrementalChanges changes) {
        JsonObject jsonChangedItemsElement = new JsonObject();

        ChartJsonSerializationContext context = new ChartJsonSerializationContext(chartGson, chart, itemKeyMapper);
        ChartDataItemsSerializer serializer = getDataItemsSerializer();

        if (changes.getAddedItems() != null) {
            jsonChangedItemsElement.add("add", serializer.serialize(changes.getAddedItems(), context));
        }
        if (changes.getRemovedItems() != null) {
            jsonChangedItemsElement.add("remove", serializer.serialize(changes.getRemovedItems(), context));
        }
        if (changes.getUpdatedItems() != null) {
            jsonChangedItemsElement.add("update", serializer.serialize(changes.getUpdatedItems(), context));
        }

        return chartGson.toJson(jsonChangedItemsElement);
    }

    public String toJson(Object value) {
        return chartGson.toJson(value);
    }

    protected ChartDataItemsSerializer getDataItemsSerializer() {
        return AppBeans.getPrototype(ChartDataItemsSerializer.NAME);
    }
}