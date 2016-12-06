/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.utils;

import com.google.gwt.core.client.JavaScriptObject;

public class JsUtils {

    public static native void applyCustomJson(JavaScriptObject config, String manualOptions) /*-{
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

    public static native void activateFunctions(JavaScriptObject config, boolean removeSuffix) /*-{
        // function property names ends with 'Function'
        var reFunction = /Function$/;
        var active = function (obj) {
            for (var prop in obj) {
                if (obj.hasOwnProperty(prop)) {
                    if (prop.match(reFunction)) {
                        var func = $wnd.eval("(" + obj[prop] + ")");
                        if (removeSuffix) {
                            obj[prop.replace(reFunction, "")] = func;
                            delete obj[prop];
                        } else {
                            obj[prop] = func;
                        }
                    } else if (typeof obj[prop] === "object") {
                        arguments.callee(obj[prop]);
                    }
                }
            }
        };
        active(config);
    }-*/;
}
