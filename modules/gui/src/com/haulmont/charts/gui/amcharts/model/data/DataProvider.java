/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Data provider for chart. Contains items which will be shown on chart.
 */
public interface DataProvider extends Serializable {

    /**
     * @return list of all items.
     */
    List<DataItem> getItems();

    /**
     * Adds an item to the data provider.
     *
     * @param item an item to be added
     */
    void addItem(DataItem item);

    /**
     * Adds a collection of data items to the data provider.
     *
     * @param items a collection of data items to be added
     */
    default void addItems(Collection<DataItem> items) {
        for (DataItem item : items) {
            addItem(item);
        }
    }

    /**
     * Update an item in the data provider if it is already there.
     *
     * @param item an item to be updated
     */
    void updateItem(DataItem item);

    /**
     * Removes an item from the data provider.
     *
     * @param item an item to be removed
     */
    void removeItem(DataItem item);

    /**
     * Removes all items from the data provider.
     */
    void removeAll();

    /**
     * Adds listener to the data provider events.
     *
     * @param listener listener to be added
     */
    void addChangeListener(DataChangeListener listener);

    /**
     * Removes listener to data provider events
     *
     * @param listener listener to be removed
     */
    void removeChangeListener(DataChangeListener listener);
}