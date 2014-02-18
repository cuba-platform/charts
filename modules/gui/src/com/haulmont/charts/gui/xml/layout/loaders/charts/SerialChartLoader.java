/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.CategoryAxis;
import com.haulmont.charts.gui.amcharts.model.DatePeriod;
import com.haulmont.charts.gui.amcharts.model.GridPosition;
import com.haulmont.charts.gui.amcharts.model.JsFunction;
import com.haulmont.charts.gui.amcharts.model.charts.SerialChart;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 * @author artamonov
 * @version $Id$
 */
public class SerialChartLoader extends RectangularChartLoader<SerialChart> {
    public SerialChartLoader(Context context) {
        super(context);
    }

    @Override
    public Chart loadComponent(ComponentsFactory factory, Element element, Component parent) {
        Chart chart = super.loadComponent(factory, element, parent);

        SerialChart configuration = new SerialChart();
        loadConfiguration(element, configuration);
        chart.setConfiguration(configuration);

        assignFrame(chart);

        return chart;
    }

    @Override
    protected void loadConfiguration(Element element, SerialChart chart) {
        super.loadConfiguration(element, chart);

        loadCategoryAxis(element, chart);

        String balloonDateFormat = element.attributeValue("balloonDateFormat");
        if (StringUtils.isNotEmpty(balloonDateFormat)) {
            chart.setBalloonDateFormat(balloonDateFormat);
        }

        String categoryField = element.attributeValue("categoryField");
        if (StringUtils.isNotEmpty(categoryField)) {
            chart.setCategoryField(categoryField);
        }

        String columnSpacing = element.attributeValue("columnSpacing");
        if (StringUtils.isNotEmpty(columnSpacing)) {
            chart.setColumnSpacing(Integer.valueOf(columnSpacing));
        }

        String columnSpacing3D = element.attributeValue("columnSpacing3D");
        if (StringUtils.isNotEmpty(columnSpacing3D)) {
            chart.setColumnSpacing3D(Integer.valueOf(columnSpacing3D));
        }

        String columnWidth = element.attributeValue("columnWidth");
        if (StringUtils.isNotEmpty(columnWidth)) {
            chart.setColumnWidth(Double.valueOf(columnWidth));
        }

        String maxSelectedSeries = element.attributeValue("maxSelectedSeries");
        if (StringUtils.isNotEmpty(maxSelectedSeries)) {
            chart.setMaxSelectedSeries(Integer.valueOf(maxSelectedSeries));
        }

        String minSelectedTime = element.attributeValue("minSelectedTime");
        if (StringUtils.isNotEmpty(minSelectedTime)) {
            chart.setMinSelectedTime(Long.valueOf(minSelectedTime));
        }

        String maxSelectedTime = element.attributeValue("maxSelectedTime");
        if (StringUtils.isNotEmpty(maxSelectedTime)) {
            chart.setMaxSelectedTime(Long.valueOf(maxSelectedTime));
        }

        String mouseWheelScrollEnabled = element.attributeValue("mouseWheelScrollEnabled");
        if (StringUtils.isNotEmpty(mouseWheelScrollEnabled)) {
            chart.setMouseWheelScrollEnabled(Boolean.valueOf(mouseWheelScrollEnabled));
        }

        String rotate = element.attributeValue("rotate");
        if (StringUtils.isNotEmpty(rotate)) {
            chart.setRotate(Boolean.valueOf(rotate));
        }

        String zoomOutOnDataUpdate = element.attributeValue("zoomOutOnDataUpdate");
        if (StringUtils.isNotEmpty(zoomOutOnDataUpdate)) {
            chart.setZoomOutOnDataUpdate(Boolean.valueOf(zoomOutOnDataUpdate));
        }
    }

    protected void loadCategoryAxis(Element element, SerialChart chart) {
        Element axisElement = element.element("categoryAxis");
        if (axisElement != null) {
            CategoryAxis axis = new CategoryAxis();

            loadAbstractAxis(axisElement, axis);

            String categoryFunction = axisElement.elementText("categoryFunction");
            if (StringUtils.isNotEmpty(categoryFunction)) {
                axis.setCategoryFunction(new JsFunction(categoryFunction));
            }

            String autoWrap = axisElement.attributeValue("autoWrap");
            if (StringUtils.isNotEmpty(autoWrap)) {
                axis.setAutoWrap(Boolean.valueOf(autoWrap));
            }

            String boldPeriodBeginning = axisElement.attributeValue("boldPeriodBeginning");
            if (StringUtils.isNotEmpty(boldPeriodBeginning)) {
                axis.setBoldPeriodBeginning(Boolean.valueOf(boldPeriodBeginning));
            }

            String centerLabelOnFullPeriod = axisElement.attributeValue("centerLabelOnFullPeriod");
            if (StringUtils.isNotEmpty(centerLabelOnFullPeriod)) {
                axis.setCenterLabelOnFullPeriod(Boolean.valueOf(centerLabelOnFullPeriod));
            }

            String equalSpacing = axisElement.attributeValue("equalSpacing");
            if (StringUtils.isNotEmpty(equalSpacing)) {
                axis.setEqualSpacing(Boolean.valueOf(equalSpacing));
            }

            String forceShowField = axisElement.attributeValue("forceShowField");
            if (StringUtils.isNotEmpty(forceShowField)) {
                axis.setForceShowField(forceShowField);
            }

            String gridPosition = axisElement.attributeValue("gridPosition");
            if (StringUtils.isNotEmpty(gridPosition)) {
                axis.setGridPosition(GridPosition.valueOf(gridPosition));
            }

            String markPeriodChange = axisElement.attributeValue("markPeriodChange");
            if (StringUtils.isNotEmpty(markPeriodChange)) {
                axis.setMarkPeriodChange(Boolean.valueOf(markPeriodChange));
            }

            String minPeriod = axisElement.attributeValue("minPeriod");
            if (StringUtils.isNotEmpty(minPeriod)) {
                axis.setMinPeriod(DatePeriod.valueOf(minPeriod));
            }

            String startOnAxis = axisElement.attributeValue("startOnAxis");
            if (StringUtils.isNotEmpty(startOnAxis)) {
                axis.setStartOnAxis(Boolean.valueOf(startOnAxis));
            }

            chart.setCategoryAxis(axis);
        }
    }
}