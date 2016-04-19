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

/**
 */
public interface Chart extends Component, Component.BelongToFrame, Component.HasXmlDescriptor {

    String NAME = "chart";

    AbstractChart getConfiguration();
    void setConfiguration(AbstractChart chart);

    boolean isByDate();
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

    void zoomOut();
    void zoomToIndexes(int start, int end);
    void zoomToDates(Date start, Date end);

    abstract class AbstractItemEvent {
        private final Entity item;

        public AbstractItemEvent(Entity item) {
            this.item = item;
        }

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

    abstract class AbstractCursorEvent {
        private final String start;
        private final String end;

        public AbstractCursorEvent(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }
    }

    class AxisZoomEvent {
        private final String axisId;
        private final double startValue;
        private final double endValue;

        public AxisZoomEvent(String axisId, double startValue, double endValue) {
            this.axisId = axisId;
            this.startValue = startValue;
            this.endValue = endValue;
        }

        public String getAxisId() {
            return axisId;
        }

        public double getEndValue() {
            return endValue;
        }

        public double getStartValue() {
            return startValue;
        }
    }

    interface AxisZoomListener {
        void onZoom(AxisZoomEvent event);
    }

    class ChartClickEvent extends AbstractClickEvent {

        private final double xAxis;
        private final double yAxis;

        public ChartClickEvent(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis) {
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

    interface ChartClickListener {
        void onClick(ChartClickEvent event);
    }

    class CursorPeriodSelectEvent extends AbstractCursorEvent {

        public CursorPeriodSelectEvent(String start, String end) {
            super(start, end);
        }
    }

    interface CursorPeriodSelectListener {
        void onSelect(CursorPeriodSelectEvent event);
    }

    class CursorZoomEvent extends AbstractCursorEvent {
        public CursorZoomEvent(String start, String end) {
            super(start, end);
        }
    }

    interface CursorZoomListener {
        void onZoom(CursorZoomEvent event);
    }

    class GraphClickEvent extends AbstractClickEvent {

        private final String graphId;

        public GraphClickEvent(String graphId, int x, int y, int absoluteX, int absoluteY) {
            super(x, y, absoluteX, absoluteY);
            this.graphId = graphId;
        }

        public String getGraphId() {
            return graphId;
        }
    }

    interface GraphClickListener {
        void onClick(GraphClickEvent event);
    }

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

        public String getGraphId() {
            return graphId;
        }

        public Entity getItem() {
            return item;
        }

        public int getItemIndex() {
            return itemIndex;
        }
    }

    interface GraphItemClickListener {
        void onClick(GraphItemClickEvent event);
    }

    class LegendItemHideEvent extends AbstractItemEvent {
        public LegendItemHideEvent(Entity item) {
            super(item);
        }
    }

    interface LegendItemHideListener {
        void onHide(LegendItemHideEvent event);
    }

    class LegendItemShowEvent extends AbstractItemEvent {
        public LegendItemShowEvent(Entity item) {
            super(item);
        }
    }

    interface LegendItemShowListener {
        void onShow(LegendItemShowEvent event);
    }

    class LegendItemClickEvent extends AbstractItemEvent {
        public LegendItemClickEvent(Entity item) {
            super(item);
        }
    }

    interface LegendItemClickListener {
        void onClick(LegendItemClickEvent event);
    }

    class SliceClickEvent extends AbstractClickEvent {
        private final Entity item;

        public SliceClickEvent(Entity item, int x, int y, int absoluteX, int absoluteY) {
            super(x, y, absoluteX, absoluteY);
            this.item = item;
        }

        public Entity getItem() {
            return item;
        }
    }

    interface SliceClickListener {
        void onClick(SliceClickEvent event);
    }

    class SlicePullInEvent extends AbstractItemEvent {
        public SlicePullInEvent(Entity item) {
            super(item);
        }
    }

    interface SlicePullInListener {
        void onPullIn(SlicePullInEvent event);
    }

    class SlicePullOutEvent extends AbstractItemEvent {
        public SlicePullOutEvent(Entity item) {
            super(item);
        }
    }

    interface SlicePullOutListener {
        void onPullOut(SlicePullOutEvent event);
    }

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

        public Date getEndDate() {
            return endDate;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public String getEndValue() {
            return endValue;
        }

        public Date getStartDate() {
            return startDate;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public String getStartValue() {
            return startValue;
        }
    }

    interface ZoomListener {
        void onZoom(ZoomEvent event);
    }
}