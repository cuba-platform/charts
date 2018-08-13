/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.rightclick;

import com.haulmont.charts.gui.map.model.Polygon;

public interface PolygonRightClickListener {
    class PolygonRightClickEvent {
        protected Polygon polygon;

        public PolygonRightClickEvent(Polygon polygon) {
            this.polygon = polygon;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

    void onRightClick(PolygonRightClickEvent event);
}