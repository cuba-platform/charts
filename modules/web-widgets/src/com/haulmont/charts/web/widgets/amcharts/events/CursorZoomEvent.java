/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;

public class CursorZoomEvent extends AbstractCursorEvent {

    private static final long serialVersionUID = -8030273951329398295L;

    public CursorZoomEvent(CubaAmchartsScene source, String start, String end) {
        super(source, start, end);
    }
}