/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Data provider for chart.
 *
 * @author artamonov
 * @version $Id$
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

    void addChangeListener(ConfigurationChangeListener listener);

    void removeChangeListener(ConfigurationChangeListener listener);
}