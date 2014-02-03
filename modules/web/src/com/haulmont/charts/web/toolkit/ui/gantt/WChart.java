/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.web.toolkit.ui.gantt;

import com.vaadin.ui.Component;

/**
 * @author gorodnov
 * @version $Id$
 */
public interface WChart extends Component {

    String getVendor();

    int getChartWidth();
    void setChartWidth(int chartWidth);

    int getChartHeight();
    void setChartHeight(int chartHeight);

    enum AxisType {
        NUMBER,
        DATE
    }

    enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    interface HasLegend {
        boolean getHasLegend();
        void setHasLegend(boolean hasLegend);
    }

    interface HasAxisLabels {
        String getArgumentAxisLabel();
        void setArgumentAxisLabel(String label);

        String getValueAxisLabel();
        void setValueAxisLabel(String label);
    }

    interface HasValueAxisType {
        AxisType getValueAxisType();
        void setValueAxisType(AxisType axisType);
    }

    interface HasArgumentAxisType {
        AxisType getArgumentAxisType();
        void setArgumentAxisType(AxisType axisType);
    }

    interface HasOrientation {
        Orientation getOrientation();
        void setOrientation(Orientation orientation);
    }

    interface ViewIn3D {
        boolean is3D();
        void set3D(boolean is3D);
    }
}