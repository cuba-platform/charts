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

public class DirectionsWaypoint implements Serializable {
    private static final long serialVersionUID = -2981796552431286404L;

    private LatLon location;
    private boolean stopOver = false;

    public DirectionsWaypoint(LatLon location, boolean stopOver) {
        this.location = location;
        this.stopOver = stopOver;
    }

    public DirectionsWaypoint() {
    }

    public boolean isStopOver() {
        return stopOver;
    }

    public void setStopOver(boolean stopOver) {
        this.stopOver = stopOver;
    }

    public LatLon getLocation() {
        return location;
    }

    public void setLocation(LatLon location) {
        this.location = location;
    }
}