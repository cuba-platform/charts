/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.gui.components.charts;

import com.haulmont.charts.gui.components.charts.XYChartRow;
import com.haulmont.charts.gui.data.XYChartRowDatasource;
import com.haulmont.charts.web.toolkit.ui.charts.XYChartRowComponent;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import com.haulmont.cuba.web.gui.data.CollectionDsWrapper;
import com.haulmont.cuba.web.gui.data.DsManager;
import com.vaadin.data.util.IndexedContainer;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public class WebXYChartRow extends WebAbstractComponent<XYChartRowComponent> implements XYChartRow {
    private static final long serialVersionUID = -4577453731402343518L;

    protected CollectionDatasource datasource;

    public WebXYChartRow() {
        component = new XYChartRowComponent();
    }

    @Override
    public CollectionDatasource getCollectionDatasource() {
        return datasource;
    }

    @Override
    public void setCollectionDatasource(CollectionDatasource datasource) {
        this.datasource = datasource;

        if (datasource instanceof XYChartRowDatasource) {
            final XYChartRowDatasource xyChartRowDatasource = (XYChartRowDatasource) datasource;

            component.setContainerDataSource(new IndexedContainer());

            Object xPropertyId = new Object(), yPropertyId = new Object();

            component.addProperty(xPropertyId);
            component.addProperty(yPropertyId);

            component.setXPropertyId(xPropertyId);
            component.setYPropertyId(yPropertyId);

            for (final Object pointId : xyChartRowDatasource.getPointIds()) {
                component.addPoint(pointId);
                component.setXValue(pointId, xyChartRowDatasource.getXValue(pointId));
                component.setYValue(pointId, xyChartRowDatasource.getYValue(pointId));
            }
        } else {
            DsManager dsManager = new DsManager(datasource, this);

            CollectionDsWrapper dsWrapper = new CollectionDsWrapper(datasource, true, dsManager);

            component.setContainerDataSource(dsWrapper);
        }
    }

    @Override
    public String getCaption() {
        return component.getCaption();
    }

    @Override
    public void setCaption(String caption) {
        component.setCaption(caption);
    }

    @Override
    public Object getXProperty() {
        return component.getXPropertyId();
    }

    @Override
    public void setXProperty(Object property) {
        component.setXPropertyId(property);
    }

    @Override
    public Object getYProperty() {
        return component.getYPropertyId();
    }

    @Override
    public void setYProperty(Object property) {
        component.setYPropertyId(property);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String description) {
    }
}