/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;
import com.vaadin.ui.Component;

/**
 * @author artamonov
 * @version $Id$
 */
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