/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;
import com.vaadin.ui.Component;

public abstract class AbstractDataSetSelectorEvent extends Component.Event {

    private static final long serialVersionUID = 7847827426042324915L;

    private final String dataSetId;

    protected AbstractDataSetSelectorEvent(CubaAmStockChartScene scene, String dataSetId) {
        super(scene);
        this.dataSetId = dataSetId;
    }

    public String getDataSetId() {
        return dataSetId;
    }
}