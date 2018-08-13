/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.services;

import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;

import java.io.Serializable;
import java.util.List;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public class DirectionsRequest implements Serializable {
    private static final long serialVersionUID = -4351120323324218168L;

    private static long idCounter = 0;

    private long id;
    private List<DirectionsWaypoint> waypoints;
    private boolean avoidHighways;
    private boolean avoidTolls;
    private boolean optimizeWaypoints;
    private boolean provideRouteAlternatives;
    private LatLon origin;
    private LatLon destination;
    private String region;
    private TravelMode travelMode;
    private UnitSystem unitSystem;

    public DirectionsRequest() {
        id = idCounter;
        idCounter++;
    }

    public DirectionsRequest(LatLon origin, LatLon destination, TravelMode travelMode) {
        this();
        this.origin = origin;
        this.destination = destination;
        this.travelMode = travelMode;
    }

    public List<DirectionsWaypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<DirectionsWaypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public boolean isAvoidHighways() {
        return avoidHighways;
    }

    public void setAvoidHighways(boolean avoidHighways) {
        this.avoidHighways = avoidHighways;
    }

    public boolean isAvoidTolls() {
        return avoidTolls;
    }

    public void setAvoidTolls(boolean avoidTolls) {
        this.avoidTolls = avoidTolls;
    }

    public boolean isOptimizeWaypoints() {
        return optimizeWaypoints;
    }

    public void setOptimizeWaypoints(boolean optimizeWaypoints) {
        this.optimizeWaypoints = optimizeWaypoints;
    }

    public boolean isProvideRouteAlternatives() {
        return provideRouteAlternatives;
    }

    public void setProvideRouteAlternatives(boolean provideRouteAlternatives) {
        this.provideRouteAlternatives = provideRouteAlternatives;
    }

    public LatLon getOrigin() {
        return origin;
    }

    public void setOrigin(LatLon origin) {
        this.origin = origin;
    }

    public LatLon getDestination() {
        return destination;
    }

    public void setDestination(LatLon destination) {
        this.destination = destination;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public TravelMode getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(TravelMode travelMode) {
        this.travelMode = travelMode;
    }

    public UnitSystem getUnitSystem() {
        return unitSystem;
    }

    public void setUnitSystem(UnitSystem unitSystem) {
        this.unitSystem = unitSystem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectionsRequest that = (DirectionsRequest) o;

        if (id != that.id) return false;
        if (avoidHighways != that.avoidHighways) return false;
        if (avoidTolls != that.avoidTolls) return false;
        if (optimizeWaypoints != that.optimizeWaypoints) return false;
        if (provideRouteAlternatives != that.provideRouteAlternatives) return false;
        if (waypoints != null ? !waypoints.equals(that.waypoints) : that.waypoints != null) return false;
        if (origin != null ? !origin.equals(that.origin) : that.origin != null) return false;
        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (travelMode != that.travelMode) return false;
        return unitSystem == that.unitSystem;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (waypoints != null ? waypoints.hashCode() : 0);
        result = 31 * result + (avoidHighways ? 1 : 0);
        result = 31 * result + (avoidTolls ? 1 : 0);
        result = 31 * result + (optimizeWaypoints ? 1 : 0);
        result = 31 * result + (provideRouteAlternatives ? 1 : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (travelMode != null ? travelMode.hashCode() : 0);
        result = 31 * result + (unitSystem != null ? unitSystem.hashCode() : 0);
        return result;
    }
}