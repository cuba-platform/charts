/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsonEnum;

public enum SmallNumberPower implements JsonEnum {
    YOCTO("1e-24"),
    ZEPTO("1e-21"),
    ATTO("1e-18"),
    FEMTO("1e-15"),
    PICO("1e-12"),
    NANO("1e-9"),
    MICRO("1e-6"),
    MILLI("1e-3");

    private String id;

    SmallNumberPower(String id) {
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