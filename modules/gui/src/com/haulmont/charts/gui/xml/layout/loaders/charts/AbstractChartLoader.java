/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.haulmont.bali.util.Dom4j;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.data.MapDataItem;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.cuba.gui.GuiDevelopmentException;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import java.util.List;

public abstract class AbstractChartLoader<T extends Chart> extends ChartModelLoader<T> {

    @Override
    public void loadComponent() {
        assignFrame(resultComponent);

        loadWidth(resultComponent, element);
        loadHeight(resultComponent, element);

        loadVisible(resultComponent, element);
        loadEnable(resultComponent, element);
        loadStyleName(resultComponent, element);
        loadAlign(resultComponent, element);

        loadIcon(resultComponent, element);
        loadCaption(resultComponent, element);
        loadDescription(resultComponent, element);

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

    protected void loadChartData(T chart, Element element) {
        Element dataElement = element.element("data");
        if (dataElement != null) {
            ListDataProvider listDataProvider = new ListDataProvider();

            for (Object item : dataElement.elements("item")) {
                Element itemElement = (Element) item;
                MapDataItem dataItem = new MapDataItem();

                for (Element property : Dom4j.elements(itemElement, "property")) {
                    loadDataItem(property, dataItem);
                }

                listDataProvider.addItem(dataItem);
                chart.setDataProvider(listDataProvider);
            }
        }
    }

    protected void checkDatasource(Element element) {
        String datasource = element.attributeValue("datasource");
        Element dataSetElement = element.element("dataSet");
        if (dataSetElement != null && StringUtils.isNotEmpty(datasource)) {
            throw new GuiDevelopmentException(
                    String.format("You cannot use chart '%s' with both data element and datasource property defined",
                            resultComponent.getId()),
                    context.getCurrentFrameId()
            );
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
                    label.setRotation(Integer.parseInt(rotation));
                }

                String size = labelElement.attributeValue("size");
                if (StringUtils.isNotEmpty(size)) {
                    label.setSize(Integer.parseInt(size));
                }

                String text = labelElement.attributeValue("text");
                if (StringUtils.isNotEmpty(text)) {
                    label.setText(loadResourceString(text));
                }

                String tabIndex = labelElement.attributeValue("tabIndex");
                if (StringUtils.isNotEmpty(tabIndex)) {
                    label.setTabIndex(Integer.parseInt(tabIndex));
                }

                String url = labelElement.attributeValue("url");
                if (StringUtils.isNotEmpty(url)) {
                    label.setUrl(url);
                }

                String x = labelElement.attributeValue("x");
                if (StringUtils.isNotEmpty(x)) {
                    label.setX(Integer.parseInt(x));
                }

                String y = labelElement.attributeValue("y");
                if (StringUtils.isNotEmpty(y)) {
                    label.setY(Integer.parseInt(y));
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
                    title.setSize(Integer.parseInt(size));
                }

                String tabIndex = titleElement.attributeValue("tabIndex");
                if (StringUtils.isNotEmpty(tabIndex)) {
                    title.setTabIndex(Integer.parseInt(tabIndex));
                }

                String text = titleElement.attributeValue("text");
                if (StringUtils.isNotEmpty(text)) {
                    title.setText(loadResourceString(text));
                }

                chart.addTitles(title);
            }
        }
    }

    protected void loadConfiguration(T chart, Element element) {
        loadLabels(chart, element);
        loadTitles(chart, element);

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

        String autoTransform = element.attributeValue("autoTransform");
        if (StringUtils.isNotEmpty(autoTransform)) {
            chart.setAutoTransform(Boolean.valueOf(autoTransform));
        }

        String backgroundAlpha = element.attributeValue("backgroundAlpha");
        if (StringUtils.isNotEmpty(backgroundAlpha)) {
            chart.setBackgroundAlpha(Double.valueOf(backgroundAlpha));
        }

        String backgroundColor = element.attributeValue("backgroundColor");
        if (StringUtils.isNotEmpty(backgroundColor)) {
            chart.setBackgroundColor(Color.valueOf(backgroundColor));
        }

        Element balloonElement = element.element("balloon");
        if (balloonElement != null) {
            chart.setBalloon(loadBalloon(balloonElement));
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

        Element exportElement = element.element("export");
        if (exportElement != null) {
            chart.setExport(loadExport(exportElement));
        }

        String fontFamily = element.attributeValue("fontFamily");
        if (StringUtils.isEmpty(fontFamily)) {
            chart.setFontFamily(fontFamily);
        }

        String fontSize = element.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            chart.setFontSize(Integer.parseInt(fontSize));
        }

        String handDrawn = element.attributeValue("handDrawn");
        if (StringUtils.isNotEmpty(handDrawn)) {
            chart.setHandDrawn(Boolean.valueOf(handDrawn));
        }

        String handDrawScatter = element.attributeValue("handDrawScatter");
        if (StringUtils.isNotEmpty(handDrawScatter)) {
            chart.setHandDrawScatter(Integer.parseInt(handDrawScatter));
        }

        String handDrawThickness = element.attributeValue("handDrawThickness");
        if (StringUtils.isNotEmpty(handDrawThickness)) {
            chart.setHandDrawThickness(Integer.parseInt(handDrawThickness));
        }

        String hideBalloonTime = element.attributeValue("hideBalloonTime");
        if (StringUtils.isNotEmpty(hideBalloonTime)) {
            chart.setHideBalloonTime(Integer.parseInt(hideBalloonTime));
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
            chart.setPercentPrecision(Integer.parseInt(percentPrecision));
        }

        String precision = element.attributeValue("precision");
        if (StringUtils.isNotEmpty(precision)) {
            chart.setPrecision(Integer.parseInt(precision));
        }

        String processCount = element.attributeValue("processCount");
        if (StringUtils.isNotEmpty(processCount)) {
            chart.setProcessCount(Integer.parseInt(processCount));
        }

        String processTimeout = element.attributeValue("processTimeout");
        if (StringUtils.isNotEmpty(processTimeout)) {
            chart.setProcessTimeout(Integer.parseInt(processTimeout));
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
            chart.setTouchClickDuration(Integer.parseInt(touchClickDuration));
        }

        String defs = element.attributeValue("defs");
        if (StringUtils.isNotEmpty(defs)) {
            chart.setDefs(defs);
        }

        Element responsiveElement = element.element("responsive");
        if (responsiveElement != null) {
            Responsive responsive = new Responsive();
            loadResponsive(responsive, responsiveElement);
            chart.setResponsive(responsive);
        }

        Element nativeJson = element.element("nativeJson");
        if (nativeJson != null) {
            String nativeJsonString = nativeJson.getTextTrim();
            try {
                JsonParser parser = new JsonParser();
                parser.parse(nativeJsonString);
            } catch (JsonSyntaxException e) {
                throw new GuiDevelopmentException("Unable to parse JSON from XML chart configuration", context.getFullFrameId());
            }

            resultComponent.setNativeJson(nativeJsonString);
        }
    }

    protected void loadResponsive(Responsive responsive, Element responsiveElement) {
        loadRules(responsive, responsiveElement);

        String responsiveValue = responsiveElement.attributeValue("enabled");
        if (StringUtils.isNotEmpty(responsiveValue)) {
            responsive.setEnabled(Boolean.parseBoolean(responsiveValue));
        }
    }

    protected void loadRules(Responsive responsive, Element responsiveElement) {
        Element rulesElement = responsiveElement.element("rules");
        if (rulesElement != null) {
            for (Element ruleElement : Dom4j.elements(rulesElement, "rule")) {
                Rule rule = new Rule();

                String maxHeight = ruleElement.attributeValue("maxHeight");
                if (StringUtils.isNotEmpty(maxHeight)) {
                    rule.setMaxHeight(Integer.parseInt(maxHeight));
                }

                String minHeight = ruleElement.attributeValue("minHeight");
                if (StringUtils.isNotEmpty(minHeight)) {
                    rule.setMinHeight(Integer.parseInt(minHeight));
                }

                String maxWidth = ruleElement.attributeValue("maxWidth");
                if (StringUtils.isNotEmpty(maxWidth)) {
                    rule.setMaxWidth(Integer.parseInt(maxWidth));
                }

                String minWidth = ruleElement.attributeValue("minWidth");
                if (StringUtils.isNotEmpty(minWidth)) {
                    rule.setMinWidth(Integer.parseInt(minWidth));
                }

                rule.setRawOverridesJson(ruleElement.getTextTrim());
                responsive.addRule(rule);
            }
        }
    }

    protected void loadStartEffect(HasStartEffect chart, Element element) {
        String startDuration = element.attributeValue("startDuration");
        if (StringUtils.isNotEmpty(startDuration)) {
            chart.setStartDuration(Integer.parseInt(startDuration));
        }

        String startEffect = element.attributeValue("startEffect");
        if (StringUtils.isNotEmpty(startEffect)) {
            chart.setStartEffect(AnimationEffect.valueOf(startEffect));
        }
    }

    protected void loadColors(HasColors chart, Element element) {
        Element colorsElement = element.element("colors");
        if (colorsElement != null) {
            List<Color> colors = loadColors(colorsElement);
            if (CollectionUtils.isNotEmpty(colors)) {
                chart.setColors(colors);
            }
        }
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
            image.setHeight(Integer.parseInt(height));
        }

        String offsetX = element.attributeValue("offsetX");
        if (StringUtils.isNotEmpty(offsetX)) {
            image.setOffsetX(Integer.parseInt(offsetX));
        }

        String offsetY = element.attributeValue("offsetY");
        if (StringUtils.isNotEmpty(offsetY)) {
            image.setOffsetY(Integer.parseInt(offsetY));
        }

        String outlineColor = element.attributeValue("outlineColor");
        if (StringUtils.isNotEmpty(outlineColor)) {
            image.setOutlineColor(Color.valueOf(outlineColor));
        }

        String rotation = element.attributeValue("rotation");
        if (StringUtils.isNotEmpty(rotation)) {
            image.setRotation(Integer.parseInt(rotation));
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
            image.setWidth(Integer.parseInt(width));
        }

        return image;
    }
}