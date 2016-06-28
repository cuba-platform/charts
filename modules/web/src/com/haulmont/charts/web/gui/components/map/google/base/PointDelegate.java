/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.base;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.base.Point;

public class PointDelegate implements Point {
    private com.vaadin.tapio.googlemaps.client.base.Point point;

    public static PointDelegate fromPoint(com.vaadin.tapio.googlemaps.client.base.Point point) {
        return point != null ? new PointDelegate(point) : null;
    }

    public PointDelegate(com.vaadin.tapio.googlemaps.client.base.Point point) {
        Preconditions.checkNotNullArgument(point);
        this.point = point;
    }

    public com.vaadin.tapio.googlemaps.client.base.Point getPoint() {
        return point;
    }

    public void setPoint(com.vaadin.tapio.googlemaps.client.base.Point point) {
        this.point = point;
    }

    @Override
    public double getX() {
        return point.getX();
    }

    @Override
    public void setX(double x) {
        point.setX(x);
    }

    @Override
    public double getY() {
        return point.getY();
    }

    @Override
    public void setY(double y) {
        point.setY(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointDelegate that = (PointDelegate) o;

        if (point != null ? !point.equals(that.point) : that.point != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return point != null ? point.hashCode() : 0;
    }
}