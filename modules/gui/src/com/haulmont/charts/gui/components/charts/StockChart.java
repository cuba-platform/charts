/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.bali.events.Subscription;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartModel;
import com.haulmont.charts.gui.amcharts.model.charts.StockPanel;
import com.haulmont.charts.gui.data.ContainerDataProvider;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.gui.data.EntityDataItem;
import com.haulmont.charts.gui.data.EntityDataProvider;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.EventObject;
import java.util.function.Consumer;

/**
 * Stock chart component.
 * <br>
 * See documentation for properties of AmStockChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/AmStockChart">http://docs.amcharts.com/3/javascriptstockchart/AmStockChart</a>
 */
public interface StockChart extends Component, StockChartModel<StockChart>, Component.BelongToFrame,
                                    Component.HasXmlDescriptor, Component.HasIcon, Component.HasCaption {
    String NAME = "stockChart";

    /**
     * @return client-specific implementation of chart
     * @deprecated Use properties of StockChart directly
     */
    @Deprecated
    StockChartGroup getConfiguration();

    /**
     * Bind dataset with given datasource.
     *
     * @param id         dataset id
     * @param datasource instance of datasource
     * @see ContainerDataProvider
     * @see EntityDataProvider
     * @see ListDataProvider
     * @deprecated use {@link DataSet#setDataProvider(DataProvider)} instead.
     */
    @Deprecated
    default void setDataSetDatasource(String id, CollectionDatasource datasource) {
        DataSet dataSet = getDataSet(id);
        if (dataSet != null) {
            dataSet.setDataProvider(datasource != null ? new EntityDataProvider(datasource) : null);
        }
    }

    /**
     * Returns datasource of dataset.
     *
     * @param id dataset id.
     * @return datasource of dataset
     * @deprecated use {@link DataSet#getDataProvider()} instead.
     */
    @Deprecated
    default CollectionDatasource getDataSetDatasource(String id) {
        DataSet dataSet = getDataSet(id);
        if (dataSet != null) {
            DataProvider dataProvider = dataSet.getDataProvider();
            if (dataProvider != null) {
                return dataProvider instanceof EntityDataProvider ?
                        ((EntityDataProvider) dataProvider).getDatasource() : null;
            }
        }
        return null;
    }

    /**
     * Resend all items and properties to client and repaint chart.
     * Use this method if you change some property of already displayed chart.
     */
    void repaint();

    /**
     * Adds a listener to stock chart click events. Called when user clicks on the stock chart.
     *
     * @param clickListener a listener to add
     */
    Subscription addClickListener(Consumer<StockChartClickEvent> clickListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeClickListener(Consumer<StockChartClickEvent> clickListener);

    /**
     * Adds listener to stock chart right click events. Called when user clicks on the stock chart.
     *
     * @param clickListener a listener to add
     */
    Subscription addRightClickListener(Consumer<StockChartRightClickEvent> clickListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeRightClickListener(Consumer<StockChartRightClickEvent> clickListener);

    /**
     * Adds listener to stock event click events. Called when user clicks on the stock event.
     *
     * @param clickListener a listener to add
     */
    Subscription addStockEventClickListener(Consumer<StockEventClickEvent> clickListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeStockEventClickListener(Consumer<StockEventClickEvent> clickListener);

    /**
     * Adds a listener to stock event roll-out events. Called when the stock event did roll-out.
     *
     * @param rollOutListener a listener to add
     */
    Subscription addStockEventRollOutListener(Consumer<StockEventRollOutEvent> rollOutListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeStockEventRollOutListener(Consumer<StockEventRollOutEvent> rollOutListener);

    /**
     * Adds listener to stock event roll-over events. Called when the stock event did roll-over.
     *
     * @param rollOverListener a listener to add
     */
    Subscription addStockEventRollOverListener(Consumer<StockEventRollOverEvent> rollOverListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeStockEventRollOverListener(Consumer<StockEventRollOverEvent> rollOverListener);

    /**
     * Adds listener to stock chart zoom events.
     *
     * @param zoomListener a listener to add
     */
    Subscription addZoomListener(Consumer<ZoomEvent> zoomListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeZoomListener(Consumer<ZoomEvent> zoomListener);

    /**
     * Adds a listener to period selector change events. Called when the period selector changed.
     *
     * @param changeListener a listener
     */
    Subscription addPeriodSelectorChangeListener(Consumer<PeriodSelectorChangeEvent> changeListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removePeriodSelectorChangeListener(Consumer<PeriodSelectorChangeEvent> changeListener);

    /**
     * Adds a listener to dataset selector compare events. Called when the data set is selected for comparing.
     *
     * @param compareListener a listener to add
     */
    Subscription addDataSetSelectorCompareListener(Consumer<DataSetSelectorCompareEvent> compareListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeDataSetSelectorCompareListener(Consumer<DataSetSelectorCompareEvent> compareListener);

    /**
     * Adds a listener to dataset selector select events. Called when the dataset selector selected.
     *
     * @param selectListener a listener to add
     */
    Subscription addDataSetSelectorSelectListener(Consumer<DataSetSelectorSelectEvent> selectListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeDataSetSelectorSelectListener(Consumer<DataSetSelectorSelectEvent> selectListener);

    /**
     * Adds a listener to dataset selector uncompare events. Called when the dataset selector removed from
     * comparison.
     *
     * @param unCompareListener a listener to add
     */
    Subscription addDataSetSelectorUnCompareListener(Consumer<DataSetSelectorUnCompareEvent> unCompareListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeDataSetSelectorUnCompareListener(Consumer<DataSetSelectorUnCompareEvent> unCompareListener);

    /**
     * Adds a listener to stock graph click events. Called when user clicks on the stock graph.
     *
     * @param clickListener a listener to add
     */
    Subscription addStockGraphClickListener(Consumer<StockGraphClickEvent> clickListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeStockGraphClickListener(Consumer<StockGraphClickEvent> clickListener);

    /**
     * Adds a listener to stock graph roll-out events. Called when the stock graph did roll-out.
     *
     * @param rollOutListener a listener to add
     */
    Subscription addStockGraphRollOutListener(Consumer<StockGraphRollOutEvent> rollOutListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeStockGraphRollOutListener(Consumer<StockGraphRollOutEvent> rollOutListener);

    /**
     * Adds a listener to stock graph roll-over events. Called when the stock graph did roll-over.
     *
     * @param rollOverListener a listener to add
     */
    Subscription addStockGraphRollOverListener(Consumer<StockGraphRollOverEvent> rollOverListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeStockGraphRollOverListener(Consumer<StockGraphRollOverEvent> rollOverListener);

    /**
     * Adds a listener to stock graph item click events. Called when user clicks on the stock graph item.
     *
     * @param clickListener a listener to add
     */
    Subscription addStockGraphItemClickListener(Consumer<StockGraphItemClickEvent> clickListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeStockGraphItemClickListener(Consumer<StockGraphItemClickEvent> clickListener);

    /**
     * Adds a listener to stock graph item right click events. Called when user clicks on the stock graph item.
     *
     * @param clickListener a listener to add
     */
    Subscription addStockGraphItemRightClickListener(Consumer<StockGraphItemRightClickEvent> clickListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeStockGraphItemRightClickListener(Consumer<StockGraphItemRightClickEvent> clickListener);

    /**
     * Adds a listener to stock graph item roll-out events. Called when the stock graph item did roll-out.
     *
     * @param rollOutListener a listener to add
     */
    Subscription addStockGraphItemRollOutListener(Consumer<StockGraphItemRollOutEvent> rollOutListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeStockGraphItemRollOutListener(Consumer<StockGraphItemRollOutEvent> rollOutListener);

    /**
     * Adds a listener to stock graph item roll-over events.
     *
     * @param rollOverListener a listener to add
     */
    Subscription addStockGraphItemRollOverListener(Consumer<StockGraphItemRollOverEvent> rollOverListener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeStockGraphItemRollOverListener(Consumer<StockGraphItemRollOverEvent> rollOverListener);

    /**
     * Set additional JSON configuration as a string.
     * This JSON can override configuration loaded from XML and from Component API.
     */
    void setNativeJson(String json);

    /**
     * @return additional JSON configuration as a string.
     */
    String getNativeJson();

    abstract class AbstractStockChartEvent extends EventObject {

        public AbstractStockChartEvent(StockChart stockChart) {
            super(stockChart);
        }

        @Override
        public StockChart getSource() {
            return (StockChart) super.getSource();
        }
    }

    abstract class AbstractStockChartClickEvent extends AbstractStockChartEvent {
        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        public AbstractStockChartClickEvent(StockChart stockChart, int x, int y, int absoluteX, int absoluteY) {
            super(stockChart);
            this.x = x;
            this.y = y;
            this.absoluteX = absoluteX;
            this.absoluteY = absoluteY;
        }

        /**
         * @return the X coordinate of the mouse pointer in local (DOM content) coordinates.
         */
        public int getAbsoluteX() {
            return absoluteX;
        }

        /**
         * @return the Y coordinate of the mouse pointer in local (DOM content) coordinates.
         */
        public int getAbsoluteY() {
            return absoluteY;
        }

        /**
         * @return the X coordinate of the mouse pointer in the chart coordinates.
         */
        public int getX() {
            return x;
        }

        /**
         * @return the Y coordinate of the mouse pointer in the chart coordinates.
         */
        public int getY() {
            return y;
        }
    }

    /**
     * Describes stock chart click event.
     */
    class StockChartClickEvent extends AbstractStockChartClickEvent {
        public StockChartClickEvent(StockChart stockChart, int x, int y, int absoluteX, int absoluteY) {
            super(stockChart, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes stock chart right click event.
     */
    class StockChartRightClickEvent extends AbstractStockChartClickEvent {
        public StockChartRightClickEvent(StockChart stockChart, int x, int y, int absoluteX, int absoluteY) {
            super(stockChart, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes StockEvent event.
     */
    abstract class AbstractStockEventEvent extends AbstractStockChartEvent {
        private final String graphId;
        private final Date date;
        private final StockEvent stockEvent;
        private final StockGraph graph;

        protected AbstractStockEventEvent(StockChart stockChart, StockGraph graph, String graphId, Date date,
                                          StockEvent stockEvent) {
            super(stockChart);
            this.graph = graph;
            this.graphId = graphId;
            this.date = date;
            this.stockEvent = stockEvent;
        }

        /**
         * @return graph id
         */
        public String getGraphId() {
            return graphId;
        }

        /**
         * @return stock event date
         */
        public Date getDate() {
            return date;
        }

        /**
         * @return stock event
         */
        public StockEvent getStockEvent() {
            return stockEvent;
        }

        /**
         * @return null or stock graph
         */
        public StockGraph getStockGraph() {
            return graph;
        }
    }

    /**
     * Describes StockEvent click event.
     */
    class StockEventClickEvent extends AbstractStockEventEvent {
        public StockEventClickEvent(StockChart stockChart, StockGraph graph, String graphId, Date date,
                                    StockEvent stockEvent) {
            super(stockChart, graph, graphId, date, stockEvent);
        }
    }

    /**
     * Describes StockEvent roll-out event.
     */
    class StockEventRollOutEvent extends AbstractStockEventEvent {
        public StockEventRollOutEvent(StockChart stockChart, StockGraph graph, String graphId, Date date, StockEvent stockEvent) {
            super(stockChart, graph, graphId, date, stockEvent);
        }
    }

    /**
     * Describes StockEvent roll-over event.
     */
    class StockEventRollOverEvent extends AbstractStockEventEvent {
        public StockEventRollOverEvent(StockChart stockChart, StockGraph graph, String graphId, Date date, StockEvent stockEvent) {
            super(stockChart, graph, graphId, date, stockEvent);
        }
    }

    /**
     * Describes zoom event.
     */
    class ZoomEvent extends AbstractStockChartEvent {
        private final Date startDate;
        private final Date endDate;
        private final DatePeriod period;

        public ZoomEvent(StockChart stockChart, Date startDate, Date endDate, DatePeriod period) {
            super(stockChart);
            this.startDate = startDate;
            this.endDate = endDate;
            this.period = period;
        }

        /**
         * @return end date of the chart zoom period
         */
        public Date getEndDate() {
            return endDate;
        }

        /**
         * @return start date of the chart zoom period
         */
        public Date getStartDate() {
            return startDate;
        }

        /**
         * @return date period
         */
        public DatePeriod getPeriod() {
            return period;
        }
    }

    /**
     * Describes period selector change event.
     */
    class PeriodSelectorChangeEvent extends AbstractStockChartEvent {
        private final Date startDate;
        private final Date endDate;

        private final PeriodType predefinedPeriod;
        private final Integer count;

        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        public PeriodSelectorChangeEvent(StockChart stockChart, Date startDate, Date endDate,
                                         PeriodType predefinedPeriod, Integer count, int x, int y, int absoluteX,
                                         int absoluteY) {
            super(stockChart);
            this.startDate = startDate;
            this.endDate = endDate;
            this.predefinedPeriod = predefinedPeriod;
            this.count = count;
            this.x = x;
            this.y = y;
            this.absoluteX = absoluteX;
            this.absoluteY = absoluteY;
        }

        /**
         * @return period start date
         */
        public Date getStartDate() {
            return startDate;
        }

        /**
         * @return period end date
         */
        public Date getEndDate() {
            return endDate;
        }

        /**
         * @return predefined period type
         */
        public PeriodType getPredefinedPeriod() {
            return predefinedPeriod;
        }

        public Integer getCount() {
            return count;
        }

        /**
         * @return the X coordinate of the mouse pointer in the chart coordinates.
         */
        public int getX() {
            return x;
        }

        /**
         * @return the Y coordinate of the mouse pointer in the chart coordinates.
         */
        public int getY() {
            return y;
        }

        /**
         * @return the X coordinate of the mouse pointer in local (DOM content) coordinates.
         */
        public int getAbsoluteX() {
            return absoluteX;
        }

        /**
         * @return the Y coordinate of the mouse pointer in local (DOM content) coordinates.
         */
        public int getAbsoluteY() {
            return absoluteY;
        }
    }

    /**
     * Describes dataset selector event.
     */
    abstract class AbstractDataSetSelectorEvent extends AbstractStockChartEvent {
        private final String dataSetId;

        protected AbstractDataSetSelectorEvent(StockChart stockChart, String dataSetId) {
            super(stockChart);
            this.dataSetId = dataSetId;
        }

        /**
         * @return dataset id
         */
        public String getDataSetId() {
            return dataSetId;
        }
    }

    /**
     * Describes dataset selector compare event.
     */
    class DataSetSelectorCompareEvent extends AbstractDataSetSelectorEvent {
        public DataSetSelectorCompareEvent(StockChart stockChart, String dataSetId) {
            super(stockChart, dataSetId);
        }
    }

    /**
     * Describes dataset selector select event.
     */
    class DataSetSelectorSelectEvent extends AbstractDataSetSelectorEvent {
        public DataSetSelectorSelectEvent(StockChart stockChart, String dataSetId) {
            super(stockChart, dataSetId);
        }
    }

    /**
     * Describes dataset selector uncompare event.
     */
    class DataSetSelectorUnCompareEvent extends AbstractDataSetSelectorEvent {
        public DataSetSelectorUnCompareEvent(StockChart stockChart, String dataSetId) {
            super(stockChart, dataSetId);
        }
    }

    /**
     * Describes stock graph event.
     */
    abstract class AbstractStockGraphEvent extends AbstractStockChartEvent {

        private final String panelId;
        private final String graphId;
        private final StockGraph stockGraph;
        private final StockPanel stockPanel;
        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        protected AbstractStockGraphEvent(StockChart stockChart, StockPanel stockPanel, String panelId,
                                          StockGraph stockGraph, String graphId, int x, int y,
                                          int absoluteX, int absoluteY) {
            super(stockChart);
            this.panelId = panelId;
            this.graphId = graphId;
            this.stockGraph = stockGraph;
            this.stockPanel = stockPanel;
            this.x = x;
            this.y = y;
            this.absoluteX = absoluteX;
            this.absoluteY = absoluteY;
        }

        /**
         * @return panel id
         */
        public String getPanelId() {
            return panelId;
        }

        /**
         * @return graph id
         */
        public String getGraphId() {
            return graphId;
        }

        /**
         * @return the X coordinate of the mouse pointer in the chart coordinates.
         */
        public int getX() {
            return x;
        }

        /**
         * @return the Y coordinate of the mouse pointer in the chart coordinates.
         */
        public int getY() {
            return y;
        }

        /**
         * @return the X coordinate of the mouse pointer in local (DOM content) coordinates.
         */
        public int getAbsoluteX() {
            return absoluteX;
        }

        /**
         * @return the Y coordinate of the mouse pointer in local (DOM content) coordinates.
         */
        public int getAbsoluteY() {
            return absoluteY;
        }

        /**
         * @return null or stock graph
         */
        public StockGraph getStockGraph() {
            return stockGraph;
        }

        /**
         * @return null or stock panel
         */
        public StockPanel getStockPanel() {
            return stockPanel;
        }
    }

    /**
     * Describes stock graph click event.
     */
    class StockGraphClickEvent extends AbstractStockGraphEvent {
        public StockGraphClickEvent(StockChart stockChart, StockPanel stockPanel, String panelId,
                                    StockGraph stockGraph, String graphId, int x, int y, int absoluteX, int absoluteY) {
            super(stockChart, stockPanel, panelId, stockGraph, graphId, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes stock graph roll-out event.
     */
    class StockGraphRollOutEvent extends AbstractStockGraphEvent {
        public StockGraphRollOutEvent(StockChart stockChart, StockPanel stockPanel, String panelId,
                                      StockGraph stockGraph, String graphId, int x, int y, int absoluteX,
                                      int absoluteY) {
            super(stockChart, stockPanel, panelId, stockGraph, graphId, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes stock graph roll over event.
     */
    class StockGraphRollOverEvent extends AbstractStockGraphEvent {
        public StockGraphRollOverEvent(StockChart stockChart, StockPanel stockPanel, String panelId,
                                       StockGraph stockGraph, String graphId, int x, int y, int absoluteX,
                                       int absoluteY) {
            super(stockChart, stockPanel, panelId, stockGraph, graphId, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes stock graph item event.
     */
    abstract class AbstractStockGraphItemEvent extends AbstractStockChartEvent {
        private final String panelId;
        private final String graphId;

        private final StockPanel stockPanel;
        private final StockGraph stockGraph;

        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        private final DataItem dataItem;
        private final int itemIndex;

        protected AbstractStockGraphItemEvent(StockChart stockChart, StockPanel stockPanel, String panelId,
                                              StockGraph stockGraph, String graphId, DataItem dataItem,
                                              int itemIndex, int x, int y, int absoluteX, int absoluteY) {
            super(stockChart);
            this.panelId = panelId;
            this.dataItem = dataItem;
            this.stockPanel = stockPanel;
            this.stockGraph = stockGraph;
            this.itemIndex = itemIndex;
            this.absoluteY = absoluteY;
            this.absoluteX = absoluteX;
            this.graphId = graphId;
            this.x = x;
            this.y = y;
        }

        /**
         * @return panel id
         */
        public String getPanelId() {
            return panelId;
        }

        /**
         * @return graph id
         */
        public String getGraphId() {
            return graphId;
        }

        /**
         * @return an item
         * @deprecated Use {@link #getEntity()} or {@link #getEntityNN()}
         */
        @Deprecated
        public Entity getItem() {
            return getEntity();
        }

        @Nullable
        public DataItem getDataItem() {
            return dataItem;
        }

        public DataItem getDataItemNN() {
            if (dataItem == null) {
                throw new IllegalStateException("dataItem is null");
            }
            return dataItem;
        }

        @Nullable
        public Entity getEntity() {
            if (dataItem != null) {
                return ((EntityDataItem) dataItem).getItem();
            }
            return null;
        }

        public Entity getEntityNN() {
            if (dataItem == null) {
                throw new IllegalStateException("dataItem is null");
            }
            return ((EntityDataItem) dataItem).getItem();
        }

        /**
         * @return item index
         */
        public int getItemIndex() {
            return itemIndex;
        }

        /**
         * @return the X coordinate of the mouse pointer in the chart coordinates.
         */
        public int getX() {
            return x;
        }

        /**
         * @return the X coordinate of the mouse pointer in the chart coordinates.
         */
        public int getY() {
            return y;
        }

        /**
         * @return the X coordinate of the mouse pointer in local (DOM content) coordinates.
         */
        public int getAbsoluteX() {
            return absoluteX;
        }

        /**
         * @return the Y coordinate of the mouse pointer in local (DOM content) coordinates.
         */
        public int getAbsoluteY() {
            return absoluteY;
        }

        /**
         * @return null or panel that contains clicked stock graph item
         */
        public StockPanel getStockPanel() {
            return stockPanel;
        }

        /**
         * @return null or stock graph that contains clicked item
         */
        public StockGraph getStockGraph() {
            return stockGraph;
        }
    }

    /**
     * Describes stock graph item click event.
     */
    class StockGraphItemClickEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemClickEvent(StockChart stockChart, StockPanel stockPanel, String panelId,
                                        StockGraph stockGraph, String graphId, DataItem item, int itemIndex, int x,
                                        int y, int absoluteX, int absoluteY) {
            super(stockChart, stockPanel, panelId, stockGraph, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes stock graph item click event.
     */
    class StockGraphItemRightClickEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemRightClickEvent(StockChart stockChart, StockPanel stockPanel, String panelId,
                                             StockGraph stockGraph, String graphId, DataItem item,
                                             int itemIndex, int x, int y, int absoluteX, int absoluteY) {
            super(stockChart, stockPanel, panelId, stockGraph, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes stock graph item roll-out event.
     */
    class StockGraphItemRollOutEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemRollOutEvent(StockChart stockChart, StockPanel stockPanel, String panelId,
                                          StockGraph stockGraph, String graphId, DataItem item, int itemIndex, int x,
                                          int y, int absoluteX, int absoluteY) {
            super(stockChart, stockPanel, panelId, stockGraph, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes stock graph item roll-over event.
     */
    class StockGraphItemRollOverEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemRollOverEvent(StockChart stockChart, StockPanel stockPanel, String panelId,
                                           StockGraph stockGraph, String graphId, DataItem item,
                                           int itemIndex, int x, int y, int absoluteX, int absoluteY) {
            super(stockChart, stockPanel, panelId, stockGraph, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }
}