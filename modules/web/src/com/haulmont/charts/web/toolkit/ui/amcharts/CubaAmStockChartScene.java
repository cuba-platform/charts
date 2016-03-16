/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.amcharts.model.DataSet;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;
import com.haulmont.charts.gui.amcharts.model.data.DataChangeListener;
import com.haulmont.charts.gui.amcharts.model.data.DataItem;
import com.haulmont.charts.gui.amcharts.model.data.DataItemsChangeEvent;
import com.haulmont.charts.gui.amcharts.model.gson.ChartJsonSerializationContext;
import com.haulmont.charts.gui.amcharts.model.gson.DataItemsSerializer;
import com.haulmont.charts.web.toolkit.ui.amcharts.events.*;
import com.haulmont.charts.web.toolkit.ui.client.amstockcharts.CubaAmStockChartSceneClientRpc;
import com.haulmont.charts.web.toolkit.ui.client.amstockcharts.CubaAmStockChartSceneState;
import com.haulmont.charts.web.toolkit.ui.client.amstockcharts.CubaAmStockChartServerRpc;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.util.ReflectTools;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 */
public class CubaAmStockChartScene extends AbstractComponent {

    private final static Method chartClickMethod =
            ReflectTools.findMethod(StockChartClickListener.class, "onClick", StockChartClickEvent.class);

    private final static Method chartRightClickMethod =
            ReflectTools.findMethod(StockChartRightClickListener.class, "onClick", StockChartRightClickEvent.class);

    private final static Method stockEventClickMethod =
            ReflectTools.findMethod(StockEventClickListener.class, "onClick", StockEventClickEvent.class);

    private final static Method stockEventRollOutMethod =
            ReflectTools.findMethod(StockEventRollOutListener.class, "onRollOut", StockEventRollOutEvent.class);

    private final static Method stockEventRollOverMethod =
            ReflectTools.findMethod(StockEventRollOverListener.class, "onRollOver", StockEventRollOverEvent.class);

    private final static Method stockZoomMethod =
            ReflectTools.findMethod(StockPanelZoomListener.class, "onZoom", StockPanelZoomEvent.class);

    private final static Method periodSelectorChangeMethod =
            ReflectTools.findMethod(PeriodSelectorChangeListener.class, "onChange", PeriodSelectorChangeEvent.class);

    private final static Method dataSetSelectorCompareMethod =
            ReflectTools.findMethod(DataSetSelectorCompareListener.class, "onCompare", DataSetSelectorCompareEvent.class);

    private final static Method dataSetSelectorSelectMethod =
            ReflectTools.findMethod(DataSetSelectorSelectListener.class, "onSelect", DataSetSelectorSelectEvent.class);

    private final static Method dataSetSelectorUnCompareMethod =
            ReflectTools.findMethod(DataSetSelectorUnCompareListener.class, "onUnCompare", DataSetSelectorUnCompareEvent.class);

    private final static Method stockGraphClickMethod =
            ReflectTools.findMethod(StockGraphClickListener.class, "onClick", StockGraphClickEvent.class);

    private final static Method stockGraphRollOutMethod =
            ReflectTools.findMethod(StockGraphRollOutListener.class, "onRollOut", StockGraphRollOutEvent.class);

    private final static Method stockGraphRollOverMethod =
            ReflectTools.findMethod(StockGraphRollOverListener.class, "onRollOver", StockGraphRollOverEvent.class);

    private final static Method stockGraphItemClickMethod =
            ReflectTools.findMethod(StockGraphItemClickListener.class, "onClick", StockGraphItemClickEvent.class);

    private final static Method stockGraphItemRightClickMethod =
            ReflectTools.findMethod(StockGraphItemRightClickListener.class, "onClick", StockGraphItemRightClickEvent.class);

    private final static Method stockGraphItemRollOutMethod =
            ReflectTools.findMethod(StockGraphItemRollOutListener.class, "onRollOut", StockGraphItemRollOutEvent.class);

