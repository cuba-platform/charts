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

package com.haulmont.charts.web.widgets.client.addons.googlemap.services;

import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;

import java.io.Serializable;
import java.util.List;

public class DirectionsRoute implements Serializable {
    private static final long serialVersionUID = 8115813324830592935L;

    private LatLonBounds bounds;
    private String copyrights;
    private List<DirectionsLeg> legs;
    private List<LatLon> overviewPath;
    private String[] warnings;
    private int[] waypointOrder;

    public DirectionsRoute() {
    }

    public LatLonBounds getBounds() {
        return bounds;
    }

    public void setBounds(LatLonBounds bounds) {
        this.bounds = bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public List<DirectionsLeg> getLegs() {
        return legs;
    }

    public void setLegs(List<DirectionsLeg> legs) {
        this.legs = legs;
    }

    public List<LatLon> getOverviewPath() {
        return overviewPath;
    }

    public void setOverviewPath(List<LatLon> overviewPath) {
        this.overviewPath = overviewPath;
    }

    public String[] getWarnings() {
        return warnings;
    }

    public void setWarnings(String[] warnings) {
        this.warnings = warnings;
    }

    public int[] getWaypointOrder() {
        return waypointOrder;
    }

    public void setWaypointOrder(int[] waypointOrder) {
        this.waypointOrder = waypointOrder;
    }
}