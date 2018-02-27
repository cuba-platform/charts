/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.XYChartModel;

/**
 * XY chart component. It can represent XY, bubble and scatter charts. Supports multiple axes with simple or
 * logarithmic scales.
 * <br>
 * See documentation for properties of AmXYChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmXYChart">http://docs.amcharts.com/3/javascriptcharts/AmXYChart</a>
 */
public interface XYChart extends RectangularChart<XYChart>, XYChartModel<XYChart> {
    String NAME = "xyChart";
}