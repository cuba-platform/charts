/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

public class JsAxisZoomedEvent extends JavaScriptObject {

    protected JsAxisZoomedEvent() {
    }

    public final native String getAxisId() /*-{
        return this.axisId;
    }-*/;

    public final native double getStartValue() /*-{
        return this.startValue;
    }-*/;

    public final native double getEndValue() /*-{
        return this.endValue;
    }-*/;
}