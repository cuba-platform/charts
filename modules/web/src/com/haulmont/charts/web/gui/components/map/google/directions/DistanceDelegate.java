/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.directions.Distance;

public class DistanceDelegate implements Distance {

    private com.vaadin.tapio.googlemaps.client.services.Distance distance;

    public static DistanceDelegate fromDistance(com.vaadin.tapio.googlemaps.client.services.Distance distance) {
        return  distance != null ? new DistanceDelegate(distance) : null;
    }

    public DistanceDelegate(com.vaadin.tapio.googlemaps.client.services.Distance distance) {
        Preconditions.checkNotNullArgument(distance);
        this.distance = distance;
    }

    public com.vaadin.tapio.googlemaps.client.services.Distance getDistance() {
        return distance;
    }

    public void setDistance(com.vaadin.tapio.googlemaps.client.services.Distance distance) {
        this.distance = distance;
    }

    @Override
    public String getText() {
        return distance.getText();
    }

    @Override
    public void setText(String text) {
        distance.setText(text);
    }

    @Override
    public int getValue() {
        return distance.getValue();
    }

    @Override
    public void setValue(int value) {
        distance.setValue(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DistanceDelegate that = (DistanceDelegate) o;

        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return distance != null ? distance.hashCode() : 0;
    }
}