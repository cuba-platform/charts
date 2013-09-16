/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.web.gui.components.charts.jfree;

import com.haulmont.charts.gui.components.charts.BarChart;
import com.haulmont.charts.web.gui.components.WebChartsHelper;
import com.haulmont.charts.web.gui.components.charts.WebAbstractCategoryChart;
import com.haulmont.charts.web.toolkit.ui.charts.jfree.JFreeBarChart;

public class WebJFreeBarChart extends WebAbstractCategoryChart<JFreeBarChart> implements BarChart {

    public WebJFreeBarChart() {
        component = new JFreeBarChart();
    }

    @Override
    public boolean is3D() {
        return component.is3D();
    }

    @Override
    public void set3D(boolean b) {
        component.set3D(b);
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