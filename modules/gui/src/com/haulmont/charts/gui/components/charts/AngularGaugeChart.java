/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.AngularGaugeChartModel;

/**
 * See documentation for properties of AmAngularGauge JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmAngularGauge">http://docs.amcharts.com/3/javascriptcharts/AmAngularGauge</a>
 */
public interface AngularGaugeChart extends Chart<AngularGaugeChart>, AngularGaugeChartModel<AngularGaugeChart> {
    String NAME = "gaugeChart";
}