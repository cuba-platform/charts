/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model;

/**
 * @author korotkov
 * @version $Id$
 */
public interface WeightedLocation {
    GeoPoint getLocation();
    void setLocation(GeoPoint geoPoint);

    Double getWeight();
    void setWeight(Double weight);
}
