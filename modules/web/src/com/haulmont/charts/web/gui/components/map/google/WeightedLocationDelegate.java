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
import com.haulmont.charts.web.widgets.client.addons.googlemap.base.WeightedLocation;

import java.util.Objects;

public class WeightedLocationDelegate implements com.haulmont.charts.gui.map.model.WeightedLocation {
    private WeightedLocation location;

    public WeightedLocationDelegate(WeightedLocation location) {
        Preconditions.checkNotNullArgument(location);
        this.location = location;
    }

    @Override
    public GeoPoint getLocation() {
        return GeoPointDelegate.fromLatLon(location.getLocation());
    }

    @Override
    public void setLocation(GeoPoint location) {
        this.location.setLocation(location != null ? ((GeoPointDelegate) location).getLatLon() : null);
    }

    @Override
    public Double getWeight() {
        return location.getWeight();
    }

    @Override
    public void setWeight(Double weight) {
        location.setWeight(weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeightedLocationDelegate that = (WeightedLocationDelegate) o;

        return Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }
}