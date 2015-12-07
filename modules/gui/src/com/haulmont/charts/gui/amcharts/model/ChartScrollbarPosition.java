/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author gorelov
 * @version $Id$
 */
public enum ChartScrollbarPosition implements ChartEnum {
    TOP("top"),
    BOTTOM("bottom");

    private String id;

    ChartScrollbarPosition(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
