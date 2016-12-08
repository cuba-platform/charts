/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Data item, which is a set of key-value pairs.
 */
public class MapDataItem implements DataItem {

    private static final long serialVersionUID = -6115531750392377539L;

    protected Map<String, Object> properties = new HashMap<>();

    public MapDataItem() {
    }

    public MapDataItem(Map<String, Object> properties) {
        this.properties.putAll(properties);
    }

    /**
     * @param property name of property
     * @return the value of a property with the specified property name.
     */
    @Override
    public Object getValue(String property) {
        return properties.get(property);
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