/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.bali.events.Subscription;
import com.haulmont.charts.gui.amcharts.model.charts.RectangularChartModel;

import java.util.function.Consumer;

/**
 * Base interface for {@link GanttChart}, {@link SerialChart} and {@link XYChart}.
 * <br>
 * See documentation for properties of AmRectangularChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmRectangularChart">http://docs.amcharts.com/3/javascriptcharts/AmRectangularChart</a>
 */
public interface RectangularChart<T extends RectangularChart> extends CoordinateChart<T>, RectangularChartModel<T> {
    /**
     * Adds a listener for cursor zoom. Called when value of the cursor zoom changed.
     *
     * @param listener a listener to add
     */
    Subscription addCursorZoomListener(Consumer<CursorZoomEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeCursorZoomListener(Consumer<CursorZoomEvent> listener);

    /**
     * Adds a listener for period selection by cursor. Called when value of the cursor period changed.
     *
     * @param listener a listener to add
     */
    Subscription addCursorPeriodSelectListener(Consumer<CursorPeriodSelectEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeCursorPeriodSelectListener(Consumer<CursorPeriodSelectEvent> listener);
}