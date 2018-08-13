/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.web.widgets.amcharts.CubaAmStockChartScene;

public abstract class AbstractStockGraphEvent extends com.vaadin.ui.Component.Event {

    private final String panelId;
    private final String graphId;

    private final int x;
    private final int y;
    private final int absoluteX;
    private final int absoluteY;

    protected AbstractStockGraphEvent(CubaAmStockChartScene scene, String panelId, String graphId,
                                      int x, int y, int absoluteX, int absoluteY) {
        super(scene);
        this.panelId = panelId;
        this.graphId = graphId;
        this.x = x;
        this.y = y;
        this.absoluteX = absoluteX;
        this.absoluteY = absoluteY;
    }

    public String getPanelId() {
        return panelId;
    }

    public String getGraphId() {
        return graphId;
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