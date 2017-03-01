/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */
package com.haulmont.charts.web.ui;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.components.charts.CustomChart;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractFrame;

import javax.inject.Inject;
import java.util.Map;

public class JsonChartController extends AbstractFrame {

    @WindowParam(required = true)
    protected String chartJson;

    @Inject
    protected CustomChart reportJsonChart;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        reportJsonChart.setConfiguration(new BasicChart());
        reportJsonChart.setNativeJson(chartJson);
    }

    /**
     * Used for default initialization in
     * WebChart.CubaAmchartsSceneExt#setupDefaults(AbstractChart)
     */
    protected static class BasicChart extends AbstractChart<BasicChart> {
    }
}