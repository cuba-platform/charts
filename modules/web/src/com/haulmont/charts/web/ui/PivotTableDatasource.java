/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.ui;

import com.haulmont.cuba.core.entity.KeyValueEntity;
import com.haulmont.cuba.gui.data.impl.CustomValueCollectionDatasource;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class PivotTableDatasource extends CustomValueCollectionDatasource {

    public static final String VALUES_PARAM = "values";

    @Override
    @SuppressWarnings("unchecked")
    protected Collection<KeyValueEntity> getEntities(Map<String, Object> params) {
        return (Collection<KeyValueEntity>) params.getOrDefault(VALUES_PARAM, Collections.emptyList());
    }
}
