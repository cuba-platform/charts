/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.core.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.cuba.core.entity.annotation.SystemLevel;

import java.util.Date;
import java.util.List;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@MetaClass(name = "charts$GanttChartGroup")
@SystemLevel
public class GanttChartGroup extends GanttChartItem {

    private List<GanttChartItem> childItems;

    public List<GanttChartItem> getChildItems() {
        return childItems;
    }

    public void setChildItems(List<GanttChartItem> childItems) {
        this.childItems = childItems;
    }

    @Override
    public Date getStartTs() {
        if (childItems != null) {
            Date minDate = null;
            for (GanttChartItem chartItem : childItems) {
                Date date = chartItem.getStartTs();
                if (minDate == null)
                    minDate = date;
                if ((date != null) && (date.compareTo(minDate) == -1)) {
                    minDate = date;
                }
            }
            return minDate;
        } else
            return super.getStartTs();
    }

    @Override
    public Date getEndTs() {
        if (childItems != null) {
            Date maxDate = null;
            for (GanttChartItem chartItem : childItems) {
                Date date = chartItem.getEndTs();
                if (maxDate == null)
                    maxDate = date;
                if ((date != null) && (date.compareTo(maxDate) == 1)) {
                    maxDate = date;
                }
            }
            return maxDate;
        } else
            return super.getEndTs();
    }
}