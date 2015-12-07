/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;

/**
 * @author artamonov
 * @version $Id$
 */
public class StockGraphRollOverEvent extends AbstractStockGraphEvent {
    public StockGraphRollOverEvent(CubaAmStockChartScene scene, String panelId, String graphId,
                                   int x, int y, int absoluteX, int absoluteY) {
        super(scene, panelId, graphId, x, y, absoluteX, absoluteY);
    }
}