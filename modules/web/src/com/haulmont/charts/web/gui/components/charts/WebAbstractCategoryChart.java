/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.gui.components.charts;

import com.haulmont.charts.gui.components.charts.CategoryChart;
import com.haulmont.charts.gui.data.CategoryChartDatasource;
import com.haulmont.charts.web.toolkit.ui.charts.CategoryChartComponent;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.web.gui.data.CollectionDsWrapper;
import com.haulmont.cuba.web.gui.data.DsManager;
import com.vaadin.data.util.IndexedContainer;

import java.util.Collection;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public abstract class WebAbstractCategoryChart<T extends CategoryChartComponent>
        extends WebAbstractChart<T>
        implements CategoryChart {

    private static final long serialVersionUID = 8120229914290249619L;

    protected CollectionDatasource datasource;

    @Override
    public CollectionDatasource getCollectionDatasource() {
        return datasource;
    }

    @Override
    public void setCollectionDatasource(CollectionDatasource datasource) {
        this.datasource = datasource;

        if (datasource instanceof CategoryChartDatasource) {
            final CategoryChartDatasource categoryChartDatasource = (CategoryChartDatasource) datasource;

            component.setContainerDataSource(new IndexedContainer());

            Object rowCaptionPropertyId = new Object();
            component.addProperty(rowCaptionPropertyId);
            component.setRowCaptionPropertyId(rowCaptionPropertyId);

            for (final Object categoryId : categoryChartDatasource.getCategoryIds()) {
                component.addProperty(categoryId);
                component.addCategory(categoryId, categoryChartDatasource.getCategoryCaption(categoryId));
            }

            for (final Object rowId : categoryChartDatasource.getRowIds()) {
                component.addRow(rowId, categoryChartDatasource.getRowCaption(rowId));

                for (final Object categoryId : categoryChartDatasource.getCategoryIds()) {
                    component.setValue(rowId, categoryId, categoryChartDatasource.getValue(rowId, categoryId));
                }
            }

        } else {
            DsManager dsManager = new DsManager(datasource, this);

            CollectionDsWrapper dsWrapper = new CollectionDsWrapper(datasource, true, dsManager);

            component.setContainerDataSource(dsWrapper);
        }
    }

    @Override
    public String getRowCaption(Object id) {
        return component.getRowCaption(id);
    }

    @Override
    public Object getRowCaptionProperty() {
        return component.getRowCaptionPropertyId();
    }

    @Override
    public void setRowCaptionProperty(Object property) {
        component.setRowCaptionPropertyId(property);
    }

    @Override
    public boolean getHasLegend() {
        return component.getHasLegend();
    }

    @Override
    public void setHasLegend(boolean needLegend) {
        component.setHasLegend(needLegend);
    }

    @Override
    public Collection<?> getCategoryProperties() {
        return component.getCategoryPropertyIds();
    }

    @Override
    public void addCategory(Object property, String caption) {
        component.addCategory(property, caption);
    }

    @Override
    public String getCategoryCaption(Object property) {
        return component.getCategoryCaption(property);
    }
}