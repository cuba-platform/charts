/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.AngularGaugeChart;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 * @author artamonov
 * @version $Id$
 */
public class AngularGaugeChartLoader extends AbtractChartLoader<AngularGaugeChart> {
    protected AngularGaugeChartLoader(Context context) {
        super(context);
    }

    @Override
    public Chart loadComponent(ComponentsFactory factory, Element element, Component parent) {
        Chart chart = super.loadComponent(factory, element, parent);

        AngularGaugeChart configuration = new AngularGaugeChart();
        loadConfiguration(element, configuration);
        chart.setConfiguration(configuration);

        assignFrame(chart);

        return chart;
    }

    @Override
    protected void loadConfiguration(Element element, AngularGaugeChart chart) {
        super.loadConfiguration(element, chart);

        loadArrows(element, chart);
        loadAxes(element, chart);

        Element facePatternElement = element.element("facePattern");
        if (facePatternElement != null) {
            chart.setFacePattern(loadPattern(facePatternElement));
        }

        String adjustSize = element.attributeValue("adjustSize");
        if (StringUtils.isNotEmpty(adjustSize)) {
            chart.setAdjustSize(Boolean.valueOf(adjustSize));
        }

        String clockWiseOnly = element.attributeValue("clockWiseOnly");
        if (StringUtils.isNotEmpty(clockWiseOnly)) {
            chart.setClockWiseOnly(Boolean.valueOf(clockWiseOnly));
        }

        String faceAlpha = element.attributeValue("faceAlpha");
        if (StringUtils.isNotEmpty(faceAlpha)) {
            chart.setFaceAlpha(Double.valueOf(faceAlpha));
        }

        String faceBorderAlpha = element.attributeValue("faceBorderAlpha");
        if (StringUtils.isNotEmpty(faceBorderAlpha)) {
            chart.setFaceBorderAlpha(Double.valueOf(faceBorderAlpha));
        }

        String faceBorderColor = element.attributeValue("faceBorderColor");
        if (StringUtils.isNotEmpty(faceBorderColor)) {
            chart.setFaceBorderColor(Color.valueOf(faceBorderColor));
        }

        String faceBorderWidth = element.attributeValue("faceBorderWidth");
        if (StringUtils.isNotEmpty(faceBorderWidth)) {
            chart.setFaceBorderWidth(Integer.valueOf(faceBorderWidth));
        }

        String faceColor = element.attributeValue("faceColor");
        if (StringUtils.isNotEmpty(faceColor)) {
            chart.setFaceColor(Color.valueOf(faceColor));
        }

        String gaugeX = element.attributeValue("gaugeX");
        if (StringUtils.isNotEmpty(gaugeX)) {
            chart.setGaugeX(gaugeX);
        }

        String gaugeY = element.attributeValue("gaugeY");
        if (StringUtils.isNotEmpty(gaugeY)) {
            chart.setGaugeY(gaugeY);
        }

        loadMargins(element, chart);

        String minRadius = element.attributeValue("minRadius");
        if (StringUtils.isNotEmpty(minRadius)) {
            chart.setMinRadius(Integer.valueOf(minRadius));
        }

        loadStartEffect(element, chart);
    }

