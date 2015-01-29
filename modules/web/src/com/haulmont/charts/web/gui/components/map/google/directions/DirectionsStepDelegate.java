/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.directions.DirectionsStep;
import com.haulmont.charts.gui.map.model.directions.Distance;
import com.haulmont.charts.gui.map.model.directions.Duration;
import com.haulmont.charts.gui.map.model.directions.TravelMode;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;
import com.haulmont.charts.web.gui.components.map.google.GeoPointDelegate;

import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public class DirectionsStepDelegate implements DirectionsStep {

    private com.vaadin.tapio.googlemaps.client.services.DirectionsStep directionsStep;

    public DirectionsStepDelegate(com.vaadin.tapio.googlemaps.client.services.DirectionsStep directionsStep) {
        this.directionsStep = directionsStep;
    }

    public com.vaadin.tapio.googlemaps.client.services.DirectionsStep getDirectionsStep() {
        return directionsStep;
    }

    public void setDirectionsStep(com.vaadin.tapio.googlemaps.client.services.DirectionsStep directionsStep) {
        this.directionsStep = directionsStep;
    }

    @Override
    public Distance getDistance() {
        return new DistanceDelegate(directionsStep.getDistance());
    }

    @Override
    public void setDistance(Distance distance) {
        directionsStep = (com.vaadin.tapio.googlemaps.client.services.DirectionsStep)distance;
    }

    @Override
    public Duration getDuration() {
        return new DurationDelegate(directionsStep.getDuration());
    }

    @Override
    public void setDuration(Duration duration) {
        directionsStep.setDuration(((DurationDelegate)duration).getDuration());
    }

    @Override
    public GeoPoint getEndLocation() {
        return new GeoPointDelegate(directionsStep.getEndLocation());
    }

    @Override
    public void setEndLocation(GeoPoint endLocation) {
        directionsStep.setEndLocation(((GeoPointDelegate)endLocation).getLatLon());
    }

    @Override
    public GeoPoint getStartLocation() {
        return new GeoPointDelegate(directionsStep.getStartLocation());
    }

    @Override
    public void setStartLocation(GeoPoint startLocation) {
        directionsStep.setStartLocation(((GeoPointDelegate)startLocation).getLatLon());
    }

    @Override
    public String getInstructions() {
        return directionsStep.getInstructions();
    }

    @Override
    public void setInstructions(String instructions) {
        directionsStep.setInstructions(instructions);
    }

    @Override
    public List<GeoPoint> getPath() {
        return DelegateHelper.toGeoPoint(directionsStep.getPath());
    }

    @Override
    public void setPath(List<GeoPoint> path) {
        directionsStep.setPath(DelegateHelper.toLatLon(path));
    }

    @Override
    public TravelMode getTravelMode() {
        return TravelMode.fromValue(directionsStep.getTravelMode().value());
    }

    @Override
    public void setTravelMode(TravelMode travelMode) {
        if (travelMode == null) {
            directionsStep.setTravelMode(null);
        } else {
            directionsStep.setTravelMode(com.vaadin.tapio.googlemaps.client.services.TravelMode.fromValue(travelMode.value()));
        }
    }
}
