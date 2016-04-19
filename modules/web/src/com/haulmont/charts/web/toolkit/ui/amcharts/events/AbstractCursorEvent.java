/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;

public abstract class AbstractCursorEvent extends com.vaadin.ui.Component.Event {

    private static final long serialVersionUID = 7387950556241724781L;

    private final String start;
    private final String end;

    public AbstractCursorEvent(CubaAmchartsScene source, String start, String end) {
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
