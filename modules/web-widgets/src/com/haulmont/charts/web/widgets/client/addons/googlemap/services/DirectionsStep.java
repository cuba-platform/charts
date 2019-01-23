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

public class DirectionsStep implements Serializable {
    private static final long serialVersionUID = 4760988810153091866L;

    private Distance distance;
    private Duration duration;
    private LatLon endLocation;
    private LatLon startLocation;
    private String instructions;
    private List<LatLon> path;
    private TravelMode travelMode;

    public DirectionsStep() {
    }

    public DirectionsStep(List<LatLon> path) {
        this.path = path;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public LatLon getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LatLon endLocation) {
        this.endLocation = endLocation;
    }

    public LatLon getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(LatLon startLocation) {
        this.startLocation = startLocation;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<LatLon> getPath() {
        return path;
    }

    public void setPath(List<LatLon> path) {
        this.path = path;
    }

    public TravelMode getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(TravelMode travelMode) {
        this.travelMode = travelMode;
    }
}