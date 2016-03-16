/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;
import com.haulmont.charts.gui.amcharts.model.HasMargins;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * See documentation for properties of AmRadarChart JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmRadarChart">http://docs.amcharts.com/3/javascriptcharts/AmRadarChart</a>
 *
 */
public class RadarChart extends CoordinateChart<RadarChart> implements HasMargins<RadarChart> {

    private static final long serialVersionUID = 7721119324768771106L;

    private String categoryField;

    private Integer marginBottom;

    private Integer marginLeft;

    private Integer marginRight;

    private Integer marginTop;

    private String radius;

    public RadarChart() {
        super(ChartType.RADAR);
    }

    public String getCategoryField() {
        return categoryField;
    }

    public RadarChart setCategoryField(String categoryField) {
        this.categoryField = categoryField;
        return this;
    }

    @Override
    public Integer getMarginBottom() {
        return marginBottom;
    }

    @Override
    public RadarChart setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    @Override
    public Integer getMarginLeft() {
        return marginLeft;
    }

    @Override
    public RadarChart setMarginLeft(Integer marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    @Override
    public Integer getMarginRight() {
        return marginRight;
    }

    @Override
    public RadarChart setMarginRight(Integer marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    @Override
    public Integer getMarginTop() {
        return marginTop;
    }

    @Override
    public RadarChart setMarginTop(Integer marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public String getRadius() {
        return radius;
    }

    public RadarChart setRadius(String radius) {
        this.radius = radius;
        return this;
    }

    @Override
    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>(super.getWiredFields());

        if (StringUtils.isNotEmpty(categoryField)) {
            wiredFields.add(categoryField);
        }

        return wiredFields;
    }
}