/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.directions.DirectionsWaypoint;
import com.haulmont.charts.web.gui.components.map.google.GeoPointDelegate;

/**
 */
public class DirectionsWaypointDelegate implements DirectionsWaypoint {

    private com.vaadin.tapio.googlemaps.client.services.DirectionsWaypoint directionsWaypoint;

    public static DirectionsWaypointDelegate fromDirectionsWaypoint(
            com.vaadin.tapio.googlemaps.client.services.DirectionsWaypoint directionsWaypoint) {
        return directionsWaypoint != null ? new DirectionsWaypointDelegate(directionsWaypoint) : null;
    }

    public DirectionsWaypointDelegate(com.vaadin.tapio.googlemaps.client.services.DirectionsWaypoint directionsWaypoint) {
        Preconditions.checkNotNullArgument(directionsWaypoint);
        this.directionsWaypoint = directionsWaypoint;
    }

    public com.vaadin.tapio.googlemaps.client.services.DirectionsWaypoint getDirectionsWaypoint() {
        return directionsWaypoint;
    }

    public void setDirectionsWaypoint(com.vaadin.tapio.googlemaps.client.services.DirectionsWaypoint directionsWaypoint) {
        this.directionsWaypoint = directionsWaypoint;
    }

    @Override
    public boolean isStopOver() {
        return directionsWaypoint.isStopOver();
    }

    @Override
    public void setStopOver(boolean stopOver) {
        directionsWaypoint.setStopOver(stopOver);
    }

    @Override
    public GeoPoint getLocation() {
        return GeoPointDelegate.fromLatLon(directionsWaypoint.getLocation());
    }

    @Override
    public void setLocation(GeoPoint location) {
        directionsWaypoint.setLocation(location != null ? ((GeoPointDelegate)location).getLatLon() : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectionsWaypointDelegate that = (DirectionsWaypointDelegate) o;

        if (directionsWaypoint != null ? !directionsWaypoint.equals(that.directionsWaypoint) : that.directionsWaypoint != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return directionsWaypoint != null ? directionsWaypoint.hashCode() : 0;
    }
}
