/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.List;

/**
 * @author artamonov
 * @version $Id$
 */
public interface HasColors<T> {

    List<Color> getColors();
    T setColors(List<Color> colors);
}