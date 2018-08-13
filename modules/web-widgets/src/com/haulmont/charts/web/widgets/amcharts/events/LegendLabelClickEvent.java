/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;

public class LegendLabelClickEvent extends AbstractLegendItemEvent {

    private static final long serialVersionUID = -536343761071370040L;

    public LegendLabelClickEvent(CubaAmchartsScene scene, int itemIndex, DataItem dataItem) {
        super(scene, itemIndex, dataItem);
    }
}