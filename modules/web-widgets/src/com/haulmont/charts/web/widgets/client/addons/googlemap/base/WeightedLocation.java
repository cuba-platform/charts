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

package com.haulmont.charts.web.widgets.client.addons.googlemap.base;

import java.io.Serializable;

public class WeightedLocation implements Serializable {

    private static final long serialVersionUID = -5728613634940583095L;

    private LatLon location;
    private double weight;

    public WeightedLocation() {
    }

    public WeightedLocation(LatLon location, double weight) {
        this.location = location;
        this.weight = weight;
    }

    public LatLon getLocation() {
        return location;
    }

    public void setLocation(LatLon location) {
        this.location = location;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeightedLocation that = (WeightedLocation) o;

        if (Double.compare(that.weight, weight) != 0) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = location != null ? location.hashCode() : 0;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}