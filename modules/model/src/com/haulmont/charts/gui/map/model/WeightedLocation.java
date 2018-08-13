/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model;

/**
 * Used in heatmap layer to add coordinates with weight.
 *
 */
public interface WeightedLocation {

    /**
     * Sets location
     * @param geoPoint location
     */
    void setLocation(GeoPoint geoPoint);

    /**
     * @return location
     */
    GeoPoint getLocation();

    /**
     * Sets weight of the data point
     * @return weight
     */
    Double getWeight();

    /**
     * @param weight weight
     */
    void setWeight(Double weight);
}
