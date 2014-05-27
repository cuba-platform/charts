/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.vaadin.tapio.googlemaps.client.LatLon;

/**
 * @author korotkov
 * @version $Id$
 */
public class GeoPointDelegate implements GeoPoint {

    protected LatLon latLon;

    public GeoPointDelegate() {
        this.latLon = new LatLon();
    }

    public GeoPointDelegate(LatLon latLon) {
        this.latLon = latLon;
    }

    public GeoPointDelegate(Double latitude, Double longitude) {
        this.latLon = new LatLon(latitude, longitude);
    }

    public LatLon getLatLon() {
        return latLon;
    }

    public void setLatLon(LatLon latLon) {
        this.latLon = latLon;
    }
    @Override
    public void setLongitude(Double longitude) {
        latLon.setLon(longitude);
    }

    @Override
    public Double getLongitude() {
        return latLon.getLon();
    }

    @Override
    public void setLatitude(Double latitude) {
        latLon.setLat(latitude);
    }

    @Override
    public Double getLatitude() {
        return latLon.getLat();
    }
}
