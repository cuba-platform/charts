/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.vaadin.tapio.googlemaps.client.base.WeightedLocation;

import java.util.Objects;

public class WeightedLocationDelegate implements com.haulmont.charts.gui.map.model.WeightedLocation {
    private WeightedLocation location;

    public WeightedLocationDelegate(WeightedLocation location) {
        Preconditions.checkNotNullArgument(location);
        this.location = location;
    }

    @Override
    public GeoPoint getLocation() {
        return GeoPointDelegate.fromLatLon(location.getLocation());
    }

    @Override
    public void setLocation(GeoPoint location) {
        this.location.setLocation(location != null ? ((GeoPointDelegate)location).getLatLon() : null);
    }

    @Override
    public Double getWeight() {
        return location.getWeight();
    }

    @Override
    public void setWeight(Double weight) {
        location.setWeight(weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeightedLocationDelegate that = (WeightedLocationDelegate) o;

        return Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }
}