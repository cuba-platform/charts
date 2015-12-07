/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.charts.SerialChart;
import org.apache.commons.lang.StringUtils;

/**
 * @author artamonov
 * @version $Id$
 */
public class SerialChartLoader<T extends SerialChart> extends AbstractSerialChartLoader<T> {
    @Override
    public void loadComponent() {
        super.loadComponent();

        T configuration = createConfiguration();
        loadConfiguration(configuration, element);
        resultComponent.setConfiguration(configuration);

        String byDate = element.attributeValue("byDate");
        if (StringUtils.isNotEmpty(byDate)) {
            resultComponent.setByDate(Boolean.valueOf(byDate));
        }
    }

    @SuppressWarnings("unchecked")
    protected T createConfiguration() {
        return (T) new SerialChart();
    }
}