/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.amstockcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

public class JsStockChartClickEvent extends JavaScriptObject {

    protected JsStockChartClickEvent() {
    }

    public final native int getX() /*-{
        return this.x;
    }-*/;

    public final native int getY() /*-{
        return this.y;
    }-*/;

    public final native int getAbsoluteX() /*-{
        return this.absoluteX;
    }-*/;

    public final native int getAbsoluteY() /*-{
        return this.absoluteY;
    }-*/;
}