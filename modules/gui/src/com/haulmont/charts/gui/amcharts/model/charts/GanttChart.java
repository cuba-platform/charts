/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.amcharts.model.ChartType;
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
public class GanttChart extends AbstractSerialChart<GanttChart> {

    private static final long serialVersionUID = 5489743047811238869L;

    private Integer brightnessStep;

    private String colorField;

    private String columnWidthField;

    private String durationField;

    private String endDateField;

    private String endField;

    private Graph graph;

    private String period;

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

    public Integer getBrightnessStep() {
        return brightnessStep;
    }

    public GanttChart setBrightnessStep(Integer brightnessStep) {
        this.brightnessStep = brightnessStep;
        return this;
    }

    public String getColorField() {
        return colorField;
    }

    public GanttChart setColorField(String colorField) {
        this.colorField = colorField;
        return this;
    }

    public String getColumnWidthField() {
        return columnWidthField;
    }

    public GanttChart setColumnWidthField(String columnWidthField) {
        this.columnWidthField = columnWidthField;
        return this;
    }

    public String getDurationField() {
        return durationField;
    }

    public GanttChart setDurationField(String durationField) {
        this.durationField = durationField;
        return this;
    }

    public String getEndDateField() {
        return endDateField;
    }

    public GanttChart setEndDateField(String endDateField) {
        this.endDateField = endDateField;
        return this;
    }

    public String getEndField() {
        return endField;
    }

    public GanttChart setEndField(String endField) {
        this.endField = endField;
        return this;
    }

    public Graph getGraph() {
        return graph;
    }

    public GanttChart setGraph(Graph graph) {
        this.graph = graph;
        return this;
    }

    public String getPeriod() {
        return period;
    }

    public GanttChart setPeriod(String period) {
        this.period = period;
        return this;
    }

    public String getSegmentsField() {
        return segmentsField;
    }

    public GanttChart setSegmentsField(String segmentsField) {
        this.segmentsField = segmentsField;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public GanttChart setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getStartDateField() {
        return startDateField;
    }

    public GanttChart setStartDateField(String startDateField) {
        this.startDateField = startDateField;
        return this;
    }

    public String getStartField() {
        return startField;
    }

    public GanttChart setStartField(String startField) {
        this.startField = startField;
        return this;
    }

    public ValueAxis getValueAxis() {
        return valueAxis;
    }

    public GanttChart setValueAxis(ValueAxis valueAxis) {
        this.valueAxis = valueAxis;
        return this;
    }

    public List<String> getAdditionalSegmentFields() {
        return additionalSegmentFields;
    }

    public GanttChart setAdditionalSegmentFields(List<String> additionalSegmentFields) {
        this.additionalSegmentFields = additionalSegmentFields;
        return this;
    }

    public GanttChart addAdditionalSegmentFields(String... fields) {
        if (additionalSegmentFields == null) {
            additionalSegmentFields = new ArrayList<>();
        }
        additionalSegmentFields.addAll(Arrays.asList(fields));
        return this;
    }
}
