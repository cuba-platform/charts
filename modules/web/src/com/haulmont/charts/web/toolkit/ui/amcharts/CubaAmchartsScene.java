/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.haulmont.charts.gui.amcharts.model.ChartType;
import com.haulmont.charts.gui.amcharts.model.charts.*;
import com.haulmont.charts.gui.amcharts.model.gson.ChartIncrementalChanges;
import com.haulmont.charts.gui.amcharts.model.gson.ChartSerializer;
import com.haulmont.charts.gui.data.DataChangeListener;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.DataItemsChangeEvent;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.web.toolkit.ui.amcharts.events.*;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.CubaAmchartsSceneClientRpc;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.CubaAmchartsSceneState;
import com.haulmont.charts.web.toolkit.ui.client.amcharts.CubaAmchartsServerRpc;
import com.vaadin.server.KeyMapper;
import com.vaadin.ui.AbstractComponent;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webjars.WebJarAssetLocator;

import javax.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import static com.vaadin.util.ReflectTools.findMethod;

public class CubaAmchartsScene extends AbstractComponent {
    private final Logger log = LoggerFactory.getLogger(CubaAmchartsScene.class);

    protected final static Method chartClickMethod =
            findMethod(ChartClickListener.class, "onClick", ChartClickEvent.class);

    protected final static Method chartRightClickMethod =
            findMethod(ChartRightClickListener.class, "onClick", ChartRightClickEvent.class);

    protected final static Method graphClickMethod =
            findMethod(GraphClickListener.class, "onClick", GraphClickEvent.class);

    protected final static Method graphItemClickMethod =
            findMethod(GraphItemClickListener.class, "onClick", GraphItemClickEvent.class);

    protected final static Method graphItemRightClickMethod =
            findMethod(GraphItemRightClickListener.class, "onClick", GraphItemRightClickEvent.class);

    protected final static Method zoomMethod =
            findMethod(ZoomListener.class, "onZoom", ZoomEvent.class);

    protected final static Method sliceClickMethod =
            findMethod(SliceClickListener.class, "onClick", SliceClickEvent.class);

    protected final static Method sliceRightClickMethod =
            findMethod(SliceRightClickListener.class, "onClick", SliceRightClickEvent.class);

    protected final static Method slicePullInMethod =
            findMethod(SlicePullInListener.class, "onClick", SlicePullInEvent.class);

    protected final static Method slicePullOutMethod =
            findMethod(SlicePullOutListener.class, "onClick", SlicePullOutEvent.class);
    protected final static Method legendLabelClickMethod =
            findMethod(LegendLabelClickListener.class, "onClick", LegendLabelClickEvent.class);

    protected final static Method legendMarkerClickMethod =
            findMethod(LegendMarkerClickListener.class, "onClick", LegendMarkerClickEvent.class);

    protected final static Method legendItemShowMethod =
            findMethod(LegendItemShowListener.class, "onShow", LegendItemShowEvent.class);

    protected final static Method legendItemHideMethod =
            findMethod(LegendItemHideListener.class, "onHide", LegendItemHideEvent.class);

    protected final static Method cursorZoomMethod =
            findMethod(CursorZoomListener.class, "onZoom", CursorZoomEvent.class);

    protected final static Method cursorPeriodSelectMethod =
            findMethod(CursorPeriodSelectListener.class, "onSelect", CursorPeriodSelectEvent.class);

    protected final static Method axisZoomMethod =
            findMethod(AxisZoomListener.class, "onZoom", AxisZoomEvent.class);

    protected final static Method categoryItemClickMethod =
            findMethod(CategoryItemClickListener.class, "onClick", CategoryItemClickEvent.class);

    protected final DataChangeListener changeListener = new ProxyChangeForwarder(this);

    protected boolean dirty = false;

    protected AbstractChart chart;

    protected ChartIncrementalChanges changedItems;

    protected ChartSerializer chartSerializer;
    protected KeyMapper<Object> dataItemKeys = new KeyMapper<>();
    protected Function<DataItem, String> dataItemKeyMapper;

