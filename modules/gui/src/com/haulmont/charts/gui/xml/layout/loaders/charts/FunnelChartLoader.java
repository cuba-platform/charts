/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.FunnelValueRepresentation;
import com.haulmont.charts.gui.amcharts.model.LabelPosition;
import com.haulmont.charts.gui.amcharts.model.charts.FunnelChart;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 * @author artamonov
 * @version $Id$
 */
public class FunnelChartLoader extends SlicedChartLoader<FunnelChart> {
    public FunnelChartLoader(Context context) {
        super(context);
    }

    @Override
    public Chart loadComponent(ComponentsFactory factory, Element element, Component parent) {
        Chart chart = super.loadComponent(factory, element, parent);

        FunnelChart configuration = new FunnelChart();
        loadConfiguration(configuration, element);
        chart.setConfiguration(configuration);

        assignFrame(chart);

        return chart;
    }

    @Override
    protected void loadConfiguration(FunnelChart chart, Element element) {
        super.loadConfiguration(chart, element);

        String balloonText = element.attributeValue("balloonText");
        if (StringUtils.isNotEmpty(balloonText)) {
            chart.setBalloonText(loadResourceString(balloonText));
        }

        String baseWidth = element.attributeValue("baseWidth");
        if (StringUtils.isNotEmpty(baseWidth)) {
            chart.setBaseWidth(baseWidth);
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