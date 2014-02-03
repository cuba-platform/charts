/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.gui.components.charts.jsgantt;

import com.haulmont.charts.gui.components.charts.BaseGanttChart;
import com.haulmont.charts.web.toolkit.ui.charts.WChart;

/**
 * @author artamonov
 * @version $Id$
 */
public class WebChartsHelper {

    public static WChart.Orientation convertChartOrientation(BaseGanttChart.Orientation orientation) {
        switch (orientation) {
            case VERTICAL:
                return WChart.Orientation.VERTICAL;
            case HORIZONTAL:
                return WChart.Orientation.HORIZONTAL;
            default:
                throw new IllegalArgumentException("Unknown chart orientation: " + orientation);
        }
    }

    public static BaseGanttChart.Orientation convertChartOrientation(WChart.Orientation orientation) {
        switch (orientation) {
            case VERTICAL:
                return BaseGanttChart.Orientation.VERTICAL;
            case HORIZONTAL:
                return BaseGanttChart.Orientation.HORIZONTAL;
            default:
                throw new IllegalArgumentException("Unknown chart orientation: " + orientation);
        }
    }

    public static WChart.AxisType convertChartAxisType(BaseGanttChart.AxisType axisType) {
        switch (axisType) {
            case NUMBER:
                return WChart.AxisType.NUMBER;
            case DATE:
                return WChart.AxisType.DATE;
            default:
                throw new IllegalArgumentException("Unknown chart axis type: " + axisType);
        }
    }

    public static BaseGanttChart.AxisType convertChartAxisType(WChart.AxisType axisType) {
        switch (axisType) {
            case NUMBER:
                return BaseGanttChart.AxisType.NUMBER;
            case DATE:
                return BaseGanttChart.AxisType.DATE;
            default:
                throw new IllegalArgumentException("Unknown chart axis type: " + axisType);
        }
    }
}