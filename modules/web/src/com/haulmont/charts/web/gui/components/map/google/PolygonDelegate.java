/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Polygon;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapPolygon;

import java.util.List;

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