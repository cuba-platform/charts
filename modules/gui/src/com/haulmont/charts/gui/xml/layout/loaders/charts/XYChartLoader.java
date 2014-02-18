/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.charts.XYChart;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 * @author artamonov
 * @version $Id$
 */
public class XYChartLoader extends RectangularChartLoader<XYChart> {
    public XYChartLoader(Context context) {
        super(context);
    }

    @Override
    public Chart loadComponent(ComponentsFactory factory, Element element, Component parent) {
        Chart chart = super.loadComponent(factory, element, parent);

        XYChart configuration = new XYChart();
        loadConfiguration(element, configuration);
        chart.setConfiguration(configuration);

        assignFrame(chart);

        return chart;
    }

    @Override
    protected void loadConfiguration(Element element, XYChart chart) {
        super.loadConfiguration(element, chart);

        String hideXScrollbar = element.attributeValue("hideXScrollbar");
        if (StringUtils.isNotEmpty(hideXScrollbar)) {
            chart.setHideXScrollbar(Boolean.valueOf(hideXScrollbar));
        }

        String hideYScrollbar = element.attributeValue("hideYScrollbar");
        if (StringUtils.isNotEmpty(hideYScrollbar)) {
            chart.setHideYScrollbar(Boolean.valueOf(hideYScrollbar));
        }

        String maxZoomFactor = element.attributeValue("maxZoomFactor");
        if (StringUtils.isNotEmpty(maxZoomFactor)) {
            chart.setMaxZoomFactor(Integer.valueOf(maxZoomFactor));
        }
    }
}