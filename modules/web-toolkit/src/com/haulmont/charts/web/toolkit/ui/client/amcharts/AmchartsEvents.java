/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.haulmont.charts.web.toolkit.ui.client.amcharts.events.*;

/**
 */
public class AmchartsEvents {

    private ChartClickHandler chartClickHandler;
    private ChartClickHandler chartRightClickHandler;

    private GraphClickHandler graphClickHandler;
    private GraphItemClickHandler graphItemClickHandler;
    private GraphItemClickHandler graphItemRightClickHandler;

    private ZoomHandler zoomHandler;

    private SliceClickHandler sliceClickHandler;
    private SliceClickHandler sliceRightClickHandler;
    private SlicePullHandler slicePullInHandler;
    private SlicePullHandler slicePullOutHandler;

    private LegendEventHandler legendLabelClickHandler;
    private LegendEventHandler legendMarkerClickHandler;
    private LegendEventHandler legendItemShowHandler;
    private LegendEventHandler legendItemHideHandler;

    private CursorEventHandler cursorPeriodSelectHandler;
    private CursorEventHandler cursorZoomHandler;
    private AxisZoomHandler axisZoomHandler;

    public ChartClickHandler getChartClickHandler() {
        return chartClickHandler;
    }

    public void setChartClickHandler(ChartClickHandler chartClickHandler) {
        this.chartClickHandler = chartClickHandler;
    }

    public GraphClickHandler getGraphClickHandler() {
        return graphClickHandler;
    }

    public ChartClickHandler getChartRightClickHandler() {
        return chartRightClickHandler;
    }

    public void setChartRightClickHandler(ChartClickHandler chartRightClickHandler) {
        this.chartRightClickHandler = chartRightClickHandler;
    }

    public void setGraphClickHandler(GraphClickHandler graphClickHandler) {
        this.graphClickHandler = graphClickHandler;
    }

    public GraphItemClickHandler getGraphItemClickHandler() {
        return graphItemClickHandler;
    }

    public void setGraphItemClickHandler(GraphItemClickHandler graphItemClickHandler) {
        this.graphItemClickHandler = graphItemClickHandler;
    }

    public GraphItemClickHandler getGraphItemRightClickHandler() {
        return graphItemRightClickHandler;
    }

    public void setGraphItemRightClickHandler(GraphItemClickHandler graphItemRightClickHandler) {
        this.graphItemRightClickHandler = graphItemRightClickHandler;
    }

    public ZoomHandler getZoomHandler() {
        return zoomHandler;
    }

    public void setZoomHandler(ZoomHandler zoomHandler) {
        this.zoomHandler = zoomHandler;
    }

    public SliceClickHandler getSliceClickHandler() {
        return sliceClickHandler;
    }

    public void setSliceClickHandler(SliceClickHandler sliceClickHandler) {
        this.sliceClickHandler = sliceClickHandler;
    }

    public SlicePullHandler getSlicePullInHandler() {
        return slicePullInHandler;
    }

    public void setSlicePullInHandler(SlicePullHandler slicePullInHandler) {
        this.slicePullInHandler = slicePullInHandler;
    }

    public SlicePullHandler getSlicePullOutHandler() {
        return slicePullOutHandler;
    }

    public void setSlicePullOutHandler(SlicePullHandler slicePullOutHandler) {
        this.slicePullOutHandler = slicePullOutHandler;
    }

    public SliceClickHandler getSliceRightClickHandler() {
        return sliceRightClickHandler;
    }

    public void setSliceRightClickHandler(SliceClickHandler sliceRightClickHandler) {
        this.sliceRightClickHandler = sliceRightClickHandler;
    }

    public LegendEventHandler getLegendItemHideHandler() {
        return legendItemHideHandler;
    }

    public void setLegendItemHideHandler(LegendEventHandler legendItemHideHandler) {
        this.legendItemHideHandler = legendItemHideHandler;
    }

    public LegendEventHandler getLegendItemShowHandler() {
        return legendItemShowHandler;
    }

    public void setLegendItemShowHandler(LegendEventHandler legendItemShowHandler) {
        this.legendItemShowHandler = legendItemShowHandler;
    }

    public LegendEventHandler getLegendLabelClickHandler() {
        return legendLabelClickHandler;
    }

    public void setLegendLabelClickHandler(LegendEventHandler legendLabelClickHandler) {
        this.legendLabelClickHandler = legendLabelClickHandler;
    }

    public LegendEventHandler getLegendMarkerClickHandler() {
        return legendMarkerClickHandler;
    }

    public void setLegendMarkerClickHandler(LegendEventHandler legendMarkerClickHandler) {
        this.legendMarkerClickHandler = legendMarkerClickHandler;
    }

    public CursorEventHandler getCursorPeriodSelectHandler() {
        return cursorPeriodSelectHandler;
    }

    public void setCursorPeriodSelectHandler(CursorEventHandler cursorPeriodSelectHandler) {
        this.cursorPeriodSelectHandler = cursorPeriodSelectHandler;
    }

    public CursorEventHandler getCursorZoomHandler() {
        return cursorZoomHandler;
    }

    public void setCursorZoomHandler(CursorEventHandler cursorZoomHandler) {
        this.cursorZoomHandler = cursorZoomHandler;
    }

    public AxisZoomHandler getAxisZoomHandler() {
        return axisZoomHandler;
    }

    public void setAxisZoomHandler(AxisZoomHandler axisZoomHandler) {
        this.axisZoomHandler = axisZoomHandler;
    }
}