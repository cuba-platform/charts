/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts;

import com.haulmont.charts.gui.amcharts.model.charts.*;
import com.haulmont.charts.web.toolkit.ui.amcharts.events.*;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.CubaAmchartsSceneState;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.CubaAmchartsServerRpc;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.util.ReflectTools;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author artamonov
 * @version $Id$
 */
public class CubaAmchartsScene extends AbstractComponent {

    private final static Method chartClickMethod =
            ReflectTools.findMethod(ChartClickListener.class, "onClick", ChartClickEvent.class);

    private final static Method chartRightClickMethod =
            ReflectTools.findMethod(ChartRightClickListener.class, "onClick", ChartRightClickEvent.class);

    private final static Method graphClickMethod =
            ReflectTools.findMethod(GraphClickListener.class, "onClick", GraphClickEvent.class);

    private final static Method graphItemClickMethod =
            ReflectTools.findMethod(GraphItemClickListener.class, "onClick", GraphItemClickEvent.class);

    private final static Method graphItemRightClickMethod =
            ReflectTools.findMethod(GraphItemRightClickListener.class, "onClick", GraphItemRightClickEvent.class);

    private final static Method zoomMethod =
            ReflectTools.findMethod(ZoomListener.class, "onZoom", ZoomEvent.class);

    private final static Method sliceClickMethod =
            ReflectTools.findMethod(SliceClickListener.class, "onClick", SliceClickEvent.class);

    private final static Method sliceRightClickMethod =
            ReflectTools.findMethod(SliceRightClickListener.class, "onClick", SliceRightClickEvent.class);

    private final static Method slicePullInMethod =
            ReflectTools.findMethod(SlicePullInListener.class, "onClick", SlicePullInEvent.class);

    private final static Method slicePullOutMethod =
            ReflectTools.findMethod(SlicePullOutListener.class, "onClick", SlicePullOutEvent.class);

    private final static Method legendLabelClickMethod =
            ReflectTools.findMethod(LegendLabelClickListener.class, "onClick", LegendLabelClickEvent.class);

    private final static Method legendMarkerClickMethod =
            ReflectTools.findMethod(LegendMarkerClickListener.class, "onClick", LegendMarkerClickEvent.class);

    private final static Method legendItemShowMethod =
            ReflectTools.findMethod(LegendItemShowListener.class, "onShow", LegendItemShowEvent.class);

    private final static Method legendItemHideMethod =
            ReflectTools.findMethod(LegendItemHideListener.class, "onHide", LegendItemHideEvent.class);

    private final static Method cursorZoomMethod =
            ReflectTools.findMethod(CursorZoomListener.class, "onZoom", CursorZoomEvent.class);

    private final static Method cursorPeriodSelectMethod =
            ReflectTools.findMethod(CursorPeriodSelectListener.class, "onSelect", CursorPeriodSelectEvent.class);

    private final static Method axisZoomMethod =
            ReflectTools.findMethod(AxisZoomListener.class, "onZoom", AxisZoomEvent.class);

    private boolean dirty = false;

    private AbstractChart chart;

    public CubaAmchartsScene() {
        // enable amcharts integration
        CubaAmchartsIntegration.get();

        registerRpc(new CubaAmchartsServerRpcImpl(), CubaAmchartsServerRpc.class);
    }

    @Override
    protected CubaAmchartsSceneState getState() {
        return (CubaAmchartsSceneState) super.getState();
    }

    @Override
    protected CubaAmchartsSceneState getState(boolean markAsDirty) {
        return (CubaAmchartsSceneState) super.getState(markAsDirty);
    }

    public AbstractChart getChart() {
        return chart;
    }

    public void setJson(String json) {
        if (!StringUtils.equals(getJson(), json)) {
            getState().json = json;
        }
    }

    public String getJson() {
        return getState(false).json;
    }

    public void drawChart() {
        forceStateChange();
    }

    public void drawChart(AbstractChart chart) {
        this.chart = chart;
        forceStateChange();
    }

