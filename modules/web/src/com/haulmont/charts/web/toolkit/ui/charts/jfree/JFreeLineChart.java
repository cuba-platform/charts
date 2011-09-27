/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.charts.web.toolkit.ui.charts.jfree;

import com.haulmont.charts.web.toolkit.ui.charts.WLineChart;

public class JFreeLineChart extends JFreeCategoryChart implements WLineChart {
    private static final long serialVersionUID = 7118566359236292560L;

    private String argumentAxisLabel;
    private String valueAxisLabel;
    private AxisType valueAxisType = AxisType.NUMBER;
    private Orientation orientation = Orientation.VERTICAL;

    @Override
    public String getArgumentAxisLabel() {
        return argumentAxisLabel;
    }

    @Override
    public void setArgumentAxisLabel(String argumentAxisLabel) {
        this.argumentAxisLabel = argumentAxisLabel;
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
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}