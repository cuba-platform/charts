/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;

import java.util.Date;

/**
 * @author artamonov
 * @version $Id$
 */
public class ZoomEvent extends com.vaadin.ui.Component.Event {

    private static final long serialVersionUID = 3375717365928857628L;

    private final int startIndex;
    private final int endIndex;
    private final Date startDate;
    private final Date endDate;
    private final String startValue;
    private final String endValue;

    public ZoomEvent(CubaAmchartsScene source, int startIndex, int endIndex,
                     Date startDate, Date endDate, String startValue, String endValue) {
        super(source);
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public String getEndValue() {
        return endValue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public String getStartValue() {
        return startValue;
    }
}