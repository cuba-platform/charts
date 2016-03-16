/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.drag;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Marker;

/**
 * Listener to be fired up when user dragged marker and released mouse button.
 *
 */
public interface MarkerDragListener {

    class MarkerDragEvent {
        private Marker marker;
        private GeoPoint oldPosition;

        public MarkerDragEvent(Marker marker, GeoPoint oldPosition) {
            this.marker = marker;
            this.oldPosition = oldPosition;
        }

        public Marker getMarker() {
            return marker;
        }

        public GeoPoint getOldPosition() {
            return oldPosition;
        }
    }

    void onDrag(MarkerDragEvent event);
}