    public AngularGaugeChart gaugeChart() {
        AngularGaugeChart gaugeChart = new AngularGaugeChart();
        drawChart(gaugeChart);
        return gaugeChart;
    }

    public FunnelChart funnelChart() {
        FunnelChart funnelChart = new FunnelChart();
        drawChart(funnelChart);
        return funnelChart;
    }

    public PieChart pieChart() {
        PieChart pieChart = new PieChart();
        drawChart(pieChart);
        return pieChart;
    }

    public RadarChart radarChart() {
        RadarChart radarChart = new RadarChart();
        drawChart(radarChart);
        return radarChart;
    }

    public SerialChart serialChart() {
        SerialChart serialChart = new SerialChart();
        drawChart(serialChart);
        return serialChart;
    }

    public XYChart xyChart() {
        XYChart xyChart = new XYChart();
        drawChart(xyChart);
        return xyChart;
    }

    public void addChartClickListener(ChartClickListener listener) {
        addListener(CubaAmchartsSceneState.CHART_CLICK_EVENT, ChartClickEvent.class, listener, chartClickMethod);
    }

    public void removeChartClickListener(ChartClickListener listener) {
        removeListener(CubaAmchartsSceneState.CHART_CLICK_EVENT, ChartClickEvent.class, listener);
    }

    public void addChartRightClickListener(ChartRightClickListener listener) {
        addListener(CubaAmchartsSceneState.CHART_RIGHT_CLICK_EVENT, ChartRightClickEvent.class, listener, chartRightClickMethod);
    }

    public void removeChartRightClickListener(ChartRightClickListener listener) {
        removeListener(CubaAmchartsSceneState.CHART_RIGHT_CLICK_EVENT, ChartRightClickEvent.class, listener);
    }

    public void addGraphClickListener(GraphClickListener listener) {
        addListener(CubaAmchartsSceneState.GRAPH_CLICK_EVENT, GraphClickEvent.class, listener, graphClickMethod);
    }

    public void removeGraphClickListener(GraphClickListener listener) {
        removeListener(CubaAmchartsSceneState.GRAPH_CLICK_EVENT, GraphClickEvent.class, listener);
    }

    public void addGraphItemClickListener(GraphItemClickListener listener) {
        addListener(CubaAmchartsSceneState.GRAPH_ITEM_CLICK_EVENT, GraphItemClickEvent.class, listener, graphItemClickMethod);
    }

    public void removeGraphItemClickListener(GraphItemClickListener listener) {
        removeListener(CubaAmchartsSceneState.GRAPH_ITEM_CLICK_EVENT, GraphItemClickEvent.class, listener);
    }

    public void addGraphItemRightClickListener(GraphItemRightClickListener listener) {
        addListener(CubaAmchartsSceneState.GRAPH_ITEM_RIGHT_CLICK_EVENT, GraphItemRightClickEvent.class, listener, graphItemRightClickMethod);
    }

    public void removeGraphItemRightClickListener(GraphItemRightClickListener listener) {
        removeListener(CubaAmchartsSceneState.GRAPH_ITEM_RIGHT_CLICK_EVENT, GraphItemRightClickEvent.class, listener);
    }

    public void addZoomListener(ZoomListener listener) {
        addListener(CubaAmchartsSceneState.ZOOM_EVENT, ZoomEvent.class, listener, zoomMethod);
    }

    public void removeZoomListener(ZoomListener listener) {
        removeListener(CubaAmchartsSceneState.ZOOM_EVENT, ZoomEvent.class, listener);
    }

    public void addSliceClickListener(SliceClickListener listener) {
        addListener(CubaAmchartsSceneState.SLICE_CLICK_EVENT, SliceClickEvent.class, listener, sliceClickMethod);
    }

    public void removeSliceClickListener(SliceClickListener listener) {
        removeListener(CubaAmchartsSceneState.SLICE_CLICK_EVENT, SliceClickEvent.class, listener);
    }

