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
import com.haulmont.cuba.web.toolkit.ui.client.JsDate;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Connect(CubaAmchartsScene.class)
public class CubaAmchartsSceneConnector extends AbstractComponentConnector {

    protected CubaAmchartsServerRpc rpc = RpcProxy.create(CubaAmchartsServerRpc.class, this);
    protected ElementResizeListener resizeListener;

    protected boolean dataReady = false;
    protected List<Runnable> afterDataReady = new ArrayList<>();

    public CubaAmchartsSceneConnector() {
        registerRpc(CubaAmchartsSceneClientRpc.class, new CubaAmchartsSceneClientRpc() {
            @Override
            public void draw(String chartJson) {
                drawChart(chartJson);
            }

            @Override
            public void updatePoints(final String json) {
                updateChart(json);
            }

            @Override
            public void zoomOut() {
                Scheduler.get().scheduleDeferred(() -> {
                    if (dataReady) {
                        getWidget().zoomOut();
                    } else {
                        afterDataReady.add(() -> getWidget().zoomOut());
                    }
                });
            }

            @Override
            public void zoomToIndexes(int start, int end) {
                Scheduler.get().scheduleDeferred(() -> {
                    if (dataReady) {
                        getWidget().zoomToIndexes(start, end);
                    } else {
                        afterDataReady.add(() -> getWidget().zoomToIndexes(start, end));
                    }
                });
            }

            @Override
            public void zoomToDates(Date start, Date end) {
                Scheduler.get().scheduleDeferred(() -> {
                    if (dataReady) {
                        getWidget().zoomToDates(JsDate.toJs(start), JsDate.toJs(end));
                    } else {
                        afterDataReady.add(() -> getWidget().zoomToDates(JsDate.toJs(start), JsDate.toJs(end)));
                    }
                });
            }

            @Override
            public void zoomOutValueAxes() {
                Scheduler.get().scheduleDeferred(() -> {
                    if (dataReady) {
                        getWidget().zoomOutValueAxes();
                    } else {
                        afterDataReady.add(() -> getWidget().zoomOutValueAxes());
                    }
                });
            }

            @Override
            public void zoomOutValueAxisById(String id) {
                Scheduler.get().scheduleDeferred(() -> {
                    if (dataReady) {
                        getWidget().zoomOutValueAxis(id);
                    } else {
                        afterDataReady.add(() -> getWidget().zoomOutValueAxis(id));
                    }
                });
            }

            @Override
            public void zoomOutValueAxisByIndex(int index) {
                Scheduler.get().scheduleDeferred(() -> {
                    if (dataReady) {
                        getWidget().zoomOutValueAxis(index);
                    } else {
                        afterDataReady.add(() -> getWidget().zoomOutValueAxis(index));
                    }
                });
            }

            @Override
            public void zoomValueAxisToValuesById(String id, String startValue, String endValue) {
                Scheduler.get().scheduleDeferred(() -> {
                    if (dataReady) {
                        getWidget().zoomValueAxisToValues(id, startValue, endValue);
                    } else {
                        afterDataReady.add(() -> getWidget().zoomValueAxisToValues(id, startValue, endValue));
                    }
                });
            }

            @Override
            public void zoomValueAxisToValuesByIndex(int index, String startValue, String endValue) {
                Scheduler.get().scheduleDeferred(() -> {
                    if (dataReady) {
                        getWidget().zoomValueAxisToValues(index, startValue, endValue);
                    } else {
                        afterDataReady.add(() -> getWidget().zoomValueAxisToValues(index, startValue, endValue));
                    }
                });
            }

            @Override
            public void zoomValueAxisToDatesById(String id, Date start, Date end) {
                Scheduler.get().scheduleDeferred(() -> {
                    if (dataReady) {
                        getWidget().zoomValueAxisToValues(id, JsDate.toJs(start), JsDate.toJs(end));
                    } else {
                        afterDataReady.add(() ->
                                getWidget().zoomValueAxisToValues(id, JsDate.toJs(start), JsDate.toJs(end)));
                    }
                });
            }

            @Override
            public void zoomValueAxisToDatesByIndex(int index, Date start, Date end) {
                Scheduler.get().scheduleDeferred(() -> {
                    if (dataReady) {
                        getWidget().zoomValueAxisToValues(index, JsDate.toJs(start), JsDate.toJs(end));
                    } else {
                        afterDataReady.add(() ->
                                getWidget().zoomValueAxisToValues(index, JsDate.toJs(start), JsDate.toJs(end)));
                    }
                });
            }
        });
    }

