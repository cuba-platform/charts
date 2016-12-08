/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.haulmont.cuba.core.global.UuidProvider;

import java.util.UUID;

/**
 * Chart data item, which contains an instance of any class.
 */
public class SimpleDataItem extends com.haulmont.charts.gui.data.SimpleDataItem {

    private static final long serialVersionUID = 7128101061882264424L;

    protected UUID id;

    public SimpleDataItem(Object item) {
        super(item);
        this.id = UuidProvider.createUuid();
    }

    @Override
    public Object getValue(String property) {
        try {
            return super.getValue(property);
        } catch (IllegalArgumentException ex) {
            if ("id".equals(property)) {
                return id;
            } else {
                throw ex;
            }
        }
    }
}
