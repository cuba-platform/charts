/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of CategoryAxis JS Object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/CategoryAxis">http://docs.amcharts.com/3/javascriptcharts/CategoryAxis</a>
 *
 */
public class CategoryAxis extends AbstractAxis<CategoryAxis> {

    private static final long serialVersionUID = -8181114623535627249L;

    private Boolean autoWrap;

    private Boolean boldPeriodBeginning;

    private JsFunction categoryFunction;

    private Boolean centerLabelOnFullPeriod;

    private Boolean equalSpacing;

    private DayOfWeek firstDayOfWeek;

    private String forceShowField;

    private GridPosition gridPosition;

    private String labelColorField;

    private JsFunction labelFunction;

    private Boolean markPeriodChange;

    private DatePeriod minPeriod;

    private Boolean parseDates;

    private Boolean startOnAxis;

    private String tickPosition;

    private Boolean twoLineMode;

    private String widthField;

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

    public String getLabelColorField() {
        return labelColorField;
    }

    public CategoryAxis setLabelColorField(String labelColorField) {
        this.labelColorField = labelColorField;
        return this;
    }

    public String getTickPosition() {
        return tickPosition;
    }

    public CategoryAxis setTickPosition(String tickPosition) {
        this.tickPosition = tickPosition;
        return this;
    }

    public Boolean getTwoLineMode() {
        return twoLineMode;
    }

    public void setTwoLineMode(Boolean twoLineMode) {
        this.twoLineMode = twoLineMode;
    }

    public JsFunction getLabelFunction() {
        return labelFunction;
    }

    public CategoryAxis setLabelFunction(JsFunction labelFunction) {
        this.labelFunction = labelFunction;
        return this;
    }

    public String getWidthField() {
        return widthField;
    }

    public CategoryAxis setWidthField(String widthField) {
        this.widthField = widthField;
        return this;
    }
}