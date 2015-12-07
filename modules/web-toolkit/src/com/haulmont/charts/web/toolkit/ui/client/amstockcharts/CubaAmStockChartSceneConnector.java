/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.NativeEvent;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.MouseHelper;
import com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.*;
import com.haulmont.cuba.web.toolkit.ui.client.JsDate;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;

import java.util.Set;

/**
 * @author gorelov
 * @version $Id$
 */
@Connect(CubaAmStockChartScene.class)
public class CubaAmStockChartSceneConnector extends AbstractComponentConnector {

    protected CubaAmStockChartServerRpc rpc = RpcProxy.create(CubaAmStockChartServerRpc.class, this);
    protected ElementResizeListener resizeListener;

    @Override
    public CubaAmStockChartSceneState getState() {
        return (CubaAmStockChartSceneState) super.getState();
    }

    @Override
    public CubaAmStockChartSceneWidget getWidget() {
        return (CubaAmStockChartSceneWidget) super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        final AmStockChartConfig config = AmStockChartConfig.fromServerConfig(getState().configuration, getState().json);
        final AmStockChartEvents amStockChartEvents = createEvents(config);

        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                getWidget().init(config, amStockChartEvents);

                // Add resize listener lazily here.
                // If done in init like in examples it will be called way too early,
                // like before the widget is not even rendered yet
                if (resizeListener == null) {
                    resizeListener = new ElementResizeListener() {

                        @Override
                        public void onElementResize(ElementResizeEvent e) {
                            getWidget().updateSize();
                        }
                    };

                    getLayoutManager().addElementResizeListener(getWidget().getElement(), resizeListener);
                }
            }
        });
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
                amStockChartEvents.setStockPanelZoomHandler(new StockPanelZoomHandler() {
                    @Override
                    public void onZoom(JsStockPanelZoomEvent event) {
                        rpc.onZoom(JsDate.toJava(event.getStartDate()), JsDate.toJava(event.getEndDate()), event.getPeriod());
                    }
                });
            }
        }

        return amStockChartEvents;
    }

    protected void bindClickEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.CHART_CLICK_EVENT)) {
            amStockChartEvents.setChartClickHandler(new StockChartClickHandler() {
                @Override
                public void onClick(JsStockChartClickEvent event) {
                    rpc.onChartClick(event.getX(), event.getY(),
                            event.getAbsoluteX(), event.getAbsoluteY());
                }
            });
        }
        if (events.contains(CubaAmStockChartSceneState.CHART_RIGHT_CLICK_EVENT)) {
            amStockChartEvents.setChartRightClickHandler(new StockChartClickHandler() {
                @Override
                public void onClick(JsStockChartClickEvent event) {
                    rpc.onChartRightClick(event.getX(), event.getY(),
                            event.getAbsoluteX(), event.getAbsoluteY());
                }
            });
        }
    }

    protected void bindStockEventEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.STOCK_EVENT_CLICK_EVENT)) {
            amStockChartEvents.setStockEventClickHandler(new StockEventClickHandler() {
                @Override
                public void onClick(JsStockEventClickEvent event) {
                    rpc.onStockEventClick(event.getGraphId(), JsDate.toJava(event.getDate()), event.getEventObjectId());
                }
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_EVENT_ROLL_OUT_EVENT)) {
            amStockChartEvents.setStockEventRollOutHandler(new StockEventRollOutHandler() {
                @Override
                public void onRollOut(JsStockEventRollOutEvent event) {
                    rpc.onStockEventRollOut(event.getGraphId(), JsDate.toJava(event.getDate()), event.getEventObjectId());
                }
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_EVENT_ROLL_OVER_EVENT)) {
            amStockChartEvents.setStockEventRollOverHandler(new StockEventRollOverHandler() {
                @Override
                public void onRollOver(JsStockEventRollOverEvent event) {
                    rpc.onStockEventRollOver(event.getGraphId(), JsDate.toJava(event.getDate()), event.getEventObjectId());
                }
            });
        }
    }

    protected void bindPeriodSelectorEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.PERIOD_SELECTOR_CHANGE_EVENT)) {
            amStockChartEvents.setPeriodSelectorChangeHandler(new PeriodSelectorChangeHandler() {
                @Override
                public void onChange(JsPeriodSelectorChangeEvent event) {
                    NativeEvent me = event.getMouseEvent();
                    rpc.onPeriodSelectorChange(JsDate.toJava(event.getStartDate()), JsDate.toJava(event.getEndDate()),
                            event.getPredefinedPeriod(), event.getCount(), MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }
    }

    protected void bindDataSetSelectorEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.DATA_SET_SELECTOR_COMPARE_EVENT)) {
            amStockChartEvents.setDataSetSelectorCompareHandler(new DataSetSelectorCompareHandler() {
                @Override
                public void onCompare(JsDataSetSelectorCompareEvent event) {
                    rpc.onDataSetSelectorCompare(event.getDataSetId());
                }
            });
        }

        if (events.contains(CubaAmStockChartSceneState.DATA_SET_SELECTOR_SELECT_EVENT)) {
            amStockChartEvents.setDataSetSelectorSelectHandler(new DataSetSelectorSelectHandler() {
                @Override
                public void onSelect(JsDataSetSelectorSelectEvent event) {
                    rpc.onDataSetSelectorSelect(event.getDataSetId());
                }
            });
        }

        if (events.contains(CubaAmStockChartSceneState.DATA_SET_SELECTOR_UNCOMPARE_EVENT)) {
            amStockChartEvents.setDataSetSelectorUnCompareHandler(new DataSetSelectorUnCompareHandler() {
                @Override
                public void onUnCompare(JsDataSetSelectorUnCompareEvent event) {
                    rpc.onDataSetSelectorUnCompare(event.getDataSetId());
                }
            });
        }
    }

    protected void bindStockGraphEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_CLICK_EVENT)) {
            amStockChartEvents.setStockGraphClickHandler(new StockGraphClickHandler() {
                @Override
                public void onClick(JsStockGraphClickEvent event) {
                    NativeEvent me = event.getMouseEvent();
                    rpc.onStockGraphClick(event.getPanelId(), event.getGraphId(), MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ROLL_OUT_EVENT)) {
            amStockChartEvents.setStockGraphRollOutHandler(new StockGraphRollOutHandler() {
                @Override
                public void onRollOut(JsStockGraphRollOutEvent event) {
                    NativeEvent me = event.getMouseEvent();
                    rpc.onStockGraphRollOut(event.getPanelId(), event.getGraphId(), MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ROLL_OVER_EVENT)) {
            amStockChartEvents.setStockGraphRollOverHandler(new StockGraphRollOverHandler() {
                @Override
                public void onRollOver(JsStockGraphRollOverEvent event) {
                    NativeEvent me = event.getMouseEvent();
                    rpc.onStockGraphRollOver(event.getPanelId(), event.getGraphId(), MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }
    }

    protected void bindStockGraphItemEvents(AmStockChartEvents amStockChartEvents, Set<String> events) {
        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_CLICK_EVENT)) {
            amStockChartEvents.setStockGraphItemClickHandler(new StockGraphItemClickHandler() {
                @Override
                public void onClick(JsStockGraphItemClickEvent event) {
                    NativeEvent me = event.getMouseEvent();
                    rpc.onStockGraphItemClick(event.getPanelId(), event.getGraphId(), event.getIndex(), event.getItemId(),
                            MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_RIGHT_CLICK_EVENT)) {
            amStockChartEvents.setStockGraphItemRightClickHandler(new StockGraphItemRightClickHandler() {
                @Override
                public void onClick(JsStockGraphItemRightClickEvent event) {
                    NativeEvent me = event.getMouseEvent();
                    rpc.onStockGraphItemRightClick(event.getPanelId(), event.getGraphId(), event.getIndex(), event.getItemId(),
                            MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_ROLL_OUT_EVENT)) {
            amStockChartEvents.setStockGraphItemRollOutHandler(new StockGraphItemRollOutHandler() {
                @Override
                public void onRollOut(JsStockGraphItemRollOutEvent event) {
                    NativeEvent me = event.getMouseEvent();
                    rpc.onStockGraphItemRollOut(event.getPanelId(), event.getGraphId(), event.getIndex(), event.getItemId(),
                            MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }

        if (events.contains(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_ROLL_OVER_EVENT)) {
            amStockChartEvents.setStockGraphItemRollOverHandler(new StockGraphItemRollOverHandler() {
                @Override
                public void onRollOver(JsStockGraphItemRollOverEvent event) {
                    NativeEvent me = event.getMouseEvent();
                    rpc.onStockGraphItemRollOver(event.getPanelId(), event.getGraphId(), event.getIndex(), event.getItemId(),
                            MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }
    }
}
