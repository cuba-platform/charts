/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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