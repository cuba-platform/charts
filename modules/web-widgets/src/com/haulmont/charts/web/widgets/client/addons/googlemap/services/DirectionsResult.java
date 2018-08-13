/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.services;

import java.io.Serializable;
import java.util.List;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public class DirectionsResult implements Serializable {
    private static final long serialVersionUID = 356752397239145745L;

    private List<DirectionsRoute> routes;

    public DirectionsResult() {
    }

    public DirectionsResult(List<DirectionsRoute> routes) {
        this.routes = routes;
    }

    public List<DirectionsRoute> getRoutes() {
        return routes;
    }

    public void setRoutes(List<DirectionsRoute> routes) {
        this.routes = routes;
    }
}