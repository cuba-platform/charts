/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

public interface XYChartModel<T extends XYChartModel> extends RectangularChartModel<T> {
    /**
     * @return true if scrollbar of X axis (horizontal) is hidden
     */
    Boolean getHideXScrollbar();

    /**
     * Set hideXScrollbar to true if scrollbar of X axis (horizontal) should be hidden.
     *
     * @param hideXScrollbar hide X scrollbar option
     */
    T setHideXScrollbar(Boolean hideXScrollbar);

    /**
     * @return true if scrollbar of Y axis (vertical) is hidden
     */
    Boolean getHideYScrollbar();

    /**
     * Set hideYScrollbar to true if scrollbar of Y axis (vertical) should be hidden.
     *
     * @param hideYScrollbar hide Y scrollbar option
     */
    T setHideYScrollbar(Boolean hideYScrollbar);

    /**
     * @return data date format
     */
    String getDataDateFormat();

    /**
     * Sets the data date format (date/time). Use it if you have date-based value axis in your XY chart. Note, that
     * two-digit years "YY" as well as literal month names "MMM" are NOT supported in this setting.
     *
     * @param dataDateFormat data date format string
     */
    T setDataDateFormat(String dataDateFormat);

    /**
     * @return maximum value of the size/scale of bubbles
     */
    Integer getMaxValue();

    /**
     * Sets the size/scale of bubbles. If these properties are not set, the bubble with smallest value will be of
     * minBulletSize and bubble with biggest value will be of maxBulletSize. However, you might want bubble size to
     * change relative to 0 or some other value. In this case you can use minValue and maxValue properties. Note, if
     * you use these two settings, you might also want to set minBulletSize to 0.
     *
     * @param maxValue maximum value of the size/scale of bubbles
     */
    T setMaxValue(Integer maxValue);

    /**
     * @return minimum value of the size/scale of bubbles
     */
    Integer getMinValue();

    /**
     * Sets the size/scale of bubbles. If these properties are not set, the bubble with smallest value will be of
     * minBulletSize and bubble with biggest value will be of maxBulletSize. However, you might want bubble size to
     * change relative to 0 or some other value. In this case you can use minValue and maxValue properties. Note, if
     * you use these two settings, you might also want to set minBulletSize to 0.
     *
     * @param minValue minimum value of the size/scale of bubbles
     */
    T setMinValue(Integer minValue);
}