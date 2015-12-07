/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.*;

/**
 * @author gorelov
 * @version $Id$
 */
public class CubaAmStockChartJsOverlay {
    private static boolean ready = false;

    private JavaScriptObject chart;

    public CubaAmStockChartJsOverlay(JavaScriptObject chart) {
        this.chart = chart;
    }

    public static CubaAmStockChartJsOverlay makeChart(Element placeHolder, JavaScriptObject json) {
        if (!ready) {
            handleLoad();
            ready = true;
        }

        return new CubaAmStockChartJsOverlay(makeJsChart(placeHolder, json));
    }

    private static native void handleLoad() /*-{
        $wnd.AmCharts.handleLoad();
    }-*/;

    private static native JavaScriptObject makeJsChart(Element placeHolder, JavaScriptObject json) /*-{
        var chart = $wnd.AmCharts.makeChart(placeHolder, json);
        return chart;
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

    public JsStockChartClickEvent getClickEvent(int x, int y, int absoluteX, int absoluteY) {
        return getClickEvent(chart, x, y, absoluteX, absoluteY);
    }

    private static native JsStockChartClickEvent getClickEvent(JavaScriptObject chart, int x, int y, int absoluteX, int absoluteY) /*-{
        var event = {};
        event.x = x;
        event.y = y;
        event.absoluteX = absoluteX;
        event.absoluteY = absoluteY;

        return event;
    }-*/;

    public void addStockEventClickHandler(StockEventClickHandler handler) {
        addStockEventClickHandler(chart, handler);
    }

    private static native void addStockEventClickHandler(JavaScriptObject chart, StockEventClickHandler handler) /*-{
        chart.addListener("clickStockEvent", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockEventClickHandler::onClick(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockEventClickEvent;)(event);
        }));
    }-*/;

    public void addStockEventRollOutHandler(StockEventRollOutHandler handler) {
        addStockEventRollOutHandler(chart, handler);
    }

    private static native void addStockEventRollOutHandler(JavaScriptObject chart, StockEventRollOutHandler handler) /*-{
        chart.addListener("rollOutStockEvent", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockEventRollOutHandler::onRollOut(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockEventRollOutEvent;)(event);
        }));
    }-*/;

    public void addStockEventRollOverHandler(StockEventRollOverHandler handler) {
        addStockEventRollOverHandler(chart, handler);
    }

    private static native void addStockEventRollOverHandler(JavaScriptObject chart, StockEventRollOverHandler handler) /*-{
        chart.addListener("rollOverStockEvent", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockEventRollOverHandler::onRollOver(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockEventRollOverEvent;)(event);
        }));
    }-*/;

    public void addStockPanelZoomHandler(StockPanelZoomHandler handler) {
        addStockZoomHandler(chart, handler);
    }

    private static native void addStockZoomHandler(JavaScriptObject chart, StockPanelZoomHandler handler) /*-{
        chart.addListener("zoomed", $entry(function (event) {
            handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockPanelZoomHandler::onZoom(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockPanelZoomEvent;)(event);
        }));
    }-*/;

    public void addPeriodSelectorChangeHandler(PeriodSelectorChangeHandler handler) {
        addPeriodSelectorChangeHandler(chart, handler);
    }

    private static native void addPeriodSelectorChangeHandler(JavaScriptObject chart, PeriodSelectorChangeHandler handler) /*-{
        if (chart.periodSelector) {
            chart.periodSelector.addListener("changed", $entry(function (event) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.PeriodSelectorChangeHandler::onChange(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsPeriodSelectorChangeEvent;)(event);
            }));
        }
    }-*/;

    public void addDataSetSelectorCompareHandler(DataSetSelectorCompareHandler handler) {
        addDataSetSelectorCompareHandler(chart, handler);
    }

    private static native void addDataSetSelectorCompareHandler(JavaScriptObject chart, DataSetSelectorCompareHandler handler) /*-{
        if (chart.dataSetSelector) {
            chart.dataSetSelector.addListener("dataSetCompared", $entry(function (event) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.DataSetSelectorCompareHandler::onCompare(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsDataSetSelectorCompareEvent;)(event);
            }));
        }
    }-*/;

    public void addDataSetSelectorSelectHandler(DataSetSelectorSelectHandler handler) {
        addDataSetSelectorSelectHandler(chart, handler);
    }

    private static native void addDataSetSelectorSelectHandler(JavaScriptObject chart, DataSetSelectorSelectHandler handler) /*-{
        if (chart.dataSetSelector) {
            chart.dataSetSelector.addListener("dataSetSelected", $entry(function (event) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.DataSetSelectorSelectHandler::onSelect(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsDataSetSelectorSelectEvent;)(event);
            }));
        }
    }-*/;

    public void addDataSetSelectorUnCompareHandler(DataSetSelectorUnCompareHandler handler) {
        addDataSetSelectorUnCompareHandler(chart, handler);
    }

