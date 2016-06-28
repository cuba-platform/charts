/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.directions.DirectionsResult;
import com.haulmont.charts.gui.map.model.directions.DirectionsRoute;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;

import java.util.List;

public class DirectionsResultDelegate implements DirectionsResult {
    private com.vaadin.tapio.googlemaps.client.services.DirectionsResult result;

    public static DirectionsResultDelegate fromDirectionsResult(com.vaadin.tapio.googlemaps.client.services.DirectionsResult result) {
        return result != null ? new DirectionsResultDelegate(result) : null;
    }

    public DirectionsResultDelegate(com.vaadin.tapio.googlemaps.client.services.DirectionsResult result) {
        Preconditions.checkNotNullArgument(result);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectionsResultDelegate that = (DirectionsResultDelegate) o;

        if (result != null ? !result.equals(that.result) : that.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return result != null ? result.hashCode() : 0;
    }
}