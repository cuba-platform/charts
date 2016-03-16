/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;

/**
 */
public class DataSetSelectorCompareEvent extends AbstractDataSetSelectorEvent {
    public DataSetSelectorCompareEvent(CubaAmStockChartScene scene, String dataSetId) {
        super(scene, dataSetId);
    }
}
