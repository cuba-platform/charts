/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.directions.DirectionsLeg;
import com.haulmont.charts.gui.map.model.directions.DirectionsStep;
import com.haulmont.charts.gui.map.model.directions.Distance;
import com.haulmont.charts.gui.map.model.directions.Duration;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;
import com.haulmont.charts.web.gui.components.map.google.GeoPointDelegate;

import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public class DirectionsLegDelegate implements DirectionsLeg {

    private com.vaadin.tapio.googlemaps.client.services.DirectionsLeg directionsLeg;

    public DirectionsLegDelegate(com.vaadin.tapio.googlemaps.client.services.DirectionsLeg directionsLeg) {
        this.directionsLeg = directionsLeg;
    }

    public com.vaadin.tapio.googlemaps.client.services.DirectionsLeg getDirectionsLeg() {
        return directionsLeg;
    }

    public void setDirectionsLeg(com.vaadin.tapio.googlemaps.client.services.DirectionsLeg directionsLeg) {
        this.directionsLeg = directionsLeg;
    }

    @Override
    public Distance getDistance() {
        return new DistanceDelegate(directionsLeg.getDistance());
    }

    @Override
    public void setDistance(Distance distance) {
        directionsLeg.setDistance(((DistanceDelegate)distance).getDistance());
    }

    @Override
    public Duration getDuration() {
        return new DurationDelegate(directionsLeg.getDuration());
    }

    @Override
    public void setDuration(Duration duration) {
        directionsLeg.setDuration(((DurationDelegate) duration).getDuration());
    }

    @Override
    public String getStartAddress() {
        return directionsLeg.getStartAddress();
    }

    @Override
    public void setStartAddress(String startAddress) {
        directionsLeg.setStartAddress(startAddress);
    }

    @Override
    public String getEndAddress() {
        return directionsLeg.getEndAddress();
    }

    @Override
    public void setEndAddress(String endAddress) {
        directionsLeg.setEndAddress(endAddress);
    }

    @Override
    public GeoPoint getStartLocation() {
        return new GeoPointDelegate(directionsLeg.getStartLocation());
    }

    @Override
    public void setStartLocation(GeoPoint startLocation) {
        directionsLeg.setStartLocation(((GeoPointDelegate)startLocation).getLatLon());
    }

    @Override
    public List<DirectionsStep> getSteps() {
        return DelegateHelper.toCubaDirectionsSteps(directionsLeg.getSteps());
    }

    @Override
    public void setSteps(List<DirectionsStep> steps) {
        directionsLeg.setSteps(DelegateHelper.toGoogleDirectionsSteps(steps));
    }

    @Override
    public List<GeoPoint> getViaWaypoints() {
        return DelegateHelper.toGeoPoint(directionsLeg.getViaWaypoints());
    }

    @Override
    public void setViaWaypoints(List<GeoPoint> viaWaypoints) {
        directionsLeg.setViaWaypoints(DelegateHelper.toLatLon(viaWaypoints));
    }

    @Override
    public GeoPoint getEndLocation() {
        return new GeoPointDelegate(directionsLeg.getEndLocation());
    }

    @Override
    public void setEndLocation(GeoPoint endLocation) {
        directionsLeg.setEndLocation(((GeoPointDelegate)endLocation).getLatLon());
    }
}
