/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.gson;

import com.haulmont.charts.gui.data.DataItem;

import java.util.ArrayList;
import java.util.List;

public class ChartIncrementalChanges {
    protected List<DataItem> addedItems;
    protected List<DataItem> removedItems;
    protected List<DataItem> updatedItems;

    public List<DataItem> getAddedItems() {
        return addedItems;
    }

    public void setAddedItems(List<DataItem> addedItems) {
        this.addedItems = addedItems;
    }

    public List<DataItem> getRemovedItems() {
        return removedItems;
    }

    public void setRemovedItems(List<DataItem> removedItems) {
        this.removedItems = removedItems;
    }

    public List<DataItem> getUpdatedItems() {
        return updatedItems;
    }

    public void setUpdatedItems(List<DataItem> updatedItems) {
        this.updatedItems = updatedItems;
    }

    public void registerAddedItem(List<DataItem> items) {
        if (addedItems == null) {
            addedItems = new ArrayList<>();
        }

        addedItems.addAll(items);
    }

    public void registerRemovedItems(List<DataItem> items) {
        if (removedItems == null) {
            removedItems = new ArrayList<>();
        }

        removedItems.addAll(items);
    }

    public void registerUpdatedItems(List<DataItem> items) {
        if (updatedItems == null) {
            updatedItems = new ArrayList<>();
        }

        updatedItems.addAll(items);
    }

    public boolean isEmpty() {
        return updatedItems == null && addedItems == null && removedItems == null;
    }
}