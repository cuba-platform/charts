/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;
import com.haulmont.charts.gui.amcharts.model.GradientType;
import com.haulmont.charts.gui.model.JsFunction;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * See documentation for properties of AmPieChart JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmPieChart">http://docs.amcharts.com/3/javascriptcharts/AmPieChart</a>
 */
public class PieChart extends SlicedChart<PieChart> {

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

    public Integer getAngle() {
        return angle;
    }

    public PieChart setAngle(Integer angle) {
        this.angle = angle;
        return this;
    }

    public String getBalloonText() {
        return balloonText;
    }

    public PieChart setBalloonText(String balloonText) {
        this.balloonText = balloonText;
        return this;
    }

    public Integer getDepth3D() {
        return depth3D;
    }

    public PieChart setDepth3D(Integer depth3D) {
        this.depth3D = depth3D;
        return this;
    }

    public String getInnerRadius() {
        return innerRadius;
    }

    public PieChart setInnerRadius(String innerRadius) {
        this.innerRadius = innerRadius;
        return this;
    }

    public Integer getLabelRadius() {
        return labelRadius;
    }

    public PieChart setLabelRadius(Integer labelRadius) {
        this.labelRadius = labelRadius;
        return this;
    }

    public String getLabelRadiusField() {
        return labelRadiusField;
    }

    public PieChart setLabelRadiusField(String labelRadiusField) {
        this.labelRadiusField = labelRadiusField;
        return this;
    }

    public String getLabelText() {
        return labelText;
    }

    public PieChart setLabelText(String labelText) {
        this.labelText = labelText;
        return this;
    }

    public Integer getMinRadius() {
        return minRadius;
    }

    public PieChart setMinRadius(Integer minRadius) {
        this.minRadius = minRadius;
        return this;
    }

    public Double getPieAlpha() {
        return pieAlpha;
    }

    public PieChart setPieAlpha(Double pieAlpha) {
        this.pieAlpha = pieAlpha;
        return this;
    }

    public String getPieX() {
        return pieX;
    }

    public PieChart setPieX(String pieX) {
        this.pieX = pieX;
        return this;
    }

    public String getPieY() {
        return pieY;
    }

    public PieChart setPieY(String pieY) {
        this.pieY = pieY;
        return this;
    }

    public String getPullOutRadius() {
        return pullOutRadius;
    }

    public PieChart setPullOutRadius(String pullOutRadius) {
        this.pullOutRadius = pullOutRadius;
        return this;
    }

    public String getRadius() {
        return radius;
    }

    public PieChart setRadius(String radius) {
        this.radius = radius;
        return this;
    }

    public Integer getStartAngle() {
        return startAngle;
    }

    public PieChart setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
        return this;
    }

    public String getStartRadius() {
        return startRadius;
    }

    public PieChart setStartRadius(String startRadius) {
        this.startRadius = startRadius;
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

    public Boolean getAdjustPrecision() {
        return adjustPrecision;
    }

    public PieChart setAdjustPrecision(Boolean adjustPrecision) {
        this.adjustPrecision = adjustPrecision;
        return this;
    }

    public JsFunction getBalloonFunction() {
        return balloonFunction;
    }

    public PieChart setBalloonFunction(JsFunction balloonFunction) {
        this.balloonFunction = balloonFunction;
        return this;
    }

    public GradientType getGradientType() {
        return gradientType;
    }

    public PieChart setGradientType(GradientType gradientType) {
        this.gradientType = gradientType;
        return this;
    }
}