/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.data;

import java.io.Serializable;
import java.util.List;

/**
 * Describes data item change event.
 */
public class DataItemsChangeEvent implements Serializable {

    private static final long serialVersionUID = 3222710756791710232L;

    private final DataChangeOperation operation;
    private final List<DataItem> items;

    public DataItemsChangeEvent(DataChangeOperation operation, List<DataItem> items) {
        this.operation = operation;
        this.items = items;
    }

    /**
     * @return operation which caused the data provider change
     */
    public DataChangeOperation getOperation() {
        return operation;
    }

    /**
     * @return items which used in operation
     */
    public List<DataItem> getItems() {
        return items;
    }
}
