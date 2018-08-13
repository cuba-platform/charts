/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import com.haulmont.charts.gui.model.JsonEnum;

import javax.annotation.Nullable;

/**
 * An enum with the orders in which row data is provided to the renderer.
 * <p>
 * Ordering by value orders by row total.
 */
public enum RowOrder implements JsonEnum {
    KEYS_ASCENDING("key_a_to_z"),
    VALUES_ASCENDING("value_a_to_z"),
    VALUES_DESCENDING("value_z_to_a");

    private String id;

    RowOrder(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static RowOrder fromId(String id) {
        for (RowOrder order : values()) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id;
    }
}