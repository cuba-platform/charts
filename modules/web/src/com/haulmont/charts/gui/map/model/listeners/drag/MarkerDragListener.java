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

package com.haulmont.charts.gui.map.model.listeners.drag;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Marker;

import java.util.function.Consumer;

/**
 * Listener to be fired up when user dragged marker and released mouse button.
 *
 * @deprecated Use {@link MapViewer#addMarkerDragListener(Consumer)} instead.
 */
@Deprecated
public interface MarkerDragListener extends Consumer<MapViewer.MarkerDragEvent> {

    class MarkerDragEvent {
        private Marker marker;
        private GeoPoint oldPosition;

        public MarkerDragEvent(Marker marker, GeoPoint oldPosition) {
            this.marker = marker;
            this.oldPosition = oldPosition;
        }

        public Marker getMarker() {
            return marker;
        }

        public GeoPoint getOldPosition() {
            return oldPosition;
        }
    }

    void onDrag(MarkerDragEvent event);

    @Override
    default void accept(MapViewer.MarkerDragEvent event) {
        onDrag(new MarkerDragEvent(event.getMarker(), event.getOldPosition()));
    }
}