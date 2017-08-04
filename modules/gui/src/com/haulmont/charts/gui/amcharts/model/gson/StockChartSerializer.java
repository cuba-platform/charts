/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.amcharts.model.Color;
import com.haulmont.charts.gui.amcharts.model.DataSet;
import com.haulmont.charts.gui.amcharts.model.Rule;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.model.JsFunction;
import com.haulmont.charts.gui.model.JsonEnum;
import com.haulmont.charts.gui.serialization.JsFunctionSerializer;
import com.haulmont.charts.gui.serialization.JsonEnumSerializer;
import com.haulmont.cuba.core.global.AppBeans;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public class StockChartSerializer {

    protected final static Gson chartGson;

    static {
        // GSON is thread safe so we can use shared GSON instance
        chartGson = createChartGsonBuilder().create();
    }

    private static GsonBuilder createChartGsonBuilder() {
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

    private final Logger logger = LoggerFactory.getLogger(StockChartSerializer.class);

    public StockChartSerializer(Function<DataItem, String> itemKeyMapper) {
        this.itemKeyMapper = itemKeyMapper;
    }

    public String serialize(StockChartGroup chart) {
        JsonElement jsonTree = chartGson.toJsonTree(chart);

        if (CollectionUtils.isNotEmpty(chart.getDataSets())) {
            ChartJsonSerializationContext context = new ChartJsonSerializationContext(chartGson, chart, itemKeyMapper);
            ChartDataItemsSerializer serializer = getDataItemsSerializer();

            JsonArray jsonDataSets = (JsonArray) jsonTree.getAsJsonObject().get("dataSets");
            for (JsonElement dataSetElement : jsonDataSets) {
                JsonObject dataSetObject = (JsonObject) dataSetElement;
                String dataSetId = dataSetObject.get("id").getAsString();
                DataSet dataSet = chart.getDataSet(dataSetId);
                if (dataSet != null && dataSet.getDataProvider() != null) {
                    JsonArray dataProviderElement = serializer.serialize(dataSet.getDataProvider().getItems(), context);

                    // Prevent errors on client for empty data provider
                    if (dataProviderElement.size() == 0) {
                        dataProviderElement.add(new JsonObject());
                    }

                    dataSetObject.add("dataProvider", dataProviderElement);
                }
            }
        }

        return chartGson.toJson(jsonTree);
    }

    protected ChartDataItemsSerializer getDataItemsSerializer() {
        return AppBeans.get(ChartDataItemsSerializer.NAME);
    }

    public String serializeChanges(StockChartGroup chart, Map<DataSet, ChartIncrementalChanges> changedItems) {
        JsonObject jsonChangedDataSetElement = new JsonObject();

        ChartJsonSerializationContext context = new ChartJsonSerializationContext(chartGson, chart, itemKeyMapper);
        ChartDataItemsSerializer serializer = getDataItemsSerializer();

        for (Map.Entry<DataSet, ChartIncrementalChanges> changesEntry : changedItems.entrySet()) {
            JsonObject jsonChangedItemsElement = new JsonObject();

            ChartIncrementalChanges changes = changesEntry.getValue();
            if (changes.getAddedItems() != null) {
                jsonChangedItemsElement.add("add", serializer.serialize(changes.getAddedItems(), context));
            }
            if (changes.getRemovedItems() != null) {
                jsonChangedItemsElement.add("remove", serializer.serialize(changes.getRemovedItems(), context));
            }
            if (changes.getUpdatedItems() != null) {
                jsonChangedItemsElement.add("update", serializer.serialize(changes.getUpdatedItems(), context));
            }

            String dataSetId = changesEntry.getKey().getId();
            if (dataSetId != null) {
                jsonChangedDataSetElement.add(dataSetId, jsonChangedItemsElement);
            } else {
                logger.warn("DataSet of StockChart does not have id. Incremental updated will not be performed.");
            }
        }

        return chartGson.toJson(jsonChangedDataSetElement);
    }
}