/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public enum SmallNumberPower implements ChartEnum {
    MILLI("1e-3"),
    MICRO("1e-6"),
    NANO("1e-9"),
    PICO("1e-12"),
    FEMTO("1e-15"),
    ATTO("1e-18"),
    ZEPTO("1e-21"),
    YOCTO("1e-24");

    private String id;

    SmallNumberPower(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}