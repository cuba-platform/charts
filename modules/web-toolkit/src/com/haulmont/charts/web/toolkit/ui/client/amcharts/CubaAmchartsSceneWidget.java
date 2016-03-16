/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.events.ChartClickHandler;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.events.JsChartClickEvent;

/**
 */
public class CubaAmchartsSceneWidget extends Widget {

    protected CubaAmchartsJsOverlay jsOverlay;

    protected ChartClickHandler chartClickHandler;
    protected ChartClickHandler chartRightClickHandler;

    public CubaAmchartsSceneWidget() {
        setElement(Document.get().createDivElement());

        sinkEvents(Event.ONCONTEXTMENU | Event.ONCLICK);
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == Event.ONCONTEXTMENU) {
            if (chartRightClickHandler != null) {
                int x = MouseHelper.getX(event);
                int y = MouseHelper.getY(event);

                JsChartClickEvent clickEvent = jsOverlay.getClickEvent(x, y, event.getClientX(), event.getClientY());
                chartRightClickHandler.onClick(clickEvent);
            }

            event.preventDefault();
        }
        if (event.getTypeInt() == Event.ONCLICK && chartClickHandler != null) {
            int x = MouseHelper.getX(event);
            int y = MouseHelper.getY(event);

            JsChartClickEvent clickEvent = jsOverlay.getClickEvent(x, y, event.getClientX(), event.getClientY());
            chartClickHandler.onClick(clickEvent);

            event.preventDefault();
        }

        super.onBrowserEvent(event);
    }

    public void updateSize() {
        if (jsOverlay != null) {
            jsOverlay.updateSize();
        }
    }

    public void init(AmchartsConfig config, AmchartsEvents amchartsEvents) {
        if (jsOverlay != null) {
            jsOverlay.destroy();
        }

        jsOverlay = CubaAmchartsJsOverlay.makeChart(getElement(), config);

        if (amchartsEvents.getChartClickHandler() != null) {
            this.chartClickHandler = amchartsEvents.getChartClickHandler();
        }
        if (amchartsEvents.getChartRightClickHandler() != null) {
            this.chartRightClickHandler = amchartsEvents.getChartRightClickHandler();
        }
        if (amchartsEvents.getGraphClickHandler() != null) {
            jsOverlay.addGraphClickHandler(amchartsEvents.getGraphClickHandler());
        }
        if (amchartsEvents.getGraphItemClickHandler() != null) {
            jsOverlay.addGraphItemClickHandler(amchartsEvents.getGraphItemClickHandler());
        }
        if (amchartsEvents.getGraphItemRightClickHandler() != null) {
            jsOverlay.addGraphItemRightClickHandler(amchartsEvents.getGraphItemRightClickHandler());
        }
        if (amchartsEvents.getZoomHandler() != null) {
            jsOverlay.addZoomHandler(amchartsEvents.getZoomHandler());
        }
        if (amchartsEvents.getSliceClickHandler() != null) {
            jsOverlay.addSliceClickHandler(amchartsEvents.getSliceClickHandler());
        }
        if (amchartsEvents.getSliceRightClickHandler() != null) {
            jsOverlay.addSliceRightClickHandler(amchartsEvents.getSliceRightClickHandler());
        }
        if (amchartsEvents.getSlicePullInHandler() != null) {
            jsOverlay.addSlicePullInHandler(amchartsEvents.getSlicePullInHandler());
        }
        if (amchartsEvents.getSlicePullOutHandler() != null) {
            jsOverlay.addSlicePullOutHandler(amchartsEvents.getSlicePullOutHandler());
        }
        if (amchartsEvents.getLegendLabelClickHandler() != null) {
            jsOverlay.addLegendLabelClickHandler(amchartsEvents.getLegendLabelClickHandler());
        }
        if (amchartsEvents.getLegendMarkerClickHandler() != null) {
            jsOverlay.addLegendMarkerClickHandler(amchartsEvents.getLegendMarkerClickHandler());
        }
        if (amchartsEvents.getLegendItemShowHandler() != null) {
            jsOverlay.addLegendItemShowHandler(amchartsEvents.getLegendItemShowHandler());
        }
        if (amchartsEvents.getLegendItemHideHandler() != null) {
            jsOverlay.addLegendItemHideHandler(amchartsEvents.getLegendItemHideHandler());
        }
        if (amchartsEvents.getCursorPeriodSelectHandler() != null) {
            jsOverlay.addCursorPeriodSelectHandler(amchartsEvents.getCursorPeriodSelectHandler());
        }
        if (amchartsEvents.getCursorZoomHandler() != null) {
            jsOverlay.addCursorZoomHandler(amchartsEvents.getCursorZoomHandler());
        }
        if (amchartsEvents.getAxisZoomHandler() != null) {
            jsOverlay.addAxisZoomHandler(amchartsEvents.getAxisZoomHandler());
        }

        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                updateSize();
            }
        });
    }

    public void updatePoints(JavaScriptObject jsObj) {
        jsOverlay.updatePoints(jsObj);
    }
}