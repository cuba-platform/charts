/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.CategoryAxis;
import com.haulmont.charts.gui.components.charts.SeriesBasedChart;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

public abstract class AbstractSerialChartLoader<T extends SeriesBasedChart> extends RectangularChartLoader<T> {

    @Override
    public void loadComponent() {
        super.loadComponent();

        loadConfiguration(resultComponent, element);

        String byDate = element.attributeValue("byDate");
        if (StringUtils.isNotEmpty(byDate)) {
            if (resultComponent.getCategoryAxis() == null) {
                resultComponent.setCategoryAxis(new CategoryAxis());
            }

            resultComponent.getCategoryAxis().setParseDates(Boolean.valueOf(byDate));
        }
    }

    @Override
    protected void loadConfiguration(T chart, Element element) {
        super.loadConfiguration(chart, element);

        loadSeriesBasedProperties(chart, element);
    }
}