/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model;

/**
 * Represents geographical point, used for other map components and settings
 *
 */
public interface GeoPoint {

    Double getLatitude();
    void setLatitude(Double latitude);

    Double getLongitude();
    void setLongitude(Double longitude);
}
