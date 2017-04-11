/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts;

import com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.*;

import java.util.function.Consumer;

public class AmStockChartEvents {

    private Consumer<JsStockChartClickEvent> chartClickHandler;
    private Consumer<JsStockChartClickEvent> chartRightClickHandler;

    private Consumer<JsStockEventClickEvent> stockEventClickHandler;
    private Consumer<JsStockEventRollOutEvent> stockEventRollOutHandler;
    private Consumer<JsStockEventRollOverEvent> stockEventRollOverHandler;

    private Consumer<JsStockPanelZoomEvent> stockPanelZoomHandler;

    private Consumer<JsPeriodSelectorChangeEvent> periodSelectorChangeHandler;

    private Consumer<JsDataSetSelectorCompareEvent> dataSetSelectorCompareHandler;
    private Consumer<JsDataSetSelectorSelectEvent> dataSetSelectorSelectHandler;
    private Consumer<JsDataSetSelectorUnCompareEvent> dataSetSelectorUnCompareHandler;

    private Consumer<JsStockGraphClickEvent> stockGraphClickHandler;
    private Consumer<JsStockGraphRollOutEvent> stockGraphRollOutHandler;
    private Consumer<JsStockGraphRollOverEvent> stockGraphRollOverHandler;

    private Consumer<JsStockGraphItemClickEvent> stockGraphItemClickHandler;
    private Consumer<JsStockGraphItemRightClickEvent> stockGraphItemRightClickHandler;
    private Consumer<JsStockGraphItemRollOutEvent> stockGraphItemRollOutHandler;
    private Consumer<JsStockGraphItemRollOverEvent> stockGraphItemRollOverHandler;

    public Consumer<JsStockChartClickEvent> getChartClickHandler() {
        return chartClickHandler;
    }

    public void setChartClickHandler(Consumer<JsStockChartClickEvent> chartClickHandler) {
        this.chartClickHandler = chartClickHandler;
    }

    public Consumer<JsStockChartClickEvent> getChartRightClickHandler() {
        return chartRightClickHandler;
    }

    public void setChartRightClickHandler(Consumer<JsStockChartClickEvent> chartRightClickHandler) {
        this.chartRightClickHandler = chartRightClickHandler;
    }

    public Consumer<JsStockEventClickEvent> getStockEventClickHandler() {
        return stockEventClickHandler;
    }

    public void setStockEventClickHandler(Consumer<JsStockEventClickEvent> stockEventClickHandler) {
        this.stockEventClickHandler = stockEventClickHandler;
    }

    public Consumer<JsStockEventRollOutEvent> getStockEventRollOutHandler() {
        return stockEventRollOutHandler;
    }

    public void setStockEventRollOutHandler(Consumer<JsStockEventRollOutEvent> stockEventRollOutHandler) {
        this.stockEventRollOutHandler = stockEventRollOutHandler;
    }

    public Consumer<JsStockEventRollOverEvent> getStockEventRollOverHandler() {
        return stockEventRollOverHandler;
    }

    public void setStockEventRollOverHandler(Consumer<JsStockEventRollOverEvent> stockEventRollOverHandler) {
        this.stockEventRollOverHandler = stockEventRollOverHandler;
    }

    public Consumer<JsStockPanelZoomEvent> getStockPanelZoomHandler() {
        return stockPanelZoomHandler;
    }

    public void setStockPanelZoomHandler(Consumer<JsStockPanelZoomEvent> stockPanelZoomHandler) {
        this.stockPanelZoomHandler = stockPanelZoomHandler;
    }

    public Consumer<JsPeriodSelectorChangeEvent> getPeriodSelectorChangeHandler() {
        return periodSelectorChangeHandler;
    }

    public void setPeriodSelectorChangeHandler(Consumer<JsPeriodSelectorChangeEvent> periodSelectorChangeHandler) {
        this.periodSelectorChangeHandler = periodSelectorChangeHandler;
    }

