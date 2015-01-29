/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of GaugeArrow JS Object.
 *
 * @author artamonov
 * @version $Id$
 */
public class GaugeArrow extends AbstractConfigurationObject {

    private static final long serialVersionUID = -9054603815401102787L;

    private Double alpha;

    private String axis;

    private Double borderAlpha;

    private Boolean clockWiseOnly;

    private Color color;

    private String id;

    private String innerRadius;

    private Double nailAlpha;

    private Double nailBorderAlpha;

    private Integer nailBorderThickness;

    private Integer nailRadius;

    private String radius;

    private Integer startWidth;

    private Double value;

    public Double getAlpha() {
        return alpha;
    }

    public GaugeArrow setAlpha(Double alpha) {
        this.alpha = alpha;
        return this;
    }

    public Double getBorderAlpha() {
        return borderAlpha;
    }

    public GaugeArrow setBorderAlpha(Double borderAlpha) {
        this.borderAlpha = borderAlpha;
        return this;
    }

    public Boolean getClockWiseOnly() {
        return clockWiseOnly;
    }

    public GaugeArrow setClockWiseOnly(Boolean clockWiseOnly) {
        this.clockWiseOnly = clockWiseOnly;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public GaugeArrow setColor(Color color) {
        this.color = color;
        return this;
    }

    public String getInnerRadius() {
        return innerRadius;
    }

    public GaugeArrow setInnerRadius(String innerRadius) {
        this.innerRadius = innerRadius;
        return this;
    }

    public Double getNailAlpha() {
        return nailAlpha;
    }

    public GaugeArrow setNailAlpha(Double nailAlpha) {
        this.nailAlpha = nailAlpha;
        return this;
    }

    public Double getNailBorderAlpha() {
        return nailBorderAlpha;
    }

    public GaugeArrow setNailBorderAlpha(Double nailBorderAlpha) {
        this.nailBorderAlpha = nailBorderAlpha;
        return this;
    }

    public Integer getNailBorderThickness() {
        return nailBorderThickness;
    }

    public GaugeArrow setNailBorderThickness(Integer nailBorderThickness) {
        this.nailBorderThickness = nailBorderThickness;
        return this;
    }

    public Integer getNailRadius() {
        return nailRadius;
    }

    public GaugeArrow setNailRadius(Integer nailRadius) {
        this.nailRadius = nailRadius;
        return this;
    }

    public String getRadius() {
        return radius;
    }

    public GaugeArrow setRadius(String radius) {
        this.radius = radius;
        return this;
    }

    public Integer getStartWidth() {
        return startWidth;
    }

    public GaugeArrow setStartWidth(Integer startWidth) {
        this.startWidth = startWidth;
        return this;
    }

    public String getAxis() {
        return axis;
    }

    public GaugeArrow setAxis(String axis) {
        this.axis = axis;
        return this;
    }

    public String getId() {
        return id;
    }

    public GaugeArrow setId(String id) {
        this.id = id;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public GaugeArrow setValue(Double value) {
        this.value = value;
        return this;
    }
}