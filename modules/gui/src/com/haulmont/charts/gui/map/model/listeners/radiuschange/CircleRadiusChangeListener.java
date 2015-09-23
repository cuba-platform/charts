/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.radiuschange;

import com.haulmont.charts.gui.map.model.Circle;

/**
 * @author korotkov
 * @version $Id$
 */
public interface CircleRadiusChangeListener {

    class CircleRadiusChangeEvent {

        private Circle circle;
        private double oldRadius;

        public CircleRadiusChangeEvent(Circle circle, double oldRadius) {
            this.circle = circle;
            this.oldRadius = oldRadius;
        }

        public Circle getCircle() {
            return circle;
        }

        public double getOldRadius() {
            return oldRadius;
        }
    }

    void onRadiusChange(CircleRadiusChangeEvent event);
}