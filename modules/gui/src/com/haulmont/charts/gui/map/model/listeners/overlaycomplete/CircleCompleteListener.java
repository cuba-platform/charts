/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.overlaycomplete;

import com.haulmont.charts.gui.map.model.Circle;

/**
 * @author korotkov
 * @version $Id$
 */
public interface CircleCompleteListener {
    static class CircleCompleteEvent {
        private Circle circle;

        public CircleCompleteEvent(Circle circle) {
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }

    void onCircleComplete(CircleCompleteEvent event);
}
