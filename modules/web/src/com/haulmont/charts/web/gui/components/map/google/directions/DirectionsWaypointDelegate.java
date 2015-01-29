/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.directions.DirectionsWaypoint;
import com.haulmont.charts.web.gui.components.map.google.GeoPointDelegate;
import com.vaadin.tapio.googlemaps.client.base.LatLon;

/**
 * @author korotkov
 * @version $Id$
 */
public class DirectionsWaypointDelegate implements DirectionsWaypoint {

    private com.vaadin.tapio.googlemaps.client.services.DirectionsWaypoint directionsWaypoint;

    public DirectionsWaypointDelegate(com.vaadin.tapio.googlemaps.client.services.DirectionsWaypoint directionsWaypoint) {
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
        directionsWaypoint.setLocation(new LatLon(location.getLatitude(), location.getLongitude()));
    }
}
