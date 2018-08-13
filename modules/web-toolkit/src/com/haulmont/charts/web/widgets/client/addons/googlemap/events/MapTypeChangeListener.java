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

import java.io.Serializable;

import com.google.gwt.maps.client.MapTypeId;

public interface MapTypeChangeListener extends Serializable {
    /**
     * Handle a MapTypeIdChange.
     *
     * @param mapTypeId The id of the new map type.
     */
    void mapTypeChanged(String mapTypeId);
}
