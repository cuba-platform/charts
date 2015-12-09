/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import java.io.Serializable;

/**
 * Chart data item.
 *
 * @author artamonov
 * @version $Id$
 */
public interface DataItem extends Serializable {

    Object getValue(String property);
}