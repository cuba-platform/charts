/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

/**
 */
public class JsCursorEvent extends JavaScriptObject {

    protected JsCursorEvent() {
    }

    public final native String getStart() /*-{
        return "" + this.start;
    }-*/;

    public final native String getEnd() /*-{
        return "" + this.end;
    }-*/;
}