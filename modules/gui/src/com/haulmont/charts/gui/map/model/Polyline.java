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

    /**
     * Sets polyline vertices coordinates
     * @param coordinates coordinates
     */
    void setCoordinates(List<GeoPoint> coordinates);

    /**
     * @return coordinates
     */
    List<GeoPoint> getCoordinates();

    /**
     * Sets stroke color in any CSS3 format except extended name colors (aquamarine, chocolate etc).
     * Defaults to "#000000"
     * @param strokeColor stroke color
     */
    void setStrokeColor(String strokeColor);

    /**
     * @return stroke color
     */
    String getStrokeColor();

    /**
     * Sets stroke opacity. Defaults to 1.0
     * @param strokeOpacity stroke opacity
     */
    void setStrokeOpacity(double strokeOpacity);

    /**
     * @return stroke opacity
     */
    double getStrokeOpacity();

    /**
     * Sets stroke weight in pixels. Defaults to 1
     * @param strokeWeight stroke weight in pixels
     */
    void setStrokeWeight(int strokeWeight);

    /**
     * @return stroke weight
     */
    int getStrokeWeight();

    /**
     * Sets z-index
     * @param zIndex z-index
     */
    void setzIndex(int zIndex);

    /**
     * @return z-index
     */
    int getzIndex();

    /**
     * Sets whether polyline lines should be geodesic, which means they they curve will change depending of the line
     * closeness to north/south pole. If edges aren't geodesic then they are rendered as straight lines in screen space.
     * Defaults to false
     *
     * @param geodesic true if edges should be geodesic
     */
    void setGeodesic(boolean geodesic);

    /**
     * @return true if edges are be geodesic
     */
    boolean isGeodesic();
}
