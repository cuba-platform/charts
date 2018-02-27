/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.SeriesBasedChartModel;

import java.util.Date;

/**
 * Base interface for {@link SerialChart} and {@link GanttChart}.
 */
public interface SeriesBasedChart<T extends SeriesBasedChart> extends RectangularChart<T>, SeriesBasedChartModel<T> {
    void addZoomListener(ZoomListener listener);
    void removeZoomListener(ZoomListener listener);

    void addCategoryItemClickListener(CategoryItemClickListener listener);
    void removeCategoryItemClickListener(CategoryItemClickListener listener);

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
     * Describes clickItem event on categories in the CategoryAxis.
     * <br>
     * See documentation for properties of clickItem event in the CategoryAxis.
     * <br>
     * <a href="https://docs.amcharts.com/3/javascriptcharts/CategoryAxis#clickItem">https://docs.amcharts.com/3/javascriptcharts/CategoryAxis#clickItem</a>
     */
    class CategoryItemClickEvent {
        private String value;

        private int offsetX;
        private int offsetY;

        private int x;
        private int y;

        private int xAxis;
        private int yAxis;

        public CategoryItemClickEvent(String value, int x, int y, int offsetX, int offsetY, int xAxis, int yAxis) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.xAxis = xAxis;
            this.yAxis = yAxis;
        }

        /**
         * @return category value that represents in String type
         */
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        /**
         * @return offset in the X coordinate of the mouse pointer between that event and the padding edge of the
         * target node
         */
        public int getOffsetX() {
            return offsetX;
        }

        public void setOffsetX(int offsetX) {
            this.offsetX = offsetX;
        }

        /**
         * @return offset in the Y coordinate of the mouse pointer between that event and the padding edge of the
         * target node
         */
        public int getOffsetY() {
            return offsetY;
        }

        public void setOffsetY(int offsetY) {
            this.offsetY = offsetY;
        }

        /**
         * @return X coordinate within the application's client area
         */
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        /**
         * @return Y coordinate within the application's client area
         */
        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        /**
         * @return X coordinate of the axis
         */
        public int getXAxis() {
            return xAxis;
        }

        public void setXAxis(int xAxis) {
            this.xAxis = xAxis;
        }

        /**
         * @return Y coordinate of the axis
         */
        public int getYAxis() {
            return yAxis;
        }

        public void setYAxis(int yAxis) {
            this.yAxis = yAxis;
        }
    }

    /**
     * Listener to the click events on categories.
     */
    interface CategoryItemClickListener {

        /**
         * Called when user clicks on the category.
         *
         * @param event event object
         */
        void onClick(CategoryItemClickEvent event);
    }
}