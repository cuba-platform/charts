/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.rightclick;

import com.haulmont.charts.gui.map.model.GeoPoint;

public interface MapRightClickListener {
    class MapRightClickEvent {
        protected GeoPoint position;

        public MapRightClickEvent(GeoPoint position) {
            this.position = position;
        }

        public GeoPoint getPosition() {
            return position;
        }
    }

    void onRightClick(MapRightClickEvent event);
}