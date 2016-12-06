/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.data;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Data provider for pivot table.
 * Contains {@link CollectionDatasource} with items which will be shown on pivot table.
 */
public class EntityPivotDataProvider implements PivotDataProvider {

    private static final long serialVersionUID = -3239225539132983723L;

    protected final CollectionDatasource datasource;

    public EntityPivotDataProvider(CollectionDatasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<PivotDataItem> getItems() {
        List<PivotDataItem> items = new ArrayList<>();

        for (Object entityItem : datasource.getItems()) {
            Entity entity = (Entity) entityItem;

            items.add(new EntityPivotDataItem(entity));
        }
        return items;
    }

    /**
     * Unsupported. Always throws an {@link UnsupportedOperationException}.
     * Use datasource for changing data items of EntityPivotDataProvider
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public void addItem(PivotDataItem item) {
        throw new UnsupportedOperationException("Use datasource for changing data items of EntityPivotDataProvider");
    }

    /**
     * Unsupported. Always throws an {@link UnsupportedOperationException}.
     * Use datasource for changing data items of EntityPivotDataProvider
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public void addItems(Collection<PivotDataItem> items) {
        throw new UnsupportedOperationException("Use datasource for changing data items of EntityPivotDataProvider");
    }

    /**
     * Unsupported. Always throws an {@link UnsupportedOperationException}.
     * Use datasource for changing data items of EntityPivotDataProvider
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public void updateItem(PivotDataItem item) {
        throw new UnsupportedOperationException("Use datasource for changing data items of EntityPivotDataProvider");
    }

    /**
     * Unsupported. Always throws an {@link UnsupportedOperationException}.
     * Use datasource for changing data items of EntityPivotDataProvider
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public void removeItem(PivotDataItem item) {
        throw new UnsupportedOperationException("Use datasource for changing data items of EntityPivotDataProvider");
    }

    /**
     * Unsupported. Always throws an {@link UnsupportedOperationException}.
     * Use datasource for changing data items of EntityPivotDataProvider
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public void removeAll() {
        throw new UnsupportedOperationException("Use datasource for changing data items of EntityPivotDataProvider");
    }

    /**
     * @return datasource instance
     */
    public CollectionDatasource getDatasource() {
        return datasource;
    }
}
