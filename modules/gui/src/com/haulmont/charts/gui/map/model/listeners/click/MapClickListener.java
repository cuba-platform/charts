/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.click;

import com.haulmont.charts.gui.map.model.GeoPoint;

/**
 * Listener to be fired up when user clicks on map.
 *
 * @author korotkov
 * @version $Id$
 */
public interface MapClickListener {
    class MapClickEvent {
        private GeoPoint position;

        public MapClickEvent(GeoPoint position) {
            this.position = position;
        }

        public GeoPoint getPosition() {
            return position;
        }
    }

    void onClick(MapClickEvent event);
}