/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.maptypes;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.Size;

import java.io.Serializable;

/**
 * @author korotkov
 * @version $Id$
 */
public class GoogleImageMapType implements Serializable {

    private static final long serialVersionUID = 452356543641L;

    private static long idCounter = 0;

    private long id;

    //map type which should appear on top of normal map instead of being separate map type
    protected boolean isOverlayMapType = false;
    protected int overlayMapTypePosition = 0;

    protected double opacity = 1.0;
    protected Size tileSize = new Size(256, 256);
    protected int minZoom = 1;
    protected int maxZoom = 20;
    //    protected GoogleTileUrlCallback tileUrlCallback;
    protected String tileUrlCallbackFunction;

    //used in setting control options. Required if this is not an overlay map type
    protected String mapTypeId;
    //could be null for overlay map type
    protected String name;
    protected String altText;

    public GoogleImageMapType() {
        id = idCounter;
        idCounter++;
    }

    public GoogleImageMapType(String name, String tileUrlCallbackFunction) {
        this.name = name;
        this.tileUrlCallbackFunction = tileUrlCallbackFunction;
    }

    public GoogleImageMapType(double opacity, String tileUrlCallbackFunction) {
        this.opacity = opacity;
        this.tileUrlCallbackFunction = tileUrlCallbackFunction;
    }

    public boolean isOverlayMapType() {
        return isOverlayMapType;
    }

    public void setOverlayMapType(boolean overlayMapType) {
        isOverlayMapType = overlayMapType;
    }

    public int getOverlayMapTypePosition() {
        return overlayMapTypePosition;
    }

    public void setOverlayMapTypePosition(int overlayMapTypePosition) {
        this.overlayMapTypePosition = overlayMapTypePosition;
    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    public Size getTileSize() {
        return tileSize;
    }

    public void setTileSize(Size tileSize) {
        this.tileSize = tileSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinZoom() {
        return minZoom;
    }

    public void setMinZoom(int minZoom) {
        this.minZoom = minZoom;
    }

    public int getMaxZoom() {
        return maxZoom;
    }

    public void setMaxZoom(int maxZoom) {
        this.maxZoom = maxZoom;
    }

    public String getTileUrlCallbackFunction() {
        return tileUrlCallbackFunction;
    }

    public void setTileUrlCallbackFunction(String tileUrlCallbackFunction) {
        this.tileUrlCallbackFunction = tileUrlCallbackFunction;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getMapTypeId() {
        return mapTypeId;
    }

    public void setMapTypeId(String mapTypeId) {
        this.mapTypeId = mapTypeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        GoogleImageMapType other = (GoogleImageMapType) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
}