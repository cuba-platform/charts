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
 * Listener to be fired once when map initialization is finished: tiles are loaded up, coordinates of center
 * and borders are known etc.
 *
 * @deprecated Use {@link MapViewer#addMapInitListener(Consumer)} instead.
 */
@Deprecated
public interface MapInitListener extends Consumer<MapViewer.MapInitEvent> {
    void init(GeoPoint center, int zoom, GeoPoint boundNE, GeoPoint boundSW);

    @Override
    default void accept(MapViewer.MapInitEvent event) {
        init(event.getCenter(), event.getZoom(), event.getBoundNE(), event.getBoundSW());
    }
}
