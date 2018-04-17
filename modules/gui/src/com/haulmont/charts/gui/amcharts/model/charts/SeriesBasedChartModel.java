/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.CategoryAxis;
import com.haulmont.charts.gui.amcharts.model.Scrollbar;
import com.haulmont.charts.gui.amcharts.model.Cursor;

public interface SeriesBasedChartModel<T extends SeriesBasedChartModel> extends RectangularChartModel<T> {
    /**
     * @return category axis
     */
    CategoryAxis getCategoryAxis();

    /**
     * Sets the category axis.
     *
     * @param categoryAxis the category axis
     */
    T setCategoryAxis(CategoryAxis categoryAxis);

    /**
     * @return category field name
     */
    String getCategoryField();

    /**
     * Sets the category field name. It tells the chart the name of the field from your data provider object which will
     * be used for category axis values.
     *
     * @param categoryField category field name string
     */
    T setCategoryField(String categoryField);

    /**
     * @return balloon date format
     */
    String getBalloonDateFormat();

    /**
     * Sets date format of the graph balloon (if chart parses dates and you don't use
     * {@link Cursor}). If not set the default value is "MMM DD, YYYY".
     *
     * @param balloonDateFormat the balloon date format
     */
    T setBalloonDateFormat(String balloonDateFormat);

    /**
     * @return space between 3D stacked columns
     */
    Integer getColumnSpacing3D();

    /**
     * Sets space between 3D stacked columns. If not set the default value is 0.
     *
     * @param columnSpacing3D space between 3D stacked columns
     */
    T setColumnSpacing3D(Integer columnSpacing3D);

    /**
     * @return column spacing in pixels
     */
    Integer getColumnSpacing();

    /**
     * Sets the gap in pixels between two columns of the same category. If not set the default value is 5.
     *
     * @param columnSpacing column spacing in pixels
     */
    T setColumnSpacing(Integer columnSpacing);

    /**
     * @return relative width of columns
     */
    Double getColumnWidth();

    /**
     * Sets relative width of columns. Value range is 0 - 1. If not set the default value is 0.8.
     *
     * @param columnWidth relative width of columns
     */
    T setColumnWidth(Double columnWidth);

    /**
     * @return data date format
     */
    String getDataDateFormat();

    /**
     * Sets data date format. Even if your chart parses dates, you can pass them as strings in your data – all you need
     * to do is to set data date format and the chart will parse dates to date objects. Please note that two-digit
     * years "YY" as well as literal month names "MMM" are NOT supported in this setting.
     *
     * @param dataDateFormat data date format string
     */
    T setDataDateFormat(String dataDateFormat);

    /**
     * @return maximum number of selected series
     */
    Integer getMaxSelectedSeries();

    /**
     * Sets maximum number of series allowed to select.
     *
     * @param maxSelectedSeries the maximum number of selected series
     */
    T setMaxSelectedSeries(Integer maxSelectedSeries);

    /**
     * @return maximum selected time in milliseconds
     */
    Long getMaxSelectedTime();

    /**
     * Sets the longest time span allowed to select in milliseconds for example, 259200000 will limit selection to 3
     * days. Works if {@link CategoryAxis#equalSpacing} is set to false.
     *
     * @param maxSelectedTime the maximum selected time in milliseconds
     */
    T setMaxSelectedTime(Long maxSelectedTime);

    /**
     * @return minimum selected time in milliseconds
     */
    Long getMinSelectedTime();

    /**
     * Sets the shortest time span allowed to select in milliseconds for example, 1000 will limit selection to 1
     * second. Works if {@link CategoryAxis#equalSpacing} is set to false. If not set the default value is 0.
     *
     * @param minSelectedTime the minimum selected time in milliseconds
     */
    T setMinSelectedTime(Long minSelectedTime);

    /**
     * @return true if scroll chart with the mouse wheel is enabled
     */
    Boolean getMouseWheelScrollEnabled();

    /**
     * Set true if you want scroll chart with the mouse wheel. If you press shift while rotating mouse wheel, the
     * chart will zoom-in/out. If not set the default value is false.
     *
     * @param mouseWheelScrollEnabled mouse wheel scroll option
     */
    T setMouseWheelScrollEnabled(Boolean mouseWheelScrollEnabled);

    /**
     * @return true if rotate is enabled
     */
    Boolean getRotate();

    /**
     * Set rotate to true, if the chart should be rotated by 90 degrees (the columns will become bars). If not set
     * the default value is false.
     *
     * @param rotate rotate option
     */
    T setRotate(Boolean rotate);

    /**
     * @return true if chart should be zoom-out when data is updated
     */
    Boolean getZoomOutOnDataUpdate();

    /**
     * Set zoomOutOnDataUpdate to true if chart should be zoom-out when data is updated. If not set the default value is
     * true.
     *
     * @param zoomOutOnDataUpdate zoomOutOnDataUpdate option
     */
    T setZoomOutOnDataUpdate(Boolean zoomOutOnDataUpdate);

    /**
     * @return true if zooming of a chart with mouse wheel is enabled
     */
    Boolean getMouseWheelZoomEnabled();

    /**
     * Set mouseWheelZoomEnabled to true if zooming of a chart with mouse wheel should be enabled. If you press shift
     * while rotating mouse wheel, the chart will scroll. If not set the default value is false.
     *
     * @param mouseWheelZoomEnabled mouseWheelZoomEnabled option
     */
    T setMouseWheelZoomEnabled(Boolean mouseWheelZoomEnabled);

    /**
     * @return value scrollbar
     */
    Scrollbar getValueScrollbar();

    /**
     * Sets value scrollbar, enables scrolling value axes.
     *
     * @param valueScrollbar the value scrollbar
     */
    T setValueScrollbar(Scrollbar valueScrollbar);

    /**
     * @return true if synchronized grid is enabled
     */
    Boolean getSynchronizeGrid();

    /**
     * Set synchronizeGrid property to true and the chart will adjust minimum and maximum of axes so that the grid
     * would be show at equal intervals. This helps users to compare values more easily.
     *
     * @param synchronizeGrid synchronized grid option
     */
    T setSynchronizeGrid(Boolean synchronizeGrid);
}