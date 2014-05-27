/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Polyline;
import com.vaadin.tapio.googlemaps.client.GoogleMapPolyline;

import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public class PolylineDelegate implements Polyline {

    protected GoogleMapPolyline polyline;

    public PolylineDelegate() {
        this.polyline = new GoogleMapPolyline();
    }

    public PolylineDelegate(GoogleMapPolyline polyline) {
        this.polyline = polyline;
    }

    public GoogleMapPolyline getPolyline() {
        return polyline;
    }

    public void setPolyline(GoogleMapPolyline polyline) {
        this.polyline = polyline;
    }

    @Override
    public long getId() {
        return polyline.getId();
    }

    @Override
    public void setId(long id) {
        polyline.setId(id);
    }

    @Override
    public List<GeoPoint> getCoordinates() {
        return DelegateHelper.toGeoPoint(polyline.getCoordinates());
    }

    @Override
    public void setCoordinates(List<GeoPoint> coordinates) {
        polyline.setCoordinates(DelegateHelper.toLatLon(coordinates));
    }

    @Override
    public String getStrokeColor() {
        return polyline.getStrokeColor();
    }

    @Override
    public void setStrokeColor(String strokeColor) {
        polyline.setStrokeColor(strokeColor);
    }

    @Override
    public double getStrokeOpacity() {
        return 0;
    }

    @Override
    public void setStrokeOpacity(double strokeOpacity) {
        polyline.setStrokeOpacity(strokeOpacity);
    }

    @Override
    public int getStrokeWeight() {
        return polyline.getStrokeWeight();
    }

    @Override
    public void setStrokeWeight(int strokeWeight) {
        polyline.setStrokeWeight(strokeWeight);
    }

    @Override
    public int getzIndex() {
        return polyline.getzIndex();
    }

    @Override
    public void setzIndex(int zIndex) {
        polyline.setzIndex(zIndex);
    }

    @Override
    public boolean isGeodesic() {
        return polyline.isGeodesic();
    }

    @Override
    public void setGeodesic(boolean geodesic) {
        polyline.setGeodesic(geodesic);
    }
}
