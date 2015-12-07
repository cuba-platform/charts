/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;
import com.vaadin.ui.Component;

/**
 * @author gorelov
 * @version $Id$
 */
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
