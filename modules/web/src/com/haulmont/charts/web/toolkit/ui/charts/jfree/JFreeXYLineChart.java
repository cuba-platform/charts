/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.charts.jfree;

import com.haulmont.charts.web.toolkit.ui.charts.WChart;
import com.haulmont.charts.web.toolkit.ui.charts.WXYLineChart;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public class JFreeXYLineChart extends JFreeXYChart implements WXYLineChart {
    private static final long serialVersionUID = 8197598406862479049L;

    private String argumentAxisLabel;
    private String valueAxisLabel;
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
    public WChart.Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String getValueAxisLabel() {
        return valueAxisLabel;
    }

    @Override
    public void setValueAxisLabel(String valueAxisLabel) {
        this.valueAxisLabel = valueAxisLabel;
    }
}