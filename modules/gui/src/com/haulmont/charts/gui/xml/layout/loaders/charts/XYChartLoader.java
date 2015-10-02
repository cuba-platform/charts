/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.charts.XYChart;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 * @author artamonov
 * @version $Id$
 */
public class XYChartLoader extends RectangularChartLoader<XYChart> {

    @Override
    public void loadComponent() {
        super.loadComponent();

        XYChart configuration = new XYChart();
        loadConfiguration(configuration, element);
        resultComponent.setConfiguration(configuration);
    }

    @Override
    protected void loadConfiguration(XYChart chart, Element element) {
        super.loadConfiguration(chart, element);

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