/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.charts.gui.map.model.directions.DirectionsResult;
import com.haulmont.charts.gui.map.model.directions.DirectionsRoute;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;

import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public class DirectionsResultDelegate implements DirectionsResult {
    private com.vaadin.tapio.googlemaps.client.services.DirectionsResult result;

    public DirectionsResultDelegate(com.vaadin.tapio.googlemaps.client.services.DirectionsResult result) {
        this.result = result;
    }

    public com.vaadin.tapio.googlemaps.client.services.DirectionsResult getResult() {
        return result;
    }

    public void setResult(com.vaadin.tapio.googlemaps.client.services.DirectionsResult result) {
        this.result = result;
    }

    @Override
    public List<DirectionsRoute> getRoutes() {
        return DelegateHelper.toCubaDirectionsRoutes(result.getRoutes());
    }
}