    private static native void addDataSetSelectorUnCompareHandler(JavaScriptObject chart, DataSetSelectorUnCompareHandler handler) /*-{
        if (chart.dataSetSelector) {
            chart.dataSetSelector.addListener("dataSetUncompared", $entry(function (event) {
                handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.DataSetSelectorUnCompareHandler::onUnCompare(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsDataSetSelectorUnCompareEvent;)(event);
            }));
        }
    }-*/;

    public void addStockGraphClickHandler(StockGraphClickHandler handler) {
        addStockGraphClickHandler(chart, handler);
    }

    private static native void addStockGraphClickHandler(JavaScriptObject chart, StockGraphClickHandler handler) /*-{
        if (chart.panels) {
            for (var i = 0; i < chart.panels.length; i++) {
                chart.panels[i].addListener("clickGraph", $entry(function (event) {
                    handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockGraphClickHandler::onClick(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockGraphClickEvent;)(event);
                }));
            }
        }
    }-*/;

    public void addStockGraphRollOutHandler(StockGraphRollOutHandler handler) {
        addStockGraphRollOutHandler(chart, handler);
    }

    private static native void addStockGraphRollOutHandler(JavaScriptObject chart, StockGraphRollOutHandler handler) /*-{
        if (chart.panels) {
            for (var i = 0; i < chart.panels.length; i++) {
                chart.panels[i].addListener("rollOutGraph", $entry(function (event) {
                    handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockGraphRollOutHandler::onRollOut(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockGraphRollOutEvent;)(event);
                }));
            }
        }
    }-*/;

    public void addStockGraphRollOverHandler(StockGraphRollOverHandler handler) {
        addStockGraphRollOverHandler(chart, handler);
    }

    private static native void addStockGraphRollOverHandler(JavaScriptObject chart, StockGraphRollOverHandler handler) /*-{
        if (chart.panels) {
            for (var i = 0; i < chart.panels.length; i++) {
                chart.panels[i].addListener("rollOverGraph", $entry(function (event) {
                    handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockGraphRollOverHandler::onRollOver(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockGraphRollOverEvent;)(event);
                }));
            }
        }
    }-*/;

    public void addStockGraphItemClickHandler(StockGraphItemClickHandler handler) {
        addStockGraphItemClickHandler(chart, handler);
    }

    private static native void addStockGraphItemClickHandler(JavaScriptObject chart, StockGraphItemClickHandler handler) /*-{
        if (chart.panels) {
            for (var i = 0; i < chart.panels.length; i++) {
                chart.panels[i].addListener("clickGraphItem", $entry(function (event) {
                    handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockGraphItemClickHandler::onClick(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockGraphItemClickEvent;)(event);
                }));
            }
        }
    }-*/;

    public void addStockGraphItemRightClickHandler(StockGraphItemRightClickHandler handler) {
        addStockGraphItemRightClickHandler(chart, handler);
    }

    private static native void addStockGraphItemRightClickHandler(JavaScriptObject chart, StockGraphItemRightClickHandler handler) /*-{
        if (chart.panels) {
            for (var i = 0; i < chart.panels.length; i++) {
                chart.panels[i].addListener("rightClickGraphItem", $entry(function (event) {
                    handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockGraphItemRightClickHandler::onClick(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockGraphItemRightClickEvent;)(event);
                }));
            }
        }
    }-*/;

    public void addStockGraphItemRollOutHandler(StockGraphItemRollOutHandler handler) {
        addStockGraphItemRollOutHandler(chart, handler);
    }

    private static native void addStockGraphItemRollOutHandler(JavaScriptObject chart, StockGraphItemRollOutHandler handler) /*-{
        if (chart.panels) {
            for (var i = 0; i < chart.panels.length; i++) {
                chart.panels[i].addListener("rollOutGraphItem", $entry(function (event) {
                    handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockGraphItemRollOutHandler::onRollOut(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockGraphItemRollOutEvent;)(event);
                }));
            }
        }
    }-*/;

    public void addStockGraphItemRollOverHandler(StockGraphItemRollOverHandler handler) {
        addStockGraphItemRollOverHandler(chart, handler);
    }

    private static native void addStockGraphItemRollOverHandler(JavaScriptObject chart, StockGraphItemRollOverHandler handler) /*-{
        if (chart.panels) {
            for (var i = 0; i < chart.panels.length; i++) {
                chart.panels[i].addListener("rollOverGraphItem", $entry(function (event) {
                    handler.@com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockGraphItemRollOverHandler::onRollOver(Lcom/haulmont/charts/web/toolkit/ui/client/amstockcharts/events/JsStockGraphItemRollOverEvent;)(event);
                }));
            }
        }
    }-*/;
}
