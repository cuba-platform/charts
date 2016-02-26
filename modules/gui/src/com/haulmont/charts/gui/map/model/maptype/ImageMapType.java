/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.maptype;

/**
 * @author korotkov
 * @version $Id$
 */
public interface ImageMapType {

    double getOpacity();
    void setOpacity(double opacity);

    double getTileWidth();
    double getTileHeight() ;
    void setTileSize(double tileWidth, double tileHeight);

    int getMinZoom();
    void setMinZoom(int minZoom);

    int getMaxZoom();
    void setMaxZoom(int maxZoom);

    String getTileUrlCallbackFunction();
    void setTileUrlCallbackFunction(String tileUrlCallbackFunction);

    String getMapTypeId();
    void setMapTypeId(String mapTypeId);

    String getName();
    void setName(String name);

    String getAltText();
    void setAltText(String altText);
}
