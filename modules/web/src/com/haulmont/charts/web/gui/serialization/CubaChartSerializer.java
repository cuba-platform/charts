/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.web.gui.serialization;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.model.JsFunction;
import com.haulmont.charts.gui.model.JsonEnum;
import com.haulmont.charts.gui.amcharts.model.Color;
import com.haulmont.charts.gui.amcharts.model.Rule;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.web.serialization.JsFunctionSerializer;
import com.haulmont.charts.web.serialization.JsonEnumSerializer;
import com.haulmont.charts.web.widgets.amcharts.serialization.*;
import com.haulmont.cuba.core.global.AppBeans;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component(CubaChartSerializer.NAME)
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CubaChartSerializer implements ChartSerializer {

    public static final String NAME = "charts_CubaChartSerializer";

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
        setDefaultProperties(builder);
        return builder;
    }

    private static void setDefaultProperties(GsonBuilder builder) {
        // uncomment if you wish to debug generated json
        // builder.setPrettyPrinting();
        builder.registerTypeHierarchyAdapter(JsonEnum.class, new JsonEnumSerializer());
        builder.registerTypeHierarchyAdapter(Color.class, new ColorSerializer());
        builder.registerTypeHierarchyAdapter(JsFunction.class, new JsFunctionSerializer());
        builder.registerTypeHierarchyAdapter(Date.class, new ConfigDateSerializer());
        builder.registerTypeHierarchyAdapter(Rule.class, new ResponsiveRuleSerializer());
    }

    protected Function<DataItem, String> itemKeyMapper;
    protected ChartDataItemsSerializer itemsSerializer;

    public CubaChartSerializer() {
        itemsSerializer = createDataItemsSerializer();
    }

    protected ChartDataItemsSerializer createDataItemsSerializer() {
        return AppBeans.getPrototype(ChartDataItemsSerializer.NAME);
    }

    @Override
    public String serialize(AbstractChart chart) {
        JsonElement jsonTree = chartGson.toJsonTree(chart);

        DataProvider dataProvider = chart.getDataProvider();
        if (dataProvider != null) {
            ChartJsonSerializationContext context = createChartJsonSerializationContext(chart);

            JsonArray dataProviderElement = itemsSerializer.serialize(dataProvider.getItems(), context);

            // Prevent errors on client for empty data provider
            if (dataProviderElement.size() == 0) {
                dataProviderElement.add(new JsonObject());
            }

            jsonTree.getAsJsonObject().add("dataProvider", dataProviderElement);
        }

        return chartGson.toJson(jsonTree);
    }

    @Override
    public String serializeChanges(AbstractChart chart, ChartIncrementalChanges changes) {
        JsonObject jsonChangedItemsElement = new JsonObject();

        ChartJsonSerializationContext context = createChartJsonSerializationContext(chart);

        if (changes.getAddedItems() != null) {
            jsonChangedItemsElement.add("add", itemsSerializer.serialize(changes.getAddedItems(), context));
        }
        if (changes.getRemovedItems() != null) {
            jsonChangedItemsElement.add("remove", itemsSerializer.serialize(changes.getRemovedItems(), context));
        }
        if (changes.getUpdatedItems() != null) {
            jsonChangedItemsElement.add("update", itemsSerializer.serialize(changes.getUpdatedItems(), context));
        }

        return chartGson.toJson(jsonChangedItemsElement);
    }

    protected ChartJsonSerializationContext createChartJsonSerializationContext(AbstractChart chart) {
        if (itemKeyMapper == null) {
            throw new IllegalStateException("itemKeyMapper can't be null");
        }
        return new ChartJsonSerializationContext(chartGson, chart, itemKeyMapper);
    }

    @Override
    public String toJson(Object value) {
        return chartGson.toJson(value);
    }

    @Override
    public Function<DataItem, String> getDataItemKeyMapper() {
        return this.itemKeyMapper;
    }

    @Override
    public void setDataItemKeyMapper(Function<DataItem, String> itemKeyMapper) {
        this.itemKeyMapper = itemKeyMapper;
    }
}