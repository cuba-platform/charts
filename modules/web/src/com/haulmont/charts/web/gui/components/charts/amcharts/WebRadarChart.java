/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.components.charts.RadarChart;

public class WebRadarChart extends WebCoordinateChart<RadarChart, com.haulmont.charts.gui.amcharts.model.charts.RadarChart>
        implements RadarChart {

    @Override
    protected com.haulmont.charts.gui.amcharts.model.charts.RadarChart createChartConfiguration() {
        return new com.haulmont.charts.gui.amcharts.model.charts.RadarChart();
    }

    @Override
    public String getCategoryField() {
        return getModel().getCategoryField();
    }

    @Override
    public RadarChart setCategoryField(String categoryField) {
        getModel().setCategoryField(categoryField);
        return this;
    }

    @Override
    public Integer getMarginBottom() {
        return getModel().getMarginBottom();
    }

    @Override
    public RadarChart setMarginBottom(Integer marginBottom) {
        getModel().setMarginBottom(marginBottom);
        return this;
    }

    @Override
    public Integer getMarginLeft() {
        return getModel().getMarginLeft();
    }

    @Override
    public RadarChart setMarginLeft(Integer marginLeft) {
        getModel().setMarginLeft(marginLeft);
        return this;
    }

    @Override
    public Integer getMarginRight() {
        return getModel().getMarginRight();
    }

    @Override
    public RadarChart setMarginRight(Integer marginRight) {
        getModel().setMarginRight(marginRight);
        return this;
    }

    @Override
    public Integer getMarginTop() {
        return getModel().getMarginTop();
    }

    @Override
    public RadarChart setMarginTop(Integer marginTop) {
        getModel().setMarginTop(marginTop);
        return this;
    }

    @Override
    public String getRadius() {
        return getModel().getRadius();
    }

    @Override
    public RadarChart setRadius(String radius) {
        getModel().setRadius(radius);
        return this;
    }
}