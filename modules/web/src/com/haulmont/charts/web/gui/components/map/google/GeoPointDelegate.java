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
import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;

public class GeoPointDelegate implements GeoPoint {

    protected LatLon latLon;

    public static GeoPoint fromLatLon(LatLon latLon) {
        return latLon != null ? new GeoPointDelegate(latLon) : null;
    }

    public GeoPointDelegate() {
        this.latLon = new LatLon();
    }

    public GeoPointDelegate(LatLon latLon) {
        Preconditions.checkNotNullArgument(latLon);
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

    @Override
    public int hashCode() {
        return latLon.hashCode();
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
        GeoPointDelegate other = (GeoPointDelegate) obj;
        return latLon.equals(other.getLatLon());
    }
}