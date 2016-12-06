/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Data provider for pivot table.
 * Contains items which will be shown on pivot table. All items are stored in {@link List}.
 */
public class ListPivotDataProvider implements PivotDataProvider {

    private static final long serialVersionUID = 1953169417966012886L;

    protected final List<PivotDataItem> items = new ArrayList<>();

    public ListPivotDataProvider() {
    }

    public ListPivotDataProvider(PivotDataItem... items) {
        if (items != null) {
            this.items.addAll(Arrays.asList(items));
        }
    }

    public ListPivotDataProvider(List<PivotDataItem> items) {
        this.items.addAll(items);
    }

    @Override
    public List<PivotDataItem> getItems() {
        return items;
    }

    @Override
    public void addItem(PivotDataItem item) {
        items.add(item);
    }

    /**
     * Update an item in the data provider if it is already there.
     *
     * @param item an item to be updated
     * @throws IllegalArgumentException if no such element found
     */
    @Override
    public void updateItem(PivotDataItem item) {
        int i = items.indexOf(item);
        if (i >= 0) {
            items.set(i, item);
        } else {
            throw new IllegalArgumentException("No such element");
        }
    }

    @Override
    public void removeItem(PivotDataItem item) {
        items.remove(item);
    }

    @Override
    public void removeAll() {
        items.clear();
    }
}
