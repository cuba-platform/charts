/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.charts.web.toolkit.ui.charts.jfree;

import com.haulmont.charts.web.toolkit.ui.charts.WBarChart;
import com.vaadin.data.Container;

public class JFreeBarChart extends JFreeCategoryChart implements WBarChart {
    private static final long serialVersionUID = 2496407681381514463L;

    private String argumentAxisLabel;
    private String valueAxisLabel;
    private AxisType valueAxisType = AxisType.NUMBER;
    private Orientation orientation = Orientation.VERTICAL;
    private boolean is3D = false;

    @Override
    public String getArgumentAxisLabel() {
        return argumentAxisLabel;
    }

    @Override
    public void setArgumentAxisLabel(String columnAxisLabel) {
        this.argumentAxisLabel = columnAxisLabel;
    }

    @Override
    public String getValueAxisLabel() {
        return valueAxisLabel;
    }

    @Override
    public void setValueAxisLabel(String valueAxisLabel) {
        this.valueAxisLabel = valueAxisLabel;
    }

    @Override
    public AxisType getValueAxisType() {
        return valueAxisType;
    }

    @Override
    public void setValueAxisType(AxisType valueAxisType) {
        this.valueAxisType = valueAxisType;
    }

    @Override
    public boolean is3D() {
        return is3D;
    }

    @Override
    public void set3D(boolean is3D) {
        this.is3D = is3D;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}