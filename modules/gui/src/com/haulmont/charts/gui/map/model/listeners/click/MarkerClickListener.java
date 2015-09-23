/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.click;

import com.haulmont.charts.gui.map.model.Marker;

/**
 * Listener fired when user clicks marker
 *
 * @author korotkov
 * @version $Id$
 */
public interface MarkerClickListener {

    class MarkerClickEvent {
        private Marker marker;

        public MarkerClickEvent(Marker marker) {
            this.marker = marker;
        }

        public Marker getMarker() {
            return marker;
        }
    }

    void onClick(MarkerClickEvent event);
}