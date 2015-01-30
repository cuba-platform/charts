/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.base;

/**
 * A point on a two-dimensional plane
 *
 * @author korotkov
 * @version $Id$
 */
public interface Point {
    double getX();

    void setX(double x);

    double getY();

    void setY(double y);
}
