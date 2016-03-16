/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of PeriodSelector JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/PeriodSelector">http://docs.amcharts.com/3/javascriptstockchart/PeriodSelector</a>
 *
 */
public class PeriodSelector extends AbstractChartObject {

    private static final long serialVersionUID = 1614139299608700421L;

    private String dateFormat;

    private String fromText;

    private Boolean hideOutOfScopePeriods;

    private Boolean inputFieldsEnabled;

    private Integer inputFieldWidth;

    private List<Period> periods;

    private String periodsText;

    private Position position;

    private Boolean selectFromStart;

    private String toText;

    private Integer width;

    public String getDateFormat() {
        return dateFormat;
    }

    public PeriodSelector setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public String getFromText() {
        return fromText;
    }

    public PeriodSelector setFromText(String fromText) {
        this.fromText = fromText;
        return this;
    }

    public Boolean getHideOutOfScopePeriods() {
        return hideOutOfScopePeriods;
    }

    public PeriodSelector setHideOutOfScopePeriods(Boolean hideOutOfScopePeriods) {
        this.hideOutOfScopePeriods = hideOutOfScopePeriods;
        return this;
    }

    public Boolean getInputFieldsEnabled() {
        return inputFieldsEnabled;
    }

    public PeriodSelector setInputFieldsEnabled(Boolean inputFieldsEnabled) {
        this.inputFieldsEnabled = inputFieldsEnabled;
        return this;
    }

    public Integer getInputFieldWidth() {
        return inputFieldWidth;
    }

    public PeriodSelector setInputFieldWidth(Integer inputFieldWidth) {
        this.inputFieldWidth = inputFieldWidth;
        return this;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public PeriodSelector setPeriods(List<Period> periods) {
        this.periods = periods;
        return this;
    }

    public PeriodSelector addPeriods(Period... periods) {
        if (periods != null) {
            if (this.periods == null) {
                this.periods = new ArrayList<>();
            }
            this.periods.addAll(Arrays.asList(periods));
        }
        return this;
    }

    public String getPeriodsText() {
        return periodsText;
    }

    public PeriodSelector setPeriodsText(String periodsText) {
        this.periodsText = periodsText;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public PeriodSelector setPosition(Position position) {
        this.position = position;
        return this;
    }

    public Boolean getSelectFromStart() {
        return selectFromStart;
    }

    public PeriodSelector setSelectFromStart(Boolean selectFromStart) {
        this.selectFromStart = selectFromStart;
        return this;
    }

    public String getToText() {
        return toText;
    }

    public PeriodSelector setToText(String toText) {
        this.toText = toText;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public PeriodSelector setWidth(Integer width) {
        this.width = width;
        return this;
    }
}
