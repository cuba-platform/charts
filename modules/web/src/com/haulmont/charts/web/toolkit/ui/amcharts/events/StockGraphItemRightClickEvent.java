/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;

/**
 * @author gorelov
 * @version $Id$
 */
public class StockGraphItemRightClickEvent extends AbstractStockGraphItemEvent {
    public StockGraphItemRightClickEvent(CubaAmStockChartScene scene, String panelId, String graphId, String itemId,
                                         int itemIndex, int x, int y, int absoluteX, int absoluteY) {
        super(scene, panelId, graphId, itemId, itemIndex, x, y, absoluteX, absoluteY);
    }
}
