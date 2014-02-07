/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public enum DatePeriod implements ChartEnum {
    MILLISECONDS("fff"),
    SECONDS("ss"),
    MINUTES("minutes"),
    HOURS("hours"),
    DAYS("days"),
    MONTHS("months"),
    WEEKS("weeks"),
    YEARS("years");

    private String id;

    private DatePeriod(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}