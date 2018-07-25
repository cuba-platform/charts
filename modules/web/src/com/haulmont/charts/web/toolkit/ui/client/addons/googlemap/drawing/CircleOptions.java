/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.drawing;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.LatLon;

import java.io.Serializable;

/**
 * @author korotkov
 * @version $Id$
 */
public class CircleOptions implements Serializable {
    private static final long serialVersionUID = 4632957330407303713L;

    protected LatLon center = null;
    protected Double radius = null;
    protected boolean clickable = true;
    protected boolean editable = false;
    protected String fillColor;
    protected Double fillOpacity;
    protected String strokeColor;
    protected Double strokeOpacity;
    protected Integer strokeWeight;
    protected Integer zIndex;

    public CircleOptions() {
    }

    public CircleOptions(LatLon center, Double radius) {
        this.center = center;
        this.radius = radius;
    }

    public LatLon getCenter() {
        return center;
    }

    public void setCenter(LatLon center) {
        this.center = center;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public Double getFillOpacity() {
        return fillOpacity;
    }

    public void setFillOpacity(Double fillOpacity) {
        this.fillOpacity = fillOpacity;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public Double getStrokeOpacity() {
        return strokeOpacity;
    }

    public void setStrokeOpacity(Double strokeOpacity) {
        this.strokeOpacity = strokeOpacity;
    }

    public Integer getStrokeWeight() {
        return strokeWeight;
    }

    public void setStrokeWeight(Integer strokeWeight) {
        this.strokeWeight = strokeWeight;
    }

    public Integer getZIndex() {
        return zIndex;
    }

    public void setZIndex(Integer zIndex) {
        this.zIndex = zIndex;
    }
}