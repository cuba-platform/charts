/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.data;

import com.haulmont.chile.core.model.MetaClass;

/**
 * Marks the data provider that it uses Entities. Used by default implementations like {@link ContainerDataProvider} and
 * {@link EntityDataProvider} when the chart is loaded from screen layout.
 */
public interface HasMetaClass {

    /**
     * @return entity MetaClass
     */
    MetaClass getMetaClass();
}
