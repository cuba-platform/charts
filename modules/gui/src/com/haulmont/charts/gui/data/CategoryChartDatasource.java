/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.data;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import java.util.Collection;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public interface CategoryChartDatasource<T extends Entity<K>, K> extends CollectionDatasource<T, K> {

    Collection<Object> getRowIds();
    Collection<Object> getCategoryIds();

    String getRowCaption(Object rowId);
    String getCategoryCaption(Object categoryId);

    Object getValue(Object rowId, Object categoryId);
}
