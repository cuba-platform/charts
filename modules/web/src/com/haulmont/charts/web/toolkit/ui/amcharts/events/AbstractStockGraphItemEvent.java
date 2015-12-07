/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;
import com.vaadin.ui.Component;

/**
 * @author gorelov
 * @version $Id$
 */
public abstract class AbstractStockGraphItemEvent extends Component.Event {

    private final String panelId;
    private final String graphId;

    private final int x;
    private final int y;
    private final int absoluteX;
    private final int absoluteY;

    private final String itemId;
    private final int itemIndex;

    protected AbstractStockGraphItemEvent(CubaAmStockChartScene scene, String panelId, String graphId, String itemId, int itemIndex,
                                          int x, int y, int absoluteX, int absoluteY) {
        super(scene);
        this.panelId = panelId;
        this.itemId = itemId;
        this.itemIndex = itemIndex;
        this.absoluteY = absoluteY;
        this.absoluteX = absoluteX;
        this.graphId = graphId;
        this.x = x;
        this.y = y;
    }

    public String getPanelId() {
        return panelId;
    }

    public String getGraphId() {
        return graphId;
    }

    public String getItemId() {
        return itemId;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAbsoluteX() {
        return absoluteX;
    }

    public int getAbsoluteY() {
        return absoluteY;
    }
}
