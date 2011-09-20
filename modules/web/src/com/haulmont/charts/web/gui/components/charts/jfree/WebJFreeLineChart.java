/*
 * Copyright (c) 2008 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.

 * Author: Nikolay Gorodnov
 * Created: 07.09.2010 17:08:59
 *
 * $Id$
 */
package com.haulmont.cuba.web.gui.components.charts.jfree;

import com.haulmont.cuba.gui.components.charts.LineChart;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.haulmont.cuba.web.gui.components.charts.WebAbstractCategoryChart;
import com.haulmont.cuba.web.gui.components.charts.WebAbstractChart;
import com.haulmont.cuba.web.toolkit.ui.charts.jfree.JFreeLineChart;

public class WebJFreeLineChart extends WebAbstractCategoryChart<JFreeLineChart> implements LineChart {
    private static final long serialVersionUID = 6270988135198002719L;

    public WebJFreeLineChart() {
        component = new JFreeLineChart();
    }

    public Orientation getOrientation() {
        return WebComponentsHelper.convertChartOrientation(component.getOrientation());
    }

    public void setOrientation(Orientation orientation) {
        component.setOrientation(WebComponentsHelper.convertChartOrientation(orientation));
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
        return WebComponentsHelper.convertChartAxisType(component.getValueAxisType());
    }

    public void setValueAxisType(AxisType axisType) {
        component.setValueAxisType(WebComponentsHelper.convertChartAxisType(axisType));
    }
}
