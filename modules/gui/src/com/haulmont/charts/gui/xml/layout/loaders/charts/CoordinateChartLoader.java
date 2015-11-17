/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.CoordinateChart;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 * @author artamonov
 * @version $Id$
 */
public abstract class CoordinateChartLoader<T extends CoordinateChart> extends AbstractChartLoader<T> {

    @Override
    protected void loadConfiguration(T chart, Element element) {
        super.loadConfiguration(chart, element);

        loadColors(chart, element);
        loadGraphs(chart, element);
        loadValueAxes(chart, element);

        loadStartEffect(chart, element);
        loadGuides(chart, element);

        String gridAboveGraphs = element.attributeValue("gridAboveGraphs");
        if (StringUtils.isNotEmpty(gridAboveGraphs)) {
            chart.setGridAboveGraphs(Boolean.valueOf(gridAboveGraphs));
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

    protected void loadGuides(T chart, Element element) {
        Element guidesElement = element.element("guides");
        if (guidesElement != null) {
            for (Object guideItem : guidesElement.elements("guide")) {
                Element guideElement = (Element) guideItem;

                Guide guide = new Guide();

                loadGuide(guide, guideElement);

                chart.addGuides(guide);
            }
        }
    }

    protected void loadGraphs(T chart, Element element) {
        Element graphsElement = element.element("graphs");
        if (graphsElement != null) {
            for (Object graphItem : graphsElement.elements("graph")) {
                Element graphElement = (Element) graphItem;
                chart.addGraphs(loadGraph(graphElement));
            }
        }
    }

    protected Graph loadGraph(Element graphElement) {
        Graph graph = new Graph();

        Element dateFormatElement = element.element("dateFormat");
        if (dateFormatElement != null) {
            DateFormat dateFormat = new DateFormat();
            loadDateFormat(dateFormat, dateFormatElement);
            graph.setDateFormat(dateFormat);
        }

        String balloonFunction = graphElement.elementText("balloonFunction");
        if (StringUtils.isNotEmpty(balloonFunction)) {
            graph.setBalloonFunction(new JsFunction(balloonFunction));
        }

        Element patternElement = graphElement.element("pattern");
        if (patternElement != null) {
            graph.setPattern(loadPattern(patternElement));
        }

        String id = graphElement.attributeValue("id");
        if (StringUtils.isNotEmpty(id)) {
            graph.setId(id);
        }

        String type = graphElement.attributeValue("type");
        if (StringUtils.isNotEmpty(type)) {
            graph.setType(GraphType.valueOf(type));
        }

        String alphaField = graphElement.attributeValue("alphaField");
        if (StringUtils.isNotEmpty(alphaField)) {
            graph.setAlphaField(alphaField);
        }

        String animationPlayed = graphElement.attributeValue("animationPlayed");
        if (StringUtils.isNotEmpty(animationPlayed)) {
            graph.setAnimationPlayed(Boolean.valueOf(animationPlayed));
        }

        String balloonColor = graphElement.attributeValue("balloonColor");
        if (StringUtils.isNotEmpty(balloonColor)) {
            graph.setBalloonColor(Color.valueOf(balloonColor));
        }

        String balloonText = graphElement.attributeValue("balloonText");
        if (StringUtils.isNotEmpty(balloonText)) {
            graph.setBalloonText(loadResourceString(balloonText));
        }

        String behindColumns = graphElement.attributeValue("behindColumns");
        if (StringUtils.isNotEmpty(behindColumns)) {
            graph.setBehindColumns(Boolean.valueOf(behindColumns));
        }

        String bullet = graphElement.attributeValue("bullet");
        if (StringUtils.isNotEmpty(bullet)) {
            graph.setBullet(BulletType.valueOf(bullet));
        }

        String bulletAlpha = graphElement.attributeValue("bulletAlpha");
        if (StringUtils.isNotEmpty(bulletAlpha)) {
            graph.setBulletAlpha(Double.valueOf(bulletAlpha));
        }

        String bulletAxis = graphElement.attributeValue("bulletAxis");
        if (StringUtils.isNotEmpty(bulletAxis)) {
            graph.setBulletAxis(bulletAxis);
        }

        String bulletBorderAlpha = graphElement.attributeValue("bulletBorderAlpha");
        if (StringUtils.isNotEmpty(bulletBorderAlpha)) {
            graph.setBulletBorderAlpha(Double.valueOf(bulletBorderAlpha));
        }

        String bulletBorderColor = graphElement.attributeValue("bulletBorderColor");
        if (StringUtils.isNotEmpty(bulletBorderColor)) {
            graph.setBulletBorderColor(Color.valueOf(bulletBorderColor));
        }

        String bulletBorderThickness = graphElement.attributeValue("bulletBorderThickness");
        if (StringUtils.isNotEmpty(bulletBorderThickness)) {
            graph.setBulletBorderThickness(Integer.valueOf(bulletBorderThickness));
        }

        String bulletColor = graphElement.attributeValue("bulletColor");
        if (StringUtils.isNotEmpty(bulletColor)) {
            graph.setBulletColor(Color.valueOf(bulletColor));
        }

        String bulletField = graphElement.attributeValue("bulletField");
        if (StringUtils.isNotEmpty(bulletField)) {
            graph.setBulletField(bulletField);
        }

        String bulletOffset = graphElement.attributeValue("bulletOffset");
        if (StringUtils.isNotEmpty(bulletOffset)) {
            graph.setBulletOffset(Integer.valueOf(bulletOffset));
        }

        String bulletSize = graphElement.attributeValue("bulletSize");
        if (StringUtils.isNotEmpty(bulletSize)) {
            graph.setBulletSize(Integer.valueOf(bulletSize));
        }

        String bulletSizeField = graphElement.attributeValue("bulletSizeField");
        if (StringUtils.isNotEmpty(bulletSizeField)) {
            graph.setBulletSizeField(bulletSizeField);
        }

        String closeField = graphElement.attributeValue("closeField");
        if (StringUtils.isNotEmpty(closeField)) {
            graph.setCloseField(closeField);
        }

        String clustered = graphElement.attributeValue("clustered");
        if (StringUtils.isNotEmpty(clustered)) {
            graph.setClustered(Boolean.valueOf(clustered));
        }

        String color = graphElement.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            graph.setColor(Color.valueOf(color));
        }

        String colorField = graphElement.attributeValue("colorField");
        if (StringUtils.isNotEmpty(colorField)) {
            graph.setColorField(colorField);
        }

        String columnWidth = graphElement.attributeValue("columnWidth");
        if (StringUtils.isNotEmpty(columnWidth)) {
            graph.setColumnWidth(Double.valueOf(columnWidth));
        }

        String connect = graphElement.attributeValue("connect");
        if (StringUtils.isNotEmpty(connect)) {
            graph.setConnect(Boolean.valueOf(connect));
        }

        String cornerRadiusTop = graphElement.attributeValue("cornerRadiusTop");
        if (StringUtils.isNotEmpty(cornerRadiusTop)) {
            graph.setCornerRadiusTop(Integer.valueOf(cornerRadiusTop));
        }

        String cursorBulletAlpha = graphElement.attributeValue("cursorBulletAlpha");
        if (StringUtils.isNotEmpty(cursorBulletAlpha)) {
            graph.setCursorBulletAlpha(Double.valueOf(cursorBulletAlpha));
        }

        String customBullet = graphElement.attributeValue("customBullet");
        if (StringUtils.isNotEmpty(customBullet)) {
            graph.setCustomBullet(customBullet);
        }

        String customBulletField = graphElement.attributeValue("customBulletField");
        if (StringUtils.isNotEmpty(customBulletField)) {
            graph.setCustomBulletField(customBulletField);
        }

        String customMarker = graphElement.attributeValue("customMarker");
        if (StringUtils.isNotEmpty(customMarker)) {
            graph.setCustomMarker(customMarker);
        }

        String dashLength = graphElement.attributeValue("dashLength");
        if (StringUtils.isNotEmpty(dashLength)) {
            graph.setDashLength(Integer.valueOf(dashLength));
        }

        String dashLengthField = graphElement.attributeValue("dashLengthField");
        if (StringUtils.isNotEmpty(dashLengthField)) {
            graph.setDashLengthField(dashLengthField);
        }

        String descriptionField = graphElement.attributeValue("descriptionField");
        if (StringUtils.isNotEmpty(descriptionField)) {
            graph.setDescriptionField(descriptionField);
        }

        String errorField = graphElement.attributeValue("errorField");
        if (StringUtils.isNotEmpty(errorField)) {
            graph.setErrorField(errorField);
        }

        String fillAlphas = graphElement.attributeValue("fillAlphas");
        if (StringUtils.isNotEmpty(fillAlphas)) {
            graph.setFillAlphas(Double.valueOf(fillAlphas));
        }

        String fillColors = graphElement.attributeValue("fillColors");
        if (StringUtils.isNotEmpty(fillColors)) {
            graph.setFillColors(Color.valueOf(fillColors));
        }

        String fillColorsField = graphElement.attributeValue("fillColorsField");
        if (StringUtils.isNotEmpty(fillColorsField)) {
            graph.setFillColorsField(fillColorsField);
        }

        String fillToAxis = graphElement.attributeValue("fillToAxis");
        if (StringUtils.isNotEmpty(fillToAxis)) {
            graph.setFillToAxis(fillToAxis);
        }

        String fillToGraph = graphElement.attributeValue("fillToGraph");
        if (StringUtils.isNotEmpty(fillToGraph)) {
            graph.setFillToGraph(fillToGraph);
        }

        String fixedColumnWidth = graphElement.attributeValue("fixedColumnWidth");
        if (StringUtils.isNotEmpty(fixedColumnWidth)) {
            graph.setFixedColumnWidth(Integer.valueOf(fixedColumnWidth));
        }

        String fontSize = graphElement.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            graph.setFontSize(Integer.valueOf(fontSize));
        }

        String gapField = graphElement.attributeValue("gapField");
        if (StringUtils.isNotEmpty(gapField)) {
            graph.setGapField(gapField);
        }

        String gapPeriod = graphElement.attributeValue("gapPeriod");
        if (StringUtils.isNotEmpty(gapPeriod)) {
            graph.setGapPeriod(Double.valueOf(gapPeriod));
        }

        String gradientOrientation = graphElement.attributeValue("gradientOrientation");
        if (StringUtils.isNotEmpty(gradientOrientation)) {
            graph.setGradientOrientation(GradientOrientation.valueOf(gradientOrientation));
        }

        String hidden = graphElement.attributeValue("hidden");
        if (StringUtils.isNotEmpty(hidden)) {
            graph.setHidden(Boolean.valueOf(hidden));
        }

        String hideBulletsCount = graphElement.attributeValue("hideBulletsCount");
        if (StringUtils.isNotEmpty(hideBulletsCount)) {
            graph.setHideBulletsCount(Integer.valueOf(hideBulletsCount));
        }

        String highField = graphElement.attributeValue("highField");
        if (StringUtils.isNotEmpty(highField)) {
            graph.setHighField(highField);
        }

        String includeInMinMax = graphElement.attributeValue("includeInMinMax");
        if (StringUtils.isNotEmpty(includeInMinMax)) {
            graph.setIncludeInMinMax(Boolean.valueOf(includeInMinMax));
        }

        String labelAnchor = graphElement.attributeValue("labelAnchor");
        if (StringUtils.isNotEmpty(labelAnchor)) {
            graph.setLabelAnchor(labelAnchor);
        }

        String labelColorField = graphElement.attributeValue("labelColorField");
        if (StringUtils.isNotEmpty(labelColorField)) {
            graph.setLabelColorField(labelColorField);
        }

        String labelFunction = graphElement.elementText("labelFunction");
        if (StringUtils.isNotBlank(labelFunction)) {
            graph.setLabelFunction(new JsFunction(labelFunction));
        }

        String labelOffset = graphElement.attributeValue("labelOffset");
        if (StringUtils.isNotEmpty(labelOffset)) {
            graph.setLabelOffset(Integer.valueOf(labelOffset));
        }

        String labelPosition = graphElement.attributeValue("labelPosition");
        if (StringUtils.isNotEmpty(labelPosition)) {
            graph.setLabelPosition(ValueLabelPosition.valueOf(labelPosition));
        }

        String labelRotation = graphElement.attributeValue("labelRotation");
        if (StringUtils.isNotEmpty(labelRotation)) {
            graph.setLabelRotation(Integer.valueOf(labelRotation));
        }

        String labelText = graphElement.attributeValue("labelText");
        if (StringUtils.isNotEmpty(labelText)) {
            graph.setLabelText(loadResourceString(labelText));
        }

        String legendAlpha = graphElement.attributeValue("legendAlpha");
        if (StringUtils.isNotEmpty(legendAlpha)) {
            graph.setLegendAlpha(Double.valueOf(legendAlpha));
        }

        String legendColor = graphElement.attributeValue("legendColor");
        if (StringUtils.isNotEmpty(legendColor)) {
            graph.setLegendColor(Color.valueOf(legendColor));
        }

        String legendPeriodValueText = graphElement.attributeValue("legendPeriodValueText");
        if (StringUtils.isNotEmpty(legendPeriodValueText)) {
            graph.setLegendPeriodValueText(loadResourceString(legendPeriodValueText));
        }

        String legendValueText = graphElement.attributeValue("legendValueText");
        if (StringUtils.isNotEmpty(legendValueText)) {
            graph.setLegendValueText(loadResourceString(legendValueText));
        }

        String lineAlpha = graphElement.attributeValue("lineAlpha");
        if (StringUtils.isNotEmpty(lineAlpha)) {
            graph.setLineAlpha(Double.valueOf(lineAlpha));
        }

        String lineColor = graphElement.attributeValue("lineColor");
        if (StringUtils.isNotEmpty(lineColor)) {
            graph.setLineColor(Color.valueOf(lineColor));
        }

        String lineColorField = graphElement.attributeValue("lineColorField");
        if (StringUtils.isNotEmpty("lineColorField")) {
            graph.setLineColorField(lineColorField);
        }

        String lineThickness = graphElement.attributeValue("lineThickness");
        if (StringUtils.isNotEmpty(lineThickness)) {
            graph.setLineThickness(Integer.valueOf(lineThickness));
        }

        String lowField = graphElement.attributeValue("lowField");
        if (StringUtils.isNotEmpty(lowField)) {
            graph.setLowField(lowField);
        }

        String markerType = graphElement.attributeValue("markerType");
        if (StringUtils.isNotEmpty(markerType)) {
            graph.setMarkerType(MarkerType.valueOf(markerType));
        }

        String maxBulletSize = graphElement.attributeValue("maxBulletSize");
        if (StringUtils.isNotEmpty(maxBulletSize)) {
            graph.setMaxBulletSize(Integer.valueOf(maxBulletSize));
        }

        String minBulletSize = graphElement.attributeValue("minBulletSize");
        if (StringUtils.isNotEmpty(minBulletSize)) {
            graph.setMinBulletSize(Integer.valueOf(minBulletSize));
        }

        String minDistance = graphElement.attributeValue("minDistance");
        if (StringUtils.isNotEmpty(minDistance)) {
            graph.setMinDistance(Integer.valueOf(minDistance));
        }

        String negativeBase = graphElement.attributeValue("negativeBase");
        if (StringUtils.isNotEmpty(negativeBase)) {
            graph.setNegativeBase(Double.valueOf(negativeBase));
        }

        String negativeFillAlphas = graphElement.attributeValue("negativeFillAlphas");
        if (StringUtils.isNotEmpty(negativeFillAlphas)) {
            graph.setNegativeFillAlphas(Double.valueOf(negativeFillAlphas));
        }

        String negativeFillColors = graphElement.attributeValue("negativeFillColors");
        if (StringUtils.isNotEmpty(negativeFillColors)) {
            graph.setNegativeFillColors(Color.valueOf(negativeFillColors));
        }

        String negativeLineAlpha = graphElement.attributeValue("negativeLineAlpha");
        if (StringUtils.isNotEmpty(negativeLineAlpha)) {
            graph.setNegativeLineAlpha(Double.valueOf(negativeLineAlpha));
        }

        String negativeLineColor = graphElement.attributeValue("negativeLineColor");
        if (StringUtils.isNotEmpty(negativeLineColor)) {
            graph.setNegativeLineColor(Color.valueOf(negativeLineColor));
        }

        String newStack = graphElement.attributeValue("newStack");
        if (StringUtils.isNotEmpty(newStack)) {
            graph.setNewStack(Boolean.valueOf(newStack));
        }

        String noStepRisers = graphElement.attributeValue("noStepRisers");
        if (StringUtils.isNotEmpty(noStepRisers)) {
            graph.setNoStepRisers(Boolean.valueOf(noStepRisers));
        }

        String openField = graphElement.attributeValue("openField");
        if (StringUtils.isNotEmpty(openField)) {
            graph.setOpenField(openField);
        }

        String patternField = graphElement.attributeValue("patternField");
        if (StringUtils.isNotEmpty(patternField)) {
            graph.setPatternField(patternField);
        }

        String periodSpan = graphElement.attributeValue("periodSpan");
        if (StringUtils.isNotEmpty(periodSpan)) {
            graph.setPeriodSpan(Integer.valueOf(periodSpan));
        }

        String pointPosition = graphElement.attributeValue("pointPosition");
        if (StringUtils.isNotEmpty(pointPosition)) {
            graph.setPointPosition(PointPosition.valueOf(pointPosition));
        }

        String precision = graphElement.attributeValue("precision");
        if (StringUtils.isNotEmpty(precision)) {
            graph.setPrecision(Integer.valueOf(precision));
        }

        String proCandlesticks = graphElement.attributeValue("proCandlesticks");
        if (StringUtils.isNotEmpty(proCandlesticks)) {
            graph.setProCandlesticks(Boolean.valueOf(proCandlesticks));
        }

        String showAllValueLabels = graphElement.attributeValue("showAllValueLabels");
        if (StringUtils.isNotEmpty(showAllValueLabels)) {
            graph.setShowAllValueLabels(Boolean.valueOf(showAllValueLabels));
        }

        String showBalloon = graphElement.attributeValue("showBalloon");
        if (StringUtils.isNotEmpty(showBalloon)) {
            graph.setShowBalloon(Boolean.valueOf(showBalloon));
        }

        String showBalloonAt = graphElement.attributeValue("showBalloonAt");
        if (StringUtils.isNotEmpty(showBalloonAt)) {
            graph.setShowBalloonAt(ShowPositionOnCandle.valueOf(showBalloonAt));
        }

        String showBulletsAt = graphElement.attributeValue("showBulletsAt");
        if (StringUtils.isNotEmpty(showBulletsAt)) {
            graph.setShowBulletsAt(ShowPositionOnCandle.valueOf(showBulletsAt));
        }

        String showHandOnHover = graphElement.attributeValue("showHandOnHover");
        if (StringUtils.isNotEmpty(showHandOnHover)) {
            graph.setShowHandOnHover(Boolean.valueOf(showHandOnHover));
        }

        String showOnAxis = graphElement.attributeValue("showOnAxis");
        if (StringUtils.isNotEmpty(showOnAxis)) {
            graph.setShowOnAxis(Boolean.valueOf(showOnAxis));
        }

        String stackable = graphElement.attributeValue("stackable");
        if (StringUtils.isNotEmpty(stackable)) {
            graph.setStackable(Boolean.valueOf(stackable));
        }

        String stepDirection = graphElement.attributeValue("stepDirection");
        if (StringUtils.isNotEmpty(stepDirection)) {
            graph.setStepDirection(StepDirection.valueOf(stepDirection));
        }

        String switchable = graphElement.attributeValue("switchable");
        if (StringUtils.isNotEmpty(switchable)) {
            graph.setSwitchable(Boolean.valueOf(switchable));
        }

        String title = graphElement.attributeValue("title");
        if (StringUtils.isNotEmpty(title)) {
            graph.setTitle(loadResourceString(title));
        }

        String topRadius = graphElement.attributeValue("topRadius");
        if (StringUtils.isNotEmpty(topRadius)) {
            graph.setTopRadius(Integer.valueOf(topRadius));
        }

        String urlField = graphElement.attributeValue("urlField");
        if (StringUtils.isNotEmpty(urlField)) {
            graph.setUrlField(urlField);
        }

        String urlTarget = graphElement.attributeValue("urlTarget");
        if (StringUtils.isNotEmpty(urlTarget)) {
            graph.setUrlTarget(urlTarget);
        }

        String useLineColorForBulletBorder = graphElement.attributeValue("useLineColorForBulletBorder");
        if (StringUtils.isNotEmpty(useLineColorForBulletBorder)) {
            graph.setUseLineColorForBulletBorder(Boolean.valueOf(useLineColorForBulletBorder));
        }

        String useNegativeColorIfDown = graphElement.attributeValue("useNegativeColorIfDown");
        if (StringUtils.isNotEmpty(useNegativeColorIfDown)) {
            graph.setUseNegativeColorIfDown(Boolean.valueOf(useNegativeColorIfDown));
        }

        String valueAxis = graphElement.attributeValue("valueAxis");
        if (StringUtils.isNotEmpty(valueAxis)) {
            graph.setValueAxis(valueAxis);
        }

        String valueField = graphElement.attributeValue("valueField");
        if (StringUtils.isNotEmpty(valueField)) {
            graph.setValueField(valueField);
        }

        String visibleInLegend = graphElement.attributeValue("visibleInLegend");
        if (StringUtils.isNotEmpty(visibleInLegend)) {
            graph.setVisibleInLegend(Boolean.valueOf(visibleInLegend));
        }

        String xAxis = graphElement.attributeValue("xAxis");
        if (StringUtils.isNotEmpty(xAxis)) {
            graph.setXAxis(xAxis);
        }

        String xField = graphElement.attributeValue("xField");
        if (StringUtils.isNotEmpty(xField)) {
            graph.setXField(xField);
        }

        String yAxis = graphElement.attributeValue("yAxis");
        if (StringUtils.isNotEmpty(yAxis)) {
            graph.setYAxis(yAxis);
        }

        String yField = graphElement.attributeValue("yField");
        if (StringUtils.isNotEmpty(yField)) {
            graph.setYField(yField);
        }

        return graph;
    }

