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

package com.haulmont.charts.web.widgets.client.addons.googlemap.overlays;

import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;

import java.io.Serializable;
import java.util.Objects;

public class GoogleMapCircle implements Serializable {

    private static final long serialVersionUID = 3901146983180302418L;

    private static long idCounter = 0;

    private long id;

    protected LatLon center;
    protected boolean draggable = false;
    protected boolean editable = false;
    protected boolean visible = true;
    protected boolean clickable = true;
    protected double radius;
    protected String fillColor = "#ffffff";
    protected double fillOpacity = 1.0;
    protected String strokeColor = "#000000";
    protected double strokeOpacity = 1.0;
    protected int strokeWeight = 1;
    protected int zIndex = 0;

    /**
     * Instantiates a new circle overlay using default values.
     */
    public GoogleMapCircle() {
        id = idCounter;
        idCounter++;
    }

    public GoogleMapCircle(LatLon center, double radius) {
        this();
        this.center = center;
        this.radius = radius;
    }

    public LatLon getCenter() {
        return center;
    }

    public void setCenter(LatLon center) {
        this.center = center;
    }

    public boolean isDraggable() {
        return draggable;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public double getFillOpacity() {
        return fillOpacity;
    }

    public void setFillOpacity(double fillOpacity) {
        this.fillOpacity = fillOpacity;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public double getStrokeOpacity() {
        return strokeOpacity;
    }

    public void setStrokeOpacity(double strokeOpacity) {
        this.strokeOpacity = strokeOpacity;
    }

    public int getStrokeWeight() {
        return strokeWeight;
    }

    public void setStrokeWeight(int strokeWeight) {
        this.strokeWeight = strokeWeight;
    }

    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GoogleMapCircle other = (GoogleMapCircle) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    public boolean hasSameFieldValues(GoogleMapCircle o) {
        if (!Objects.equals(center, o.center)) {
            return false;
        }
        if (draggable != o.draggable) {
            return false;
        }
        if (editable != o.editable) {
            return false;
        }
        if (visible != o.visible) {
            return false;
        }
        if (radius != o.radius) {
            return false;
        }
        return true;
    }
}