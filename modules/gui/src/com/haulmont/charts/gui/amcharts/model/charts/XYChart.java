/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;

/**
 * See documentation for properties of AmXYChart JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmXYChart">http://docs.amcharts.com/3/javascriptcharts/AmXYChart</a>
 *
 */
public class XYChart extends RectangularChart<XYChart> {

    private static final long serialVersionUID = 3259485360498054262L;

    private String dataDateFormat;

    private Boolean hideXScrollbar;

    private Boolean hideYScrollbar;

    private Integer maxValue;

    private Integer minValue;

    public XYChart() {
        super(ChartType.XY);
    }

    public Boolean getHideXScrollbar() {
        return hideXScrollbar;
    }

    public XYChart setHideXScrollbar(Boolean hideXScrollbar) {
        this.hideXScrollbar = hideXScrollbar;
        return this;
    }

    public Boolean getHideYScrollbar() {
        return hideYScrollbar;
    }

    public XYChart setHideYScrollbar(Boolean hideYScrollbar) {
        this.hideYScrollbar = hideYScrollbar;
        return this;
    }

    public String getDataDateFormat() {
        return dataDateFormat;
    }

    public XYChart setDataDateFormat(String dataDateFormat) {
        this.dataDateFormat = dataDateFormat;
        return this;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public XYChart setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public XYChart setMinValue(Integer minValue) {
        this.minValue = minValue;
        return this;
    }
}