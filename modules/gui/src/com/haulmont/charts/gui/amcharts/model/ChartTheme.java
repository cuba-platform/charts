/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

public enum ChartTheme implements ChartEnum {
    NONE("none"),
    BLACK("black"),
    CHALK("chalk"),
    DARK("dark"),
    LIGHT("light"),
    PATTERNS("patterns");

    private String id;

    ChartTheme(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}