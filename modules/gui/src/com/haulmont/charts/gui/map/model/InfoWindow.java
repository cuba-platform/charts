/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model;

/**
 * @author korotkov
 * @version $Id$
 */
public interface InfoWindow {

    long getId();
    void setId(long id);

    String getContent();
    void setContent(String content);

    void setWidth(String width);
    String getWidth();

    void setHeight(String height);
    String getHeight();

    Integer getMaxWidth();
    void setMaxWidth(Integer maxWidth);

    Integer getPixelOffsetWidth();
    void setPixelOffsetWidth(Integer pixelOffsetWidth);

    Integer getPixelOffsetHeight();
    void setPixelOffsetHeight(Integer pixelOffsetHeight);

    Integer getZIndex();
    void setZIndex(Integer zIndex);

    GeoPoint getPosition();
    void setPosition(GeoPoint position);

    Marker getAnchorMarker();
    void setAnchorMarker(Marker anchorMarker);

    boolean isAutoPanDisabled();
    void setAutoPanDisabled(boolean autoPanDisabled);
}
