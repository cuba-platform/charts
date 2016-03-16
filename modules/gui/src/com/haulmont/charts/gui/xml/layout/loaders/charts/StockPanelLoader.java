/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.StockPanel;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 */
public class StockPanelLoader extends AbstractSerialChartLoader<StockPanel> {

    @Override
    public void loadComponent() {
        // do nothing
    }

    @Override
    protected StockPanel createConfiguration() {
        return new StockPanel();
    }

    @Override
    protected void loadConfiguration(StockPanel chart, Element element) {
        super.loadConfiguration(chart, element);

        loadStockGraphs(chart, element);
        loadStockLegend(chart, element);

        String id = element.attributeValue("id");
        if (StringUtils.isNotEmpty(id)) {
            chart.setId(id);
        }

        String allowTurningOff = element.attributeValue("allowTurningOff");
        if (StringUtils.isNotEmpty(allowTurningOff)) {
            chart.setAllowTurningOff(Boolean.valueOf(allowTurningOff));
        }

        String drawingIconsEnabled = element.attributeValue("drawingIconsEnabled");
        if (StringUtils.isNotEmpty(drawingIconsEnabled)) {
            chart.setDrawingIconsEnabled(Boolean.valueOf(drawingIconsEnabled));
        }

        Element drawOnAxisElement = element.element("drawOnAxis");
        if (drawOnAxisElement != null) {
            chart.setDrawOnAxis(loadValueAxis(drawOnAxisElement));
        }

        String eraseAll = element.attributeValue("eraseAll");
        if (StringUtils.isNotEmpty(eraseAll)) {
            chart.setEraseAll(Boolean.valueOf(eraseAll));
        }

        String iconSize = element.attributeValue("iconSize");
        if (StringUtils.isNotEmpty(iconSize)) {
            chart.setIconSize(Integer.valueOf(iconSize));
        }

        String percentHeight = element.attributeValue("percentHeight");
        if (StringUtils.isNotEmpty(percentHeight)) {
            chart.setPercentHeight(Integer.valueOf(percentHeight));
        }

        String recalculateFromDate = element.attributeValue("recalculateFromDate");
        if (StringUtils.isNotEmpty(recalculateFromDate)) {
            chart.setRecalculateFromDate(loadDate(recalculateFromDate));
        }

        String recalculateToPercents = element.attributeValue("recalculateToPercents");
        if (StringUtils.isNotEmpty(recalculateToPercents)) {
            chart.setRecalculateToPercents(recalculateToPercents);
        }

        String showCategoryAxis = element.attributeValue("showCategoryAxis");
        if (StringUtils.isNotEmpty(showCategoryAxis)) {
            chart.setShowCategoryAxis(Boolean.valueOf(showCategoryAxis));
        }

        String showComparedOnTop = element.attributeValue("showComparedOnTop");
        if (StringUtils.isNotEmpty(showComparedOnTop)) {
            chart.setShowComparedOnTop(Boolean.valueOf(showComparedOnTop));
        }

        String title = element.attributeValue("title");
        if (StringUtils.isNotEmpty(title)) {
            chart.setTitle(title);
        }

        String trendLineAlpha = element.attributeValue("trendLineAlpha");
        if (StringUtils.isNotEmpty(trendLineAlpha)) {
            chart.setTrendLineAlpha(Double.valueOf(trendLineAlpha));
        }

        String trendLineColor = element.attributeValue("trendLineColor");
        if (StringUtils.isNotEmpty(trendLineColor)) {
            chart.setTrendLineColor(Color.valueOf(trendLineColor));
        }

        String trendLineDashLength = element.attributeValue("trendLineDashLength");
        if (StringUtils.isNotEmpty(trendLineDashLength)) {
            chart.setTrendLineDashLength(Integer.valueOf(trendLineDashLength));
        }

        String trendLineThickness = element.attributeValue("trendLineThickness");
        if (StringUtils.isNotEmpty(trendLineThickness)) {
            chart.setTrendLineThickness(Integer.valueOf(trendLineThickness));
        }
    }

