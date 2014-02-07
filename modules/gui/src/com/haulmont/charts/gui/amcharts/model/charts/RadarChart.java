/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;

/**
 * See documentation for properties of AmRadarChart JS object.
 *
 * @author artamonov
 * @version $Id$
 */
public class RadarChart extends CoordinateChart<RadarChart> {

    private static final long serialVersionUID = 7721119324768771106L;

    public RadarChart() {
        super(ChartType.RADAR);
    }
}