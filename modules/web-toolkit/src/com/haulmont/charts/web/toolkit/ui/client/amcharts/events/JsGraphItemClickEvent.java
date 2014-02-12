/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;

/**
 * @author artamonov
 * @version $Id$
 */
public class JsGraphItemClickEvent extends JavaScriptObject {

    protected JsGraphItemClickEvent() {
    }

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
            return "" + this.item.dataContext.id;
        }
        return null;
    }-*/;
}