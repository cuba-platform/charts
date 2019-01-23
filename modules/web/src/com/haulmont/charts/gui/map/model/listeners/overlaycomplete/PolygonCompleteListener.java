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