/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;

/**
 * @author gorelov
 * @version $Id$
 */
public class DataSetSelectorSelectEvent extends AbstractDataSetSelectorEvent {
    public DataSetSelectorSelectEvent(CubaAmStockChartScene scene, String dataSetId) {
        super(scene, dataSetId);
    }
}
