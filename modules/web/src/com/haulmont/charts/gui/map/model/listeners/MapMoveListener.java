/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.function.Consumer;

/**
 * Listener fired when map's center or bounds have been moved.
 * If map's center or bounds are being changed continuously (when the user is dragging the map for example),
 * then listener will be fired up only once, on moving finished.
 *
 * @deprecated Use {@link MapViewer#addMapMoveListener(Consumer)} instead.
 */
@Deprecated
public interface MapMoveListener extends Consumer<MapViewer.MapMoveEvent> {
    class MapMoveEvent {
        private double zoom;
        private GeoPoint center;
        private GeoPoint boundsNE;
        private GeoPoint boundsSW;

        public MapMoveEvent(double zoom, GeoPoint center, GeoPoint boundsNE, GeoPoint boundsSW) {
            this.zoom = zoom;
            this.center = center;
            this.boundsNE = boundsNE;
            this.boundsSW = boundsSW;
        }

        public double getZoom() {
            return zoom;
        }

        public GeoPoint getCenter() {
            return center;
        }

        public GeoPoint getBoundsNE() {
            return boundsNE;
        }

        public GeoPoint getBoundsSW() {
            return boundsSW;
        }
    }

    void onMove(MapMoveEvent event);

    @Override
    default void accept(MapViewer.MapMoveEvent event) {
        onMove(new MapMoveEvent(event.getZoom(), event.getCenter(), event.getBoundsNE(), event.getBoundsSW()));
    }
}