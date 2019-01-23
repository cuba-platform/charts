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
import com.haulmont.charts.gui.map.model.Circle;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addCircleClickListener(Consumer)} instead.
 */
@Deprecated
public interface CircleClickListener extends Consumer<MapViewer.CircleClickEvent> {
    class CircleClickEvent {
        private Circle circle;

        public CircleClickEvent(Circle circle) {
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }

    void onClick(CircleClickEvent event);

    @Override
    default void accept(MapViewer.CircleClickEvent event) {
        onClick(new CircleClickEvent(event.getCircle()));
    }
}