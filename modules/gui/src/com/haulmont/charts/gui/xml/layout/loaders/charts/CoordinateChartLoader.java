/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.CoordinateChart;
import com.haulmont.charts.gui.model.JsFunction;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

public abstract class CoordinateChartLoader<T extends CoordinateChart> extends AbstractChartLoader<T> {

    @Override
    protected void loadConfiguration(T chart, Element element) {
        checkDatasource(element);
        super.loadConfiguration(chart, element);

        loadChartData(chart, element);
        loadColors(chart, element);
        loadGraphs(chart, element);
        loadValueAxes(chart, element);

        loadStartEffect(chart, element);

        String gridAboveGraphs = element.attributeValue("gridAboveGraphs");
        if (StringUtils.isNotEmpty(gridAboveGraphs)) {
            chart.setGridAboveGraphs(Boolean.valueOf(gridAboveGraphs));
        }

        Element guidesElement = element.element("guides");
        if (guidesElement != null) {
            chart.setGuides(loadGuides(guidesElement));
        }

        String sequencedAnimation = element.attributeValue("sequencedAnimation");
        if (StringUtils.isNotEmpty(sequencedAnimation)) {
            chart.setSequencedAnimation(Boolean.valueOf(sequencedAnimation));
        }

        String startAlpha = element.attributeValue("startAlpha");
        if (StringUtils.isNotEmpty(startAlpha)) {
            chart.setStartAlpha(Double.valueOf(startAlpha));
        }

        String urlTarget = element.attributeValue("urlTarget");
        if (StringUtils.isNotEmpty(urlTarget)) {
            chart.setUrlTarget(urlTarget);
        }
    }

    protected void loadGraphs(T chart, Element element) {
        Element graphsElement = element.element("graphs");
        if (graphsElement != null) {
            for (Object graphItem : graphsElement.elements("graph")) {
                Element graphElement = (Element) graphItem;
                Graph graph = new Graph();
                loadGraph(graph, graphElement);
                chart.addGraphs(graph);
            }
        }
    }

    protected void loadValueAxes(T chart, Element element) {
        Element valueAxesElement = element.element("valueAxes");
        if (valueAxesElement != null) {
            for (Object axisItem : valueAxesElement.elements("axis")) {
                Element axisElement = (Element) axisItem;

                ValueAxis axis = loadValueAxis(axisElement);

                String labelFunction = valueAxesElement.elementText("labelFunction");
                if (StringUtils.isNotBlank(labelFunction)) {
                    axis.setLabelFunction(new JsFunction(labelFunction));
                }

                chart.addValueAxes(axis);
            }
        }
    }
}