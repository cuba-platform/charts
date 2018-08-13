/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;

public class ChartClickEvent extends AbstractClickEvent {

    private static final long serialVersionUID = 1697513203813447451L;

    private final double xAxis;
    private final double yAxis;

    public ChartClickEvent(CubaAmchartsScene scene, int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis) {
        super(scene, x, y, absoluteX, absoluteY);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public double getXAxis() {
        return xAxis;
    }

    public double getYAxis() {
        return yAxis;
    }
}