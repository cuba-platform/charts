/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.List;

/**
 * See documentation for properties of CategoryAxis JS Object.
 *
 * @author artamonov
 * @version $Id$
 */
public class CategoryAxis extends AbstractAxis<CategoryAxis> {

    private static final long serialVersionUID = -8181114623535627249L;

    private Boolean autoWrap;

    private Boolean boldPeriodBeginning;

    private JsFunction categoryFunction;

    private Boolean centerLabelOnFullPeriod;

    private List<DateFormat> dateFormats;

    private Boolean equalSpacing;

    private DayOfWeek firstDayOfWeek;

    private String forceShowField;

    private GridPosition gridPosition;

    private JsFunction labelFunction;

    private Boolean markPeriodChange;

    private DatePeriod minPeriod;

    private Boolean parseDates;

    private Boolean startOnAxis;

    public Boolean getAutoWrap() {
        return autoWrap;
    }

    public CategoryAxis setAutoWrap(Boolean autoWrap) {
        this.autoWrap = autoWrap;
        return this;
    }

    public Boolean getBoldPeriodBeginning() {
        return boldPeriodBeginning;
    }

    public CategoryAxis setBoldPeriodBeginning(Boolean boldPeriodBeginning) {
        this.boldPeriodBeginning = boldPeriodBeginning;
        return this;
    }

    public Boolean getCenterLabelOnFullPeriod() {
        return centerLabelOnFullPeriod;
    }

    public CategoryAxis setCenterLabelOnFullPeriod(Boolean centerLabelOnFullPeriod) {
        this.centerLabelOnFullPeriod = centerLabelOnFullPeriod;
        return this;
    }

    public List<DateFormat> getDateFormats() {
        return dateFormats;
    }

    public CategoryAxis setDateFormats(List<DateFormat> dateFormats) {
        this.dateFormats = dateFormats;
        return this;
    }

    public Boolean getEqualSpacing() {
        return equalSpacing;
    }

    public CategoryAxis setEqualSpacing(Boolean equalSpacing) {
        this.equalSpacing = equalSpacing;
        return this;
    }

    public DayOfWeek getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public CategoryAxis setFirstDayOfWeek(DayOfWeek firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
        return this;
    }

    public String getForceShowField() {
        return forceShowField;
    }

    public CategoryAxis setForceShowField(String forceShowField) {
        this.forceShowField = forceShowField;
        return this;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public CategoryAxis setGridPosition(GridPosition gridPosition) {
        this.gridPosition = gridPosition;
        return this;
    }

    public Boolean getMarkPeriodChange() {
        return markPeriodChange;
    }

    public CategoryAxis setMarkPeriodChange(Boolean markPeriodChange) {
        this.markPeriodChange = markPeriodChange;
        return this;
    }

    public DatePeriod getMinPeriod() {
        return minPeriod;
    }

    public CategoryAxis setMinPeriod(DatePeriod minPeriod) {
        this.minPeriod = minPeriod;
        return this;
    }

    public Boolean getParseDates() {
        return parseDates;
    }

    public CategoryAxis setParseDates(Boolean parseDates) {
        this.parseDates = parseDates;
        return this;
    }

    public Boolean getStartOnAxis() {
        return startOnAxis;
    }

    public CategoryAxis setStartOnAxis(Boolean startOnAxis) {
        this.startOnAxis = startOnAxis;
        return this;
    }

    public JsFunction getCategoryFunction() {
        return categoryFunction;
    }

    public CategoryAxis setCategoryFunction(JsFunction categoryFunction) {
        this.categoryFunction = categoryFunction;
        return this;
    }

    public JsFunction getLabelFunction() {
        return labelFunction;
    }

    public CategoryAxis setLabelFunction(JsFunction labelFunction) {
        this.labelFunction = labelFunction;
        return this;
    }
}