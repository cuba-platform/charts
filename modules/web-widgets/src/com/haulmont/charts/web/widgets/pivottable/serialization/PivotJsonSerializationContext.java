/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.pivottable.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.pivottable.model.PivotTableModel;
import org.apache.commons.collections4.MapUtils;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PivotJsonSerializationContext implements JsonSerializationContext {

    protected PivotTableModel pivotTableModel;
    protected Gson gson;

    public PivotJsonSerializationContext(PivotTableModel pivotTableModel, Gson gson) {
        this.pivotTableModel = pivotTableModel;
        this.gson = gson;
    }

    @Override
    public JsonElement serialize(Object src) {
        return gson.toJsonTree(src);
    }

    @Override
    public JsonElement serialize(Object src, Type typeOfSrc) {
        return gson.toJsonTree(src, typeOfSrc);
    }

    public PivotTableModel getPivotTableModel() {
        return pivotTableModel;
    }

    public List<String> getProperties() {
        return Collections.unmodifiableList(pivotTableModel.getWiredFields());
    }

    public String getLocalizedPropertyName(String property) {
        Map<String, String> properties = pivotTableModel.getProperties();
        return (MapUtils.isEmpty(properties) || !properties.containsKey(property))
                ? property
                : properties.get(property);
    }
}