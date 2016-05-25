/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import java.io.Serializable;

/**
 * Listener to data provider item change events.
 */
public interface DataChangeListener extends Serializable {

    /**
     * Enclosed collection changed.
     *
     * @param e event with information about changes of data items
     */
    void dataItemsChanged(DataItemsChangeEvent e);
}
