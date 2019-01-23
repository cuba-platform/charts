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