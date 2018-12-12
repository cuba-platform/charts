/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.doubleclick;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Marker;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addMarkerDoubleClickListener(Consumer)} instead.
 */
@Deprecated
public interface MarkerDoubleClickListener extends Consumer<MapViewer.MarkerDoubleClickEvent> {
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

    @Override
    default void accept(MapViewer.MarkerDoubleClickEvent event) {
        onClick(new MarkerDoubleClickEvent(event.getMarker()));
    }
}