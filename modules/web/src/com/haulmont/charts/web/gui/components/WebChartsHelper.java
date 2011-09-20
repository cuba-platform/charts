/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.gui.components;

import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.web.toolkit.ui.charts.VChart;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public class WebChartsHelper {

    public static VChart.Orientation convertChartOrientation(Chart.Orientation orientation) {
        switch (orientation) {
            case VERTICAL:
                return VChart.Orientation.VERTICAL;
            case HORIZONTAL:
                return VChart.Orientation.HORIZONTAL;
            default:
                throw new IllegalArgumentException("Unknown chart orientation: " + orientation);
        }
    }

    public static Chart.Orientation convertChartOrientation(VChart.Orientation orientation) {
        switch (orientation) {
            case VERTICAL:
                return Chart.Orientation.VERTICAL;
            case HORIZONTAL:
                return Chart.Orientation.HORIZONTAL;
            default:
                throw new IllegalArgumentException("Unknown chart orientation: " + orientation);
        }
    }

    public static VChart.AxisType convertChartAxisType(Chart.AxisType axisType) {
        switch (axisType) {
            case NUMBER:
                return VChart.AxisType.NUMBER;
            case DATE:
                return VChart.AxisType.DATE;
            default:
                throw new IllegalArgumentException("Unknown chart axis type: " + axisType);
        }
    }

    public static Chart.AxisType convertChartAxisType(VChart.AxisType axisType) {
        switch (axisType) {
            case NUMBER:
                return Chart.AxisType.NUMBER;
            case DATE:
                return Chart.AxisType.DATE;
            default:
                throw new IllegalArgumentException("Unknown chart axis type: " + axisType);
        }
    }
}