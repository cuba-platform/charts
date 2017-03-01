/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.HasMargins;

public interface RadarChartModel<T extends RadarChartModel> extends CoordinateChartModel<T>, HasMargins<T> {
    String getCategoryField();
    T setCategoryField(String categoryField);

    String getRadius();
    T setRadius(String radius);
}