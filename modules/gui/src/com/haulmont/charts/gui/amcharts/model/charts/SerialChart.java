/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;

/**
 * See documentation for properties of AmSerialChart JS object. <br/>
 * <p>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmSerialChart">http://docs.amcharts.com/3/javascriptcharts/AmSerialChart</a>
 *
 */
public class SerialChart extends AbstractSerialChart<SerialChart> {

    private static final long serialVersionUID = 4640758803235179022L;

    public SerialChart() {
        super(ChartType.SERIAL);
    }
}