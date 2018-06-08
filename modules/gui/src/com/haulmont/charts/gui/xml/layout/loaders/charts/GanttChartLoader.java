/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.google.common.base.Splitter;
import com.haulmont.bali.util.Dom4j;
import com.haulmont.charts.gui.amcharts.model.DatePeriod;
import com.haulmont.charts.gui.amcharts.model.Graph;
import com.haulmont.charts.gui.amcharts.model.charts.ChartModel;
import com.haulmont.charts.gui.components.charts.GanttChart;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.charts.gui.data.MapDataItem;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

public class GanttChartLoader extends AbstractSerialChartLoader<GanttChart> {

    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(GanttChart.class);
        loadId(resultComponent, element);
    }

    @Override
    protected void loadChartData(ChartModel chart, Element element) {
        Element dataSet = element.element("data");
        if (dataSet != null) {
            ListDataProvider listDataProvider = new ListDataProvider();

            for (Object item : dataSet.elements("item")) {
                Element itemElement = (Element) item;
                MapDataItem dataItem = new MapDataItem();

                for (Element property : Dom4j.elements(itemElement, "property")) {
                    if (property.elements().size() > 0) {
                        List<MapDataItem> innerItems = new ArrayList<>();

                        for (Object innerItem : property.elements("item")) {
                            Element innerItemElement = (Element) innerItem;
                            MapDataItem innerDataItem = new MapDataItem();

                            for (Element innerProperty : Dom4j.elements(innerItemElement, "property")) {
                                innerDataItem = loadDataItem(innerProperty, innerDataItem);
                            }

                            innerItems.add(innerDataItem);
                        }

                        dataItem.add(property.attributeValue("name"), innerItems);
                    } else {
                        dataItem = loadDataItem(property, dataItem);
                    }
                }

                listDataProvider.addItem(dataItem);
                chart.setDataProvider(listDataProvider);
            }
        }
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
            List<String> fields = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(additionalSegmentFields);

            chart.addAdditionalSegmentFields(fields.toArray(new String[fields.size()]));
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
            DatePeriod dp = DatePeriod.fromId(period);
            if (dp == null) {
                dp = DatePeriod.valueOf(period);
            }
            chart.setPeriod(dp);
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