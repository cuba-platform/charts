/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.data;

import java.io.Serializable;

/**
 * Pivot data item
 */
public interface PivotDataItem extends Serializable {

    /**
     * @param property name of property
     * @return the value of a property with the specified property name
     */
    Object getValue(String property);
}