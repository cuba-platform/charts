/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author artamonov
 * @version $Id$
 */
public class JsAxisZoomedEvent extends JavaScriptObject {

    protected JsAxisZoomedEvent() {
    }

    public final native String getAxisId() /*-{
        return this.axisId;
    }-*/;

    public final native double getStartValue() /*-{
        return this.startValue;
    }-*/;

    public final native double getEndValue() /*-{
        return this.endValue;
    }-*/;
}