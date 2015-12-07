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
public class StockEventClickEvent extends AbstractStockEventEvent {
    private static final long serialVersionUID = -995274588662239672L;

    public StockEventClickEvent(CubaAmStockChartScene scene, String graphId, Date date, String stockEventId) {
        super(scene, graphId, date, stockEventId);
    }
}
