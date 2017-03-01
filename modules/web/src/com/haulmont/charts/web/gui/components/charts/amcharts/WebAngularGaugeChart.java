/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.AngularGaugeChart;

import java.util.List;

public class WebAngularGaugeChart extends WebChart<AngularGaugeChart, com.haulmont.charts.gui.amcharts.model.charts.AngularGaugeChart> implements AngularGaugeChart {
    @Override
    protected com.haulmont.charts.gui.amcharts.model.charts.AngularGaugeChart createChartConfiguration() {
        return new com.haulmont.charts.gui.amcharts.model.charts.AngularGaugeChart();
    }

    @Override
    public Boolean getAdjustSize() {
        return getModel().getAdjustSize();
    }

    @Override
    public AngularGaugeChart setAdjustSize(Boolean adjustSize) {
        getModel().setAdjustSize(adjustSize);
        return this;
    }

    @Override
    public List<GaugeArrow> getArrows() {
        return getModel().getArrows();
    }

    @Override
    public AngularGaugeChart setArrows(List<GaugeArrow> arrows) {
        getModel().setArrows(arrows);
        return this;
    }

    @Override
    public AngularGaugeChart addArrows(GaugeArrow... arrows) {
        getModel().addArrows(arrows);
        return this;
    }

    @Override
    public List<GaugeAxis> getAxes() {
        return getModel().getAxes();
    }

    @Override
    public AngularGaugeChart setAxes(List<GaugeAxis> axes) {
        getModel().setAxes(axes);
        return this;
    }

    @Override
    public AngularGaugeChart addAxes(GaugeAxis... axes) {
        getModel().addAxes(axes);
        return this;
    }

    @Override
    public Boolean getClockWiseOnly() {
        return getModel().getClockWiseOnly();
    }

    @Override
    public AngularGaugeChart setClockWiseOnly(Boolean clockWiseOnly) {
        getModel().setClockWiseOnly(clockWiseOnly);
        return this;
    }

    @Override
    public Double getFaceAlpha() {
        return getModel().getFaceAlpha();
    }

    @Override
    public AngularGaugeChart setFaceAlpha(Double faceAlpha) {
        getModel().setFaceAlpha(faceAlpha);
        return this;
    }

    @Override
    public Double getFaceBorderAlpha() {
        return getModel().getFaceBorderAlpha();
    }

    @Override
    public AngularGaugeChart setFaceBorderAlpha(Double faceBorderAlpha) {
        getModel().setFaceBorderAlpha(faceBorderAlpha);
        return this;
    }

    @Override
    public Color getFaceBorderColor() {
        return getModel().getFaceBorderColor();
    }

    @Override
    public AngularGaugeChart setFaceBorderColor(Color faceBorderColor) {
        getModel().setFaceBorderColor(faceBorderColor);
        return this;
    }

    @Override
    public Integer getFaceBorderWidth() {
        return getModel().getFaceBorderWidth();
    }

    @Override
    public AngularGaugeChart setFaceBorderWidth(Integer faceBorderWidth) {
        getModel().setFaceBorderWidth(faceBorderWidth);
        return this;
    }

    @Override
    public Color getFaceColor() {
        return getModel().getFaceColor();
    }

    @Override
    public AngularGaugeChart setFaceColor(Color faceColor) {
        getModel().setFaceColor(faceColor);
        return this;
    }

    @Override
    public Pattern getFacePattern() {
        return getModel().getFacePattern();
    }

    @Override
    public AngularGaugeChart setFacePattern(Pattern facePattern) {
        getModel().setFacePattern(facePattern);
        return this;
    }

    @Override
    public String getGaugeX() {
        return getModel().getGaugeX();
    }

    @Override
    public AngularGaugeChart setGaugeX(String gaugeX) {
        getModel().setGaugeX(gaugeX);
        return this;
    }

    @Override
    public String getGaugeY() {
        return getModel().getGaugeY();
    }

    @Override
    public AngularGaugeChart setGaugeY(String gaugeY) {
        getModel().setGaugeY(gaugeY);
        return this;
    }

    @Override
    public Integer getMarginBottom() {
        return getModel().getMarginBottom();
    }

    @Override
    public AngularGaugeChart setMarginBottom(Integer marginBottom) {
        getModel().setMarginBottom(marginBottom);
        return this;
    }

    @Override
    public Integer getMarginLeft() {
        return getModel().getMarginLeft();
    }

    @Override
    public AngularGaugeChart setMarginLeft(Integer marginLeft) {
        getModel().setMarginLeft(marginLeft);
        return this;
    }

    @Override
    public Integer getMarginRight() {
        return getModel().getMarginRight();
    }

    @Override
    public AngularGaugeChart setMarginRight(Integer marginRight) {
        getModel().setMarginRight(marginRight);
        return this;
    }

    @Override
    public Integer getMarginTop() {
        return getModel().getMarginTop();
    }

    @Override
    public AngularGaugeChart setMarginTop(Integer marginTop) {
        getModel().setMarginTop(marginTop);
        return this;
    }

    @Override
    public Integer getMinRadius() {
        return getModel().getMinRadius();
    }

    @Override
    public AngularGaugeChart setMinRadius(Integer minRadius) {
        getModel().setMinRadius(minRadius);
        return this;
    }

    @Override
    public Integer getStartDuration() {
        return getModel().getStartDuration();
    }

    @Override
    public AngularGaugeChart setStartDuration(Integer startDuration) {
        getModel().setStartDuration(startDuration);
        return this;
    }

    @Override
    public AnimationEffect getStartEffect() {
        return getModel().getStartEffect();
    }

    @Override
    public AngularGaugeChart setStartEffect(AnimationEffect startEffect) {
        getModel().setStartEffect(startEffect);
        return this;
    }
}