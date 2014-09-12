/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model;

/**
 * Used in heatmap layer to add coordinates with weight.
 *
 * @author korotkov
 * @version $Id$
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
