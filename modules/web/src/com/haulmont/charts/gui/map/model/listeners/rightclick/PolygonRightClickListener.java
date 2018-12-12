/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.rightclick;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Polygon;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addPolygonRightClickListener(Consumer)} instead.
 */
@Deprecated
public interface PolygonRightClickListener extends Consumer<MapViewer.PolygonRightClickEvent> {
    class PolygonRightClickEvent {
        protected Polygon polygon;

        public PolygonRightClickEvent(Polygon polygon) {
            this.polygon = polygon;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

    void onRightClick(PolygonRightClickEvent event);

    @Override
    default void accept(MapViewer.PolygonRightClickEvent event) {
        onRightClick(new PolygonRightClickEvent(event.getPolygon()));
    }
}