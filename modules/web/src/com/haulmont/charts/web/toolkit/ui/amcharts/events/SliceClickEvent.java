/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;

/**
 * @author artamonov
 * @version $Id$
 */
public class SliceClickEvent extends com.vaadin.ui.Component.Event {

    private static final long serialVersionUID = -536343761071370040L;

    private final String sliceId;

    private final int x;
    private final int y;
    private final int absoluteX;
    private final int absoluteY;

    public SliceClickEvent(CubaAmchartsScene scene, String sliceId, int x, int y, int absoluteX, int absoluteY) {
        super(scene);
        this.sliceId = sliceId;
        this.x = x;
        this.y = y;
        this.absoluteX = absoluteX;
        this.absoluteY = absoluteY;
    }

    public String getSliceId() {
        return sliceId;
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