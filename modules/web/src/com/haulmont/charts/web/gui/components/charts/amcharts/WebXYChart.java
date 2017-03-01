/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.gson.ChartJsonSerializationContext;
import com.haulmont.charts.gui.components.charts.XYChart;

public class WebXYChart extends WebRectangularChart<XYChart, com.haulmont.charts.gui.amcharts.model.charts.XYChart>
        implements XYChart {

    @Override
    protected com.haulmont.charts.gui.amcharts.model.charts.XYChart createChartConfiguration() {
        return new com.haulmont.charts.gui.amcharts.model.charts.XYChart();
    }

    @Override
    protected void setupDefaults(com.haulmont.charts.gui.amcharts.model.charts.XYChart chart) {
        super.setupDefaults(chart);

        setupXYChartDefaults(chart);
    }

    protected void setupXYChartDefaults(com.haulmont.charts.gui.amcharts.model.charts.XYChart chart) {
        chart.setDataDateFormat(ChartJsonSerializationContext.DEFAULT_JS_DATE_FORMAT);
    }

    @Override
    public Boolean getHideXScrollbar() {
        return getModel().getHideXScrollbar();
    }

    @Override
    public XYChart setHideXScrollbar(Boolean hideXScrollbar) {
        getModel().setHideXScrollbar(hideXScrollbar);
        return this;
    }

    @Override
    public Boolean getHideYScrollbar() {
        return getModel().getHideYScrollbar();
    }

    @Override
    public XYChart setHideYScrollbar(Boolean hideYScrollbar) {
        getModel().setHideYScrollbar(hideYScrollbar);
        return this;
    }

    @Override
    public String getDataDateFormat() {
        return getModel().getDataDateFormat();
    }

    @Override
    public XYChart setDataDateFormat(String dataDateFormat) {
        getModel().setDataDateFormat(dataDateFormat);
        return this;
    }

    @Override
    public Integer getMaxValue() {
        return getModel().getMaxValue();
    }

    @Override
    public XYChart setMaxValue(Integer maxValue) {
        getModel().setMaxValue(maxValue);
        return this;
    }

    @Override
    public Integer getMinValue() {
        return getModel().getMinValue();
    }

    @Override
    public XYChart setMinValue(Integer minValue) {
        getModel().setMinValue(minValue);
        return this;
    }
}