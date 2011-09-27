/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.core.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;

import java.util.List;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@MetaClass(name = "charts$GanttChartGroup")
public class GanttChartGroup extends GanttChartItem {

    private List<GanttChartItem> childItems;

    @MetaProperty
    public List<GanttChartItem> getChildItems() {
        return childItems;
    }

    @MetaProperty
    public void setChildItems(List<GanttChartItem> childItems) {
        this.childItems = childItems;
    }
}