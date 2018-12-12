/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.click;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Marker;

import java.util.function.Consumer;

/**
 * Listener fired when user clicks marker
 *
 * @deprecated Use {@link MapViewer#addMarkerClickListener(Consumer)} instead.
 */
@Deprecated
public interface MarkerClickListener extends Consumer<MapViewer.MarkerClickEvent> {

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

    @Override
    default void accept(MapViewer.MarkerClickEvent event) {
        onClick(new MarkerClickEvent(event.getMarker()));
    }
}