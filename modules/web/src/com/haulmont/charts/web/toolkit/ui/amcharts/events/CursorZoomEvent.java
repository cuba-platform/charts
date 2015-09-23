/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;

/**
 * @author artamonov
 * @version $Id$
 */
public class CursorZoomEvent extends com.vaadin.ui.Component.Event {

    private final String start;
    private final String end;

    public CursorZoomEvent(CubaAmchartsScene source, String start, String end) {
        super(source);
        this.start = start;
        this.end = end;
    }

    public String getEnd() {
        return end;
    }

    public String getStart() {
        return start;
    }
}