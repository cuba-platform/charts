/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of PeriodSelector JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/PeriodSelector">http://docs.amcharts.com/3/javascriptstockchart/PeriodSelector</a>
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

    /**
     * @return date format of date input fields
     */
    public String getDateFormat() {
        return dateFormat;
    }

    /**
     * Sets date format of date input fields. Note, only numeric date formats are allowed, so don't use "MMM" or "MMMM"
     * month format, two-digit years "YY" is NOT supported in this setting.
     *
     * @param dateFormat date format string
     */
    public PeriodSelector setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    /**
     * @return from text
     */
    public String getFromText() {
        return fromText;
    }

    /**
     * Sets text displayed next to "from" date input field.
     *
     * @param fromText from text
     */
    public PeriodSelector setFromText(String fromText) {
        this.fromText = fromText;
        return this;
    }

    /**
     * @return true if period buttons with date range bigger than available data are hidden
     */
    public Boolean getHideOutOfScopePeriods() {
        return hideOutOfScopePeriods;
    }

    /**
     * Set hideOutOfScopePeriods to false if period buttons with date range bigger than available data shouldn't be
     * hidden.
     *
     * @param hideOutOfScopePeriods hideOutOfScopePeriods option
     */
    public PeriodSelector setHideOutOfScopePeriods(Boolean hideOutOfScopePeriods) {
        this.hideOutOfScopePeriods = hideOutOfScopePeriods;
        return this;
    }

    /**
     * @return true if period selector displays "from" and "to" date input fields
     */
    public Boolean getInputFieldsEnabled() {
        return inputFieldsEnabled;
    }

    /**
     * Set inputFieldsEnabled to false if period selector shouldn't display "from" and "to" date input fields.
     *
     * @param inputFieldsEnabled inputFieldsEnabled option
     */
    public PeriodSelector setInputFieldsEnabled(Boolean inputFieldsEnabled) {
        this.inputFieldsEnabled = inputFieldsEnabled;
        return this;
    }

    /**
     * @return width of date input fields, in pixels
     */
    public Integer getInputFieldWidth() {
        return inputFieldWidth;
    }

    /**
     * Sets width of date input fields, in pixels. Works only if period selector is horizontal.
     *
     * @param inputFieldWidth width
     */
    public PeriodSelector setInputFieldWidth(Integer inputFieldWidth) {
        this.inputFieldWidth = inputFieldWidth;
        return this;
    }

    /**
     * @return list of periods
     */
    public List<Period> getPeriods() {
        return periods;
    }

    /**
     * Sets list of predefined periods.
     *
     * @param periods list of periods
     */
    public PeriodSelector setPeriods(List<Period> periods) {
        this.periods = periods;
        return this;
    }

    /**
     * Adds periods.
     *
     * @param periods periods
     */
    public PeriodSelector addPeriods(Period... periods) {
        if (periods != null) {
            if (this.periods == null) {
                this.periods = new ArrayList<>();
            }
            this.periods.addAll(Arrays.asList(periods));
        }
        return this;
    }

    /**
     * @return text displayed next to predefined period buttons
     */
    public String getPeriodsText() {
        return periodsText;
    }

    /**
     * Sets text displayed next to predefined period buttons.
     *
     * @param periodsText periods text
     */
    public PeriodSelector setPeriodsText(String periodsText) {
        this.periodsText = periodsText;
        return this;
    }

    /**
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position position
     */
    public PeriodSelector setPosition(Position position) {
        this.position = position;
        return this;
    }

    /**
     * @return true if predefined period buttons select a period from the beginning
     */
    public Boolean getSelectFromStart() {
        return selectFromStart;
    }

    /**
     * Set selectFromStart to true if predefined period buttons should select a period from the beginning.
     *
     * @param selectFromStart selectFromStart option
     */
    public PeriodSelector setSelectFromStart(Boolean selectFromStart) {
        this.selectFromStart = selectFromStart;
        return this;
    }

    /**
     * @return text displayed next to "to" date input field
     */
    public String getToText() {
        return toText;
    }

    /**
     * Sets text displayed next to "to" date input field.
     *
     * @param toText text
     */
    public PeriodSelector setToText(String toText) {
        this.toText = toText;
        return this;
    }

    /**
     * @return width of a period selector
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets width of a period selector, when position is "left" or "right".
     *
     * @param width width
     */
    public PeriodSelector setWidth(Integer width) {
        this.width = width;
        return this;
    }
}
