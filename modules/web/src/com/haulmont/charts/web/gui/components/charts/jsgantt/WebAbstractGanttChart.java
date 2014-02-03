/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.charts.jsgantt;

import com.haulmont.charts.gui.components.charts.GanttChart;
import com.haulmont.charts.web.toolkit.ui.gantt.GanttChartComponent;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.web.gui.data.CollectionDsWrapper;

/**
 * @author artamonov
 * @version $Id$
 */
public abstract class WebAbstractGanttChart<T extends GanttChartComponent>
        extends WebAbstractBaseGanttChart<T>
        implements GanttChart {

    protected CollectionDatasource datasource;
    protected TaskClickListener taskClickListener;

    @Override
    public TaskClickListener getTaskClickListener() {
        return taskClickListener;
    }

    @Override
    public void setTaskClickListener(TaskClickListener taskClickListener) {
        this.taskClickListener = taskClickListener;
    }

    @Override
    public CollectionDatasource getCollectionDatasource() {
        return datasource;
    }

    @Override
    public void setCollectionDatasource(CollectionDatasource datasource) {
        this.datasource = datasource;
        CollectionDsWrapper dsWrapper = new CollectionDsWrapper(datasource, true);
        component.setContainerDataSource(dsWrapper);
    }
}