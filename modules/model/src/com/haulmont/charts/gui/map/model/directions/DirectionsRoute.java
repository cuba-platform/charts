/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.directions;

import com.haulmont.charts.gui.map.model.Bounds;
import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.List;

public interface DirectionsRoute {
    Bounds getBounds();
    void setBounds(Bounds bounds);

    String getCopyrights();
    void setCopyrights(String copyrights);

    List<DirectionsLeg> getLegs();
    void setLegs(List<DirectionsLeg> legs);

    List<GeoPoint> getOverviewPath();
    void setOverviewPath(List<GeoPoint> overviewPath);

    String[] getWarnings();
    void setWarnings(String[] warnings);

    int[] getWaypointOrder();
    void setWaypointOrder(int[] waypointOrder);
}