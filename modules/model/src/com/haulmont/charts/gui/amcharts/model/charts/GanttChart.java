/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.amcharts.model.ChartType;
import com.haulmont.charts.gui.amcharts.model.DatePeriod;
import com.haulmont.charts.gui.amcharts.model.Graph;
import com.haulmont.charts.gui.amcharts.model.ValueAxis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * See documentation for properties of AmGanttChart JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmGanttChart">http://docs.amcharts.com/3/javascriptcharts/AmGanttChart</a>
 */
public class GanttChart extends AbstractSerialChart<GanttChart> implements GanttChartModel<GanttChart> {

    private static final long serialVersionUID = 5489743047811238869L;

    private Integer brightnessStep;

    private String colorField;

    private String columnWidthField;

    private String durationField;

    private String endDateField;

    private String endField;

    private Graph graph;

    private DatePeriod period;

    private String segmentsField;

    private Date startDate;

    private String startDateField;

    private String startField;

    private ValueAxis valueAxis;

    @Expose(serialize = false, deserialize = false)
    private List<String> additionalSegmentFields;

    public GanttChart() {
        super(ChartType.GANTT);
    }

    @Override
    public Integer getBrightnessStep() {
        return brightnessStep;
    }

    @Override
    public GanttChart setBrightnessStep(Integer brightnessStep) {
        this.brightnessStep = brightnessStep;
        return this;
    }

    @Override
    public String getColorField() {
        return colorField;
    }

    @Override
    public GanttChart setColorField(String colorField) {
        this.colorField = colorField;
        return this;
    }

    @Override
    public String getColumnWidthField() {
        return columnWidthField;
    }

    @Override
    public GanttChart setColumnWidthField(String columnWidthField) {
        this.columnWidthField = columnWidthField;
        return this;
    }

    @Override
    public String getDurationField() {
        return durationField;
    }

    @Override
    public GanttChart setDurationField(String durationField) {
        this.durationField = durationField;
        return this;
    }

    @Override
    public String getEndDateField() {
        return endDateField;
    }

    @Override
    public GanttChart setEndDateField(String endDateField) {
        this.endDateField = endDateField;
        return this;
    }

    @Override
    public String getEndField() {
        return endField;
    }

    @Override
    public GanttChart setEndField(String endField) {
        this.endField = endField;
        return this;
    }

    @Override
    public Graph getGraph() {
        return graph;
    }

    @Override
    public GanttChart setGraph(Graph graph) {
        this.graph = graph;
        return this;
    }

    @Override
    public DatePeriod getPeriod() {
        return period;
    }

    @Override
    public GanttChart setPeriod(DatePeriod period) {
        this.period = period;
        return this;
    }

    @Override
    public String getSegmentsField() {
        return segmentsField;
    }

    @Override
    public GanttChart setSegmentsField(String segmentsField) {
        this.segmentsField = segmentsField;
        return this;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public GanttChart setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public String getStartDateField() {
        return startDateField;
    }

    @Override
    public GanttChart setStartDateField(String startDateField) {
        this.startDateField = startDateField;
        return this;
    }

    @Override
    public String getStartField() {
        return startField;
    }

    @Override
    public GanttChart setStartField(String startField) {
        this.startField = startField;
        return this;
    }

    @Override
    public ValueAxis getValueAxis() {
        return valueAxis;
    }

    @Override
    public GanttChart setValueAxis(ValueAxis valueAxis) {
        this.valueAxis = valueAxis;
        return this;
    }

    @Override
    public List<String> getAdditionalSegmentFields() {
        return additionalSegmentFields;
    }

    @Override
    public GanttChart setAdditionalSegmentFields(List<String> additionalSegmentFields) {
        this.additionalSegmentFields = additionalSegmentFields;
        return this;
    }

    @Override
    public GanttChart addAdditionalSegmentFields(String... fields) {
        if (additionalSegmentFields == null) {
            additionalSegmentFields = new ArrayList<>();
        }
        additionalSegmentFields.addAll(Arrays.asList(fields));
        return this;
    }
}
