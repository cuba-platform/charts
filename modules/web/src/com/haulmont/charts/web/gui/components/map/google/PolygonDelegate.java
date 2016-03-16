/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Polygon;
import com.vaadin.tapio.googlemaps.client.overlays.*;

import java.util.List;

/**
 */
public class PolygonDelegate implements Polygon {

    protected GoogleMapPolygon polygon;

    public PolygonDelegate() {
        this.polygon = new GoogleMapPolygon();
    }

    public PolygonDelegate(GoogleMapPolygon polygon) {
        Preconditions.checkNotNullArgument(polygon);
        this.polygon = polygon;
    }

    public GoogleMapPolygon getPolygon() {
        return polygon;
    }

    public void setPolygon(GoogleMapPolygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public List<GeoPoint> getCoordinates() {
        return DelegateHelper.toGeoPoints(polygon.getCoordinates());
    }

    @Override
    public void setCoordinates(List<GeoPoint> coordinates) {
        polygon.setCoordinates(DelegateHelper.toLatLon(coordinates));
    }

    @Override
    public String getFillColor() {
        return polygon.getFillColor();
    }

    @Override
    public void setFillColor(String fillColor) {
        polygon.setFillColor(fillColor);
    }

    @Override
    public double getFillOpacity() {
        return polygon.getFillOpacity();
    }

    @Override
    public void setFillOpacity(double fillOpacity) {
        polygon.setFillOpacity(fillOpacity);
    }

    @Override
    public String getStrokeColor() {
        return polygon.getStrokeColor();
    }

    @Override
    public void setStrokeColor(String strokeColor) {
        polygon.setStrokeColor(strokeColor);
    }

    @Override
    public double getStrokeOpacity() {
        return polygon.getStrokeOpacity();
    }

    @Override
    public void setStrokeOpacity(double strokeOpacity) {
        polygon.setStrokeOpacity(strokeOpacity);
    }

    @Override
    public int getStrokeWeight() {
        return polygon.getStrokeWeight();
    }

    @Override
    public void setStrokeWeight(int strokeWeight) {
        polygon.setStrokeWeight(strokeWeight);
    }

    @Override
    public int getzIndex() {
        return polygon.getzIndex();
    }

    @Override
    public void setzIndex(int zIndex) {
        polygon.setzIndex(zIndex);
    }

    @Override
    public boolean isGeodesic() {
        return polygon.isGeodesic();
    }

    @Override
    public void setGeodesic(boolean geodesic) {
        polygon.setGeodesic(geodesic);
    }

    @Override
    public boolean isEditable() {
        return polygon.isEditable();
    }

    @Override
    public void setEditable(boolean editable) {
        polygon.setEditable(editable);
    }

    @Override
    public int hashCode() {
        return polygon.hashCode();
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
        PolygonDelegate other = (PolygonDelegate) obj;
        return polygon.equals(other.getPolygon());
    }
}
