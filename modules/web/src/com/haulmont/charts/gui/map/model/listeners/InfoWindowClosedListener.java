/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.InfoWindow;

import java.util.function.Consumer;

/**
 * Listener to be fired up on info window closing.
 *
 * @deprecated Use {@link MapViewer#addInfoWindowClosedListener(Consumer)} instead.
 */
@Deprecated
public interface InfoWindowClosedListener extends Consumer<MapViewer.InfoWindowCloseEvent> {

    class InfoWindowCloseEvent {
        private InfoWindow infoWindow;

        public InfoWindowCloseEvent(InfoWindow infoWindow) {
            this.infoWindow = infoWindow;
        }

        public InfoWindow getInfoWindow() {
            return infoWindow;
        }
    }

    void onClose(InfoWindowCloseEvent event);

    @Override
    default void accept(MapViewer.InfoWindowCloseEvent event) {
        onClose(new InfoWindowCloseEvent(event.getInfoWindow()));
    }
}