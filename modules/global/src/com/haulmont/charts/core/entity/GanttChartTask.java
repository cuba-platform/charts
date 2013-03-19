/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.core.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.annotation.SystemLevel;

import java.util.Date;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@MetaClass(name = "charts$GanttChartTask")
@SystemLevel
public class GanttChartTask extends GanttChartItem {

    protected Date startTs;

    protected Date endTs;

    protected Integer completePercent = 0;

    public GanttChartTask() {
    }

    public GanttChartTask(GanttChartGroup parent) {
        this.parent = parent;
    }

    @MetaProperty
    @Override
    public Date getStartTs() {
        return startTs;
    }

    @MetaProperty
    public void setStartTs(Date startTs) {
        this.startTs = startTs;
    }

    @MetaProperty
    @Override
    public Date getEndTs() {
        return endTs;
    }

    @MetaProperty
    public void setEndTs(Date endTs) {
        this.endTs = endTs;
    }

    @MetaProperty
    @Override
    public Integer getCompletePercent() {
        return completePercent;
    }

    @MetaProperty
    @Override
    public void setCompletePercent(Integer completePercent) {
        this.completePercent = completePercent;
    }
}