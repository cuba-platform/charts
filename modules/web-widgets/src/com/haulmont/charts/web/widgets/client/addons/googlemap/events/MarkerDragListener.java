/*
 * Copyright 2018 Tapio Aali
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.events;

import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapMarker;

import java.io.Serializable;

/**
 * Interface for listening marker drag events.
 */
public interface MarkerDragListener extends Serializable {
    /**
     * Handle a MarkerDragEvent.
     *
     * @param draggedMarker The marker that was dragged with position updated.
     * @param oldPosition   The old position of the marker.
     */
    void markerDragged(GoogleMapMarker draggedMarker, LatLon oldPosition);
}
