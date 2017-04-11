/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

public class JsLegendEvent extends JavaScriptObject {
    protected JsLegendEvent() {
    }

    public final native String getItemKey() /*-{
        if (this.dataItem && this.dataItem.dataContext) {
            //noinspection JSUnresolvedVariable
            return this.dataItem.dataContext.$k;
        }
        return null;
    }-*/;

    public final native int getItemIndex() /*-{
        if (this.dataItem && this.dataItem.index) {
            return this.dataItem.index;
        }
        return -1;
    }-*/;
}