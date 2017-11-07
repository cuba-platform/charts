/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.haulmont.charts.gui.data.DataItem;

import java.util.List;

/**
 * Describes data item change event.
 *
 * @deprecated use {@link com.haulmont.charts.gui.data.DataItemsChangeEvent} instead
 */
@Deprecated
public class DataItemsChangeEvent extends com.haulmont.charts.gui.data.DataItemsChangeEvent {

    private static final long serialVersionUID = -9206509789273675564L;

    public DataItemsChangeEvent(com.haulmont.charts.gui.data.DataChangeOperation operation, List<DataItem> items) {
        super(operation, items);
    }
}
