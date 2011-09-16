/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.charts.web.toolkit.ui.charts;

public interface PieChart
        extends
        CategoryChart,
        Chart.ViewIn3D {

    boolean isIgnoreZeroValues();
    void setIgnoreZeroValues(boolean ignoreZeroValues);

    boolean isIgnoreNullValues();
    void setIgnoreNullValues(boolean ignoreNullValues);
}
