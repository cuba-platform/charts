/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Polygon;

import java.util.function.Consumer;

/**
 * Listener to be fired up when user adds/removes/moves polygon vertex.
 *
 * @deprecated Use {@link MapViewer#addPolygonEditListener(Consumer)} instead.
 */
@Deprecated
public interface PolygonEditListener extends Consumer<MapViewer.PolygonEditEvent> {

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

    @Override
    default void accept(MapViewer.PolygonEditEvent event) {
        onEdit(new PolygonEditEvent(event.getPolygon(), convertActionType(event.getActionType()),
                event.getIndex(), event.getGeoPoint()));
    }

    default ActionType convertActionType(MapViewer.PolygonEditEvent.ActionType actionType) {
        switch (actionType) {
            case SET:
                return ActionType.SET;
            case INSERT:
                return ActionType.INSERT;
            case REMOVE:
                return ActionType.REMOVE;
        }
        return null;
    }
}