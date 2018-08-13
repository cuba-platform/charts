/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.amstockcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.json.client.JSONParser;
import com.haulmont.charts.web.widgets.amcharts.CubaAmStockChartScene;
import com.haulmont.charts.web.widgets.client.amcharts.MouseHelper;
import com.haulmont.cuba.web.widgets.client.JsDate;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;

import java.util.Set;

@Connect(CubaAmStockChartScene.class)
public class CubaAmStockChartSceneConnector extends AbstractComponentConnector {

    protected CubaAmStockChartServerRpc rpc = RpcProxy.create(CubaAmStockChartServerRpc.class, this);
    protected ElementResizeListener resizeListener;

    public CubaAmStockChartSceneConnector() {
        registerRpc(CubaAmStockChartSceneClientRpc.class, new CubaAmStockChartSceneClientRpc() {
            @Override
            public void draw(String chartJson) {
                drawChart(chartJson);
            }

            @Override
            public void updatePoints(final String json) {
                updateChart(json);
            }
        });
    }

    protected void drawChart(String chartJson) {
        final AmStockChartConfig config = AmStockChartConfig.fromServerConfig(chartJson, getState().json);
        final AmStockChartEvents amStockChartEvents = createEvents(config);

        Scheduler.get().scheduleDeferred(() -> {
            getWidget().init(config, amStockChartEvents);

            // Add resize listener lazily here.
            // If done in init like in examples it will be called way too early,
            // like before the widget is not even rendered yet
            if (resizeListener == null) {
                resizeListener = e -> getWidget().updateSize();

                getLayoutManager().addElementResizeListener(getWidget().getElement(), resizeListener);
            }
        });
    }

    protected void updateChart(String json) {
        Scheduler.get().scheduleDeferred(() ->
                getWidget().updatePoints(getJsonAsObject(json)));
    }

    protected JavaScriptObject getJsonAsObject(String json) {
        return JSONParser.parseLenient(json).isObject().getJavaScriptObject();
    }

    @Override
    public CubaAmStockChartSceneState getState() {
        return (CubaAmStockChartSceneState) super.getState();
    }

    @Override
    public CubaAmStockChartSceneWidget getWidget() {
        return (CubaAmStockChartSceneWidget) super.getWidget();
    }

    protected AmStockChartEvents createEvents(AmStockChartConfig config) {
        AmStockChartEvents amStockChartEvents = new AmStockChartEvents();
        Set<String> events = getState().registeredEventListeners;
        if (events != null) {

            bindClickEvents(amStockChartEvents, events);

            if (config.hasStockEvents()) {
                bindStockEventEvents(amStockChartEvents, events);
            }

            if (config.hasPeriodSelector()) {
                bindPeriodSelectorEvents(amStockChartEvents, events);
            }

            if (config.hasDataSetSelector()) {
                bindDataSetSelectorEvents(amStockChartEvents, events);
            }

            bindStockGraphEvents(amStockChartEvents, events);
            bindStockGraphItemEvents(amStockChartEvents, events);

            if (events.contains(CubaAmStockChartSceneState.STOCK_ZOOM_EVENT)) {
                amStockChartEvents.setStockPanelZoomHandler(event ->
                        rpc.onZoom(JsDate.toJava(event.getStartDate()), JsDate.toJava(event.getEndDate()), event.getPeriod())
                );
            }
        }

        return amStockChartEvents;
    }

