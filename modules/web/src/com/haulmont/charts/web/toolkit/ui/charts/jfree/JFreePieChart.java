/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.charts.web.toolkit.ui.charts.jfree;

import com.haulmont.charts.web.toolkit.ui.charts.WPieChart;

public class JFreePieChart extends JFreeCategoryChart implements WPieChart {
    private static final long serialVersionUID = 1881367032236295730L;

    private boolean is3D = false;

    private boolean ignoreZeroValues = false;
    private boolean ignoreNullValues = false;

    @Override
    public boolean isIgnoreNullValues() {
        return ignoreNullValues;
    }

    @Override
    public void setIgnoreNullValues(boolean ignoreNullValues) {
        this.ignoreNullValues = ignoreNullValues;
        requestRepaint();
    }

    @Override
    public boolean isIgnoreZeroValues() {
        return ignoreZeroValues;
    }

    @Override
    public void setIgnoreZeroValues(boolean ignoreZeroValues) {
        this.ignoreZeroValues = ignoreZeroValues;
        requestRepaint();
    }

    @Override
    public boolean is3D() {
        return is3D;
    }

    @Override
    public void set3D(boolean is3D) {
        this.is3D = is3D;
    }
}