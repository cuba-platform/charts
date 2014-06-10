/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.map.model.GeoPoint;

/**
 * @author korotkov
 * @version $Id$
 */
public interface MapClickListener {
    static class MapClickEvent {
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
