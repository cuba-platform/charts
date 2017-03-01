/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.GradientType;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.charts.gui.model.JsFunction;

public class WebPieChart extends WebSlicedChart<PieChart, com.haulmont.charts.gui.amcharts.model.charts.PieChart>
        implements PieChart {

    @Override
    protected com.haulmont.charts.gui.amcharts.model.charts.PieChart createChartConfiguration() {
        return new com.haulmont.charts.gui.amcharts.model.charts.PieChart();
    }

    @Override
    public Integer getAngle() {
        return getModel().getAngle();
    }

    @Override
    public PieChart setAngle(Integer angle) {
        getModel().setAngle(angle);
        return this;
    }

    @Override
    public String getBalloonText() {
        return getModel().getBalloonText();
    }

    @Override
    public PieChart setBalloonText(String balloonText) {
        getModel().setBalloonText(balloonText);
        return this;
    }

    @Override
    public Integer getDepth3D() {
        return getModel().getDepth3D();
    }

    @Override
    public PieChart setDepth3D(Integer depth3D) {
        getModel().setDepth3D(depth3D);
        return this;
    }

    @Override
    public String getInnerRadius() {
        return getModel().getInnerRadius();
    }

    @Override
    public PieChart setInnerRadius(String innerRadius) {
        getModel().setInnerRadius(innerRadius);
        return this;
    }

    @Override
    public Integer getLabelRadius() {
        return getModel().getLabelRadius();
    }

    @Override
    public PieChart setLabelRadius(Integer labelRadius) {
        getModel().setLabelRadius(labelRadius);
        return this;
    }

    @Override
    public String getLabelRadiusField() {
        return getModel().getLabelRadiusField();
    }

    @Override
    public PieChart setLabelRadiusField(String labelRadiusField) {
        getModel().setLabelRadiusField(labelRadiusField);
        return this;
    }

    @Override
    public String getLabelText() {
        return getModel().getLabelText();
    }

    @Override
    public PieChart setLabelText(String labelText) {
        getModel().setLabelText(labelText);
        return this;
    }

    @Override
    public Integer getMinRadius() {
        return getModel().getMinRadius();
    }

    @Override
    public PieChart setMinRadius(Integer minRadius) {
        getModel().setMinRadius(minRadius);
        return this;
    }

    @Override
    public Double getPieAlpha() {
        return getModel().getPieAlpha();
    }

    @Override
    public PieChart setPieAlpha(Double pieAlpha) {
        getModel().setPieAlpha(pieAlpha);
        return this;
    }

    @Override
    public String getPieX() {
        return getModel().getPieX();
    }

    @Override
    public PieChart setPieX(String pieX) {
        getModel().setPieX(pieX);
        return this;
    }

    @Override
    public String getPieY() {
        return getModel().getPieY();
    }

    @Override
    public PieChart setPieY(String pieY) {
        getModel().setPieY(pieY);
        return this;
    }

    @Override
    public String getPullOutRadius() {
        return getModel().getPullOutRadius();
    }

    @Override
    public PieChart setPullOutRadius(String pullOutRadius) {
        getModel().setPullOutRadius(pullOutRadius);
        return this;
    }

    @Override
    public String getRadius() {
        return getModel().getRadius();
    }

    @Override
    public PieChart setRadius(String radius) {
        getModel().setRadius(radius);
        return this;
    }

    @Override
    public Integer getStartAngle() {
        return getModel().getStartAngle();
    }

    @Override
    public PieChart setStartAngle(Integer startAngle) {
        getModel().setStartAngle(startAngle);
        return this;
    }

    @Override
    public String getStartRadius() {
        return getModel().getStartRadius();
    }

    @Override
    public PieChart setStartRadius(String startRadius) {
        getModel().setStartRadius(startRadius);
        return this;
    }

    @Override
    public Boolean getAdjustPrecision() {
        return getModel().getAdjustPrecision();
    }

    @Override
    public PieChart setAdjustPrecision(Boolean adjustPrecision) {
        getModel().setAdjustPrecision(adjustPrecision);
        return this;
    }

    @Override
    public JsFunction getBalloonFunction() {
        return getModel().getBalloonFunction();
    }

    @Override
    public PieChart setBalloonFunction(JsFunction balloonFunction) {
        getModel().setBalloonFunction(balloonFunction);
        return this;
    }

    @Override
    public GradientType getGradientType() {
        return getModel().getGradientType();
    }

    @Override
    public PieChart setGradientType(GradientType gradientType) {
        getModel().setGradientType(gradientType);
        return this;
    }
}