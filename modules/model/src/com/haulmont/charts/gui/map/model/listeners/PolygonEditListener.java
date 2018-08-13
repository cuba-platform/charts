/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Polygon;

/**
 * Listener to be fired up when user adds/removes/moves polygon vertex.
 */
public interface PolygonEditListener {

    /**
     * Polygon edit action type
     *
     * <br> {@link #INSERT} - vertex have been inserted into polygon
     * <br> {@link #REMOVE} - vertex have been removed from polygon
     * <br> {@link #SET} - vertex coordinates have been changed
     */
    enum ActionType {
        INSERT,
        REMOVE,
        SET
    }

    class PolygonEditEvent {
        private Polygon polygon;
        private ActionType actionType;
        private int index;
        private GeoPoint geoPoint;

        public PolygonEditEvent(Polygon polygon, ActionType actionType, int index, GeoPoint geoPoint) {
            this.polygon = polygon;
            this.actionType = actionType;
            this.index = index;
            this.geoPoint = geoPoint;
        }

        public Polygon getPolygon() {
            return polygon;
        }

        public ActionType getActionType() {
            return actionType;
        }

        public int getIndex() {
            return index;
        }

        public GeoPoint getGeoPoint() {
            return geoPoint;
        }
    }

    void onEdit(PolygonEditEvent polygonEditEvent);
}