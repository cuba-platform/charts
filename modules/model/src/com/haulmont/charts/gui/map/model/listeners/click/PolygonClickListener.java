/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.click;

import com.haulmont.charts.gui.map.model.Polygon;

public interface PolygonClickListener {
    class PolygonClickEvent {
        protected Polygon polygon;

        public PolygonClickEvent(Polygon polygon) {
            this.polygon = polygon;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

    void onClick(PolygonClickEvent event);
}