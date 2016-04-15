/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.cuba.gui.GuiDevelopmentException;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import java.util.List;

/**
 */
public abstract class AbstractChartLoader<T extends AbstractChart> extends ChartModelLoader<T, Chart> {

    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(Chart.class);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
        assignFrame(resultComponent);

        loadWidth(resultComponent, element);
        loadHeight(resultComponent, element);

        loadVisible(resultComponent, element);
        loadEnable(resultComponent, element);
        loadStyleName(resultComponent, element);

        loadDatasource(resultComponent, element);
    }

    protected void loadDatasource(Chart chart, Element element) {
        String datasource = element.attributeValue("datasource");
        if (StringUtils.isNotEmpty(datasource)) {
            Datasource ds = context.getDsContext().get(datasource);
            if (ds == null) {
                throw new GuiDevelopmentException("Can't find datasource by name: " + datasource, context.getCurrentFrameId());
            }

            if (!(ds instanceof CollectionDatasource)) {
                throw new GuiDevelopmentException("Not a CollectionDatasource: " + datasource, context.getCurrentFrameId());
            }

            chart.setDatasource((CollectionDatasource) ds);
        }
    }

    protected void loadLabels(T chart, Element element) {
        Element allLabels = element.element("allLabels");
        if (allLabels != null) {
            for (Object labelItem : allLabels.elements("label")) {
                Element labelElement = (Element) labelItem;

                Label label = new Label();

                String align = labelElement.attributeValue("align");
                if (StringUtils.isNotEmpty(align)) {
                    label.setAlign(Align.valueOf(align));
                }

                String alpha = labelElement.attributeValue("alpha");
                if (StringUtils.isNotEmpty(alpha)) {
                    label.setAlpha(Double.valueOf(alpha));
                }

                String bold = labelElement.attributeValue("bold");
                if (StringUtils.isNotEmpty(bold)) {
                    label.setBold(Boolean.valueOf(bold));
                }

                String color = labelElement.attributeValue("color");
                if (StringUtils.isNotEmpty(color)) {
                    label.setColor(Color.valueOf(color));
                }

                String id = labelElement.attributeValue("id");
                if (StringUtils.isNotEmpty(id)) {
                    label.setId(id);
                }

                String rotation = labelElement.attributeValue("rotation");
                if (StringUtils.isNotEmpty(rotation)) {
                    label.setRotation(Integer.valueOf(rotation));
                }

                String size = labelElement.attributeValue("size");
                if (StringUtils.isNotEmpty(size)) {
                    label.setSize(Integer.valueOf(size));
                }

                String text = labelElement.attributeValue("text");
                if (StringUtils.isNotEmpty(text)) {
                    label.setText(loadResourceString(text));
                }

                String url = labelElement.attributeValue("url");
                if (StringUtils.isNotEmpty(url)) {
                    label.setUrl(url);
                }

                String x = labelElement.attributeValue("x");
                if (StringUtils.isNotEmpty(x)) {
                    label.setX(Integer.valueOf(x));
                }

                String y = labelElement.attributeValue("y");
                if (StringUtils.isNotEmpty(y)) {
                    label.setY(Integer.valueOf(y));
                }

                chart.addLabels(label);
            }
        }
    }

    protected void loadTitles(T chart, Element element) {
        Element titles = element.element("titles");
        if (titles != null) {
            for (Object titleItem : titles.elements("title")) {
                Element titleElement = (Element) titleItem;

                Title title = new Title();

                String alpha = titleElement.attributeValue("alpha");
                if (StringUtils.isNotEmpty(alpha)) {
                    title.setAlpha(Double.valueOf(alpha));
                }

                String bold = titleElement.attributeValue("bold");
                if (StringUtils.isNotEmpty(bold)) {
                    title.setBold(Boolean.valueOf(bold));
                }

                String color = titleElement.attributeValue("color");
                if (StringUtils.isNotEmpty(color)) {
                    title.setColor(Color.valueOf(color));
                }

                String id = titleElement.attributeValue("id");
                if (StringUtils.isNotEmpty(id)) {
                    title.setId(id);
                }

                String size = titleElement.attributeValue("size");
                if (StringUtils.isNotEmpty(size)) {
                    title.setSize(Integer.valueOf(size));
                }

                String text = titleElement.attributeValue("text");
                if (StringUtils.isNotEmpty(text)) {
                    title.setText(loadResourceString(text));
                }

                chart.addTitles(title);
            }
        }
    }

    @Deprecated
    protected void loadBalloon(T chart, Element element) {
        Element balloonElement = element.element("balloon");
        if (balloonElement != null) {
            chart.setBalloon(loadBalloon(balloonElement));
        }
    }

    @Deprecated
    protected void loadExport(T chart, Element element) {
        Element exportElement = element.element("export");
        if (exportElement != null) {
            chart.setExport(loadExport(exportElement));
        }
    }

    protected void loadLegend(AbstractLegend legend, Element legendElement) {
        loadLegendItems(legend, legendElement);

        String align = legendElement.attributeValue("align");
        if (StringUtils.isNotEmpty(align)) {
            legend.setAlign(Align.valueOf(align));
        }

        String autoMargins = legendElement.attributeValue("autoMargins");
        if (StringUtils.isNotEmpty(autoMargins)) {
            legend.setAutoMargins(Boolean.valueOf(autoMargins));
        }

        String backgroundAlpha = legendElement.attributeValue("backgroundAlpha");
        if (StringUtils.isNotEmpty(backgroundAlpha)) {
            legend.setBackgroundAlpha(Double.valueOf(backgroundAlpha));
        }

        String backgroundColor = legendElement.attributeValue("backgroundColor");
        if (StringUtils.isNotEmpty(backgroundColor)) {
            legend.setBackgroundColor(Color.valueOf(backgroundColor));
        }

        String borderAlpha = legendElement.attributeValue("borderAlpha");
        if (StringUtils.isNotEmpty(borderAlpha)) {
            legend.setBorderAlpha(Double.valueOf(borderAlpha));
        }

        String borderColor = legendElement.attributeValue("borderColor");
        if (StringUtils.isNotEmpty(borderColor)) {
            legend.setBackgroundColor(Color.valueOf(borderColor));
        }

        String bottom = legendElement.attributeValue("bottom");
        if (StringUtils.isNotEmpty(bottom)) {
            legend.setBottom(Integer.valueOf(bottom));
        }

        String color = legendElement.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            legend.setColor(Color.valueOf(color));
        }

        String divId = legendElement.attributeValue("divId");
        if (StringUtils.isNotEmpty(divId)) {
            legend.setDivId(divId);
        }

        String enabled = legendElement.attributeValue("enabled");
        if (StringUtils.isNotEmpty(enabled)) {
            legend.setEnabled(Boolean.valueOf(enabled));
        }

        String equalWidths = legendElement.attributeValue("equalWidths");
        if (StringUtils.isNotEmpty(equalWidths)) {
            legend.setEqualWidths(Boolean.valueOf(equalWidths));
        }

        String fontSize = legendElement.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            legend.setFontSize(Integer.valueOf(fontSize));
        }

        String forceWidth = legendElement.attributeValue("forceWidth");
        if (StringUtils.isNotEmpty(forceWidth)) {
            legend.setForceWidth(Boolean.valueOf(forceWidth));
        }

        String gradientRotation = legendElement.attributeValue("gradientRotation");
        if (StringUtils.isNotEmpty(gradientRotation)) {
            legend.setGradientRotation(Integer.valueOf(gradientRotation));
        }

        String horizontalGap = legendElement.attributeValue("horizontalGap");
        if (StringUtils.isNotEmpty(horizontalGap)) {
            legend.setHorizontalGap(Integer.valueOf(horizontalGap));
        }

        String labelWidth = legendElement.attributeValue("labelWidth");
        if (StringUtils.isNotEmpty(labelWidth)) {
            legend.setLabelWidth(Integer.valueOf(labelWidth));
        }

        String labelText = legendElement.attributeValue("labelText");
        if (StringUtils.isNotEmpty(labelText)) {
            legend.setLabelText(loadResourceString(labelText));
        }

        String left = legendElement.attributeValue("left");
        if (StringUtils.isNotEmpty(left)) {
            legend.setLeft(Integer.valueOf(left));
        }

        loadMargins(legend, legendElement);

        String markerBorderAlpha = legendElement.attributeValue("markerBorderAlpha");
        if (StringUtils.isNotEmpty(markerBorderAlpha)) {
            legend.setMarkerBorderAlpha(Double.valueOf(markerBorderAlpha));
        }

        String markerBorderColor = legendElement.attributeValue("markerBorderColor");
        if (StringUtils.isNotEmpty(markerBorderColor)) {
            legend.setMarkerBorderColor(Color.valueOf(markerBorderColor));
        }

        String markerBorderThickness = legendElement.attributeValue("markerBorderThickness");
        if (StringUtils.isNotEmpty(markerBorderThickness)) {
            legend.setMarkerBorderThickness(Integer.valueOf(markerBorderThickness));
        }

        String markerDisabledColor = legendElement.attributeValue("markerDisabledColor");
        if (StringUtils.isNotEmpty(markerDisabledColor)) {
            legend.setMarkerDisabledColor(Color.valueOf(markerDisabledColor));
        }

        String markerLabelGap = legendElement.attributeValue("markerLabelGap");
        if (StringUtils.isNotEmpty(markerLabelGap)) {
            legend.setMarkerLabelGap(Integer.valueOf(markerLabelGap));
        }

        String markerSize = legendElement.attributeValue("markerSize");
        if (StringUtils.isNotEmpty(markerSize)) {
            legend.setMarkerSize(Integer.valueOf(markerSize));
        }

        String markerType = legendElement.attributeValue("markerType");
        if (StringUtils.isNotEmpty(markerType)) {
            legend.setMarkerType(MarkerType.valueOf(markerType));
        }

        String maxColumns = legendElement.attributeValue("maxColumns");
        if (StringUtils.isNotEmpty(maxColumns)) {
            legend.setMaxColumns(Integer.valueOf(maxColumns));
        }

        String periodValueText = legendElement.attributeValue("periodValueText");
        if (StringUtils.isNotEmpty(periodValueText)) {
            legend.setPeriodValueText(loadResourceString(periodValueText));
        }

        String position = legendElement.attributeValue("position");
        if (StringUtils.isNotEmpty(position)) {
            legend.setPosition(LegendPosition.valueOf(position));
        }

        String reversedOrder = legendElement.attributeValue("reversedOrder");
        if (StringUtils.isNotEmpty(reversedOrder)) {
            legend.setReversedOrder(Boolean.valueOf(reversedOrder));
        }

        String right = legendElement.attributeValue("right");
        if (StringUtils.isNotEmpty(right)) {
            legend.setRight(Integer.valueOf(right));
        }

        String rollOverColor = legendElement.attributeValue("rollOverColor");
        if (StringUtils.isNotEmpty(rollOverColor)) {
            legend.setRollOverColor(Color.valueOf(rollOverColor));
        }

        String rollOverGraphAlpha = legendElement.attributeValue("rollOverGraphAlpha");
        if (StringUtils.isNotEmpty(rollOverGraphAlpha)) {
            legend.setRollOverGraphAlpha(Double.valueOf(rollOverGraphAlpha));
        }

        String showEntries = legendElement.attributeValue("showEntries");
        if (StringUtils.isNotEmpty(showEntries)) {
            legend.setShowEntries(Boolean.valueOf(showEntries));
        }

        String spacing = legendElement.attributeValue("spacing");
        if (StringUtils.isNotEmpty(spacing)) {
            legend.setSpacing(Integer.valueOf(spacing));
        }

        String switchable = legendElement.attributeValue("switchable");
        if (StringUtils.isNotEmpty(switchable)) {
            legend.setSwitchable(Boolean.valueOf(switchable));
        }

        String switchColor = legendElement.attributeValue("switchColor");
        if (StringUtils.isNotEmpty(switchColor)) {
            legend.setSwitchColor(Color.valueOf(switchColor));
        }

        String switchType = legendElement.attributeValue("switchType");
        if (StringUtils.isNotEmpty(switchType)) {
            legend.setSwitchType(LegendSwitch.valueOf(switchType));
        }

        String textClickEnabled = legendElement.attributeValue("textClickEnabled");
        if (StringUtils.isNotEmpty(textClickEnabled)) {
            legend.setTextClickEnabled(Boolean.valueOf(textClickEnabled));
        }

        String top = legendElement.attributeValue("top");
        if (StringUtils.isNotEmpty(top)) {
            legend.setTop(Integer.valueOf(top));
        }

        String useGraphSettings = legendElement.attributeValue("useGraphSettings");
        if (StringUtils.isNotEmpty(useGraphSettings)) {
            legend.setUseGraphSettings(Boolean.valueOf(useGraphSettings));
        }

        String useMarkerColorForLabels = legendElement.attributeValue("useMarkerColorForLabels");
        if (StringUtils.isNotEmpty(useMarkerColorForLabels)) {
            legend.setUseMarkerColorForLabels(Boolean.valueOf(useMarkerColorForLabels));
        }

        String useMarkerColorForValues = legendElement.attributeValue("useMarkerColorForValues");
        if (StringUtils.isNotEmpty(useMarkerColorForValues)) {
            legend.setUseMarkerColorForValues(Boolean.valueOf(useMarkerColorForValues));
        }

        String valueAlign = legendElement.attributeValue("valueAlign");
        if (StringUtils.isNotEmpty(valueAlign)) {
            legend.setValueAlign(ValueAlign.valueOf(valueAlign));
        }

        String valueFunction = legendElement.elementText("valueFunction");
        if (StringUtils.isNotBlank(valueFunction)) {
            legend.setValueFunction(new JsFunction(valueFunction));
        }

        String valueText = legendElement.attributeValue("valueText");
        if (StringUtils.isNotEmpty(valueText)) {
            legend.setValueText(loadResourceString(valueText));
        }

        String valueWidth = legendElement.attributeValue("valueWidth");
        if (StringUtils.isNotEmpty(valueWidth)) {
            legend.setValueWidth(Integer.valueOf(valueWidth));
        }

        String verticalGap = legendElement.attributeValue("verticalGap");
        if (StringUtils.isNotEmpty(verticalGap)) {
            legend.setVerticalGap(Integer.valueOf(verticalGap));
        }

        String width = legendElement.attributeValue("width");
        if (StringUtils.isNotEmpty(width)) {
            legend.setWidth(Integer.valueOf(width));
        }
    }

    protected void loadLegendItems(AbstractLegend legend, Element legendElement) {
        Element legendDataElement = legendElement.element("data");
        if (legendDataElement != null) {
            for (Object dataItem : legendDataElement.elements("item")) {
                Element dataElement = (Element) dataItem;

                LegendItem legendItem = new LegendItem();

                String title = dataElement.attributeValue("title");
                if (StringUtils.isNotEmpty(title)) {
                    legendItem.setTitle(loadResourceString(title));
                }

                String color = dataElement.attributeValue("color");
                if (StringUtils.isNotEmpty(color)) {
                    legendItem.setColor(Color.valueOf(color));
                }

                String markerType = dataElement.attributeValue("markerType");
                if (StringUtils.isNotEmpty(markerType)) {
                    legendItem.setMarkerType(MarkerType.valueOf(markerType));
                }

                legend.addItems(legendItem);
            }
        }
    }

    protected void loadConfiguration(T chart, Element element) {
        loadLabels(chart, element);
        loadTitles(chart, element);
        loadBalloon(chart, element);
        loadExport(chart, element);

        String accessible = element.attributeValue("accessible");
        if (StringUtils.isNotEmpty(accessible)) {
            chart.setAccessible(Boolean.valueOf(accessible));
        }

        String accessibleTitle = element.attributeValue("accessibleTitle");
        if (StringUtils.isNotEmpty(accessibleTitle)) {
            chart.setAccessibleTitle(accessibleTitle);
        }

        String addClassNames = element.attributeValue("addClassNames");
        if (StringUtils.isNotEmpty(addClassNames)) {
            chart.setAddClassNames(Boolean.valueOf(addClassNames));
        }

        String additionalFields = element.attributeValue("additionalFields");
        if (StringUtils.isNotEmpty(additionalFields)) {
            chart.addAdditionalFields(additionalFields.split(","));
        }

        String autoDisplay = element.attributeValue("autoDisplay");
        if (StringUtils.isNotEmpty(autoDisplay)) {
            chart.setAutoDisplay(Boolean.valueOf(autoDisplay));
        }

        String autoResize = element.attributeValue("autoResize");
        if (StringUtils.isNotEmpty(autoResize)) {
            chart.setAutoResize(Boolean.valueOf(autoResize));
        }

        String backgroundAlpha = element.attributeValue("backgroundAlpha");
        if (StringUtils.isNotEmpty(backgroundAlpha)) {
            chart.setBackgroundAlpha(Double.valueOf(backgroundAlpha));
        }

        String backgroundColor = element.attributeValue("backgroundColor");
        if (StringUtils.isNotEmpty(backgroundColor)) {
            chart.setBackgroundColor(Color.valueOf(backgroundColor));
        }

        String classNamePrefix = element.attributeValue("classNamePrefix");
        if (StringUtils.isNotEmpty(classNamePrefix)) {
            chart.setClassNamePrefix(classNamePrefix);
        }

        chart.setCreditsPosition(loadCreditsPosition(element));

        String borderAlpha = element.attributeValue("borderAlpha");
        if (StringUtils.isNotEmpty(borderAlpha)) {
            chart.setBorderAlpha(Double.valueOf(borderAlpha));
        }

        String borderColor = element.attributeValue("borderColor");
        if (StringUtils.isNotEmpty(borderColor)) {
            chart.setBorderColor(Color.valueOf(borderColor));
        }

        String color = element.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            chart.setColor(Color.valueOf(color));
        }

        String decimalSeparator = element.attributeValue("decimalSeparator");
        if (StringUtils.isNotEmpty(decimalSeparator)) {
            chart.setDecimalSeparator(decimalSeparator);
        }

        String fontFamily = element.attributeValue("fontFamily");
        if (StringUtils.isEmpty(fontFamily)) {
            chart.setFontFamily(fontFamily);
        }

        String fontSize = element.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            chart.setFontSize(Integer.valueOf(fontSize));
        }

        String handDrawn = element.attributeValue("handDrawn");
        if (StringUtils.isNotEmpty(handDrawn)) {
            chart.setHandDrawn(Boolean.valueOf(handDrawn));
        }

        String handDrawScatter = element.attributeValue("handDrawScatter");
        if (StringUtils.isNotEmpty(handDrawScatter)) {
            chart.setHandDrawScatter(Integer.valueOf(handDrawScatter));
        }

        String handDrawThickness = element.attributeValue("handDrawThickness");
        if (StringUtils.isNotEmpty(handDrawThickness)) {
            chart.setHandDrawThickness(Integer.valueOf(handDrawThickness));
        }

        String hideBalloonTime = element.attributeValue("hideBalloonTime");
        if (StringUtils.isNotEmpty(hideBalloonTime)) {
            chart.setHideBalloonTime(Integer.valueOf(hideBalloonTime));
        }

        String language = element.attributeValue("language");
        if (StringUtils.isNotEmpty(language)) {
            chart.setLanguage(language);
        }

        Element legendElement = element.element("legend");
        if (legendElement != null) {
            Legend legend = new Legend();
            loadLegend(legend, legendElement);
            chart.setLegend(legend);
        }

        String panEventsEnabled = element.attributeValue("panEventsEnabled");
        if (StringUtils.isNotEmpty(panEventsEnabled)) {
            chart.setPanEventsEnabled(Boolean.valueOf(panEventsEnabled));
        }

        String percentPrecision = element.attributeValue("percentPrecision");
        if (StringUtils.isNotEmpty(percentPrecision)) {
            chart.setPercentPrecision(Integer.valueOf(percentPrecision));
        }

        String precision = element.attributeValue("precision");
        if (StringUtils.isNotEmpty(precision)) {
            chart.setPrecision(Integer.valueOf(precision));
        }

        String processCount = element.attributeValue("processCount");
        if (StringUtils.isNotEmpty(processCount)) {
            chart.setProcessCount(Integer.valueOf(processCount));
        }

        String processTimeout = element.attributeValue("processTimeout");
        if (StringUtils.isNotEmpty(processTimeout)) {
            chart.setProcessTimeout(Integer.valueOf(processTimeout));
        }

        String svgIcons = element.attributeValue("svgIcons");
        if (StringUtils.isNotEmpty(svgIcons)) {
            chart.setSvgIcons(Boolean.valueOf(svgIcons));
        }

        String tapToActivate = element.attributeValue("tapToActivate");
        if (StringUtils.isNotEmpty(tapToActivate)) {
            chart.setTapToActivate(Boolean.valueOf(tapToActivate));
        }

        String usePrefixes = element.attributeValue("usePrefixes");
        if (StringUtils.isNotEmpty(usePrefixes)) {
            chart.setUsePrefixes(Boolean.valueOf(usePrefixes));
        }

        String theme = element.attributeValue("theme");
        if (StringUtils.isNotEmpty(theme)) {
            chart.setTheme(ChartTheme.valueOf(theme));
        }

        String thousandsSeparator = element.attributeValue("thousandsSeparator");
        if (StringUtils.isNotEmpty(thousandsSeparator)) {
            chart.setThousandsSeparator(thousandsSeparator);
        }

        String touchClickDuration = element.attributeValue("touchClickDuration");
        if (StringUtils.isNotEmpty(touchClickDuration)) {
            chart.setTouchClickDuration(Integer.valueOf(touchClickDuration));
        }

        String defs = element.attributeValue("defs");
        if (StringUtils.isNotEmpty(defs)) {
            chart.setDefs(defs);
        }
    }

    protected void loadStartEffect(HasStartEffect chart, Element element) {
        String startDuration = element.attributeValue("startDuration");
        if (StringUtils.isNotEmpty(startDuration)) {
            chart.setStartDuration(Integer.valueOf(startDuration));
        }

        String startEffect = element.attributeValue("startEffect");
        if (StringUtils.isNotEmpty(startEffect)) {
            chart.setStartEffect(AnimationEffect.valueOf(startEffect));
        }
    }

    @Deprecated
    protected void loadColors(HasColors chart, Element element) {
        Element colorsElement = element.element("colors");
        if (colorsElement != null) {
            List<Color> colors = loadColors(colorsElement);
            if (CollectionUtils.isNotEmpty(colors)) {
                chart.setColors(colors);
            }
        }
    }

    protected void loadAbstractAxis(AbstractAxis axis, Element element) {
        loadGuides(axis, element);
        loadDateFormats(axis, element);

        String autoGridCount = element.attributeValue("autoGridCount");
        if (StringUtils.isNotEmpty(autoGridCount)) {
            axis.setAutoGridCount(Boolean.valueOf(autoGridCount));
        }

        String autoRotateAngle = element.attributeValue("autoRotateAngle");
        if (StringUtils.isNotEmpty(autoRotateAngle)) {
            axis.setAutoRotateAngle(Integer.valueOf(autoRotateAngle));
        }

        String autoRotateCount = element.attributeValue("autoRotateCount");
        if (StringUtils.isNotEmpty(autoRotateCount)) {
            axis.setAutoRotateCount(Integer.valueOf(autoRotateCount));
        }

        String axisAlpha = element.attributeValue("axisAlpha");
        if (StringUtils.isNotEmpty(axisAlpha)) {
            axis.setAxisAlpha(Double.valueOf(axisAlpha));
        }

        String axisColor = element.attributeValue("axisColor");
        if (StringUtils.isNotEmpty(axisColor)) {
            axis.setAxisColor(Color.valueOf(axisColor));
        }

        String axisThickness = element.attributeValue("axisThickness");
        if (StringUtils.isNotEmpty(axisThickness)) {
            axis.setAxisThickness(Integer.valueOf(axisThickness));
        }

        Element balloonElement = element.element("balloon");
        if (balloonElement != null) {
            axis.setBalloon(loadBalloon(balloonElement));
        }

        String boldLabels = element.attributeValue("boldLabels");
        if (StringUtils.isNotEmpty(boldLabels)) {
            axis.setCenterLabels(Boolean.valueOf(boldLabels));
        }

        String boldPeriodBeginning = element.attributeValue("boldPeriodBeginning");
        if (StringUtils.isNotEmpty(boldPeriodBeginning)) {
            axis.setBoldPeriodBeginning(Boolean.valueOf(boldPeriodBeginning));
        }

        String centerLabelOnFullPeriod = element.attributeValue("centerLabelOnFullPeriod");
        if (StringUtils.isNotEmpty(centerLabelOnFullPeriod)) {
            axis.setCenterLabelOnFullPeriod(Boolean.valueOf(centerLabelOnFullPeriod));
        }

        String centerLabels = element.attributeValue("centerLabels");
        if (StringUtils.isNotEmpty(centerLabels)) {
            axis.setBoldLabels(Boolean.valueOf(centerLabels));
        }

        String color = element.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            axis.setColor(Color.valueOf(color));
        }

        String dashLength = element.attributeValue("dashLength");
        if (StringUtils.isNotEmpty(dashLength)) {
            axis.setDashLength(Integer.valueOf(dashLength));
        }

        String fillAlpha = element.attributeValue("fillAlpha");
        if (StringUtils.isNotEmpty(fillAlpha)) {
            axis.setFillAlpha(Double.valueOf(fillAlpha));
        }

        String fillColor = element.attributeValue("fillColor");
        if (StringUtils.isNotEmpty(fillColor)) {
            axis.setFillColor(Color.valueOf(fillColor));
        }

        String fontSize = element.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            axis.setFontSize(Integer.valueOf(fontSize));
        }

        String gridAlpha = element.attributeValue("gridAlpha");
        if (StringUtils.isNotEmpty(gridAlpha)) {
            axis.setGridAlpha(Double.valueOf(gridAlpha));
        }

        String gridColor = element.attributeValue("gridColor");
        if (StringUtils.isNotEmpty(gridColor)) {
            axis.setGridColor(Color.valueOf(gridColor));
        }

        String gridCount = element.attributeValue("gridCount");
        if (StringUtils.isNotEmpty(gridCount)) {
            axis.setGridCount(Integer.valueOf(gridCount));
        }

        String gridThickness = element.attributeValue("gridThickness");
        if (StringUtils.isNotEmpty(gridThickness)) {
            axis.setGridThickness(Integer.valueOf(gridThickness));
        }

        String ignoreAxisWidth = element.attributeValue("ignoreAxisWidth");
        if (StringUtils.isNotEmpty(ignoreAxisWidth)) {
            axis.setIgnoreAxisWidth(Boolean.valueOf(ignoreAxisWidth));
        }

        String inside = element.attributeValue("inside");
        if (StringUtils.isNotEmpty(inside)) {
            axis.setInside(Boolean.valueOf(inside));
        }

        String labelFrequency = element.attributeValue("labelFrequency");
        if (StringUtils.isNotEmpty(labelFrequency)) {
            axis.setLabelFrequency(Double.valueOf(labelFrequency));
        }

        String labelOffset = element.attributeValue("labelOffset");
        if (StringUtils.isNotEmpty(labelOffset)) {
            axis.setLabelOffset(Integer.valueOf(labelOffset));
        }

        String labelRotation = element.attributeValue("labelRotation");
        if (StringUtils.isNotEmpty(labelRotation)) {
            axis.setLabelRotation(Integer.valueOf(labelRotation));
        }

        String labelsEnabled = element.attributeValue("labelsEnabled");
        if (StringUtils.isNotEmpty(labelsEnabled)) {
            axis.setLabelsEnabled(Boolean.valueOf(labelsEnabled));
        }

        String markPeriodChange = element.attributeValue("markPeriodChange");
        if (StringUtils.isNotEmpty(markPeriodChange)) {
            axis.setMarkPeriodChange(Boolean.valueOf(markPeriodChange));
        }

        String minHorizontalGap = element.attributeValue("minHorizontalGap");
        if (StringUtils.isNotEmpty(minHorizontalGap)) {
            axis.setMinHorizontalGap(Integer.valueOf(minHorizontalGap));
        }

        String minorGridAlpha = element.attributeValue("minorGridAlpha");
        if (StringUtils.isNotEmpty(minorGridAlpha)) {
            axis.setMinorGridAlpha(Double.valueOf(minorGridAlpha));
        }

        String minorGridEnabled = element.attributeValue("minorGridEnabled");
        if (StringUtils.isNotEmpty(minorGridEnabled)) {
            axis.setMinorGridEnabled(Boolean.valueOf(minorGridEnabled));
        }

        String minVerticalGap = element.attributeValue("minVerticalGap");
        if (StringUtils.isNotEmpty(minVerticalGap)) {
            axis.setMinVerticalGap(Integer.valueOf(minVerticalGap));
        }

        String minorTickLength = element.attributeValue("minorTickLength");
        if (StringUtils.isNotEmpty(minorTickLength)) {
            axis.setMinorTickLength(Integer.valueOf(minorTickLength));
        }

        String offset = element.attributeValue("offset");
        if (StringUtils.isNotEmpty(offset)) {
            axis.setOffset(Integer.valueOf(offset));
        }

        String position = element.attributeValue("position");
        if (StringUtils.isNotEmpty(position)) {
            axis.setPosition(Position.valueOf(position));
        }

        String showFirstLabel = element.attributeValue("showFirstLabel");
        if (StringUtils.isNotEmpty(showFirstLabel)) {
            axis.setShowFirstLabel(Boolean.valueOf(showFirstLabel));
        }

        String showLastLabel = element.attributeValue("showLastLabel");
        if (StringUtils.isNotEmpty(showLastLabel)) {
            axis.setShowLastLabel(Boolean.valueOf(showLastLabel));
        }

        String tickLength = element.attributeValue("tickLength");
        if (StringUtils.isNotEmpty(tickLength)) {
            axis.setTickLength(Integer.valueOf(tickLength));
        }

        String title = element.attributeValue("title");
        if (StringUtils.isNotEmpty(title)) {
            axis.setTitle(loadResourceString(title));
        }

        String titleBold = element.attributeValue("titleBold");
        if (StringUtils.isNotEmpty(titleBold)) {
            axis.setTitleBold(Boolean.valueOf(titleBold));
        }

        String titleColor = element.attributeValue("titleColor");
        if (StringUtils.isNotEmpty(titleColor)) {
            axis.setTitleColor(Color.valueOf(titleColor));
        }

        String titleFontSize = element.attributeValue("titleFontSize");
        if (StringUtils.isNotEmpty(titleFontSize)) {
            axis.setTitleFontSize(Integer.valueOf(titleFontSize));
        }

        String titleRotation = element.attributeValue("titleRotation");
        if (StringUtils.isNotEmpty(titleRotation)) {
            axis.setTitleRotation(Integer.valueOf(titleRotation));
        }
    }

    @Deprecated
    protected void loadDateFormats(AbstractAxis axis, Element element) {
        Element dateFormatsElement = element.element("dateFormats");
        if (dateFormatsElement != null) {
            axis.setDateFormats(loadDateFormats(dateFormatsElement));
        }
    }

    @Deprecated
    protected void loadGuides(AbstractAxis axis, Element element) {
        Element guidesElement = element.element("guides");
        if (guidesElement != null) {
            axis.setGuides(loadGuides(guidesElement));
        }
    }

    protected Pattern loadPattern(Element element) {
        Pattern pattern = new Pattern();

        String url = element.attributeValue("url");
        if (StringUtils.isNotEmpty(url)) {
            pattern.setUrl(url);
        }

        String width = element.attributeValue("width");
        if (StringUtils.isNotEmpty(width)) {
            pattern.setWidth(Integer.valueOf(width));
        }

        String height = element.attributeValue("height");
        if (StringUtils.isNotEmpty(height)) {
            pattern.setHeight(Integer.valueOf(height));
        }

        return pattern;
    }

    protected Image loadImage(Element element) {
        Image image = new Image();

        String balloonColor = element.attributeValue("balloonColor");
        if (StringUtils.isNotEmpty(balloonColor)) {
            image.setBalloonColor(Color.valueOf(balloonColor));
        }

        String balloonText = element.attributeValue("balloonText");
        if (StringUtils.isNotEmpty(balloonText)) {
            image.setBalloonText(balloonText);
        }

        String color = element.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            image.setColor(Color.valueOf(color));
        }

        String height = element.attributeValue("height");
        if (StringUtils.isNotEmpty(height)) {
            image.setHeight(Integer.valueOf(height));
        }

        String offsetX = element.attributeValue("offsetX");
        if (StringUtils.isNotEmpty(offsetX)) {
            image.setOffsetX(Integer.valueOf(offsetX));
        }

        String offsetY = element.attributeValue("offsetY");
        if (StringUtils.isNotEmpty(offsetY)) {
            image.setOffsetY(Integer.valueOf(offsetY));
        }

        String outlineColor = element.attributeValue("outlineColor");
        if (StringUtils.isNotEmpty(outlineColor)) {
            image.setOutlineColor(Color.valueOf(outlineColor));
        }

        String rotation = element.attributeValue("rotation");
        if (StringUtils.isNotEmpty(rotation)) {
            image.setRotation(Integer.valueOf(rotation));
        }

        String svgPath = element.attributeValue("svgPath");
        if (StringUtils.isNotEmpty(svgPath)) {
            image.setSvgPath(svgPath);
        }

        String url = element.attributeValue("url");
        if (StringUtils.isNotEmpty(url)) {
            image.setUrl(url);
        }

        String width = element.attributeValue("width");
        if (StringUtils.isNotEmpty(width)) {
            image.setWidth(Integer.valueOf(width));
        }

        return image;
    }
}