    protected void bindClickEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.CHART_CLICK_EVENT)) {
            amStockChartEvents.setChartClickHandler(event ->
                    rpc.onChartClick(event.getX(), event.getY(),
                            event.getAbsoluteX(), event.getAbsoluteY())
            );
        }
        if (events.contains(CubaAmStockChartSceneState.CHART_RIGHT_CLICK_EVENT)) {
            amStockChartEvents.setChartRightClickHandler(event ->
                    rpc.onChartRightClick(event.getX(), event.getY(),
                            event.getAbsoluteX(), event.getAbsoluteY())
            );
        }
    }

    protected void bindStockEventEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.STOCK_EVENT_CLICK_EVENT)) {
            amStockChartEvents.setStockEventClickHandler(event ->
                    rpc.onStockEventClick(event.getGraphId(), JsDate.toJava(event.getDate()), event.getEventObjectId())
            );
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_EVENT_ROLL_OUT_EVENT)) {
            amStockChartEvents.setStockEventRollOutHandler(event ->
                    rpc.onStockEventRollOut(event.getGraphId(), JsDate.toJava(event.getDate()), event.getEventObjectId())
            );
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_EVENT_ROLL_OVER_EVENT)) {
            amStockChartEvents.setStockEventRollOverHandler(event ->
                    rpc.onStockEventRollOver(event.getGraphId(), JsDate.toJava(event.getDate()), event.getEventObjectId())
            );
        }
    }

    protected void bindPeriodSelectorEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.PERIOD_SELECTOR_CHANGE_EVENT)) {
            amStockChartEvents.setPeriodSelectorChangeHandler(event -> {
                NativeEvent me = event.getMouseEvent();
                rpc.onPeriodSelectorChange(JsDate.toJava(event.getStartDate()), JsDate.toJava(event.getEndDate()),
                        event.getPredefinedPeriod(), event.getCount(), MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }
    }

    protected void bindDataSetSelectorEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.DATA_SET_SELECTOR_COMPARE_EVENT)) {
            amStockChartEvents.setDataSetSelectorCompareHandler(event ->
                    rpc.onDataSetSelectorCompare(event.getDataSetId())
            );
        }

        if (events.contains(CubaAmStockChartSceneState.DATA_SET_SELECTOR_SELECT_EVENT)) {
            amStockChartEvents.setDataSetSelectorSelectHandler(event ->
                    rpc.onDataSetSelectorSelect(event.getDataSetId())
            );
        }

        if (events.contains(CubaAmStockChartSceneState.DATA_SET_SELECTOR_UNCOMPARE_EVENT)) {
            amStockChartEvents.setDataSetSelectorUnCompareHandler(event ->
                    rpc.onDataSetSelectorUnCompare(event.getDataSetId())
            );
        }
    }

    protected void bindStockGraphEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_CLICK_EVENT)) {
            amStockChartEvents.setStockGraphClickHandler(event -> {
                NativeEvent me = event.getMouseEvent();
                rpc.onStockGraphClick(event.getPanelId(), event.getGraphId(), MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ROLL_OUT_EVENT)) {
            amStockChartEvents.setStockGraphRollOutHandler(event -> {
                NativeEvent me = event.getMouseEvent();
                rpc.onStockGraphRollOut(event.getPanelId(), event.getGraphId(), MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ROLL_OVER_EVENT)) {
            amStockChartEvents.setStockGraphRollOverHandler(event -> {
                NativeEvent me = event.getMouseEvent();
                rpc.onStockGraphRollOver(event.getPanelId(), event.getGraphId(), MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }
    }

    protected void bindStockGraphItemEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_CLICK_EVENT)) {
            amStockChartEvents.setStockGraphItemClickHandler(event -> {
                NativeEvent me = event.getMouseEvent();
                rpc.onStockGraphItemClick(event.getPanelId(), event.getGraphId(), event.getIndex(), event.getDataSetId(), event.getItemKey(),
                        MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_RIGHT_CLICK_EVENT)) {
            amStockChartEvents.setStockGraphItemRightClickHandler(event -> {
                NativeEvent me = event.getMouseEvent();
                rpc.onStockGraphItemRightClick(event.getPanelId(), event.getGraphId(), event.getIndex(), event.getDataSetId(), event.getItemKey(),
                        MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_ROLL_OUT_EVENT)) {
            amStockChartEvents.setStockGraphItemRollOutHandler(event -> {
                NativeEvent me = event.getMouseEvent();
                rpc.onStockGraphItemRollOut(event.getPanelId(), event.getGraphId(), event.getIndex(), event.getDataSetId(), event.getItemKey(),
                        MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_ROLL_OVER_EVENT)) {
            amStockChartEvents.setStockGraphItemRollOverHandler(event -> {
                NativeEvent me = event.getMouseEvent();
                rpc.onStockGraphItemRollOver(event.getPanelId(), event.getGraphId(), event.getIndex(), event.getDataSetId(), event.getItemKey(),
                        MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }
    }
}