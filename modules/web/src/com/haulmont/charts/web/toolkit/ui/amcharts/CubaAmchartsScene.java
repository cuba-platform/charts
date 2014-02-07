/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts;

import com.haulmont.charts.gui.amcharts.model.charts.*;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.CubaAmchartsSceneState;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractComponent;
import org.apache.commons.lang.StringUtils;

/**
 * @author artamonov
 * @version $Id$
 */
@JavaScript({"resources/amcharts/amcharts-all.min.js",
        "resources/amcharts/themes.min.js",
        "resources/amcharts/exporting.min.js"})
public class CubaAmchartsScene extends AbstractComponent {

    private boolean dirty = false;

    private AbstractChart chart;

    @Override
    protected CubaAmchartsSceneState getState() {
        return (CubaAmchartsSceneState) super.getState();
    }

    @Override
    protected CubaAmchartsSceneState getState(boolean markAsDirty) {
        return (CubaAmchartsSceneState) super.getState(markAsDirty);
    }

    public void setJson(String json) {
        if (!StringUtils.equals(getJson(), json)) {
            getState().json = json;
        }
    }

    public String getJson() {
        return getState(false).json;
    }

    public void drawChart() {
        forceStateChange();
    }

    public void drawChart(AbstractChart chart) {
        this.chart = chart;
        forceStateChange();
    }

    public AngularGaugeChart gaugeChart() {
        AngularGaugeChart gaugeChart = new AngularGaugeChart();
        drawChart(gaugeChart);
        return gaugeChart;
    }

    public FunnelChart funnelChart() {
        FunnelChart funnelChart = new FunnelChart();
        drawChart(funnelChart);
        return funnelChart;
    }

    public PieChart pieChart() {
        PieChart pieChart = new PieChart();
        drawChart(pieChart);
        return pieChart;
    }

    public RadarChart radarChart() {
        RadarChart radarChart = new RadarChart();
        drawChart(radarChart);
        return radarChart;
    }

    public SerialChart serialChart() {
        SerialChart serialChart = new SerialChart();
        drawChart(serialChart);
        return serialChart;
    }

    public XYChart xyChart() {
        XYChart xyChart = new XYChart();
        drawChart(xyChart);
        return xyChart;
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);
        if (initial || dirty) {
            if (chart != null) {
                getState().configuration = chart.toString();
            }
            dirty = false;
        }
    }

    private void forceStateChange() {
        getState().version++;
    }
}