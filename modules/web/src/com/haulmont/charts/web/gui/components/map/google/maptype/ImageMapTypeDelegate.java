/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.maptype;

import com.haulmont.charts.gui.map.model.maptype.ImageMapType;
import com.haulmont.charts.web.widgets.client.addons.googlemap.base.Size;
import com.haulmont.charts.web.widgets.client.addons.googlemap.maptypes.GoogleImageMapType;

public class ImageMapTypeDelegate implements ImageMapType {
    protected GoogleImageMapType mapType;

    public ImageMapTypeDelegate() {
        mapType = new GoogleImageMapType();
    }

    public ImageMapTypeDelegate(GoogleImageMapType mapType) {
        this.mapType = mapType;
    }

    public ImageMapTypeDelegate(String mapTypeId) {
        this();
        mapType.setMapTypeId(mapTypeId);
    }

    public ImageMapTypeDelegate(String mapTypeId, String tileUrlCallbackJsFunction) {
        this(mapTypeId);
        mapType.setTileUrlCallbackFunction(tileUrlCallbackJsFunction);
    }

    public ImageMapTypeDelegate(String mapTypeId, String name, String tileUrlCallbackJsFunction) {
        this(mapTypeId, tileUrlCallbackJsFunction);
        mapType.setName(name);
    }

    public GoogleImageMapType getMapType() {
        return mapType;
    }

    @Override
    public void setMapTypeId(String mapTypeId) {
        mapType.setMapTypeId(mapTypeId);
    }

    @Override
    public double getOpacity() {
        return mapType.getOpacity();
    }

    @Override
    public void setOpacity(double opacity) {
        mapType.setOpacity(opacity);
    }

    @Override
    public double getTileWidth() {
        return mapType.getTileSize() != null ? mapType.getTileSize().getWidth() : 0;
    }

    @Override
    public double getTileHeight() {
        return mapType.getTileSize() != null ? mapType.getTileSize().getHeight() : 0;
    }

    @Override
    public void setTileSize(double tileWidth, double tileHeight) {
        mapType.setTileSize(new Size(tileWidth, tileHeight));
    }

    @Override
    public String getName() {
        return mapType.getName();
    }

    @Override
    public void setName(String name) {
        mapType.setName(name);
    }

    @Override
    public int getMinZoom() {
        return mapType.getMinZoom();
    }

    @Override
    public void setMinZoom(int minZoom) {
        mapType.setMinZoom(minZoom);
    }

    @Override
    public int getMaxZoom() {
        return mapType.getMaxZoom();
    }

    @Override
    public void setMaxZoom(int maxZoom) {
        mapType.setMaxZoom(maxZoom);
    }

    @Override
    public String getTileUrlCallbackFunction() {
        return mapType.getTileUrlCallbackFunction();
    }

    @Override
    public void setTileUrlCallbackFunction(String tileUrlCallbackFunction) {
        mapType.setTileUrlCallbackFunction(tileUrlCallbackFunction);
    }

    @Override
    public String getAltText() {
        return mapType.getAltText();
    }

    @Override
    public void setAltText(String altText) {
        mapType.setAltText(altText);
    }

    @Override
    public String getMapTypeId() {
        return mapType.getMapTypeId();
    }
}