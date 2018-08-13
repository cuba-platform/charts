/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.HasMargins;

public interface RadarChartModel<T extends RadarChartModel> extends CoordinateChartModel<T>, HasMargins<T> {
    /**
     * @return category field
     */
    String getCategoryField();

    /**
     * Sets field from your data provider containing categories.
     *
     * @param categoryField category field string
     */
    T setCategoryField(String categoryField);

    /**
     * @return radius
     */
    String getRadius();

    /**
     * Sets radius of radar. If not set the default value is 35%.
     *
     * @param radius the radius
     */
    T setRadius(String radius);
}