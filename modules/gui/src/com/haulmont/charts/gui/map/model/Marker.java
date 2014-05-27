/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model;

/**
 * @author korotkov
 * @version $Id$
 */
public interface Marker {

    long getId();
    void setId(long id);

    GeoPoint getPosition();
    void setPosition(GeoPoint position);

    String getCaption();
    void setCaption(String caption);

    boolean isDraggable();
    void setDraggable(boolean draggable);

    String getIconUrl();
    void setIconUrl(String iconUrl);

    boolean isAnimationEnabled();
    void setAnimationEnabled(boolean animationEnabled);

    boolean isOptimized();
    void setOptimized(boolean optimized);

    boolean isVisible();
    void setVisible(boolean visible);

    boolean isClickable();
    void setClickable(boolean clickable);
}
