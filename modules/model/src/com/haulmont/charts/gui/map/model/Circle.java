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

public interface Circle {

    /**
     * @return center of the circle overlay
     */
    GeoPoint getCenter();

    /**
     * Sets center of the circle overlay
     * @param center center
     */
    void setCenter(GeoPoint center);

    /**
     * @return true if user is able to drag overlay over the map. Defaults to false
     */
    boolean isDraggable();

    /**
     * If set to true, the user can drag overlay over the map. Defaults to false
     * @param draggable draggable
     */
    void setDraggable(boolean draggable);

    /**
     * @return true if the user can edit this overlay by dragging the control points displayed in the center of
     * the circle and on the edges. Defaults to false.
     */
    boolean isEditable();

    /**
     * If set to true, the user can edit this overlay by dragging the control points displayed in the center of
     * the circle and on the edges. Defaults to false.
     * @param editable editable
     */
    void setEditable(boolean editable);

    /**
     * Flag defining whether overlay is visible on the map. Defaults to true.
     * @return true is overlay is visible
     */
    boolean isVisible();

    /**
     * Sets flag defining whether overlay is visible on the map. Defaults to true.
     * @param visible visible
     */
    void setVisible(boolean visible);

    /**
     * Flag defining whether overlay handles click (and double click) events. Defaults to true.
     * @return true if clickable
     */
    boolean isClickable();

    /**
     * Sets flag defining whether overlay handles click (and double click) events. Defaults to true.
     * @param clickable clickable
     */
    void setClickable(boolean clickable);

    /**
     * Radius of the circle overlay in meters on the Earth's surface
     * @return radius in meters
     */
    double getRadius();

    /**
     * Sets radius of the circle overlay in meters on the Earth's surface
     * @param radius radius in meters
     */
    void setRadius(double radius);

    /**
     * Sets circle fill color. Defaults to "#ffffff"
     * @param fillColor fill color in any CSS3 format except extended name colors (aquamarine, chocolate etc)
     */
    void setFillColor(String fillColor);

    /**
     * @return circle fill color
     */
    String getFillColor();

    /**
     * Sets fill opacity. Defaults to 1.0
     * @param fillOpacity fill opacity
     */
    void setFillOpacity(double fillOpacity);

    /**
     * @return fill opacity
     */
    double getFillOpacity();

    /**
     * Sets stroke color. Defaults to "#000000"
     * @param strokeColor stroke color in any CSS3 format except extended name colors (aquamarine, chocolate etc)
     */
    void setStrokeColor(String strokeColor);

    /**
     * @return stroke color
     */
    String getStrokeColor();

    /**
     * Sets stroke opacity. Defaults to 1.0
     * @param strokeOpacity
     */
    void setStrokeOpacity(double strokeOpacity);

    /**
     * @return stroke opacity
     */
    double getStrokeOpacity();

    /**
     * Sets stroke weight in pixels. Defaults to 1
     * @param strokeWeight stroke weight in pixels
     */
    void setStrokeWeight(int strokeWeight);

    /**
     * @return stroke weights in pixels
     */
    int getStrokeWeight();

    /**
     * Sets circle z-index
     * @param zIndex z-index
     */
    void setzIndex(int zIndex);

    /**
     * @return z-index
     */
    int getzIndex();
}