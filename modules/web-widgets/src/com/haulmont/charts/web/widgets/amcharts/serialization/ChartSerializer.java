/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.serialization;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;

public interface ChartSerializer extends HasDataItemKeyMapper {

    String serialize(AbstractChart chart);

    String serializeChanges(AbstractChart chart, ChartIncrementalChanges changes);

    String toJson(Object value);
}