    protected void loadStockLegend(StockPanel chart, Element element) {
        Element stockLegendElement = element.element("stockLegend");
        if (stockLegendElement != null) {
            StockLegend stockLegend = new StockLegend();
            loadLegend(stockLegend, stockLegendElement);

            String periodValueTextComparing = stockLegendElement.attributeValue("periodValueTextComparing");
            if (StringUtils.isNotEmpty(periodValueTextComparing)) {
                stockLegend.setPeriodValueTextComparing(periodValueTextComparing);
            }

            String periodValueTextRegular = stockLegendElement.attributeValue("periodValueTextRegular");
            if (StringUtils.isNotEmpty(periodValueTextRegular)) {
                stockLegend.setPeriodValueTextRegular(periodValueTextRegular);
            }

            String valueTextComparing = stockLegendElement.attributeValue("valueTextComparing");
            if (StringUtils.isNotEmpty(valueTextComparing)) {
                stockLegend.setValueTextComparing(valueTextComparing);
            }

            String valueTextRegular = stockLegendElement.attributeValue("valueTextRegular");
            if (StringUtils.isNotEmpty(valueTextRegular)) {
                stockLegend.setValueTextRegular(valueTextRegular);
            }

            chart.setStockLegend(stockLegend);
        }
    }

    protected void loadStockGraphs(StockPanel chart, Element element) {
        Element stockGraphsElement = element.element("stockGraphs");
        if (stockGraphsElement != null) {
            for (Object stockGraphItem : stockGraphsElement.elements("stockGraph")) {
                Element stockGraphElement = (Element) stockGraphItem;
                StockGraph stockGraph = new StockGraph();
                loadStockGraph(stockGraph, stockGraphElement);
                chart.addStockGraphs(stockGraph);
            }
        }
    }

