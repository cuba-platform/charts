/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
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

    @Override
    public String toString() {
        return id;
    }
}