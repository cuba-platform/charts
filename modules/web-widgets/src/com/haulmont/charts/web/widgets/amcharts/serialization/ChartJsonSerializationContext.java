/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.amcharts.model.charts.ChartModelImpl;
import com.haulmont.charts.gui.data.DataItem;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ChartJsonSerializationContext implements JsonSerializationContext {

    public static final String DEFAULT_JS_DATE_FORMAT = "YYYY-MM-DD JJ:NN:SS:QQQ";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:S";

    protected Gson gson;
    protected ChartModelImpl chartModel;
    protected Function<DataItem, String> itemKeyMapper;

    public ChartJsonSerializationContext(Gson gson, ChartModelImpl chartModel, Function<DataItem, String> itemKeyMapper) {
        this.gson = gson;
        this.chartModel = chartModel;
        this.itemKeyMapper = itemKeyMapper;
    }

    @Override
    public JsonElement serialize(Object src) {
        return gson.toJsonTree(src);
    }

    @Override
    public JsonElement serialize(Object src, Type typeOfSrc) {
        return gson.toJsonTree(src, typeOfSrc);
    }

    public ChartModelImpl getChartModel() {
        return chartModel;
    }

    public Function<DataItem, String> getItemKeyMapper() {
        return itemKeyMapper;
    }

    public List<String> getProperties() {
        List<String> properties = new ArrayList<>();
        for (String property : chartModel.getWiredFields()) {
            if (!properties.contains(property)) {
                properties.add(property);
            }
        }
        return properties;
    }
}