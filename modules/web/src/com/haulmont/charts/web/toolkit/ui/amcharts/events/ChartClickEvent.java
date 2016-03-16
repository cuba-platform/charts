/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;
import com.vaadin.ui.Component;

/**
 */
public class ChartClickEvent extends Component.Event {

    private final int x;
    private final int y;
    private final int absoluteX;
    private final int absoluteY;
    private final double xAxis;
    private final double yAxis;

    public ChartClickEvent(CubaAmchartsScene source, int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis) {
        super(source);
        this.x = x;
        this.y = y;
        this.absoluteX = absoluteX;
        this.absoluteY = absoluteY;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public int getAbsoluteX() {
        return absoluteX;
    }

    public int getAbsoluteY() {
        return absoluteY;
    }

    public int getX() {
        return x;
    }

    public double getXAxis() {
        return xAxis;
    }

    public int getY() {
        return y;
    }

    public double getYAxis() {
        return yAxis;
    }
}