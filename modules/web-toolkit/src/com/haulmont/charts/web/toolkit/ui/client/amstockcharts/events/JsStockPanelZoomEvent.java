/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events;

import com.google.gwt.core.client.JavaScriptObject;
import com.haulmont.cuba.web.toolkit.ui.client.JsDate;

public class JsStockPanelZoomEvent extends JavaScriptObject {

    protected JsStockPanelZoomEvent() {
    }

    public final native String getPeriod() /*-{
        if (this.period) {
            return this.period;
        }
        return null;
    }-*/;

    public final native JsDate getStartDate() /*-{
        return this.startDate;
    }-*/;

    public final native JsDate getEndDate() /*-{
        return this.endDate;
    }-*/;
}
