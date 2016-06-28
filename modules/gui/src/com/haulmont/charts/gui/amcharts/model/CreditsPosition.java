/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import javax.annotation.Nullable;

public enum CreditsPosition implements ChartEnum {
    TOP_LEFT("top-left"),
    TOP_RIGHT("top-right"),
    BOTTOM_LEFT("bottom-left"),
    BOTTOM_RIGHT("bottom-right");

    private String id;

    CreditsPosition(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CreditsPosition fromId(String id) {
        for (CreditsPosition position : values()) {
            if (position.getId().equals(id)) {
                return position;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id;
    }
}
