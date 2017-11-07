/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */
package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.amcharts.model.charts.ChartModel;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.EntityDataItem;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.EventObject;

/**
 * Base interface for all *Chart components.
 *
 * @param <T> type of builder methods
 */
public interface Chart<T extends Chart> extends Component, ChartModel<T>, Component.BelongToFrame, Component.HasXmlDescriptor, Component.HasIcon,
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

    CollectionDatasource getDatasource();
    void setDatasource(CollectionDatasource datasource);

    /**
     * Resend all items and properties to client and repaint chart.
     * Use this method if you change some property of already displayed chart.
     */
    void repaint();

    void addClickListener(ChartClickListener listener);
    void removeClickListener(ChartClickListener listener);

    void addRightClickListener(ChartRightClickListener clickListener);
    void removeRightClickListener(ChartRightClickListener clickListener);

    void addLegendItemHideListener(LegendItemHideListener listener);
    void removeLegendItemHideListener(LegendItemHideListener listener);

    void addLegendItemShowListener(LegendItemShowListener listener);
    void removeLegendItemShowListener(LegendItemShowListener listener);

    void addLegendLabelClickListener(LegendItemClickListener listener);
    void removeLegendLabelClickListener(LegendItemClickListener listener);

    void addLegendMarkerClickListener(LegendMarkerClickListener listener);
    void removeLegendMarkerClickListener(LegendMarkerClickListener listener);

    /**
     * Set additional JSON configuration as a string.
     * This JSON can override configuration loaded from XML and from Component API.
     */
    void setNativeJson(String json);
    /**
     * @return additional JSON configuration as a string.
     */
    String getNativeJson();

    abstract class AbstractItemEvent {
        private final DataItem dataItem;

        public AbstractItemEvent(DataItem dataItem) {
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

    abstract class AbstractClickEvent {
        private final int x;
        private final int y;
        private final int absoluteX;
        private final int absoluteY;

        public AbstractClickEvent(int x, int y, int absoluteX, int absoluteY) {
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

        public AbstractChartClickEvent(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis) {
            super(x, y, absoluteX, absoluteY);
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

        private final DataItem dataItem;
        private final int itemIndex;

        public AbstractGraphItemClickEvent(String graphId, DataItem dataItem,
                                           int itemIndex, int x, int y, int absoluteX, int absoluteY) {
            super(x, y, absoluteX, absoluteY);
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
    }

    abstract class AbstractSliceClickEvent extends AbstractClickEvent {
        private final DataItem dataItem;

        public AbstractSliceClickEvent(DataItem dataItem, int x, int y, int absoluteX, int absoluteY) {
            super(x, y, absoluteX, absoluteY);
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

    abstract class AbstractCursorEvent {
        private final String start;
        private final String end;

        public AbstractCursorEvent(String start, String end) {
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
     * Listener to the axis zoom events.
     */
    interface AxisZoomListener {
        /**
         * Called when value of the axis zoom changed.
         *
         * @param event event object
         */
        void onZoom(AxisZoomEvent event);
    }

    /**
     * Describes chart click event.
     */
    class ChartClickEvent extends AbstractChartClickEvent {
        public ChartClickEvent(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis) {
            super(x, y, absoluteX, absoluteY, xAxis, yAxis);
        }
    }

    /**
     * Listener to the chart click events.
     */
    interface ChartClickListener {
        /**
         * Called when user clicks on the chart.
         *
         * @param event event object
         */
        void onClick(ChartClickEvent event);
    }

    /**
     * Describes chart click event.
     */
    class ChartRightClickEvent extends AbstractChartClickEvent {
        public ChartRightClickEvent(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis) {
            super(x, y, absoluteX, absoluteY, xAxis, yAxis);
        }
    }

    /**
     * Listener to the chart right click events.
     */
    interface ChartRightClickListener {
        /**
         * Called when user clicks on the chart.
         *
         * @param event event object
         */
        void onRightClick(ChartRightClickEvent event);
    }

    /**
     * Describes cursor period select event.
     */
    class CursorPeriodSelectEvent extends AbstractCursorEvent {

        public CursorPeriodSelectEvent(String start, String end) {
            super(start, end);
        }
    }

    /**
     * Listener to the cursor period select events.
     */
    interface CursorPeriodSelectListener {
        /**
         * Called when value of the cursor period changed
         *
         * @param event event object
         */
        void onSelect(CursorPeriodSelectEvent event);
    }

    /**
     * Describes cursor zoom event.
     */
    class CursorZoomEvent extends AbstractCursorEvent {
        public CursorZoomEvent(String start, String end) {
            super(start, end);
        }
    }

    /**
     * Listener to the cursor zoom events.
     */
    interface CursorZoomListener {
        /**
         * Called when value of the cursor zoom changed.
         *
         * @param event event object
         */
        void onZoom(CursorZoomEvent event);
    }

    /**
     * Describes graph click event.
     */
    class GraphClickEvent extends AbstractClickEvent {

        private final String graphId;

        public GraphClickEvent(String graphId, int x, int y, int absoluteX, int absoluteY) {
            super(x, y, absoluteX, absoluteY);
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
     * Listener to the graph click events.
     */
    interface GraphClickListener {
        /**
         * Called when user clicks on the graph.
         *
         * @param event event object
         */
        void onClick(GraphClickEvent event);
    }

    /**
     * Describes graph item click event.
     */
    class GraphItemClickEvent extends AbstractGraphItemClickEvent {
        public GraphItemClickEvent(String graphId, DataItem item, int itemIndex, int x, int y, int absoluteX, int absoluteY) {
            super(graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the graph item click events.
     */
    interface GraphItemClickListener {
        /**
         * Called when user clicks on the graph item.
         *
         * @param event event object
         */
        void onClick(GraphItemClickEvent event);
    }

    /**
     * Describes graph item click event.
     */
    class GraphItemRightClickEvent extends AbstractGraphItemClickEvent {
        public GraphItemRightClickEvent(String graphId, DataItem item, int itemIndex, int x, int y, int absoluteX, int absoluteY) {
            super(graphId, item, itemIndex, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the graph item click events.
     */
    interface GraphItemRightClickListener {
        /**
         * Called when user clicks on the graph item.
         *
         * @param event event object
         */
        void onRightClick(GraphItemRightClickEvent event);
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
     * Listener to the legend item hide events.
     */
    interface LegendItemHideListener {
        /**
         * Called when the legend item hided
         *
         * @param event event object
         */
        void onHide(LegendItemHideEvent event);
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
     * Listener to the legend item show events.
     */
    interface LegendItemShowListener {
        /**
         * Called when the legend item showed
         *
         * @param event event object
         */
        void onShow(LegendItemShowEvent event);
    }

    /**
     * Describes legend item click event.
     */
    abstract class LegendItemEvent extends EventObject {
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
     * Listener to the legend item click events.
     */
    interface LegendItemClickListener {
        /**
         * Called when user clicks on the legend item.
         *
         * @param event event object
         */
        void onClick(LegendItemClickEvent event);
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
     * Listener to the legend item click events.
     */
    interface LegendMarkerClickListener {
        /**
         * Called when user clicks on the legend marker.
         *
         * @param event event object
         */
        void onMarkerClick(LegendMarkerClickEvent event);
    }

    /**
     * Describes slice click event.
     */
    class SliceClickEvent extends AbstractSliceClickEvent {
        public SliceClickEvent(DataItem dataItem, int x, int y, int absoluteX, int absoluteY) {
            super(dataItem, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the slice click events.
     */
    interface SliceClickListener {
        /**
         * Called when user clicks on the slice.
         *
         * @param event event object
         */
        void onClick(SliceClickEvent event);
    }

    /**
     * Describes slice click event.
     */
    class SliceRightClickEvent extends AbstractSliceClickEvent {
        public SliceRightClickEvent(DataItem dataItem, int x, int y, int absoluteX, int absoluteY) {
            super(dataItem, x, y, absoluteX, absoluteY);
        }
    }

    /**
     * Listener to the slice click events.
     */
    interface SliceRightClickListener {
        /**
         * Called when user clicks on the slice.
         *
         * @param event event object
         */
        void onRightClick(SliceRightClickEvent event);
    }

    /**
     * Describes slice pull-in event.
     */
    class SlicePullInEvent extends AbstractItemEvent {
        public SlicePullInEvent(DataItem item) {
            super(item);
        }
    }

    /**
     * Listener to the slice pull-in events.
     */
    interface SlicePullInListener {
        /**
         * Called when the slice did pull-in.
         *
         * @param event event object
         */
        void onPullIn(SlicePullInEvent event);
    }

    /**
     * Describes slice pull-out event.
     */
    class SlicePullOutEvent extends AbstractItemEvent {
        public SlicePullOutEvent(DataItem item) {
            super(item);
        }
    }

    /**
     * Listener to the slice pull-out events.
     */
    interface SlicePullOutListener {
        /**
         * Called when the slice did pull-out.
         *
         * @param event event object
         */
        void onPullOut(SlicePullOutEvent event);
    }

    /**
     * Describes zoom event.
     */
    class ZoomEvent {
        private final int startIndex;
        private final int endIndex;
        private final Date startDate;
        private final Date endDate;
        private final String startValue;
        private final String endValue;

        public ZoomEvent(int startIndex, int endIndex,
                         Date startDate, Date endDate, String startValue, String endValue) {
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

    /**
     * Listener to the chart zoom events.
     */
    interface ZoomListener {
        /**
         * Called when value of the chart zoom changed.
         *
         * @param event event object
         */
        void onZoom(ZoomEvent event);
    }
}