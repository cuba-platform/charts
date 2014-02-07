/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public enum BigNumberPower implements ChartEnum {
    KILO("1e+3"),
    MEGA("1e+6"),
    GIGA("1e+9"),
    TERA("1e+12"),
    PETA("1e+15"),
    EXA("1e+18"),
    ZETTA("1e+21"),
    YOTTA("1e+24");

    private String id;

    private BigNumberPower(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}