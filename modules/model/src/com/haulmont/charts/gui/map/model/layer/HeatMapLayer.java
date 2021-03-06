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

package com.haulmont.charts.gui.map.model.layer;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.WeightedLocation;

import java.util.List;

/**
 * Layer for visualizing the intensity of data at geographical points.
 *
 */
public interface HeatMapLayer {

    /**
     * @return list of geographical points displayed
     */
    List<GeoPoint> getData();

    /**
     * @param data list of geographical points to display on the heatmap. Calling this method is enough to
     *             update already added on the map layer.
     */
    void setData(List<GeoPoint> data);

    /**
     * @return list of weighted locations
     */
    List<WeightedLocation> getWeightedData();

    /**
     * Sets weighted locations to display on the heatmap. Adding location with weight 3 equals to adding three
     * non-weighted locations with same coordinate. Mutually excluding with {@link HeatMapLayer#setData(List)}.
     * If non-weighted coordinates have been added using {@link HeatMapLayer#setData(List)}
     * then weighted ones wont be displayed.
     *
     * @param weightedData list of weighted locations
     */
    void setWeightedData(List<WeightedLocation> weightedData);

    /**
     * Sets colors to use for depicting intensity of the data. The order is from lowest to highest.
     * Any format supported by CSS3 standard supported as well, except "extended named color" (aquamarine,
     * chocolate etc) and HSL(A) colors.
     * Usually it is a good idea to give fully transparent first color (for example "rgba(255, 0, 255, 0)")
     * so that areas with no data had the same color as normal map.
     *
     * @param gradient list of colors
     */
    void setGradient(List<String> gradient);

    /**
     * @return colors used for depicting density of the data
     */
    List<String> getGradient();

    /**
     * @return opacity
     */
    Double getOpacity();

    /**
     * Sets heatmap opacity. Default value is 0.6
     * @param opacity opacity
     */
    void setOpacity(Double opacity);

    /**
     * @return radius of influence of each location
     */
    Double getRadius();

    /**
     * Sets the radius of influence for each location.
     * @param radius radius in pixels
     */
    void setRadius(Double radius);

    /**
     * Sets the maximum intensity of the heatmap. If maximum intensity is not set then colors will be dynamically
     * scaled based on area with highest intensity.
     *
     * @param maxIntensity max intensity
     */
    void setMaxIntensity(Double maxIntensity);

    /**
     * @return max intensity
     */
    Double getMaxIntensity();

    /**
     * Sets whether heatmap dissipate on zoom. When turned on the radius of influence doesn't change on zoom.
     * Defaults to false.
     *
     * @param dissipating dissipating
     */
    void setDissipating(Boolean dissipating);

    /**
     * @return true if heatmap dissipates on zoom, false otherwise
     */
    Boolean getDissipating();
}