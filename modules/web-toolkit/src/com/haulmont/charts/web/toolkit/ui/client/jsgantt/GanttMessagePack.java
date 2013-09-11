/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
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