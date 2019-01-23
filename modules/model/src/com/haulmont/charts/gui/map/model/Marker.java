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

import com.haulmont.charts.gui.map.model.base.MarkerImage;

public interface Marker {

    /**
     * Sets position of the marker
     * @param position position
     */
    void setPosition(GeoPoint position);

    /**
     * @return position of the marker
     */
    GeoPoint getPosition();

    /**
     * Sets caption to be displayed when user hovers the marker
     * @param caption caption
     */
    void setCaption(String caption);

    /**
     * @return caption
     */
    String getCaption();

    /**
     * Sets whether marker should be draggable. Defaults to false
     * @param draggable draggable
     */
    void setDraggable(boolean draggable);

    /**
     * @return true if marker is draggable
     */
    boolean isDraggable();

    /**
     * Sets marker's icon URL. IF not specified marker will use standard icon.
     * @param iconUrl icon url
     */
    void setIconUrl(String iconUrl);

    /**
     * @return marker icon's url
     */
    String getIconUrl();

    /**
     * Sets whether marker adding animation must be turned on. Disable of a lot of markers should be added at once.
     * Defaults to true
     * @param animationEnabled true if animation should be enabled
     */
    void setAnimationEnabled(boolean animationEnabled);

    /**
     * @return true if animation is enabled
     */
    boolean isAnimationEnabled();

    /**
     * Sets if marker rendering should be optimized, which will lead to markers being rendered as a single DOM
     * element. This can drastically increase performance when a lot of markers should be displayed. Should be set to
     * false if user wants to use animated marker icon. Defaults to true
     * @param optimized true if marker rendering should be optimized
     */
    void setOptimized(boolean optimized);

    /**
     * @return true if marker rendering optimization is on
     */
    boolean isOptimized();

    /**
     * @return true if marker is visible
     */
    boolean isVisible();

    /**
     * Sets marker visibility
     * @param visible true if marker should be visible
     */
    void setVisible(boolean visible);

    /**
     * @return true if clicks on marker will cause click events
     */
    boolean isClickable();

    /**
     * @param clickable true if marker is clickable
     */
    void setClickable(boolean clickable);

    /**
     * Sets icon
     * @param icon icon
     */
    void setIcon(MarkerImage icon);

    /**
     * @return icon
     */
    MarkerImage getIcon();
}
