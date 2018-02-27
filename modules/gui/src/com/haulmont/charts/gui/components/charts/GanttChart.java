/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.GanttChartModel;

/**
 * Gantt chart component. It displays multiple bars on one series where value axis displays date/time and is horizontal.
 * <br>
 * See documentation for properties of AmGanttChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmGanttChart">http://docs.amcharts.com/3/javascriptcharts/AmGanttChart</a>
 */
public interface GanttChart extends SeriesBasedChart<GanttChart>, GanttChartModel<GanttChart> {
    String NAME = "ganttChart";
}