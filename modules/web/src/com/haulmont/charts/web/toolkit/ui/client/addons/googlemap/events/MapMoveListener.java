/*
 * Copyright 2018 Henri Muurimaa
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

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.events;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.LatLon;

import java.io.Serializable;

/**
 * Interface for listening map move and zoom events.
 *
 * @author Henri Muurimaa
 */
public interface MapMoveListener extends Serializable {
    /**
     * Handle a MapMoveEvent.
     *
     * @param zoomLevel The new zoom level.
     * @param center    The new center.
     * @param boundsNE  The position of the north-east corner of the map.
     * @param boundsSW  The position of the south-west corner of the map.
     */
    public void mapMoved(int zoomLevel, LatLon center, LatLon boundsNE,
                         LatLon boundsSW);
}