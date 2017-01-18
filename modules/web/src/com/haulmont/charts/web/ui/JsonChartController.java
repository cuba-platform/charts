/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */
package com.haulmont.charts.web.ui;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractFrame;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;

import javax.inject.Inject;
import java.util.Map;

public class JsonChartController extends AbstractFrame {

    @WindowParam(required = true)
    protected String chartJson;

    @Inject
    protected ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        Chart chart = (Chart) componentsFactory.createComponent(Chart.NAME);
        chart.setSizeFull();

        CubaAmchartsScene cubaAmchartsScene = (CubaAmchartsScene) WebComponentsHelper.unwrap(chart);
        cubaAmchartsScene.drawChart(new CustomChart());
        cubaAmchartsScene.setJson(chartJson);

        add(chart);
    }

    /**
     * Used for default initialization in
     * {@link com.haulmont.charts.web.gui.components.charts.amcharts.WebChart.CubaAmchartsSceneExt#setupDefaults(AbstractChart)}}
     */
    protected static class CustomChart extends AbstractChart {
    }
}