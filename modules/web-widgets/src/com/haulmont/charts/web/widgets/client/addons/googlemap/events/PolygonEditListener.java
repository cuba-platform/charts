/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.events;

import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapPolygon;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public interface PolygonEditListener {

    /**
     * Polygon edit action type
     *
     * <p> {@link #INSERT} - vertex have been inserted into polygon
     * <p> {@link #REMOVE} - vertex have been removed from polygon
     * <p> {@link #SET} - vertex coordinates have been changed
     */
    enum ActionType {
        INSERT,
        REMOVE,
        SET
    }

    void polygonEdited(GoogleMapPolygon polygon, ActionType actionType, int idx, LatLon latLon);
}