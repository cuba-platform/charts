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

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.directions.Distance;

public class DistanceDelegate implements Distance {

    private com.haulmont.charts.web.widgets.client.addons.googlemap.services.Distance distance;

    public static DistanceDelegate fromDistance(com.haulmont.charts.web.widgets.client.addons.googlemap.services.Distance distance) {
        return  distance != null ? new DistanceDelegate(distance) : null;
    }

    public DistanceDelegate(com.haulmont.charts.web.widgets.client.addons.googlemap.services.Distance distance) {
        Preconditions.checkNotNullArgument(distance);
        this.distance = distance;
    }

    public com.haulmont.charts.web.widgets.client.addons.googlemap.services.Distance getDistance() {
        return distance;
    }

    public void setDistance(com.haulmont.charts.web.widgets.client.addons.googlemap.services.Distance distance) {
        this.distance = distance;
    }

    @Override
    public String getText() {
        return distance.getText();
    }

    @Override
    public void setText(String text) {
        distance.setText(text);
    }

    @Override
    public int getValue() {
        return distance.getValue();
    }

    @Override
    public void setValue(int value) {
        distance.setValue(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DistanceDelegate that = (DistanceDelegate) o;

        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return distance != null ? distance.hashCode() : 0;
    }
}