/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONParser;
import com.vaadin.client.BrowserInfo;

/**
 * @author artamonov
 * @version $Id$
 */
public class AmchartsConfig extends JavaScriptObject {

    protected AmchartsConfig() {
    }

    public static AmchartsConfig fromServerConfig(String config, String json) {
        String configJson = config != null ? config : "{}";
        AmchartsConfig configObject = (AmchartsConfig) JSONParser.parseLenient(configJson).isObject().getJavaScriptObject();
        parseDefs(configObject);
        applyCustomJson(configObject, json);
        activateFunctions(configObject);
        parseConfigDateProperties(configObject);
        if (BrowserInfo.get().isIE() && BrowserInfo.get().getIEVersion() < 10) {
            disableExportFeatures(configObject);
        }
        return configObject;
    }

    private static native String getDefs(JavaScriptObject config) /*-{
        return config.defs;
    }-*/;

    private static native void setDefs(JavaScriptObject config, JavaScriptObject defsObject) /*-{
        config.defs = defsObject;
    }-*/;

    protected static void parseDefs(JavaScriptObject config) {
        String defs = getDefs(config);
        if (defs != null) {
            setDefs(config, JSONParser.parseLenient(defs).isObject().getJavaScriptObject());
        }
    }

    private static native void disableExportFeatures(JavaScriptObject config) /*-{
        config['export'] = undefined;
    }-*/;

    private static native void parseConfigDateProperties(JavaScriptObject config) /*-{
        var DEFAULT_JS_DATE_FORMAT = "YYYY-MM-DD JJ:NN:SS:QQQ";

        (function () {
            if (config.categoryAxis) {
                if (config.categoryAxis.guides) {
                    for (var i = 0; i < config.categoryAxis.guides.length; i++) {
                        var guide = config.categoryAxis.guides[i];
                        if (typeof guide.date == "string") {
                            guide.date = $wnd.AmCharts.stringToDate(guide.date, DEFAULT_JS_DATE_FORMAT);
                        }
                        if (typeof guide.toDate == "string") {
                            guide.toDate = $wnd.AmCharts.stringToDate(guide.toDate, DEFAULT_JS_DATE_FORMAT);
                        }
                    }
                }
            }
        })();

        (function () {
            if (config.trendLines) {
                for (var i = 0; i < config.trendLines.length; i++) {
                    var trendLine = config.trendLines[i];
                    if (typeof trendLine.finalDate == "string") {
                        trendLine.finalDate = $wnd.AmCharts.stringToDate(trendLine.finalDate, DEFAULT_JS_DATE_FORMAT);
                    }
                    if (typeof trendLine.initialDate == "string") {
                        trendLine.initialDate = $wnd.AmCharts.stringToDate(trendLine.initialDate, DEFAULT_JS_DATE_FORMAT);
                    }
                }
            }
        })();

        (function () {
            if (config.valueAxes) {
                for (var i = 0; i < config.valueAxes.length; i++) {
                    var valueAxis = config.valueAxes[i];
                    if (valueAxis.guides) {
                        for (var j = 0; j < valueAxis.guides.length; j++) {
                            var guide = valueAxis.guides[j];
                            if (typeof guide.date == "string") {
                                guide.date = $wnd.AmCharts.stringToDate(guide.date, DEFAULT_JS_DATE_FORMAT);
                            }
                            if (typeof guide.toDate == "string") {
                                guide.toDate = $wnd.AmCharts.stringToDate(guide.toDate, DEFAULT_JS_DATE_FORMAT);
                            }
                        }
                    }
                }
            }
        })();

        (function(){
            if (config.startDate) {
                config.startDate = $wnd.AmCharts.stringToDate(config.startDate, DEFAULT_JS_DATE_FORMAT);
            }
            if (config.endDate) {
                config.endDate = $wnd.AmCharts.stringToDate(config.endDate, DEFAULT_JS_DATE_FORMAT);
            }
        })();
    }-*/;

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