/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.click;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Polygon;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addPolygonClickListener(Consumer)} instead.
 */
@Deprecated
public interface PolygonClickListener extends Consumer<MapViewer.PolygonClickEvent> {
    class PolygonClickEvent {
        protected Polygon polygon;

        public PolygonClickEvent(Polygon polygon) {
            this.polygon = polygon;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

    void onClick(PolygonClickEvent event);

    @Override
    default void accept(MapViewer.PolygonClickEvent event) {
        onClick(new PolygonClickEvent(event.getPolygon()));
    }
}