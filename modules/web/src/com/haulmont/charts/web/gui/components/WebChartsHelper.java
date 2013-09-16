/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components;

import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.web.toolkit.ui.charts.WChart;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public class WebChartsHelper {

    public static WChart.Orientation convertChartOrientation(Chart.Orientation orientation) {
        switch (orientation) {
            case VERTICAL:
                return WChart.Orientation.VERTICAL;
            case HORIZONTAL:
                return WChart.Orientation.HORIZONTAL;
            default:
                throw new IllegalArgumentException("Unknown chart orientation: " + orientation);
        }
    }

    public static Chart.Orientation convertChartOrientation(WChart.Orientation orientation) {
        switch (orientation) {
            case VERTICAL:
                return Chart.Orientation.VERTICAL;
            case HORIZONTAL:
                return Chart.Orientation.HORIZONTAL;
            default:
                throw new IllegalArgumentException("Unknown chart orientation: " + orientation);
        }
    }

    public static WChart.AxisType convertChartAxisType(Chart.AxisType axisType) {
        switch (axisType) {
            case NUMBER:
                return WChart.AxisType.NUMBER;
            case DATE:
                return WChart.AxisType.DATE;
            default:
                throw new IllegalArgumentException("Unknown chart axis type: " + axisType);
        }
    }

    public static Chart.AxisType convertChartAxisType(WChart.AxisType axisType) {
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