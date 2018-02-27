/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

/**
 * Serial chart component. It can represent line, area, column, bar, step line, smoothed line, candlestick and OHLC
 * charts. The charts support multiple axes with simple or logarithmic scales, the data points can be displayed at
 * equal/irregular intervals or on timeline basis.
 * <br>
 * See documentation for properties of AmSerialChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmSerialChart">http://docs.amcharts.com/3/javascriptcharts/AmSerialChart</a>
 */
public interface SerialChart extends SeriesBasedChart<SerialChart> {
    String NAME = "serialChart";

    /**
     * @return horizontal tension of bezier
     */
    Integer getBezierX();

    /**
     * Sets horizontal tension of bezier (used by smoothed line). If not defined, chart adjust tension by itself,
     * taking in to account if chart is rotated or not. Allowed values 1 - infinity.
     *
     * @param bezierX horizontal tension of bezier
     */
    void setBezierX(Integer bezierX);

    /**
     * @return vertical tension of bezier
     */
    Integer getBezierY();

    /**
     * Sets vertical tension of bezier (used by smoothed line). If not defined, chart adjust tension by itself,
     * taking in to account if chart is rotated or not. Allowed values 1 - infinity.
     *
     * @param bezierY vertical tension of bezier
     */
    void setBezierY(Integer bezierY);
}