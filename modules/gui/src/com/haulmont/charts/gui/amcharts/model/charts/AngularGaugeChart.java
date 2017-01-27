/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of AmAngularGauge JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmAngularGauge">http://docs.amcharts.com/3/javascriptcharts/AmAngularGauge</a>
 */
public class AngularGaugeChart extends AbstractChart<AngularGaugeChart>
        implements HasMargins<AngularGaugeChart>, HasStartEffect<AngularGaugeChart> {

    private static final long serialVersionUID = -6090793752941909292L;

    private Boolean adjustSize;

    private List<GaugeArrow> arrows;

    private List<GaugeAxis> axes;

    private Boolean clockWiseOnly;

    private Double faceAlpha;

    private Double faceBorderAlpha;

    private Color faceBorderColor;

    private Integer faceBorderWidth;

    private Color faceColor;

    private Pattern facePattern;

    private String gaugeX;

    private String gaugeY;

    private Integer marginBottom;

    private Integer marginLeft;

    private Integer marginRight;

    private Integer marginTop;

    private Integer minRadius;

    private Integer startDuration;

    private AnimationEffect startEffect;

    public AngularGaugeChart() {
        super(ChartType.GAUGE);
    }

    public Boolean getAdjustSize() {
        return adjustSize;
    }

    public AngularGaugeChart setAdjustSize(Boolean adjustSize) {
        this.adjustSize = adjustSize;
        return this;
    }

    public List<GaugeArrow> getArrows() {
        return arrows;
    }

    public AngularGaugeChart setArrows(List<GaugeArrow> arrows) {
        this.arrows = arrows;
        return this;
    }

    public AngularGaugeChart addArrows(GaugeArrow... arrows) {
        if (arrows != null) {
            if (this.arrows == null) {
                this.arrows = new ArrayList<>();
            }
            this.arrows.addAll(Arrays.asList(arrows));
        }
        return this;
    }

    public List<GaugeAxis> getAxes() {
        return axes;
    }

    public AngularGaugeChart setAxes(List<GaugeAxis> axes) {
        this.axes = axes;
        return this;
    }

    public AngularGaugeChart addAxes(GaugeAxis... axes) {
        if (axes != null) {
            if (this.axes == null) {
                this.axes = new ArrayList<>();
            }
            this.axes.addAll(Arrays.asList(axes));
        }
        return this;
    }

    public Boolean getClockWiseOnly() {
        return clockWiseOnly;
    }

    public AngularGaugeChart setClockWiseOnly(Boolean clockWiseOnly) {
        this.clockWiseOnly = clockWiseOnly;
        return this;
    }

    public Double getFaceAlpha() {
        return faceAlpha;
    }

    public AngularGaugeChart setFaceAlpha(Double faceAlpha) {
        this.faceAlpha = faceAlpha;
        return this;
    }

    public Double getFaceBorderAlpha() {
        return faceBorderAlpha;
    }

    public AngularGaugeChart setFaceBorderAlpha(Double faceBorderAlpha) {
        this.faceBorderAlpha = faceBorderAlpha;
        return this;
    }

    public Color getFaceBorderColor() {
        return faceBorderColor;
    }

    public AngularGaugeChart setFaceBorderColor(Color faceBorderColor) {
        this.faceBorderColor = faceBorderColor;
        return this;
    }

    public Integer getFaceBorderWidth() {
        return faceBorderWidth;
    }

    public AngularGaugeChart setFaceBorderWidth(Integer faceBorderWidth) {
        this.faceBorderWidth = faceBorderWidth;
        return this;
    }

    public Color getFaceColor() {
        return faceColor;
    }

    public AngularGaugeChart setFaceColor(Color faceColor) {
        this.faceColor = faceColor;
        return this;
    }

    public Pattern getFacePattern() {
        return facePattern;
    }

    public AngularGaugeChart setFacePattern(Pattern facePattern) {
        this.facePattern = facePattern;
        return this;
    }

    public String getGaugeX() {
        return gaugeX;
    }

    public AngularGaugeChart setGaugeX(String gaugeX) {
        this.gaugeX = gaugeX;
        return this;
    }

    public String getGaugeY() {
        return gaugeY;
    }

    public AngularGaugeChart setGaugeY(String gaugeY) {
        this.gaugeY = gaugeY;
        return this;
    }

    @Override
    public Integer getMarginBottom() {
        return marginBottom;
    }

    @Override
    public AngularGaugeChart setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    @Override
    public Integer getMarginLeft() {
        return marginLeft;
    }

    @Override
    public AngularGaugeChart setMarginLeft(Integer marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    @Override
    public Integer getMarginRight() {
        return marginRight;
    }

    @Override
    public AngularGaugeChart setMarginRight(Integer marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    @Override
    public Integer getMarginTop() {
        return marginTop;
    }

    @Override
    public AngularGaugeChart setMarginTop(Integer marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public Integer getMinRadius() {
        return minRadius;
    }

    public AngularGaugeChart setMinRadius(Integer minRadius) {
        this.minRadius = minRadius;
        return this;
    }

    @Override
    public Integer getStartDuration() {
        return startDuration;
    }

    @Override
    public AngularGaugeChart setStartDuration(Integer startDuration) {
        this.startDuration = startDuration;
        return this;
    }

    @Override
    public AnimationEffect getStartEffect() {
        return startEffect;
    }

    @Override
    public AngularGaugeChart setStartEffect(AnimationEffect startEffect) {
        this.startEffect = startEffect;
        return this;
    }
}