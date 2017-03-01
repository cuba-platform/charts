/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.components.charts.SerialChart;

public class WebSerialChart extends WebSeriesBasedChart<SerialChart, com.haulmont.charts.gui.amcharts.model.charts.SerialChart>
        implements SerialChart {

    @Override
    protected com.haulmont.charts.gui.amcharts.model.charts.SerialChart createChartConfiguration() {
        return new com.haulmont.charts.gui.amcharts.model.charts.SerialChart();
    }
}