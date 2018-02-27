/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.List;

public interface HasColors<T> {

    /**
     * @return List of colors
     */
    List<Color> getColors();

    /**
     * Sets the list of colors.
     * <p>
     * If you use charts based on {@link com.haulmont.charts.gui.components.charts.SlicedChart SlicedChart}
     * it specifies the colors of the slices, if the slice color is not set.
     * If there are more slices than colors in this array, the chart picks random color.
     * </p>
     *
     * <p>
     *  If you use charts based on {@link com.haulmont.charts.gui.components.charts.CoordinateChart CoordinateChart}
     *  it specifies the colors of the graphs if the lineColor of a graph is not set.
     *  If there are more graphs then colors in this array, the chart picks a random color.
     * </p>
     * @param colors - list of colors
     */
    T setColors(List<Color> colors);

    /**
     * Adds colors.
     *
     * @param colors - list of colors
     */
    T addColors(Color... colors);
}