    protected void loadAxes(Element element, AngularGaugeChart chart) {
        Element axesListElement = element.element("axes");
        if (axesListElement != null) {
            for (Object axisItem : axesListElement.elements("axis")) {
                Element axisElement = (Element) axisItem;

                GaugeAxis axis = new GaugeAxis();

                loadGaugeBands(axisElement, axis);

                String axisAlpha = axisElement.attributeValue("axisAlpha");
                if (StringUtils.isNotEmpty(axisAlpha)) {
                    axis.setAxisAlpha(Double.valueOf(axisAlpha));
                }

                String axisColor = axisElement.attributeValue("axisColor");
                if (StringUtils.isNotEmpty(axisColor)) {
                    axis.setAxisColor(Color.valueOf(axisColor));
                }

                String axisThickness = axisElement.attributeValue("axisThickness");
                if (StringUtils.isNotEmpty(axisThickness)) {
                    axis.setAxisThickness(Integer.valueOf(axisThickness));
                }

                String bandAlpha = axisElement.attributeValue("bandAlpha");
                if (StringUtils.isNotEmpty(bandAlpha)) {
                    axis.setBandAlpha(Double.valueOf(bandAlpha));
                }

                String bandOutlineAlpha = axisElement.attributeValue("bandOutlineAlpha");
                if (StringUtils.isNotEmpty(bandOutlineAlpha)) {
                    axis.setBandOutlineAlpha(Double.valueOf(bandOutlineAlpha));
                }

                String bandOutlineColor = axisElement.attributeValue("bandOutlineColor");
                if (StringUtils.isNotEmpty(bandOutlineColor)) {
                    axis.setBandOutlineColor(Color.valueOf(bandOutlineColor));
                }

                String bandOutlineThickness = axisElement.attributeValue("bandOutlineThickness");
                if (StringUtils.isNotEmpty(bandOutlineThickness)) {
                    axis.setBandOutlineThickness(Integer.valueOf(bandOutlineThickness));
                }

                String bottomText = axisElement.attributeValue("bottomText");
                if (StringUtils.isNotEmpty(bottomText)) {
                    axis.setBottomText(loadResourceString(bottomText));
                }

                String bottomTextBold = axisElement.attributeValue("bottomTextBold");
                if (StringUtils.isNotEmpty(bottomTextBold)) {
                    axis.setBottomTextBold(Boolean.valueOf(bottomTextBold));
                }

                String bottomTextColor = axisElement.attributeValue("bottomTextColor");
                if (StringUtils.isNotEmpty(bottomTextColor)) {
                    axis.setBottomTextColor(Color.valueOf(bottomTextColor));
                }

                String bottomTextFontSize = axisElement.attributeValue("bottomTextFontSize");
                if (StringUtils.isNotEmpty(bottomTextFontSize)) {
                    axis.setBottomTextFontSize(Integer.valueOf(bottomTextFontSize));
                }

                String bottomTextYOffset = axisElement.attributeValue("bottomTextYOffset");
                if (StringUtils.isNotEmpty(bottomTextYOffset)) {
                    axis.setBottomTextYOffset(Integer.valueOf(bottomTextYOffset));
                }

                String centerX = axisElement.attributeValue("centerX");
                if (StringUtils.isNotEmpty(centerX)) {
                    axis.setCenterX(centerX);
                }

                String centerY = axisElement.attributeValue("centerY");
                if (StringUtils.isNotEmpty(centerY)) {
                    axis.setCenterY(centerY);
                }

                String endAngle = axisElement.attributeValue("endAngle");
                if (StringUtils.isNotEmpty(endAngle)) {
                    axis.setEndAngle(Integer.valueOf(endAngle));
                }

                String endValue = axisElement.attributeValue("endValue");
                if (StringUtils.isNotEmpty(endValue)) {
                    axis.setEndValue(Double.valueOf(endValue));
                }

                String gridInside = axisElement.attributeValue("gridInside");
                if (StringUtils.isNotEmpty(gridInside)) {
                    axis.setGridInside(Boolean.valueOf(gridInside));
                }

                String inside = axisElement.attributeValue("inside");
                if (StringUtils.isNotEmpty(inside)) {
                    axis.setInside(Boolean.valueOf(inside));
                }

                String labelFrequency = axisElement.attributeValue("labelFrequency");
                if (StringUtils.isNotEmpty(labelFrequency)) {
                    axis.setLabelFrequency(Double.valueOf(labelFrequency));
                }

                String labelOffset = axisElement.attributeValue("labelOffset");
                if (StringUtils.isNotEmpty(labelOffset)) {
                    axis.setLabelOffset(Integer.valueOf(labelOffset));
                }

                String minorTickInterval = axisElement.attributeValue("minorTickInterval");
                if (StringUtils.isNotEmpty(minorTickInterval)) {
                    axis.setMinorTickInterval(Integer.valueOf(minorTickInterval));
                }

                String minorTickLength = axisElement.attributeValue("minorTickLength");
                if (StringUtils.isNotEmpty(minorTickLength)) {
                    axis.setMinorTickLength(Integer.valueOf(minorTickLength));
                }

                String radius = axisElement.attributeValue("radius");
                if (StringUtils.isNotEmpty(radius)) {
                    axis.setRadius(radius);
                }

                String showFirstLabel = axisElement.attributeValue("showFirstLabel");
                if (StringUtils.isNotEmpty(showFirstLabel)) {
                    axis.setShowFirstLabel(Boolean.valueOf(showFirstLabel));
                }

                String showLastLabel = axisElement.attributeValue("showLastLabel");
                if (StringUtils.isNotEmpty(showLastLabel)) {
                    axis.setShowLastLabel(Boolean.valueOf(showLastLabel));
                }

                String startAngle = axisElement.attributeValue("startAngle");
                if (StringUtils.isNotEmpty(startAngle)) {
                    axis.setStartAngle(Integer.valueOf(startAngle));
                }

                String startValue = axisElement.attributeValue("startValue");
                if (StringUtils.isNotEmpty(startValue)) {
                    axis.setStartValue(Double.valueOf(startValue));
                }

                String tickAlpha = axisElement.attributeValue("tickAlpha");
                if (StringUtils.isNotEmpty(tickAlpha)) {
                    axis.setTickAlpha(Double.valueOf(tickAlpha));
                }

                String tickColor = axisElement.attributeValue("tickColor");
                if (StringUtils.isNotEmpty(tickColor)) {
                    axis.setTickColor(Color.valueOf(tickColor));
                }

                String tickLength = axisElement.attributeValue("tickLength");
                if (StringUtils.isNotEmpty(tickLength)) {
                    axis.setTickLength(Integer.valueOf(tickLength));
                }

                String tickThickness = axisElement.attributeValue("tickThickness");
                if (StringUtils.isNotEmpty(tickThickness)) {
                    axis.setTickThickness(Integer.valueOf(tickThickness));
                }

                String topText = axisElement.attributeValue("topText");
                if (StringUtils.isNotEmpty(topText)) {
                    axis.setTopText(loadResourceString(topText));
                }

                String topTextBold = axisElement.attributeValue("topTextBold");
                if (StringUtils.isNotEmpty(topTextBold)) {
                    axis.setTopTextBold(Boolean.valueOf(topTextBold));
                }

                String topTextColor = axisElement.attributeValue("topTextColor");
                if (StringUtils.isNotEmpty(topTextColor)) {
                    axis.setTopTextColor(Color.valueOf(topTextColor));
                }

                String topTextFontSize = axisElement.attributeValue("topTextFontSize");
                if (StringUtils.isNotEmpty(topTextFontSize)) {
                    axis.setTopTextFontSize(Integer.valueOf(topTextFontSize));
                }

                String topTextYOffset = axisElement.attributeValue("topTextYOffset");
                if (StringUtils.isNotEmpty(topTextYOffset)) {
                    axis.setTopTextYOffset(Integer.valueOf(topTextYOffset));
                }

                String unit = axisElement.attributeValue("unit");
                if (StringUtils.isNotEmpty(unit)) {
                    axis.setUnit(unit);
                }

                String unitPosition = axisElement.attributeValue("unitPosition");
                if (StringUtils.isNotEmpty(unitPosition)) {
                    axis.setUnitPosition(UnitPosition.valueOf(unitPosition));
                }

                String valueInterval = axisElement.attributeValue("valueInterval");
                if (StringUtils.isNotEmpty(valueInterval)) {
                    axis.setValueInterval(Integer.valueOf(valueInterval));
                }

                chart.addAxes(axis);
            }
        }
    }

