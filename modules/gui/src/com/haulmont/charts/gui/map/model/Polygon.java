/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model;

import java.util.List;

/**
 */
public interface Polygon {

    /**
     * Sets vertices coordinates
     * @param coordinates coordinates
     */
    void setCoordinates(List<GeoPoint> coordinates);

    /**
     * @return vertices coordinates
     */
    List<GeoPoint> getCoordinates();

    /**
     * Sets polygon fill color. Defaults to "#ffffff"
     * @param fillColor fill color in any CSS3 format except extended name colors (aquamarine, chocolate etc)
     */
    void setFillColor(String fillColor);

    /**
     * @return polygon fill color
     */
    String getFillColor();

    /**
     * Sets fill opacity. Defaults to 1.0
     * @param fillOpacity fill opacity
     */
    void setFillOpacity(double fillOpacity);

    /**
     * @return fill opacity
     */
    double getFillOpacity();

    /**
     * Sets stroke color. Defaults to "#000000"
     * @param strokeColor stroke color in any CSS3 format except extended name colors (aquamarine, chocolate etc)
     */
    void setStrokeColor(String strokeColor);

    /**
     * @return stroke color
     */
    String getStrokeColor();

    /**
     * Sets stroke opacity. Defaults to 1.0
     * @param strokeOpacity
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
     * @return stroke weights in pixels
     */
    int getStrokeWeight();

    /**
     * Sets polygon z-index
     * @param zIndex z-index
     */
    void setzIndex(int zIndex);

    /**
     * @return z-index
     */
    int getzIndex();

    /**
     * Sets whether polygon edges should be geodesic, which means they they curve will change depending of the polygon
     * closeness to north/south pole. If edges aren't geodesic then they are rendered as straight lines in screen space.
     * Defaults to false
     *
     * @param geodesic true if edges should be geodesic
     */
    void setGeodesic(boolean geodesic);

    /**
     * @return true if edges are geodesic
     */
    boolean isGeodesic();

    /**
     * Sets whether polygon should be editable, which allows user to move/add/delete polygon vertices. Defaults to false
     * @param editable true if polygon should be editable
     */
    void setEditable(boolean editable);

    /**
     * @return true if polygon is editable
     */
    boolean isEditable();
}
