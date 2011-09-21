/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.gui.components.charts.jfree;

import com.haulmont.charts.gui.components.charts.XYLineChart;
import com.haulmont.charts.web.gui.components.WebChartsHelper;
import com.haulmont.charts.web.gui.components.charts.WebAbstractXYChart;
import com.haulmont.charts.web.toolkit.ui.charts.jfree.JFreeXYLineChart;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public class WebJFreeXYLineChart extends WebAbstractXYChart<JFreeXYLineChart> implements XYLineChart {
    private static final long serialVersionUID = -3460128438079322004L;

    public WebJFreeXYLineChart() {
        component = new JFreeXYLineChart();
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
    public boolean getHasLegend() {
        return component.getHasLegend();
    }

    @Override
    public void setHasLegend(boolean hasLegend) {
        component.setHasLegend(hasLegend);
    }
}