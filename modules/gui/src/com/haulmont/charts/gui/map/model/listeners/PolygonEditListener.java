/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Polygon;

/**
 * @author korotkov
 * @version $Id$
 */
public interface PolygonEditListener {

    /**
     * Polygon edit action type
     *
     * <p/> {@link #INSERT} - vertex have been inserted into polygon
     * <p/> {@link #REMOVE} - vertex have been removed from polygon
     * <p/> {@link #SET} - vertex coordinates have been changed
     */
    enum ActionType {
        INSERT,
        REMOVE,
        SET
    }

    static class PolygonEditEvent {
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
