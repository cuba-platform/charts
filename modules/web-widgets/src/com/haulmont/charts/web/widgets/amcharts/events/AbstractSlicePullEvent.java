/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;

public abstract class AbstractSlicePullEvent extends com.vaadin.ui.Component.Event {

    private static final long serialVersionUID = -3625204689056222328L;

    private final DataItem dataItem;

    public AbstractSlicePullEvent(CubaAmchartsScene scene, DataItem dataItem) {
        super(scene);
        this.dataItem = dataItem;
    }

    public DataItem getDataItem() {
        return dataItem;
    }
}