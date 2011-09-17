/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
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
