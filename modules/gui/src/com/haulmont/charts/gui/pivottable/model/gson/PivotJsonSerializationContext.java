/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.pivottable.model.AbstractPivotObject;
import com.haulmont.charts.gui.pivottable.model.PivotTableModel;
import org.apache.commons.collections.MapUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class PivotJsonSerializationContext implements JsonSerializationContext {

    protected PivotTableModel pivotTableModel;

    public PivotJsonSerializationContext(PivotTableModel pivotTableModel) {
        this.pivotTableModel = pivotTableModel;
    }

    @Override
    public JsonElement serialize(Object src) {
        return AbstractPivotObject.getSharedGson().toJsonTree(src);
    }

    @Override
    public JsonElement serialize(Object src, Type typeOfSrc) {
        return AbstractPivotObject.getSharedGson().toJsonTree(src, typeOfSrc);
    }

    public PivotTableModel getPivotTableModel() {
        return pivotTableModel;
    }

    public List<String> getProperties() {
        List<String> properties = new ArrayList<>();
        properties.addAll(new LinkedHashSet<>(pivotTableModel.getWiredFields()));
        return properties;
    }

    public String getLocalizedPropertyName(String property) {
        Map<String, String> properties = pivotTableModel.getProperties();
        return (MapUtils.isEmpty(properties) || !properties.containsKey(property))
                ? property
                : properties.get(property);
    }
}