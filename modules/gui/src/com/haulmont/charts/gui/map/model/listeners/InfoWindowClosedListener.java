/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.map.model.InfoWindow;

/**
 * @author korotkov
 * @version $Id$
 */
public interface InfoWindowClosedListener {

    static class InfoWindowCloseEvent {
        private InfoWindow infoWindow;

        public InfoWindowCloseEvent(InfoWindow infoWindow) {
            this.infoWindow = infoWindow;
        }

        public InfoWindow getInfoWindow() {
            return infoWindow;
        }
    }

    void onClose(InfoWindowCloseEvent event);

}
