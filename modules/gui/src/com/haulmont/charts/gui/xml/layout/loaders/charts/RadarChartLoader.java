/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.components.charts.RadarChart;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;

public class RadarChartLoader extends CoordinateChartLoader<RadarChart> {

    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(RadarChart.class);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
        super.loadComponent();

        loadConfiguration(resultComponent, element);
    }

    @Override
    protected void loadConfiguration(RadarChart chart, Element element) {
        super.loadConfiguration(chart, element);

        String categoryField = element.attributeValue("categoryField");
        if (StringUtils.isNotEmpty(categoryField)) {
            chart.setCategoryField(categoryField);
        }

        loadMargins(chart, element);

        String radius = element.attributeValue("radius");
        if (StringUtils.isNotEmpty(radius)) {
            chart.setRadius(radius);
        }
    }
}