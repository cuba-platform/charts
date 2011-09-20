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

    public Orientation getOrientation() {
        return WebChartsHelper.convertChartOrientation(component.getOrientation());
    }

    public void setOrientation(Orientation orientation) {
        component.setOrientation(WebChartsHelper.convertChartOrientation(orientation));
    }

    public String getArgumentAxisLabel() {
        return component.getArgumentAxisLabel();
    }

    public void setArgumentAxisLabel(String label) {
        component.setArgumentAxisLabel(label);
    }

    public String getValueAxisLabel() {
        return component.getValueAxisLabel();
    }

    public void setValueAxisLabel(String label) {
        component.setValueAxisLabel(label);
    }

    public AxisType getValueAxisType() {
        return WebChartsHelper.convertChartAxisType(component.getValueAxisType());
    }

    public void setValueAxisType(AxisType axisType) {
        component.setValueAxisType(WebChartsHelper.convertChartAxisType(axisType));
    }
}