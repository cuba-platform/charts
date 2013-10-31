/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
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