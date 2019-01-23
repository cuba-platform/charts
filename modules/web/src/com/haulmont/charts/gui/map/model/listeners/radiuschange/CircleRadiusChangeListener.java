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

package com.haulmont.charts.gui.map.model.listeners.radiuschange;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Circle;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addCircleRadiusChangeListener(Consumer)} instead.
 */
@Deprecated
public interface CircleRadiusChangeListener extends Consumer<MapViewer.CircleRadiusChangeEvent> {

    class CircleRadiusChangeEvent {

        private Circle circle;
        private double oldRadius;

        public CircleRadiusChangeEvent(Circle circle, double oldRadius) {
            this.circle = circle;
            this.oldRadius = oldRadius;
        }

        public Circle getCircle() {
            return circle;
        }

        public double getOldRadius() {
            return oldRadius;
        }
    }

    void onRadiusChange(CircleRadiusChangeEvent event);

    @Override
    default void accept(MapViewer.CircleRadiusChangeEvent event) {
        onRadiusChange(new CircleRadiusChangeEvent(event.getCircle(), event.getOldRadius()));
    }
}