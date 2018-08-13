/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.pivottable.events;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.Map;

public class JsCellClickEvent extends JavaScriptObject {
    protected JsCellClickEvent() {
    }

    public final native Double getValue() /*-{
        return this.value;
    }-*/;

    public final native Map<String, String> getFilters() /*-{
        return this.filters;
    }-*/;
}
