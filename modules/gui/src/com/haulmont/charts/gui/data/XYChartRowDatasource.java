/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.data;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import java.util.Collection;

/**
 * @author zagumennikov
 * @version $Id$
 */
public interface XYChartRowDatasource<T extends Entity<K>, K> extends CollectionDatasource<T, K> {

    Collection<Object> getPointIds();

    Object getXValue(Object pointId);
    Object getYValue(Object pointId);
}
