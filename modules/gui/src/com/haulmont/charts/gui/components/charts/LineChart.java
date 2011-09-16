/*
 * Copyright (c) 2008 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.

 * Author: Nikolay Gorodnov
 * Created: 07.09.2010 17:44:12
 *
 * $Id$
 */
package com.haulmont.cuba.gui.components.charts;

/** Line chart component */
public interface LineChart
        extends
        CategoryChart,
        Chart.HasAxisLabels,
        Chart.HasValueAxisType,
        Chart.HasOrientation {

    String NAME = "lineChart";
}
