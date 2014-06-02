/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Marker;
import com.vaadin.tapio.googlemaps.client.overlays.*;

/**
 * @author korotkov
 * @version $Id$
 */
public class MarkerDelegate implements Marker {

    private GoogleMapMarker marker;

    public MarkerDelegate() {
        this.marker = new GoogleMapMarker();
    }

    public MarkerDelegate(GoogleMapMarker marker) {
        this.marker = marker;
    }

    public GoogleMapMarker getMarker() {
        return marker;
    }

    public void setMarker(GoogleMapMarker marker) {
        this.marker = marker;
    }

    @Override
    public void setId(long id) {
        marker.setId(id);
    }

    @Override
    public long getId() {
        return marker.getId();
    }

    @Override
    public void setOptimized(boolean optimized) {
        marker.setOptimized(optimized);
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public void setVisible(boolean visible) {
        //nothing
    }

    @Override
    public boolean isClickable() {
        return true;
    }

    @Override
    public void setClickable(boolean clickable) {
        //nothing
    }

    @Override
    public boolean isOptimized() {
        return marker.isOptimized();
    }

    @Override
    public void setAnimationEnabled(boolean animationEnabled) {
        marker.setAnimationEnabled(animationEnabled);
    }

    @Override
    public boolean isAnimationEnabled() {
        return marker.isAnimationEnabled();
    }

    @Override
    public void setIconUrl(String iconUrl) {
        marker.setIconUrl(iconUrl);
    }

    @Override
    public String getIconUrl() {
        return marker.getIconUrl();
    }

    @Override
    public void setDraggable(boolean draggable) {
        marker.setDraggable(draggable);
    }

    @Override
    public boolean isDraggable() {
        return marker.isDraggable();
    }

    @Override
    public void setCaption(String caption) {
        marker.setCaption(caption);
    }

    @Override
    public String getCaption() {
        return marker.getCaption();
    }

    @Override
    public void setPosition(GeoPoint position) {
        marker.setPosition(((GeoPointDelegate)position).getLatLon());
    }

    @Override
    public GeoPoint getPosition() {
        return new GeoPointDelegate(marker.getPosition());
    }
}
