/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.web.toolkit.ui.charts;

public interface WPieChart
        extends
        WCategoryChart,
        WChart.ViewIn3D {

    boolean isIgnoreZeroValues();
    void setIgnoreZeroValues(boolean ignoreZeroValues);

    boolean isIgnoreNullValues();
    void setIgnoreNullValues(boolean ignoreNullValues);
}
