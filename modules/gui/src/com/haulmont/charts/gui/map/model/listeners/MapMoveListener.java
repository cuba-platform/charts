/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.map.model.GeoPoint;

/**
 * Listener fired when map's center or bounds have been moved.
 * If map's center or bounds are being changed continuously (when the user is dragging the map for example),
 * then listener will be fired up only once, on moving finished.
 *
 * @author korotkov
 * @version $Id$
 */
public interface MapMoveListener {
    class MapMoveEvent {
        private double zoom;
        private GeoPoint center;
        private GeoPoint boundsNE;
        private GeoPoint boundsSW;

        public MapMoveEvent(double zoom, GeoPoint center, GeoPoint boundsNE, GeoPoint boundsSW) {
            this.zoom = zoom;
            this.center = center;
            this.boundsNE = boundsNE;
            this.boundsSW = boundsSW;
        }

        public double getZoom() {
            return zoom;
        }

        public GeoPoint getCenter() {
            return center;
        }

        public GeoPoint getBoundsNE() {
            return boundsNE;
        }

        public GeoPoint getBoundsSW() {
            return boundsSW;
        }
    }

    void onMove(MapMoveEvent event);
}