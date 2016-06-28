/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

public class JsSlicePullEvent extends JavaScriptObject {

    protected JsSlicePullEvent() {
    }

    public final native String getSliceId() /*-{
        if (this.dataItem && this.dataItem.dataContext) {
            return "" + this.dataItem.dataContext.id;
        }
        return null;
    }-*/;
}