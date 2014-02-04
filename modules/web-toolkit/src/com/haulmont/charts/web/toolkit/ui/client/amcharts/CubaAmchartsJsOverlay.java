/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * @author artamonov
 * @version $Id$
 */
public class CubaAmchartsJsOverlay {

    private static boolean ready = false;

    private JavaScriptObject chart;

    public CubaAmchartsJsOverlay(JavaScriptObject chart) {
        this.chart = chart;
    }

    public static CubaAmchartsJsOverlay makeChart(Element placeHolder, JavaScriptObject json) {
        if (!ready) {
            handleLoad();
            ready = true;
        }

        return new CubaAmchartsJsOverlay(makeJsChart(placeHolder, json));
    }

    private static native void handleLoad() /*-{
        $wnd.AmCharts.handleLoad();
    }-*/;

    private static native JavaScriptObject makeJsChart(Element placeHolder, JavaScriptObject json) /*-{
        return $wnd.AmCharts.makeChart(placeHolder, json);
    }-*/;

    public void updateSize() {
        updateSize(chart);
    }

    private static native void updateSize(JavaScriptObject chart) /*-{
        chart.invalidateSize();
    }-*/;
}