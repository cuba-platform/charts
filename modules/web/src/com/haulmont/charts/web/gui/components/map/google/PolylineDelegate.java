/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Polyline;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapPolyline;

import java.util.List;

public class PolylineDelegate implements Polyline {

    protected GoogleMapPolyline polyline;

    public PolylineDelegate() {
        this.polyline = new GoogleMapPolyline();
    }

    public PolylineDelegate(GoogleMapPolyline polyline) {
        Preconditions.checkNotNullArgument(polyline);
        this.polyline = polyline;
    }

    public GoogleMapPolyline getPolyline() {
        return polyline;
    }

    public void setPolyline(GoogleMapPolyline polyline) {
        this.polyline = polyline;
    }

    @Override
    public List<GeoPoint> getCoordinates() {
        return DelegateHelper.toGeoPoints(polyline.getCoordinates());
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

    @Override
    public int hashCode() {
        return polyline.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PolylineDelegate other = (PolylineDelegate) obj;
        return polyline.equals(other.getPolyline());
    }
}