/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONParser;
import com.vaadin.client.BrowserInfo;

public class AmStockChartConfig extends JavaScriptObject {

    protected AmStockChartConfig() {
    }

    public static AmStockChartConfig fromServerConfig(String config, String json) {
        String configJson = config != null ? config : "{}";
        AmStockChartConfig configObject = (AmStockChartConfig) JSONParser.parseLenient(configJson).isObject().getJavaScriptObject();
        parseDefs(configObject);
        applyCustomJson(configObject, json);
        activateFunctions(configObject);
        parseConfigDateProperties(configObject);
        copyFromDataSets(configObject);
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
            if (config.dataSets) {
                for (var dataSetIndex = 0; dataSetIndex < config.dataSets.length; dataSetIndex++) {
                    var dataSet = config.dataSets[dataSetIndex];
                    if (dataSet.stockEvents) {
                        for (var stockEventIndex = 0; stockEventIndex < dataSet.stockEvents.length; stockEventIndex++) {
                            var stockEvent = dataSet.stockEvents[stockEventIndex];
                            if (typeof stockEvent.date == "string") {
                                stockEvent.date = $wnd.AmCharts.stringToDate(stockEvent.date, DEFAULT_JS_DATE_FORMAT);
                            }
                        }
                    }
                }
            }
        })();

        var parseGuides = function (guides) {
            for (var i = 0; i < guides.length; i++) {
                var guide = guides[i];
                if (typeof guide.date == "string") {
                    guide.date = $wnd.AmCharts.stringToDate(guide.date, DEFAULT_JS_DATE_FORMAT);
                }
                if (typeof guide.toDate == "string") {
                    guide.toDate = $wnd.AmCharts.stringToDate(guide.toDate, DEFAULT_JS_DATE_FORMAT);
                }
            }
        };

        var parseCategoryAxis = function (categoryAxis) {
            if (categoryAxis.guides) {
                parseGuides(categoryAxis.guides);
            }
        };

        var parseTrendLines = function (trendLines) {
            for (var i = 0; i < trendLines.length; i++) {
                var trendLine = trendLines[i];
                if (typeof trendLine.finalDate == "string") {
                    trendLine.finalDate = $wnd.AmCharts.stringToDate(trendLine.finalDate, DEFAULT_JS_DATE_FORMAT);
                }
                if (typeof trendLine.initialDate == "string") {
                    trendLine.initialDate = $wnd.AmCharts.stringToDate(trendLine.initialDate, DEFAULT_JS_DATE_FORMAT);
                }
            }
        };

        var parseValueAxis = function (valueAxis) {
            if (typeof valueAxis.minimumDate == "string") {
                valueAxis.minimumDate = $wnd.AmCharts.stringToDate(valueAxis.minimumDate, DEFAULT_JS_DATE_FORMAT);
            }
            if (typeof valueAxis.maximumDate == "string") {
                valueAxis.maximumDate = $wnd.AmCharts.stringToDate(valueAxis.maximumDate, DEFAULT_JS_DATE_FORMAT);
            }
            if (valueAxis.guides) {
                parseGuides(valueAxis.guides);
            }
        };

        var parseValueAxes = function (valueAxes) {
            for (var i = 0; i < valueAxes.length; i++) {
                var valueAxis = valueAxes[i];
                parseValueAxis(valueAxis);
            }
        };

        (function () {
            if (config.panels) {
                for (var panelIndex = 0; panelIndex < config.panels.length; panelIndex++) {
                    var panel = config.panels[panelIndex];
                    if (typeof panel.recalculateFromDate == "string") {
                        panel.recalculateFromDate = $wnd.AmCharts.stringToDate(panel.recalculateFromDate, DEFAULT_JS_DATE_FORMAT);
                    }
                    if (panel.valueAxis) {
                        parseValueAxis(panel.valueAxis);
                    }
                    if (panel.categoryAxis) {
                        parseCategoryAxis(panel.categoryAxis);
                    }
                    if (panel.trendLines) {
                        parseTrendLines(panel.trendLines);
                    }
                    if (panel.guides) {
                        parseGuides(panel.guides);
                    }
                    if (panel.valueAxes) {
                        parseValueAxes(panel.valueAxes);
                    }
                }
            }
        })();
    }-*/;

    private static native void copyFromDataSets(JavaScriptObject config) /*-{
        if (config.dataSets) {
            var findDataSetById = function(id) {
                for (var i = 0; i < config.dataSets.length; i++) {
                    var dataSet = config.dataSets[i];
                    if (dataSet.id == id) {
                        return dataSet;
                    }
                }
                return undefined;
            };

            if (typeof config.mainDataSet == "string") {
                config.mainDataSet = findDataSetById(config.mainDataSet);
            }

            if (config.comparedDataSets) {
                for (var i = 0; i < config.comparedDataSets.length; i++) {
                    var dataSet = config.comparedDataSets[i];
                    if (typeof dataSet == "string") {
                        dataSet = findDataSetById(dataSet);
                    }
                }
            }
        }
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

    public final native boolean hasStockEvents() /*-{
        if (this.dataSets) {
            for (var i = 0; i < this.dataSets.length; i++) {
                if (this.dataSets[i].stockEvents) {
                    return true;
                }
            }
        }
        return false;
    }-*/;

    public final native boolean hasPeriodSelector() /*-{
        if (this.periodSelector) {
            return true;
        }
        return false;
    }-*/;

    public final native boolean hasDataSetSelector() /*-{
        if (this.dataSetSelector) {
            return true;
        }
        return false;
    }-*/;
}
