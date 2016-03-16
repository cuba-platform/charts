/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.amcharts.model.AbstractChartObject;
import com.haulmont.charts.gui.amcharts.model.charts.ChartModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 */
public class ChartJsonSerializationContext implements JsonSerializationContext {

    public static final String DEFAULT_JS_DATE_FORMAT = "YYYY-MM-DD JJ:NN:SS:QQQ";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:S";

    protected ChartModel chartModel;

    public ChartJsonSerializationContext(ChartModel chartModel) {
        this.chartModel = chartModel;
    }

    @Override
    public JsonElement serialize(Object src) {
        return AbstractChartObject.getSharedGson().toJsonTree(src);
    }

    @Override
    public JsonElement serialize(Object src, Type typeOfSrc) {
        return AbstractChartObject.getSharedGson().toJsonTree(src, typeOfSrc);
    }

    public ChartModel getChartModel() {
        return chartModel;
    }

    public List<String> getProperties() {
        List<String> properties = new ArrayList<>();
        properties.add("id");
        properties.addAll(new LinkedHashSet<>(chartModel.getWiredFields()));
        return properties;
    }
}
