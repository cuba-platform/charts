/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.CoordinateChartModel;

/**
 * Base interface for {@link GanttChart}, {@link SerialChart}, {@link RadarChart} and {@link XYChart}.
 * <br>
 * See documentation for properties of AmCoordinateChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmCoordinateChart">http://docs.amcharts.com/3/javascriptcharts/AmCoordinateChart</a>
 */
public interface CoordinateChart<T extends CoordinateChart> extends Chart<T>, CoordinateChartModel<T> {
    void addGraphClickListener(GraphClickListener listener);
    void removeGraphClickListener(GraphClickListener listener);

    void addGraphItemClickListener(GraphItemClickListener listener);
    void removeGraphItemClickListener(GraphItemClickListener listener);

    void addGraphItemRightClickListener(GraphItemRightClickListener clickListener);
    void removeGraphItemRightClickListener(GraphItemRightClickListener clickListener);

    void addAxisZoomListener(AxisZoomListener listener);
    void removeAxisZoomListener(AxisZoomListener listener);

    /**
     * Zooms out value axes, value axes shows all available data.
     */
    void zoomOutValueAxes();

    /**
     * Zooms out value axis, value axis shows all available data.
     *
     * @param id id of value axis
     */
    void zoomOutValueAxis(String id);

    /**
     * Zooms out value axis, value axis shows all available data.
     *
     * @param index index of value axis
     */
    void zoomOutValueAxis(int index);

    /**
     * Zooms-in an axis to the provided values.
     *
     * @param id         id of value axis
     * @param startValue start value
     * @param endValue   end value
     */
    void zoomValueAxisToValues(String id, Object startValue, Object endValue);

    /**
     * Zooms-in an axis to the provided values.
     *
     * @param index      index of value axis
     * @param startValue start value
     * @param endValue   end value
     */
    void zoomValueAxisToValues(int index, Object startValue, Object endValue);
}