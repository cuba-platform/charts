/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.PieChartModel;

/**
 * See documentation for properties of AmPieChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmPieChart">http://docs.amcharts.com/3/javascriptcharts/AmPieChart</a>
 */
public interface PieChart extends SlicedChart<PieChart>, PieChartModel<PieChart> {
    String NAME = "pieChart";
}