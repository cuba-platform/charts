/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.haulmont.charts.web.toolkit.ui.client.amcharts.events.*;

import java.util.function.Consumer;

public class AmchartsEvents {
    private Consumer<JsChartClickEvent> chartClickHandler;
    private Consumer<JsChartClickEvent> chartRightClickHandler;

    private Consumer<JsGraphClickEvent> graphClickHandler;
    private Consumer<JsGraphItemClickEvent> graphItemClickHandler;
    private Consumer<JsGraphItemClickEvent> graphItemRightClickHandler;

    private Consumer<JsZoomEvent> zoomHandler;

    private Consumer<JsSliceClickEvent> sliceClickHandler;
    private Consumer<JsSliceClickEvent> sliceRightClickHandler;
    private Consumer<JsSlicePullEvent> slicePullInHandler;
    private Consumer<JsSlicePullEvent> slicePullOutHandler;

    private Consumer<JsLegendEvent> legendLabelClickHandler;
    private Consumer<JsLegendEvent> legendMarkerClickHandler;
    private Consumer<JsLegendEvent> legendItemShowHandler;
    private Consumer<JsLegendEvent> legendItemHideHandler;

    private Consumer<JsCursorEvent> cursorPeriodSelectHandler;
    private Consumer<JsCursorEvent> cursorZoomHandler;
    private Consumer<JsAxisZoomedEvent> axisZoomHandler;

    public Consumer<JsChartClickEvent> getChartClickHandler() {
        return chartClickHandler;
    }

    public void setChartClickHandler(Consumer<JsChartClickEvent> chartClickHandler) {
        this.chartClickHandler = chartClickHandler;
    }

    public Consumer<JsGraphClickEvent> getGraphClickHandler() {
        return graphClickHandler;
    }

    public void setGraphClickHandler(Consumer<JsGraphClickEvent> graphClickHandler) {
        this.graphClickHandler = graphClickHandler;
    }

    public Consumer<JsChartClickEvent> getChartRightClickHandler() {
        return chartRightClickHandler;
    }

    public void setChartRightClickHandler(Consumer<JsChartClickEvent> chartRightClickHandler) {
        this.chartRightClickHandler = chartRightClickHandler;
    }

    public Consumer<JsGraphItemClickEvent> getGraphItemClickHandler() {
        return graphItemClickHandler;
    }

    public void setGraphItemClickHandler(Consumer<JsGraphItemClickEvent> graphItemClickHandler) {
        this.graphItemClickHandler = graphItemClickHandler;
    }

    public Consumer<JsGraphItemClickEvent> getGraphItemRightClickHandler() {
        return graphItemRightClickHandler;
    }

    public void setGraphItemRightClickHandler(Consumer<JsGraphItemClickEvent> graphItemRightClickHandler) {
        this.graphItemRightClickHandler = graphItemRightClickHandler;
    }

    public Consumer<JsZoomEvent> getZoomHandler() {
        return zoomHandler;
    }

    public void setZoomHandler(Consumer<JsZoomEvent> zoomHandler) {
        this.zoomHandler = zoomHandler;
    }

    public Consumer<JsSliceClickEvent> getSliceClickHandler() {
        return sliceClickHandler;
    }

    public void setSliceClickHandler(Consumer<JsSliceClickEvent> sliceClickHandler) {
        this.sliceClickHandler = sliceClickHandler;
    }

    public Consumer<JsSlicePullEvent> getSlicePullInHandler() {
        return slicePullInHandler;
    }

    public void setSlicePullInHandler(Consumer<JsSlicePullEvent> slicePullInHandler) {
        this.slicePullInHandler = slicePullInHandler;
    }

    public Consumer<JsSlicePullEvent> getSlicePullOutHandler() {
        return slicePullOutHandler;
    }

    public void setSlicePullOutHandler(Consumer<JsSlicePullEvent> slicePullOutHandler) {
        this.slicePullOutHandler = slicePullOutHandler;
    }

    public Consumer<JsSliceClickEvent> getSliceRightClickHandler() {
        return sliceRightClickHandler;
    }

    public void setSliceRightClickHandler(Consumer<JsSliceClickEvent> sliceRightClickHandler) {
        this.sliceRightClickHandler = sliceRightClickHandler;
    }

    public Consumer<JsLegendEvent> getLegendItemHideHandler() {
        return legendItemHideHandler;
    }

    public void setLegendItemHideHandler(Consumer<JsLegendEvent> legendItemHideHandler) {
        this.legendItemHideHandler = legendItemHideHandler;
    }

    public Consumer<JsLegendEvent> getLegendItemShowHandler() {
        return legendItemShowHandler;
    }

    public void setLegendItemShowHandler(Consumer<JsLegendEvent> legendItemShowHandler) {
        this.legendItemShowHandler = legendItemShowHandler;
    }

    public Consumer<JsLegendEvent> getLegendLabelClickHandler() {
        return legendLabelClickHandler;
    }

    public void setLegendLabelClickHandler(Consumer<JsLegendEvent> legendLabelClickHandler) {
        this.legendLabelClickHandler = legendLabelClickHandler;
    }

    public Consumer<JsLegendEvent> getLegendMarkerClickHandler() {
        return legendMarkerClickHandler;
    }

    public void setLegendMarkerClickHandler(Consumer<JsLegendEvent> legendMarkerClickHandler) {
        this.legendMarkerClickHandler = legendMarkerClickHandler;
    }

    public Consumer<JsCursorEvent> getCursorPeriodSelectHandler() {
        return cursorPeriodSelectHandler;
    }

    public void setCursorPeriodSelectHandler(Consumer<JsCursorEvent> cursorPeriodSelectHandler) {
        this.cursorPeriodSelectHandler = cursorPeriodSelectHandler;
    }

    public Consumer<JsCursorEvent> getCursorZoomHandler() {
        return cursorZoomHandler;
    }

    public void setCursorZoomHandler(Consumer<JsCursorEvent> cursorZoomHandler) {
        this.cursorZoomHandler = cursorZoomHandler;
    }

    public Consumer<JsAxisZoomedEvent> getAxisZoomHandler() {
        return axisZoomHandler;
    }

    public void setAxisZoomHandler(Consumer<JsAxisZoomedEvent> axisZoomHandler) {
        this.axisZoomHandler = axisZoomHandler;
    }
}