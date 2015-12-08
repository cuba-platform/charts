/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.charts.SerialChart;

/**
 * @author artamonov
 * @version $Id$
 */
public class SerialChartLoader extends AbstractSerialChartLoader<SerialChart> {

    protected SerialChart createConfiguration() {
        return new SerialChart();
    }
}