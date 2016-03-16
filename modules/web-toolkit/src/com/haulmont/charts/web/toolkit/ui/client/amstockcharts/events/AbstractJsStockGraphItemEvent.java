/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;

/**
 */
public class AbstractJsStockGraphItemEvent extends JavaScriptObject {

    protected AbstractJsStockGraphItemEvent() {
    }

    public final native String getPanelId() /*-{
        if (this.chart) {
            return this.chart.id;
        }
        return null;
    }-*/;

    public final native String getGraphId() /*-{
        if (this.graph) {
            return this.graph.id;
        }
        return null;
    }-*/;

    public final native NativeEvent getMouseEvent() /*-{
        return this.event;
    }-*/;

    public final native int getIndex() /*-{
        return this.index;
    }-*/;

    public final native String getItemId() /*-{
        if (this.item && this.item.dataContext) {
            if (!this.item.dataContext.id) {
                return null;
            }

            return "" + this.item.dataContext.id;
        }
        return null;
    }-*/;
}