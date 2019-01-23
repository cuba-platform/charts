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
 * InfoWindow is a component for displaying html content in a popup on the map, at a given location.
 * Can be attached to a marker or to a given location.
 *
 */
public interface InfoWindow {

    /**
     * Sets info window content in HTML format
     * @param content content
     */
    void setContent(String content);

    /**
     * @return info window content
     */
    String getContent();

    /**
     * Sets infoWindow width. The width format is similar to the one used in HTML.
     * @param width width
     */
    void setWidth(String width);

    /**
     * @return width
     */
    String getWidth();

    /**
     * Sets infoWindow height. The height format is similar to the one used in HTML.
     * @param height height
     */
    void setHeight(String height);

    /**
     * @return height
     */
    String getHeight();

    /**
     * Sets info window max width in pixels. With maximum width specified info window will auto-wrap to enforce
     * the specified width.
     *
     * @param maxWidth maximum width
     */
    void setMaxWidth(Integer maxWidth);

    /**
     * @return info window maximum width
     */
    Integer getMaxWidth();

    /**
     * Sets horizontal offset from the tip of the window to the location/marker on which the window is anchored.
     * @param pixelOffsetWidth horizontal offset in pixels. Can be negative.
     */
    void setPixelOffsetWidth(Integer pixelOffsetWidth);

    /**
     * @return horizontal offset from the tip of the window to the location/marker on which the window is anchored.
     */
    Integer getPixelOffsetWidth();

    /**
     * Sets vertical offset from the tip of the window to the location/marker on which the window is anchored.
     * @param pixelOffsetHeight vertical offset in pixels. Cen be negative.
     */
    void setPixelOffsetHeight(Integer pixelOffsetHeight);

    /**
     * @return vertical offset from the tip of the window to the location/marker on which the window is anchored.
     */
    Integer getPixelOffsetHeight();

    /**
     * Sets z-index of the window
     * @param zIndex z-index
     */
    void setZIndex(Integer zIndex);

    /**
     * @return z-index
     */
    Integer getZIndex();

    /**
     * Position on which info window should be anchored on. Typically user will use
     * {@link InfoWindow#setAnchorMarker(Marker)} instead.
     *
     * @param position position
     */
    void setPosition(GeoPoint position);

    /**
     * @return position on which info window is anchored on
     */
    GeoPoint getPosition();

    /**
     * Sets marker on which info window should be anchored on
     * @param anchorMarker anchor marker
     */
    void setAnchorMarker(Marker anchorMarker);

    /**
     * @return marker on which info window is anchored on
     */
    Marker getAnchorMarker();

    /**
     * Sets whether map should be scrolled automatically if info window doesn't fit it.
     * @param autoPanDisabled true if auto pan feature should be disabled
     */
    void setAutoPanDisabled(boolean autoPanDisabled);

    /**
     * @return true if auto pan is disabled
     */
    boolean isAutoPanDisabled();
}
