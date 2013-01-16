/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.gui.data.impl;

import com.haulmont.charts.gui.data.XYChartRowDatasource;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.data.impl.CollectionDatasourceImpl;

/**
 * @author zagumennikov
 * @version $Id$
 */
public abstract class AbstractXYChartRowDatasource<T extends Entity<K>, K>
        extends CollectionDatasourceImpl<T, K>
        implements XYChartRowDatasource<T, K> {

    public void refreshIfNotValid() {
        if (!State.VALID.equals(state)) {
            refresh();
        }
    }
}
