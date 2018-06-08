/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events;

import com.google.gwt.core.client.JavaScriptObject;
import com.haulmont.cuba.web.widgets.client.JsDate;

public abstract class AbstractJsStockEventEvent extends JavaScriptObject {

    protected AbstractJsStockEventEvent() {
    }

    public final native String getGraphId() /*-{
        if (this.graph) {
            return this.graph.id;
        }
        return null;
    }-*/;

    public final native String getEventObjectId() /*-{
        return this.eventObject.id;
    }-*/;

    public final native JsDate getDate() /*-{
        return this.date;
    }-*/;
}
