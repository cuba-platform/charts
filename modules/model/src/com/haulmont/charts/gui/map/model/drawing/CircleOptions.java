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

package com.haulmont.charts.gui.map.model.drawing;

import com.haulmont.charts.gui.map.model.GeoPoint;

import java.io.Serializable;

public class CircleOptions implements Serializable {

    private static final long serialVersionUID = 456182536005952265L;

    protected GeoPoint center = null;
    protected Double radius = null;
    protected boolean clickable = true;
    protected boolean editable = false;
    protected String fillColor = "#33ee66";
    protected Double fillOpacity = 0.6;
    protected String strokeColor = "#000000";
    protected Double strokeOpacity = 1.0;
    protected Integer strokeWeight = 1;
    protected Integer zIndex = 0;

    public CircleOptions() {
    }

    public CircleOptions(boolean clickable, boolean editable) {
        this.clickable = clickable;
        this.editable = editable;
    }

    public CircleOptions(boolean clickable, boolean editable, String fillColor, Double fillOpacity) {
        this.clickable = clickable;
        this.editable = editable;
        this.fillColor = fillColor;
        this.fillOpacity = fillOpacity;
    }

    /**
     * @return true if created circle should handle click events. Defaults to true
     */
    public boolean isClickable() {
        return clickable;
    }

    /**
     * Flag defining whether newly created circle should handle click events. Defaults to true
     * @param clickable true if circle should handle click events
     */
    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    /**
     * @return true if created circle should be editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * Sets whether newly created circle should be editable, which allows user to drag control points at center
     * of circle and on its circumference.
     * Defaults to false
     *
     * @param editable true if circle should be editable
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * @return circle fill color
     */
    public String getFillColor() {
        return fillColor;
    }

    /**
     * Sets circle fill color.
     * Defaults to "#33ee66"
     *
     * @param fillColor fill color in any CSS3 format except extended name colors (aquamarine, chocolate etc)
     */
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    /**
     * @return fill opacity
     */
    public Double getFillOpacity() {
        return fillOpacity;
    }

    /**
     * Sets fill opacity. Defaults to 0.6
     * @param fillOpacity fill opacity
     */
    public void setFillOpacity(Double fillOpacity) {
        this.fillOpacity = fillOpacity;
    }

    /**
     * @return stroke color
     */
    public String getStrokeColor() {
        return strokeColor;
    }

    /**
     * Sets stroke color.
     * Defaults to "#000000" (black)
     *
     * @param strokeColor stroke color in any CSS3 format except extended name colors (aquamarine, chocolate etc)
     */
    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    /**
     * @return stroke opacity
     */
    public Double getStrokeOpacity() {
        return strokeOpacity;
    }

    /**
     * Sets stroke opacity.
     * Defaults to 1.0
     *
     * @param strokeOpacity
     */
    public void setStrokeOpacity(Double strokeOpacity) {
        this.strokeOpacity = strokeOpacity;
    }

    /**
     * @return stroke opacity
     */
    public Integer getStrokeWeight() {
        return strokeWeight;
    }

    /**
     * Sets stroke weight in pixels.
     * Defaults to 3
     *
     * @param strokeWeight stroke weight in pixels
     */
    public void setStrokeWeight(Integer strokeWeight) {
        this.strokeWeight = strokeWeight;
    }

    /**
     * @return z-index
     */
    public Integer getZIndex() {
        return zIndex;
    }

    /**
     * Sets circle z-index
     * @param zIndex z-index
     */
    public void setZIndex(Integer zIndex) {
        this.zIndex = zIndex;
    }

    /**
     * Not used for drawing
     * @return center
     */
    public GeoPoint getCenter() {
        return center;
    }

    /**
     * Not used for drawing
     * @param center center
     */
    public void setCenter(GeoPoint center) {
        this.center = center;
    }

    /**
     * Not used for drawing
     * @return radius
     */
    public Double getRadius() {
        return radius;
    }

    /**
     * Not used for drawing
     * @param radius radius
     */
    public void setRadius(Double radius) {
        this.radius = radius;
    }
}