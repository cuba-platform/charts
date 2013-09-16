/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.data.Container;

import java.util.Collection;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public interface WXYChart extends WChart, WChart.HasLegend, WChart.HasValueAxisType, WChart.HasArgumentAxisType,
        Container.ItemSetChangeListener, Container.PropertySetChangeListener {

    Collection<WXYChartRow> getRows();
    void addRow(WXYChartRow row);
}