/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.rightclick;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addMapRightClickListener(Consumer)} instead.
 */
@Deprecated
public interface MapRightClickListener extends Consumer<MapViewer.MapRightClickEvent> {
    class MapRightClickEvent {
        protected GeoPoint position;

        public MapRightClickEvent(GeoPoint position) {
            this.position = position;
        }

        public GeoPoint getPosition() {
            return position;
        }
    }

    void onRightClick(MapRightClickEvent event);

    @Override
    default void accept(MapViewer.MapRightClickEvent event) {
        onRightClick(new MapRightClickEvent(event.getPosition()));
    }
}