/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.gui.components.charts;

import com.haulmont.cuba.gui.components.Component;

/** Root chart component */
public interface Chart extends Component, Component.Wrapper, Component.BelongToFrame,
        Component.HasXmlDescriptor, Component.HasCaption {

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
        void set3D(boolean b);
    }
}