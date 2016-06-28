/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.Bounds;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.vaadin.tapio.googlemaps.client.base.LatLonBounds;

public class BoundsDelegate implements Bounds {
    private LatLonBounds bounds;

    public static BoundsDelegate fromLatLonBounds(LatLonBounds bounds) {
        return bounds != null ? new BoundsDelegate(bounds) : null;
    }

    public BoundsDelegate(LatLonBounds bounds) {
        Preconditions.checkNotNullArgument(bounds);
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
        return GeoPointDelegate.fromLatLon(bounds.getSw());
    }

    @Override
    public void setSw(GeoPoint sw) {
        bounds.setSw(sw != null ? ((GeoPointDelegate)sw).getLatLon() : null);
    }

    @Override
    public GeoPoint getNe() {
        return GeoPointDelegate.fromLatLon(bounds.getNe());
    }

    @Override
    public void setNe(GeoPoint ne) {
        bounds.setNe(ne != null ? ((GeoPointDelegate)ne).getLatLon() : null);
    }
}