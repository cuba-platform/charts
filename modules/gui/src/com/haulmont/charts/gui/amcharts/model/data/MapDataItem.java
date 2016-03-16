/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.haulmont.cuba.core.global.UuidProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 */
public class MapDataItem implements DataItem {

    private static final long serialVersionUID = -6115531750392377539L;

    protected UUID id;
    private Map<String, Object> properties = new HashMap<>();

    public MapDataItem(Map<String, Object> properties) {
        this();
        this.properties.putAll(properties);
    }

    public MapDataItem() {
        this.id = UuidProvider.createUuid();
    }

    @Override
    public Object getValue(String property) {
        Object value = properties.get(property);
        if (value == null && "id".equals(property)) {
            return id;
        }
        return value;
    }

    public MapDataItem add(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    public void remove(String key) {
        properties.remove(key);
    }
}