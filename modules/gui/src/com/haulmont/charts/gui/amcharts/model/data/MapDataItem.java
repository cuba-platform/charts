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
 * Chart data item, which is a set of key-value pairs.
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

    /**
     * @param property name of property
     * @return the value of a property with the specified property name.
     */
    @Override
    public Object getValue(String property) {
        Object value = properties.get(property);
        if (value == null && "id".equals(property)) {
            return id;
        }
        return value;
    }

    /**
     * Adds value with given key.
     *
     * @param key   name of property
     * @param value property value
     * @return this {@code MapDataItem}
     */
    public MapDataItem add(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    /**
     * Removes property from this {@code MapDataItem}
     *
     * @param key name of property
     */
    public void remove(String key) {
        properties.remove(key);
    }
}