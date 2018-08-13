/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.rightclick;

import com.haulmont.charts.gui.map.model.Marker;

public interface MarkerRightClickListener {
    class MarkerRightClickEvent {
        protected Marker marker;

        public MarkerRightClickEvent(Marker marker) {
            this.marker = marker;
        }

        public Marker getMarker() {
            return marker;
        }
    }

    void onRightClick(MarkerRightClickEvent event);
}