    protected void loadGaugeBands(Element axisElement, GaugeAxis axis) {
        Element bandsElement = axisElement.element("bands");
        if (bandsElement != null) {
            for (Object bandItem : bandsElement.elements("band")) {
                Element bandElement = (Element) bandItem;

                GaugeBand band = new GaugeBand();

                String alpha = bandElement.attributeValue("alpha");
                if (StringUtils.isNotEmpty(alpha)) {
                    band.setAlpha(Double.valueOf(alpha));
                }

                String color = bandElement.attributeValue("color");
                if (StringUtils.isNotEmpty(color)) {
                    band.setColor(Color.valueOf(color));
                }

                String endValue = bandElement.attributeValue("endValue");
                if (StringUtils.isNotEmpty(endValue)) {
                    band.setEndValue(Double.valueOf(endValue));
                }

                String innerRadius = bandElement.attributeValue("innerRadius");
                if (StringUtils.isNotEmpty(innerRadius)) {
                    band.setInnerRadius(innerRadius);
                }

                String radius = bandElement.attributeValue("radius");
                if (StringUtils.isNotEmpty(radius)) {
                    band.setRadius(radius);
                }

                String startValue = bandElement.attributeValue("startValue");
                if (StringUtils.isNotEmpty(startValue)) {
                    axis.setStartValue(Double.valueOf(startValue));
                }

                axis.addBands(band);
            }
        }
    }

