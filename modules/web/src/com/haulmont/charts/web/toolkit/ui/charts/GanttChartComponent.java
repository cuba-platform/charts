/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public abstract class GanttChartComponent extends ChartComponent implements WGanttChart {

    protected GanttChartComponent() {
        chartWidth = -1;
        chartHeight = -1;

        setWidth("-1px");
        setHeight("-1px");
    }
}