/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.AbstractChartObject;
import com.haulmont.charts.gui.data.DataItem;

import java.util.List;

public abstract class ChartModelImpl extends AbstractChartObject {

    /**
     * @return fields of the {@link DataItem} that are bound to the chart
     */
    public abstract List<String> getWiredFields();
}