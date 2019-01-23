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
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.directions.DirectionsWaypoint;
import com.haulmont.charts.web.gui.components.map.google.GeoPointDelegate;

public class DirectionsWaypointDelegate implements DirectionsWaypoint {

    private com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsWaypoint directionsWaypoint;

    public static DirectionsWaypointDelegate fromDirectionsWaypoint(
            com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsWaypoint directionsWaypoint) {
        return directionsWaypoint != null ? new DirectionsWaypointDelegate(directionsWaypoint) : null;
    }

    public DirectionsWaypointDelegate(com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsWaypoint directionsWaypoint) {
        Preconditions.checkNotNullArgument(directionsWaypoint);
        this.directionsWaypoint = directionsWaypoint;
    }

    public com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsWaypoint getDirectionsWaypoint() {
        return directionsWaypoint;
    }

    public void setDirectionsWaypoint(com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsWaypoint directionsWaypoint) {
        this.directionsWaypoint = directionsWaypoint;
    }

    @Override
    public boolean isStopOver() {
        return directionsWaypoint.isStopOver();
    }

    @Override
    public void setStopOver(boolean stopOver) {
        directionsWaypoint.setStopOver(stopOver);
    }

    @Override
    public GeoPoint getLocation() {
        return GeoPointDelegate.fromLatLon(directionsWaypoint.getLocation());
    }

    @Override
    public void setLocation(GeoPoint location) {
        directionsWaypoint.setLocation(location != null ? ((GeoPointDelegate)location).getLatLon() : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectionsWaypointDelegate that = (DirectionsWaypointDelegate) o;

        if (directionsWaypoint != null ? !directionsWaypoint.equals(that.directionsWaypoint) : that.directionsWaypoint != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return directionsWaypoint != null ? directionsWaypoint.hashCode() : 0;
    }
}