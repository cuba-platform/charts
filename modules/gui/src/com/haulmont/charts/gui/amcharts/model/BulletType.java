/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public enum BulletType implements ChartEnum {
    NONE("none"),
    ROUND("round"),
    SQUARE("square"),
    TRIANGLE_UP("triangleUp"),
    TRIANGLE_DOWN("triangleDown"),
    TRIANGLE_LEFT("triangleLeft"),
    TRIANGLE_RIGHT("triangleRight"),
    BUBBLE("bubble"),
    DIAMOND("diamond"),
    X_ERROR("xError"),
    Y_ERROR("yError"),
    CUSTOM("custom");

    private String id;

    private BulletType(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}