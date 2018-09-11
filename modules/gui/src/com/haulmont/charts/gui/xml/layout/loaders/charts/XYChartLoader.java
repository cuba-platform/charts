/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.components.charts.XYChart;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;

public class XYChartLoader extends RectangularChartLoader<XYChart> {
    @Override
    public void createComponent() {
        resultComponent = factory.create(XYChart.NAME);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
        super.loadComponent();

        loadConfiguration(resultComponent, element);
    }

    @Override
    protected void loadConfiguration(XYChart chart, Element element) {
        super.loadConfiguration(chart, element);

        String dataDateFormat = element.attributeValue("dataDateFormat");
        if (StringUtils.isNotEmpty(dataDateFormat)) {
            chart.setDataDateFormat(dataDateFormat);
        }

        String hideXScrollbar = element.attributeValue("hideXScrollbar");
        if (StringUtils.isNotEmpty(hideXScrollbar)) {
            chart.setHideXScrollbar(Boolean.valueOf(hideXScrollbar));
        }

        String hideYScrollbar = element.attributeValue("hideYScrollbar");
        if (StringUtils.isNotEmpty(hideYScrollbar)) {
            chart.setHideYScrollbar(Boolean.valueOf(hideYScrollbar));
        }

        String maxValue = element.attributeValue("maxValue");
        if (StringUtils.isNotEmpty(maxValue)) {
            chart.setMaxValue(Integer.valueOf(maxValue));
        }

        String minValue = element.attributeValue("minValue");
        if (StringUtils.isNotEmpty(minValue)) {
            chart.setMinValue(Integer.valueOf(minValue));
        }
    }
}