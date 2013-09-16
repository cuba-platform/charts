/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.jsgantt;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public class GanttMessagePack extends JavaScriptObject {

    public static GanttMessagePack create() {
        return JavaScriptObject.createObject().cast();
    }

    protected GanttMessagePack() {
    }

    public final native void addMessage(String key, String value)/*-{
        this[key] = value;
    }-*/;
}