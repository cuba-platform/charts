/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;

import javax.annotation.Nullable;

public abstract class AbstractLegendItemEvent extends com.vaadin.ui.Component.Event {

    private static final long serialVersionUID = -2258433755537180205L;

    private final int itemIndex;
    private final DataItem dataItem;

    public AbstractLegendItemEvent(CubaAmchartsScene scene, int itemIndex, DataItem dataItem) {
        super(scene);
        this.itemIndex = itemIndex;
        this.dataItem = dataItem;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    @Nullable
    public DataItem getDataItem() {
        return dataItem;
    }

    public DataItem getDataItemNN() {
        if (dataItem == null) {
            throw new IllegalStateException("LegendItemEvent dataItem is null");
        }
        return dataItem;
    }
}