    private final static Method stockGraphItemRollOverMethod =
            ReflectTools.findMethod(StockGraphItemRollOverListener.class, "onRollOver", StockGraphItemRollOverEvent.class);

    private boolean dirty = false;

    private StockChartGroup chart;

    private Map<String, Map<String, List<DataItem>>> changedItems;

    protected JsonSerializationContext serializationContext;

    protected enum Operation {
        ADD("add"),
        REMOVE("remove"),
        UPDATE("update");

        private String id;

        Operation(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id;
        }
    }

    public CubaAmStockChartScene() {
        // enable amcharts integration
        CubaAmchartsIntegration.get();

        registerRpc(new CubaAmStockChartServerRpcImpl(), CubaAmStockChartServerRpc.class);
    }

    @Override
    protected CubaAmStockChartSceneState getState() {
        return (CubaAmStockChartSceneState) super.getState();
    }

    @Override
    protected CubaAmStockChartSceneState getState(boolean markAsDirty) {
        return (CubaAmStockChartSceneState) super.getState(markAsDirty);
    }

    public StockChartGroup getChart() {
        return chart;
    }

    public void setJson(String json) {
        if (!StringUtils.equals(getJson(), json)) {
            getState().json = json;
            forceStateChange();
        }
    }

    public String getJson() {
        return getState(false).json;
    }

    public void drawChart() {
        forceStateChange();
    }

    public void drawChart(StockChartGroup chart) {
        this.chart = chart;
        forceStateChange();
    }

    protected void setChangedItems(Map<String, Map<String, List<DataItem>>> changedItems) {
        this.changedItems = changedItems;
        markAsDirty();
    }

    protected void addChangedItems(Operation type, String dataSetId, List<DataItem> items) {
        if (changedItems == null) {
            changedItems = new HashMap<>();
        }

        Map<String, List<DataItem>> dataSetChanges = changedItems.get(dataSetId);
        if (dataSetChanges == null) {
            dataSetChanges = new HashMap<>();
            changedItems.put(dataSetId, dataSetChanges);
        }

        List<DataItem> existedItems = dataSetChanges.get(type.toString());
        if (existedItems == null) {
            existedItems = new ArrayList<>();
            dataSetChanges.put(type.toString(), existedItems);
        }

        existedItems.addAll(items);

        markAsDirty();
    }

    public void addChartClickListener(StockChartClickListener listener) {
        addListener(CubaAmStockChartSceneState.CHART_CLICK_EVENT, StockChartClickEvent.class, listener, chartClickMethod);
    }

    public void removeChartClickListener(StockChartClickListener listener) {
        removeListener(CubaAmStockChartSceneState.CHART_CLICK_EVENT, StockChartClickEvent.class, listener);
    }

    public void addChartRightClickListener(StockChartRightClickListener listener) {
        addListener(CubaAmStockChartSceneState.CHART_RIGHT_CLICK_EVENT, StockChartRightClickEvent.class, listener, chartRightClickMethod);
    }

    public void removeChartRightClickListener(StockChartRightClickListener listener) {
        removeListener(CubaAmStockChartSceneState.CHART_RIGHT_CLICK_EVENT, StockChartRightClickEvent.class, listener);
    }

