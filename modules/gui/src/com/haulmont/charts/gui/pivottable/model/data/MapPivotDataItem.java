/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Pivot data item, which is a set of key-value pairs.
 */
public class MapPivotDataItem implements PivotDataItem {

    private static final long serialVersionUID = 9092600506624197172L;

    private Map<String, Object> properties = new HashMap<>();

    public MapPivotDataItem() {
    }

    public MapPivotDataItem(Map<String, Object> properties) {
        this();
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
    public MapPivotDataItem add(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    /**
     * Removes property from this {@code MapPivotDataItem}
     *
     * @param key name of property
     * @return this {@code MapDataItem}
     */
    public MapPivotDataItem remove(String key) {
        properties.remove(key);
        return this;
    }
}
