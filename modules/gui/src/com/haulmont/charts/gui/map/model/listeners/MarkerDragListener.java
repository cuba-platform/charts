/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Marker;

/**
 * @author korotkov
 * @version $Id$
 */
public interface MarkerDragListener {

    static class MarkerDragEvent {
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
