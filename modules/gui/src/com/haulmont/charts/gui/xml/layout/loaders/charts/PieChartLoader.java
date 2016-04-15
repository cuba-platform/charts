/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.GradientType;
import com.haulmont.charts.gui.amcharts.model.JsFunction;
import com.haulmont.charts.gui.amcharts.model.charts.PieChart;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 */
public class PieChartLoader extends SlicedChartLoader<PieChart> {

    @Override
    public void loadComponent() {
        super.loadComponent();

        PieChart configuration = new PieChart();
        loadConfiguration(configuration, element);
        resultComponent.setConfiguration(configuration);
    }

    @Override
    protected void loadConfiguration(PieChart chart, Element element) {
        super.loadConfiguration(chart, element);

        String adjustPrecision = element.attributeValue("adjustPrecision");
        if (StringUtils.isNotEmpty(adjustPrecision)) {
            chart.setAdjustPrecision(Boolean.valueOf(adjustPrecision));
        }

        String angle = element.attributeValue("angle");
        if (StringUtils.isNotEmpty(angle)) {
            chart.setAngle(Integer.valueOf(angle));
        }

        String balloonFunction = element.elementText("balloonFunction");
        if (StringUtils.isNotEmpty(balloonFunction)) {
            chart.setBalloonFunction(new JsFunction(balloonFunction));
        }

        String balloonText = element.attributeValue("balloonText");
        if (StringUtils.isNotEmpty(balloonText)) {
            chart.setBalloonText(loadResourceString(balloonText));
        }

        String depth3D = element.attributeValue("depth3D");
        if (StringUtils.isNotEmpty(depth3D)) {
            chart.setDepth3D(Integer.valueOf(depth3D));
        }

        String gradientType = element.attributeValue("gradientType");
        if (StringUtils.isNotEmpty(gradientType)) {
            chart.setGradientType(GradientType.valueOf("gradientType"));
        }

        String innerRadius = element.attributeValue("innerRadius");
        if (StringUtils.isNotEmpty(innerRadius)) {
            chart.setInnerRadius(innerRadius);
        }

        String labelRadius = element.attributeValue("labelRadius");
        if (StringUtils.isNotEmpty(labelRadius)) {
            chart.setLabelRadius(Integer.valueOf(labelRadius));
        }

        String labelRadiusField = element.attributeValue("labelRadiusField");
        if (StringUtils.isNotEmpty(labelRadiusField)) {
            chart.setLabelRadiusField(labelRadiusField);
        }

        String labelText = element.attributeValue("labelText");
        if (StringUtils.isNotEmpty(labelText)) {
            chart.setLabelText(loadResourceString(labelText));
        }

        String minRadius = element.attributeValue("minRadius");
        if (StringUtils.isNotEmpty(minRadius)) {
            chart.setMinRadius(Integer.valueOf(minRadius));
        }

        String pieAlpha = element.attributeValue("pieAlpha");
        if (StringUtils.isNotEmpty(pieAlpha)) {
            chart.setPieAlpha(Double.valueOf(pieAlpha));
        }

        String pieX = element.attributeValue("pieX");
        if (StringUtils.isNotEmpty(pieX)) {
            chart.setPieX(pieX);
        }

        String pieY = element.attributeValue("pieY");
        if (StringUtils.isNotEmpty(pieY)) {
            chart.setPieY(pieY);
        }

        String pullOutRadius = element.attributeValue("pullOutRadius");
        if (StringUtils.isNotEmpty(pullOutRadius)) {
            chart.setPullOutRadius(pullOutRadius);
        }

        String radius = element.attributeValue("radius");
        if (StringUtils.isNotEmpty(radius)) {
            chart.setRadius(radius);
        }

        String startAngle = element.attributeValue("startAngle");
        if (StringUtils.isNotEmpty(startAngle)) {
            chart.setStartAngle(Integer.valueOf(startAngle));
        }

        String startRadius = element.attributeValue("startRadius");
        if (StringUtils.isNotEmpty(startRadius)) {
            chart.setStartRadius(startRadius);
        }
    }
}