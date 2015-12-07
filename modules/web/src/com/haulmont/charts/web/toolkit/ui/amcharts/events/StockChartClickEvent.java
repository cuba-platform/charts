/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;

/**
 * @author artamonov
 * @version $Id$
 */
public class StockChartClickEvent extends Component.Event {

    private final int x;
    private final int y;
    private final int absoluteX;
    private final int absoluteY;

    public StockChartClickEvent(AbstractComponent source, int x, int y, int absoluteX, int absoluteY) {
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