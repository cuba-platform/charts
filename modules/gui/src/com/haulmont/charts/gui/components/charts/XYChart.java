/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.components.charts;

import java.util.Collection;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public interface XYChart extends Chart, Chart.HasLegend, Chart.HasValueAxisType, Chart.HasArgumentAxisType {

    Collection<XYChartRow> getRows();
    void addRow(XYChartRow row);
}