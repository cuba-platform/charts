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
    public RadarChartLoader(Context context) {
        super(context);
    }

    @Override
    public Chart loadComponent(ComponentsFactory factory, Element element, Component parent) {
        Chart chart = super.loadComponent(factory, element, parent);

        RadarChart configuration = new RadarChart();
        loadConfiguration(configuration, element);
        chart.setConfiguration(configuration);

        assignFrame(chart);

        return chart;
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