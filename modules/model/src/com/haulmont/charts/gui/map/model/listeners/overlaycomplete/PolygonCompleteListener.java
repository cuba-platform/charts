/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.overlaycomplete;

import com.haulmont.charts.gui.map.model.Polygon;

/**
 * Listener to be fired up when user finished drawing polygon, i.e. made the first and the last vertices
 * of the polygon connected.
 *
 */
public interface PolygonCompleteListener {

    class PolygonCompleteEvent {
        private Polygon polygon;

        public PolygonCompleteEvent(Polygon polygon) {
            this.polygon = polygon;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

    void onComplete(PolygonCompleteEvent event);
}