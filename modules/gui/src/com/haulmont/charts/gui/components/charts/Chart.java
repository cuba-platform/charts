/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */
package com.haulmont.charts.gui.components.charts;

import com.haulmont.bali.events.Subscription;
import com.haulmont.charts.gui.amcharts.model.Graph;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.amcharts.model.charts.ChartModel;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.gui.data.EntityDataItem;
import com.haulmont.charts.gui.data.EntityDataProvider;
import com.haulmont.charts.gui.data.ContainerDataProvider;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.EventObject;
import java.util.function.Consumer;

/**
 * Base interface for all *Chart components.
 *
 * @param <T> type of builder methods
 */
public interface Chart<T extends Chart> extends Component, ChartModel<T>, Component.BelongToFrame, Component.HasIcon,
        Component.HasCaption {

    /**
     * @deprecated Do not create this Component programmatically. Use concrete Chart implementation.
     */
    @Deprecated
    String NAME = "chart";

    /**
     * @return client-specific implementation of the chart
     * @deprecated Use concrete Chart implementation.
     */
    @Deprecated
    AbstractChart getConfiguration();

    /**
     * @deprecated use {@link Chart#getDataProvider()} instead.
     */
    @Deprecated
    default CollectionDatasource getDatasource() {
        DataProvider dataProvider = getDataProvider();

        return dataProvider instanceof EntityDataProvider ?
                ((EntityDataProvider) dataProvider).getDatasource() : null;
    }

    /**
     * @see ContainerDataProvider
     * @see EntityDataProvider
     * @see ListDataProvider
     * @deprecated use {@link Chart#setDataProvider(DataProvider)} instead.
     */
    @Deprecated
    default void setDatasource(CollectionDatasource datasource) {
        setDataProvider(datasource != null ? new EntityDataProvider(datasource) : null);
    }

    /**
     * @return the data provider
     */
    @Override
    DataProvider getDataProvider();

    /**
     * @param dataProvider the data provider
     * @return chart
     * @see ContainerDataProvider
     * @see EntityDataProvider
     * @see ListDataProvider
     */
    @Override
    T setDataProvider(DataProvider dataProvider);

    /**
     * Resend all items and properties to client and repaint chart.
     * Use this method if you change some property of already displayed chart.
     */
    void repaint();

    /**
     * Adds a listener for a chart. Called when user clicks on the chart.
     *
     * @param listener a listener to add
     */
    Subscription addClickListener(Consumer<ChartClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeClickListener(Consumer<ChartClickEvent> listener);

    /**
     * Adds a listener for a chart. Called when user clicks on the chart.
     *
     * @param listener a listener to add
     */
    Subscription addRightClickListener(Consumer<ChartRightClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeRightClickListener(Consumer<ChartRightClickEvent> listener);

    /**
     * Adds a listener for a chart. Called when the legend item hided.
     *
     * @param listener a listener to add
     */
    Subscription addLegendItemHideListener(Consumer<LegendItemHideEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeLegendItemHideListener(Consumer<LegendItemHideEvent> listener);

    /**
     * Adds a listener for a chart. Called when the legend item showed.
     *
     * @param listener a listener to add
     */
    Subscription addLegendItemShowListener(Consumer<LegendItemShowEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeLegendItemShowListener(Consumer<LegendItemShowEvent> listener);

    /**
     * Adds a listener for a chart. Called when user clicks on the legend item.
     *
     * @param listener a listener to add
     */
    Subscription addLegendLabelClickListener(Consumer<LegendItemClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeLegendLabelClickListener(Consumer<LegendItemClickEvent> listener);

    /**
     * Adds a listener for a chart. Called when user clicks on the legend marker.
     *
     * @param listener a listener to add
     */
    Subscription addLegendMarkerClickListener(Consumer<LegendMarkerClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeLegendMarkerClickListener(Consumer<LegendMarkerClickEvent> listener);

    /**
     * Set additional JSON configuration as a string.
     * This JSON can override configuration loaded from XML and from Component API.
     */
    void setNativeJson(String json);

    /**
     * @return additional JSON configuration as a string.
     */
    String getNativeJson();

    abstract class AbstractChartEvent extends EventObject {

        public AbstractChartEvent(Chart source) {
            super(source);
        }

        @Override
        public Chart getSource() {
            return (Chart) super.getSource();
        }
    }

    abstract class AbstractItemEvent extends AbstractChartEvent {
        private final DataItem dataItem;

        public AbstractItemEvent(Chart chart, DataItem dataItem) {
            super(chart);
            this.dataItem = dataItem;
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
    }

    abstract class AbstractClickEvent extends AbstractChartEvent {
        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        public AbstractClickEvent(Chart chart, int x, int y, int absoluteX, int absoluteY) {
            super(chart);
            this.x = x;
            this.y = y;
            this.absoluteX = absoluteX;
            this.absoluteY = absoluteY;
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

    abstract class AbstractChartClickEvent extends AbstractClickEvent {
        private final double xAxis;
        private final double yAxis;

        public AbstractChartClickEvent(Chart chart, int x, int y, int absoluteX, int absoluteY, double xAxis,
                                       double yAxis) {
            super(chart, x, y, absoluteX, absoluteY);
            this.xAxis = xAxis;
            this.yAxis = yAxis;
        }

        public double getxAxis() {
            return xAxis;
        }

        public double getyAxis() {
            return yAxis;
        }
    }

    abstract class AbstractGraphItemClickEvent extends AbstractClickEvent {
        private final String graphId;
        private final Graph graph;
        private final DataItem dataItem;
        private final int itemIndex;

        public AbstractGraphItemClickEvent(Chart chart, Graph graph, String graphId, DataItem dataItem,
                                           int itemIndex, int x, int y, int absoluteX, int absoluteY) {
            super(chart, x, y, absoluteX, absoluteY);
            this.graph = graph;
            this.dataItem = dataItem;
            this.itemIndex = itemIndex;
            this.graphId = graphId;
        }

        public String getGraphId() {
            return graphId;
        }

        /**
         * @return entity
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

        public int getItemIndex() {
            return itemIndex;
        }

        /**
         * @return null or graph that contains clicked graph item
         */
        public Graph getGraph() {
            return graph;
        }
    }

    abstract class AbstractSliceClickEvent extends AbstractClickEvent {
        private final DataItem dataItem;

        public AbstractSliceClickEvent(Chart chart, DataItem dataItem, int x, int y, int absoluteX, int absoluteY) {
            super(chart, x, y, absoluteX, absoluteY);
            this.dataItem = dataItem;
        }

        /**
         * @return entity related with event
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
    }

    abstract class AbstractCursorEvent extends AbstractChartEvent {
        private final String start;
        private final String end;

        public AbstractCursorEvent(Chart chart, String start, String end) {
            super(chart);
            this.start = start;
            this.end = end;
        }

        /**
         * @return start period
         */
        public String getStart() {
            return start;
        }

        /**
         * @return end period
         */
        public String getEnd() {
            return end;
        }
    }

    /**
     * Describes axis zoom event.
     */
    class AxisZoomEvent {
        private final String axisId;
        private final double startValue;
        private final double endValue;

        public AxisZoomEvent(String axisId, double startValue, double endValue) {
            this.axisId = axisId;
            this.startValue = startValue;
            this.endValue = endValue;
        }

        /**
         * @return axis id
         */
        public String getAxisId() {
            return axisId;
        }

        /**
         * @return axis end value
         */
        public double getEndValue() {
            return endValue;
        }

        /**
         * @return axis start value
         */
        public double getStartValue() {
            return startValue;
        }
    }

    /**
     * Describes chart click event.
     */
    class ChartClickEvent extends AbstractChartClickEvent {
        public ChartClickEvent(Chart chart, int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis) {
            super(chart, x, y, absoluteX, absoluteY, xAxis, yAxis);
        }
    }

    /**
     * Describes chart click event.
     */
    class ChartRightClickEvent extends AbstractChartClickEvent {
        public ChartRightClickEvent(Chart chart, int x, int y, int absoluteX, int absoluteY, double xAxis,
                                    double yAxis) {
            super(chart, x, y, absoluteX, absoluteY, xAxis, yAxis);
        }
    }

    /**
     * Describes cursor period select event.
     */
    class CursorPeriodSelectEvent extends AbstractCursorEvent {

        public CursorPeriodSelectEvent(Chart chart, String start, String end) {
            super(chart, start, end);
        }
    }

    /**
     * Describes cursor zoom event.
     */
    class CursorZoomEvent extends AbstractCursorEvent {
        public CursorZoomEvent(Chart chart, String start, String end) {
            super(chart, start, end);
        }
    }

    /**
     * Describes graph click event.
     */
    class GraphClickEvent extends AbstractClickEvent {

        private final String graphId;

        public GraphClickEvent(Chart chart, String graphId, int x, int y, int absoluteX, int absoluteY) {
            super(chart, x, y, absoluteX, absoluteY);
            this.graphId = graphId;
        }

        /**
         * @return graph id
         */
        public String getGraphId() {
            return graphId;
        }
    }

    /**
     * Describes graph item click event.
     */
    class GraphItemClickEvent extends AbstractGraphItemClickEvent {
        public GraphItemClickEvent(Chart chart, Graph graph, String graphId, DataItem item, int itemIndex, int x, int y,
                                   int absoluteX, int absoluteY) {
            super(chart, graph, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes graph item click event.
     */
    class GraphItemRightClickEvent extends AbstractGraphItemClickEvent {
        public GraphItemRightClickEvent(Chart chart, Graph graph, String graphId, DataItem item, int itemIndex, int x,
                                        int y, int absoluteX, int absoluteY) {
            super(chart, graph, graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes legend item hide event.
     */
    class LegendItemHideEvent extends LegendItemEvent {
        public LegendItemHideEvent(Chart chart, int itemIndex, DataItem dataItem) {
            super(chart, itemIndex, dataItem);
        }
    }

    /**
     * Describes legend item show event.
     */
    class LegendItemShowEvent extends LegendItemEvent {
        public LegendItemShowEvent(Chart chart, int itemIndex, DataItem dataItem) {
            super(chart, itemIndex, dataItem);
        }
    }

    /**
     * Describes legend item click event.
     */
    abstract class LegendItemEvent extends AbstractChartEvent {
        private final int itemIndex;
        private final DataItem dataItem;

        public LegendItemEvent(Chart chart, int itemIndex, DataItem dataItem) {
            super(chart);
            this.itemIndex = itemIndex;
            this.dataItem = dataItem;
        }

        @Override
        public Chart getSource() {
            return (Chart) super.getSource();
        }

        public int getItemIndex() {
            return itemIndex;
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
    }

    /**
     * Describes legend item click event.
     */
    class LegendItemClickEvent extends LegendItemEvent {
        public LegendItemClickEvent(Chart chart, int itemIndex, DataItem dataItem) {
            super(chart, itemIndex, dataItem);
        }
    }

    /**
     * Describes legend marker click event.
     */
    class LegendMarkerClickEvent extends LegendItemEvent {
        public LegendMarkerClickEvent(Chart chart, int itemIndex, DataItem dataItem) {
            super(chart, itemIndex, dataItem);
        }
    }

    /**
     * Describes slice click event.
     */
    class SliceClickEvent extends AbstractSliceClickEvent {
        public SliceClickEvent(Chart chart, DataItem dataItem, int x, int y, int absoluteX, int absoluteY) {
            super(chart, dataItem, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes slice click event.
     */
    class SliceRightClickEvent extends AbstractSliceClickEvent {
        public SliceRightClickEvent(Chart chart, DataItem dataItem, int x, int y, int absoluteX, int absoluteY) {
            super(chart, dataItem, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Describes slice pull-in event.
     */
    class SlicePullInEvent extends AbstractItemEvent {
        public SlicePullInEvent(Chart chart, DataItem item) {
            super(chart, item);
        }
    }

    /**
     * Describes slice pull-out event.
     */
    class SlicePullOutEvent extends AbstractItemEvent {
        public SlicePullOutEvent(Chart chart, DataItem item) {
            super(chart, item);
        }
    }

    /**
     * Describes zoom event.
     */
    class ZoomEvent extends AbstractChartEvent {
        private final int startIndex;
        private final int endIndex;
        private final Date startDate;
        private final Date endDate;
        private final String startValue;
        private final String endValue;

        public ZoomEvent(Chart chart, int startIndex, int endIndex,
                         Date startDate, Date endDate, String startValue, String endValue) {
            super(chart);
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.startDate = startDate;
            this.endDate = endDate;
            this.startValue = startValue;
            this.endValue = endValue;
        }

        /**
         * @return end date of the chart zoom period
         */
        public Date getEndDate() {
            return endDate;
        }

        /**
         * @return end category index of the chart zoom period
         */
        public int getEndIndex() {
            return endIndex;
        }

        /**
         * @return end category value of the chart zoom period
         */
        public String getEndValue() {
            return endValue;
        }

        /**
         * @return start date of the chart zoom period
         */
        public Date getStartDate() {
            return startDate;
        }

        /**
         * @return start category index of the chart zoom period
         */
        public int getStartIndex() {
            return startIndex;
        }

        /**
         * @return start category value of the chart zoom period
         */
        public String getStartValue() {
            return startValue;
        }
    }
}