    public Consumer<JsDataSetSelectorCompareEvent> getDataSetSelectorCompareHandler() {
        return dataSetSelectorCompareHandler;
    }

    public void setDataSetSelectorCompareHandler(Consumer<JsDataSetSelectorCompareEvent> dataSetSelectorCompareHandler) {
        this.dataSetSelectorCompareHandler = dataSetSelectorCompareHandler;
    }

    public Consumer<JsDataSetSelectorSelectEvent> getDataSetSelectorSelectHandler() {
        return dataSetSelectorSelectHandler;
    }

    public void setDataSetSelectorSelectHandler(Consumer<JsDataSetSelectorSelectEvent> dataSetSelectorSelectHandler) {
        this.dataSetSelectorSelectHandler = dataSetSelectorSelectHandler;
    }

    public Consumer<JsDataSetSelectorUnCompareEvent> getDataSetSelectorUnCompareHandler() {
        return dataSetSelectorUnCompareHandler;
    }

    public void setDataSetSelectorUnCompareHandler(Consumer<JsDataSetSelectorUnCompareEvent> dataSetSelectorUnCompareHandler) {
        this.dataSetSelectorUnCompareHandler = dataSetSelectorUnCompareHandler;
    }

    public Consumer<JsStockGraphClickEvent> getStockGraphClickHandler() {
        return stockGraphClickHandler;
    }

    public void setStockGraphClickHandler(Consumer<JsStockGraphClickEvent> stockGraphClickHandler) {
        this.stockGraphClickHandler = stockGraphClickHandler;
    }

    public Consumer<JsStockGraphRollOutEvent> getStockGraphRollOutHandler() {
        return stockGraphRollOutHandler;
    }

    public void setStockGraphRollOutHandler(Consumer<JsStockGraphRollOutEvent> stockGraphRollOutHandler) {
        this.stockGraphRollOutHandler = stockGraphRollOutHandler;
    }

    public Consumer<JsStockGraphRollOverEvent> getStockGraphRollOverHandler() {
        return stockGraphRollOverHandler;
    }

    public void setStockGraphRollOverHandler(Consumer<JsStockGraphRollOverEvent> stockGraphRollOverHandler) {
        this.stockGraphRollOverHandler = stockGraphRollOverHandler;
    }

    public Consumer<JsStockGraphItemClickEvent> getStockGraphItemClickHandler() {
        return stockGraphItemClickHandler;
    }

    public void setStockGraphItemClickHandler(Consumer<JsStockGraphItemClickEvent> stockGraphItemClickHandler) {
        this.stockGraphItemClickHandler = stockGraphItemClickHandler;
    }

    public Consumer<JsStockGraphItemRightClickEvent> getStockGraphItemRightClickHandler() {
        return stockGraphItemRightClickHandler;
    }

    public void setStockGraphItemRightClickHandler(Consumer<JsStockGraphItemRightClickEvent> stockGraphItemRightClickHandler) {
        this.stockGraphItemRightClickHandler = stockGraphItemRightClickHandler;
    }

    public Consumer<JsStockGraphItemRollOutEvent> getStockGraphItemRollOutHandler() {
        return stockGraphItemRollOutHandler;
    }

    public void setStockGraphItemRollOutHandler(Consumer<JsStockGraphItemRollOutEvent> stockGraphItemRollOutHandler) {
        this.stockGraphItemRollOutHandler = stockGraphItemRollOutHandler;
    }

    public Consumer<JsStockGraphItemRollOverEvent> getStockGraphItemRollOverHandler() {
        return stockGraphItemRollOverHandler;
    }

    public void setStockGraphItemRollOverHandler(Consumer<JsStockGraphItemRollOverEvent> stockGraphItemRollOverHandler) {
        this.stockGraphItemRollOverHandler = stockGraphItemRollOverHandler;
    }
}
