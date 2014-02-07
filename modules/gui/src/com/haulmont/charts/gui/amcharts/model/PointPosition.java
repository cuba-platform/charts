/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public enum PointPosition implements ChartEnum {
    START("start"),
    MIDDLE("middle"),
    END("end");

    private String id;

    private PointPosition(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}