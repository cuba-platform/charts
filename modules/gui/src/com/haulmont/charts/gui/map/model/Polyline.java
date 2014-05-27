/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model;

import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public interface Polyline {

    long getId();
    void setId(long id);

    List<GeoPoint> getCoordinates();
    void setCoordinates(List<GeoPoint> coordinates);

    String getStrokeColor();
    void setStrokeColor(String strokeColor);

    double getStrokeOpacity();
    void setStrokeOpacity(double strokeOpacity);

    int getStrokeWeight();
    void setStrokeWeight(int strokeWeight);

    int getzIndex();
    void setzIndex(int zIndex);

    boolean isGeodesic();
    void setGeodesic(boolean geodesic);
}
