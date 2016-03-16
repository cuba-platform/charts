/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 */
public class BigNumberPrefix extends AbstractChartObject {

    private static final long serialVersionUID = -9041838899608052695L;

    private BigNumberPower number;

    private String prefix;

    public BigNumberPrefix() {
    }

    public BigNumberPrefix(BigNumberPower number, String prefix) {
        this.number = number;
        this.prefix = prefix;
    }

    public BigNumberPower getNumber() {
        return number;
    }

    public BigNumberPrefix setNumber(BigNumberPower number) {
        this.number = number;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public BigNumberPrefix setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }
}