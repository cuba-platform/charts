/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;
import com.haulmont.charts.gui.amcharts.model.charts.StockPanel;
import com.haulmont.charts.gui.components.charts.StockChart;
import com.haulmont.cuba.gui.GuiDevelopmentException;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractComponentLoader;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 */
public class StockChartLoader extends AbstractComponentLoader<StockChart> {

    protected static final String CONFIG_DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(StockChart.class);
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

        StockChartGroup configuration = createConfiguration();
        loadConfiguration(configuration, element);
        resultComponent.setConfiguration(configuration);

        loadDatasources(resultComponent, element);
    }

    protected void loadDatasources(StockChart chart, Element element) {
        Element dataSetsElement = element.element("dataSets");
        if (dataSetsElement != null) {
            for (Object dataSetItem : dataSetsElement.elements("dataSet")) {
                Element dataSetElement = (Element) dataSetItem;
                String id = dataSetElement.attributeValue("id");
                String datasource = dataSetElement.attributeValue("datasource");
                if (StringUtils.isNotEmpty(datasource)) {
                    Datasource ds = context.getDsContext().get(datasource);
                    if (ds == null) {
                        throw new GuiDevelopmentException("Can't find datasource by name: " + datasource, context.getCurrentFrameId());
                    }

                    if (!(ds instanceof CollectionDatasource)) {
                        throw new GuiDevelopmentException("Not a CollectionDatasource: " + datasource, context.getCurrentFrameId());
                    }

                    chart.setDataSetDatasource(id, (CollectionDatasource) ds);
                }
            }
        }
    }

    @Override
    protected void loadWidth(Component component, Element element) {
        final String width = element.attributeValue("width");
        if ("auto".equalsIgnoreCase(width)) {
            component.setWidth("640px");
        } else if (!StringUtils.isBlank(width)) {
            component.setWidth(width);
        } else {
            component.setWidth("640px");
        }
    }

    @Override
    protected void loadHeight(Component component, Element element) {
        final String height = element.attributeValue("height");
        if ("auto".equalsIgnoreCase(height)) {
            component.setHeight("480px");
        } else if (!StringUtils.isBlank(height)) {
            component.setHeight(height);
        } else {
            component.setHeight("480px");
        }
    }

    protected StockChartGroup createConfiguration() {
        return new StockChartGroup();
    }

    protected void loadConfiguration(StockChartGroup chart, Element element) {
        loadBalloon(chart, element);
        loadExport(chart, element);
        loadCategoryAxesSettings(chart, element);
        loadChartCursorSettings(chart, element);
        loadChartScrollbarSettings(chart, element);
        loadDataSetSelector(chart, element);
        loadLegendSettings(chart, element);
        loadPanels(chart, element);
        loadPanelsSettings(chart, element);
        loadPeriodSelector(chart, element);
        loadStockEventsSettings(chart, element);
        loadValueAxesSettings(chart, element);

        String addClassNames = element.attributeValue("addClassNames");
        if (StringUtils.isNotEmpty(addClassNames)) {
            chart.setAddClassNames(Boolean.valueOf(addClassNames));
        }

        String animationPlayed = element.attributeValue("animationPlayed");
        if (StringUtils.isNotEmpty(animationPlayed)) {
            chart.setAnimationPlayed(Boolean.valueOf(animationPlayed));
        }

        String autoResize = element.attributeValue("autoResize");
        if (StringUtils.isNotEmpty(autoResize)) {
            chart.setAutoResize(Boolean.valueOf(autoResize));
        }

        String classNamePrefix = element.attributeValue("classNamePrefix");
        if (StringUtils.isNotEmpty(classNamePrefix)) {
            chart.setClassNamePrefix(classNamePrefix);
        }

        Element colorsElement = element.element("colors");
        if (colorsElement != null) {
            List<Color> colors = loadColors(colorsElement);
            if (CollectionUtils.isNotEmpty(colors)) {
                chart.setColors(colors);
            }
        }

        String comparedDataSets = element.attributeValue("comparedDataSets");
        if (comparedDataSets != null) {
            chart.setComparedDataSets(Arrays.asList(comparedDataSets.split(",")));
        }

        String dataDateFormat = element.attributeValue("dataDateFormat");
        if (StringUtils.isNotEmpty(dataDateFormat)) {
            chart.setDataDateFormat(dataDateFormat);
        }

        Element dataSetsElement = element.element("dataSets");
        if (dataSetsElement != null) {
            chart.setDataSets(loadDataSets(dataSetsElement));
        }

        String extendToFullPeriod = element.attributeValue("extendToFullPeriod");
        if (StringUtils.isNotEmpty(extendToFullPeriod)) {
            chart.setExtendToFullPeriod(Boolean.valueOf(extendToFullPeriod));
        }

        String firstDayOfWeek = element.attributeValue("firstDayOfWeek");
        if (StringUtils.isNotEmpty(firstDayOfWeek)) {
            chart.setFirstDayOfWeek(Integer.valueOf(firstDayOfWeek));
        }

        String glueToTheEnd = element.attributeValue("glueToTheEnd");
        if (StringUtils.isNotEmpty(glueToTheEnd)) {
            chart.setGlueToTheEnd(Boolean.valueOf(glueToTheEnd));
        }

        String language = element.attributeValue("language");
        if (StringUtils.isNotEmpty(language)) {
            chart.setLanguage(language);
        }

        String mainDataSet = element.attributeValue("mainDataSet");
        if (StringUtils.isNotEmpty(mainDataSet)) {
            chart.setMainDataSet(mainDataSet);
        }

        String mouseWheelScrollEnabled = element.attributeValue("mouseWheelScrollEnabled");
        if (StringUtils.isNotEmpty(mouseWheelScrollEnabled)) {
            chart.setMouseWheelScrollEnabled(Boolean.valueOf(mouseWheelScrollEnabled));
        }

        String theme = element.attributeValue("theme");
        if (StringUtils.isNotEmpty(theme)) {
            chart.setTheme(ChartTheme.valueOf(theme));
        }

        String zoomOutOnDataSetChange = element.attributeValue("zoomOutOnDataSetChange");
        if (StringUtils.isNotEmpty(zoomOutOnDataSetChange)) {
            chart.setZoomOutOnDataSetChange(Boolean.valueOf(zoomOutOnDataSetChange));
        }
    }

    protected void loadPanels(StockChartGroup chart, Element element) {
        Element panelsElement = element.element("panels");
        if (panelsElement != null) {
            for (Object panelItem : panelsElement.elements("panel")) {
                Element panelElement = (Element) panelItem;
                StockPanelLoader panelLoader = new StockPanelLoader();
                StockPanel stockPanel = new StockPanel();
                panelLoader.loadConfiguration(stockPanel, panelElement);
                chart.addPanels(stockPanel);
            }
        }
    }

    protected List<DataSet> loadDataSets(Element dataSetsElement) {
        List<DataSet> dataSets = new ArrayList<>();

        for (Object dataSetItem : dataSetsElement.elements("dataSet")) {
            Element dataSetElement = (Element) dataSetItem;
            DataSet dataSet = new DataSet();
            loadDataSet(dataSet, dataSetElement);
            dataSets.add(dataSet);
        }

        return dataSets;
    }

    protected void loadDataSet(DataSet dataSet, Element dataSetElement) {

        loadFieldMappings(dataSet, dataSetElement);
        loadStockEvents(dataSet, dataSetElement);

        String id = dataSetElement.attributeValue("id");
        if (StringUtils.isNotEmpty(id)) {
            dataSet.setId(id);
        }

        String categoryField = dataSetElement.attributeValue("categoryField");
        if (StringUtils.isNotEmpty(categoryField)) {
            dataSet.setCategoryField(categoryField);
        }

        String color = dataSetElement.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            dataSet.setColor(Color.valueOf(color));
        }

        String compared = dataSetElement.attributeValue("compared");
        if (StringUtils.isNotEmpty(compared)) {
            dataSet.setCompared(Boolean.valueOf(compared));
        }

        String showInCompare = dataSetElement.attributeValue("showInCompare");
        if (StringUtils.isNotEmpty(showInCompare)) {
            dataSet.setShowInCompare(Boolean.valueOf(showInCompare));
        }

        String showInSelect = dataSetElement.attributeValue("showInSelect");
        if (StringUtils.isNotEmpty(showInSelect)) {
            dataSet.setShowInSelect(Boolean.valueOf(showInSelect));
        }

        String title = dataSetElement.attributeValue("title");
        if (StringUtils.isNotEmpty(title)) {
            dataSet.setTitle(title);
        }
    }

    protected void loadFieldMappings(DataSet dataSet, Element dataSetElement) {
        Element fieldMappingsElement = dataSetElement.element("fieldMappings");
        if (fieldMappingsElement != null) {
            for (Object fieldMappingItem : fieldMappingsElement.elements("fieldMapping")) {
                Element fieldMappingElement = (Element) fieldMappingItem;
                FieldMapping fieldMapping = new FieldMapping();
                loadFieldMapping(fieldMapping, fieldMappingElement);
                dataSet.addFieldMappings(fieldMapping);
            }
        }
    }

    protected void loadFieldMapping(FieldMapping fieldMapping, Element fieldMappingElement) {
        String fromField = fieldMappingElement.attributeValue("fromField");
        if (StringUtils.isNotEmpty(fromField)) {
            fieldMapping.setFromField(fromField);
        }

        String toField = fieldMappingElement.attributeValue("toField");
        if (StringUtils.isNotEmpty(toField)) {
            fieldMapping.setToField(toField);
        }
    }

    protected void loadStockEvents(DataSet dataSet, Element dataSetElement) {
        Element stockEventsElement = dataSetElement.element("stockEvents");
        if (stockEventsElement != null) {
            for (Object stockEventItem : stockEventsElement.elements("stockEvent")) {
                Element stockEventElement = (Element) stockEventItem;
                StockEvent stockEvent = new StockEvent();
                loadStockEvent(stockEvent, stockEventElement);
                dataSet.addStockEvents(stockEvent);
            }
        }
    }

    protected void loadStockEvent(StockEvent stockEvent, Element stockEventElement) {

        String backgroundAlpha = stockEventElement.attributeValue("backgroundAlpha");
        if (StringUtils.isNotEmpty(backgroundAlpha)) {
            stockEvent.setBackgroundAlpha(Double.valueOf(backgroundAlpha));
        }

        String backgroundColor = stockEventElement.attributeValue("backgroundColor");
        if (StringUtils.isNotEmpty(backgroundColor)) {
            stockEvent.setBackgroundColor(Color.valueOf(backgroundColor));
        }

        String borderAlpha = stockEventElement.attributeValue("borderAlpha");
        if (StringUtils.isNotEmpty(borderAlpha)) {
            stockEvent.setBorderAlpha(Double.valueOf(borderAlpha));
        }

        String borderColor = stockEventElement.attributeValue("borderColor");
        if (StringUtils.isNotEmpty(borderColor)) {
            stockEvent.setBorderColor(Color.valueOf(borderColor));
        }

        String color = stockEventElement.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            stockEvent.setColor(Color.valueOf(color));
        }

        String date = stockEventElement.attributeValue("date");
        if (StringUtils.isNotEmpty(date)) {
            stockEvent.setDate(loadDate(date));
        }

        String description = stockEventElement.attributeValue("description");
        if (StringUtils.isNotEmpty(description)) {
            stockEvent.setDescription(description);
        }

        String fontSize = stockEventElement.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            stockEvent.setFontSize(Integer.valueOf(fontSize));
        }

        String graph = stockEventElement.attributeValue("graph");
        if (StringUtils.isNotEmpty(graph)) {
            stockEvent.setGraph(graph);
        }

        String rollOverColor = stockEventElement.attributeValue("rollOverColor");
        if (StringUtils.isNotEmpty(rollOverColor)) {
            stockEvent.setRollOverColor(Color.valueOf(rollOverColor));
        }

        String showAt = stockEventElement.attributeValue("showAt");
        if (StringUtils.isNotEmpty(showAt)) {
            stockEvent.setShowAt(showAt);
        }

        String showBullet = stockEventElement.attributeValue("showBullet");
        if (StringUtils.isNotEmpty(showBullet)) {
            stockEvent.setShowBullet(Boolean.valueOf(showBullet));
        }

        String showOnAxiseriod = stockEventElement.attributeValue("showOnAxis");
        if (StringUtils.isNotEmpty(showOnAxiseriod)) {
            stockEvent.setShowOnAxis(Boolean.valueOf(showOnAxiseriod));
        }

        String text = stockEventElement.attributeValue("text");
        if (StringUtils.isNotEmpty(text)) {
            stockEvent.setText(text);
        }

        String type = stockEventElement.attributeValue("type");
        if (StringUtils.isNotEmpty(type)) {
            stockEvent.setType(StockEventType.valueOf(type));
        }

        String url = stockEventElement.attributeValue("url");
        if (StringUtils.isNotEmpty(url)) {
            stockEvent.setUrl(url);
        }

        String urlTarget = stockEventElement.attributeValue("urlTarget");
        if (StringUtils.isNotEmpty(urlTarget)) {
            stockEvent.setUrlTarget(urlTarget);
        }

        String value = stockEventElement.attributeValue("value");
        if (StringUtils.isNotEmpty(value)) {
            stockEvent.setValue(Double.valueOf(value));
        }
    }

    protected List<DateFormat> loadDateFormats(Element dateFormatsElement) {
        List<DateFormat> dateFormats = new ArrayList<>();
        for (Object dateFormatItem : dateFormatsElement.elements("dateFormat")) {
            Element dateFormatElement = (Element) dateFormatItem;
            DateFormat dateFormat = new DateFormat();
            loadDateFormat(dateFormat, dateFormatElement);
            dateFormats.add(dateFormat);
        }
        return dateFormats;
    }

    protected void loadDateFormat(DateFormat dateFormat, Element dateFormatElement) {
        String period = dateFormatElement.attributeValue("period");
        if (StringUtils.isNotEmpty(period)) {
            dateFormat.setPeriod(DatePeriod.valueOf(period));
        }

        String format = dateFormatElement.attributeValue("format");
        if (StringUtils.isNotEmpty(format)) {
            dateFormat.setFormat(format);
        }
    }

    protected void loadLegendSettings(StockChartGroup chart, Element element) {
        Element legendSettingsElement = element.element("legendSettings");
        if (legendSettingsElement != null) {
            LegendSettings legendSettings = new LegendSettings();

            String align = legendSettingsElement.attributeValue("align");
            if (StringUtils.isNotEmpty(align)) {
                legendSettings.setAlign(Align.valueOf(align));
            }

            String equalWidths = legendSettingsElement.attributeValue("equalWidths");
            if (StringUtils.isNotEmpty(equalWidths)) {
                legendSettings.setEqualWidths(Boolean.valueOf(equalWidths));
            }

            String horizontalGap = legendSettingsElement.attributeValue("horizontalGap");
            if (StringUtils.isNotEmpty(horizontalGap)) {
                legendSettings.setHorizontalGap(Integer.valueOf(horizontalGap));
            }

            String labelText = legendSettingsElement.attributeValue("labelText");
            if (StringUtils.isNotEmpty(labelText)) {
                legendSettings.setLabelText(labelText);
            }

            String marginBottom = legendSettingsElement.attributeValue("marginBottom");
            if (StringUtils.isNotEmpty(marginBottom)) {
                legendSettings.setMarginBottom(Integer.valueOf(marginBottom));
            }

            String marginTop = legendSettingsElement.attributeValue("marginTop");
            if (StringUtils.isNotEmpty(marginTop)) {
                legendSettings.setMarginTop(Integer.valueOf(marginTop));
            }

            String markerBorderAlpha = legendSettingsElement.attributeValue("markerBorderAlpha");
            if (StringUtils.isNotEmpty(markerBorderAlpha)) {
                legendSettings.setMarkerBorderAlpha(Double.valueOf(markerBorderAlpha));
            }

            String markerBorderColor = legendSettingsElement.attributeValue("markerBorderColor");
            if (StringUtils.isNotEmpty(markerBorderColor)) {
                legendSettings.setMarkerBorderColor(Color.valueOf(markerBorderColor));
            }

            String markerBorderThickness = legendSettingsElement.attributeValue("markerBorderThickness");
            if (StringUtils.isNotEmpty(markerBorderThickness)) {
                legendSettings.setMarkerBorderThickness(Integer.valueOf(markerBorderThickness));
            }

            String markerDisabledColor = legendSettingsElement.attributeValue("markerDisabledColor");
            if (StringUtils.isNotEmpty(markerDisabledColor)) {
                legendSettings.setMarkerDisabledColor(Color.valueOf(markerDisabledColor));
            }

            String markerLabelGap = legendSettingsElement.attributeValue("markerLabelGap");
            if (StringUtils.isNotEmpty(markerLabelGap)) {
                legendSettings.setMarkerLabelGap(Integer.valueOf(markerLabelGap));
            }

            String markerSize = legendSettingsElement.attributeValue("markerSize");
            if (StringUtils.isNotEmpty(markerSize)) {
                legendSettings.setMarkerSize(Integer.valueOf(markerSize));
            }

            String markerType = legendSettingsElement.attributeValue("markerType");
            if (StringUtils.isNotEmpty(markerType)) {
                legendSettings.setMarkerType(MarkerType.valueOf(markerType));
            }

            String reversedOrder = legendSettingsElement.attributeValue("reversedOrder");
            if (StringUtils.isNotEmpty(reversedOrder)) {
                legendSettings.setReversedOrder(Boolean.valueOf(reversedOrder));
            }

            String rollOverColor = legendSettingsElement.attributeValue("rollOverColor");
            if (StringUtils.isNotEmpty(rollOverColor)) {
                legendSettings.setRollOverColor(Color.valueOf(rollOverColor));
            }

            String rollOverGraphAlpha = legendSettingsElement.attributeValue("rollOverGraphAlpha");
            if (StringUtils.isNotEmpty(rollOverGraphAlpha)) {
                legendSettings.setRollOverGraphAlpha(Double.valueOf(rollOverGraphAlpha));
            }

            String switchable = legendSettingsElement.attributeValue("switchable");
            if (StringUtils.isNotEmpty(switchable)) {
                legendSettings.setSwitchable(Boolean.valueOf(switchable));
            }

            String switchColor = legendSettingsElement.attributeValue("switchColor");
            if (StringUtils.isNotEmpty(switchColor)) {
                legendSettings.setSwitchColor(Color.valueOf(switchColor));
            }

            String switchType = legendSettingsElement.attributeValue("switchType");
            if (StringUtils.isNotEmpty(switchType)) {
                legendSettings.setSwitchType(SwitchType.valueOf(switchType));
            }

            String textClickEnabled = legendSettingsElement.attributeValue("textClickEnabled");
            if (StringUtils.isNotEmpty(textClickEnabled)) {
                legendSettings.setTextClickEnabled(Boolean.valueOf(textClickEnabled));
            }

            String useMarkerColorForLabels = legendSettingsElement.attributeValue("useMarkerColorForLabels");
            if (StringUtils.isNotEmpty(useMarkerColorForLabels)) {
                legendSettings.setUseMarkerColorForLabels(Boolean.valueOf(useMarkerColorForLabels));
            }

            String valueTextComparing = legendSettingsElement.attributeValue("valueTextComparing");
            if (StringUtils.isNotEmpty(valueTextComparing)) {
                legendSettings.setValueTextComparing(valueTextComparing);
            }

            String valueTextRegular = legendSettingsElement.attributeValue("valueTextRegular");
            if (StringUtils.isNotEmpty(valueTextRegular)) {
                legendSettings.setValueTextRegular(valueTextRegular);
            }

            String valueWidth = legendSettingsElement.attributeValue("valueWidth");
            if (StringUtils.isNotEmpty(valueWidth)) {
                legendSettings.setValueWidth(Integer.valueOf(valueWidth));
            }

            String verticalGap = legendSettingsElement.attributeValue("verticalGap");
            if (StringUtils.isNotEmpty(verticalGap)) {
                legendSettings.setVerticalGap(Integer.valueOf(verticalGap));
            }

            chart.setLegendSettings(legendSettings);
        }
    }

    protected void loadDataSetSelector(StockChartGroup chart, Element element) {
        Element dataSetSelectorElement = element.element("dataSetSelector");
        if (dataSetSelectorElement != null) {
            DataSetSelector dataSetSelector = new DataSetSelector();

            String comboBoxSelectText = dataSetSelectorElement.attributeValue("comboBoxSelectText");
            if (StringUtils.isNotEmpty(comboBoxSelectText)) {
                dataSetSelector.setComboBoxSelectText(comboBoxSelectText);
            }

            String compareText = dataSetSelectorElement.attributeValue("compareText");
            if (StringUtils.isNotEmpty(compareText)) {
                dataSetSelector.setCompareText(compareText);
            }
            String listHeight = dataSetSelectorElement.attributeValue("listHeight");
            if (StringUtils.isNotEmpty(listHeight)) {
                dataSetSelector.setListHeight(Integer.valueOf(listHeight));
            }

            String position = dataSetSelectorElement.attributeValue("position");
            if (StringUtils.isNotEmpty(position)) {
                dataSetSelector.setPosition(Position.valueOf(position));
            }

            String selectText = dataSetSelectorElement.attributeValue("selectText");
            if (StringUtils.isNotEmpty(selectText)) {
                dataSetSelector.setSelectText(selectText);
            }

            String width = dataSetSelectorElement.attributeValue("width");
            if (StringUtils.isNotEmpty(width)) {
                dataSetSelector.setWidth(Integer.valueOf(width));
            }

            chart.setDataSetSelector(dataSetSelector);
        }
    }

    protected void loadChartCursorSettings(StockChartGroup chart, Element element) {
        Element settingsElement = element.element("chartCursorSettings");
        if (settingsElement != null) {
            ChartCursorSettings chartCursorSettings = new ChartCursorSettings();

            Element categoryBalloonDateFormatsElement = element.element("categoryBalloonDateFormats");
            if (categoryBalloonDateFormatsElement != null) {
                chartCursorSettings.setCategoryBalloonDateFormats(loadDateFormats(categoryBalloonDateFormatsElement));
            }

            String bulletsEnabled = settingsElement.attributeValue("bulletsEnabled");
            if (StringUtils.isNotEmpty(bulletsEnabled)) {
                chartCursorSettings.setBulletsEnabled(Boolean.valueOf(bulletsEnabled));
            }

            String bulletSize = settingsElement.attributeValue("bulletSize");
            if (StringUtils.isNotEmpty(bulletSize)) {
                chartCursorSettings.setBulletSize(Integer.valueOf(bulletSize));
            }

            String categoryBalloonAlpha = settingsElement.attributeValue("categoryBalloonAlpha");
            if (StringUtils.isNotEmpty(categoryBalloonAlpha)) {
                chartCursorSettings.setCategoryBalloonAlpha(Double.valueOf(categoryBalloonAlpha));
            }

            String categoryBalloonColor = settingsElement.attributeValue("categoryBalloonColor");
            if (StringUtils.isNotEmpty(categoryBalloonColor)) {
                chartCursorSettings.setCategoryBalloonColor(Color.valueOf(categoryBalloonColor));
            }

            String categoryBalloonEnabled = settingsElement.attributeValue("categoryBalloonEnabled");
            if (StringUtils.isNotEmpty(categoryBalloonEnabled)) {
                chartCursorSettings.setCategoryBalloonEnabled(Boolean.valueOf(categoryBalloonEnabled));
            }

            String categoryBalloonText = settingsElement.attributeValue("categoryBalloonText");
            if (StringUtils.isNotEmpty(categoryBalloonText)) {
                chartCursorSettings.setCategoryBalloonText(categoryBalloonText);
            }

            String cursorAlpha = settingsElement.attributeValue("cursorAlpha");
            if (StringUtils.isNotEmpty(cursorAlpha)) {
                chartCursorSettings.setCursorAlpha(Double.valueOf(cursorAlpha));
            }

            String cursorColor = settingsElement.attributeValue("cursorColor");
            if (StringUtils.isNotEmpty(cursorColor)) {
                chartCursorSettings.setCursorColor(Color.valueOf(cursorColor));
            }

            String cursorPosition = settingsElement.attributeValue("cursorPosition");
            if (StringUtils.isNotEmpty(cursorPosition)) {
                chartCursorSettings.setCursorPosition(CursorPosition.valueOf(cursorPosition));
            }

            String enabled = settingsElement.attributeValue("enabled");
            if (StringUtils.isNotEmpty(enabled)) {
                chartCursorSettings.setEnabled(Boolean.valueOf(enabled));
            }

            String fullWidth = settingsElement.attributeValue("fullWidth");
            if (StringUtils.isNotEmpty(fullWidth)) {
                chartCursorSettings.setFullWidth(Boolean.valueOf(fullWidth));
            }

            String graphBulletSize = settingsElement.attributeValue("graphBulletSize");
            if (StringUtils.isNotEmpty(graphBulletSize)) {
                chartCursorSettings.setGraphBulletSize(Double.valueOf(graphBulletSize));
            }

            String leaveAfterTouch = settingsElement.attributeValue("leaveAfterTouch");
            if (StringUtils.isNotEmpty(leaveAfterTouch)) {
                chartCursorSettings.setLeaveAfterTouch(Boolean.valueOf(leaveAfterTouch));
            }

            String leaveCursor = settingsElement.attributeValue("leaveCursor");
            if (StringUtils.isNotEmpty(leaveCursor)) {
                chartCursorSettings.setLeaveCursor(Boolean.valueOf(leaveCursor));
            }

            String onePanelOnly = settingsElement.attributeValue("onePanelOnly");
            if (StringUtils.isNotEmpty(onePanelOnly)) {
                chartCursorSettings.setOnePanelOnly(Boolean.valueOf(onePanelOnly));
            }

            String pan = settingsElement.attributeValue("pan");
            if (StringUtils.isNotEmpty(pan)) {
                chartCursorSettings.setPan(Boolean.valueOf(pan));
            }

            String valueBalloonsEnabled = settingsElement.attributeValue("valueBalloonsEnabled");
            if (StringUtils.isNotEmpty(valueBalloonsEnabled)) {
                chartCursorSettings.setValueBalloonsEnabled(Boolean.valueOf(valueBalloonsEnabled));
            }

            String valueLineAlpha = settingsElement.attributeValue("valueLineAlpha");
            if (StringUtils.isNotEmpty(valueLineAlpha)) {
                chartCursorSettings.setValueLineAlpha(Double.valueOf(valueLineAlpha));
            }

            String valueLineBalloonEnabled = settingsElement.attributeValue("valueLineBalloonEnabled");
            if (StringUtils.isNotEmpty(valueLineBalloonEnabled)) {
                chartCursorSettings.setValueLineBalloonEnabled(Boolean.valueOf(valueLineBalloonEnabled));
            }

            String valueLineEnabled = settingsElement.attributeValue("valueLineEnabled");
            if (StringUtils.isNotEmpty(valueLineEnabled)) {
                chartCursorSettings.setValueLineEnabled(Boolean.valueOf(valueLineEnabled));
            }

            String zoomable = settingsElement.attributeValue("zoomable");
            if (StringUtils.isNotEmpty(zoomable)) {
                chartCursorSettings.setZoomable(Boolean.valueOf(zoomable));
            }

            chart.setChartCursorSettings(chartCursorSettings);
        }
    }

    protected void loadChartScrollbarSettings(StockChartGroup chart, Element element) {
        Element settingsElement = element.element("chartScrollbarSettings");
        if (settingsElement != null) {
            ChartScrollbarSettings chartScrollbarSettings = new ChartScrollbarSettings();

            String autoGridCount = settingsElement.attributeValue("autoGridCount");
            if (StringUtils.isNotEmpty(autoGridCount)) {
                chartScrollbarSettings.setAutoGridCount(Boolean.valueOf(autoGridCount));
            }

            String backgroundAlpha = settingsElement.attributeValue("backgroundAlpha");
            if (StringUtils.isNotEmpty(backgroundAlpha)) {
                chartScrollbarSettings.setBackgroundAlpha(Double.valueOf(backgroundAlpha));
            }

            String backgroundColor = settingsElement.attributeValue("backgroundColor");
            if (StringUtils.isNotEmpty(backgroundColor)) {
                chartScrollbarSettings.setBackgroundColor(Color.valueOf(backgroundColor));
            }

            String color = settingsElement.attributeValue("color");
            if (StringUtils.isNotEmpty(color)) {
                chartScrollbarSettings.setColor(Color.valueOf(color));
            }

            String dragIconHeight = settingsElement.attributeValue("dragIconHeight");
            if (StringUtils.isNotEmpty(dragIconHeight)) {
                chartScrollbarSettings.setDragIconHeight(Integer.valueOf(dragIconHeight));
            }

            String dragIconWidth = settingsElement.attributeValue("dragIconWidth");
            if (StringUtils.isNotEmpty(dragIconWidth)) {
                chartScrollbarSettings.setDragIconWidth(Integer.valueOf(dragIconWidth));
            }

            String enabled = settingsElement.attributeValue("enabled");
            if (StringUtils.isNotEmpty(enabled)) {
                chartScrollbarSettings.setEnabled(Boolean.valueOf(enabled));
            }

            String fontSize = settingsElement.attributeValue("fontSize");
            if (StringUtils.isNotEmpty(fontSize)) {
                chartScrollbarSettings.setFontSize(Integer.valueOf(fontSize));
            }

            String graph = settingsElement.attributeValue("graph");
            if (StringUtils.isNotEmpty(graph)) {
                chartScrollbarSettings.setGraph(graph);
            }

            String graphFillAlpha = settingsElement.attributeValue("graphFillAlpha");
            if (StringUtils.isNotEmpty(graphFillAlpha)) {
                chartScrollbarSettings.setGraphFillAlpha(Double.valueOf(graphFillAlpha));
            }

            String graphFillColor = settingsElement.attributeValue("graphFillColor");
            if (StringUtils.isNotEmpty(graphFillColor)) {
                chartScrollbarSettings.setGraphFillColor(Color.valueOf(graphFillColor));
            }

            String graphLineAlpha = settingsElement.attributeValue("graphLineAlpha");
            if (StringUtils.isNotEmpty(graphLineAlpha)) {
                chartScrollbarSettings.setGraphLineAlpha(Double.valueOf(graphLineAlpha));
            }

            String graphLineColor = settingsElement.attributeValue("graphLineColor");
            if (StringUtils.isNotEmpty(graphLineColor)) {
                chartScrollbarSettings.setGraphLineColor(Color.valueOf(graphLineColor));
            }

            String graphType = settingsElement.attributeValue("graphType");
            if (StringUtils.isNotEmpty(graphType)) {
                chartScrollbarSettings.setGraphType(GraphType.valueOf(graphType));
            }

            String gridAlpha = settingsElement.attributeValue("gridAlpha");
            if (StringUtils.isNotEmpty(gridAlpha)) {
                chartScrollbarSettings.setGridAlpha(Double.valueOf(gridAlpha));
            }

            String gridColor = settingsElement.attributeValue("gridColor");
            if (StringUtils.isNotEmpty(gridColor)) {
                chartScrollbarSettings.setGridColor(Color.valueOf(gridColor));
            }

            String gridCount = settingsElement.attributeValue("gridCount");
            if (StringUtils.isNotEmpty(gridCount)) {
                chartScrollbarSettings.setGridCount(Integer.valueOf(gridCount));
            }

            String height = settingsElement.attributeValue("height");
            if (StringUtils.isNotEmpty(height)) {
                chartScrollbarSettings.setHeight(Integer.valueOf(height));
            }

            String hideResizeGrips = settingsElement.attributeValue("hideResizeGrips");
            if (StringUtils.isNotEmpty(hideResizeGrips)) {
                chartScrollbarSettings.setHideResizeGrips(Boolean.valueOf(hideResizeGrips));
            }

            String markPeriodChange = settingsElement.attributeValue("markPeriodChange");
            if (StringUtils.isNotEmpty(markPeriodChange)) {
                chartScrollbarSettings.setMarkPeriodChange(Boolean.valueOf(markPeriodChange));
            }

            String position = settingsElement.attributeValue("position");
            if (StringUtils.isNotEmpty(position)) {
                chartScrollbarSettings.setPosition(ChartScrollbarPosition.valueOf(position));
            }

            String resizeEnabled = settingsElement.attributeValue("resizeEnabled");
            if (StringUtils.isNotEmpty(resizeEnabled)) {
                chartScrollbarSettings.setResizeEnabled(Boolean.valueOf(resizeEnabled));
            }

            String scrollDuration = settingsElement.attributeValue("scrollDuration");
            if (StringUtils.isNotEmpty(scrollDuration)) {
                chartScrollbarSettings.setScrollDuration(Double.valueOf(scrollDuration));
            }

            String selectedBackgroundAlpha = settingsElement.attributeValue("selectedBackgroundAlpha");
            if (StringUtils.isNotEmpty(selectedBackgroundAlpha)) {
                chartScrollbarSettings.setSelectedBackgroundAlpha(Double.valueOf(selectedBackgroundAlpha));
            }

            String selectedBackgroundColor = settingsElement.attributeValue("selectedBackgroundColor");
            if (StringUtils.isNotEmpty(selectedBackgroundColor)) {
                chartScrollbarSettings.setSelectedBackgroundColor(Color.valueOf(selectedBackgroundColor));
            }

            String selectedGraphFillAlpha = settingsElement.attributeValue("selectedGraphFillAlpha");
            if (StringUtils.isNotEmpty(selectedGraphFillAlpha)) {
                chartScrollbarSettings.setSelectedGraphFillAlpha(Double.valueOf(selectedGraphFillAlpha));
            }

            String selectedGraphFillColor = settingsElement.attributeValue("selectedGraphFillColor");
            if (StringUtils.isNotEmpty(selectedGraphFillColor)) {
                chartScrollbarSettings.setSelectedGraphFillColor(Color.valueOf(selectedGraphFillColor));
            }

            String selectedGraphLineAlpha = settingsElement.attributeValue("selectedGraphLineAlpha");
            if (StringUtils.isNotEmpty(selectedGraphLineAlpha)) {
                chartScrollbarSettings.setSelectedGraphLineAlpha(Double.valueOf(selectedGraphLineAlpha));
            }

            String selectedGraphLineColor = settingsElement.attributeValue("selectedGraphLineColor");
            if (StringUtils.isNotEmpty(selectedGraphLineColor)) {
                chartScrollbarSettings.setSelectedGraphLineColor(Color.valueOf(selectedGraphLineColor));
            }

            String updateOnReleaseOnly = settingsElement.attributeValue("updateOnReleaseOnly");
            if (StringUtils.isNotEmpty(updateOnReleaseOnly)) {
                chartScrollbarSettings.setUpdateOnReleaseOnly(Boolean.valueOf(updateOnReleaseOnly));
            }

            String usePeriod = settingsElement.attributeValue("usePeriod");
            if (StringUtils.isNotEmpty(usePeriod)) {
                chartScrollbarSettings.setUsePeriod(usePeriod);
            }

            chart.setChartScrollbarSettings(chartScrollbarSettings);
        }
    }

    protected void loadCategoryAxesSettings(StockChartGroup chart, Element element) {
        Element settingsElement = element.element("categoryAxesSettings");
        if (settingsElement != null) {
            CategoryAxesSettings categoryAxesSettings = new CategoryAxesSettings();

            Element dateFormatsElement = element.element("dateFormats");
            if (dateFormatsElement != null) {
                categoryAxesSettings.setDateFormats(loadDateFormats(dateFormatsElement));
            }

            String alwaysGroup = settingsElement.attributeValue("alwaysGroup");
            if (StringUtils.isNotEmpty(alwaysGroup)) {
                categoryAxesSettings.setAlwaysGroup(Boolean.valueOf(alwaysGroup));
            }

            String autoGridCount = settingsElement.attributeValue("autoGridCount");
            if (StringUtils.isNotEmpty(autoGridCount)) {
                categoryAxesSettings.setAutoGridCount(Boolean.valueOf(autoGridCount));
            }

            String axisAlpha = settingsElement.attributeValue("axisAlpha");
            if (StringUtils.isNotEmpty(axisAlpha)) {
                categoryAxesSettings.setAxisAlpha(Double.valueOf(axisAlpha));
            }

            String axisColor = settingsElement.attributeValue("axisColor");
            if (StringUtils.isNotEmpty(axisColor)) {
                categoryAxesSettings.setAxisColor(Color.valueOf(axisColor));
            }

            String axisHeight = settingsElement.attributeValue("axisHeight");
            if (StringUtils.isNotEmpty(axisHeight)) {
                categoryAxesSettings.setAxisHeight(Integer.valueOf(axisHeight));
            }

            String axiaxisThicknessColor = settingsElement.attributeValue("axisThickness");
            if (StringUtils.isNotEmpty(axiaxisThicknessColor)) {
                categoryAxesSettings.setAxisThickness(Integer.valueOf(axiaxisThicknessColor));
            }

            String boldPeriodBeginning = settingsElement.attributeValue("boldPeriodBeginning");
            if (StringUtils.isNotEmpty(boldPeriodBeginning)) {
                categoryAxesSettings.setBoldPeriodBeginning(Boolean.valueOf(boldPeriodBeginning));
            }

            String color = settingsElement.attributeValue("color");
            if (StringUtils.isNotEmpty(color)) {
                categoryAxesSettings.setColor(Color.valueOf(color));
            }

            String dashLength = settingsElement.attributeValue("dashLength");
            if (StringUtils.isNotEmpty(dashLength)) {
                categoryAxesSettings.setDashLength(Integer.valueOf(dashLength));
            }

            String equalSpacing = settingsElement.attributeValue("equalSpacing");
            if (StringUtils.isNotEmpty(equalSpacing)) {
                categoryAxesSettings.setEqualSpacing(Boolean.valueOf(equalSpacing));
            }

            String fillAlpha = settingsElement.attributeValue("fillAlpha");
            if (StringUtils.isNotEmpty(fillAlpha)) {
                categoryAxesSettings.setFillAlpha(Double.valueOf(fillAlpha));
            }

            String fillColor = settingsElement.attributeValue("fillColor");
            if (StringUtils.isNotEmpty(fillColor)) {
                categoryAxesSettings.setFillColor(Color.valueOf(fillColor));
            }

            String fontSize = settingsElement.attributeValue("fontSize");
            if (StringUtils.isNotEmpty(fontSize)) {
                categoryAxesSettings.setFontSize(Integer.valueOf(fontSize));
            }

            String gridAlpha = settingsElement.attributeValue("gridAlpha");
            if (StringUtils.isNotEmpty(gridAlpha)) {
                categoryAxesSettings.setGridAlpha(Double.valueOf(gridAlpha));
            }

            String gridColor = settingsElement.attributeValue("gridColor");
            if (StringUtils.isNotEmpty(gridColor)) {
                categoryAxesSettings.setGridColor(Color.valueOf(gridColor));
            }

            String gridCount = settingsElement.attributeValue("gridCount");
            if (StringUtils.isNotEmpty(gridCount)) {
                categoryAxesSettings.setGridCount(Integer.valueOf(gridCount));
            }

            String gridThickness = settingsElement.attributeValue("gridThickness");
            if (StringUtils.isNotEmpty(gridThickness)) {
                categoryAxesSettings.setGridThickness(Integer.valueOf(gridThickness));
            }

            String groupToPeriods = settingsElement.attributeValue("groupToPeriods");
            if (StringUtils.isNotEmpty(groupToPeriods)) {
                categoryAxesSettings.addGroupToPeriods(groupToPeriods.split(","));
            }

            String inside = settingsElement.attributeValue("inside");
            if (StringUtils.isNotEmpty(inside)) {
                categoryAxesSettings.setInside(Boolean.valueOf(inside));
            }

            String labelOffset = settingsElement.attributeValue("labelOffset");
            if (StringUtils.isNotEmpty(labelOffset)) {
                categoryAxesSettings.setLabelOffset(Integer.valueOf(labelOffset));
            }

            String labelRotation = settingsElement.attributeValue("labelRotation");
            if (StringUtils.isNotEmpty(labelRotation)) {
                categoryAxesSettings.setLabelRotation(Integer.valueOf(labelRotation));
            }

            String labelsEnabled = settingsElement.attributeValue("labelsEnabled");
            if (StringUtils.isNotEmpty(labelsEnabled)) {
                categoryAxesSettings.setLabelsEnabled(Boolean.valueOf(labelsEnabled));
            }

            String markPeriodChange = settingsElement.attributeValue("markPeriodChange");
            if (StringUtils.isNotEmpty(markPeriodChange)) {
                categoryAxesSettings.setMarkPeriodChange(Boolean.valueOf(markPeriodChange));
            }

            String maxSeries = settingsElement.attributeValue("maxSeries");
            if (StringUtils.isNotEmpty(maxSeries)) {
                categoryAxesSettings.setMaxSeries(Integer.valueOf(maxSeries));
            }

            String minHorizontalGap = settingsElement.attributeValue("minHorizontalGap");
            if (StringUtils.isNotEmpty(minHorizontalGap)) {
                categoryAxesSettings.setMinHorizontalGap(Integer.valueOf(minHorizontalGap));
            }

            String minPeriod = settingsElement.attributeValue("minPeriod");
            if (StringUtils.isNotEmpty(minPeriod)) {
                categoryAxesSettings.setMinPeriod(minPeriod);
            }

            String position = settingsElement.attributeValue("position");
            if (StringUtils.isNotEmpty(position)) {
                categoryAxesSettings.setPosition(CategoryAxesPosition.valueOf(position));
            }

            String startOnAxis = settingsElement.attributeValue("startOnAxis");
            if (StringUtils.isNotEmpty(startOnAxis)) {
                categoryAxesSettings.setStartOnAxis(Boolean.valueOf(startOnAxis));
            }

            String tickLength = settingsElement.attributeValue("tickLength");
            if (StringUtils.isNotEmpty(tickLength)) {
                categoryAxesSettings.setTickLength(Integer.valueOf(tickLength));
            }

            String twoLineMode = settingsElement.attributeValue("twoLineMode");
            if (StringUtils.isNotEmpty(twoLineMode)) {
                categoryAxesSettings.setTwoLineMode(Boolean.valueOf(twoLineMode));
            }

            chart.setCategoryAxesSettings(categoryAxesSettings);
        }
    }

    protected void loadPeriodSelector(StockChartGroup chart, Element element) {
        Element periodSelectorElement = element.element("periodSelector");
        if (periodSelectorElement != null) {

            PeriodSelector periodSelector = new PeriodSelector();

            loadPeriods(periodSelector, periodSelectorElement);

            String dateFormat = periodSelectorElement.attributeValue("dateFormat");
            if (StringUtils.isNotEmpty(dateFormat)) {
                periodSelector.setDateFormat(dateFormat);
            }

            String fromText = periodSelectorElement.attributeValue("fromText");
            if (StringUtils.isNotEmpty(fromText)) {
                periodSelector.setFromText(fromText);
            }

            String hideOutOfScopePeriods = periodSelectorElement.attributeValue("hideOutOfScopePeriods");
            if (StringUtils.isNotEmpty(hideOutOfScopePeriods)) {
                periodSelector.setHideOutOfScopePeriods(Boolean.valueOf(hideOutOfScopePeriods));
            }

            String inputFieldsEnabled = periodSelectorElement.attributeValue("inputFieldsEnabled");
            if (StringUtils.isNotEmpty(inputFieldsEnabled)) {
                periodSelector.setInputFieldsEnabled(Boolean.valueOf(inputFieldsEnabled));
            }

            String inputFieldWidth = periodSelectorElement.attributeValue("inputFieldWidth");
            if (StringUtils.isNotEmpty(inputFieldWidth)) {
                periodSelector.setInputFieldWidth(Integer.valueOf(inputFieldWidth));
            }

            String periodsText = periodSelectorElement.attributeValue("periodsText");
            if (StringUtils.isNotEmpty(periodsText)) {
                periodSelector.setPeriodsText(periodsText);
            }

            String position = periodSelectorElement.attributeValue("position");
            if (StringUtils.isNotEmpty(position)) {
                periodSelector.setPosition(Position.valueOf(position));
            }

            String selectFromStart = periodSelectorElement.attributeValue("selectFromStart");
            if (StringUtils.isNotEmpty(selectFromStart)) {
                periodSelector.setSelectFromStart(Boolean.valueOf(selectFromStart));
            }

            String toText = periodSelectorElement.attributeValue("toText");
            if (StringUtils.isNotEmpty(toText)) {
                periodSelector.setToText(toText);
            }

            String width = periodSelectorElement.attributeValue("width");
            if (StringUtils.isNotEmpty(width)) {
                periodSelector.setWidth(Integer.valueOf(width));
            }

            chart.setPeriodSelector(periodSelector);
        }
    }

    protected void loadPeriod(Period period, Element periodElement) {
        String periodType = periodElement.attributeValue("period");
        if (StringUtils.isNotEmpty(periodType)) {
            period.setPeriod(PeriodType.valueOf(periodType));
        }

        String count = periodElement.attributeValue("count");
        if (StringUtils.isNotEmpty(count)) {
            period.setCount(Integer.valueOf(count));
        }

        String label = periodElement.attributeValue("label");
        if (StringUtils.isNotEmpty(label)) {
            period.setLabel(label);
        }

        String selected = periodElement.attributeValue("selected");
        if (StringUtils.isNotEmpty(selected)) {
            period.setSelected(Boolean.valueOf(selected));
        }
    }

    protected void loadPeriods(PeriodSelector periodSelector, Element periodSelectorElement) {
        Element periodsElement = periodSelectorElement.element("periods");
        if (periodsElement != null) {
            for (Object periodItem : periodsElement.elements("period")) {
                Element periodElement = (Element) periodItem;
                Period period = new Period();
                loadPeriod(period, periodElement);
                periodSelector.addPeriods(period);
            }
        }
    }

    protected void loadPanelsSettings(StockChartGroup chart, Element element) {
        Element panelSettingsElement = element.element("panelsSettings");
        if (panelSettingsElement != null) {
            PanelsSettings panelsSettings = new PanelsSettings();

            loadMargins(panelsSettings, panelSettingsElement);
            loadStartEffect(panelsSettings, panelSettingsElement);

            String angel = panelSettingsElement.attributeValue("angel");
            if (StringUtils.isNotEmpty(angel)) {
                panelsSettings.setAngel(Integer.valueOf(angel));
            }

            String backgroundAlpha = panelSettingsElement.attributeValue("backgroundAlpha");
            if (StringUtils.isNotEmpty(backgroundAlpha)) {
                panelsSettings.setBackgroundAlpha(Double.valueOf(backgroundAlpha));
            }

            String backgroundColor = panelSettingsElement.attributeValue("backgroundColor");
            if (StringUtils.isNotEmpty(backgroundColor)) {
                panelsSettings.setBackgroundColor(Color.valueOf(backgroundColor));
            }

            String columnSpacing = panelSettingsElement.attributeValue("columnSpacing");
            if (StringUtils.isNotEmpty(columnSpacing)) {
                panelsSettings.setColumnSpacing(Integer.valueOf(columnSpacing));
            }

            String columnWidth = panelSettingsElement.attributeValue("columnWidth");
            if (StringUtils.isNotEmpty(columnWidth)) {
                panelsSettings.setColumnWidth(Integer.valueOf(columnWidth));
            }

            String creditsPosition = panelSettingsElement.attributeValue("creditsPosition");
            if (StringUtils.isNotEmpty(creditsPosition)) {
                CreditsPosition cp = CreditsPosition.fromId(creditsPosition);
                if (cp == null) {
                    cp = CreditsPosition.valueOf(creditsPosition);
                }
                panelsSettings.setCreditsPosition(cp);
            }

            String decimalSeparator = panelSettingsElement.attributeValue("decimalSeparator");
            if (StringUtils.isNotEmpty(decimalSeparator)) {
                panelsSettings.setDecimalSeparator(decimalSeparator);
            }

            String depth3D = panelSettingsElement.attributeValue("depth3D");
            if (StringUtils.isNotEmpty(depth3D)) {
                panelsSettings.setDepth3D(Integer.valueOf(depth3D));
            }

            String fontFamily = panelSettingsElement.attributeValue("fontFamily");
            if (StringUtils.isNotEmpty(fontFamily)) {
                panelsSettings.setFontFamily(fontFamily);
            }

            String fontSize = panelSettingsElement.attributeValue("fontSize");
            if (StringUtils.isNotEmpty(fontSize)) {
                panelsSettings.setFontSize(Integer.valueOf(fontSize));
            }

            String maxSelectedTime = panelSettingsElement.attributeValue("maxSelectedTime");
            if (StringUtils.isNotEmpty(maxSelectedTime)) {
                panelsSettings.setMaxSelectedTime(Long.valueOf(maxSelectedTime));
            }

            String minSelectedTime = panelSettingsElement.attributeValue("minSelectedTime");
            if (StringUtils.isNotEmpty(minSelectedTime)) {
                panelsSettings.setMinSelectedTime(Long.valueOf(minSelectedTime));
            }

            String panelSpacing = panelSettingsElement.attributeValue("panelSpacing");
            if (StringUtils.isNotEmpty(panelSpacing)) {
                panelsSettings.setPanelSpacing(Integer.valueOf(panelSpacing));
            }

            String panEventsEnabled = panelSettingsElement.attributeValue("panEventsEnabled");
            if (StringUtils.isNotEmpty(panEventsEnabled)) {
                panelsSettings.setPanEventsEnabled(Boolean.valueOf(panEventsEnabled));
            }

            String percentPrecision = panelSettingsElement.attributeValue("percentPrecision");
            if (StringUtils.isNotEmpty(percentPrecision)) {
                panelsSettings.setPercentPrecision(Double.valueOf(percentPrecision));
            }

            String plotAreaBorderAlpha = panelSettingsElement.attributeValue("plotAreaBorderAlpha");
            if (StringUtils.isNotEmpty(plotAreaBorderAlpha)) {
                panelsSettings.setPlotAreaBorderAlpha(Double.valueOf(plotAreaBorderAlpha));
            }

            String plotAreaBorderColor = panelSettingsElement.attributeValue("plotAreaBorderColor");
            if (StringUtils.isNotEmpty(plotAreaBorderColor)) {
                panelsSettings.setPlotAreaBorderColor(Color.valueOf(plotAreaBorderColor));
            }

            String plotAreaFillAlphas = panelSettingsElement.attributeValue("plotAreaFillAlphas");
            if (StringUtils.isNotEmpty(plotAreaFillAlphas)) {
                panelsSettings.setPlotAreaFillAlphas(Double.valueOf(plotAreaFillAlphas));
            }

            Element plotAreaFillColorsElement = element.element("plotAreaFillColors");
            if (plotAreaFillColorsElement != null) {
                List<Color> colors = loadColors(plotAreaFillColorsElement);
                if (CollectionUtils.isNotEmpty(colors)) {
                    panelsSettings.setPlotAreaFillColors(colors);
                }
            }

            String precision = panelSettingsElement.attributeValue("precision");
            if (StringUtils.isNotEmpty(precision)) {
                panelsSettings.setPrecision(Double.valueOf(precision));
            }

            String recalculateToPercents = panelSettingsElement.attributeValue("recalculateToPercents");
            if (StringUtils.isNotEmpty(recalculateToPercents)) {
                panelsSettings.setRecalculateToPercents(RecalculateToPercents.valueOf(recalculateToPercents));
            }

            String sequencedAnimation = panelSettingsElement.attributeValue("sequencedAnimation");
            if (StringUtils.isNotEmpty(sequencedAnimation)) {
                panelsSettings.setSequencedAnimation(Boolean.valueOf(sequencedAnimation));
            }

            String startAlpha = panelSettingsElement.attributeValue("startAlpha");
            if (StringUtils.isNotEmpty(startAlpha)) {
                panelsSettings.setStartAlpha(Double.valueOf(startAlpha));
            }

            String thousandsSeparator = panelSettingsElement.attributeValue("thousandsSeparator");
            if (StringUtils.isNotEmpty(thousandsSeparator)) {
                panelsSettings.setThousandsSeparator(thousandsSeparator);
            }

            String usePrefixes = panelSettingsElement.attributeValue("usePrefixes");
            if (StringUtils.isNotEmpty(usePrefixes)) {
                panelsSettings.setUsePrefixes(Boolean.valueOf(usePrefixes));
            }

            chart.setPanelsSettings(panelsSettings);
        }
    }

    protected void loadValueAxesSettings(StockChartGroup chart, Element element) {
        Element valueAxesSettingsElement = element.element("valueAxesSettings");
        if (valueAxesSettingsElement != null) {
            ValueAxesSettings valueAxesSettings = new ValueAxesSettings();

            String autoGridCount = valueAxesSettingsElement.attributeValue("autoGridCount");
            if (StringUtils.isNotEmpty(autoGridCount)) {
                valueAxesSettings.setAutoGridCount(Boolean.valueOf(autoGridCount));
            }

            String axisAlpha = valueAxesSettingsElement.attributeValue("axisAlpha");
            if (StringUtils.isNotEmpty(axisAlpha)) {
                valueAxesSettings.setAxisAlpha(Double.valueOf(axisAlpha));
            }

            String axisColor = valueAxesSettingsElement.attributeValue("axisColor");
            if (StringUtils.isNotEmpty(axisColor)) {
                valueAxesSettings.setAxisColor(Color.valueOf(axisColor));
            }

            String axisThickness = valueAxesSettingsElement.attributeValue("axisThickness");
            if (StringUtils.isNotEmpty(axisThickness)) {
                valueAxesSettings.setAxisThickness(Integer.valueOf(axisThickness));
            }

            String color = valueAxesSettingsElement.attributeValue("color");
            if (StringUtils.isNotEmpty(color)) {
                valueAxesSettings.setColor(Color.valueOf(color));
            }

            String dashLength = valueAxesSettingsElement.attributeValue("dashLength");
            if (StringUtils.isNotEmpty(dashLength)) {
                valueAxesSettings.setDashLength(Integer.valueOf(dashLength));
            }

            String fillAlpha = valueAxesSettingsElement.attributeValue("fillAlpha");
            if (StringUtils.isNotEmpty(fillAlpha)) {
                valueAxesSettings.setFillAlpha(Double.valueOf(fillAlpha));
            }

            String fillColor = valueAxesSettingsElement.attributeValue("fillColor");
            if (StringUtils.isNotEmpty(fillColor)) {
                valueAxesSettings.setFillColor(Color.valueOf(fillColor));
            }

            String gridAlpha = valueAxesSettingsElement.attributeValue("gridAlpha");
            if (StringUtils.isNotEmpty(gridAlpha)) {
                valueAxesSettings.setGridAlpha(Double.valueOf(gridAlpha));
            }

            String gridColor = valueAxesSettingsElement.attributeValue("gridColor");
            if (StringUtils.isNotEmpty(gridColor)) {
                valueAxesSettings.setGridColor(Color.valueOf(gridColor));
            }

            String gridThickness = valueAxesSettingsElement.attributeValue("gridThickness");
            if (StringUtils.isNotEmpty(gridThickness)) {
                valueAxesSettings.setGridThickness(Integer.valueOf(gridThickness));
            }

            String includeGuidesInMinMax = valueAxesSettingsElement.attributeValue("includeGuidesInMinMax");
            if (StringUtils.isNotEmpty(includeGuidesInMinMax)) {
                valueAxesSettings.setIncludeGuidesInMinMax(Boolean.valueOf(includeGuidesInMinMax));
            }

            String includeHidden = valueAxesSettingsElement.attributeValue("includeHidden");
            if (StringUtils.isNotEmpty(includeHidden)) {
                valueAxesSettings.setIncludeHidden(Boolean.valueOf(includeHidden));
            }

            String inside = valueAxesSettingsElement.attributeValue("inside");
            if (StringUtils.isNotEmpty(inside)) {
                valueAxesSettings.setInside(Boolean.valueOf(inside));
            }

            String integersOnly = valueAxesSettingsElement.attributeValue("integersOnly");
            if (StringUtils.isNotEmpty(integersOnly)) {
                valueAxesSettings.setIntegersOnly(Boolean.valueOf(integersOnly));
            }

            String labelFrequency = valueAxesSettingsElement.attributeValue("labelFrequency");
            if (StringUtils.isNotEmpty(labelFrequency)) {
                valueAxesSettings.setLabelFrequency(Double.valueOf(labelFrequency));
            }

            String labelOffset = valueAxesSettingsElement.attributeValue("labelOffset");
            if (StringUtils.isNotEmpty(labelOffset)) {
                valueAxesSettings.setLabelOffset(Integer.valueOf(labelOffset));
            }

            String labelsEnabled = valueAxesSettingsElement.attributeValue("labelsEnabled");
            if (StringUtils.isNotEmpty(labelsEnabled)) {
                valueAxesSettings.setLabelsEnabled(Boolean.valueOf(labelsEnabled));
            }

            String logarithmic = valueAxesSettingsElement.attributeValue("logarithmic");
            if (StringUtils.isNotEmpty(logarithmic)) {
                valueAxesSettings.setLogarithmic(Boolean.valueOf(logarithmic));
            }

            String maximum = valueAxesSettingsElement.attributeValue("maximum");
            if (StringUtils.isNotEmpty(maximum)) {
                valueAxesSettings.setMaximum(Double.valueOf(maximum));
            }

            String minimum = valueAxesSettingsElement.attributeValue("minimum");
            if (StringUtils.isNotEmpty(minimum)) {
                valueAxesSettings.setMinimum(Double.valueOf(minimum));
            }

            String minMaxMultiplier = valueAxesSettingsElement.attributeValue("minMaxMultiplier");
            if (StringUtils.isNotEmpty(minMaxMultiplier)) {
                valueAxesSettings.setMinMaxMultiplier(Double.valueOf(minMaxMultiplier));
            }

            String offset = valueAxesSettingsElement.attributeValue("offset");
            if (StringUtils.isNotEmpty(offset)) {
                valueAxesSettings.setOffset(Integer.valueOf(offset));
            }

            String position = valueAxesSettingsElement.attributeValue("position");
            if (StringUtils.isNotEmpty(position)) {
                valueAxesSettings.setPosition(ValueAxisPosition.valueOf(position));
            }

            String reversed = valueAxesSettingsElement.attributeValue("reversed");
            if (StringUtils.isNotEmpty(reversed)) {
                valueAxesSettings.setReversed(Boolean.valueOf(reversed));
            }

            String showFirstLabel = valueAxesSettingsElement.attributeValue("showFirstLabel");
            if (StringUtils.isNotEmpty(showFirstLabel)) {
                valueAxesSettings.setShowFirstLabel(Boolean.valueOf(showFirstLabel));
            }

            String showLastLabel = valueAxesSettingsElement.attributeValue("showLastLabel");
            if (StringUtils.isNotEmpty(showLastLabel)) {
                valueAxesSettings.setShowLastLabel(Boolean.valueOf(showLastLabel));
            }

            String stackType = valueAxesSettingsElement.attributeValue("stackType");
            if (StringUtils.isNotEmpty(stackType)) {
                valueAxesSettings.setStackType(StackType.valueOf(stackType));
            }

            String tickLength = valueAxesSettingsElement.attributeValue("tickLength");
            if (StringUtils.isNotEmpty(tickLength)) {
                valueAxesSettings.setTickLength(Integer.valueOf(tickLength));
            }

            String unit = valueAxesSettingsElement.attributeValue("unit");
            if (StringUtils.isNotEmpty(unit)) {
                valueAxesSettings.setUnit(unit);
            }

            String unitPosition = valueAxesSettingsElement.attributeValue("unitPosition");
            if (StringUtils.isNotEmpty(unitPosition)) {
                valueAxesSettings.setUnitPosition(UnitPosition.valueOf(unitPosition));
            }

            chart.setValueAxesSettings(valueAxesSettings);
        }
    }

    protected void loadStockEventsSettings(StockChartGroup chart, Element element) {
        Element stockEventsSettingsElement = element.element("stockEventsSettings");
        if (stockEventsSettingsElement != null) {
            StockEventsSettings stockEventsSettings = new StockEventsSettings();

            String backgroundAlpha = stockEventsSettingsElement.attributeValue("backgroundAlpha");
            if (StringUtils.isNotEmpty(backgroundAlpha)) {
                stockEventsSettings.setBackgroundAlpha(Double.valueOf(backgroundAlpha));
            }

            String backgroundColor = stockEventsSettingsElement.attributeValue("backgroundColor");
            if (StringUtils.isNotEmpty(backgroundColor)) {
                stockEventsSettings.setBackgroundColor(Color.valueOf(backgroundColor));
            }

            String balloonColor = stockEventsSettingsElement.attributeValue("balloonColor");
            if (StringUtils.isNotEmpty(balloonColor)) {
                stockEventsSettings.setBalloonColor(Color.valueOf(balloonColor));
            }

            String borderAlpha = stockEventsSettingsElement.attributeValue("borderAlpha");
            if (StringUtils.isNotEmpty(borderAlpha)) {
                stockEventsSettings.setBorderAlpha(Double.valueOf(borderAlpha));
            }

            String borderColor = stockEventsSettingsElement.attributeValue("borderColor");
            if (StringUtils.isNotEmpty(borderColor)) {
                stockEventsSettings.setBorderColor(Color.valueOf(borderColor));
            }

            String rollOverColor = stockEventsSettingsElement.attributeValue("rollOverColor");
            if (StringUtils.isNotEmpty(rollOverColor)) {
                stockEventsSettings.setRollOverColor(Color.valueOf(rollOverColor));
            }

            String showAt = stockEventsSettingsElement.attributeValue("showAt");
            if (StringUtils.isNotEmpty(showAt)) {
                stockEventsSettings.setShowAt(showAt);
            }

            String type = stockEventsSettingsElement.attributeValue("type");
            if (StringUtils.isNotEmpty(type)) {
                stockEventsSettings.setType(StockEventType.valueOf(type));
            }

            chart.setStockEventsSettings(stockEventsSettings);
        }
    }

    protected void loadBalloon(StockChartGroup chart, Element element) {
        Element balloonElement = element.element("balloon");
        if (balloonElement != null) {
            Balloon balloon = new Balloon();

            String adjustBorderColor = balloonElement.attributeValue("adjustBorderColor");
            if (StringUtils.isNotEmpty(adjustBorderColor)) {
                balloon.setAdjustBorderColor(Boolean.valueOf(adjustBorderColor));
            }

            String animationDuration = balloonElement.attributeValue("animationDuration");
            if (StringUtils.isNotEmpty(animationDuration)) {
                balloon.setAnimationDuration(Double.valueOf(animationDuration));
            }

            String borderAlpha = balloonElement.attributeValue("borderAlpha");
            if (StringUtils.isNotEmpty(borderAlpha)) {
                balloon.setBorderAlpha(Double.valueOf(borderAlpha));
            }

            String borderColor = balloonElement.attributeValue("borderColor");
            if (StringUtils.isNotEmpty(borderColor)) {
                balloon.setBorderColor(Color.valueOf(borderColor));
            }

            String borderThickness = balloonElement.attributeValue("borderThickness");
            if (StringUtils.isNotEmpty(borderThickness)) {
                balloon.setBorderThickness(Integer.valueOf(borderThickness));
            }

            String color = balloonElement.attributeValue("color");
            if (StringUtils.isNotEmpty(color)) {
                balloon.setColor(Color.valueOf(color));
            }

            String cornerRadius = balloonElement.attributeValue("cornerRadius");
            if (StringUtils.isNotEmpty(cornerRadius)) {
                balloon.setCornerRadius(Integer.valueOf(cornerRadius));
            }

            String disableMouseEvents = balloonElement.attributeValue("disableMouseEvents");
            if (StringUtils.isNotEmpty(disableMouseEvents)) {
                balloon.setDisableMouseEvents(Boolean.valueOf(disableMouseEvents));
            }

            String fadeOutDuration = balloonElement.attributeValue("fadeOutDuration");
            if (StringUtils.isNotEmpty(fadeOutDuration)) {
                balloon.setFadeOutDuration(Double.valueOf(fadeOutDuration));
            }

            String fillAlpha = balloonElement.attributeValue("fillAlpha");
            if (StringUtils.isNotEmpty(fillAlpha)) {
                balloon.setFillAlpha(Double.valueOf(fillAlpha));
            }

            String fillColor = balloonElement.attributeValue("fillColor");
            if (StringUtils.isNotEmpty(fillColor)) {
                balloon.setFillColor(Color.valueOf(fillColor));
            }

            String fixedPosition = balloonElement.attributeValue("fixedPosition");
            if (StringUtils.isNotEmpty(fixedPosition)) {
                balloon.setFixedPosition(Boolean.valueOf(fixedPosition));
            }

            String fontSize = balloonElement.attributeValue("fontSize");
            if (StringUtils.isNotEmpty(fontSize)) {
                balloon.setFontSize(Integer.valueOf(fontSize));
            }

            String horizontalPadding = balloonElement.attributeValue("horizontalPadding");
            if (StringUtils.isNotEmpty(horizontalPadding)) {
                balloon.setHorizontalPadding(Integer.valueOf(horizontalPadding));
            }

            String maxWidth = balloonElement.attributeValue("maxWidth");
            if (StringUtils.isNotEmpty(maxWidth)) {
                balloon.setMaxWidth(Integer.valueOf(maxWidth));
            }

            String offsetX = balloonElement.attributeValue("offsetX");
            if (StringUtils.isNotEmpty(offsetX)) {
                balloon.setOffsetX(Integer.valueOf(offsetX));
            }

            String offsetY = balloonElement.attributeValue("offsetY");
            if (StringUtils.isNotEmpty(offsetY)) {
                balloon.setOffsetY(Integer.valueOf(offsetY));
            }

            String pointerWidth = balloonElement.attributeValue("pointerWidth");
            if (StringUtils.isNotEmpty(pointerWidth)) {
                balloon.setPointerWidth(Integer.valueOf(pointerWidth));
            }

            String shadowAlpha = balloonElement.attributeValue("shadowAlpha");
            if (StringUtils.isNotEmpty(shadowAlpha)) {
                balloon.setShadowAlpha(Double.valueOf(shadowAlpha));
            }

            String shadowColor = balloonElement.attributeValue("shadowColor");
            if (StringUtils.isNotEmpty(shadowColor)) {
                balloon.setShadowColor(Color.valueOf(shadowColor));
            }

            String showBullet = balloonElement.attributeValue("showBullet");
            if (StringUtils.isNotEmpty(showBullet)) {
                balloon.setShowBullet(Boolean.valueOf(showBullet));
            }

            String textAlign = balloonElement.attributeValue("textAlign");
            if (StringUtils.isNotEmpty(textAlign)) {
                balloon.setTextAlign(Align.valueOf(textAlign));
            }

            String verticalPadding = balloonElement.attributeValue("verticalPadding");
            if (StringUtils.isNotEmpty(verticalPadding)) {
                balloon.setVerticalPadding(Integer.valueOf(verticalPadding));
            }

            chart.setBalloon(balloon);
        }
    }

    protected ExportMenuItem loadExportMenuItem(Element menuItemElement) {
        ExportMenuItem menuItem = new ExportMenuItem();

        String format = menuItemElement.attributeValue("format");
        if (StringUtils.isNotBlank(format)) {
            menuItem.setFormat(ExportFormat.valueOf(format));
        }

        String title = menuItemElement.attributeValue("title");
        if (StringUtils.isNotBlank(title)) {
            menuItem.setTitle(loadResourceString(title));
        }

        String label = menuItemElement.attributeValue("label");
        if (StringUtils.isNotBlank(label)) {
            menuItem.setLabel(loadResourceString(label));
        }

        return menuItem;
    }

    protected void loadExportMenu(Export export, Element exportElement) {
        Element menuElement = exportElement.element("menu");
        if (menuElement != null) {
            List<ExportMenuItem> items = new ArrayList<>();

            for (Object menuElementItem : menuElement.elements("item")) {
                Element menuItemElement = (Element) menuElementItem;
                items.add(loadExportMenuItem(menuItemElement));
            }

            export.setMenu(items);
        }
    }

    protected void loadExportLibs(ExportLibs libs, Element libsElement) {
        String path = libsElement.attributeValue("path");
        if (StringUtils.isNotEmpty(path)) {
            libs.setPath(path);
        }
    }

    protected void loadExport(StockChartGroup chart, Element element) {
        Element exportElement = element.element("export");
        if (exportElement != null) {
            Export export = new Export();

            loadExportMenu(export, exportElement);

            String enabled = exportElement.attributeValue("enabled");
            if (StringUtils.isNotEmpty(enabled)) {
                export.setEnabled(Boolean.valueOf(enabled));
            }

            Element libsElement = exportElement.element("libs");
            if (libsElement != null) {
                ExportLibs libs = new ExportLibs();
                loadExportLibs(libs, libsElement);
                export.setLibs(libs);
            }

            String backgroundColor = exportElement.attributeValue("backgroundColor");
            if (StringUtils.isNotEmpty(backgroundColor)) {
                export.setBackgroundColor(Color.valueOf(backgroundColor));
            }

            String fileName = exportElement.attributeValue("fileName");
            if (StringUtils.isNotEmpty(fileName)) {
                export.setFileName(fileName);
            }

            String position = exportElement.attributeValue("position");
            if (StringUtils.isNotEmpty(position)) {
                export.setPosition(ExportPosition.valueOf(position));
            }

            String removeImages = exportElement.attributeValue("removeImages");
            if (StringUtils.isNotEmpty(removeImages)) {
                export.setRemoveImages(Boolean.valueOf(removeImages));
            }

            String exportTitles = exportElement.attributeValue("exportTitles");
            if (StringUtils.isNotEmpty(exportTitles)) {
                export.setExportTitles(Boolean.valueOf(exportTitles));
            }

            String exportSelection = exportElement.attributeValue("exportSelection");
            if (StringUtils.isNotEmpty(exportSelection)) {
                export.setExportSelection(Boolean.valueOf(exportSelection));
            }

            String dataDateFormat = exportElement.attributeValue("dataDateFormat");
            if (StringUtils.isNotEmpty(dataDateFormat)) {
                export.setDataDateFormat(dataDateFormat);
            }

            String dateFormat = exportElement.attributeValue("dateFormat");
            if (StringUtils.isNotEmpty(dateFormat)) {
                export.setDateFormat(dateFormat);
            }

            String keyListener = exportElement.attributeValue("keyListener");
            if (StringUtils.isNotEmpty(keyListener)) {
                export.setKeyListener(Boolean.valueOf(keyListener));
            }

            String fileListener = exportElement.attributeValue("fileListener");
            if (StringUtils.isNotEmpty(fileListener)) {
                export.setFileListener(Boolean.valueOf(fileListener));
            }

            chart.setExport(export);
        }
    }

    protected void loadGraph(AbstractGraph graph, Element graphElement) {
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

    protected List<Color> loadColors(Element colorsElement) {
        List<Color> colors = new ArrayList<>();

        for (Object colorItem : colorsElement.elements("color")) {
            Element colorElement = (Element) colorItem;

            String value = colorElement.attributeValue("value");
            if (StringUtils.isNotEmpty(value)) {
                colors.add(Color.valueOf(value));
            }
        }
        return colors;
    }

    protected void loadMargins(HasMargins hasMargins, Element element) {
        String marginTop = element.attributeValue("marginTop");
        if (StringUtils.isNotEmpty(marginTop)) {
            hasMargins.setMarginTop(Integer.valueOf(marginTop));
        }

        String marginBottom = element.attributeValue("marginBottom");
        if (StringUtils.isNotEmpty(marginBottom)) {
            hasMargins.setMarginBottom(Integer.valueOf(marginBottom));
        }

        String marginLeft = element.attributeValue("marginLeft");
        if (StringUtils.isNotEmpty(marginLeft)) {
            hasMargins.setMarginLeft(Integer.valueOf(marginLeft));
        }

        String marginRight = element.attributeValue("marginRight");
        if (StringUtils.isNotEmpty(marginRight)) {
            hasMargins.setMarginRight(Integer.valueOf(marginRight));
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

    protected Date loadDate(String value) {
        SimpleDateFormat df = new SimpleDateFormat(CONFIG_DATE_FORMAT);
        try {
            return df.parse(value);
        } catch (ParseException e) {
            throw new GuiDevelopmentException("Unable to parse date from XML chart configuration",
                    context.getCurrentFrameId(), "date", value);
        }
    }

}