    public void addStockEventClickListener(StockEventClickListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_EVENT_CLICK_EVENT, StockEventClickEvent.class, listener, stockEventClickMethod);
    }

    public void removeStockEventClickListener(StockEventClickListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_EVENT_CLICK_EVENT, StockEventClickEvent.class, listener);
    }

    public void addStockEventRollOutListener(StockEventRollOutListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_EVENT_ROLL_OUT_EVENT, StockEventRollOutEvent.class, listener, stockEventRollOutMethod);
    }

    public void removeStockEventRollOutListener(StockEventRollOutListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_EVENT_ROLL_OUT_EVENT, StockEventRollOutEvent.class, listener);
    }

    public void addStockEventRollOverListener(StockEventRollOverListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_EVENT_ROLL_OVER_EVENT, StockEventRollOverEvent.class, listener, stockEventRollOverMethod);
    }

    public void removeStockEventRollOverListener(StockEventRollOverListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_EVENT_ROLL_OVER_EVENT, StockEventRollOverEvent.class, listener);
    }

    public void addStockPanelZoomListener(StockPanelZoomListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_ZOOM_EVENT, StockPanelZoomEvent.class, listener, stockZoomMethod);
    }

    public void removeStockPanelZoomListener(StockPanelZoomListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_ZOOM_EVENT, StockPanelZoomEvent.class, listener);
    }

    public void addPeriodSelectorChangeListener(PeriodSelectorChangeListener listener) {
        addListener(CubaAmStockChartSceneState.PERIOD_SELECTOR_CHANGE_EVENT, PeriodSelectorChangeEvent.class, listener, periodSelectorChangeMethod);
    }

    public void removePeriodSelectorChangeListener(PeriodSelectorChangeListener listener) {
        removeListener(CubaAmStockChartSceneState.PERIOD_SELECTOR_CHANGE_EVENT, PeriodSelectorChangeEvent.class, listener);
    }

    public void addDataSetSelectorCompareListener(DataSetSelectorCompareListener listener) {
        addListener(CubaAmStockChartSceneState.DATA_SET_SELECTOR_COMPARE_EVENT, DataSetSelectorCompareEvent.class, listener, dataSetSelectorCompareMethod);
    }

    public void removeDataSetSelectorCompareListener(DataSetSelectorCompareListener listener) {
        removeListener(CubaAmStockChartSceneState.DATA_SET_SELECTOR_COMPARE_EVENT, DataSetSelectorCompareEvent.class, listener);
    }

    public void addDataSetSelectorSelectListener(DataSetSelectorSelectListener listener) {
        addListener(CubaAmStockChartSceneState.DATA_SET_SELECTOR_SELECT_EVENT, DataSetSelectorSelectEvent.class, listener, dataSetSelectorSelectMethod);
    }

    public void removeDataSetSelectorSelectListener(DataSetSelectorSelectListener listener) {
        removeListener(CubaAmStockChartSceneState.DATA_SET_SELECTOR_SELECT_EVENT, DataSetSelectorSelectEvent.class, listener);
    }

    public void addDataSetSelectorUnCompareListener(DataSetSelectorUnCompareListener listener) {
        addListener(CubaAmStockChartSceneState.DATA_SET_SELECTOR_UNCOMPARE_EVENT, DataSetSelectorUnCompareEvent.class, listener, dataSetSelectorUnCompareMethod);
    }

    public void removeDataSetSelectorUnCompareListener(DataSetSelectorUnCompareListener listener) {
        removeListener(CubaAmStockChartSceneState.DATA_SET_SELECTOR_UNCOMPARE_EVENT, DataSetSelectorUnCompareEvent.class, listener);
    }

    public void addStockGraphClickListener(StockGraphClickListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_GRAPH_CLICK_EVENT, StockGraphClickEvent.class, listener, stockGraphClickMethod);
    }

    public void removeStockGraphClickListener(StockGraphClickListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_GRAPH_CLICK_EVENT, StockGraphClickEvent.class, listener);
    }

    public void addStockGraphRollOutListener(StockGraphRollOutListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_GRAPH_ROLL_OUT_EVENT, StockGraphRollOutEvent.class, listener, stockGraphRollOutMethod);
    }

    public void removeStockGraphRollOutListener(StockGraphRollOutListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_GRAPH_ROLL_OUT_EVENT, StockGraphRollOutEvent.class, listener);
    }

    public void addStockGraphRollOverListener(StockGraphRollOverListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_GRAPH_ROLL_OVER_EVENT, StockGraphRollOverEvent.class, listener, stockGraphRollOverMethod);
    }

    public void removeStockGraphRollOverListener(StockGraphRollOverListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_GRAPH_ROLL_OVER_EVENT, StockGraphRollOverEvent.class, listener);
    }

    public void addStockGraphItemClickListener(StockGraphItemClickListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_CLICK_EVENT, StockGraphItemClickEvent.class, listener, stockGraphItemClickMethod);
    }

    public void removeStockGraphItemClickListener(StockGraphItemClickListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_CLICK_EVENT, StockGraphItemClickEvent.class, listener);
    }

    public void addStockGraphItemRightClickListener(StockGraphItemRightClickListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_RIGHT_CLICK_EVENT, StockGraphItemRightClickEvent.class, listener, stockGraphItemRightClickMethod);
    }

    public void removeStockGraphItemRightClickListener(StockGraphItemRightClickListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_RIGHT_CLICK_EVENT, StockGraphItemRightClickEvent.class, listener);
    }

    public void addStockGraphItemRollOutListener(StockGraphItemRollOutListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_ROLL_OUT_EVENT, StockGraphItemRollOutEvent.class, listener, stockGraphItemRollOutMethod);
    }

    public void removeStockGraphItemRollOutListener(StockGraphItemRollOutListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_ROLL_OUT_EVENT, StockGraphItemRollOutEvent.class, listener);
    }

    public void addStockGraphItemRollOverListener(StockGraphItemRollOverListener listener) {
        addListener(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_ROLL_OVER_EVENT, StockGraphItemRollOverEvent.class, listener, stockGraphItemRollOverMethod);
    }

    public void removeStockGraphItemRollOverListener(StockGraphItemRollOverListener listener) {
        removeListener(CubaAmStockChartSceneState.STOCK_GRAPH_ITEM_ROLL_OVER_EVENT, StockGraphItemRollOverEvent.class, listener);
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);
        if (initial || dirty) {
            if (chart != null) {
                setupDefaults(chart);

                for (DataSet dataSet : chart.getDataSets()) {
                    if (dataSet.getDataProvider() != null) {
                        dataSet.getDataProvider().addChangeListener(new ProxyChangeForwarder(this, dataSet));
                    }
                }

                getState().configuration = chart.toString();
            }
            dirty = false;
        }

        if (changedItems != null && !changedItems.isEmpty()) {

            DataItemsSerializer serializer = new DataItemsSerializer();
            JsonObject jsonChangedItemsElement = new JsonObject();

            for (Map.Entry<String,  Map<String, List<DataItem>>> dataSetEntry : changedItems.entrySet()) {
                JsonObject jsonChangedDataSetElement = new JsonObject();
                for (Map.Entry<String, List<DataItem>> entry : dataSetEntry.getValue().entrySet()) {
                    JsonArray jsonItemsArray = new JsonArray();

                    if (serializationContext == null) {
                        serializationContext = new ChartJsonSerializationContext(chart);
                    }

                    List<JsonObject> jsonObjects = serializer.serialize(entry.getValue(), serializationContext);
                    for (JsonObject jsonObject : jsonObjects) {
                        jsonItemsArray.add(jsonObject);
                    }
                    jsonChangedDataSetElement.add(entry.getKey(), jsonItemsArray);
                }
                jsonChangedItemsElement.add(dataSetEntry.getKey(), jsonChangedDataSetElement);
            }

            getRpcProxy(CubaAmStockChartSceneClientRpc.class).updatePoints(
                    StockChartGroup.getSharedGson().toJson(jsonChangedItemsElement));
            setChangedItems(null);
        }
    }

    protected void setupDefaults(StockChartGroup chart) {
    }

    protected void forceStateChange() {
        this.dirty = true;
        getState().version++;
    }

    protected class CubaAmStockChartServerRpcImpl implements CubaAmStockChartServerRpc {

        @Override
        public void onChartClick(int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new StockChartClickEvent(CubaAmStockChartScene.this, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onChartRightClick(int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new StockChartRightClickEvent(CubaAmStockChartScene.this, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onStockEventClick(String graphId, Date date, String stockEventId) {
            fireEvent(new StockEventClickEvent(CubaAmStockChartScene.this, graphId, date, stockEventId));
        }

        @Override
        public void onStockEventRollOut(String graphId, Date date, String stockEventId) {
            fireEvent(new StockEventRollOutEvent(CubaAmStockChartScene.this, graphId, date, stockEventId));
        }

        @Override
        public void onStockEventRollOver(String graphId, Date date, String stockEventId) {
            fireEvent(new StockEventRollOverEvent(CubaAmStockChartScene.this, graphId, date, stockEventId));
        }

        @Override
        public void onZoom(Date startDate, Date endDate, String period) {
            fireEvent(new StockPanelZoomEvent(CubaAmStockChartScene.this, startDate, endDate, period));
        }

        @Override
        public void onPeriodSelectorChange(Date startDate, Date endDate, String predefinedPeriod, Integer count,
                                           int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new PeriodSelectorChangeEvent(CubaAmStockChartScene.this, startDate, endDate, predefinedPeriod,
                    count, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onDataSetSelectorCompare(String dataSetId) {
            fireEvent(new DataSetSelectorCompareEvent(CubaAmStockChartScene.this, dataSetId));
        }

        @Override
        public void onDataSetSelectorSelect(String dataSetId) {
            fireEvent(new DataSetSelectorSelectEvent(CubaAmStockChartScene.this, dataSetId));
        }

        @Override
        public void onDataSetSelectorUnCompare(String dataSetId) {
            fireEvent(new DataSetSelectorUnCompareEvent(CubaAmStockChartScene.this, dataSetId));
        }

        @Override
        public void onStockGraphClick(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new StockGraphClickEvent(CubaAmStockChartScene.this, panelId, graphId, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onStockGraphRollOut(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new StockGraphRollOutEvent(CubaAmStockChartScene.this, panelId, graphId, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onStockGraphRollOver(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new StockGraphRollOverEvent(CubaAmStockChartScene.this, panelId, graphId, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onStockGraphItemClick(String panelId, String graphId, int itemIndex, String itemId,
                                          int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new StockGraphItemClickEvent(CubaAmStockChartScene.this, panelId, graphId, itemId, itemIndex,
                    x, y, absoluteX, absoluteY));
        }

        @Override
        public void onStockGraphItemRightClick(String panelId, String graphId, int itemIndex, String itemId,
                                               int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new StockGraphItemRightClickEvent(CubaAmStockChartScene.this, panelId, graphId, itemId, itemIndex,
                    x, y, absoluteX, absoluteY));
        }

        @Override
        public void onStockGraphItemRollOut(String panelId, String graphId, int itemIndex, String itemId,
                                            int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new StockGraphItemRollOutEvent(CubaAmStockChartScene.this, panelId, graphId, itemId, itemIndex,
                    x, y, absoluteX, absoluteY));
        }

        @Override
        public void onStockGraphItemRollOver(String panelId, String graphId, int itemIndex, String itemId,
                                             int x, int y, int absoluteX, int absoluteY) {
            fireEvent(new StockGraphItemRollOverEvent(CubaAmStockChartScene.this, panelId, graphId, itemId, itemIndex,
                    x, y, absoluteX, absoluteY));
        }
    }

    protected static class ProxyChangeForwarder implements DataChangeListener {

        private final CubaAmStockChartScene chart;
        private final DataSet dataSet;

        private ProxyChangeForwarder(CubaAmStockChartScene chart, DataSet dataSet) {
            this.chart = chart;
            this.dataSet = dataSet;
        }

        @Override
        public void dataItemsChanged(DataItemsChangeEvent e) {
            Operation operation = null;
            switch (e.getOperation()) {
                case ADD:
                    operation = Operation.ADD;
                    break;
                case REMOVE:
                    operation = Operation.REMOVE;
                    break;
                case UPDATE:
                    operation = Operation.UPDATE;
                    break;
                case REFRESH:
                    dataSet.getDataProvider().removeChangeListener(this);
                    chart.setChangedItems(null);
                    chart.drawChart();
                    break;
            }
            if (operation != null && CollectionUtils.isNotEmpty(e.getItems())) {
                chart.addChangedItems(operation, dataSet.getId(), e.getItems());
            }
        }
    }
}
