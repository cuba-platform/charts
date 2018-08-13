/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;

public abstract class AbstractClickEvent extends com.vaadin.ui.Component.Event {

    private static final long serialVersionUID = -549144399958392892L;

    private final int x;
    private final int y;
    private final int absoluteX;
    private final int absoluteY;

    public AbstractClickEvent(CubaAmchartsScene scene, int x, int y, int absoluteX, int absoluteY) {
        super(scene);
        this.x = x;
        this.y = y;
        this.absoluteX = absoluteX;
        this.absoluteY = absoluteY;
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
