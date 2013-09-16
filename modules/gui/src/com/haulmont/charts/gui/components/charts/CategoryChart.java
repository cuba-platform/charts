/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.cuba.gui.data.CollectionDatasource;

import java.util.Collection;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public interface CategoryChart extends Chart, Chart.HasLegend {

    CollectionDatasource getCollectionDatasource();
    void setCollectionDatasource(CollectionDatasource datasource);

    String getRowCaption(Object id);

    Object getRowCaptionProperty();
    void setRowCaptionProperty(Object property);

    Collection<?> getCategoryProperties();
    void addCategory(Object property, String caption);

    String getCategoryCaption(Object property);
}