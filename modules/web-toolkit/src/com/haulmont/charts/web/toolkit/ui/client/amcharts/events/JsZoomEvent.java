/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;
import com.haulmont.cuba.web.toolkit.ui.client.JsDate;

public class JsZoomEvent extends JavaScriptObject {

    protected JsZoomEvent() {
    }

    public final native int getStartIndex() /*-{
        return this.startIndex;
    }-*/;

    public final native int getEndIndex() /*-{
        return this.endIndex;
    }-*/;

    public final native JsDate getStartDate() /*-{
        return this.startDate;
    }-*/;

    public final native JsDate getEndDate() /*-{
        return this.endDate;
    }-*/;

    public final native String getStartValue() /*-{
        return this.startValue;
    }-*/;

    public final native String getEndValue() /*-{
        return this.endValue;
    }-*/;
}