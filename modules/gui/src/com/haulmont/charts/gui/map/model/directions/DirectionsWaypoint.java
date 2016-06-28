/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.directions;

import com.haulmont.charts.gui.map.model.GeoPoint;

public interface DirectionsWaypoint {
    boolean isStopOver();

    void setStopOver(boolean stopOver);

    GeoPoint getLocation();

    void setLocation(GeoPoint location);
}