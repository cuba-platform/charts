/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;
import com.haulmont.charts.gui.amcharts.model.GradientType;
import com.haulmont.charts.gui.model.JsFunction;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * See documentation for properties of AmPieChart JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmPieChart">http://docs.amcharts.com/3/javascriptcharts/AmPieChart</a>
 */
public class PieChart extends SlicedChart<PieChart> implements PieChartModel<PieChart> {

    private static final long serialVersionUID = 7721119324768771106L;

    private Boolean adjustPrecision;

    private Integer angle;

    private JsFunction balloonFunction;

    private String balloonText;

    private Integer depth3D;

    private GradientType gradientType;

    private String innerRadius;

    private Integer labelRadius;

    private String labelRadiusField;

    private String labelText;

    private Integer minRadius;

    private Double pieAlpha;

    private String pieX;

    private String pieY;

    private String pullOutRadius;

    private String radius;

    private Integer startAngle;

    private String startRadius;

    public PieChart() {
        super(ChartType.PIE);
    }

    @Override
    public Integer getAngle() {
        return angle;
    }

    @Override
    public PieChart setAngle(Integer angle) {
        this.angle = angle;
        return this;
    }

    @Override
    public String getBalloonText() {
        return balloonText;
    }

    @Override
    public PieChart setBalloonText(String balloonText) {
        this.balloonText = balloonText;
        return this;
    }

    @Override
    public Integer getDepth3D() {
        return depth3D;
    }

    @Override
    public PieChart setDepth3D(Integer depth3D) {
        this.depth3D = depth3D;
        return this;
    }

    @Override
    public String getInnerRadius() {
        return innerRadius;
    }

    @Override
    public PieChart setInnerRadius(String innerRadius) {
        this.innerRadius = innerRadius;
        return this;
    }

    @Override
    public Integer getLabelRadius() {
        return labelRadius;
    }

    @Override
    public PieChart setLabelRadius(Integer labelRadius) {
        this.labelRadius = labelRadius;
        return this;
    }

    @Override
    public String getLabelRadiusField() {
        return labelRadiusField;
    }

    @Override
    public PieChart setLabelRadiusField(String labelRadiusField) {
        this.labelRadiusField = labelRadiusField;
        return this;
    }

    @Override
    public String getLabelText() {
        return labelText;
    }

    @Override
    public PieChart setLabelText(String labelText) {
        this.labelText = labelText;
        return this;
    }

    @Override
    public Integer getMinRadius() {
        return minRadius;
    }

    @Override
    public PieChart setMinRadius(Integer minRadius) {
        this.minRadius = minRadius;
        return this;
    }

    @Override
    public Double getPieAlpha() {
        return pieAlpha;
    }

    @Override
    public PieChart setPieAlpha(Double pieAlpha) {
        this.pieAlpha = pieAlpha;
        return this;
    }

    @Override
    public String getPieX() {
        return pieX;
    }

    @Override
    public PieChart setPieX(String pieX) {
        this.pieX = pieX;
        return this;
    }

    @Override
    public String getPieY() {
        return pieY;
    }

    @Override
    public PieChart setPieY(String pieY) {
        this.pieY = pieY;
        return this;
    }

    @Override
    public String getPullOutRadius() {
        return pullOutRadius;
    }

    @Override
    public PieChart setPullOutRadius(String pullOutRadius) {
        this.pullOutRadius = pullOutRadius;
        return this;
    }

    @Override
    public String getRadius() {
        return radius;
    }

    @Override
    public PieChart setRadius(String radius) {
        this.radius = radius;
        return this;
    }

    @Override
    public Integer getStartAngle() {
        return startAngle;
    }

    @Override
    public PieChart setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
        return this;
    }

    @Override
    public String getStartRadius() {
        return startRadius;
    }

    @Override
    public PieChart setStartRadius(String startRadius) {
        this.startRadius = startRadius;
        return this;
    }

    @Override
    public Boolean getAdjustPrecision() {
        return adjustPrecision;
    }

    @Override
    public PieChart setAdjustPrecision(Boolean adjustPrecision) {
        this.adjustPrecision = adjustPrecision;
        return this;
    }

    @Override
    public JsFunction getBalloonFunction() {
        return balloonFunction;
    }

    @Override
    public PieChart setBalloonFunction(JsFunction balloonFunction) {
        this.balloonFunction = balloonFunction;
        return this;
    }

    @Override
    public GradientType getGradientType() {
        return gradientType;
    }

    @Override
    public PieChart setGradientType(GradientType gradientType) {
        this.gradientType = gradientType;
        return this;
    }

    @Override
    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>(super.getWiredFields());

        if (StringUtils.isNotEmpty(labelRadiusField)) {
            wiredFields.add(labelRadiusField);
        }

        return wiredFields;
    }
}