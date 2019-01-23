/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.web.widgets.client.amstockcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.haulmont.charts.web.widgets.client.amcharts.MouseHelper;
import com.haulmont.charts.web.widgets.client.amstockcharts.events.JsStockChartClickEvent;

import java.util.function.Consumer;

public class CubaAmStockChartSceneWidget extends Widget {

    protected CubaAmStockChartJsOverlay jsOverlay;

    protected Consumer<JsStockChartClickEvent> chartClickHandler;
    protected Consumer<JsStockChartClickEvent> chartRightClickHandler;

    public CubaAmStockChartSceneWidget() {
        setElement(Document.get().createDivElement());
        setStyleName("c-amcharts-stockchart");

        sinkEvents(Event.ONCONTEXTMENU | Event.ONCLICK);
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == Event.ONCONTEXTMENU) {
            if (chartRightClickHandler != null) {
                int x = MouseHelper.getX(event);
                int y = MouseHelper.getY(event);

                JsStockChartClickEvent clickEvent = jsOverlay.getClickEvent(x, y, event.getClientX(), event.getClientY());
                chartRightClickHandler.accept(clickEvent);
            }

            event.preventDefault();
        }
        if (event.getTypeInt() == Event.ONCLICK && chartClickHandler != null) {
            int x = MouseHelper.getX(event);
            int y = MouseHelper.getY(event);

            JsStockChartClickEvent clickEvent = jsOverlay.getClickEvent(x, y, event.getClientX(), event.getClientY());
            chartClickHandler.accept(clickEvent);

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

        if (amStockChartEvents.getStockPanelZoomHandler() != null) {
            jsOverlay.addStockPanelZoomHandler(amStockChartEvents.getStockPanelZoomHandler());
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

        Scheduler.get().scheduleDeferred(
                this::updateSize
        );
    }

    public void updatePoints(JavaScriptObject jsObj) {
        jsOverlay.updatePoints(jsObj);
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        resetMouseOver();
    }

    private static native void resetMouseOver() /*-{
        $wnd.AmCharts.resetMouseOver();
    }-*/;
}