    protected void loadStockGraph(StockGraph stockGraph, Element stockGraphElement) {
        loadGraph(stockGraph, stockGraphElement);

        String comparable = stockGraphElement.attributeValue("comparable");
        if (StringUtils.isNotEmpty(comparable)) {
            stockGraph.setComparable(Boolean.valueOf(comparable));
        }

        String compareField = stockGraphElement.attributeValue("compareField");
        if (StringUtils.isNotEmpty(compareField)) {
            stockGraph.setCompareField(compareField);
        }

        String compareFromStart = stockGraphElement.attributeValue("compareFromStart");
        if (StringUtils.isNotEmpty(compareFromStart)) {
            stockGraph.setCompareFromStart(Boolean.valueOf(compareFromStart));
        }

        Element compareGraphElement = stockGraphElement.element("compareGraph");
        if (compareGraphElement != null) {
            Graph compareGraph = new Graph();
            loadGraph(compareGraph, compareGraphElement);
            stockGraph.setCompareGraph(compareGraph);
        }

        String compareGraphBalloonColor = stockGraphElement.attributeValue("compareGraphBalloonColor");
        if (StringUtils.isNotEmpty(compareGraphBalloonColor)) {
            stockGraph.setCompareGraphBalloonColor(Color.valueOf(compareGraphBalloonColor));
        }

        String compareGraphBalloonFunction = stockGraphElement.elementText("compareGraphBalloonFunction");
        if (StringUtils.isNotBlank(compareGraphBalloonFunction)) {
            stockGraph.setCompareGraphBalloonFunction(new JsFunction(compareGraphBalloonFunction));
        }

        String compareGraphBalloonText = stockGraphElement.attributeValue("compareGraphBalloonText");
        if (StringUtils.isNotEmpty(compareGraphBalloonText)) {
            stockGraph.setCompareGraphBalloonText(compareGraphBalloonText);
        }

        String compareGraphBullet = stockGraphElement.attributeValue("compareGraphBullet");
        if (StringUtils.isNotEmpty(compareGraphBullet)) {
            stockGraph.setCompareGraphBullet(compareGraphBullet);
        }

        String compareGraphBulletBorderAlpha = stockGraphElement.attributeValue("compareGraphBulletBorderAlpha");
        if (StringUtils.isNotEmpty(compareGraphBulletBorderAlpha)) {
            stockGraph.setCompareGraphBulletBorderAlpha(Double.valueOf(compareGraphBulletBorderAlpha));
        }

        String compareGraphBulletBorderColor = stockGraphElement.attributeValue("compareGraphBulletBorderColor");
        if (StringUtils.isNotEmpty(compareGraphBulletBorderColor)) {
            stockGraph.setCompareGraphBulletBorderColor(Color.valueOf(compareGraphBulletBorderColor));
        }

        String compareGraphBulletBorderThickness = stockGraphElement.attributeValue("compareGraphBulletBorderThickness");
        if (StringUtils.isNotEmpty(compareGraphBulletBorderThickness)) {
            stockGraph.setCompareGraphBulletBorderThickness(Integer.valueOf(compareGraphBulletBorderThickness));
        }

        String compareGraphBulletColor = stockGraphElement.attributeValue("compareGraphBulletColor");
        if (StringUtils.isNotEmpty(compareGraphBulletColor)) {
            stockGraph.setCompareGraphBulletColor(Color.valueOf(compareGraphBulletColor));
        }

        String compareGraphBulletSize = stockGraphElement.attributeValue("compareGraphBulletSize");
        if (StringUtils.isNotEmpty(compareGraphBulletSize)) {
            stockGraph.setCompareGraphBulletSize(Integer.valueOf(compareGraphBulletSize));
        }

        String compareGraphCornerRadiusTop = stockGraphElement.attributeValue("compareGraphCornerRadiusTop");
        if (StringUtils.isNotEmpty(compareGraphCornerRadiusTop)) {
            stockGraph.setCompareGraphCornerRadiusTop(Integer.valueOf(compareGraphCornerRadiusTop));
        }

        String compareGraphDashLength = stockGraphElement.attributeValue("compareGraphDashLength");
        if (StringUtils.isNotEmpty(compareGraphDashLength)) {
            stockGraph.setCompareGraphDashLength(Integer.valueOf(compareGraphDashLength));
        }

        String compareGraphFillAlphas = stockGraphElement.attributeValue("compareGraphFillAlphas");
        if (StringUtils.isNotEmpty(compareGraphFillAlphas)) {
            stockGraph.setCompareGraphFillAlphas(Double.valueOf(compareGraphFillAlphas));
        }

        String compareGraphFillColors = stockGraphElement.attributeValue("compareGraphFillColors");
        if (StringUtils.isNotEmpty(compareGraphFillColors)) {
            stockGraph.setCompareGraphFillColors(Color.valueOf(compareGraphFillColors));
        }

        String compareGraphLineAlpha = stockGraphElement.attributeValue("compareGraphLineAlpha");
        if (StringUtils.isNotEmpty(compareGraphLineAlpha)) {
            stockGraph.setCompareGraphLineAlpha(Double.valueOf(compareGraphLineAlpha));
        }

        String compareGraphLineColor = stockGraphElement.attributeValue("compareGraphLineColor");
        if (StringUtils.isNotEmpty(compareGraphLineColor)) {
            stockGraph.setCompareGraphLineColor(Color.valueOf(compareGraphLineColor));
        }

        String compareGraphLineThickness = stockGraphElement.attributeValue("compareGraphLineThickness");
        if (StringUtils.isNotEmpty(compareGraphLineThickness)) {
            stockGraph.setCompareGraphLineThickness(Integer.valueOf(compareGraphLineThickness));
        }

        String compareGraphType = stockGraphElement.attributeValue("compareGraphType");
        if (StringUtils.isNotEmpty(compareGraphType)) {
            stockGraph.setCompareGraphType(GraphType.valueOf(compareGraphType));
        }

        String compareGraphVisibleInLegend = stockGraphElement.attributeValue("compareGraphVisibleInLegend");
        if (StringUtils.isNotEmpty(compareGraphVisibleInLegend)) {
            stockGraph.setCompareGraphVisibleInLegend(Boolean.valueOf(compareGraphVisibleInLegend));
        }

        String periodValue = stockGraphElement.attributeValue("periodValue");
        if (StringUtils.isNotEmpty(periodValue)) {
            stockGraph.setPeriodValue(StockGraphValue.valueOf(periodValue));
        }

        String recalculateValue = stockGraphElement.attributeValue("recalculateValue");
        if (StringUtils.isNotEmpty(recalculateValue)) {
            stockGraph.setRecalculateValue(StockGraphValue.valueOf(recalculateValue));
        }

        String showEventsOnComparedGraphs = stockGraphElement.attributeValue("showEventsOnComparedGraphs");
        if (StringUtils.isNotEmpty(showEventsOnComparedGraphs)) {
            stockGraph.setShowEventsOnComparedGraphs(Boolean.valueOf(showEventsOnComparedGraphs));
        }

        String useDataSetColors = stockGraphElement.attributeValue("useDataSetColors");
        if (StringUtils.isNotEmpty(useDataSetColors)) {
            stockGraph.setUseDataSetColors(Boolean.valueOf(useDataSetColors));
        }
    }
}
