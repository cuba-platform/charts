/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author gorelov
 * @version $Id$
 */
public enum ValueAxesPosition implements ChartEnum {
    LEFT("left"),
    RIGHT("right");

    private String id;

    ValueAxesPosition(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