    protected void loadArrows(Element element, AngularGaugeChart chart) {
        Element arrowsElement = element.element("arrows");
        if (arrowsElement != null) {
            for (Object arrowItem : element.elements("arrow")) {
                Element arrowElement = (Element) arrowItem;

                GaugeArrow arrow = new GaugeArrow();

                String alpha = arrowElement.attributeValue("alpha");
                if (StringUtils.isNotEmpty(alpha)) {
                    arrow.setAlpha(Double.valueOf(alpha));
                }

                String axis = arrowElement.attributeValue("axis");
                if (StringUtils.isNotEmpty(axis)) {
                    arrow.setAxis(axis);
                }

                String borderAlpha = arrowElement.attributeValue("borderAlpha");
                if (StringUtils.isNotEmpty(borderAlpha)) {
                    arrow.setBorderAlpha(Double.valueOf(borderAlpha));
                }

                String clockWiseOnly = arrowElement.attributeValue("clockWiseOnly");
                if (StringUtils.isNotEmpty(clockWiseOnly)) {
                    arrow.setClockWiseOnly(Boolean.valueOf(clockWiseOnly));
                }

                String color = arrowElement.attributeValue("color");
                if (StringUtils.isNotEmpty(color)) {
                    arrow.setColor(Color.valueOf(color));
                }

                String innerRadius = arrowElement.attributeValue("innerRadius");
                if (StringUtils.isNotEmpty(innerRadius)) {
                    arrow.setInnerRadius(innerRadius);
                }

                String nailAlpha = arrowElement.attributeValue("nailAlpha");
                if (StringUtils.isNotEmpty(nailAlpha)) {
                    arrow.setNailAlpha(Double.valueOf(nailAlpha));
                }

                String nailBorderAlpha = arrowElement.attributeValue("nailBorderAlpha");
                if (StringUtils.isNotEmpty(nailBorderAlpha)) {
                    arrow.setNailBorderAlpha(Double.valueOf(nailBorderAlpha));
                }

                String nailBorderThickness = arrowElement.attributeValue("nailBorderThickness");
                if (StringUtils.isNotEmpty(nailBorderThickness)) {
                    arrow.setNailBorderThickness(Integer.valueOf(nailBorderThickness));
                }

                String nailRadius = arrowElement.attributeValue("nailRadius");
                if (StringUtils.isNotEmpty(nailRadius)) {
                    arrow.setNailRadius(Integer.valueOf(nailRadius));
                }

                String radius = arrowElement.attributeValue("radius");
                if (StringUtils.isNotEmpty(radius)) {
                    arrow.setRadius(radius);
                }

                String startWidth = arrowElement.attributeValue("startWidth");
                if (StringUtils.isNotEmpty(startWidth)) {
                    arrow.setStartWidth(Integer.valueOf(startWidth));
                }

                chart.addArrows(arrow);
            }
        }
    }
}