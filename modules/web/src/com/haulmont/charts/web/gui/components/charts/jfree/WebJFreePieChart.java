/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.charts.web.gui.components.charts.jfree;

import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.charts.web.gui.components.charts.WebAbstractCategoryChart;
import com.haulmont.charts.web.toolkit.ui.charts.jfree.JFreePieChart;

public class WebJFreePieChart extends WebAbstractCategoryChart<JFreePieChart> implements PieChart {
    private static final long serialVersionUID = 2148678991758077072L;

    public WebJFreePieChart() {
        component = new JFreePieChart();
    }

    public boolean is3D() {
        return component.is3D();
    }

    public void set3D(boolean b) {
        component.set3D(b);
    }
}
