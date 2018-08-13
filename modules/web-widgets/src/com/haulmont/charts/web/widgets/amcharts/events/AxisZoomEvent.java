/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;
import com.vaadin.ui.Component;

public class AxisZoomEvent extends Component.Event {

    private final String axisId;
    private final double startValue;
    private final double endValue;

    public AxisZoomEvent(CubaAmchartsScene source, String axisId, double startValue, double endValue) {
        super(source);
        this.axisId = axisId;
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public String getAxisId() {
        return axisId;
    }

    public double getEndValue() {
        return endValue;
    }

    public double getStartValue() {
        return startValue;
    }
}