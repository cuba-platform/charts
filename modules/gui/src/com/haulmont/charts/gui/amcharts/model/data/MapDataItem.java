/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.google.common.collect.ImmutableMap;

import java.util.Collections;
import java.util.Map;

/**
 * Chart data item, which is a set of key-value pairs.
 *
 * @deprecated Use base {@link com.haulmont.charts.gui.data.MapDataItem}
 */
@Deprecated
public class MapDataItem extends com.haulmont.charts.gui.data.MapDataItem {

    private static final long serialVersionUID = -4221150268668862399L;

    public MapDataItem(Map<String, Object> properties) {
        super(properties);
    }

    public MapDataItem() {
        this(Collections.emptyMap());
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
}