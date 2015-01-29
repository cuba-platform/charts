/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.charts.gui.map.model.Bounds;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.vaadin.tapio.googlemaps.client.base.LatLonBounds;

/**
 * @author korotkov
 * @version $Id$
 */
public class BoundsDelegate implements Bounds {
    private LatLonBounds bounds;

    public BoundsDelegate(LatLonBounds bounds) {
        this.bounds = bounds;
    }

    public LatLonBounds getBounds() {
        return bounds;
    }

    public void setBounds(LatLonBounds bounds) {
        this.bounds = bounds;
    }

    @Override
    public GeoPoint getSw() {
        return new GeoPointDelegate(bounds.getSw());
    }

    @Override
    public void setSw(GeoPoint sw) {
        bounds.setSw(((GeoPointDelegate)sw).getLatLon());
    }

    @Override
    public GeoPoint getNe() {
        return new GeoPointDelegate(bounds.getNe());
    }

    @Override
    public void setNe(GeoPoint ne) {
        bounds.setNe(((GeoPointDelegate)ne).getLatLon());
    }
}
