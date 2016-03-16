/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;

/**
 */
public class JsSliceClickEvent extends JavaScriptObject {

    protected JsSliceClickEvent() {
    }

    public final native String getSliceId() /*-{
        if (this.dataItem && this.dataItem.dataContext) {
            return "" + this.dataItem.dataContext.id;
        }
        return null;
    }-*/;

    public final native NativeEvent getMouseEvent() /*-{
        return this.event;
    }-*/;
}