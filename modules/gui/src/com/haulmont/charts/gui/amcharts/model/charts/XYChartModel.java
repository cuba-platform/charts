/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

public interface XYChartModel<T extends XYChartModel> extends RectangularChartModel<T> {
    Boolean getHideXScrollbar();
    T setHideXScrollbar(Boolean hideXScrollbar);

    Boolean getHideYScrollbar();
    T setHideYScrollbar(Boolean hideYScrollbar);

    String getDataDateFormat();
    T setDataDateFormat(String dataDateFormat);

    Integer getMaxValue();
    T setMaxValue(Integer maxValue);

    Integer getMinValue();
    T setMinValue(Integer minValue);
}