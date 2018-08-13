/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.List;

/**
 * Creates a band for a specified value range on the {@link GaugeAxis}. Multiple bands can be assigned to a single
 * {@link GaugeAxis}.
 * <br>
 * See documentation for properties of GaugeBand JS Object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/GaugeBand">http://docs.amcharts.com/3/javascriptcharts/GaugeBand</a>
 */
public class GaugeBand extends AbstractChartObject {

    private static final long serialVersionUID = 6480625092225201700L;

    private Double alpha;

    private List<Float> gradientRatio;

    private String balloonText;

    private Color color;

    private Double endValue;

    private String id;

    private String innerRadius;

    private String radius;

    private Double startValue;

    private String url;

    public GaugeBand() {
    }

    /**
     * @return opacity of band fill
     */
    public Double getAlpha() {
        return alpha;
    }

    /**
     * Sets opacity of band fill. Will use {@link GaugeAxis#bandAlpha} if not set any.
     *
     * @param alpha opacity
     */
    public GaugeBand setAlpha(Double alpha) {
        this.alpha = alpha;
        return this;
    }

    /**
     * @return color of a band
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color of a band.
     *
     * @param color color
     */
    public GaugeBand setColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * @return end value of a fill
     */
    public Double getEndValue() {
        return endValue;
    }

    /**
     * Sets end value of a fill.
     *
     * @param endValue end value
     */
    public GaugeBand setEndValue(Double endValue) {
        this.endValue = endValue;
        return this;
    }

    /**
     * @return inner radius of a band
     */
    public String getInnerRadius() {
        return innerRadius;
    }

    /**
     * Sets inner radius of a band. If not set any, the band will end with the end of minor ticks. Set 0 if you want
     * the band to be drawn to the axis center.
     *
     * @param innerRadius inner radius
     */
    public GaugeBand setInnerRadius(String innerRadius) {
        this.innerRadius = innerRadius;
        return this;
    }

    /**
     * @return band radius
     */
    public String getRadius() {
        return radius;
    }

    /**
     * Sets band radius. If not set any, the band will start with the axis outline.
     *
     * @param radius band radius
     */
    public GaugeBand setRadius(String radius) {
        this.radius = radius;
        return this;
    }

    /**
     * @return start value of a fill
     */
    public Double getStartValue() {
        return startValue;
    }

    /**
     * Sets start value of a fill.
     *
     * @param startValue start value
     */
    public GaugeBand setStartValue(Double startValue) {
        this.startValue = startValue;
        return this;
    }

    /**
     * @return balloon text
     */
    public String getBalloonText() {
        return balloonText;
    }

    /**
     * Sets balloon text. When rolled-over, band will display balloon.
     *
     * @param balloonText balloon text
     */
    public GaugeBand setBalloonText(String balloonText) {
        this.balloonText = balloonText;
        return this;
    }

    /**
     * @return unique id of a band
     */
    public String getId() {
        return id;
    }

    /**
     * Sets unique id of a band.
     *
     * @param id id
     */
    public GaugeBand setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return the URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets URL for band. Gauge band can be clickable and can lead to some page.
     *
     * @param url the URL
     */
    public GaugeBand setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * @return list of gradient ratio
     */
    public List<Float> getGradientRatio() {
        return gradientRatio;
    }

    /**
     * Sets list of gradient ratio. Will make bands to be filled with color gradients. Negative value means the color
     * will be darker than the original, and positive number means the color will be lighter.
     *
     * @param gradientRatio list of gradient ratio
     */
    public GaugeBand setGradientRatio(List<Float> gradientRatio) {
        this.gradientRatio = gradientRatio;
        return this;
    }
}