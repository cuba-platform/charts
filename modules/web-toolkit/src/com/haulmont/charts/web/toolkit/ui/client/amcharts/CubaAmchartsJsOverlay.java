/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.events.*;
import com.haulmont.cuba.web.toolkit.ui.client.JsDate;

/**
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

    public void updatePoints(JavaScriptObject value) {
        updatePoints(chart, value);
    }

    private native void updatePoints(JavaScriptObject chart, JavaScriptObject src) /*-{
        (function () {
            var opp = 'add';
            if (src[opp] != null) {
                for (var i = 0; i < src[opp].length; i++) {
                    chart.dataProvider.push(src[opp][i]);
                }
            }
        })();

        (function () {
            var opp = 'remove';
            if (src[opp] != null) {
                for (var i = 0; i < src[opp].length; i++) {
                    for (var j = 0; j < chart.dataProvider.length; j++) {
                        if (chart.dataProvider[j].id == src[opp][i].id) {
                            chart.dataProvider.splice(j, 1);
                            break;
                        }
                    }
                }
            }
        })();

        (function () {
            var opp = 'update';
            if (src[opp] != null) {
                for (var i = 0; i < src[opp].length; i++) {
                    for (var j = 0; j < chart.dataProvider.length; j++) {
                        if (chart.dataProvider[j].id == src[opp][i].id) {
                            chart.dataProvider[j] = src[opp][i];
                            break;
                        }
                    }
                }
            }
        })();

        chart.validateData();
    }-*/;

    private static native void handleLoad() /*-{
        $wnd.AmCharts.handleLoad();
    }-*/;

    private static native JavaScriptObject makeJsChart(Element placeHolder, JavaScriptObject json) /*-{
        var chart = $wnd.AmCharts.makeChart(placeHolder, json);
        // save last cursor position to chart.cursorPosition
        if (("xy" === chart.type || "serial" === chart.type) && chart.chartCursor) {
            chart.chartCursor.addListener("moved", function (event) {
                chart.cursorPosition = {"x": event.x, "y": event.y};
            });
        }
        return  chart;
    }-*/;

    public void updateSize() {
        updateSize(chart);
    }

    private static native void updateSize(JavaScriptObject chart) /*-{
        chart.invalidateSize();
    }-*/;

    public void destroy() {
        destroy(chart);
    }

    private static native void destroy(JavaScriptObject chart) /*-{
        chart.clear();
    }-*/;

    public JsChartClickEvent getClickEvent(int x, int y, int absoluteX, int absoluteY) {
        return getClickEvent(chart, x, y, absoluteX, absoluteY);
    }

    private static native JsChartClickEvent getClickEvent(JavaScriptObject chart, int x, int y, int absoluteX, int absoluteY) /*-{
        var event = {};
        event.x = x;
        event.y = y;
        event.absoluteX = absoluteX;
        event.absoluteY = absoluteY;
        event.xAxis = -1;
        event.yAxis = -1;

        if ("xy" === chart.type || "serial" === chart.type) {
            if (chart.valueAxes && chart.cursorPosition) {
                for (var i = 0; i < chart.valueAxes.length; i++) {
                    var axis = chart.valueAxes[i];
                    if ("left" === axis.position || "right" === axis.position) {
                        event.yAxis = $wnd.AmCharts.roundTo(axis.coordinateToValue(chart.cursorPosition.y - axis.axisY), 2);
                    } else if ("bottom" === axis.position || "top" === axis.position) {
                        event.xAxis = $wnd.AmCharts.roundTo(axis.coordinateToValue(chart.cursorPosition.x - axis.axisX), 2);
                    }
                }
            }
        }

        return event;
    }-*/;

    public void addGraphClickHandler(GraphClickHandler handler) {
        addGraphClickHandler(chart, handler);
    }

    private static native void addGraphClickHandler(JavaScriptObject chart, GraphClickHandler handler) /*-{
        chart.addListener("clickGraph", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.GraphClickHandler::onClick(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsGraphClickEvent;)(event);
        }));
    }-*/;

    public void addGraphItemClickHandler(GraphItemClickHandler handler) {
        addGraphItemClickHandler(chart, handler);
    }

    private static native void addGraphItemClickHandler(JavaScriptObject chart, GraphItemClickHandler handler) /*-{
        chart.addListener("clickGraphItem", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.GraphItemClickHandler::onClick(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsGraphItemClickEvent;)(event);
        }));
    }-*/;

    public void addGraphItemRightClickHandler(GraphItemClickHandler handler) {
        addGraphItemRightClickHandler(chart, handler);
    }

    private static native void addGraphItemRightClickHandler(JavaScriptObject chart, GraphItemClickHandler handler) /*-{
        chart.addListener("rightClickGraphItem", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.GraphItemClickHandler::onClick(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsGraphItemClickEvent;)(event);

            event.event.preventDefault();
        }));
    }-*/;

    public void addZoomHandler(ZoomHandler zoomHandler) {
        addZoomHandler(chart, zoomHandler);
    }

    private static native void addZoomHandler(JavaScriptObject chart, ZoomHandler handler) /*-{
        chart.addListener("zoomed", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.ZoomHandler::onZoom(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsZoomEvent;)(event);
        }));
    }-*/;

    public void addSliceClickHandler(SliceClickHandler sliceClickHandler) {
        addSliceClickHandler(chart, sliceClickHandler);
    }

    private static native void addSliceClickHandler(JavaScriptObject chart, SliceClickHandler handler) /*-{
        chart.addListener("clickSlice", $entry(function (event) {
            if (event.event.which == 1) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.SliceClickHandler::onEvent(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsSliceClickEvent;)(event);
            }
        }));
    }-*/;

    public void addSliceRightClickHandler(SliceClickHandler sliceRightClickHandler) {
        addSliceRightClickHandler(chart, sliceRightClickHandler);
    }

    private static native void addSliceRightClickHandler(JavaScriptObject chart, SliceClickHandler handler) /*-{
        chart.addListener("rightClickSlice", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.SliceClickHandler::onEvent(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsSliceClickEvent;)(event);

            event.event.preventDefault();
        }));
    }-*/;

    public void addSlicePullInHandler(SlicePullHandler slicePullInHandler) {
        addSlicePullInHandler(chart, slicePullInHandler);
    }

    private static native void addSlicePullInHandler(JavaScriptObject chart, SlicePullHandler handler) /*-{
        chart.addListener("pullInSlice", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.SlicePullHandler::onEvent(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsSlicePullEvent;)(event);
        }));
    }-*/;

    public void addSlicePullOutHandler(SlicePullHandler slicePullOutHandler) {
        addSlicePullOutHandler(chart, slicePullOutHandler);
    }

    private static native void addSlicePullOutHandler(JavaScriptObject chart, SlicePullHandler handler)  /*-{
        chart.addListener("pullOutSlice", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.SlicePullHandler::onEvent(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsSlicePullEvent;)(event);
        }));
    }-*/;

    public void addLegendLabelClickHandler(LegendEventHandler legendLabelClickHandler) {
        addLegendLabelClickHandler(chart, legendLabelClickHandler);
    }

    private native static void addLegendLabelClickHandler(JavaScriptObject chart, LegendEventHandler handler) /*-{
        if (chart.legend) {
            chart.legend.addListener("clickLabel", $entry(function (event) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.LegendEventHandler::onEvent(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsLegendEvent;)(event);
            }));
        }
    }-*/;

    public void addLegendMarkerClickHandler(LegendEventHandler legendMarkerClickHandler) {
        addLegendMarkerClickHandler(chart, legendMarkerClickHandler);
    }

    private native static void addLegendMarkerClickHandler(JavaScriptObject chart, LegendEventHandler handler) /*-{
        if (chart.legend) {
            chart.legend.addListener("clickMarker", $entry(function (event) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.LegendEventHandler::onEvent(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsLegendEvent;)(event);
            }));
        }
    }-*/;

    public void addLegendItemShowHandler(LegendEventHandler legendItemShowHandler) {
        addLegendItemShowHandler(chart, legendItemShowHandler);
    }

    private native static void addLegendItemShowHandler(JavaScriptObject chart, LegendEventHandler handler) /*-{
        if (chart.legend) {
            chart.legend.addListener("showItem", $entry(function (event) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.LegendEventHandler::onEvent(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsLegendEvent;)(event);
            }));
        }
    }-*/;

    public void addLegendItemHideHandler(LegendEventHandler legendItemHideHandler) {
        addLegendItemHideHandler(chart, legendItemHideHandler);
    }

    private native static void addLegendItemHideHandler(JavaScriptObject chart, LegendEventHandler handler) /*-{
        if (chart.legend) {
            chart.legend.addListener("hideItem", $entry(function (event) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.LegendEventHandler::onEvent(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsLegendEvent;)(event);
            }));
        }
    }-*/;

    public void addCursorPeriodSelectHandler(CursorEventHandler cursorPeriodSelectHandler) {
        addCursorPeriodSelectHandler(chart, cursorPeriodSelectHandler);
    }

    private native static void addCursorPeriodSelectHandler(JavaScriptObject chart, CursorEventHandler handler) /*-{
        if (chart.chartCursor) {
            chart.chartCursor.addListener("selected", $entry(function (event) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.CursorEventHandler::onEvent(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsCursorEvent;)(event);
            }));
        }
    }-*/;

    public void addCursorZoomHandler(CursorEventHandler cursorZoomHandler) {
        addCursorZoomHandler(chart, cursorZoomHandler);
    }

    private native static void addCursorZoomHandler(JavaScriptObject chart, CursorEventHandler handler) /*-{
        if (chart.chartCursor) {
            chart.chartCursor.addListener("zoomed", $entry(function (event) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.CursorEventHandler::onEvent(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsCursorEvent;)(event);
            }));
        }
    }-*/;

    public void addAxisZoomHandler(AxisZoomHandler axisZoomHandler) {
        addAxisZoomHandler(chart, axisZoomHandler);
    }

    private native static void addAxisZoomHandler(JavaScriptObject chart, AxisZoomHandler handler) /*-{
        if (chart.valueAxes) {
            for (var i = 0; i < chart.valueAxes.length; i++) {
                var axis = chart.valueAxes[i];
                (function () {
                    // store axisId in function scope, prevent reference on mutable variable
                    var axisId = axis.id;
                    axis.addListener("axisZoomed", $entry(function (event) {
                        var axisEvent = {};
                        axisEvent.startValue = event.startValue;
                        axisEvent.endValue = event.endValue;
                        axisEvent.axisId = axisId;

                        handler.@com.haulmont.charts.web.toolkit.ui.client.amcharts.events.AxisZoomHandler::onZoom(Lcom/haulmont/charts/web/toolkit/ui/client/amcharts/events/JsAxisZoomedEvent;)(axisEvent);
                    }));
                })();
            }
        }
    }-*/;

    public void zoomOut() {
        zoomOut(chart);
    }

    private native static void zoomOut(JavaScriptObject chart) /*-{
        chart.zoomOut();
    }-*/;

    public void zoomToIndexes(int start, int end) {
        zoomToIndexes(chart, start, end);
    }

    private native static void zoomToIndexes(JavaScriptObject chart, int start, int end) /*-{
        chart.zoomToIndexes(start, end);
    }-*/;

    public void zoomToDates(JsDate start, JsDate end) {
        zoomToDates(chart, start, end);
    }

    private native static void zoomToDates(JavaScriptObject chart, JsDate start, JsDate end) /*-{
        chart.zoomToDates(start, end);
    }-*/;
}