/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.LatLon;

import java.io.Serializable;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
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