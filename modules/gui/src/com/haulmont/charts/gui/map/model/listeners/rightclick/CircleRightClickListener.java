/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.rightclick;

import com.haulmont.charts.gui.map.model.Circle;

public interface CircleRightClickListener {
    class CircleRightClickEvent {
        protected Circle circle;

        public CircleRightClickEvent(Circle circle) {
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }

    void onRightClick(CircleRightClickEvent event);
}