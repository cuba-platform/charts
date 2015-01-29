/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.directions.DirectionsRequest;
import com.haulmont.charts.gui.map.model.directions.DirectionsWaypoint;
import com.haulmont.charts.gui.map.model.directions.TravelMode;
import com.haulmont.charts.gui.map.model.directions.UnitSystem;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;
import com.haulmont.charts.web.gui.components.map.google.GeoPointDelegate;

import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public class DirectionsRequestDelegate implements DirectionsRequest {

    private com.vaadin.tapio.googlemaps.client.services.DirectionsRequest request;

    public DirectionsRequestDelegate(com.vaadin.tapio.googlemaps.client.services.DirectionsRequest request) {
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
        return new GeoPointDelegate(request.getOrigin());
    }

    @Override
    public void setOrigin(GeoPoint origin) {
        request.setOrigin(((GeoPointDelegate)origin).getLatLon());
    }

    @Override
    public GeoPoint getDestination() {
        return new GeoPointDelegate(request.getDestination());
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
        return TravelMode.fromValue(request.getTravelMode().value());
    }

    @Override
    public void setTravelMode(TravelMode travelMode) {
        request.setTravelMode(com.vaadin.tapio.googlemaps.client.services.TravelMode.fromValue(travelMode.value()));
    }

    @Override
    public UnitSystem getUnitSystem() {
        return UnitSystem.fromValue(request.getUnitSystem().value());
    }

    @Override
    public void setUnitSystem(UnitSystem unitSystem) {
        request.setUnitSystem(com.vaadin.tapio.googlemaps.client.services.UnitSystem.fromValue(unitSystem.value()));
    }
}
