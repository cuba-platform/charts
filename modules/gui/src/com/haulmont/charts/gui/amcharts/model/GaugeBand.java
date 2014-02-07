/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of GaugeBand JS Object.
 *
 * @author artamonov
 * @version $Id$
 */
public class GaugeBand extends AbstractConfigurationObject {

    private static final long serialVersionUID = 6480625092225201700L;

    private Double alpha;

    private Color color;

    private Double endValue;

    private String innerRadius;

    private String radius;

    private Double startValue;

    public Double getAlpha() {
        return alpha;
    }

    public GaugeBand setAlpha(Double alpha) {
        this.alpha = alpha;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public GaugeBand setColor(Color color) {
        this.color = color;
        return this;
    }

    public Double getEndValue() {
        return endValue;
    }

    public GaugeBand setEndValue(Double endValue) {
        this.endValue = endValue;
        return this;
    }

    public String getInnerRadius() {
        return innerRadius;
    }

    public GaugeBand setInnerRadius(String innerRadius) {
        this.innerRadius = innerRadius;
        return this;
    }

    public String getRadius() {
        return radius;
    }

    public GaugeBand setRadius(String radius) {
        this.radius = radius;
        return this;
    }

    public Double getStartValue() {
        return startValue;
    }

    public GaugeBand setStartValue(Double startValue) {
        this.startValue = startValue;
        return this;
    }
}