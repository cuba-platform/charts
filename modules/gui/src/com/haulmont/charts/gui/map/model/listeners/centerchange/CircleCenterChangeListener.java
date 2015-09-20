/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.centerchange;

import com.haulmont.charts.gui.map.model.Circle;
import com.haulmont.charts.gui.map.model.GeoPoint;

/**
 * @author korotkov
 * @version $Id$
 */
public interface CircleCenterChangeListener {

    static class CircleCenterChangeEvent {
        private Circle circle;
        private GeoPoint oldCenter;

        public CircleCenterChangeEvent(Circle circle, GeoPoint oldCenter) {
            this.circle = circle;
            this.oldCenter = oldCenter;
        }

        public Circle getCircle() {
            return circle;
        }

        public GeoPoint getOldCenter() {
            return oldCenter;
        }
    }

    void onCenterChange(CircleCenterChangeEvent event);
}
