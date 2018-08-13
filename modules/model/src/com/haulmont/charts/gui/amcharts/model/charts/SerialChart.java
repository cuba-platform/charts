/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;

/**
 * See documentation for properties of AmSerialChart JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmSerialChart">http://docs.amcharts.com/3/javascriptcharts/AmSerialChart</a>
 */
public class SerialChart extends AbstractSerialChart<SerialChart> {

    private static final long serialVersionUID = 4640758803235179022L;

    private Integer bezierX;

    private Integer bezierY;

    public SerialChart() {
        super(ChartType.SERIAL);
    }

    public Integer getBezierX() {
        return bezierX;
    }

    public SerialChart setBezierX(Integer bezierX) {
        this.bezierX = bezierX;
        return this;
    }

    public Integer getBezierY() {
        return bezierY;
    }

    public SerialChart setBezierY(Integer bezierY) {
        this.bezierY = bezierY;
        return this;
    }
}