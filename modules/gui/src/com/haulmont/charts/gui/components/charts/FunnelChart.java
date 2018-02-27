/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.FunnelChartModel;

/**
 * Funnel / pyramid chart component.
 * <br>
 * See documentation for properties of AmFunnelChart JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmFunnelChart">http://docs.amcharts.com/3/javascriptcharts/AmFunnelChart</a>
 */
public interface FunnelChart extends SlicedChart<FunnelChart>, FunnelChartModel<FunnelChart> {
    String NAME = "funnelChart";
}