/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public interface HasMargins<T> {

    Integer getMarginTop();
    T setMarginTop(Integer marginTop);

    Integer getMarginBottom();
    T setMarginBottom(Integer marginBottom);

    Integer getMarginLeft();
    T setMarginLeft(Integer marginLeft);

    Integer getMarginRight();
    T setMarginRight(Integer marginRight);
}