/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;

import java.util.*;

/**
 * @author artamonov
 * @version $Id$
 */
public class ListDataProvider implements DataProvider {

    private static final long serialVersionUID = -8893186272622531844L;

    protected final ArrayList<DataChangeListener> changeListeners = new ArrayList<>();
    protected AbstractChart chart;
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
        fireDataChanged(DataChangeOperation.ADD, Collections.singletonList(item));
    }

    @Override
    public void addItems(Collection<DataItem> items) {
        this.items.addAll(items);
        fireDataChanged(DataChangeOperation.ADD, new ArrayList<>(items));
    }

    @Override
    public void updateItem(DataItem item) {
        int i = items.indexOf(item);
        if (i >= 0) {
            items.set(i, item);
            fireDataChanged(DataChangeOperation.UPDATE, Collections.singletonList(item));
        } else {
            throw new IllegalArgumentException("No such element");
        }
    }

    @Override
    public void removeItem(DataItem item) {
        items.remove(item);
        fireDataChanged(DataChangeOperation.REMOVE, Collections.singletonList(item));
    }

    protected void fireDataChanged(DataChangeOperation operation, List<DataItem> items) {
        DataItemsChangeEvent event = new DataItemsChangeEvent(operation, items);
        List<DataChangeListener> changeListeners = new ArrayList<>(this.changeListeners);
        for (DataChangeListener listener : changeListeners) {
            listener.dataItemsChanged(event);
        }
    }

    @Override
    public void addChangeListener(DataChangeListener listener) {
        if (!changeListeners.contains(listener)) {
            changeListeners.add(listener);
        }
    }

    @Override
    public void removeChangeListener(DataChangeListener listener) {
        changeListeners.remove(listener);
    }
}