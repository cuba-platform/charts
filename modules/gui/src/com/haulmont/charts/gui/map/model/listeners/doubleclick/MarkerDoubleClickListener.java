/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.doubleclick;

import com.haulmont.charts.gui.map.model.Marker;

/**
 * @author korotkov
 * @version $Id$
 */
public interface MarkerDoubleClickListener {
    class MarkerDoubleClickEvent {
        private Marker marker;

        public MarkerDoubleClickEvent(Marker marker) {
            this.marker = marker;
        }

        public Marker getMarker() {
            return marker;
        }
    }

    void onClick(MarkerDoubleClickEvent event);
}