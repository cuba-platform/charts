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