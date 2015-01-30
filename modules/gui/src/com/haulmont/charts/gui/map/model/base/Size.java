/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.base;

/**
 * Two-dimensional size, where width is the distance on the x-axis, and height is the distance on the y-axis.
 *
 * @author korotkov
 * @version $Id$
 */
public interface Size {
    double getWidth();

    void setWidth(double width);

    double getHeight();

    void setHeight(double height);
}