    protected ValueAxis loadValueAxis(Element valueAxisElement) {
        ValueAxis axis = new ValueAxis();

        loadAbstractAxis(axis, valueAxisElement);

        String id = valueAxisElement.attributeValue("id");
        if (StringUtils.isNotEmpty(id)) {
            axis.setId(id);
        }

        String labelFunction = valueAxisElement.elementText("labelFunction");
        if (StringUtils.isNotBlank(labelFunction)) {
            axis.setLabelFunction(new JsFunction(labelFunction));
        }

        String axisTitleOffset = valueAxisElement.attributeValue("axisTitleOffset");
        if (StringUtils.isNotEmpty(axisTitleOffset)) {
            axis.setAxisTitleOffset(Integer.valueOf(axisTitleOffset));
        }

        String baseValue = valueAxisElement.attributeValue("baseValue");
        if (StringUtils.isNotEmpty(baseValue)) {
            axis.setBaseValue(Double.valueOf(baseValue));
        }

        String duration = valueAxisElement.attributeValue("duration");
        if (StringUtils.isNotEmpty(duration)) {
            axis.setDuration(Duration.valueOf(duration));
        }

        String gridType = valueAxisElement.attributeValue("gridType");
        if (StringUtils.isNotEmpty(gridType)) {
            axis.setGridType(GridType.valueOf(gridType));
        }

        String includeAllValues = valueAxisElement.attributeValue("includeAllValues");
        if (StringUtils.isNotEmpty(includeAllValues)) {
            axis.setIncludeAllValues(Boolean.valueOf(includeAllValues));
        }

        String includeGuidesInMinMax = valueAxisElement.attributeValue("includeGuidesInMinMax");
        if (StringUtils.isNotEmpty(includeGuidesInMinMax)) {
            axis.setIncludeGuidesInMinMax(Boolean.valueOf(includeGuidesInMinMax));
        }

        String includeHidden = valueAxisElement.attributeValue("includeHidden");
        if (StringUtils.isNotEmpty(includeHidden)) {
            axis.setIncludeHidden(Boolean.valueOf(includeHidden));
        }

        String integersOnly = valueAxisElement.attributeValue("integersOnly");
        if (StringUtils.isNotEmpty(integersOnly)) {
            axis.setIntegersOnly(Boolean.valueOf(integersOnly));
        }

        String logarithmic = valueAxisElement.attributeValue("logarithmic");
        if (StringUtils.isNotEmpty(logarithmic)) {
            axis.setLogarithmic(Boolean.valueOf(logarithmic));
        }

        String maximum = valueAxisElement.attributeValue("maximum");
        if (StringUtils.isNotEmpty(maximum)) {
            axis.setMaximum(Double.valueOf(maximum));
        }

        String maximumDate = valueAxisElement.attributeValue("maximumDate");
        if (StringUtils.isNotEmpty(maximumDate)) {
            axis.setMaximumDate(loadDate(maximumDate));
        }

        String minimum = valueAxisElement.attributeValue("minimum");
        if (StringUtils.isNotEmpty(minimum)) {
            axis.setMinimum(Double.valueOf(minimum));
        }

        String minimumDate = valueAxisElement.attributeValue("minimumDate");
        if (StringUtils.isNotEmpty(minimumDate)) {
            axis.setMinimumDate(loadDate(minimumDate));
        }

        String minMaxMultiplier = valueAxisElement.attributeValue("minMaxMultiplier");
        if (StringUtils.isNotEmpty(minMaxMultiplier)) {
            axis.setMinMaxMultiplier(Double.valueOf(minMaxMultiplier));
        }

        String pointPosition = valueAxisElement.attributeValue("pointPosition");
        if (StringUtils.isNotEmpty(pointPosition)) {
            axis.setPointPosition(PointPosition.valueOf(pointPosition));
        }

        String precision = valueAxisElement.attributeValue("precision");
        if (StringUtils.isNotEmpty(precision)) {
            axis.setPrecision(Integer.valueOf(precision));
        }

        String radarCategoriesEnabled = valueAxisElement.attributeValue("radarCategoriesEnabled");
        if (StringUtils.isNotEmpty(radarCategoriesEnabled)) {
            axis.setRadarCategoriesEnabled(Boolean.valueOf(radarCategoriesEnabled));
        }

        String recalculateToPercents = valueAxisElement.attributeValue("recalculateToPercents");
        if (StringUtils.isNotEmpty(recalculateToPercents)) {
            axis.setRecalculateToPercents(Boolean.valueOf(recalculateToPercents));
        }

        String reversed = valueAxisElement.attributeValue("reversed");
        if (StringUtils.isNotEmpty(reversed)) {
            axis.setReversed(Boolean.valueOf(reversed));
        }

        String stackType = valueAxisElement.attributeValue("stackType");
        if (StringUtils.isNotEmpty(stackType)) {
            axis.setStackType(StackType.valueOf(stackType));
        }

        String strictMinMax = valueAxisElement.attributeValue("strictMinMax");
        if (StringUtils.isNotEmpty(strictMinMax)) {
            axis.setStrictMinMax(Boolean.valueOf(strictMinMax));
        }

        String synchronizationMultiplier = valueAxisElement.attributeValue("synchronizationMultiplier");
        if (StringUtils.isNotEmpty(synchronizationMultiplier)) {
            axis.setSynchronizationMultiplier(Double.valueOf(synchronizationMultiplier));
        }

        String synchronizeWith = valueAxisElement.attributeValue("synchronizeWith");
        if (StringUtils.isNotEmpty(synchronizeWith)) {
            axis.setSynchronizeWith(synchronizeWith);
        }

        String totalText = valueAxisElement.elementText("totalText");
        if (StringUtils.isNotEmpty(totalText)) {
            axis.setTotalText(loadResourceString(totalText));
        }

        String totalTextColor = valueAxisElement.attributeValue("totalTextColor");
        if (StringUtils.isNotEmpty(totalTextColor)) {
            axis.setTotalTextColor(Color.valueOf(totalTextColor));
        }

        String totalTextOffset = valueAxisElement.attributeValue("totalTextOffset");
        if (StringUtils.isNotEmpty(totalTextOffset)) {
            axis.setTotalTextOffset(Integer.valueOf(totalTextOffset));
        }

        String treatZeroAs = valueAxisElement.attributeValue("treatZeroAs");
        if (StringUtils.isNotEmpty(treatZeroAs)) {
            axis.setTreatZeroAs(Double.valueOf(treatZeroAs));
        }

        String type = valueAxisElement.attributeValue("type");
        if (StringUtils.isNotEmpty(type)) {
            axis.setType(ValueAxisType.valueOf(type));
        }

        String unit = valueAxisElement.attributeValue("unit");
        if (StringUtils.isNotEmpty(unit)) {
            axis.setUnit(unit);
        }

        String unitPosition = valueAxisElement.attributeValue("unitPosition");
        if (StringUtils.isNotEmpty(unitPosition)) {
            axis.setUnitPosition(UnitPosition.valueOf(unitPosition));
        }

        String usePrefixes = valueAxisElement.attributeValue("usePrefixes");
        if (StringUtils.isNotEmpty(usePrefixes)) {
            axis.setUsePrefixes(Boolean.valueOf(usePrefixes));
        }

        String useScientificNotation = valueAxisElement.attributeValue("useScientificNotation");
        if (StringUtils.isNotEmpty(useScientificNotation)) {
            axis.setUseScientificNotation(Boolean.valueOf(useScientificNotation));
        }

        String zeroGridAlpha = valueAxisElement.attributeValue("zeroGridAlpha");
        if (StringUtils.isNotEmpty(zeroGridAlpha)) {
            axis.setZeroGridAlpha(Double.valueOf(zeroGridAlpha));
        }

        return axis;
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