/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.web.ui;

import com.haulmont.charts.gui.amcharts.model.charts.PieChart;
import com.haulmont.charts.web.gui.components.charts.amcharts.WebChart;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;
import com.haulmont.cuba.gui.components.AbstractFrame;

import java.util.Map;

/**
 * @author degtyarjov
 */
public class JsonChartController extends AbstractFrame {
    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        String chartJson = (String) params.get("Chart");
        WebChart webChart = new WebChart();
        webChart.setHeight("100%");
        webChart.setWidth("100%");
        CubaAmchartsScene cubaAmchartsScene = (CubaAmchartsScene) webChart.getComponent();
        cubaAmchartsScene.drawChart(new PieChart());
        cubaAmchartsScene.setJson(chartJson);
        cubaAmchartsScene.drawChart();
        add(webChart);
    }
}