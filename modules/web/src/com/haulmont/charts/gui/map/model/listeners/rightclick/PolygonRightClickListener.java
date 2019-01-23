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