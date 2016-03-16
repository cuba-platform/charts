/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Data provider for chart.
 *
 */
public interface DataProvider extends Serializable {

    List<DataItem> getItems();

    void addItem(DataItem item);

    default void addItems(Collection<DataItem> items) {
        for (DataItem item : items) {
            addItem(item);
        }
    }

    void updateItem(DataItem item);

    void removeItem(DataItem item);

    void addChangeListener(DataChangeListener listener);

    void removeChangeListener(DataChangeListener listener);
}