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
}