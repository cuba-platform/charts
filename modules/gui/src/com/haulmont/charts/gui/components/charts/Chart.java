/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */
package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import java.util.Date;

public interface Chart extends Component, Component.BelongToFrame, Component.HasXmlDescriptor, Component.HasIcon,
                               Component.HasCaption {

    String NAME = "chart";

    /**
     * @return client-specific implementation of the chart
     */
    AbstractChart getConfiguration();

    /**
     * Sets client-specific implementation of the chart.
     *
     * @param chart client-specific implementation of the chart
     */
    void setConfiguration(AbstractChart chart);

    /**
     * @return if {@code CategoryAxis} parses dates
     */
    boolean isByDate();

    /**
     * Sets value of {@link com.haulmont.charts.gui.amcharts.model.CategoryAxis#setParseDates(Boolean)}
     *
     * @param byDate is parse dates
     */
    void setByDate(boolean byDate);

    void setDatasource(CollectionDatasource datasource);
    CollectionDatasource getDatasource();

    /**
     * Resend all items and properties to client and repaint chart.
     * Use this method if you change some property of already displayed chart.
     */
    void repaint();

    void addAxisZoomListener(AxisZoomListener zoomListener);
    void removeAxisZoomListener(AxisZoomListener zoomListener);

    void addClickListener(ChartClickListener clickListener);
    void removeClickListener(ChartClickListener clickListener);

    void addRightClickListener(ChartClickListener clickListener);
    void removeRightClickListener(ChartClickListener clickListener);

    void addCursorPeriodSelectListener(CursorPeriodSelectListener selectListener);
    void removeCursorPeriodSelectListener(CursorPeriodSelectListener selectListener);

    void addCursorZoomListener(CursorZoomListener zoomListener);
    void removeCursorZoomListener(CursorZoomListener zoomListener);

    void addGraphClickListener(GraphClickListener clickListener);
    void removeGraphClickListener(GraphClickListener clickListener);

    void addGraphItemClickListener(GraphItemClickListener clickListener);
    void removeGraphItemClickListener(GraphItemClickListener clickListener);

    void addGraphItemRightClickListener(GraphItemClickListener clickListener);
    void removeGraphItemRightClickListener(GraphItemClickListener clickListener);

    void addLegendItemHideListener(LegendItemHideListener itemHideListener);
    void removeLegendItemHideListener(LegendItemHideListener itemHideListener);

    void addLegendItemShowListener(LegendItemShowListener itemShowListener);
    void removeLegendItemShowListener(LegendItemShowListener itemShowListener);

    void addLegendLabelClickListener(LegendItemClickListener clickListener);
    void removeLegendLabelClickListener(LegendItemClickListener clickListener);

    void addLegendMarkerClickListener(LegendItemClickListener clickListener);
    void removeLegendMarkerClickListener(LegendItemClickListener clickListener);

    void addSliceClickListener(SliceClickListener clickListener);
    void removeSliceClickListener(SliceClickListener clickListener);

    void addSliceRightClickListener(SliceClickListener clickListener);
    void removeSliceRightClickListener(SliceClickListener clickListener);

    void addSlicePullInListener(SlicePullInListener pullInListener);
    void removeSlicePullInListener(SlicePullInListener pullInListener);

    void addSlicePullOutListener(SlicePullOutListener pullOutListener);
    void removeSlicePullOutListener(SlicePullOutListener pullOutListener);

    void addZoomListener(ZoomListener zoomListener);
    void removeZoomListener(ZoomListener zoomListener);

    /**
     * Set responsive option for chart.
     */
    void setResponsive(boolean value);
    /**
     * @return true if chart has responsive rules.
     */
    boolean isResponsive();

    /**
     * Set additional JSON configuration as a string.
     * This JSON can override configuration loaded from XML and from Component API.
     */
    void setNativeJson(String json);
    /**
     * @return additional JSON configuration as a string.
     */
    String getNativeJson();

    /**
     * Zooms out, charts shows all available data.
     */
    void zoomOut();

    /**
     * Zooms the chart by the index of the category.
     *
     * @param start start index
     * @param end   end index
     */
    void zoomToIndexes(int start, int end);

    /**
     * Zooms the chart from one date to another.
     *
     * @param start start date
     * @param end   end date
     */
    void zoomToDates(Date start, Date end);

    /**
     * Zooms out value axes, value axes shows all available data.
     */
    void zoomOutValueAxes();

    /**
     * Zooms out value axis, value axis shows all available data.
     *
     * @param id id of value axis
     */
    void zoomOutValueAxis(String id);

    /**
     * Zooms out value axis, value axis shows all available data.
     *
     * @param index index of value axis
     */
    void zoomOutValueAxis(int index);

    /**
     * Zooms-in an axis to the provided values.
     *
     * @param id         id of value axis
     * @param startValue start value
     * @param endValue   end value
     */
    void zoomValueAxisToValues(String id, Object startValue, Object endValue);

    /**
     * Zooms-in an axis to the provided values.
     *
     * @param index      index of value axis
     * @param startValue start value
     * @param endValue   end value
     */
    void zoomValueAxisToValues(int index, Object startValue, Object endValue);

    abstract class AbstractItemEvent {
        private final Entity item;

        public AbstractItemEvent(Entity item) {
            this.item = item;
        }

        /**
         * @return an item
         */
        public Entity getItem() {
            return item;
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
    class ChartClickEvent extends AbstractClickEvent {

        private final double xAxis;
        private final double yAxis;

        public ChartClickEvent(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis) {
            super(x, y, absoluteX, absoluteY);
            this.xAxis = xAxis;
            this.yAxis = yAxis;
        }

        /**
         * @return value of the X axis corresponding to mouse pointer
         */
        public double getxAxis() {
            return xAxis;
        }

        /**
         * @return value of the Y axis corresponding to mouse pointer
         */
        public double getyAxis() {
            return yAxis;
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
    class GraphItemClickEvent extends AbstractClickEvent{
        private final String graphId;

        private final Entity item;
        private final int itemIndex;

        public GraphItemClickEvent(String graphId, Entity item, int itemIndex, int x, int y, int absoluteX, int absoluteY) {
            super(x, y, absoluteX, absoluteY);
            this.item = item;
            this.itemIndex = itemIndex;
            this.graphId = graphId;
        }

        /**
         * @return graph id
         */
        public String getGraphId() {
            return graphId;
        }

        /**
         * @return an item corresponding to the graph item
         */
        public Entity getItem() {
            return item;
        }

        /**
         * @return item index
         */
        public int getItemIndex() {
            return itemIndex;
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
     * Describes legend item hide event.
     */
    class LegendItemHideEvent extends AbstractItemEvent {
        public LegendItemHideEvent(Entity item) {
            super(item);
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
    class LegendItemShowEvent extends AbstractItemEvent {
        public LegendItemShowEvent(Entity item) {
            super(item);
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
    class LegendItemClickEvent extends AbstractItemEvent {
        public LegendItemClickEvent(Entity item) {
            super(item);
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
     * Describes slice click event.
     */
    class SliceClickEvent extends AbstractClickEvent {
        private final Entity item;

        public SliceClickEvent(Entity item, int x, int y, int absoluteX, int absoluteY) {
            super(x, y, absoluteX, absoluteY);
            this.item = item;
        }

        /**
         * @return an item corresponding to the slice
         */
        public Entity getItem() {
            return item;
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
     * Describes slice pull-in event.
     */
    class SlicePullInEvent extends AbstractItemEvent {
        public SlicePullInEvent(Entity item) {
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
        public SlicePullOutEvent(Entity item) {
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