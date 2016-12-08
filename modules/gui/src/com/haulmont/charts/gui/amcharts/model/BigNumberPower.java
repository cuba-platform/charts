/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsonEnum;

public enum BigNumberPower implements JsonEnum {
    KILO("1e+3"),
    MEGA("1e+6"),
    GIGA("1e+9"),
    TERA("1e+12"),
    PETA("1e+15"),
    EXA("1e+18"),
    ZETTA("1e+21"),
    YOTTA("1e+24");

    private String id;

    BigNumberPower(String id) {
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