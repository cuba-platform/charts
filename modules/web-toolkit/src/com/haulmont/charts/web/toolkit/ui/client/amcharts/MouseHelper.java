/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.dom.client.NativeEvent;

/**
 */
public class MouseHelper {

    public static native int getX(NativeEvent e) /*-{
        return (typeof e.offsetX == "number") ? e.offsetX : e.layerX || 0;
    }-*/;

    public static native int getY(NativeEvent e) /*-{
        return (typeof e.offsetY == "number") ? e.offsetY : e.layerY || 0;
    }-*/;
}