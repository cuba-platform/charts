/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Marker;
import com.haulmont.charts.gui.map.model.base.MarkerImage;
import com.haulmont.charts.web.gui.components.map.google.base.MarkerImageDelegate;
import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.overlays.GoogleMapMarker;

public class MarkerDelegate implements Marker {

    private GoogleMapMarker marker;

    public MarkerDelegate() {
        this.marker = new GoogleMapMarker();
    }

    public MarkerDelegate(GoogleMapMarker marker) {
        Preconditions.checkNotNullArgument(marker);
        this.marker = marker;
    }

    public GoogleMapMarker getMarker() {
        return marker;
    }

    public void setMarker(GoogleMapMarker marker) {
        this.marker = marker;
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
        marker.setPosition(position != null ? ((GeoPointDelegate)position).getLatLon() : null);
    }

    @Override
    public GeoPoint getPosition() {
        return GeoPointDelegate.fromLatLon(marker.getPosition());
    }

    @Override
    public void setIcon(MarkerImage icon) {
        marker.setMarkerImage(icon != null ? ((MarkerImageDelegate)icon).getMarkerImage() : null);
    }

    @Override
    public MarkerImage getIcon() {
        return MarkerImageDelegate.fromMarkerImage(marker.getMarkerImage());
    }

    @Override
    public int hashCode() {
        return marker.hashCode();
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
        MarkerDelegate other = (MarkerDelegate) obj;
        return marker.equals(other.getMarker());
    }
}