/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.directions;

import com.haulmont.charts.gui.map.model.GeoPoint;

/**
 * @author korotkov
 * @version $Id$
 */
public interface DirectionsWaypoint {
    boolean isStopOver();

    void setStopOver(boolean stopOver);

    GeoPoint getLocation();

    void setLocation(GeoPoint location);
}
