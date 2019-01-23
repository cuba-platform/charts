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

package com.haulmont.charts.gui.map.model;

/**
 * Used in heatmap layer to add coordinates with weight.
 *
 */
public interface WeightedLocation {

    /**
     * Sets location
     * @param geoPoint location
     */
    void setLocation(GeoPoint geoPoint);

    /**
     * @return location
     */
    GeoPoint getLocation();

    /**
     * Sets weight of the data point
     * @return weight
     */
    Double getWeight();

    /**
     * @param weight weight
     */
    void setWeight(Double weight);
}
