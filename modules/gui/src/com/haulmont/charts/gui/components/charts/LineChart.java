/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.charts.gui.components.charts;

/** Line chart component */
public interface LineChart
        extends
        CategoryChart,
        Chart.HasAxisLabels,
        Chart.HasValueAxisType,
        Chart.HasOrientation {

    String NAME = "lineChart";
}