/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;

import java.util.Date;

/**
 * @author gorelov
 * @version $Id$
 */
public class StockEventRollOverEvent extends AbstractStockEventEvent {
    private static final long serialVersionUID = 6264694014859141084L;

    public StockEventRollOverEvent(CubaAmStockChartScene scene, String graphId, Date date, String stockEventId) {
        super(scene, graphId, date, stockEventId);
    }
}
