/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

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

    BulletType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}