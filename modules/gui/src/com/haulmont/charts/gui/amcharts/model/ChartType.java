/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * The default series type for the chart.
 *
 */
public enum ChartType implements ChartEnum {
    SERIAL("serial"),
    PIE("pie"),
    XY("xy"),
    RADAR("radar"),
    FUNNEL("funnel"),
    GAUGE("gauge"),
    GANTT("gantt"),
    STOCK("stock");

    private String id;

    ChartType(String id) {
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