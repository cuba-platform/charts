/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.charts.web.gui.components.charts.jfree;

import com.haulmont.charts.gui.components.charts.LineChart;
import com.haulmont.charts.web.gui.components.WebChartsHelper;
import com.haulmont.charts.web.gui.components.charts.WebAbstractCategoryChart;
import com.haulmont.charts.web.toolkit.ui.charts.jfree.JFreeLineChart;

public class WebJFreeLineChart extends WebAbstractCategoryChart<JFreeLineChart> implements LineChart {
    private static final long serialVersionUID = 6270988135198002719L;

    public WebJFreeLineChart() {
        component = new JFreeLineChart();
    }

    @Override
    public Orientation getOrientation() {
        return WebChartsHelper.convertChartOrientation(component.getOrientation());
    }

    @Override
    public void setOrientation(Orientation orientation) {
        component.setOrientation(WebChartsHelper.convertChartOrientation(orientation));
    }

    @Override
    public String getArgumentAxisLabel() {
        return component.getArgumentAxisLabel();
    }

    @Override
    public void setArgumentAxisLabel(String label) {
        component.setArgumentAxisLabel(label);
    }

    @Override
    public String getValueAxisLabel() {
        return component.getValueAxisLabel();
    }

    @Override
    public void setValueAxisLabel(String label) {
        component.setValueAxisLabel(label);
    }

    @Override
    public AxisType getValueAxisType() {
        return WebChartsHelper.convertChartAxisType(component.getValueAxisType());
    }

    @Override
    public void setValueAxisType(AxisType axisType) {
        component.setValueAxisType(WebChartsHelper.convertChartAxisType(axisType));
    }
}