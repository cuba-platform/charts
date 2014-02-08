/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author artamonov
 * @version $Id$
 */
public class ListDataProvider implements DataProvider {

    private static final long serialVersionUID = -8893186272622531844L;

    private List<DataItem> items = new ArrayList<>();

    public ListDataProvider() {
    }

    public ListDataProvider(DataItem... items) {
        if (items != null) {
            this.items.addAll(Arrays.asList(items));
        }
    }

    public ListDataProvider(List<DataItem> items) {
        this.items.addAll(items);
    }

    @Override
    public List<DataItem> getItems() {
        return items;
    }

    @Override
    public void addItem(DataItem item) {
        items.add(item);
    }

    @Override
    public void addItems(Collection<DataItem> items) {
        this.items.addAll(items);
    }

    @Override
    public boolean contains(DataItem item) {
        return items.contains(item);
    }

    @Override
    public void updateItem(DataItem item) {
    }

    @Override
    public void removeItem(DataItem item) {
        items.remove(item);
    }
}