/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.components.charts.AngularGaugeChart;

/**
 * Creates an arrow for {@link AngularGaugeChart} chart, multiple can be assigned.
 * <br>
 * See documentation for properties of GaugeArrow JS Object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/GaugeArrow">http://docs.amcharts.com/3/javascriptcharts/GaugeArrow</a>
 */
public class GaugeArrow extends AbstractChartObject {

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

    /**
     * @return opacity of an arrow
     */
    public Double getAlpha() {
        return alpha;
    }

    /**
     * Sets opacity of an arrow. If not set the default value is 1.
     *
     * @param alpha opacity
     */
    public GaugeArrow setAlpha(Double alpha) {
        this.alpha = alpha;
        return this;
    }

    /**
     * @return opacity of arrow border
     */
    public Double getBorderAlpha() {
        return borderAlpha;
    }

    /**
     * Sets opacity of arrow border. If not set the default value is 1.
     *
     * @param borderAlpha border opacity
     */
    public GaugeArrow setBorderAlpha(Double borderAlpha) {
        this.borderAlpha = borderAlpha;
        return this;
    }

    /**
     * @return true if clockWiseOnly is enabled
     */
    public Boolean getClockWiseOnly() {
        return clockWiseOnly;
    }

    /**
     * Set clockWiseOnly to true if you need the arrow to rotate only clock-wise. If not set the default value is false.
     *
     * @param clockWiseOnly clockWiseOnly option
     */
    public GaugeArrow setClockWiseOnly(Boolean clockWiseOnly) {
        this.clockWiseOnly = clockWiseOnly;
        return this;
    }

    /**
     * @return color of an arrow
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color of an arrow. If not set the default value is #000000.
     *
     * @param color color
     */
    public GaugeArrow setColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * @return inner radius
     */
    public String getInnerRadius() {
        return innerRadius;
    }

    /**
     * Sets inner radius of an arrow. If not set the default value is 0.
     *
     * @param innerRadius inner radius
     */
    public GaugeArrow setInnerRadius(String innerRadius) {
        this.innerRadius = innerRadius;
        return this;
    }

    /**
     * @return opacity of a nail, holding the arrow
     */
    public Double getNailAlpha() {
        return nailAlpha;
    }

    /**
     * Sets opacity of a nail, holding the arrow. If not set the default value is 1.
     *
     * @param nailAlpha opacity
     */
    public GaugeArrow setNailAlpha(Double nailAlpha) {
        this.nailAlpha = nailAlpha;
        return this;
    }

    /**
     * @return opacity of nail border
     */
    public Double getNailBorderAlpha() {
        return nailBorderAlpha;
    }

    /**
     * Sets opacity of nail border. If not set the default value is 0.
     *
     * @param nailBorderAlpha opacity
     */
    public GaugeArrow setNailBorderAlpha(Double nailBorderAlpha) {
        this.nailBorderAlpha = nailBorderAlpha;
        return this;
    }

    /**
     * @return thickness of nail border
     */
    public Integer getNailBorderThickness() {
        return nailBorderThickness;
    }

    /**
     * Sets thickness of nail border. If not set the default value is 1.
     *
     * @param nailBorderThickness thickness
     */
    public GaugeArrow setNailBorderThickness(Integer nailBorderThickness) {
        this.nailBorderThickness = nailBorderThickness;
        return this;
    }

    /**
     * @return radius
     */
    public Integer getNailRadius() {
        return nailRadius;
    }

    /**
     * Sets radius of a nail, holding the arrow. If not set the default value is 8.
     *
     * @param nailRadius radius
     */
    public GaugeArrow setNailRadius(Integer nailRadius) {
        this.nailRadius = nailRadius;
        return this;
    }

    /**
     * @return radius of an arrow
     */
    public String getRadius() {
        return radius;
    }

    /**
     * Sets radius of an arrow. If not set the default value is 90%.
     *
     * @param radius radius
     */
    public GaugeArrow setRadius(String radius) {
        this.radius = radius;
        return this;
    }

    /**
     * @return width of arrow root
     */
    public Integer getStartWidth() {
        return startWidth;
    }

    /**
     * Sets width of arrow root. If not set the default value is 8.
     *
     * @param startWidth width
     */
    public GaugeArrow setStartWidth(Integer startWidth) {
        this.startWidth = startWidth;
        return this;
    }

    /**
     * @return axis id
     */
    public String getAxis() {
        return axis;
    }

    /**
     * Sets axis of the arrow. If you don't set any axis, the first axis of a chart will be used.
     *
     * @param axis axis id
     */
    public GaugeArrow setAxis(String axis) {
        this.axis = axis;
        return this;
    }

    /**
     * @return unique id of an arrow
     */
    public String getId() {
        return id;
    }

    /**
     * Sets unique id of an arrow.
     */
    public GaugeArrow setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return value to which the arrow is point at
     */
    public Double getValue() {
        return value;
    }

    /**
     * Sets value to which the arrow should point at.
     *
     * @param value value
     */
    public GaugeArrow setValue(Double value) {
        this.value = value;
        return this;
    }
}