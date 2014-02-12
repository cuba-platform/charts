/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONParser;

/**
 * @author artamonov
 * @version $Id$
 */
public class AmchartsConfig extends JavaScriptObject {

    protected AmchartsConfig() {
    }

    public static AmchartsConfig fromServerConfig(String config, String json) {
        AmchartsConfig configObject = (AmchartsConfig) JSONParser.parseLenient(config).isObject().getJavaScriptObject();
        applyCustomJson(configObject, json);
        activateFunctions(configObject);
        return configObject;
    }

    private static native void applyCustomJson(JavaScriptObject config, String manualOptions) /*-{
        var merge = function (dst, src) {
            for (var property in src) {
                if (src.hasOwnProperty(property)) {
                    if (src[property] && typeof src[property] === "object") {
                        if (!dst[property]) {
                            dst[property] = src[property];
                        } else {
                            arguments.callee(dst[property], src[property]);
                        }
                    } else {
                        dst[property] = src[property];
                    }
                }
            }
        };
        var cfg = $wnd.eval("(" + manualOptions + ")");
        merge(config, cfg);
    }-*/;

    private static native void activateFunctions(JavaScriptObject config) /*-{
        // function property names ends with 'Function'
        var reFunction = /Function$/;
        var active = function (obj) {
            for (var prop in obj) {
                if (obj.hasOwnProperty(prop)) {
                    if (prop.match(reFunction)) {
                        obj[prop] = $wnd.eval("(" + obj[prop] + ")");
                    } else if (typeof obj[prop] === "object") {
                        arguments.callee(obj[prop]);
                    }
                }
            }
        };
        active(config);
    }-*/;

    public final native String getChartType() /*-{
        return this.type;
    }-*/;

    public final native boolean hasLegend() /*-{
        if (this.legend) {
            return true;
        }
        return false;
    }-*/;

    public final native boolean hasCursor() /*-{
        if (this.chartCursor) {
            return true;
        }
        return false;
    }-*/;
}