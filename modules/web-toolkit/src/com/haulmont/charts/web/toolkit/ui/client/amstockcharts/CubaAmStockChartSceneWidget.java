/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.MouseHelper;
import com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.JsStockChartClickEvent;
import com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.StockChartClickHandler;

/**
 * @author gorelov
 * @version $Id$
 */
public class CubaAmStockChartSceneWidget extends Widget {

    protected CubaAmStockChartJsOverlay jsOverlay;

    protected StockChartClickHandler chartClickHandler;
    protected StockChartClickHandler chartRightClickHandler;

    public CubaAmStockChartSceneWidget() {
        setElement(Document.get().createDivElement());

        sinkEvents(Event.ONCONTEXTMENU | Event.ONCLICK);
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == Event.ONCONTEXTMENU) {
            if (chartRightClickHandler != null) {
                int x = MouseHelper.getX(event);
                int y = MouseHelper.getY(event);

                JsStockChartClickEvent clickEvent = jsOverlay.getClickEvent(x, y, event.getClientX(), event.getClientY());
                chartRightClickHandler.onClick(clickEvent);
            }

            event.preventDefault();
        }
        if (event.getTypeInt() == Event.ONCLICK && chartClickHandler != null) {
            int x = MouseHelper.getX(event);
            int y = MouseHelper.getY(event);

            JsStockChartClickEvent clickEvent = jsOverlay.getClickEvent(x, y, event.getClientX(), event.getClientY());
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

    public void init(AmStockChartConfig config, AmStockChartEvents amStockChartEvents) {
        if (jsOverlay != null) {
            jsOverlay.destroy();
        }

        jsOverlay = CubaAmStockChartJsOverlay.makeChart(getElement(), config);

        if (amStockChartEvents.getChartClickHandler() != null) {
            this.chartClickHandler = amStockChartEvents.getChartClickHandler();
        }
        if (amStockChartEvents.getChartRightClickHandler() != null) {
            this.chartRightClickHandler = amStockChartEvents.getChartRightClickHandler();
        }

        if (amStockChartEvents.getStockEventClickHandler() != null) {
            jsOverlay.addStockEventClickHandler(amStockChartEvents.getStockEventClickHandler());
        }

        if (amStockChartEvents.getStockEventRollOutHandler() != null) {
            jsOverlay.addStockEventRollOutHandler(amStockChartEvents.getStockEventRollOutHandler());
        }

        if (amStockChartEvents.getStockEventRollOverHandler() != null) {
            jsOverlay.addStockEventRollOverHandler(amStockChartEvents.getStockEventRollOverHandler());
        }

        if (amStockChartEvents.getStockZoomHandler() != null) {
            jsOverlay.addStockZoomHandler(amStockChartEvents.getStockZoomHandler());
        }

        if (amStockChartEvents.getPeriodSelectorChangeHandler() != null) {
            jsOverlay.addPeriodSelectorChangeHandler(amStockChartEvents.getPeriodSelectorChangeHandler());
        }

        if (amStockChartEvents.getDataSetSelectorCompareHandler() != null) {
            jsOverlay.addDataSetSelectorCompareHandler(amStockChartEvents.getDataSetSelectorCompareHandler());
        }

        if (amStockChartEvents.getDataSetSelectorSelectHandler() != null) {
            jsOverlay.addDataSetSelectorSelectHandler(amStockChartEvents.getDataSetSelectorSelectHandler());
        }

        if (amStockChartEvents.getDataSetSelectorUnCompareHandler() != null) {
            jsOverlay.addDataSetSelectorUnCompareHandler(amStockChartEvents.getDataSetSelectorUnCompareHandler());
        }

        if (amStockChartEvents.getStockGraphClickHandler() != null) {
            jsOverlay.addStockGraphClickHandler(amStockChartEvents.getStockGraphClickHandler());
        }

        if (amStockChartEvents.getStockGraphRollOutHandler() != null) {
            jsOverlay.addStockGraphRollOutHandler(amStockChartEvents.getStockGraphRollOutHandler());
        }

        if (amStockChartEvents.getStockGraphRollOverHandler() != null) {
            jsOverlay.addStockGraphRollOverHandler(amStockChartEvents.getStockGraphRollOverHandler());
        }

        if (amStockChartEvents.getStockGraphItemClickHandler() != null) {
            jsOverlay.addStockGraphItemClickHandler(amStockChartEvents.getStockGraphItemClickHandler());
        }

        if (amStockChartEvents.getStockGraphItemRightClickHandler() != null) {
            jsOverlay.addStockGraphItemRightClickHandler(amStockChartEvents.getStockGraphItemRightClickHandler());
        }

        if (amStockChartEvents.getStockGraphItemRollOutHandler() != null) {
            jsOverlay.addStockGraphItemRollOutHandler(amStockChartEvents.getStockGraphItemRollOutHandler());
        }

        if (amStockChartEvents.getStockGraphItemRollOverHandler() != null) {
            jsOverlay.addStockGraphItemRollOverHandler(amStockChartEvents.getStockGraphItemRollOverHandler());
        }

        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                updateSize();
            }
        });
    }
}
