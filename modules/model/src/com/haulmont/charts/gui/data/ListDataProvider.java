/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.data;

import java.util.*;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Data provider in which all items are stored in {@link List}.
 */
public class ListDataProvider implements DataProvider {

    private static final long serialVersionUID = -6810317342142985329L;

    protected final List<DataItem> items = new ArrayList<>();
    protected final List<DataChangeListener> changeListeners = new ArrayList<>();

    public ListDataProvider() {
    }

    public ListDataProvider(DataItem... items) {
        if (items != null) {
            this.items.addAll(Arrays.asList(items));
        }
    }

    public ListDataProvider(List<? extends DataItem> items) {
        checkNotNull(items);

        this.items.addAll(items);
    }

    @Override
    public List<DataItem> getItems() {
        return items;
    }

    @Override
    public DataItem getItem(Object id) {
        return items.stream()
                .filter(dataItem -> (dataItem instanceof DataItem.HasId)
                        && Objects.equals(id, ((DataItem.HasId) dataItem).getId()))
                .findFirst().orElse(null);
    }

    @Override
    public void addItem(DataItem item) {
        items.add(item);
        fireDataChanged(DataChangeOperation.ADD, Collections.singletonList(item));
    }

    @Override
    public void addItems(Collection<? extends DataItem> items) {
        this.items.addAll(items);
        fireDataChanged(DataChangeOperation.ADD, new ArrayList<>(items));
    }

    /**
     * Update an item in the data provider if it is already there.
     *
     * @param item an item to be updated
     * @throws IllegalArgumentException if no such element found
     */
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

    @Override
    public void removeAll() {
        items.clear();
        fireDataChanged(DataChangeOperation.REFRESH, Collections.emptyList());
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