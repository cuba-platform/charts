/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.web.widgets.amcharts.CubaAmStockChartScene;
import com.vaadin.ui.Component;

import java.util.Date;

public abstract class AbstractStockEventEvent extends Component.Event {

    private static final long serialVersionUID = 275215935877518123L;

    private final String graphId;
    private final Date date;
    private final String stockEventId;

    protected AbstractStockEventEvent(CubaAmStockChartScene scene, String graphId, Date date, String stockEventId) {
        super(scene);
        this.graphId = graphId;
        this.date = date;
        this.stockEventId = stockEventId;
    }

    public String getGraphId() {
        return graphId;
    }

    public Date getDate() {
        return date;
    }

    public String getStockEventId() {
        return stockEventId;
    }
}