/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of AmAngularGauge JS object.
 *
 * @author artamonov
 * @version $Id$
 */
public class AngularGaugeChart extends AbstractChart<AngularGaugeChart> {

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

    public Integer getMarginBottom() {
        return marginBottom;
    }

    public AngularGaugeChart setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public Integer getMarginLeft() {
        return marginLeft;
    }

    public AngularGaugeChart setMarginLeft(Integer marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public Integer getMarginRight() {
        return marginRight;
    }

    public AngularGaugeChart setMarginRight(Integer marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    public Integer getMarginTop() {
        return marginTop;
    }

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

    public Integer getStartDuration() {
        return startDuration;
    }

    public AngularGaugeChart setStartDuration(Integer startDuration) {
        this.startDuration = startDuration;
        return this;
    }

    public AnimationEffect getStartEffect() {
        return startEffect;
    }

    public AngularGaugeChart setStartEffect(AnimationEffect startEffect) {
        this.startEffect = startEffect;
        return this;
    }
}