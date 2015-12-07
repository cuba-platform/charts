/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author artamonov
 * @version $Id$
 */
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