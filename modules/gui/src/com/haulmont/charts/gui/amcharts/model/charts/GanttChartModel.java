/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.DatePeriod;
import com.haulmont.charts.gui.amcharts.model.Graph;
import com.haulmont.charts.gui.amcharts.model.ValueAxis;

import java.util.Date;
import java.util.List;

public interface GanttChartModel<T extends GanttChartModel> extends SeriesBasedChartModel<T> {
    Integer getBrightnessStep();
    T setBrightnessStep(Integer brightnessStep);

    String getColorField();
    T setColorField(String colorField);

    String getColumnWidthField();
    T setColumnWidthField(String columnWidthField);

    String getDurationField();
    T setDurationField(String durationField);

    String getEndDateField();
    T setEndDateField(String endDateField);

    String getEndField();
    T setEndField(String endField);

    Graph getGraph();
    T setGraph(Graph graph);

    DatePeriod getPeriod();
    T setPeriod(DatePeriod period);

    String getSegmentsField();
    T setSegmentsField(String segmentsField);

    Date getStartDate();
    T setStartDate(Date startDate);

    String getStartDateField();
    T setStartDateField(String startDateField);

    String getStartField();
    T setStartField(String startField);

    ValueAxis getValueAxis();
    T setValueAxis(ValueAxis valueAxis);

    List<String> getAdditionalSegmentFields();
    T setAdditionalSegmentFields(List<String> additionalSegmentFields);
    T addAdditionalSegmentFields(String... fields);
}