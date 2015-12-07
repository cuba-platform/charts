/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import com.haulmont.cuba.web.toolkit.ui.client.JsDate;

/**
 * @author gorelov
 * @version $Id$
 */
public class JsPeriodSelectorChangeEvent extends JavaScriptObject {

    protected JsPeriodSelectorChangeEvent() {
    }

    public final native JsDate getStartDate() /*-{
        return this.startDate;
    }-*/;

    public final native JsDate getEndDate() /*-{
        return this.startDate;
    }-*/;

    public final native NativeEvent getMouseEvent() /*-{
        return this.event;
    }-*/;

    public final native String getPredefinedPeriod() /*-{
        return this.predefinedPeriod;
    }-*/;

    public final native Integer getCount() /*-{
        return this.count;
    }-*/;
}
