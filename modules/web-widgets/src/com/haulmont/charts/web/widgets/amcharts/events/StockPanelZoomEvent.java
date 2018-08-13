/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.web.widgets.amcharts.CubaAmStockChartScene;
import com.vaadin.ui.Component;

import java.util.Date;

public class StockPanelZoomEvent extends Component.Event {

    private static final long serialVersionUID = -8555462390239325142L;

    private final Date startDate;
    private final Date endDate;
    private final String period;

    public StockPanelZoomEvent(CubaAmStockChartScene scene, Date startDate, Date endDate, String period) {
        super(scene);
        this.startDate = startDate;
        this.endDate = endDate;
        this.period = period;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getPeriod() {
        return period;
    }
}
