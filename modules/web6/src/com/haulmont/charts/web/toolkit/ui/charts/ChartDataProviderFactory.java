/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
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
