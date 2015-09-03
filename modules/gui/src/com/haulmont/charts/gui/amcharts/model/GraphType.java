/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public enum GraphType implements ChartEnum {
    LINE("line"),
    COLUMN("column"),
    STEP("step"),
    SMOOTHED_LINE("smoothedLine"),
    CANDLESTICK("candlestick"),
    OHLC("ohlc");

    private String id;

    GraphType(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}