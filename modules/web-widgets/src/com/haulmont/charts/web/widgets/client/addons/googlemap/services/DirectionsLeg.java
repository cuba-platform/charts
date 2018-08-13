/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.services;

import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;

import java.io.Serializable;
import java.util.List;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public class DirectionsLeg implements Serializable {
    private static final long serialVersionUID = 5373460510314109667L;

    private Distance distance;
    private Duration duration;
    private String startAddress;
    private String endAddress;
    private LatLon startLocation;
    private LatLon endLocation;
    private List<DirectionsStep> steps;
    private List<LatLon> viaWaypoints;

    public DirectionsLeg() {
    }

    public DirectionsLeg(List<DirectionsStep> steps) {
        this.steps = steps;
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

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public LatLon getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(LatLon startLocation) {
        this.startLocation = startLocation;
    }

    public List<DirectionsStep> getSteps() {
        return steps;
    }

    public void setSteps(List<DirectionsStep> steps) {
        this.steps = steps;
    }

    public List<LatLon> getViaWaypoints() {
        return viaWaypoints;
    }

    public void setViaWaypoints(List<LatLon> viaWaypoints) {
        this.viaWaypoints = viaWaypoints;
    }

    public LatLon getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LatLon endLocation) {
        this.endLocation = endLocation;
    }
}