/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.Graph;
import com.haulmont.charts.gui.amcharts.model.charts.GanttChart;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 */
public class GanttChartLoader extends AbstractSerialChartLoader<GanttChart> {

    @Override
    protected GanttChart createConfiguration() {
        return new GanttChart();
    }

    @Override
    protected void loadConfiguration(GanttChart chart, Element element) {
        super.loadConfiguration(chart, element);

        Element valueAxisElement = element.element("valueAxis");
        if (valueAxisElement != null) {
            chart.setValueAxis(loadValueAxis(valueAxisElement));
        }

        Element graphElement = element.element("graph");
        if (graphElement != null) {
            Graph graph = new Graph();
            loadGraph(graph, graphElement);
            chart.setGraph(graph);
        }

        String additionalSegmentFields = element.attributeValue("additionalSegmentFields");
        if (StringUtils.isNotEmpty(additionalSegmentFields)) {
            chart.addAdditionalSegmentFields(additionalSegmentFields.split(","));
        }

        String brightnessStep = element.attributeValue("brightnessStep");
        if (StringUtils.isNotEmpty(brightnessStep)) {
            chart.setBrightnessStep(Integer.valueOf(brightnessStep));
        }

        String colorField = element.attributeValue("colorField");
        if (StringUtils.isNotEmpty(colorField)) {
            chart.setColorField(colorField);
        }

        String columnWidthField = element.attributeValue("columnWidthField");
        if (StringUtils.isNotEmpty(columnWidthField)) {
            chart.setColumnWidthField(columnWidthField);
        }

        String durationField = element.attributeValue("durationField");
        if (StringUtils.isNotEmpty(durationField)) {
            chart.setDurationField(durationField);
        }

        String endDate = element.attributeValue("endDate");
        if (StringUtils.isNotEmpty(endDate)) {
            chart.setEndDate(loadDate(endDate));
        }

        String endDateField = element.attributeValue("endDateField");
        if (StringUtils.isNotEmpty(endDateField)) {
            chart.setEndDateField(endDateField);
        }

        String endField = element.attributeValue("endField");
        if (StringUtils.isNotEmpty(endField)) {
            chart.setEndField(endField);
        }

        String period = element.attributeValue("period");
        if (StringUtils.isNotEmpty(period)) {
            chart.setPeriod(period);
        }

        String segmentsField = element.attributeValue("segmentsField");
        if (StringUtils.isNotEmpty(segmentsField)) {
            chart.setSegmentsField(segmentsField);
        }

        String startDate = element.attributeValue("startDate");
        if (StringUtils.isNotEmpty(startDate)) {
            chart.setStartDate(loadDate(startDate));
        }

        String startDateField = element.attributeValue("startDateField");
        if (StringUtils.isNotEmpty(startDateField)) {
            chart.setStartDateField(startDateField);
        }

        String startField = element.attributeValue("startField");
        if (StringUtils.isNotEmpty(startField)) {
            chart.setStartField(startField);
        }
    }
}
