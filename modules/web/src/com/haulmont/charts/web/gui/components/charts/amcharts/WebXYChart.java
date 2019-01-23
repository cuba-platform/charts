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

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.web.widgets.amcharts.serialization.ChartJsonSerializationContext;
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