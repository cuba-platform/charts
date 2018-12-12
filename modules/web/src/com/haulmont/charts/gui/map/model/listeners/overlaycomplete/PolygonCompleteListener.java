/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.overlaycomplete;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Polygon;

import java.util.function.Consumer;

/**
 * Listener to be fired up when user finished drawing polygon, i.e. made the first and the last vertices
 * of the polygon connected.
 *
 * @deprecated Use {@link MapViewer#addPolygonCompleteListener(Consumer)} instead.
 */
@Deprecated
public interface PolygonCompleteListener extends Consumer<MapViewer.PolygonCompleteEvent> {

    class PolygonCompleteEvent {
        private Polygon polygon;

        public PolygonCompleteEvent(Polygon polygon) {
            this.polygon = polygon;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

    void onComplete(PolygonCompleteEvent event);

    @Override
    default void accept(MapViewer.PolygonCompleteEvent event) {
        onComplete(new PolygonCompleteEvent(event.getPolygon()));
    }
}