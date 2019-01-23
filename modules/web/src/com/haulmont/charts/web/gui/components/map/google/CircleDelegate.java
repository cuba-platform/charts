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

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.charts.gui.map.model.Circle;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapCircle;

public class CircleDelegate implements Circle {

    protected GoogleMapCircle circle;

    public CircleDelegate(GoogleMapCircle circle) {
        this.circle = circle;
    }

    @Override
    public GeoPoint getCenter() {
        return GeoPointDelegate.fromLatLon(circle.getCenter());
    }

    @Override
    public void setCenter(GeoPoint center) {
        circle.setCenter(center != null ? ((GeoPointDelegate) center).getLatLon() : null);
    }

    @Override
    public boolean isDraggable() {
        return circle.isDraggable();
    }

    @Override
    public void setDraggable(boolean draggable) {
        circle.setDraggable(draggable);
    }

    @Override
    public boolean isEditable() {
        return circle.isEditable();
    }

    @Override
    public void setEditable(boolean editable) {
        circle.setEditable(editable);
    }

    @Override
    public boolean isVisible() {
        return circle.isVisible();
    }

    @Override
    public void setVisible(boolean visible) {
        circle.setVisible(visible);
    }

    @Override
    public boolean isClickable() {
        return circle.isClickable();
    }

    @Override
    public void setClickable(boolean clickable) {
        circle.setClickable(clickable);
    }

    @Override
    public double getRadius() {
        return circle.getRadius();
    }

    @Override
    public void setRadius(double radius) {
        circle.setRadius(radius);
    }

    @Override
    public String getFillColor() {
        return circle.getFillColor();
    }

    @Override
    public void setFillColor(String fillColor) {
        circle.setFillColor(fillColor);
    }

    @Override
    public double getFillOpacity() {
        return circle.getFillOpacity();
    }

    @Override
    public void setFillOpacity(double fillOpacity) {
        circle.setFillOpacity(fillOpacity);
    }

    @Override
    public String getStrokeColor() {
        return circle.getStrokeColor();
    }

    @Override
    public void setStrokeColor(String strokeColor) {
        circle.setStrokeColor(strokeColor);
    }

    @Override
    public double getStrokeOpacity() {
        return circle.getStrokeOpacity();
    }

    @Override
    public void setStrokeOpacity(double strokeOpacity) {
        circle.setStrokeOpacity(strokeOpacity);
    }

    @Override
    public int getStrokeWeight() {
        return circle.getStrokeWeight();
    }

    @Override
    public void setStrokeWeight(int strokeWeight) {
        circle.setStrokeWeight(strokeWeight);
    }

    @Override
    public int getzIndex() {
        return circle.getzIndex();
    }

    @Override
    public void setzIndex(int zIndex) {
        circle.setzIndex(zIndex);
    }

    public GoogleMapCircle getCircle() {
        return circle;
    }

    public void setCircle(GoogleMapCircle circle) {
        this.circle = circle;
    }
}