/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;

public class StockChartRightClickEvent extends Component.Event {

    private final int x;
    private final int y;
    private final int absoluteX;
    private final int absoluteY;

    public StockChartRightClickEvent(AbstractComponent source, int x, int y, int absoluteX, int absoluteY) {
        super(source);
        this.x = x;
        this.y = y;
        this.absoluteX = absoluteX;
        this.absoluteY = absoluteY;
    }

    public int getAbsoluteX() {
        return absoluteX;
    }

    public int getAbsoluteY() {
        return absoluteY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}