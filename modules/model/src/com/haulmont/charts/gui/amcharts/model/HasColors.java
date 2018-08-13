/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.amcharts.model.charts.CoordinateChart;
import com.haulmont.charts.gui.amcharts.model.charts.SlicedChart;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartModel;

import java.util.List;

public interface HasColors<T> {

    /**
     * @return List of colors
     */
    List<Color> getColors();

    /**
     * Sets the list of colors.
     * <p>
     * If you use charts based on {@link SlicedChart} it specifies the colors of the slices, if the slice color is
     * not set. If there are more slices than colors in this array, the chart picks random color.
     *
     * <p>
     * If you use charts based on {@link CoordinateChart} or {@link StockChartModel} it specifies the colors of the graphs
     * if the lineColor of a graph is not set. If there are more graphs then colors in this array, the chart picks a
     * random color. If not set the default value is
     * <pre>{@code
     *  ["#FF6600", "#FCD202", "#B0DE09",
     *   "#0D8ECF", "#2A0CD0", "#CD0D74",
     *   "#CC0000", "#00CC00", "#0000CC",
     *   "#DDDDDD", "#999999", "#333333",
     *   "#990000"]
     * }</pre>
     *
     * <p>
     * If you use chart based on {@link SlicedChart} (PieChart, FunnelChart). Specifies the colors of the slices, if
     * the slice color is not set. If there are more slices than colors in this array, the chart picks random color.
     * If not set default value is
     * <pre>{@code
     *  ["#FF0F00", "#FF6600", "#FF9E01", "#FCD202",
     *   "#F8FF01", "#B0DE09", "#04D215", "#0D8ECF",
     *   "#0D52D1", "#2A0CD0", "#8A0CCF", "#CD0D74",
     *   "#754DEB", "#DDDDDD", "#999999", "#333333",
     *   "#000000", "#57032A", "#CA9726", "#990000",
     *  "#4B0C25"]
     * }</pre>
     *
     * @param colors list of colors
     */
    T setColors(List<Color> colors);

    /**
     * Adds colors.
     *
     * @param colors list of colors
     */
    T addColors(Color... colors);
}