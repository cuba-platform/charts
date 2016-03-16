/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.directions;

import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.List;

/**
 */
public interface DirectionsStep {
    Distance getDistance();

    void setDistance(Distance distance);

    Duration getDuration();

    void setDuration(Duration duration);

    GeoPoint getEndLocation();

    void setEndLocation(GeoPoint endLocation);

    GeoPoint getStartLocation();

    void setStartLocation(GeoPoint startLocation);

    String getInstructions();

    void setInstructions(String instructions);

    List<GeoPoint> getPath();

    void setPath(List<GeoPoint> path);

    TravelMode getTravelMode();

    void setTravelMode(TravelMode travelMode);
}
