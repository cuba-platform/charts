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

import java.io.Serializable;

public class PolygonOptions implements Serializable {

    private static final long serialVersionUID = -1836885545431952265L;

    protected boolean clickable = true;
    protected boolean editable = false;
    protected String fillColor = "#993366";
    protected Double fillOpacity = 0.6;
    protected boolean geodesic = false;
    protected String strokeColor = "#000000";
    protected Double strokeOpacity = 1.0;
    protected Integer strokeWeight = 3;
    protected boolean visible = true;
    protected Integer zIndex = 0;

    public PolygonOptions() {
    }

    public PolygonOptions(boolean clickable, boolean editable) {
        this.clickable = clickable;
        this.editable = editable;
    }

    public PolygonOptions(boolean clickable, boolean editable, String fillColor, Double fillOpacity) {
        this.clickable = clickable;
        this.editable = editable;
        this.fillColor = fillColor;
        this.fillOpacity = fillOpacity;
    }

    /**
     * @return true if created polygon should be editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * Sets whether newly created polygon should be editable, which allows user to move/add/delete polygon vertices.
     * Defaults to false
     *
     * @param editable true if polygon should be editable
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * @return true if created polygon should handle click events. Defaults to true
     */
    public boolean isClickable() {
        return clickable;
    }

    /**
     * Flag defining whether newly created polygon should handle click events. Defaults to true
     * @param clickable true if polygon should handle click events
     */
    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    /**
     * @return polygon fill color
     */
    public String getFillColor() {
        return fillColor;
    }

    /**
     * Sets polygon fill color.
     * Defaults to "#993366"
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
     * Sets whether polygon edges should be geodesic, which means they they curve will change depending of the polygon
     * closeness to north/south pole. If edges aren't geodesic then they are rendered as straight lines in screen space.
     * Defaults to false
     *
     * @param geodesic true if edges should be geodesic
     */
    public void setGeodesic(boolean geodesic) {
        this.geodesic = geodesic;
    }

    /**
     * @return true if edges are geodesic
     */
    public boolean isGeodesic() {
        return geodesic;
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
     * @return visibility of newly drawn polygons
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets visibility of newly drawn polygons
     * @param visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return z-index
     */
    public Integer  getZIndex() {
        return zIndex;
    }

    /**
     * Sets polygon z-index
     * @param zIndex z-index
     */
    public void setZIndex(Integer  zIndex) {
        this.zIndex = zIndex;
    }
}