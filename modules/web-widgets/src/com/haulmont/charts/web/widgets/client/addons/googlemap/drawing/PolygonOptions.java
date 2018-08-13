/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.drawing;

import java.io.Serializable;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public class PolygonOptions implements Serializable {

    private static final long serialVersionUID = -1836882536005952265L;

    protected boolean clickable = true;
    protected boolean editable = false;
    protected String fillColor;
    protected Double fillOpacity;
    protected boolean geodesic = false;
    protected String strokeColor;
    protected Double strokeOpacity;
    protected Integer strokeWeight;
    protected boolean visible = true;
    protected Integer zIndex;

    public PolygonOptions() {
    }

    public PolygonOptions(boolean clickable, boolean editable, String fillColor, Double fillOpacity) {
        this.clickable = clickable;
        this.editable = editable;
        this.fillColor = fillColor;
        this.fillOpacity = fillOpacity;
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

    public boolean isGeodesic() {
        return geodesic;
    }

    public void setGeodesic(boolean geodesic) {
        this.geodesic = geodesic;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Integer  getZIndex() {
        return zIndex;
    }

    public void setZIndex(Integer  zIndex) {
        this.zIndex = zIndex;
    }
}