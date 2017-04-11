/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.data;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Data item, which is a set of key-value pairs.
 */
public class MapDataItem implements DataItem, DataItem.HasId {

    private static final long serialVersionUID = -6115531750392377539L;

    protected Map<String, Object> properties = new HashMap<>();

    public MapDataItem() {
    }

    public MapDataItem(Map<String, Object> properties) {
        this.properties.putAll(properties);
    }

    protected static void put(ImmutableMap.Builder<String, Object> builder, String key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("key should not be null");
        }

        if (value != null) {
            builder.put(key, value);
        }
    }

    public static MapDataItem of(String paramName, Object paramValue) {
        ImmutableMap.Builder<String, Object> b = new ImmutableMap.Builder<>();
        put(b, paramName, paramValue);
        return new MapDataItem(b.build());
    }

    public static MapDataItem of(String paramName1, Object paramValue1,
                                 String paramName2, Object paramValue2) {
        ImmutableMap.Builder<String, Object> b = new ImmutableMap.Builder<>();
        put(b, paramName1, paramValue1);
        put(b, paramName2, paramValue2);
        return new MapDataItem(b.build());
    }

    public static MapDataItem of(String paramName1, Object paramValue1,
                                 String paramName2, Object paramValue2,
                                 String paramName3, Object paramValue3) {
        ImmutableMap.Builder<String, Object> b = new ImmutableMap.Builder<>();
        put(b, paramName1, paramValue1);
        put(b, paramName2, paramValue2);
        put(b, paramName3, paramValue3);
        return new MapDataItem(b.build());
    }

    public static MapDataItem of(String paramName1, Object paramValue1,
                                 String paramName2, Object paramValue2,
                                 String paramName3, Object paramValue3,
                                 String paramName4, Object paramValue4) {
        ImmutableMap.Builder<String, Object> b = new ImmutableMap.Builder<>();
        put(b, paramName1, paramValue1);
        put(b, paramName2, paramValue2);
        put(b, paramName3, paramValue3);
        put(b, paramName4, paramValue4);
        return new MapDataItem(b.build());
    }

    public static MapDataItem of(String paramName1, Object paramValue1,
                                 String paramName2, Object paramValue2,
                                 String paramName3, Object paramValue3,
                                 String paramName4, Object paramValue4,
                                 String paramName5, Object paramValue5) {
        ImmutableMap.Builder<String, Object> b = new ImmutableMap.Builder<>();
        put(b, paramName1, paramValue1);
        put(b, paramName2, paramValue2);
        put(b, paramName3, paramValue3);
        put(b, paramName4, paramValue4);
        put(b, paramName5, paramValue5);
        return new MapDataItem(b.build());
    }

    public static MapDataItem of(String paramName1, Object paramValue1,
                                 String paramName2, Object paramValue2,
                                 String paramName3, Object paramValue3,
                                 String paramName4, Object paramValue4,
                                 String paramName5, Object paramValue5,
                                 String paramName6, Object paramValue6) {
        ImmutableMap.Builder<String, Object> b = new ImmutableMap.Builder<>();
        put(b, paramName1, paramValue1);
        put(b, paramName2, paramValue2);
        put(b, paramName3, paramValue3);
        put(b, paramName4, paramValue4);
        put(b, paramName5, paramValue5);
        put(b, paramName6, paramValue6);
        return new MapDataItem(b.build());
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

    @Override
    public Object getId() {
        return this;
    }
}