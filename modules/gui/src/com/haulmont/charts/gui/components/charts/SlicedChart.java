/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
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