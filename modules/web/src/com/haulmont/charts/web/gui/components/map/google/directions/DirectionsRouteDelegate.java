/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.charts.gui.map.model.Bounds;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.directions.DirectionsLeg;
import com.haulmont.charts.gui.map.model.directions.DirectionsRoute;
import com.haulmont.charts.web.gui.components.map.google.BoundsDelegate;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;

import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public class DirectionsRouteDelegate implements DirectionsRoute {

    private com.vaadin.tapio.googlemaps.client.services.DirectionsRoute directionsRoute;

    public DirectionsRouteDelegate(com.vaadin.tapio.googlemaps.client.services.DirectionsRoute directionsRoute) {
        this.directionsRoute = directionsRoute;
    }

    public com.vaadin.tapio.googlemaps.client.services.DirectionsRoute getDirectionsRoute() {
        return directionsRoute;
    }

    public void setDirectionsRoute(com.vaadin.tapio.googlemaps.client.services.DirectionsRoute directionsRoute) {
        this.directionsRoute = directionsRoute;
    }

    @Override
    public Bounds getBounds() {
        return new BoundsDelegate(directionsRoute.getBounds());
    }

    @Override
    public void setBounds(Bounds bounds) {
        directionsRoute.setBounds(((BoundsDelegate)bounds).getBounds());
    }

    @Override
    public String getCopyrights() {
        return directionsRoute.getCopyrights();
    }

    @Override
    public void setCopyrights(String copyrights) {
        directionsRoute.setCopyrights(copyrights);
    }

    @Override
    public List<DirectionsLeg> getLegs() {
        return DelegateHelper.toCubaDirectionsLegs(directionsRoute.getLegs());
    }

    @Override
    public void setLegs(List<DirectionsLeg> legs) {
        directionsRoute.setLegs(DelegateHelper.toGoogleDirectionsLegs(legs));
    }

    @Override
    public List<GeoPoint> getOverviewPath() {
        return DelegateHelper.toGeoPoint(directionsRoute.getOverviewPath());
    }

    @Override
    public void setOverviewPath(List<GeoPoint> overviewPath) {
        directionsRoute.setOverviewPath(DelegateHelper.toLatLon(overviewPath));
    }

    @Override
    public String[] getWarnings() {
        return directionsRoute.getWarnings();
    }

    @Override
    public void setWarnings(String[] warnings) {
        directionsRoute.setWarnings(warnings);
    }

    @Override
    public int[] getWaypointOrder() {
        return directionsRoute.getWaypointOrder();
    }

    @Override
    public void setWaypointOrder(int[] waypointOrder) {
        directionsRoute.setWaypointOrder(waypointOrder);
    }
}
