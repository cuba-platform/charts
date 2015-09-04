/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * The default series type for the chart.
 *
 * @author artamonov
 * @version $Id$
 */
public enum ChartType implements ChartEnum {
    SERIAL("serial"),
    PIE("pie"),
    XY("xy"),
    RADAR("radar"),
    FUNNEL("funnel"),
    GAUGE("gauge"),
    GANTT("gantt");

    private String id;

    ChartType(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}