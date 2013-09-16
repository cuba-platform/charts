/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.web.toolkit.ui.charts;

import com.haulmont.charts.web.toolkit.ui.charts.jfree.JFreeChart;
import com.haulmont.charts.web.toolkit.ui.charts.jfree.JFreeChartDataProvider;

import java.util.HashMap;
import java.util.Map;

public abstract class ChartDataProviderFactory {

    private static Map<String, VChartDataProvider> providers = new HashMap<String, VChartDataProvider>();

    static {
        providers.put(JFreeChart.VENDOR, new JFreeChartDataProvider());
    }

    public static void register(String chartVendor, VChartDataProvider dataProvider) {
        providers.put(chartVendor, dataProvider);
    }

    public static VChartDataProvider getDataProvider(String chartVendor) {
        return providers.get(chartVendor);
    }
}
