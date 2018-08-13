/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.web.widgets.amcharts.CubaAmStockChartScene;

public class StockGraphItemClickEvent extends AbstractStockGraphItemEvent {
    public StockGraphItemClickEvent(CubaAmStockChartScene scene, String panelId, String graphId, DataItem dataItem,
                                    int itemIndex, int x, int y, int absoluteX, int absoluteY) {
        super(scene, panelId, graphId, dataItem, itemIndex, x, y, absoluteX, absoluteY);
    }
}