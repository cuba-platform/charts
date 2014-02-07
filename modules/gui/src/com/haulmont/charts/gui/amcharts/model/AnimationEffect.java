/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public enum AnimationEffect implements ChartEnum {
    EASE_OUT_SINE("easeOutSine"),
    EASE_IN_SINE("easeInSine"),
    ELASTIC("elastic"),
    BOUNCE("bounce");

    private String id;

    private AnimationEffect(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}