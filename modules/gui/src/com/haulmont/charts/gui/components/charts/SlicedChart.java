/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.SlicedChartModel;

/**
 * Base interface for {@link PieChart} and {@link FunnelChart}.
 * <br>
 * See documentation for properties of AmSlicedChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmSlicedChart">http://docs.amcharts.com/3/javascriptcharts/AmSlicedChart</a>
 */
public interface SlicedChart<T extends SlicedChart> extends Chart<T>, SlicedChartModel<T> {
    void addSliceClickListener(SliceClickListener listener);
    void removeSliceClickListener(SliceClickListener listener);

    void addSliceRightClickListener(SliceRightClickListener listener);
    void removeSliceRightClickListener(SliceRightClickListener listener);

    void addSlicePullInListener(SlicePullInListener listener);
    void removeSlicePullInListener(SlicePullInListener listener);

    void addSlicePullOutListener(SlicePullOutListener listener);
    void removeSlicePullOutListener(SlicePullOutListener listener);
}