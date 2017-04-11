/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.data;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.impl.WeakCollectionChangeListener;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Data provider which contains {@link CollectionDatasource} with items.
 */
public class EntityDataProvider implements DataProvider {

    private static final long serialVersionUID = -4215045539824729753L;

    protected final CollectionDatasource datasource;
    protected final CollectionDatasource.CollectionChangeListener collectionChangeListener;
    protected final List<DataChangeListener> changeListeners = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public EntityDataProvider(CollectionDatasource datasource) {
        this.datasource = datasource;

        collectionChangeListener = e -> {
            DataChangeOperation operation = null;
            switch (e.getOperation()) {
                case ADD:
                    operation = DataChangeOperation.ADD;
                    break;
                case REMOVE:
                    operation = DataChangeOperation.REMOVE;
                    break;
                case UPDATE:
                    operation = DataChangeOperation.UPDATE;
                    break;
                case REFRESH:
                case CLEAR:
                    operation = DataChangeOperation.REFRESH;
                    break;
            }
            fireDataChanged(operation, e.getItems());
        };
        this.datasource.addCollectionChangeListener(new WeakCollectionChangeListener(datasource, collectionChangeListener));
    }

    protected void fireDataChanged(DataChangeOperation operation, List items) {
        List<DataItem> dataItems;
        if (CollectionUtils.isNotEmpty(items)) {
            dataItems = new ArrayList<>(items.size());
            for (Object entityItem : items) {
                Entity entity = (Entity) entityItem;
                dataItems.add(new EntityDataItem(entity));
            }
        } else {
            dataItems = Collections.emptyList();
        }

        DataItemsChangeEvent event = new DataItemsChangeEvent(operation, dataItems);
        for (DataChangeListener listener : new ArrayList<>(this.changeListeners)) {
            listener.dataItemsChanged(event);
        }
    }

    @Override
    public List<DataItem> getItems() {
        List<DataItem> items = new ArrayList<>();

        for (Object entityItem : datasource.getItems()) {
            Entity entity = (Entity) entityItem;

            items.add(new EntityDataItem(entity));
        }
        return items;
    }

    @Override
    public DataItem getItem(Object id) {
        @SuppressWarnings("unchecked")
        Entity item = datasource.getItem(id);
        if (item == null) {
            return null;
        }
        return new EntityDataItem(item);
    }

    /**
     * Unsupported. Always throws an {@link UnsupportedOperationException}.
     * Use datasource for changing data items of EntityDataProvider
     *
     * @throws UnsupportedOperationException use datasource for changing data items of EntityDataProvider
     */
    @Override
    public void addItem(DataItem item) {
        throw new UnsupportedOperationException("Use datasource for changing data items of EntityDataProvider");
    }

    /**
     * Unsupported. Always throws an {@link UnsupportedOperationException}.
     * Use datasource for changing data items of EntityDataProvider
     *
     * @throws UnsupportedOperationException use datasource for changing data items of EntityDataProvider
     */
    @Override
    public void addItems(Collection<DataItem> items) {
        throw new UnsupportedOperationException("Use datasource for changing data items of EntityDataProvider");
    }

    /**
     * Unsupported. Always throws an {@link UnsupportedOperationException}.
     * Use datasource for changing data items of EntityDataProvider
     *
     * @throws UnsupportedOperationException use datasource for changing data items of EntityDataProvider
     */
    @Override
    public void updateItem(DataItem item) {
        throw new UnsupportedOperationException("Use datasource for changing data items of EntityDataProvider");
    }

    /**
     * Unsupported. Always throws an {@link UnsupportedOperationException}.
     * Use datasource for changing data items of EntityDataProvider
     *
     * @throws UnsupportedOperationException use datasource for changing data items of EntityDataProvider
     */
    @Override
    public void removeItem(DataItem item) {
        throw new UnsupportedOperationException("Use datasource for changing data items of EntityDataProvider");
    }

    @Override
    public void removeAll() {
        throw new UnsupportedOperationException("Use datasource for changing data items of EntityDataProvider");
    }

    /**
     * @return datasource instance
     */
    public CollectionDatasource getDatasource() {
        return datasource;
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