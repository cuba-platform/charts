/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.haulmont.cuba.gui.data.CollectionDatasource;

/**
 * Data provider which contains {@link CollectionDatasource} with items.
 *
 * @deprecated use {@link com.haulmont.charts.gui.data.EntityDataProvider} instead
 */
@Deprecated
public class EntityDataProvider extends com.haulmont.charts.gui.data.EntityDataProvider {

    private static final long serialVersionUID = -631516572260683521L;

    public EntityDataProvider(CollectionDatasource datasource) {
        super(datasource);
    }
}