/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

public class SmallNumberPrefix extends AbstractChartObject {

    private static final long serialVersionUID = 2147380689710093636L;

    private SmallNumberPower number;

    private String prefix;

    public SmallNumberPrefix() {
    }

    public SmallNumberPrefix(SmallNumberPower number, String prefix) {
        this.number = number;
        this.prefix = prefix;
    }

    public SmallNumberPower getNumber() {
        return number;
    }

    public SmallNumberPrefix setNumber(SmallNumberPower number) {
        this.number = number;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public SmallNumberPrefix setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }
}