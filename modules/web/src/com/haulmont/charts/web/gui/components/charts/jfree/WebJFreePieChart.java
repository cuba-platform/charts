/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.web.gui.components.charts.jfree;

import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.charts.web.gui.components.charts.WebAbstractCategoryChart;
import com.haulmont.charts.web.toolkit.ui.charts.jfree.JFreePieChart;

public class WebJFreePieChart extends WebAbstractCategoryChart<JFreePieChart> implements PieChart {

    public WebJFreePieChart() {
        component = new JFreePieChart();
    }

    @Override
    public boolean is3D() {
        return component.is3D();
    }

    @Override
    public void set3D(boolean b) {
        component.set3D(b);
    }
}