    public void addSliceRightClickListener(SliceRightClickListener listener) {
        addListener(CubaAmchartsSceneState.SLICE_RIGHT_CLICK_EVENT, SliceRightClickEvent.class, listener, sliceRightClickMethod);
    }

    public void removeSliceRightClickListener(SliceRightClickListener listener) {
        removeListener(CubaAmchartsSceneState.SLICE_RIGHT_CLICK_EVENT, SliceRightClickEvent.class, listener);
    }

    public void addSlicePullInListener(SlicePullInListener listener) {
        addListener(CubaAmchartsSceneState.SLICE_PULL_IN_EVENT, SlicePullInEvent.class, listener, slicePullInMethod);
    }

    public void removeSlicePullInListener(SlicePullInListener listener) {
        removeListener(CubaAmchartsSceneState.SLICE_PULL_IN_EVENT, SlicePullInEvent.class, listener);
    }

    public void addSlicePullOutListener(SlicePullOutListener listener) {
        addListener(CubaAmchartsSceneState.SLICE_PULL_OUT_EVENT, SlicePullOutEvent.class, listener, slicePullOutMethod);
    }

    public void removeSlicePullOutListener(SlicePullOutListener listener) {
        removeListener(CubaAmchartsSceneState.SLICE_PULL_OUT_EVENT, SlicePullOutEvent.class, listener);
    }

    public void addLegendLabelClickListener(LegendLabelClickListener listener) {
        addListener(CubaAmchartsSceneState.LEGEND_LABEL_CLICK_EVENT, LegendLabelClickEvent.class, listener, legendLabelClickMethod);
    }

    public void removeLegendLabelClickListener(LegendLabelClickListener listener) {
        removeListener(CubaAmchartsSceneState.LEGEND_LABEL_CLICK_EVENT, LegendLabelClickEvent.class, listener);
    }

    public void addLegendMarkerClickListener(LegendMarkerClickListener listener) {
        addListener(CubaAmchartsSceneState.LEGEND_MARKER_CLICK_EVENT, LegendMarkerClickEvent.class, listener, legendMarkerClickMethod);
    }

    public void removeLegendMarkerClickListener(LegendMarkerClickListener listener) {
        removeListener(CubaAmchartsSceneState.LEGEND_MARKER_CLICK_EVENT, LegendMarkerClickEvent.class, listener);
    }

    public void addLegendItemShowListener(LegendItemShowListener listener) {
        addListener(CubaAmchartsSceneState.LEGEND_ITEM_SHOW_EVENT, LegendItemShowEvent.class, listener, legendItemShowMethod);
    }

    public void removeLegendItemShowListener(LegendItemShowListener listener) {
        removeListener(CubaAmchartsSceneState.LEGEND_ITEM_SHOW_EVENT, LegendItemShowEvent.class, listener);
    }

    public void addLegendItemHideListener(LegendItemHideListener listener) {
        addListener(CubaAmchartsSceneState.LEGEND_ITEM_HIDE_EVENT, LegendItemHideEvent.class, listener, legendItemHideMethod);
    }

    public void removeLegendItemHideListener(LegendItemHideListener listener) {
        removeListener(CubaAmchartsSceneState.LEGEND_ITEM_HIDE_EVENT, LegendItemHideEvent.class, listener);
    }

    public void addCursorZoomListener(CursorZoomListener listener) {
        addListener(CubaAmchartsSceneState.CURSOR_ZOOM_EVENT, CursorZoomEvent.class, listener, cursorZoomMethod);
    }

    public void removeCursorZoomListener(CursorZoomListener listener) {
        removeListener(CubaAmchartsSceneState.CURSOR_ZOOM_EVENT, CursorZoomEvent.class, listener);
    }

    public void addCursorPeriodSelectListener(CursorPeriodSelectListener listener) {
        addListener(CubaAmchartsSceneState.CURSOR_PERIOD_SELECT_EVENT, CursorPeriodSelectEvent.class, listener, cursorPeriodSelectMethod);
    }

