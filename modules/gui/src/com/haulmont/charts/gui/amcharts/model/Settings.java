/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.List;

/**
 * See documentation for properties of AmCharts JS Object.
 *
 * @author artamonov
 * @version $Id$
 */
public class Settings extends AbstractConfigurationObject {

    private static final long serialVersionUID = 8224937687234516612L;

    private ChartTheme theme;

    private Boolean baseHref;

    private List<String> dayNames;

    private List<String> monthNames;

    private List<String> shortDayNames;

    private List<String> shortMonthNames;

    private Boolean useUTC;

    public Boolean getBaseHref() {
        return baseHref;
    }

    public Settings setBaseHref(Boolean baseHref) {
        this.baseHref = baseHref;
        return this;
    }

    public List<String> getDayNames() {
        return dayNames;
    }

    public Settings setDayNames(List<String> dayNames) {
        this.dayNames = dayNames;
        return this;
    }

    public List<String> getMonthNames() {
        return monthNames;
    }

    public Settings setMonthNames(List<String> monthNames) {
        this.monthNames = monthNames;
        return this;
    }

    public List<String> getShortDayNames() {
        return shortDayNames;
    }

    public Settings setShortDayNames(List<String> shortDayNames) {
        this.shortDayNames = shortDayNames;
        return this;
    }

    public List<String> getShortMonthNames() {
        return shortMonthNames;
    }

    public Settings setShortMonthNames(List<String> shortMonthNames) {
        this.shortMonthNames = shortMonthNames;
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
}