/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.DatePeriod;
import com.haulmont.charts.gui.amcharts.model.PeriodType;
import com.haulmont.charts.gui.amcharts.model.StockEvent;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import java.util.Date;

/**
 * @author gorelov
 * @version $Id$
 */
public interface StockChart extends Component, Component.BelongToFrame, Component.HasXmlDescriptor {
    String NAME = "stockChart";

    StockChartGroup getConfiguration();

    void setConfiguration(StockChartGroup chart);

    void setDataSetDatasource(String id, CollectionDatasource datasource);
    CollectionDatasource getDataSetDatasource(String id);

    void repaint();

    void addClickListener(StockChartClickListener clickListener);
    void removeClickListener(StockChartClickListener clickListener);

    void addRightClickListener(StockChartClickListener clickListener);
    void removeRightClickListener(StockChartClickListener clickListener);

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

    void addStockGraphItemRightClickListener(StockGraphItemClickListener clickListener);
    void removeStockGraphItemRightClickListener(StockGraphItemClickListener clickListener);

    void addStockGraphItemRollOutListener(StockGraphItemRollOutListener rollOutListener);
    void removeStockGraphItemRollOutListener(StockGraphItemRollOutListener rollOutListener);

    void addStockGraphItemRollOverListener(StockGraphItemRollOverListener rollOverListener);
    void removeStockGraphItemRollOverListener(StockGraphItemRollOverListener rollOverListener);

    class StockChartClickEvent {

        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        public StockChartClickEvent(int x, int y, int absoluteX, int absoluteY) {
            this.x = x;
            this.y = y;
            this.absoluteX = absoluteX;
            this.absoluteY = absoluteY;
        }

        public int getAbsoluteX() {
            return absoluteX;
        }

        public int getAbsoluteY() {
            return absoluteY;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    interface StockChartClickListener {
        void onClick(StockChartClickEvent event);
    }

    abstract class AbstractStockEventEvent {
        private final String graphId;
        private final Date date;
        private final StockEvent stockEvent;

        protected AbstractStockEventEvent(String graphId, Date date, StockEvent stockEvent) {
            this.graphId = graphId;
            this.date = date;
            this.stockEvent = stockEvent;
        }

        public String getGraphId() {
            return graphId;
        }

        public Date getDate() {
            return date;
        }

        public StockEvent getStockEvent() {
            return stockEvent;
        }
    }

    class StockEventClickEvent extends AbstractStockEventEvent {
        public StockEventClickEvent(String graphId, Date date, StockEvent stockEvent) {
            super(graphId, date, stockEvent);
        }
    }

    interface StockEventClickListener {
        void onClick(StockEventClickEvent event);
    }

    class StockEventRollOutEvent extends AbstractStockEventEvent {
        public StockEventRollOutEvent(String graphId, Date date, StockEvent stockEvent) {
            super(graphId, date, stockEvent);
        }
    }

    interface StockEventRollOutListener {
        void onRollOut(StockEventRollOutEvent event);
    }

    class StockEventRollOverEvent extends AbstractStockEventEvent {
        public StockEventRollOverEvent(String graphId, Date date, StockEvent stockEvent) {
            super(graphId, date, stockEvent);
        }
    }

    interface StockEventRollOverListener {
        void onRollOver(StockEventRollOverEvent event);
    }

    class ZoomEvent {
        private final Date startDate;
        private final Date endDate;
        private final DatePeriod period;

        public ZoomEvent(Date startDate, Date endDate, DatePeriod period) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.period = period;
        }

        public Date getEndDate() {
            return endDate;
        }

        public Date getStartDate() {
            return startDate;
        }

        public DatePeriod getPeriod() {
            return period;
        }
    }

    interface ZoomListener {
        void onZoom(ZoomEvent event);
    }

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

