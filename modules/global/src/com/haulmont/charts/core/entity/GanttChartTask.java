/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.core.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;

import java.util.Date;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@MetaClass(name = "charts$GanttTaskItem")
public class GanttChartTask extends GanttChartItem {

    private Date startTs;

    private Date endTs;

    @MetaProperty
    public Date getStartTs() {
        return startTs;
    }

    @MetaProperty
    public void setStartTs(Date startTs) {
        this.startTs = startTs;
    }

    @MetaProperty
    public Date getEndTs() {
        return endTs;
    }

    @MetaProperty
    public void setEndTs(Date endTs) {
        this.endTs = endTs;
    }
}