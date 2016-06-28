/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.directions.DirectionsStep;
import com.haulmont.charts.gui.map.model.directions.Distance;
import com.haulmont.charts.gui.map.model.directions.Duration;
import com.haulmont.charts.gui.map.model.directions.TravelMode;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;
import com.haulmont.charts.web.gui.components.map.google.GeoPointDelegate;

import java.util.List;

public class DirectionsStepDelegate implements DirectionsStep {

    private com.vaadin.tapio.googlemaps.client.services.DirectionsStep directionsStep;

    public static DirectionsStepDelegate fromDirectionsStep(
            com.vaadin.tapio.googlemaps.client.services.DirectionsStep step) {
        return step != null ? new DirectionsStepDelegate(step) : null;
    }

    public DirectionsStepDelegate(com.vaadin.tapio.googlemaps.client.services.DirectionsStep directionsStep) {
        Preconditions.checkNotNullArgument(directionsStep);
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
        return DistanceDelegate.fromDistance(directionsStep.getDistance());
    }

    @Override
    public void setDistance(Distance distance) {
        directionsStep.setDistance(distance != null ? ((DistanceDelegate)distance).getDistance() : null);
    }

    @Override
    public Duration getDuration() {
        return DurationDelegate.fromDuration(directionsStep.getDuration());
    }

    @Override
    public void setDuration(Duration duration) {
        directionsStep.setDuration(duration != null ? ((DurationDelegate)duration).getDuration() : null);
    }

    @Override
    public GeoPoint getEndLocation() {
        return GeoPointDelegate.fromLatLon(directionsStep.getEndLocation());
    }

    @Override
    public void setEndLocation(GeoPoint endLocation) {
        directionsStep.setEndLocation(endLocation != null ? ((GeoPointDelegate)endLocation).getLatLon() : null);
    }

    @Override
    public GeoPoint getStartLocation() {
        return GeoPointDelegate.fromLatLon(directionsStep.getStartLocation());
    }

    @Override
    public void setStartLocation(GeoPoint startLocation) {
        directionsStep.setStartLocation(startLocation != null ? ((GeoPointDelegate)startLocation).getLatLon() : null);
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
        return DelegateHelper.toGeoPoints(directionsStep.getPath());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectionsStepDelegate that = (DirectionsStepDelegate) o;

        if (directionsStep != null ? !directionsStep.equals(that.directionsStep) : that.directionsStep != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return directionsStep != null ? directionsStep.hashCode() : 0;
    }
}