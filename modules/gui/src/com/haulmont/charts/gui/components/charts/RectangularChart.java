/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.RectangularChartModel;

/**
 * Base interface for {@link GanttChart}, {@link SerialChart} and {@link XYChart}.
 * <br>
 * See documentation for properties of AmRectangularChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmRectangularChart">http://docs.amcharts.com/3/javascriptcharts/AmRectangularChart</a>
 */
public interface RectangularChart<T extends RectangularChart> extends CoordinateChart<T>, RectangularChartModel<T> {
    void addCursorZoomListener(CursorZoomListener listener);
    void removeCursorZoomListener(CursorZoomListener listener);

    void addCursorPeriodSelectListener(CursorPeriodSelectListener listener);
    void removeCursorPeriodSelectListener(CursorPeriodSelectListener listener);
}