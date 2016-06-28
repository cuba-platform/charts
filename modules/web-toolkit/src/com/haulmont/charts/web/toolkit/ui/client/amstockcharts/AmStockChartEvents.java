/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts;

import com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events.*;

public class AmStockChartEvents {

    private StockChartClickHandler chartClickHandler;
    private StockChartClickHandler chartRightClickHandler;

    private StockEventClickHandler stockEventClickHandler;
    private StockEventRollOutHandler stockEventRollOutHandler;
    private StockEventRollOverHandler stockEventRollOverHandler;

    private StockPanelZoomHandler stockPanelZoomHandler;

    private PeriodSelectorChangeHandler periodSelectorChangeHandler;

    private DataSetSelectorCompareHandler dataSetSelectorCompareHandler;
    private DataSetSelectorSelectHandler dataSetSelectorSelectHandler;
    private DataSetSelectorUnCompareHandler dataSetSelectorUnCompareHandler;

    private StockGraphClickHandler stockGraphClickHandler;
    private StockGraphRollOutHandler stockGraphRollOutHandler;
    private StockGraphRollOverHandler stockGraphRollOverHandler;

    private StockGraphItemClickHandler stockGraphItemClickHandler;
    private StockGraphItemRightClickHandler stockGraphItemRightClickHandler;
    private StockGraphItemRollOutHandler stockGraphItemRollOutHandler;
    private StockGraphItemRollOverHandler stockGraphItemRollOverHandler;

    public StockChartClickHandler getChartClickHandler() {
        return chartClickHandler;
    }

    public void setChartClickHandler(StockChartClickHandler chartClickHandler) {
        this.chartClickHandler = chartClickHandler;
    }

    public StockChartClickHandler getChartRightClickHandler() {
        return chartRightClickHandler;
    }

    public void setChartRightClickHandler(StockChartClickHandler chartRightClickHandler) {
        this.chartRightClickHandler = chartRightClickHandler;
    }

    public StockEventClickHandler getStockEventClickHandler() {
        return stockEventClickHandler;
    }

    public void setStockEventClickHandler(StockEventClickHandler stockEventClickHandler) {
        this.stockEventClickHandler = stockEventClickHandler;
    }

    public StockEventRollOutHandler getStockEventRollOutHandler() {
        return stockEventRollOutHandler;
    }

    public void setStockEventRollOutHandler(StockEventRollOutHandler stockEventRollOutHandler) {
        this.stockEventRollOutHandler = stockEventRollOutHandler;
    }

    public StockEventRollOverHandler getStockEventRollOverHandler() {
        return stockEventRollOverHandler;
    }

    public void setStockEventRollOverHandler(StockEventRollOverHandler stockEventRollOverHandler) {
        this.stockEventRollOverHandler = stockEventRollOverHandler;
    }

    public StockPanelZoomHandler getStockPanelZoomHandler() {
        return stockPanelZoomHandler;
    }

    public void setStockPanelZoomHandler(StockPanelZoomHandler stockPanelZoomHandler) {
        this.stockPanelZoomHandler = stockPanelZoomHandler;
    }

    public PeriodSelectorChangeHandler getPeriodSelectorChangeHandler() {
        return periodSelectorChangeHandler;
    }

    public void setPeriodSelectorChangeHandler(PeriodSelectorChangeHandler periodSelectorChangeHandler) {
        this.periodSelectorChangeHandler = periodSelectorChangeHandler;
    }

    public DataSetSelectorCompareHandler getDataSetSelectorCompareHandler() {
        return dataSetSelectorCompareHandler;
    }

    public void setDataSetSelectorCompareHandler(DataSetSelectorCompareHandler dataSetSelectorCompareHandler) {
        this.dataSetSelectorCompareHandler = dataSetSelectorCompareHandler;
    }

    public DataSetSelectorSelectHandler getDataSetSelectorSelectHandler() {
        return dataSetSelectorSelectHandler;
    }

    public void setDataSetSelectorSelectHandler(DataSetSelectorSelectHandler dataSetSelectorSelectHandler) {
        this.dataSetSelectorSelectHandler = dataSetSelectorSelectHandler;
    }

    public DataSetSelectorUnCompareHandler getDataSetSelectorUnCompareHandler() {
        return dataSetSelectorUnCompareHandler;
    }

    public void setDataSetSelectorUnCompareHandler(DataSetSelectorUnCompareHandler dataSetSelectorUnCompareHandler) {
        this.dataSetSelectorUnCompareHandler = dataSetSelectorUnCompareHandler;
    }

    public StockGraphClickHandler getStockGraphClickHandler() {
        return stockGraphClickHandler;
    }

    public void setStockGraphClickHandler(StockGraphClickHandler stockGraphClickHandler) {
        this.stockGraphClickHandler = stockGraphClickHandler;
    }

    public StockGraphRollOutHandler getStockGraphRollOutHandler() {
        return stockGraphRollOutHandler;
    }

    public void setStockGraphRollOutHandler(StockGraphRollOutHandler stockGraphRollOutHandler) {
        this.stockGraphRollOutHandler = stockGraphRollOutHandler;
    }

    public StockGraphRollOverHandler getStockGraphRollOverHandler() {
        return stockGraphRollOverHandler;
    }

    public void setStockGraphRollOverHandler(StockGraphRollOverHandler stockGraphRollOverHandler) {
        this.stockGraphRollOverHandler = stockGraphRollOverHandler;
    }

    public StockGraphItemClickHandler getStockGraphItemClickHandler() {
        return stockGraphItemClickHandler;
    }

    public void setStockGraphItemClickHandler(StockGraphItemClickHandler stockGraphItemClickHandler) {
        this.stockGraphItemClickHandler = stockGraphItemClickHandler;
    }

    public StockGraphItemRightClickHandler getStockGraphItemRightClickHandler() {
        return stockGraphItemRightClickHandler;
    }

    public void setStockGraphItemRightClickHandler(StockGraphItemRightClickHandler stockGraphItemRightClickHandler) {
        this.stockGraphItemRightClickHandler = stockGraphItemRightClickHandler;
    }

    public StockGraphItemRollOutHandler getStockGraphItemRollOutHandler() {
        return stockGraphItemRollOutHandler;
    }

    public void setStockGraphItemRollOutHandler(StockGraphItemRollOutHandler stockGraphItemRollOutHandler) {
        this.stockGraphItemRollOutHandler = stockGraphItemRollOutHandler;
    }

    public StockGraphItemRollOverHandler getStockGraphItemRollOverHandler() {
        return stockGraphItemRollOverHandler;
    }

    public void setStockGraphItemRollOverHandler(StockGraphItemRollOverHandler stockGraphItemRollOverHandler) {
        this.stockGraphItemRollOverHandler = stockGraphItemRollOverHandler;
    }
}
