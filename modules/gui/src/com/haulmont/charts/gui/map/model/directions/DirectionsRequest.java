/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.directions;

import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public interface DirectionsRequest {
    List<DirectionsWaypoint> getWaypoints();

    void setWaypoints(List<DirectionsWaypoint> waypoints);

    boolean isAvoidHighways();

    void setAvoidHighways(boolean avoidHighways);

    boolean isAvoidTolls();

    void setAvoidTolls(boolean avoidTolls);

    boolean isOptimizeWaypoints();

    void setOptimizeWaypoints(boolean optimizeWaypoints);

    boolean isProvideRouteAlternatives();

    void setProvideRouteAlternatives(boolean provideRouteAlternatives);

    GeoPoint getOrigin();

    void setOrigin(GeoPoint origin);

    GeoPoint getDestination();

    void setDestination(GeoPoint destination);

    String getRegion();

    void setRegion(String region);

    TravelMode getTravelMode();

    void setTravelMode(TravelMode travelMode);

    UnitSystem getUnitSystem();

    void setUnitSystem(UnitSystem unitSystem);
}
