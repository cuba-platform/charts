/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

/**
 * Chart data item, which contains an instance of any class.
 *
 * @deprecated Use base {@link com.haulmont.charts.gui.data.SimpleDataItem}
 */
@Deprecated
public class SimpleDataItem extends com.haulmont.charts.gui.data.SimpleDataItem {

    private static final long serialVersionUID = 7128101061882264424L;

    public SimpleDataItem(Object item) {
        super(item);
    }
}