    protected void updateChart(String json) {
        dataReady = false;

        Scheduler.get().scheduleDeferred(() -> {
            getWidget().updatePoints(getJsonAsObject(json));
            dataReady = true;
            executeAfterDataReady();
        });
    }

    protected void executeAfterDataReady() {
        for (Runnable runnable : afterDataReady) {
            runnable.run();
        }
        afterDataReady.clear();
    }

    protected void drawChart(String chartJson) {
        dataReady = false;

        AmchartsConfig config = AmchartsConfig.fromServerConfig(chartJson, getState().json);
        AmchartsEvents amchartsEvents = createEvents(config);

        Scheduler.get().scheduleDeferred(() -> {
            getWidget().init(config, amchartsEvents);

            // Add resize listener lazily here.
            // If done in init like in examples it will be called way too early,
            // like before the widget is not even rendered yet
            if (resizeListener == null) {
                resizeListener = e -> getWidget().updateSize();

                getLayoutManager().addElementResizeListener(getWidget().getElement(), resizeListener);
            }

            dataReady = true;
            executeAfterDataReady();
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

    protected AmchartsEvents createEvents(AmchartsConfig config) {
        AmchartsEvents amchartsEvents = new AmchartsEvents();
        Set<String> events = getState().registeredEventListeners;
        if (events != null) {
            bindClickEvents(amchartsEvents, events);

            String chartType = config.getChartType();
            if ("xy".equals(chartType)
                    || "radar".equals(chartType)
                    || "serial".equals(chartType)
                    || "gantt".equals(chartType)) {
                bindCoordinateChartEvents(amchartsEvents, events);
            }
            if ("serial".equals(chartType) || "gantt".equals(chartType)) {
                bindSerialChartEvents(amchartsEvents, events);
            }
            if ("pie".equals(chartType) || "funnel".equals(chartType)) {
                bindSlicedChartEvents(amchartsEvents, events);
            }
            if (config.hasLegend()) {
                bindLegendEvents(amchartsEvents, events);
            }
            if (("xy".equals(chartType)
                    || "serial".equals(chartType)
                    || "gantt".equals(chartType)) && config.hasCursor()) {
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
            amchartsEvents.setChartClickHandler(event ->
                    rpc.onChartClick(event.getX(), event.getY(),
                            event.getAbsoluteX(), event.getAbsoluteY(), event.getXAxis(), event.getYAxis())
            );
        }
        if (events.contains(CubaAmchartsSceneState.CHART_RIGHT_CLICK_EVENT)) {
            amchartsEvents.setChartRightClickHandler(event ->
                    rpc.onChartRightClick(event.getX(), event.getY(),
                            event.getAbsoluteX(), event.getAbsoluteY(), event.getXAxis(), event.getYAxis())
            );
        }
    }

    protected void bindXYChartEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.VALUE_AXIS_ZOOM_EVENT)) {
            amchartsEvents.setAxisZoomHandler(event ->
                    rpc.onValueAxisZoom(event.getAxisId(), event.getStartValue(), event.getEndValue())
            );
        }
    }

    protected void bindCursorEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.CURSOR_ZOOM_EVENT)) {
            amchartsEvents.setCursorZoomHandler(event ->
                    rpc.onCursorZoom(event.getStart(), event.getEnd())
            );
        }
        if (events.contains(CubaAmchartsSceneState.CURSOR_PERIOD_SELECT_EVENT)) {
            amchartsEvents.setCursorPeriodSelectHandler(event ->
                    rpc.onCursorPeriodSelect(event.getStart(), event.getEnd())
            );
        }
    }

    protected void bindLegendEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.LEGEND_LABEL_CLICK_EVENT)) {
            amchartsEvents.setLegendLabelClickHandler(event ->
                    rpc.onLegendLabelClick(event.getItemId())
            );
        }
        if (events.contains(CubaAmchartsSceneState.LEGEND_MARKER_CLICK_EVENT)) {
            amchartsEvents.setLegendMarkerClickHandler(event ->
                    rpc.onLegendMarkerClick(event.getItemId())
            );
        }
        if (events.contains(CubaAmchartsSceneState.LEGEND_ITEM_SHOW_EVENT)) {
            amchartsEvents.setLegendItemShowHandler(event ->
                    rpc.onLegendItemShow(event.getItemId())
            );
        }
        if (events.contains(CubaAmchartsSceneState.LEGEND_ITEM_HIDE_EVENT)) {
            amchartsEvents.setLegendItemHideHandler(event ->
                    rpc.onLegendItemHide(event.getItemId())
            );
        }
    }

    protected void bindSlicedChartEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.SLICE_CLICK_EVENT)) {
            amchartsEvents.setSliceClickHandler(event -> {
                NativeEvent me = event.getMouseEvent();

                rpc.onSliceClick(event.getSliceId(), MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }
        if (events.contains(CubaAmchartsSceneState.SLICE_RIGHT_CLICK_EVENT)) {
            amchartsEvents.setSliceRightClickHandler(event -> {
                NativeEvent me = event.getMouseEvent();

                rpc.onSliceRightClick(event.getSliceId(), MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }
        if (events.contains(CubaAmchartsSceneState.SLICE_PULL_IN_EVENT)) {
            amchartsEvents.setSlicePullInHandler(event -> rpc.onSlicePullIn(event.getSliceId()));
        }
        if (events.contains(CubaAmchartsSceneState.SLICE_PULL_OUT_EVENT)) {
            amchartsEvents.setSlicePullOutHandler(event -> rpc.onSlicePullOut(event.getSliceId()));
        }
    }

    protected void bindSerialChartEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.ZOOM_EVENT)) {
            amchartsEvents.setZoomHandler(event ->
                    rpc.onZoom(event.getStartIndex(), event.getEndIndex(),
                    JsDate.toJava(event.getStartDate()), JsDate.toJava(event.getEndDate()),
                    event.getStartValue(), event.getEndValue())
            );
        }
    }

    protected void bindCoordinateChartEvents(AmchartsEvents amchartsEvents, Set<String> events) {
        if (events.contains(CubaAmchartsSceneState.GRAPH_CLICK_EVENT)) {
            amchartsEvents.setGraphClickHandler(event -> {
                NativeEvent me = event.getMouseEvent();

                rpc.onGraphClick(event.getGraphId(), MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }
        if (events.contains(CubaAmchartsSceneState.GRAPH_ITEM_CLICK_EVENT)) {
            amchartsEvents.setGraphItemClickHandler(event -> {
                NativeEvent me = event.getMouseEvent();

                rpc.onGraphItemClick(event.getGraphId(), event.getIndex(), event.getItemId(),
                        MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }
        if (events.contains(CubaAmchartsSceneState.GRAPH_ITEM_RIGHT_CLICK_EVENT)) {
            amchartsEvents.setGraphItemRightClickHandler(event -> {
                NativeEvent me = event.getMouseEvent();

                rpc.onGraphItemRightClick(event.getGraphId(), event.getIndex(), event.getItemId(),
                        MouseHelper.getX(me), MouseHelper.getY(me),
                        me.getClientX(), me.getClientY());
            });
        }
    }
}