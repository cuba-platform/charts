/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;
import com.haulmont.charts.gui.amcharts.model.charts.StockPanel;
import com.haulmont.charts.gui.amcharts.model.gson.ChartJsonSerializationContext;
import com.haulmont.charts.gui.components.charts.StockChart;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.gui.data.EntityDataProvider;
import com.haulmont.charts.web.gui.ChartLocaleHelper;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsIntegration;
import com.haulmont.charts.web.toolkit.ui.amcharts.events.*;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.FormatStrings;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.impl.CollectionDsHelper;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.*;

public class WebStockChart extends WebAbstractComponent<CubaAmStockChartScene> implements StockChart {

    protected Messages messages = AppBeans.get(Messages.class);

    protected Metadata metadata = AppBeans.get(Metadata.class);

    protected UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);

    protected StockChartEventsForwarder stockChartEventsForwarder = new StockChartEventsForwarder();

    public WebStockChart() {
        initLocale();

        component = new CubaAmStockChartScene();
        StockChartGroup configuration = new StockChartGroup();
        setupDefaults(configuration);

        component.drawChart(configuration);
    }

    protected void initLocale() {
        CubaAmchartsIntegration amchartsIntegration = CubaAmchartsIntegration.get();
        if (amchartsIntegration.getSettings() == null
                || !Objects.equals(userSessionSource.getLocale(), amchartsIntegration.getLocale())) {

            Settings settings = new Settings();
            Locale locale = userSessionSource.getLocale();

            // chart
            String localeString = messages.getTools().localeToString(locale);
            amchartsIntegration.setChartMessages(localeString, ChartLocaleHelper.getChartLocaleMap(locale));

            // export
            amchartsIntegration.setExportMessages(localeString, ChartLocaleHelper.getExportLocaleMap(locale));

            amchartsIntegration.setSettings(settings);
            amchartsIntegration.setLocale(userSessionSource.getLocale());
        }
    }

    protected void setupDefaults(StockChartGroup chart) {
        chart.setLanguage(messages.getTools().localeToString(userSessionSource.getLocale()));

        chart.setDataDateFormat(ChartJsonSerializationContext.DEFAULT_JS_DATE_FORMAT);
    }

    protected void setupFormatStrings(List<StockPanel> panels) {
        FormatStrings formatStrings = Datatypes.getFormatStrings(userSessionSource.getLocale());
        if (formatStrings != null) {
            for (StockPanel panel : panels) {
                DecimalFormatSymbols formatSymbols = formatStrings.getFormatSymbols();

                if (panel.getPrecision() == null) {
                    panel.setPrecision(-1);
                }

                if (panel.getPercentPrecision() == null) {
                    panel.setPercentPrecision(2);
                }

                if (panel.getDecimalSeparator() == null) {
                    panel.setDecimalSeparator(Character.toString(formatSymbols.getDecimalSeparator()));
                }

                if (panel.getThousandsSeparator() == null) {
                    panel.setThousandsSeparator(Character.toString(formatSymbols.getGroupingSeparator()));
                }
            }
        }
    }

    @Override
    public StockChartGroup getConfiguration() {
        return component.getChart();
    }

    protected StockChartGroup getModel() {
        return component.getChart();
    }

    @Override
    public void setDataSetDatasource(String id, CollectionDatasource datasource) {
        DataSet dataSet = component.getChart().getDataSet(id);
        if (dataSet != null) {
            if (datasource == null) {
                dataSet.setDataProvider(null);
            } else {
                CollectionDsHelper.autoRefreshInvalid(datasource, true);
                dataSet.setDataProvider(new EntityDataProvider(datasource));
            }
        }
    }

    @Override
    public CollectionDatasource getDataSetDatasource(String id) {
        DataSet dataSet = component.getChart().getDataSet(id);
        if (dataSet != null) {
            DataProvider dataProvider = dataSet.getDataProvider();
            if (dataProvider != null) {
                if (dataProvider instanceof EntityDataProvider) {
                    return ((EntityDataProvider) dataProvider).getDatasource();
                } else {
                    throw new IllegalArgumentException("Trying to get datasource from non EntityDataProvider");
                }
            }
        }
        return null;
    }

    @Override
    public void repaint() {
        component.drawChart();
    }

    protected StockEvent getStockEvent(String stockEventId) {
        UUID eventId = UUID.fromString(stockEventId);
        for (DataSet dataSet : component.getChart().getDataSets()) {
            for (StockEvent stockEvent : dataSet.getStockEvents()) {
                if (stockEvent.getId().equals(eventId)) {
                    return stockEvent;
                }
            }
        }
        return null;
    }

    protected Entity getEventItem(String itemIdString) {
        if (StringUtils.isNotEmpty(itemIdString)) {
            for (DataSet dataSet : component.getChart().getDataSets()) {
                CollectionDatasource ds = getDataSetDatasource(dataSet.getId());
                if (ds != null) {
                    //noinspection unchecked
                    Entity item = ds.getItem(getItemId(ds, itemIdString));
                    if (item != null) {
                        return item;
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    protected Object getItemId(CollectionDatasource datasource, String itemIdString) {
        MetaProperty pkProp = metadata.getTools().getPrimaryKeyProperty(datasource.getMetaClass());
        if (pkProp != null) {
            Datatype<Object> datatype = pkProp.getRange().asDatatype();
            try {
                return datatype.parse(itemIdString);
            } catch (ParseException e) {
                throw new RuntimeException("Error parsing item ID", e);
            }
        }
        return null;
    }

    @Override
    public void addClickListener(StockChartClickListener clickListener) {
        getEventRouter().addListener(StockChartClickListener.class, clickListener,
                () -> component.addChartClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeClickListener(StockChartClickListener clickListener) {
        getEventRouter().removeListener(StockChartClickListener.class, clickListener,
                () -> component.removeChartClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addRightClickListener(StockChartRightClickListener clickListener) {
        getEventRouter().addListener(StockChartRightClickListener.class, clickListener,
                () -> component.addChartRightClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeRightClickListener(StockChartRightClickListener clickListener) {
        getEventRouter().removeListener(StockChartRightClickListener.class, clickListener,
                () -> component.removeChartRightClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addStockEventClickListener(StockEventClickListener clickListener) {
        getEventRouter().addListener(StockEventClickListener.class, clickListener,
                () -> component.addStockEventClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeStockEventClickListener(StockEventClickListener clickListener) {
        getEventRouter().removeListener(StockEventClickListener.class, clickListener,
                () -> component.removeStockEventClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addStockEventRollOutListener(StockEventRollOutListener rollOutListener) {
        getEventRouter().addListener(StockEventRollOutListener.class, rollOutListener,
                () -> component.addStockEventRollOutListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeStockEventRollOutListener(StockEventRollOutListener rollOutListener) {
        getEventRouter().removeListener(StockEventRollOutListener.class, rollOutListener,
                () -> component.removeStockEventRollOutListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addStockEventRollOverListener(StockEventRollOverListener rollOverListener) {
        getEventRouter().addListener(StockEventRollOverListener.class, rollOverListener,
                () -> component.addStockEventRollOverListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeStockEventRollOverListener(StockEventRollOverListener rollOverListener) {
        getEventRouter().removeListener(StockEventRollOverListener.class, rollOverListener,
                () -> component.removeStockEventRollOverListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addZoomListener(ZoomListener zoomListener) {
        getEventRouter().addListener(ZoomListener.class, zoomListener,
                () -> component.addStockPanelZoomListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeZoomListener(ZoomListener zoomListener) {
        getEventRouter().removeListener(ZoomListener.class, zoomListener,
                () -> component.removeStockPanelZoomListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addPeriodSelectorChangeListener(PeriodSelectorChangeListener changeListener) {
        getEventRouter().addListener(PeriodSelectorChangeListener.class, changeListener,
                () -> component.addPeriodSelectorChangeListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removePeriodSelectorChangeListener(PeriodSelectorChangeListener changeListener) {
        getEventRouter().removeListener(PeriodSelectorChangeListener.class, changeListener,
                () -> component.removePeriodSelectorChangeListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addDataSetSelectorCompareListener(DataSetSelectorCompareListener compareListener) {
        getEventRouter().addListener(DataSetSelectorCompareListener.class, compareListener,
                () -> component.addDataSetSelectorCompareListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeDataSetSelectorCompareListener(DataSetSelectorCompareListener compareListener) {
        getEventRouter().removeListener(DataSetSelectorCompareListener.class, compareListener,
                () -> component.removeDataSetSelectorCompareListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addDataSetSelectorSelectListener(DataSetSelectorSelectListener selectListener) {
        getEventRouter().addListener(DataSetSelectorSelectListener.class, selectListener,
                () -> component.addDataSetSelectorSelectListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeDataSetSelectorSelectListener(DataSetSelectorSelectListener selectListener) {
        getEventRouter().removeListener(DataSetSelectorSelectListener.class, selectListener,
                () -> component.removeDataSetSelectorSelectListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addDataSetSelectorUnCompareListener(DataSetSelectorUnCompareListener unCompareListener) {
        getEventRouter().addListener(DataSetSelectorUnCompareListener.class, unCompareListener,
                () -> component.addDataSetSelectorUnCompareListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeDataSetSelectorUnCompareListener(DataSetSelectorUnCompareListener unCompareListener) {
        getEventRouter().removeListener(DataSetSelectorUnCompareListener.class, unCompareListener,
                () -> component.removeDataSetSelectorUnCompareListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addStockGraphClickListener(StockGraphClickListener clickListener) {
        getEventRouter().addListener(StockGraphClickListener.class, clickListener,
                () -> component.addStockGraphClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeStockGraphClickListener(StockGraphClickListener clickListener) {
        getEventRouter().removeListener(StockGraphClickListener.class, clickListener,
                () -> component.removeStockGraphClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addStockGraphRollOutListener(StockGraphRollOutListener rollOutListener) {
        getEventRouter().addListener(StockGraphRollOutListener.class, rollOutListener,
                () -> component.addStockGraphRollOutListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeStockGraphRollOutListener(StockGraphRollOutListener rollOutListener) {
        getEventRouter().removeListener(StockGraphRollOutListener.class, rollOutListener,
                () -> component.removeStockGraphRollOutListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addStockGraphRollOverListener(StockGraphRollOverListener rollOverListener) {
        getEventRouter().addListener(StockGraphRollOverListener.class, rollOverListener,
                () -> component.addStockGraphRollOverListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeStockGraphRollOverListener(StockGraphRollOverListener rollOverListener) {
        getEventRouter().removeListener(StockGraphRollOverListener.class, rollOverListener,
                 () -> component.removeStockGraphRollOverListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addStockGraphItemClickListener(StockGraphItemClickListener clickListener) {
        getEventRouter().addListener(StockGraphItemClickListener.class, clickListener,
                () -> component.addStockGraphItemClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeStockGraphItemClickListener(StockGraphItemClickListener clickListener) {
        getEventRouter().removeListener(StockGraphItemClickListener.class, clickListener,
                () -> component.removeStockGraphItemClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addStockGraphItemRightClickListener(StockGraphItemRightClickListener clickListener) {
        getEventRouter().addListener(StockGraphItemRightClickListener.class, clickListener,
                () -> component.addStockGraphItemRightClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeStockGraphItemRightClickListener(StockGraphItemRightClickListener clickListener) {
        getEventRouter().removeListener(StockGraphItemRightClickListener.class, clickListener,
                () -> component.removeStockGraphItemRightClickListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addStockGraphItemRollOutListener(StockGraphItemRollOutListener rollOutListener) {
        getEventRouter().addListener(StockGraphItemRollOutListener.class, rollOutListener,
                () -> component.addStockGraphItemRollOutListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeStockGraphItemRollOutListener(StockGraphItemRollOutListener rollOutListener) {
        getEventRouter().removeListener(StockGraphItemRollOutListener.class, rollOutListener,
                () -> component.removeStockGraphItemRollOutListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void addStockGraphItemRollOverListener(StockGraphItemRollOverListener rollOverListener) {
        getEventRouter().addListener(StockGraphItemRollOverListener.class, rollOverListener,
                () -> component.addStockGraphItemRollOverListener(stockChartEventsForwarder)
        );
    }

    @Override
    public void removeStockGraphItemRollOverListener(StockGraphItemRollOverListener rollOverListener) {
        getEventRouter().removeListener(StockGraphItemRollOverListener.class, rollOverListener,
                () -> component.removeStockGraphItemRollOverListener(stockChartEventsForwarder)
        );
    }

    @Override
    public String getNativeJson() {
        return component.getJson();
    }

    @Override
    public void setNativeJson(String json) {
        component.setJson(json);
    }

    @Override
    public Boolean getAddClassNames() {
        return getModel().getAddClassNames();
    }

    @Override
    public StockChart setAddClassNames(Boolean addClassNames) {
        getModel().setAddClassNames(addClassNames);
        return this;
    }

    @Override
    public Export getExport() {
        return getModel().getExport();
    }

    @Override
    public StockChart setExport(Export export) {
        if (export != null && export.getDataDateFormat() == null) {
            export.setDateFormat(messages.getMainMessage("amcharts.export.dateFormat"));
        }

        getModel().setExport(export);
        return this;
    }

    @Override
    public Boolean getAnimationPlayed() {
        return getModel().getAnimationPlayed();
    }

    @Override
    public StockChart setAnimationPlayed(Boolean animationPlayed) {
        getModel().setAnimationPlayed(animationPlayed);
        return this;
    }

    @Override
    public Boolean getAutoResize() {
        return getModel().getAutoResize();
    }

    @Override
    public StockChart setAutoResize(Boolean autoResize) {
        getModel().setAutoResize(autoResize);
        return this;
    }

    @Override
    public Balloon getBalloon() {
        return getModel().getBalloon();
    }

    @Override
    public StockChart setBalloon(Balloon balloon) {
        getModel().setBalloon(balloon);
        return this;
    }

    @Override
    public CategoryAxesSettings getCategoryAxesSettings() {
        return getModel().getCategoryAxesSettings();
    }

    @Override
    public StockChart setCategoryAxesSettings(CategoryAxesSettings categoryAxesSettings) {
        getModel().setCategoryAxesSettings(categoryAxesSettings);
        return this;
    }

    @Override
    public ChartCursorSettings getChartCursorSettings() {
        return getModel().getChartCursorSettings();
    }

    @Override
    public StockChart setChartCursorSettings(ChartCursorSettings chartCursorSettings) {
        getModel().setChartCursorSettings(chartCursorSettings);
        return this;
    }

    @Override
    public ChartScrollbarSettings getChartScrollbarSettings() {
        return getModel().getChartScrollbarSettings();
    }

    @Override
    public StockChart setChartScrollbarSettings(ChartScrollbarSettings chartScrollbarSettings) {
        getModel().setChartScrollbarSettings(chartScrollbarSettings);
        return this;
    }

    @Override
    public String getClassNamePrefix() {
        return getModel().getClassNamePrefix();
    }

    @Override
    public StockChart setClassNamePrefix(String classNamePrefix) {
        getModel().setClassNamePrefix(classNamePrefix);
        return this;
    }

    @Override
    public List<Color> getColors() {
        return getModel().getColors();
    }

    @Override
    public StockChart setColors(List<Color> colors) {
        getModel().setColors(colors);
        return this;
    }

    @Override
    public StockChart addColors(Color... colors) {
        getModel().addColors(colors);
        return this;
    }

    @Override
    public List<String> getComparedDataSets() {
        return getModel().getComparedDataSets();
    }

    @Override
    public StockChart setComparedDataSets(List<String> comparedDataSets) {
        getModel().setComparedDataSets(comparedDataSets);
        return this;
    }

    @Override
    public StockChart addComparedDataSets(String... comparedDataSets) {
        getModel().addComparedDataSets(comparedDataSets);
        return this;
    }

    @Override
    public String getDataDateFormat() {
        return getModel().getDataDateFormat();
    }

    @Override
    public StockChart setDataDateFormat(String dataDateFormat) {
        getModel().setDataDateFormat(dataDateFormat);
        return this;
    }

    @Override
    public List<DataSet> getDataSets() {
        return getModel().getDataSets();
    }

    @Override
    public StockChart setDataSets(List<DataSet> dataSets) {
        getModel().setDataSets(dataSets);
        return this;
    }

    @Override
    public StockChart addDataSets(DataSet... dataSets) {
        getModel().addDataSets(dataSets);
        return this;
    }

    @Override
    public DataSetSelector getDataSetSelector() {
        return getModel().getDataSetSelector();
    }

    @Override
    public StockChart setDataSetSelector(DataSetSelector dataSetSelector) {
        getModel().setDataSetSelector(dataSetSelector);
        return this;
    }

    @Override
    public Boolean getExtendToFullPeriod() {
        return getModel().getExtendToFullPeriod();
    }

    @Override
    public StockChart setExtendToFullPeriod(Boolean extendToFullPeriod) {
        getModel().setExtendToFullPeriod(extendToFullPeriod);
        return this;
    }

    @Override
    public Integer getFirstDayOfWeek() {
        return getModel().getFirstDayOfWeek();
    }

    @Override
    public StockChart setFirstDayOfWeek(Integer firstDayOfWeek) {
        getModel().setFirstDayOfWeek(firstDayOfWeek);
        return this;
    }

    @Override
    public Boolean getGlueToTheEnd() {
        return getModel().getGlueToTheEnd();
    }

    @Override
    public StockChart setGlueToTheEnd(Boolean glueToTheEnd) {
        getModel().setGlueToTheEnd(glueToTheEnd);
        return this;
    }

    @Override
    public String getLanguage() {
        return getModel().getLanguage();
    }

    @Override
    public StockChart setLanguage(String language) {
        getModel().setLanguage(language);
        return this;
    }

    @Override
    public LegendSettings getLegendSettings() {
        return getModel().getLegendSettings();
    }

    @Override
    public StockChart setLegendSettings(LegendSettings legendSettings) {
        getModel().setLegendSettings(legendSettings);
        return this;
    }

    @Override
    public String getMainDataSet() {
        return getModel().getMainDataSet();
    }

    @Override
    public StockChart setMainDataSet(String mainDataSet) {
        getModel().setMainDataSet(mainDataSet);
        return this;
    }

    @Override
    public Boolean getMouseWheelScrollEnabled() {
        return getModel().getMouseWheelScrollEnabled();
    }

    @Override
    public StockChart setMouseWheelScrollEnabled(Boolean mouseWheelScrollEnabled) {
        getModel().setMouseWheelScrollEnabled(mouseWheelScrollEnabled);
        return this;
    }

    @Override
    public List<StockPanel> getPanels() {
        return getModel().getPanels();
    }

    @Override
    public StockChart setPanels(List<StockPanel> panels) {
        if (panels != null) {
            setupFormatStrings(panels);
        }
        getModel().setPanels(panels);
        return this;
    }

    @Override
    public StockChart addPanels(StockPanel... panels) {
        if (panels != null) {
            setupFormatStrings(Arrays.asList(panels));
        }

        getModel().addPanels(panels);
        return this;
    }

    @Override
    public PanelsSettings getPanelsSettings() {
        return getModel().getPanelsSettings();
    }

    @Override
    public StockChart setPanelsSettings(PanelsSettings panelsSettings) {
        if (panelsSettings != null) {
            // number prefixes
            if (BooleanUtils.isTrue(panelsSettings.getUsePrefixes())) {
                if (panelsSettings.getPrefixesOfBigNumbers() == null) {
                    List<BigNumberPrefix> prefixes = new ArrayList<>();
                    for (BigNumberPower power : BigNumberPower.values()) {
                        prefixes.add(new BigNumberPrefix(power,
                                messages.getMainMessage("amcharts.bigNumberPower." + power.name())));
                    }
                    panelsSettings.setPrefixesOfBigNumbers(prefixes);
                }
                if (panelsSettings.getPrefixesOfSmallNumbers() == null) {
                    List<SmallNumberPrefix> prefixes = new ArrayList<>();
                    for (SmallNumberPower power : SmallNumberPower.values()) {
                        prefixes.add(new SmallNumberPrefix(power,
                                messages.getMainMessage("amcharts.smallNumberPower." + power.name())));
                    }
                    panelsSettings.setPrefixesOfSmallNumbers(prefixes);
                }
            }
        }

        getModel().setPanelsSettings(panelsSettings);
        return this;
    }

    @Override
    public String getPath() {
        return getModel().getPath();
    }

    @Override
    public StockChart setPath(String path) {
        getModel().setPath(path);
        return this;
    }

    @Override
    public String getPathToImages() {
        return getModel().getPathToImages();
    }

    @Override
    public StockChart setPathToImages(String pathToImages) {
        getModel().setPathToImages(pathToImages);
        return this;
    }

    @Override
    public PeriodSelector getPeriodSelector() {
        return getModel().getPeriodSelector();
    }

    @Override
    public StockChart setPeriodSelector(PeriodSelector periodSelector) {
        getModel().setPeriodSelector(periodSelector);
        return this;
    }

    @Override
    public StockEventsSettings getStockEventsSettings() {
        return getModel().getStockEventsSettings();
    }

    @Override
    public StockChart setStockEventsSettings(StockEventsSettings stockEventsSettings) {
        getModel().setStockEventsSettings(stockEventsSettings);
        return this;
    }

    @Override
    public ChartTheme getTheme() {
        return getModel().getTheme();
    }

    @Override
    public StockChart setTheme(ChartTheme theme) {
        getModel().setTheme(theme);
        return this;
    }

    @Override
    public ValueAxesSettings getValueAxesSettings() {
        return getModel().getValueAxesSettings();
    }

    @Override
    public StockChart setValueAxesSettings(ValueAxesSettings valueAxesSettings) {
        getModel().setValueAxesSettings(valueAxesSettings);
        return this;
    }

    @Override
    public Boolean getZoomOutOnDataSetChange() {
        return getModel().getZoomOutOnDataSetChange();
    }

    @Override
    public StockChart setZoomOutOnDataSetChange(Boolean zoomOutOnDataSetChange) {
        getModel().setZoomOutOnDataSetChange(zoomOutOnDataSetChange);
        return this;
    }

    @Override
    public DataSet getDataSet(String id) {
        return getModel().getDataSet(id);
    }

    @Override
    public List<String> getAdditionalFields() {
        return getModel().getAdditionalFields();
    }

    @Override
    public StockChart setAdditionalFields(List<String> additionalFields) {
        getModel().setAdditionalFields(additionalFields);
        return this;
    }

    @Override
    public Integer getProcessTimeout() {
        return getModel().getProcessTimeout();
    }

    @Override
    public StockChart setProcessTimeout(Integer processTimeout) {
        getModel().setProcessTimeout(processTimeout);
        return this;
    }

    protected class StockChartEventsForwarder
            implements com.haulmont.charts.web.toolkit.ui.amcharts.events.StockChartClickListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockChartRightClickListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockEventClickListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockEventRollOutListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockEventRollOverListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockPanelZoomListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.PeriodSelectorChangeListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.DataSetSelectorCompareListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.DataSetSelectorSelectListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.DataSetSelectorUnCompareListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphClickListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphRollOutListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphRollOverListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemClickListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemRightClickListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemRollOutListener,
                       com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemRollOverListener {

        @Override
        public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockChartClickEvent e) {
            StockChartClickEvent cubaEvent = new StockChartClickEvent(
                    e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
            getEventRouter().fireEvent(StockChartClickListener.class, StockChartClickListener::onClick, cubaEvent);
        }

        @Override
        public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphClickEvent e) {
            StockGraphClickEvent cubaEvent = new StockGraphClickEvent(e.getPanelId(), e.getGraphId(),
                    e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
            getEventRouter().fireEvent(StockGraphClickListener.class, StockGraphClickListener::onClick, cubaEvent);
        }

        @Override
        public void onZoom(StockPanelZoomEvent e) {
            ZoomEvent cubaEvent = new ZoomEvent(e.getStartDate(), e.getEndDate(), DatePeriod.fromId(e.getPeriod()));
            getEventRouter().fireEvent(ZoomListener.class, ZoomListener::onZoom, cubaEvent);
        }

        @Override
        public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockEventClickEvent e) {
            StockEventClickEvent cubaEvent = new StockEventClickEvent(e.getGraphId(), e.getDate(),
                    getStockEvent(e.getStockEventId()));
            getEventRouter().fireEvent(StockEventClickListener.class, StockEventClickListener::onClick, cubaEvent);
        }

        @Override
        public void onRollOut(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockEventRollOutEvent e) {
            StockEventRollOutEvent cubaEvent = new StockEventRollOutEvent(e.getGraphId(), e.getDate(),
                    getStockEvent(e.getStockEventId()));
            getEventRouter().fireEvent(StockEventRollOutListener.class, StockEventRollOutListener::onRollOut, cubaEvent);
        }

        @Override
        public void onRollOut(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphRollOutEvent e) {
            StockGraphRollOutEvent cubaEvent = new StockGraphRollOutEvent(e.getPanelId(), e.getGraphId(),
                    e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
            getEventRouter().fireEvent(StockGraphRollOutListener.class, StockGraphRollOutListener::onRollOut, cubaEvent);
        }

        @Override
        public void onRollOver(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockEventRollOverEvent e) {
            StockEventRollOverEvent cubaEvent = new StockEventRollOverEvent(e.getGraphId(), e.getDate(),
                    getStockEvent(e.getStockEventId()));
            getEventRouter().fireEvent(StockEventRollOverListener.class, StockEventRollOverListener::onRollOver, cubaEvent);
        }

        @Override
        public void onRollOver(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphRollOverEvent e) {
            StockGraphRollOverEvent cubaEvent = new StockGraphRollOverEvent(e.getPanelId(), e.getGraphId(),
                    e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
            getEventRouter().fireEvent(StockGraphRollOverListener.class, StockGraphRollOverListener::onRollOver, cubaEvent);
        }

        @Override
        public void onChange(com.haulmont.charts.web.toolkit.ui.amcharts.events.PeriodSelectorChangeEvent e) {
            PeriodSelectorChangeEvent cubaEvent = new PeriodSelectorChangeEvent(e.getStartDate(), e.getEndDate(),
                    PeriodType.fromId(e.getPredefinedPeriod()), e.getCount(),
                    e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
            getEventRouter().fireEvent(PeriodSelectorChangeListener.class, PeriodSelectorChangeListener::onChange, cubaEvent);
        }

        @Override
        public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockChartRightClickEvent e) {
            StockChartRightClickEvent cubaEvent = new StockChartRightClickEvent(
                    e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
            getEventRouter().fireEvent(StockChartRightClickListener.class, StockChartRightClickListener::onRightClick, cubaEvent);
        }

        @Override
        public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemClickEvent e) {
            StockGraphItemClickEvent cubaEvent = new StockGraphItemClickEvent(e.getPanelId(), e.getGraphId(),
                    e.getDataItem(), e.getItemIndex(),
                    e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
            getEventRouter().fireEvent(StockGraphItemClickListener.class, StockGraphItemClickListener::onClick, cubaEvent);
        }

        @Override
        public void onSelect(com.haulmont.charts.web.toolkit.ui.amcharts.events.DataSetSelectorSelectEvent e) {
            DataSetSelectorSelectEvent cubaEvent = new DataSetSelectorSelectEvent(e.getDataSetId());
            getEventRouter().fireEvent(DataSetSelectorSelectListener.class, DataSetSelectorSelectListener::onSelect, cubaEvent);
        }

        @Override
        public void onRollOut(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemRollOutEvent e) {
            StockGraphItemRollOutEvent cubaEvent = new StockGraphItemRollOutEvent(e.getPanelId(), e.getGraphId(),
                    e.getDataItem(), e.getItemIndex(),
                    e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
            getEventRouter().fireEvent(StockGraphItemRollOutListener.class, StockGraphItemRollOutListener::onRollOut, cubaEvent);
        }

        @Override
        public void onCompare(com.haulmont.charts.web.toolkit.ui.amcharts.events.DataSetSelectorCompareEvent e) {
            DataSetSelectorCompareEvent cubaEvent = new DataSetSelectorCompareEvent(e.getDataSetId());
            getEventRouter().fireEvent(DataSetSelectorCompareListener.class, DataSetSelectorCompareListener::onCompare, cubaEvent);
        }

        @Override
        public void onRollOver(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemRollOverEvent e) {
            StockGraphItemRollOverEvent cubaEvent = new StockGraphItemRollOverEvent(e.getPanelId(), e.getGraphId(),
                    e.getDataItem(), e.getItemIndex(),
                    e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
            getEventRouter().fireEvent(StockGraphItemRollOverListener.class, StockGraphItemRollOverListener::onRollOver, cubaEvent);
        }

        @Override
        public void onUnCompare(com.haulmont.charts.web.toolkit.ui.amcharts.events.DataSetSelectorUnCompareEvent e) {
            DataSetSelectorUnCompareEvent cubaEvent = new DataSetSelectorUnCompareEvent(e.getDataSetId());
            getEventRouter().fireEvent(DataSetSelectorUnCompareListener.class, DataSetSelectorUnCompareListener::onUnCompare, cubaEvent);
        }

        @Override
        public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemRightClickEvent e) {
            StockGraphItemRightClickEvent cubaEvent = new StockGraphItemRightClickEvent(e.getPanelId(), e.getGraphId(),
                    e.getDataItem(), e.getItemIndex(),
                    e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
            getEventRouter().fireEvent(StockGraphItemRightClickListener.class, StockGraphItemRightClickListener::onClick, cubaEvent);
        }
    }
}