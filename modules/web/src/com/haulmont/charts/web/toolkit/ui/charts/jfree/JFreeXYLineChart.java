/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts.jfree;

import com.haulmont.charts.web.toolkit.ui.charts.Chart;
import com.haulmont.charts.web.toolkit.ui.charts.XYLineChart;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public class JFreeXYLineChart extends JFreeXYChart implements XYLineChart {
    private static final long serialVersionUID = 8197598406862479049L;

    private String argumentAxisLabel;
    private String valueAxisLabel;
    private Orientation orientation = Orientation.VERTICAL;

    public String getArgumentAxisLabel() {
        return argumentAxisLabel;
    }

    public void setArgumentAxisLabel(String argumentAxisLabel) {
        this.argumentAxisLabel = argumentAxisLabel;
    }

    public Chart.Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public String getValueAxisLabel() {
        return valueAxisLabel;
    }

    public void setValueAxisLabel(String valueAxisLabel) {
        this.valueAxisLabel = valueAxisLabel;
    }
}