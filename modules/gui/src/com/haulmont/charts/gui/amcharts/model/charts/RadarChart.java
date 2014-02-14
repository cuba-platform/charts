/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;

/**
 * See documentation for properties of AmRadarChart JS object.
 *
 * @author artamonov
 * @version $Id$
 */
public class RadarChart extends CoordinateChart<RadarChart> {

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

    public Integer getMarginBottom() {
        return marginBottom;
    }

    public RadarChart setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public Integer getMarginLeft() {
        return marginLeft;
    }

    public RadarChart setMarginLeft(Integer marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public Integer getMarginRight() {
        return marginRight;
    }

    public RadarChart setMarginRight(Integer marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    public Integer getMarginTop() {
        return marginTop;
    }

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
}