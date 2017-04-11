/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.DatePeriod;
import com.haulmont.charts.gui.amcharts.model.PeriodType;
import com.haulmont.charts.gui.amcharts.model.StockEvent;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartModel;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.EntityDataItem;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.annotation.Nullable;
import java.util.Date;

/**
 * See documentation for properties of AmStockChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/AmStockChart">http://docs.amcharts.com/3/javascriptstockchart/AmStockChart</a>
 */
public interface StockChart extends Component, StockChartModel<StockChart>, Component.BelongToFrame,
                                    Component.HasXmlDescriptor, Component.HasIcon, Component.HasCaption {
    String NAME = "stockChart";

    /**
     * @deprecated Use properties of StockChart directly
     * @return client-specific implementation of chart
     */
    @Deprecated
    StockChartGroup getConfiguration();

    /**
     * Bind dataset with given datasource.
     *
     * @param id         dataset id
     * @param datasource instance of datasource
     */
    void setDataSetDatasource(String id, CollectionDatasource datasource);

    /**
     * Returns datasource of dataset.
     *
     * @param id dataset id.
     * @return datasource of dataset
     */
    CollectionDatasource getDataSetDatasource(String id);

    /**
     * Resend all items and properties to client and repaint chart.
     * Use this method if you change some property of already displayed chart.
     */
    void repaint();

    void addClickListener(StockChartClickListener clickListener);
    void removeClickListener(StockChartClickListener clickListener);

    void addRightClickListener(StockChartRightClickListener clickListener);
    void removeRightClickListener(StockChartRightClickListener clickListener);

    void addStockEventClickListener(StockEventClickListener clickListener);
    void removeStockEventClickListener(StockEventClickListener clickListener);

    void addStockEventRollOutListener(StockEventRollOutListener rollOutListener);
    void removeStockEventRollOutListener(StockEventRollOutListener rollOutListener);

    void addStockEventRollOverListener(StockEventRollOverListener rollOverListener);
    void removeStockEventRollOverListener(StockEventRollOverListener rollOverListener);

    void addZoomListener(ZoomListener zoomListener);
    void removeZoomListener(ZoomListener zoomListener);

    void addPeriodSelectorChangeListener(PeriodSelectorChangeListener changeListener);
    void removePeriodSelectorChangeListener(PeriodSelectorChangeListener changeListener);

    void addDataSetSelectorCompareListener(DataSetSelectorCompareListener compareListener);
    void removeDataSetSelectorCompareListener(DataSetSelectorCompareListener compareListener);

    void addDataSetSelectorSelectListener(DataSetSelectorSelectListener selectListener);
    void removeDataSetSelectorSelectListener(DataSetSelectorSelectListener selectListener);

    void addDataSetSelectorUnCompareListener(DataSetSelectorUnCompareListener unCompareListener);
    void removeDataSetSelectorUnCompareListener(DataSetSelectorUnCompareListener unCompareListener);

    void addStockGraphClickListener(StockGraphClickListener clickListener);
    void removeStockGraphClickListener(StockGraphClickListener clickListener);

    void addStockGraphRollOutListener(StockGraphRollOutListener rollOutListener);
    void removeStockGraphRollOutListener(StockGraphRollOutListener rollOutListener);

    void addStockGraphRollOverListener(StockGraphRollOverListener rollOverListener);
    void removeStockGraphRollOverListener(StockGraphRollOverListener rollOverListener);

    void addStockGraphItemClickListener(StockGraphItemClickListener clickListener);
    void removeStockGraphItemClickListener(StockGraphItemClickListener clickListener);

    void addStockGraphItemRightClickListener(StockGraphItemRightClickListener clickListener);
    void removeStockGraphItemRightClickListener(StockGraphItemRightClickListener clickListener);

    void addStockGraphItemRollOutListener(StockGraphItemRollOutListener rollOutListener);
    void removeStockGraphItemRollOutListener(StockGraphItemRollOutListener rollOutListener);

    void addStockGraphItemRollOverListener(StockGraphItemRollOverListener rollOverListener);
    void removeStockGraphItemRollOverListener(StockGraphItemRollOverListener rollOverListener);

    /**
     * Set additional JSON configuration as a string.
     * This JSON can override configuration loaded from XML and from Component API.
     */
    void setNativeJson(String json);
    /**
     * @return additional JSON configuration as a string.
     */
    String getNativeJson();

    abstract class AbstractStockChartClickEvent {
        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        public AbstractStockChartClickEvent(int x, int y, int absoluteX, int absoluteY) {
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
        public StockChartClickEvent(int x, int y, int absoluteX, int absoluteY) {
            super(x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the stock chart click events.
     */
    interface StockChartClickListener {
        /**
         * Called when user clicks on the stock chart.
         *
         * @param event event object
         */
        void onClick(StockChartClickEvent event);
    }

    /**
     * Describes stock chart right click event.
     */
    class StockChartRightClickEvent extends AbstractStockChartClickEvent {
        public StockChartRightClickEvent(int x, int y, int absoluteX, int absoluteY) {
            super(x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the stock chart right click events.
     */
    interface StockChartRightClickListener {
        /**
         * Called when user clicks on the stock chart.
         *
         * @param event event object
         */
        void onRightClick(StockChartRightClickEvent event);
    }

    /**
     * Describes StockEvent event.
     */
    abstract class AbstractStockEventEvent {
        private final String graphId;
        private final Date date;
        private final StockEvent stockEvent;

        protected AbstractStockEventEvent(String graphId, Date date, StockEvent stockEvent) {
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
    }

    /**
     * Describes StockEvent click event.
     */
    class StockEventClickEvent extends AbstractStockEventEvent {
        public StockEventClickEvent(String graphId, Date date, StockEvent stockEvent) {
            super(graphId, date, stockEvent);
        }
    }

    /**
     * Listener to the stock event click events.
     */
    interface StockEventClickListener {
        /**
         * Called when user clicks on the stock event.
         *
         * @param event event object
         */
        void onClick(StockEventClickEvent event);
    }

    /**
     * Describes StockEvent roll-out event.
     */
    class StockEventRollOutEvent extends AbstractStockEventEvent {
        public StockEventRollOutEvent(String graphId, Date date, StockEvent stockEvent) {
            super(graphId, date, stockEvent);
        }
    }

    /**
     * Listener to the stock event roll-out events.
     */
    interface StockEventRollOutListener {
        /**
         * Called when the stock event did roll-out
         *
         * @param event event object
         */
        void onRollOut(StockEventRollOutEvent event);
    }

    /**
     * Describes StockEvent roll-over event.
     */
    class StockEventRollOverEvent extends AbstractStockEventEvent {
        public StockEventRollOverEvent(String graphId, Date date, StockEvent stockEvent) {
            super(graphId, date, stockEvent);
        }
    }

    /**
     * Listener to the stock event roll-over events.
     */
    interface StockEventRollOverListener {
        /**
         * Called when the stock event did roll-over
         *
         * @param event event object
         */
        void onRollOver(StockEventRollOverEvent event);
    }

    /**
     * Describes zoom event.
     */
    class ZoomEvent {
        private final Date startDate;
        private final Date endDate;
        private final DatePeriod period;

        public ZoomEvent(Date startDate, Date endDate, DatePeriod period) {
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
     * Listener to the stock chart zoom events.
     */
    interface ZoomListener {
        /**
         * Called when value of the stock chart zoom changed.
         *
         * @param event event object
         */
        void onZoom(ZoomEvent event);
    }

    /**
     * Describes period selector change event.
     */
    class PeriodSelectorChangeEvent {
        private final Date startDate;
        private final Date endDate;

        private final PeriodType predefinedPeriod;
        private final Integer count;

        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        public PeriodSelectorChangeEvent(Date startDate, Date endDate, PeriodType predefinedPeriod,
                                         Integer count, int x, int y, int absoluteX, int absoluteY) {
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
     * Listener to the period selector change events.
     */
    interface PeriodSelectorChangeListener {
        /**
         * Called when the period selector changed
         *
         * @param event event object
         */
        void onChange(PeriodSelectorChangeEvent event);
    }

    /**
     * Describes dataset selector event.
     */
    abstract class AbstractDataSetSelectorEvent {
        private final String dataSetId;

        protected AbstractDataSetSelectorEvent(String dataSetId) {
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
        public DataSetSelectorCompareEvent(String dataSetId) {
            super(dataSetId);
        }
    }

    /**
     * Listener to dataset selector compare events.
     */
    interface DataSetSelectorCompareListener {
        void onCompare(DataSetSelectorCompareEvent event);
    }

    /**
     * Describes dataset selector select event.
     */
    class DataSetSelectorSelectEvent extends AbstractDataSetSelectorEvent {
        public DataSetSelectorSelectEvent(String dataSetId) {
            super(dataSetId);
        }
    }

    /**
     * Listener to dataset selector select events.
     */
    interface DataSetSelectorSelectListener {
        /**
         * Called when the dataset selector selected.
         *
         * @param event event object
         */
        void onSelect(DataSetSelectorSelectEvent event);
    }

    /**
     * Describes dataset selector uncompare event.
     */
    class DataSetSelectorUnCompareEvent extends AbstractDataSetSelectorEvent {
        public DataSetSelectorUnCompareEvent(String dataSetId) {
            super(dataSetId);
        }
    }

    /**
     * Listener to the dataset selector uncompare events.
     */
    interface DataSetSelectorUnCompareListener {
        /**
         * Called when the dataset selector removed from comparison.
         *
         * @param event event object
         */
        void onUnCompare(DataSetSelectorUnCompareEvent event);
    }

    /**
     * Describes stock graph event.
     */
    abstract class AbstractStockGraphEvent {

        private final String panelId;
        private final String graphId;
        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        protected AbstractStockGraphEvent(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY) {
            this.panelId = panelId;
            this.graphId = graphId;
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
    }

    /**
     * Describes stock graph click event.
     */
    class StockGraphClickEvent extends AbstractStockGraphEvent {
        public StockGraphClickEvent(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the stock graph click events.
     */
    interface StockGraphClickListener {
        /**
         * Called when user clicks on the stock graph.
         *
         * @param event event object
         */
        void onClick(StockGraphClickEvent event);
    }

    /**
     * Describes stock graph roll-out event.
     */
    class StockGraphRollOutEvent extends AbstractStockGraphEvent {
        public StockGraphRollOutEvent(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the stock graph roll-out events.
     */
    interface StockGraphRollOutListener {
        /**
         * Called when the stock graph did roll-out.
         *
         * @param event event object
         */
        void onRollOut(StockGraphRollOutEvent event);
    }

    /**
     * Describes stock graph roll over event.
     */
    class StockGraphRollOverEvent extends AbstractStockGraphEvent {
        public StockGraphRollOverEvent(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the stock graph roll-over events.
     */
    interface StockGraphRollOverListener {
        /**
         * Called when the stock graph did roll-over.
         *
         * @param event event object
         */
        void onRollOver(StockGraphRollOverEvent event);
    }

    /**
     * Describes stock graph item event.
     */
    abstract class AbstractStockGraphItemEvent {
        private final String panelId;
        private final String graphId;

        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        private final DataItem dataItem;
        private final int itemIndex;

        protected AbstractStockGraphItemEvent(String panelId, String graphId, DataItem dataItem, int itemIndex,
                                              int x, int y, int absoluteX, int absoluteY) {
            this.panelId = panelId;
            this.dataItem = dataItem;
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
    }

    /**
     * Describes stock graph item click event.
     */
    class StockGraphItemClickEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemClickEvent(String panelId, String graphId, DataItem item, int itemIndex,
                                        int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the stock graph item click events.
     */
    interface StockGraphItemClickListener {
        /**
         * Called when user clicks on the stock graph item.
         *
         * @param event event object
         */
        void onClick(StockGraphItemClickEvent event);
    }

    /**
     * Describes stock graph item click event.
     */
    class StockGraphItemRightClickEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemRightClickEvent(String panelId, String graphId, DataItem item, int itemIndex,
                                             int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the stock graph item right click events.
     */
    interface StockGraphItemRightClickListener {
        /**
         * Called when user clicks on the stock graph item.
         *
         * @param event event object
         */
        void onClick(StockGraphItemRightClickEvent event);
    }

    /**
     * Describes stock graph item roll-out event.
     */
    class StockGraphItemRollOutEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemRollOutEvent(String panelId, String graphId, DataItem item, int itemIndex,
                                          int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the stock graph item roll-out events.
     */
    interface StockGraphItemRollOutListener {
        /**
         * Called when the stock graph item did roll-out.
         *
         * @param event event object
         */
        void onRollOut(StockGraphItemRollOutEvent event);
    }

    /**
     * Describes stock graph item roll-over event.
     */
    class StockGraphItemRollOverEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemRollOverEvent(String panelId, String graphId, DataItem item, int itemIndex,
                                           int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the stock graph item roll-over events.
     */
    interface StockGraphItemRollOverListener {
        /**
         * Called when the stock graph item did roll-over.
         *
         * @param event event object
         */
        void onRollOver(StockGraphItemRollOverEvent event);
    }
}