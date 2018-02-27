/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.RadarChartModel;

/**
 * Radar / polar chart component.
 * <br>
 * See documentation for properties of AmRadarChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmRadarChart">http://docs.amcharts.com/3/javascriptcharts/AmRadarChart</a>
 */
public interface RadarChart extends CoordinateChart<RadarChart>, RadarChartModel<RadarChart> {
    String NAME = "radarChart";
}