/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Data provider for PivotTable. Contains items which will be shown on PivotTable.
 */
public interface PivotDataProvider extends Serializable {

    /**
     * @return list of all items.
     */
    List<PivotDataItem> getItems();

    /**
     * Adds an item to the data provider.
     *
     * @param item an item to be added
     */
    void addItem(PivotDataItem item);

    /**
     * Adds a collection of data items to the data provider.
     *
     * @param items a collection of data items to be added
     */
    default void addItems(Collection<PivotDataItem> items) {
        items.forEach(this::addItem);
    }

    /**
     * Update an item in the data provider if it is already there.
     *
     * @param item an item to be updated
     */
    void updateItem(PivotDataItem item);

    /**
     * Removes an item from the data provider.
     *
     * @param item an item to be removed
     */
    void removeItem(PivotDataItem item);

    /**
     * Removes all items from the data provider.
     */
    void removeAll();
}
