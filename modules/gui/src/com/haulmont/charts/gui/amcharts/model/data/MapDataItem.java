/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.haulmont.cuba.core.global.UuidProvider;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

/**
 * Chart data item, which is a set of key-value pairs.
 */
public class MapDataItem extends com.haulmont.charts.gui.data.MapDataItem {

    private static final long serialVersionUID = -4221150268668862399L;

    protected UUID id;

    public MapDataItem(Map<String, Object> properties) {
        super(properties);
        this.id = UuidProvider.createUuid();
    }

    public MapDataItem() {
        this(Collections.emptyMap());
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
}
