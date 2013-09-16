/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.charts;

import com.haulmont.charts.gui.components.charts.GanttChart;
import com.haulmont.charts.web.toolkit.ui.charts.GanttChartComponent;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.chile.core.model.MetaPropertyPath;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.web.gui.data.CollectionDsWrapper;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public abstract class WebAbstractGanttChart<T extends GanttChartComponent>
        extends WebAbstractChart<T>
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
        Collection<MetaPropertyPath> metaPropertyPaths = new ArrayList<>();
        for (MetaProperty metaProperty : datasource.getMetaClass().getProperties()) {
            metaPropertyPaths.add(datasource.getMetaClass().getPropertyPath(metaProperty.getName()));
        }
        CollectionDsWrapper dsWrapper = new CollectionDsWrapper(datasource, metaPropertyPaths, true);
        component.setContainerDataSource(dsWrapper);
    }
}