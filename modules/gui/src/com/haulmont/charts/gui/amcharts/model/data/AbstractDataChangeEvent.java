/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import java.io.Serializable;

/**
 * @author gorelov
 * @version $Id$
 */
public class AbstractDataChangeEvent implements Serializable {

    private final DataItem item;

    public AbstractDataChangeEvent(DataItem item) {
        this.item = item;
    }

    public DataItem getItem() {
        return item;
    }
}