        public Date getStartDate() {
            return startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public PeriodType getPredefinedPeriod() {
            return predefinedPeriod;
        }

        public Integer getCount() {
            return count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getAbsoluteX() {
            return absoluteX;
        }

        public int getAbsoluteY() {
            return absoluteY;
        }
    }

    interface PeriodSelectorChangeListener {
        void onChange(PeriodSelectorChangeEvent event);
    }

    abstract class AbstractDataSetSelectorEvent {
        private final String dataSetId;

        protected AbstractDataSetSelectorEvent(String dataSetId) {
            this.dataSetId = dataSetId;
        }

        public String getDataSetId() {
            return dataSetId;
        }
    }

    class DataSetSelectorCompareEvent extends AbstractDataSetSelectorEvent {
        public DataSetSelectorCompareEvent(String dataSetId) {
            super(dataSetId);
        }
    }

    interface DataSetSelectorCompareListener {
        void onCompare(DataSetSelectorCompareEvent event);
    }

    class DataSetSelectorSelectEvent extends AbstractDataSetSelectorEvent {
        public DataSetSelectorSelectEvent(String dataSetId) {
            super(dataSetId);
        }
    }

    interface DataSetSelectorSelectListener {
        void onSelect(DataSetSelectorSelectEvent event);
    }

    class DataSetSelectorUnCompareEvent extends AbstractDataSetSelectorEvent {
        public DataSetSelectorUnCompareEvent(String dataSetId) {
            super(dataSetId);
        }
    }

    interface DataSetSelectorUnCompareListener {
        void onUnCompare(DataSetSelectorUnCompareEvent event);
    }

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

        public String getPanelId() {
            return panelId;
        }

        public String getGraphId() {
            return graphId;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getAbsoluteX() {
            return absoluteX;
        }

        public int getAbsoluteY() {
            return absoluteY;
        }
    }

    class StockGraphClickEvent extends AbstractStockGraphEvent {
        public StockGraphClickEvent(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, x, y, absoluteX, absoluteY);
        }
    }

    interface StockGraphClickListener {
        void onClick(StockGraphClickEvent event);
    }

    class StockGraphRollOutEvent extends AbstractStockGraphEvent {
        public StockGraphRollOutEvent(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, x, y, absoluteX, absoluteY);
        }
    }

    interface StockGraphRollOutListener {
        void onRollOut(StockGraphRollOutEvent event);
    }

    class StockGraphRollOverEvent extends AbstractStockGraphEvent {
        public StockGraphRollOverEvent(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, x, y, absoluteX, absoluteY);
        }
    }

    interface StockGraphRollOverListener {
        void onRollOver(StockGraphRollOverEvent event);
    }

    abstract class AbstractStockGraphItemEvent {
        private final String panelId;
        private final String graphId;

        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        private final Entity item;
        private final int itemIndex;

        protected AbstractStockGraphItemEvent(String panelId, String graphId, Entity item, int itemIndex,
                                              int x, int y, int absoluteX, int absoluteY) {
            this.panelId = panelId;
            this.item = item;
            this.itemIndex = itemIndex;
            this.absoluteY = absoluteY;
            this.absoluteX = absoluteX;
            this.graphId = graphId;
            this.x = x;
            this.y = y;
        }

        public String getPanelId() {
            return panelId;
        }

        public String getGraphId() {
            return graphId;
        }

        public Entity getItem() {
            return item;
        }

        public int getItemIndex() {
            return itemIndex;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getAbsoluteX() {
            return absoluteX;
        }

        public int getAbsoluteY() {
            return absoluteY;
        }
    }

    class StockGraphItemClickEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemClickEvent(String panelId, String graphId, Entity item, int itemIndex,
                                        int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    interface StockGraphItemClickListener {
        void onClick(StockGraphItemClickEvent event);
    }

    class StockGraphItemRollOutEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemRollOutEvent(String panelId, String graphId, Entity item, int itemIndex,
                                          int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    interface StockGraphItemRollOutListener {
        void onRollOut(StockGraphItemRollOutEvent event);
    }

    class StockGraphItemRollOverEvent extends AbstractStockGraphItemEvent {
        public StockGraphItemRollOverEvent(String panelId, String graphId, Entity item, int itemIndex,
                                           int x, int y, int absoluteX, int absoluteY) {
            super(panelId, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    interface StockGraphItemRollOverListener {
        void onRollOver(StockGraphItemRollOverEvent event);
    }
}
