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
import com.haulmont.charts.gui.amcharts.model.charts.SlicedChartModel;

import java.util.function.Consumer;

/**
 * Base interface for {@link PieChart} and {@link FunnelChart}.
 * <br>
 * See documentation for properties of AmSlicedChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmSlicedChart">http://docs.amcharts.com/3/javascriptcharts/AmSlicedChart</a>
 */
public interface SlicedChart<T extends SlicedChart> extends Chart<T>, SlicedChartModel<T> {
    /**
     * Adds a listener for a slice. Called when user clicks on the slice.
     *
     * @param listener a listener to add
     */
    Subscription addSliceClickListener(Consumer<SliceClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeSliceClickListener(Consumer<SliceClickEvent> listener);

    /**
     * Adds a listener for a slice. Called when user clicks on the slice.
     *
     * @param listener a listener to add
     */
    Subscription addSliceRightClickListener(Consumer<SliceRightClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeSliceRightClickListener(Consumer<SliceRightClickEvent> listener);

    /**
     * Adds a listener for a slice. Called when the slice did pull-in.
     *
     * @param listener a listener to add
     */
    Subscription addSlicePullInListener(Consumer<SlicePullInEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeSlicePullInListener(Consumer<SlicePullInEvent> listener);

    /**
     * Adds a listener for a slice. Called when the slice did pull-out.
     *
     * @param listener a listener to add
     */
    Subscription addSlicePullOutListener(Consumer<SlicePullOutEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeSlicePullOutListener(Consumer<SlicePullOutEvent> listener);
}