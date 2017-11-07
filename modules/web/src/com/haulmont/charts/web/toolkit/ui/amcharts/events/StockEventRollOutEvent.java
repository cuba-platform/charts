/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;

import java.util.Date;

public class StockEventRollOutEvent extends AbstractStockEventEvent {
    private static final long serialVersionUID = 137246431386490989L;

    public StockEventRollOutEvent(CubaAmStockChartScene scene, String graphId, Date date, String stockEventId) {
        super(scene, graphId, date, stockEventId);
    }
}