    public CubaAmchartsScene() {
        // enable amcharts integration
        CubaAmchartsIntegration.get();

        dataItemKeyMapper = item -> {
            if (item instanceof DataItem.HasId) {
                return dataItemKeys.key(((DataItem.HasId) item).getId());
            }
            return null;
        };
        chartSerializer = new ChartSerializer(dataItemKeyMapper);

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

    public boolean isDirty() {
        return dirty;
    }

    public void setJson(String json) {
        if (!StringUtils.equals(getJson(), json)) {
            if (json != null) {
                try {
                    JsonParser parser = new JsonParser();
                    parser.parse(json);
                } catch (JsonSyntaxException e) {
                    throw new IllegalStateException("Unable to parse JSON chart configuration");
                }
            }

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

    public void drawChart(AbstractChart chart) {
        this.chart = chart;
        this.chart.addDataProviderChangeListener(() -> {
            forgetChangedItems();
            forceStateChange();
        });
        forceStateChange();
    }

    protected void forgetChangedItems() {
        this.changedItems = null;
    }

    protected void addChangedItems(IncrementalUpdateType type, List<DataItem> items) {
        if (changedItems == null) {
            changedItems = new ChartIncrementalChanges();
        }

        switch (type) {
            case ADD:
                changedItems.registerAddedItem(items);
                break;
            case REMOVE:
                changedItems.registerRemovedItems(items);
                break;
            case UPDATE:
                changedItems.registerUpdatedItems(items);
                break;
        }

        markAsDirty();
    }

    public void activateResponsivePlugin() {
        CubaAmchartsResponsiveIntegration.get();
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

    public GanttChart ganttChart() {
        GanttChart ganttChart = new GanttChart();
        drawChart(ganttChart);
        return ganttChart;
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

    public void addCategoryItemClickListener(CategoryItemClickListener listener) {
        addListener(CubaAmchartsSceneState.CATEGORY_ITEM_CLICK_EVENT, CategoryItemClickEvent.class, listener, categoryItemClickMethod);
    }

    public void removeCategoryItemClickListener(CategoryItemClickListener listener) {
        removeListener(CubaAmchartsSceneState.CATEGORY_ITEM_CLICK_EVENT, CategoryItemClickEvent.class, listener);
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);

        if (initial || dirty) {
            if (chart != null) {
                // Full repaint
                setupDefaults(chart);
                setupPaths(chart);

                dataItemKeys.removeAll();

                if (chart.getDataProvider() != null) {
                    chart.getDataProvider().addChangeListener(changeListener);
                }

                String jsonString = chartSerializer.serialize(chart);
                log.trace("Chart full JSON:\n{}", jsonString);

                getRpcProxy(CubaAmchartsSceneClientRpc.class).draw(jsonString);
            }
            dirty = false;
        } else if (changedItems != null && !changedItems.isEmpty()) {
            // Incremental update

            String jsonString = chartSerializer.serializeChanges(chart, changedItems);
            log.trace("Chart update JSON:\n{}", jsonString);

            List<DataItem> removedItems = changedItems.getRemovedItems();
            if (removedItems != null) {
                for (DataItem removedItem : removedItems) {
                    dataItemKeys.remove(removedItem);
                }
            }

            getRpcProxy(CubaAmchartsSceneClientRpc.class).updatePoints(jsonString);
        }

        forgetChangedItems();
    }

    protected void setupDefaults(AbstractChart chart) {
    }

    protected void setupPaths(AbstractChart chart) {
        if (chart.getPath() != null && !chart.getPath().isEmpty()) {
            return;
        }

        if (chart.getPath() == null || chart.getPath().isEmpty()) {
            String amchartsPath = new WebJarAssetLocator()
                    .getFullPath("amcharts", "amcharts.js");
            String path = amchartsPath.substring(0, amchartsPath.lastIndexOf("/"))
                    .replace("META-INF/resources", "VAADIN") + "/";
            chart.setPath(path);
        }
    }

    protected void forceStateChange() {
        this.dirty = true;
        markAsDirty();
    }

    public void zoomOut() {
        getRpcProxy(CubaAmchartsSceneClientRpc.class).zoomOut();
    }

    public void zoomToIndexes(int start, int end) {
        getRpcProxy(CubaAmchartsSceneClientRpc.class).zoomToIndexes(start, end);
    }

    public void zoomToDates(Date start, Date end) {
        getRpcProxy(CubaAmchartsSceneClientRpc.class).zoomToDates(start, end);
    }

    public void zoomOutValueAxes() {
        getRpcProxy(CubaAmchartsSceneClientRpc.class).zoomOutValueAxes();
    }

    public void zoomOutValueAxis(String id) {
        getRpcProxy(CubaAmchartsSceneClientRpc.class).zoomOutValueAxisById(id);
    }

    public void zoomOutValueAxis(int index) {
        getRpcProxy(CubaAmchartsSceneClientRpc.class).zoomOutValueAxisByIndex(index);
    }

    protected String convertObjectToString(Object value) {
        return chartSerializer.toJson(value);
    }

    public void zoomValueAxisToValues(String id, Object startValue, Object endValue) {
        if (startValue == null || endValue == null) {
            throw new IllegalArgumentException("startValue or endValue cannot be null");
        }

        CubaAmchartsSceneClientRpc rpc = getRpcProxy(CubaAmchartsSceneClientRpc.class);
        if (startValue instanceof Date) {
            rpc.zoomValueAxisToDatesById(id, (Date) startValue, (Date) endValue);
        } else {
            rpc.zoomValueAxisToValuesById(id, convertObjectToString(startValue), convertObjectToString(endValue));
        }
    }

    public void zoomValueAxisToValues(int index, Object startValue, Object endValue) {
        if (startValue == null || endValue == null) {
            throw new IllegalArgumentException("startValue or endValue cannot be null");
        }

        CubaAmchartsSceneClientRpc rpc = getRpcProxy(CubaAmchartsSceneClientRpc.class);
        if (startValue instanceof Date) {
            rpc.zoomValueAxisToDatesByIndex(index, (Date) startValue, (Date) endValue);
        } else {
            rpc.zoomValueAxisToValuesByIndex(index, convertObjectToString(startValue), convertObjectToString(endValue));
        }
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
        public void onGraphItemClick(String graphId, int itemIndex, String itemKey, int x, int y, int absoluteX, int absoluteY) {
            DataItem dataItem = getDataItemByKey(itemKey);
            fireEvent(new GraphItemClickEvent(CubaAmchartsScene.this,
                    graphId, itemIndex, dataItem, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onGraphItemRightClick(String graphId, int itemIndex, String itemKey, int x, int y, int absoluteX, int absoluteY) {
            DataItem dataItem = getDataItemByKey(itemKey);
            fireEvent(new GraphItemRightClickEvent(CubaAmchartsScene.this,
                    graphId, itemIndex, dataItem, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onZoom(int startIndex, int endIndex, Date startDate, Date endDate, String startValue, String endValue) {
            fireEvent(new ZoomEvent(CubaAmchartsScene.this, startIndex, endIndex, startDate, endDate, startValue, endValue));
        }

        @Override
        public void onSliceClick(int itemIndex, String dataItemKey, int x, int y, int absoluteX, int absoluteY) {
            DataItem dataItem = getDataItemByKey(dataItemKey);
            fireEvent(new SliceClickEvent(CubaAmchartsScene.this, dataItem, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onSliceRightClick(int itemIndex, String dataItemKey, int x, int y, int absoluteX, int absoluteY) {
            DataItem dataItem = getDataItemByKey(dataItemKey);
            fireEvent(new SliceRightClickEvent(CubaAmchartsScene.this, dataItem, x, y, absoluteX, absoluteY));
        }

        @Override
        public void onSlicePullIn(String dataItemKey) {
            DataItem dataItem = getDataItemByKey(dataItemKey);
            fireEvent(new SlicePullInEvent(CubaAmchartsScene.this, dataItem));
        }

        @Override
        public void onSlicePullOut(String dataItemKey) {
            DataItem dataItem = getDataItemByKey(dataItemKey);
            fireEvent(new SlicePullOutEvent(CubaAmchartsScene.this, dataItem));
        }

        @Override
        public void onLegendLabelClick(int legendItemIndex, @Nullable String dataItemKey) {
            DataItem dataItem = getDataItemByKey(dataItemKey);
            fireEvent(new LegendLabelClickEvent(CubaAmchartsScene.this, legendItemIndex, dataItem));
        }

        @Override
        public void onLegendMarkerClick(int legendItemIndex, @Nullable String dataItemKey) {
            DataItem dataItem = getDataItemByKey(dataItemKey);
            fireEvent(new LegendMarkerClickEvent(CubaAmchartsScene.this, legendItemIndex, dataItem));
        }

        @Override
        public void onLegendItemHide(int legendItemIndex, @Nullable String dataItemKey) {
            DataItem dataItem = getDataItemByKey(dataItemKey);
            fireEvent(new LegendItemHideEvent(CubaAmchartsScene.this, legendItemIndex, dataItem));
        }

        @Override
        public void onLegendItemShow(int legendItemIndex, @Nullable String dataItemKey) {
            DataItem dataItem = getDataItemByKey(dataItemKey);
            fireEvent(new LegendItemShowEvent(CubaAmchartsScene.this, legendItemIndex, dataItem));
        }

        protected DataItem getDataItemByKey(@Nullable String dataItemKey) {
            DataItem dataItem = null;
            if (dataItemKey != null) {
                DataProvider dataProvider = chart.getDataProvider();

                if (chart.getType() == ChartType.GANTT && dataItemKey.contains(":")) {
                    String graphItemKey = dataItemKey.substring(0, dataItemKey.indexOf(":"));
                    String segmentItemKey = dataItemKey.substring(dataItemKey.indexOf(":") + 1, dataItemKey.length());

                    Object dataItemId = dataItemKeys.get(graphItemKey);

                    if (dataProvider != null) {
                        DataItem graphDataItem = dataProvider.getItem(dataItemId);
                        if (graphDataItem != null) {
                            int segmentIndex = Integer.parseInt(segmentItemKey);
                            String segmentsField = ((GanttChart) chart).getSegmentsField();

                            @SuppressWarnings("unchecked")
                            List<DataItem> segmentItems = (List<DataItem>) graphDataItem.getValue(segmentsField);
                            dataItem = segmentItems.get(segmentIndex);
                        }
                    }
                } else {
                    Object dataItemId = dataItemKeys.get(dataItemKey);

                    if (dataProvider != null) {
                        dataItem = dataProvider.getItem(dataItemId);
                    }
                }
            }
            return dataItem;
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

        @Override
        public void onCategoryItemClick(String value, int x, int y, int offsetX, int offsetY, int xAxis, int yAxis) {
            fireEvent(new CategoryItemClickEvent(CubaAmchartsScene.this, value, x, y, offsetX, offsetY, xAxis, yAxis));
        }
    }

    protected static class ProxyChangeForwarder implements DataChangeListener {
        protected final CubaAmchartsScene chart;

        public ProxyChangeForwarder(CubaAmchartsScene chart) {
            this.chart = chart;
        }

        @Override
        public void dataItemsChanged(DataItemsChangeEvent e) {
            if (chart.isDirty()) {
                // full repaint required, don't need to send incremental updates
                return;
            }

            IncrementalUpdateType updateType = null;
            switch (e.getOperation()) {
                case ADD:
                    updateType = IncrementalUpdateType.ADD;
                    break;
                case REMOVE:
                    updateType = IncrementalUpdateType.REMOVE;
                    break;
                case UPDATE:
                    updateType = IncrementalUpdateType.UPDATE;
                    break;
                case REFRESH:
                    chart.getChart().getDataProvider().removeChangeListener(this);
                    chart.forgetChangedItems();
                    chart.drawChart();
                    break;
            }
            if (updateType != null && CollectionUtils.isNotEmpty(e.getItems())) {
                chart.addChangedItems(updateType, e.getItems());
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            ProxyChangeForwarder that = (ProxyChangeForwarder) obj;

            return this.chart.equals(that.chart);
        }

        @Override
        public int hashCode() {
            return chart.hashCode();
        }
    }
}