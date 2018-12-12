/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.rightclick;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Marker;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addMarkerRightClickListener(Consumer)} instead.
 */
@Deprecated
public interface MarkerRightClickListener extends Consumer<MapViewer.MarkerRightClickEvent> {
    class MarkerRightClickEvent {
        protected Marker marker;

        public MarkerRightClickEvent(Marker marker) {
            this.marker = marker;
        }

        public Marker getMarker() {
            return marker;
        }
    }

    void onRightClick(MarkerRightClickEvent event);

    @Override
    default void accept(MapViewer.MarkerRightClickEvent event) {
        onRightClick(new MarkerRightClickEvent(event.getMarker()));
    }
}