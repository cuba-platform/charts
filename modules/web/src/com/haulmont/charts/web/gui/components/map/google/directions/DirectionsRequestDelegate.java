/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.directions.DirectionsRequest;
import com.haulmont.charts.gui.map.model.directions.DirectionsWaypoint;
import com.haulmont.charts.gui.map.model.directions.TravelMode;
import com.haulmont.charts.gui.map.model.directions.UnitSystem;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;
import com.haulmont.charts.web.gui.components.map.google.GeoPointDelegate;

import java.util.List;

public class DirectionsRequestDelegate implements DirectionsRequest {

    private com.vaadin.tapio.googlemaps.client.services.DirectionsRequest request;

    public DirectionsRequestDelegate(com.vaadin.tapio.googlemaps.client.services.DirectionsRequest request) {
        Preconditions.checkNotNullArgument(request);
        this.request = request;
    }

    public com.vaadin.tapio.googlemaps.client.services.DirectionsRequest getRequest() {
        return request;
    }

    public void setRequest(com.vaadin.tapio.googlemaps.client.services.DirectionsRequest request) {
        this.request = request;
    }

    @Override
    public List<DirectionsWaypoint> getWaypoints() {
        return DelegateHelper.toCubaDirectionsWaypoints(request.getWaypoints());
    }

    @Override
    public void setWaypoints(List<DirectionsWaypoint> waypoints) {
        request.setWaypoints(DelegateHelper.toGoogleDirectionsWaypoints(waypoints));
    }

    @Override
    public boolean isAvoidHighways() {
        return request.isAvoidHighways();
    }

    @Override
    public void setAvoidHighways(boolean avoidHighways) {
        request.setAvoidHighways(avoidHighways);
    }

    @Override
    public boolean isAvoidTolls() {
        return request.isAvoidTolls();
    }

    @Override
    public void setAvoidTolls(boolean avoidTolls) {
        request.setAvoidTolls(avoidTolls);
    }

    @Override
    public boolean isOptimizeWaypoints() {
        return request.isOptimizeWaypoints();
    }

    @Override
    public void setOptimizeWaypoints(boolean optimizeWaypoints) {
        request.setOptimizeWaypoints(optimizeWaypoints);
    }

    @Override
    public boolean isProvideRouteAlternatives() {
        return request.isProvideRouteAlternatives();
    }

    @Override
    public void setProvideRouteAlternatives(boolean provideRouteAlternatives) {
        request.setProvideRouteAlternatives(provideRouteAlternatives);
    }

    @Override
    public GeoPoint getOrigin() {
        return GeoPointDelegate.fromLatLon(request.getOrigin());
    }

    @Override
    public void setOrigin(GeoPoint origin) {
        request.setOrigin(((GeoPointDelegate)origin).getLatLon());
    }

    @Override
    public GeoPoint getDestination() {
        return GeoPointDelegate.fromLatLon(request.getDestination());
    }

    @Override
    public void setDestination(GeoPoint destination) {
        request.setDestination(((GeoPointDelegate)destination).getLatLon());
    }

    @Override
    public String getRegion() {
        return request.getRegion();
    }

    @Override
    public void setRegion(String region) {
        request.setRegion(region);
    }

    @Override
    public TravelMode getTravelMode() {
        return request.getTravelMode() != null ? TravelMode.fromValue(request.getTravelMode().value()) : null;
    }

    @Override
    public void setTravelMode(TravelMode travelMode) {
        request.setTravelMode(travelMode != null
                ? com.vaadin.tapio.googlemaps.client.services.TravelMode.fromValue(travelMode.value())
                : null);
    }

    @Override
    public UnitSystem getUnitSystem() {
        return request.getUnitSystem() != null ? UnitSystem.fromValue(request.getUnitSystem().value()) : null;
    }

    @Override
    public void setUnitSystem(UnitSystem unitSystem) {
        request.setUnitSystem(unitSystem != null
                ? com.vaadin.tapio.googlemaps.client.services.UnitSystem.fromValue(unitSystem.value())
                : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectionsRequestDelegate that = (DirectionsRequestDelegate) o;

        if (request != null ? !request.equals(that.request) : that.request != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return request != null ? request.hashCode() : 0;
    }
}