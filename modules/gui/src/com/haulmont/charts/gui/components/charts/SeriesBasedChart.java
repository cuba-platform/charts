/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.SeriesBasedChartModel;

import java.util.Date;

/**
 * Base interface for {@link SerialChart} and {@link GanttChart}.
 */
public interface SeriesBasedChart<T extends SeriesBasedChart> extends RectangularChart<T>, SeriesBasedChartModel<T> {
    void addZoomListener(ZoomListener listener);
    void removeZoomListener(ZoomListener listener);

    /**
     * Zooms out, charts shows all available data.
     */
    void zoomOut();

    /**
     * Zooms the chart by the index of the category.
     *
     * @param start start index
     * @param end   end index
     */
    void zoomToIndexes(int start, int end);

    /**
     * Zooms the chart from one date to another.
     *
     * @param start start date
     * @param end   end date
     */
    void zoomToDates(Date start, Date end);
}