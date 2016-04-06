/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.json.client.JSONParser;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.events.*;
import com.haulmont.cuba.web.toolkit.ui.client.JsDate;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;

import java.util.Date;
import java.util.Set;

/**
 */
@Connect(CubaAmchartsScene.class)
public class CubaAmchartsSceneConnector extends AbstractComponentConnector {

    protected CubaAmchartsServerRpc rpc = RpcProxy.create(CubaAmchartsServerRpc.class, this);
    protected ElementResizeListener resizeListener;

    public CubaAmchartsSceneConnector() {
             registerRpc(CubaAmchartsSceneClientRpc.class, new CubaAmchartsSceneClientRpc() {
                 @Override
                 public void updatePoints(final String json) {
                     Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                         @Override
                         public void execute() {
                             getWidget().updatePoints(getJsonAsObject(json));
                         }
                     });
                 }

                 @Override
                 public void zoomOut() {
                     getWidget().zoomOut();
                 }

                 @Override
                 public void zoomToIndexes(int start, int end) {
                     getWidget().zoomToIndexes(start, end);
                 }

                 @Override
                 public void zoomToDates(Date start, Date end) {
                     getWidget().zoomToDates(JsDate.toJs(start), JsDate.toJs(end));
                 }
             });
    }

    protected JavaScriptObject getJsonAsObject(String json) {
        return JSONParser.parseLenient(json).isObject().getJavaScriptObject();
    }

    @Override
    public CubaAmchartsSceneState getState() {
        return (CubaAmchartsSceneState) super.getState();
    }

    @Override
    public CubaAmchartsSceneWidget getWidget() {
        return (CubaAmchartsSceneWidget) super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        final AmchartsConfig config = AmchartsConfig.fromServerConfig(getState().configuration, getState().json);
        final AmchartsEvents amchartsEvents = createEvents(config);

        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                getWidget().init(config, amchartsEvents);

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

    @Override
    public void onUnregister() {
        super.onUnregister();
        resetMouseOver();
    }

    private static native void resetMouseOver() /*-{
        $wnd.AmCharts.resetMouseOver();
    }-*/;

    protected AmchartsEvents createEvents(AmchartsConfig config) {
        AmchartsEvents amchartsEvents = new AmchartsEvents();
        Set<String> events = getState().registeredEventListeners;
        if (events != null) {
            bindClickEvents(amchartsEvents, events);

            String chartType = config.getChartType();
            if ("xy".equals(chartType) || "radar".equals(chartType) || "serial".equals(chartType)) {
                bindCoordinateChartEvents(amchartsEvents, events);
            }
            if ("serial".equals(chartType)) {
                bindSerialChartEvents(amchartsEvents, events);
            }
            if ("pie".equals(chartType) || "funnel".equals(chartType)) {
                bindSlicedChartEvents(amchartsEvents, events);
            }
            if (config.hasLegend()) {
                bindLegendEvents(amchartsEvents, events);
            }
            if (("xy".equals(chartType) || "serial".equals(chartType)) && config.hasCursor()) {
                bindCursorEvents(amchartsEvents, events);
            }
            if ("xy".equals(chartType)) {
                bindXYChartEvents(amchartsEvents, events);
            }
        }
        return amchartsEvents;
    }

    protected void bindClickEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.CHART_CLICK_EVENT)) {
            amchartsEvents.setChartClickHandler(new ChartClickHandler() {
                @Override
                public void onClick(JsChartClickEvent event) {
                    rpc.onChartClick(event.getX(), event.getY(),
                            event.getAbsoluteX(), event.getAbsoluteY(), event.getXAxis(), event.getYAxis());
                }
            });
        }
        if (events.contains(CubaAmchartsSceneState.CHART_RIGHT_CLICK_EVENT)) {
            amchartsEvents.setChartRightClickHandler(new ChartClickHandler() {
                @Override
                public void onClick(JsChartClickEvent event) {
                    rpc.onChartRightClick(event.getX(), event.getY(),
                            event.getAbsoluteX(), event.getAbsoluteY(), event.getXAxis(), event.getYAxis());
                }
            });
        }
    }

    protected void bindXYChartEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.VALUE_AXIS_ZOOM_EVENT)) {
            amchartsEvents.setAxisZoomHandler(new AxisZoomHandler() {
                @Override
                public void onZoom(JsAxisZoomedEvent event) {
                    rpc.onValueAxisZoom(event.getAxisId(), event.getStartValue(), event.getEndValue());
                }
            });
        }
    }

    protected void bindCursorEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.CURSOR_ZOOM_EVENT)) {
            amchartsEvents.setCursorZoomHandler(new CursorEventHandler() {
                @Override
                public void onEvent(JsCursorEvent event) {
                    rpc.onCursorZoom(event.getStart(), event.getEnd());
                }
            });
        }
        if (events.contains(CubaAmchartsSceneState.CURSOR_PERIOD_SELECT_EVENT)) {
            amchartsEvents.setCursorPeriodSelectHandler(new CursorEventHandler() {
                @Override
                public void onEvent(JsCursorEvent event) {
                    rpc.onCursorPeriodSelect(event.getStart(), event.getEnd());
                }
            });
        }
    }

    protected void bindLegendEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.LEGEND_LABEL_CLICK_EVENT)) {
            amchartsEvents.setLegendLabelClickHandler(new LegendEventHandler() {
                @Override
                public void onEvent(JsLegendEvent event) {
                    rpc.onLegendLabelClick(event.getItemId());
                }
            });
        }
        if (events.contains(CubaAmchartsSceneState.LEGEND_MARKER_CLICK_EVENT)) {
            amchartsEvents.setLegendMarkerClickHandler(new LegendEventHandler() {
                @Override
                public void onEvent(JsLegendEvent event) {
                    rpc.onLegendMarkerClick(event.getItemId());
                }
            });
        }
        if (events.contains(CubaAmchartsSceneState.LEGEND_ITEM_SHOW_EVENT)) {
            amchartsEvents.setLegendItemShowHandler(new LegendEventHandler() {
                @Override
                public void onEvent(JsLegendEvent event) {
                    rpc.onLegendItemShow(event.getItemId());
                }
            });
        }
        if (events.contains(CubaAmchartsSceneState.LEGEND_ITEM_HIDE_EVENT)) {
            amchartsEvents.setLegendItemHideHandler(new LegendEventHandler() {
                @Override
                public void onEvent(JsLegendEvent event) {
                    rpc.onLegendItemHide(event.getItemId());
                }
            });
        }
    }

    protected void bindSlicedChartEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.SLICE_CLICK_EVENT)) {
            amchartsEvents.setSliceClickHandler(new SliceClickHandler() {
                @Override
                public void onEvent(JsSliceClickEvent event) {
                    NativeEvent me = event.getMouseEvent();

                    rpc.onSliceClick(event.getSliceId(), MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }
        if (events.contains(CubaAmchartsSceneState.SLICE_RIGHT_CLICK_EVENT)) {
            amchartsEvents.setSliceRightClickHandler(new SliceClickHandler() {
                @Override
                public void onEvent(JsSliceClickEvent event) {
                    NativeEvent me = event.getMouseEvent();

                    rpc.onSliceRightClick(event.getSliceId(), MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }
        if (events.contains(CubaAmchartsSceneState.SLICE_PULL_IN_EVENT)) {
            amchartsEvents.setSlicePullInHandler(new SlicePullHandler() {
                @Override
                public void onEvent(JsSlicePullEvent event) {
                    rpc.onSlicePullIn(event.getSliceId());
                }
            });
        }
        if (events.contains(CubaAmchartsSceneState.SLICE_PULL_OUT_EVENT)) {
            amchartsEvents.setSlicePullOutHandler(new SlicePullHandler() {
                @Override
                public void onEvent(JsSlicePullEvent event) {
                    rpc.onSlicePullOut(event.getSliceId());
                }
            });
        }
    }

    protected void bindSerialChartEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.ZOOM_EVENT)) {
            amchartsEvents.setZoomHandler(new ZoomHandler() {
                @Override
                public void onZoom(JsZoomEvent event) {
                    rpc.onZoom(event.getStartIndex(), event.getEndIndex(),
                            JsDate.toJava(event.getStartDate()), JsDate.toJava(event.getEndDate()),
                            event.getStartValue(), event.getEndValue());
                }
            });
        }
    }

    protected void bindCoordinateChartEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.GRAPH_CLICK_EVENT)) {
            amchartsEvents.setGraphClickHandler(new GraphClickHandler() {
                @Override
                public void onClick(JsGraphClickEvent event) {
                    NativeEvent me = event.getMouseEvent();

                    rpc.onGraphClick(event.getGraphId(), MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }
        if (events.contains(CubaAmchartsSceneState.GRAPH_ITEM_CLICK_EVENT)) {
            amchartsEvents.setGraphItemClickHandler(new GraphItemClickHandler() {
                @Override
                public void onClick(JsGraphItemClickEvent event) {
                    NativeEvent me = event.getMouseEvent();

                    rpc.onGraphItemClick(event.getGraphId(), event.getIndex(), event.getItemId(),
                            MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }
        if (events.contains(CubaAmchartsSceneState.GRAPH_ITEM_RIGHT_CLICK_EVENT)) {
            amchartsEvents.setGraphItemRightClickHandler(new GraphItemClickHandler() {
                @Override
                public void onClick(JsGraphItemClickEvent event) {
                    NativeEvent me = event.getMouseEvent();

                    rpc.onGraphItemRightClick(event.getGraphId(), event.getIndex(), event.getItemId(),
                            MouseHelper.getX(me), MouseHelper.getY(me),
                            me.getClientX(), me.getClientY());
                }
            });
        }
    }
}