/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.haulmont.cuba.core.entity.Entity;

/**
 * Chart data item, which contains an instance of an {@link Entity}.
 *
 * @deprecated use {@link com.haulmont.charts.gui.data.EntityDataItem} instead
 */
@Deprecated
public class EntityDataItem extends com.haulmont.charts.gui.data.EntityDataItem {

    private static final long serialVersionUID = -2703129637028051748L;

    public EntityDataItem(Entity item) {
        super(item);
    }
}
