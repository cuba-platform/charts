/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of AmCharts JS Object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmCharts">http://docs.amcharts.com/3/javascriptcharts/AmCharts</a>
 */
public class Settings extends AbstractChartObject {

    private static final long serialVersionUID = 8224937687234516612L;

    private ChartTheme theme;

    private Boolean baseHref;

    private Integer bezierX;

    private Integer bezierY;

    private Integer processDelay;

    private Boolean useUTC;

    public Boolean getBaseHref() {
        return baseHref;
    }

    public Settings setBaseHref(Boolean baseHref) {
        this.baseHref = baseHref;
        return this;
    }

    public ChartTheme getTheme() {
        return theme;
    }

    public Settings setTheme(ChartTheme theme) {
        this.theme = theme;
        return this;
    }

    public Boolean getUseUTC() {
        return useUTC;
    }

    public Settings setUseUTC(Boolean useUTC) {
        this.useUTC = useUTC;
        return this;
    }

    public Integer getProcessDelay() {
        return processDelay;
    }

    public Settings setProcessDelay(Integer processDelay) {
        this.processDelay = processDelay;
        return this;
    }

    public Integer getBezierX() {
        return bezierX;
    }

    public Settings setBezierX(Integer bezierX) {
        this.bezierX = bezierX;
        return this;
    }

    public Integer getBezierY() {
        return bezierY;
    }

    public Settings setBezierY(Integer bezierY) {
        this.bezierY = bezierY;
        return this;
    }
}