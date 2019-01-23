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

package com.haulmont.charts.gui.map.model.listeners.centerchange;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Circle;
import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addCircleCenterChangeListener(Consumer)} instead.
 */
@Deprecated
public interface CircleCenterChangeListener extends Consumer<MapViewer.CircleCenterChangeEvent> {

    class CircleCenterChangeEvent {
        private Circle circle;
        private GeoPoint oldCenter;

        public CircleCenterChangeEvent(Circle circle, GeoPoint oldCenter) {
            this.circle = circle;
            this.oldCenter = oldCenter;
        }

        public Circle getCircle() {
            return circle;
        }

        public GeoPoint getOldCenter() {
            return oldCenter;
        }
    }

    void onCenterChange(CircleCenterChangeEvent event);

    @Override
    default void accept(MapViewer.CircleCenterChangeEvent mapEvent) {
        onCenterChange(new CircleCenterChangeEvent(mapEvent.getCircle(), mapEvent.getOldCenter()));
    }
}