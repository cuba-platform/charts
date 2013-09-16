/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.gui.components.charts;

/** Bar chart component */
public interface BarChart
        extends
        CategoryChart,
        Chart.HasAxisLabels,
        Chart.HasValueAxisType,
        Chart.ViewIn3D,
        Chart.HasOrientation {

    String NAME = "barChart";
}
