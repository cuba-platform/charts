/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model;

public interface Bounds {
    GeoPoint getSw();

    void setSw(GeoPoint sw);

    GeoPoint getNe();

    void setNe(GeoPoint ne);
}