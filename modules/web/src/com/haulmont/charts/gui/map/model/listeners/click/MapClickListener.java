/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.click;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.function.Consumer;

/**
 * Listener to be fired up when user clicks on map.
 *
 * @deprecated Use {@link MapViewer#addMapClickListener(Consumer)} instead.
 */
@Deprecated
public interface MapClickListener extends Consumer<MapViewer.MapClickEvent> {
    class MapClickEvent {
        private GeoPoint position;

        public MapClickEvent(GeoPoint position) {
            this.position = position;
        }

        public GeoPoint getPosition() {
            return position;
        }
    }

    void onClick(MapClickEvent event);

    @Override
    default void accept(MapViewer.MapClickEvent event) {
        onClick(new MapClickEvent(event.getPosition()));
    }
}