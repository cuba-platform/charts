/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;
import com.vaadin.ui.Component;

import java.util.Date;

public class PeriodSelectorChangeEvent extends Component.Event {

    private static final long serialVersionUID = -8827566480577154901L;

    private final Date startDate;
    private final Date endDate;

    private final String predefinedPeriod;
    private final Integer count;

    private final int x;
    private final int y;
    private final int absoluteX;
    private final int absoluteY;

    public PeriodSelectorChangeEvent(CubaAmStockChartScene scene, Date startDate, Date endDate, String predefinedPeriod,
                                     Integer count, int x, int y, int absoluteX, int absoluteY) {
        super(scene);
        this.startDate = startDate;
        this.endDate = endDate;
        this.predefinedPeriod = predefinedPeriod;
        this.count = count;
        this.x = x;
        this.y = y;
        this.absoluteX = absoluteX;
        this.absoluteY = absoluteY;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getPredefinedPeriod() {
        return predefinedPeriod;
    }

    public Integer getCount() {
        return count;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAbsoluteX() {
        return absoluteX;
    }

    public int getAbsoluteY() {
        return absoluteY;
    }
}