/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.serialization;

import com.haulmont.charts.gui.amcharts.model.DataSet;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;

import java.util.Map;

public interface StockChartSerializer extends HasDataItemKeyMapper {

    String serialize(StockChartGroup chart);

    String serializeChanges(StockChartGroup chart, Map<DataSet, ChartIncrementalChanges> changedItems);
}
