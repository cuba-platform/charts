/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.directions;

/**
 * @author korotkov
 * @version $Id$
 */
public interface Distance {
    String getText();

    void setText(String text);

    int getValue();

    void setValue(int value);
}
