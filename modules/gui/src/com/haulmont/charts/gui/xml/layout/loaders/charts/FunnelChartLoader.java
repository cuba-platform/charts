/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.FunnelValueRepresentation;
import com.haulmont.charts.gui.amcharts.model.LabelPosition;
import com.haulmont.charts.gui.components.charts.FunnelChart;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

public class FunnelChartLoader extends SlicedChartLoader<FunnelChart> {

    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(FunnelChart.class);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
        super.loadComponent();

        loadConfiguration(resultComponent, element);
    }

    @Override
    protected void loadConfiguration(FunnelChart chart, Element element) {
        super.loadConfiguration(chart, element);

        String angle = element.attributeValue("angle");
        if (StringUtils.isNotEmpty(angle)) {
            chart.setAngle(Integer.valueOf(angle));
        }

        String balloonText = element.attributeValue("balloonText");
        if (StringUtils.isNotEmpty(balloonText)) {
            chart.setBalloonText(loadResourceString(balloonText));
        }

        String baseWidth = element.attributeValue("baseWidth");
        if (StringUtils.isNotEmpty(baseWidth)) {
            chart.setBaseWidth(baseWidth);
        }

        String depth3D = element.attributeValue("depth3D");
        if (StringUtils.isNotEmpty(depth3D)) {
            chart.setDepth3D(Integer.valueOf(depth3D));
        }

        String labelPosition = element.attributeValue("labelPosition");
        if (StringUtils.isNotEmpty(labelPosition)) {
            chart.setLabelPosition(LabelPosition.valueOf(labelPosition));
        }

        String labelText = element.attributeValue("labelText");
        if (StringUtils.isNotEmpty(labelText)) {
            chart.setLabelText(loadResourceString(labelText));
        }

        String neckHeight = element.attributeValue("neckHeight");
        if (StringUtils.isNotEmpty(neckHeight)) {
            chart.setNeckHeight(neckHeight);
        }

        String neckWidth = element.attributeValue("neckWidth");
        if (StringUtils.isNotEmpty(neckWidth)) {
            chart.setNeckWidth(neckWidth);
        }

        String pullDistance = element.attributeValue("pullDistance");
        if (StringUtils.isNotEmpty(pullDistance)) {
            chart.setPullDistance(pullDistance);
        }

        String rotate = element.attributeValue("rotate");
        if (StringUtils.isNotEmpty(rotate)) {
            chart.setRotate(Boolean.valueOf(rotate));
        }

        String startX = element.attributeValue("startX");
        if (StringUtils.isNotEmpty(startX)) {
            chart.setStartX(Integer.valueOf(startX));
        }

        String startY = element.attributeValue("startY");
        if (StringUtils.isNotEmpty(startY)) {
            chart.setStartY(Integer.valueOf(startY));
        }

        String valueRepresents = element.attributeValue("valueRepresents");
        if (StringUtils.isNotEmpty(valueRepresents)) {
            chart.setValueRepresents(FunnelValueRepresentation.valueOf(valueRepresents));
        }
    }
}