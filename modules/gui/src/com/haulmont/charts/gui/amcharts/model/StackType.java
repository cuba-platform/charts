/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public enum StackType implements ChartEnum {

    NONE("none"),
    REGULAR("regular"),
    FILL("100%"),
    BOX_3D("3D");

    private String id;

    private StackType(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}