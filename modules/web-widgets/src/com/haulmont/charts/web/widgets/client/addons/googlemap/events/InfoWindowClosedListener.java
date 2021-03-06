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

import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapInfoWindow;

import java.io.Serializable;

/**
 * Interface for listening info window close events initiated by the user.
 */
public interface InfoWindowClosedListener extends Serializable {

    /**
     * Handle an info window close event
     *
     * @param window the info window that was closed.
     */
    void infoWindowClosed(GoogleMapInfoWindow window);
}
