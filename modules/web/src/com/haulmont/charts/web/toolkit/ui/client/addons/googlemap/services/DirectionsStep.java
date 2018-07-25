/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.LatLon;

import java.io.Serializable;
import java.util.List;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)

 */
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