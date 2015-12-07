/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author gorelov
 * @version $Id$
 */
public enum PeriodType implements ChartEnum {
    SECONDS("ss"),
    MINUTES("mm"),
    HOURS("hh"),
    DAYS("DD"),
    MONTHS("MM"),
    YEARS("YYYY"),
    YTD("YTD"),
    MAX("MAX");

    private String id;

    PeriodType(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
