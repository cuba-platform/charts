/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.charts.RadarChart;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 * @author artamonov
 * @version $Id$
 */
public class RadarChartLoader extends CoordinateChartLoader<RadarChart> {
    protected RadarChartLoader(Context context) {
        super(context);
    }

    @Override
    public Chart loadComponent(ComponentsFactory factory, Element element, Component parent) {
        Chart chart = super.loadComponent(factory, element, parent);

        RadarChart configuration = new RadarChart();
        loadConfiguration(element, configuration);
        chart.setConfiguration(configuration);

        assignFrame(chart);

        return chart;
    }

    @Override
    protected void loadConfiguration(Element element, RadarChart chart) {
        super.loadConfiguration(element, chart);

        String categoryField = element.attributeValue("categoryField");
        if (StringUtils.isNotEmpty(categoryField)) {
            chart.setCategoryField(categoryField);
        }

        loadMargins(element, chart);

        String radius = element.attributeValue("radius");
        if (StringUtils.isNotEmpty(radius)) {
            chart.setRadius(radius);
        }
    }
}