/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.click;

import com.haulmont.charts.gui.map.model.Polygon;

/**
 * @author korotkov
 * @version $Id$
 */
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
