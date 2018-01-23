/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

/**
 * See documentation for properties of AmSerialChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmSerialChart">http://docs.amcharts.com/3/javascriptcharts/AmSerialChart</a>
 */
public interface SerialChart extends SeriesBasedChart<SerialChart> {
    String NAME = "serialChart";

    Integer getBezierX();
    void setBezierX(Integer bezierX);

    Integer getBezierY();
    void setBezierY(Integer bezierY);
}