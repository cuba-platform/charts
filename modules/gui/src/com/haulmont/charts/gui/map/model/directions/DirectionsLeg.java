/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.directions;

import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.List;

/**
 */
public interface DirectionsLeg {
    Distance getDistance();

    void setDistance(Distance distance);

    Duration getDuration();

    void setDuration(Duration duration);

    String getStartAddress();

    void setStartAddress(String startAddress);

    String getEndAddress();

    void setEndAddress(String endAddress);

    GeoPoint getStartLocation();

    void setStartLocation(GeoPoint startLocation);

    List<DirectionsStep> getSteps();

    void setSteps(List<DirectionsStep> steps);

    List<GeoPoint> getViaWaypoints();

    void setViaWaypoints(List<GeoPoint> viaWaypoints);

    GeoPoint getEndLocation();

    void setEndLocation(GeoPoint endLocation);
}