    public void removeCursorPeriodSelectListener(CursorPeriodSelectListener listener) {
        removeListener(CubaAmchartsSceneState.CURSOR_PERIOD_SELECT_EVENT, CursorPeriodSelectEvent.class, listener);
    }

    public void addAxisZoomListener(AxisZoomListener listener) {
        addListener(CubaAmchartsSceneState.VALUE_AXIS_ZOOM_EVENT, AxisZoomEvent.class, listener, axisZoomMethod);
    }

    public void removeAxisZoomListener(AxisZoomListener listener) {
        removeListener(CubaAmchartsSceneState.VALUE_AXIS_ZOOM_EVENT, AxisZoomEvent.class, listener);
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);
        if (initial || dirty) {
            if (chart != null) {
                setupDefaults(chart);

                if (chart.getDataProvider() != null) {
                    chart.getDataProvider().bindToChart(chart);
                }

                getState().configuration = chart.toString();
            }
            dirty = false;
        }
    }

    protected void setupDefaults(AbstractChart chart) {
    }

    protected void forceStateChange() {
        this.dirty = true;
        getState().version++;
    }

    protected class CubaAmchartsServerRpcImpl implements CubaAmchartsServerRpc {

        @Override
        public void onChartClick(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis) {
            fireEvent(new ChartClickEvent(CubaAmchartsScene.this, x, y, absoluteX, absoluteY, xAxis, yAxis));
        }

        @Override
        public void onChartRightClick(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis) {
            fireEvent(new ChartRightClickEvent(CubaAmchartsScene.this, x, y, absoluteX, absoluteY, xAxis, yAxis));
        }

        @Override
        public void onGraphClick(String graphId, int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new GraphClickEvent(CubaAmchartsScene.this, graphId, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onGraphItemClick(String graphId, int itemIndex, String itemId, int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new GraphItemClickEvent(CubaAmchartsScene.this, graphId, itemIndex, itemId, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onGraphItemRightClick(String graphId, int itemIndex, String itemId, int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new GraphItemRightClickEvent(CubaAmchartsScene.this, graphId, itemIndex, itemId, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onZoom(int startIndex, int endIndex, Date startDate, Date endDate, String startValue, String endValue) {
            fireEvent(new ZoomEvent(CubaAmchartsScene.this, startIndex, endIndex, startDate, endDate, startValue, endValue));
        }

        @Override
        public void onSliceClick(String sliceId, int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new SliceClickEvent(CubaAmchartsScene.this, sliceId, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onSliceRightClick(String sliceId, int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new SliceRightClickEvent(CubaAmchartsScene.this, sliceId, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onSlicePullIn(String sliceId) {
            fireEvent(new SlicePullInEvent(CubaAmchartsScene.this, sliceId));
        }

        @Override
        public void onSlicePullOut(String sliceId) {
            fireEvent(new SlicePullOutEvent(CubaAmchartsScene.this, sliceId));
        }

        @Override
        public void onLegendLabelClick(String itemId) {
            fireEvent(new LegendLabelClickEvent(CubaAmchartsScene.this, itemId));
        }

        @Override
        public void onLegendMarkerClick(String itemId) {
            fireEvent(new LegendMarkerClickEvent(CubaAmchartsScene.this, itemId));
        }

        @Override
        public void onLegendItemHide(String itemId) {
            fireEvent(new LegendItemShowEvent(CubaAmchartsScene.this, itemId));
        }

        @Override
        public void onLegendItemShow(String itemId) {
            fireEvent(new LegendItemHideEvent(CubaAmchartsScene.this, itemId));
        }

        @Override
        public void onCursorZoom(String start, String end) {
            fireEvent(new CursorZoomEvent(CubaAmchartsScene.this, start, end));
        }

        @Override
        public void onCursorPeriodSelect(String start, String end) {
            fireEvent(new CursorPeriodSelectEvent(CubaAmchartsScene.this, start, end));
        }

        @Override
        public void onValueAxisZoom(String axisId, double startValue, double endValue) {
            fireEvent(new AxisZoomEvent(CubaAmchartsScene.this, axisId, startValue, endValue));
        }
    }
}