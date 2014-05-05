/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.core.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.annotation.SystemLevel;

import java.util.Date;

/**
 * @author artamonov
 * @version $Id$
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

    @Override
    public Date getStartTs() {
        return startTs;
    }

    @Override
    public void setStartTs(Date startTs) {
        this.startTs = startTs;
    }

    @Override
    public Date getEndTs() {
        return endTs;
    }

    @Override
    public void setEndTs(Date endTs) {
        this.endTs = endTs;
    }

    @Override
    public Integer getCompletePercent() {
        return completePercent;
    }

    @Override
    public void setCompletePercent(Integer completePercent) {
        this.completePercent = completePercent;
    }
}