/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author artamonov
 * @version $Id$
 */
public interface DataProvider extends Serializable {

    List<DataItem> getItems();

    void addItem(DataItem item);

    void addItems(Collection<DataItem> items);

    boolean contains(DataItem item);

    void updateItem(DataItem item);

    void removeItem(DataItem item);
}