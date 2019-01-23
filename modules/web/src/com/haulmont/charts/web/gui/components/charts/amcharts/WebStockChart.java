/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.google.common.base.Strings;
import com.haulmont.bali.events.Subscription;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.StockChart;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;
import com.haulmont.charts.gui.amcharts.model.charts.StockPanel;
import com.haulmont.charts.web.gui.ChartLocaleHelper;
import com.haulmont.charts.web.gui.serialization.CubaStockChartSerializer;
import com.haulmont.charts.web.widgets.amcharts.CubaAmStockChartScene;
import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsIntegration;
import com.haulmont.charts.web.widgets.amcharts.events.StockPanelZoomEvent;
import com.haulmont.charts.web.widgets.amcharts.serialization.ChartJsonSerializationContext;
import com.haulmont.charts.web.widgets.amcharts.serialization.StockChartSerializer;
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
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.*;
import java.util.function.Consumer;

public class WebStockChart extends WebAbstractComponent<CubaAmStockChartScene>
        implements StockChart, InitializingBean {

    protected Messages messages;
    protected Metadata metadata;
    protected UserSessionSource userSessionSource;

    protected StockChartEventsForwarder stockChartEventsForwarder = new StockChartEventsForwarder();

    public WebStockChart() {
        component = createComponent();
    }

    protected StockChartGroup createConfiguration() {
        return new StockChartGroup();
    }

    protected CubaAmStockChartScene createComponent() {
        return new CubaAmStockChartScene(createChartSerializer());
    }

    protected StockChartSerializer createChartSerializer() {
        return AppBeans.getPrototype(CubaStockChartSerializer.NAME);
    }

    @Inject
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    @Inject
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Inject
    public void setUserSessionSource(UserSessionSource userSessionSource) {
        this.userSessionSource = userSessionSource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initLocale();

        StockChartGroup configuration = createConfiguration();
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
    public Subscription addClickListener(Consumer<StockChartClickEvent> clickListener) {
        if (!hasSubscriptions(StockChartClickEvent.class)) {
            component.addChartClickListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockChartClickEvent.class, clickListener);
    }

    @Override
    public void removeClickListener(Consumer<StockChartClickEvent> clickListener) {
        unsubscribe(StockChartClickEvent.class, clickListener);
        if (!hasSubscriptions(StockChartClickEvent.class)) {
            component.removeChartClickListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addRightClickListener(Consumer<StockChartRightClickEvent> clickListener) {
        if (!hasSubscriptions(StockChartRightClickEvent.class)) {
            component.addChartRightClickListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockChartRightClickEvent.class, clickListener);
    }

    @Override
    public void removeRightClickListener(Consumer<StockChartRightClickEvent> clickListener) {
        unsubscribe(StockChartRightClickEvent.class, clickListener);
        if (!hasSubscriptions(StockChartRightClickEvent.class)) {
            component.removeChartRightClickListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addStockEventClickListener(Consumer<StockEventClickEvent> clickListener) {
        if (!hasSubscriptions(StockEventClickEvent.class)) {
            component.addStockEventClickListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockEventClickEvent.class, clickListener);
    }

    @Override
    public void removeStockEventClickListener(Consumer<StockEventClickEvent> clickListener) {
        unsubscribe(StockEventClickEvent.class, clickListener);
        if (!hasSubscriptions(StockEventClickEvent.class)) {
            component.removeStockEventClickListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addStockEventRollOutListener(Consumer<StockEventRollOutEvent> rollOutListener) {
        if (!hasSubscriptions(StockEventRollOutEvent.class)) {
            component.addStockEventRollOutListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockEventRollOutEvent.class, rollOutListener);
    }

    @Override
    public void removeStockEventRollOutListener(Consumer<StockEventRollOutEvent> rollOutListener) {
        unsubscribe(StockEventRollOutEvent.class, rollOutListener);
        if (!hasSubscriptions(StockEventRollOutEvent.class)) {
            component.removeStockEventRollOutListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addStockEventRollOverListener(Consumer<StockEventRollOverEvent> rollOverListener) {
        if (!hasSubscriptions(StockEventRollOverEvent.class)) {
            component.addStockEventRollOverListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockEventRollOverEvent.class, rollOverListener);
    }

    @Override
    public void removeStockEventRollOverListener(Consumer<StockEventRollOverEvent> rollOverListener) {
        unsubscribe(StockEventRollOverEvent.class, rollOverListener);
        if (!hasSubscriptions(StockEventRollOverEvent.class)) {
            component.removeStockEventRollOverListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addZoomListener(Consumer<ZoomEvent> zoomListener) {
        if (!hasSubscriptions(ZoomEvent.class)) {
            component.addStockPanelZoomListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(ZoomEvent.class, zoomListener);
    }

    @Override
    public void removeZoomListener(Consumer<ZoomEvent> zoomListener) {
        unsubscribe(ZoomEvent.class, zoomListener);
        if (!hasSubscriptions(ZoomEvent.class)) {
            component.removeStockPanelZoomListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addPeriodSelectorChangeListener(Consumer<PeriodSelectorChangeEvent> changeListener) {
        if (!hasSubscriptions(PeriodSelectorChangeEvent.class)) {
            component.addPeriodSelectorChangeListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(PeriodSelectorChangeEvent.class, changeListener);
    }

    @Override
    public void removePeriodSelectorChangeListener(Consumer<PeriodSelectorChangeEvent> changeListener) {
        unsubscribe(PeriodSelectorChangeEvent.class, changeListener);
        if (!hasSubscriptions(PeriodSelectorChangeEvent.class)) {
            component.removePeriodSelectorChangeListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addDataSetSelectorCompareListener(Consumer<DataSetSelectorCompareEvent> compareListener) {
        if (!hasSubscriptions(DataSetSelectorCompareEvent.class)) {
            component.addDataSetSelectorCompareListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(DataSetSelectorCompareEvent.class, compareListener);
    }

    @Override
    public void removeDataSetSelectorCompareListener(Consumer<DataSetSelectorCompareEvent> compareListener) {
        unsubscribe(DataSetSelectorCompareEvent.class, compareListener);
        if (!hasSubscriptions(DataSetSelectorCompareEvent.class)) {
            component.removeDataSetSelectorCompareListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addDataSetSelectorSelectListener(Consumer<DataSetSelectorSelectEvent> selectListener) {
        if (!hasSubscriptions(DataSetSelectorSelectEvent.class)) {
            component.addDataSetSelectorSelectListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(DataSetSelectorSelectEvent.class, selectListener);
    }

    @Override
    public void removeDataSetSelectorSelectListener(Consumer<DataSetSelectorSelectEvent> selectListener) {
        unsubscribe(DataSetSelectorSelectEvent.class, selectListener);
        if (!hasSubscriptions(DataSetSelectorSelectEvent.class)) {
            component.removeDataSetSelectorSelectListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addDataSetSelectorUnCompareListener(Consumer<DataSetSelectorUnCompareEvent> unCompareListener) {
        if (!hasSubscriptions(DataSetSelectorUnCompareEvent.class)) {
            component.addDataSetSelectorUnCompareListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(DataSetSelectorUnCompareEvent.class, unCompareListener);
    }

    @Override
    public void removeDataSetSelectorUnCompareListener(Consumer<DataSetSelectorUnCompareEvent> unCompareListener) {
        unsubscribe(DataSetSelectorUnCompareEvent.class, unCompareListener);
        if (!hasSubscriptions(DataSetSelectorUnCompareEvent.class)) {
            component.removeDataSetSelectorUnCompareListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addStockGraphClickListener(Consumer<StockGraphClickEvent> clickListener) {
        if (!hasSubscriptions(StockGraphClickEvent.class)) {
            component.addStockGraphClickListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockGraphClickEvent.class, clickListener);
    }

    @Override
    public void removeStockGraphClickListener(Consumer<StockGraphClickEvent> clickListener) {
        unsubscribe(StockGraphClickEvent.class, clickListener);
        if (!hasSubscriptions(StockGraphClickEvent.class)) {
            component.removeStockGraphClickListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addStockGraphRollOutListener(Consumer<StockGraphRollOutEvent> rollOutListener) {
        if (!hasSubscriptions(StockGraphRollOutEvent.class)) {
            component.addStockGraphRollOutListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockGraphRollOutEvent.class, rollOutListener);
    }

    @Override
    public void removeStockGraphRollOutListener(Consumer<StockGraphRollOutEvent> rollOutListener) {
        unsubscribe(StockGraphRollOutEvent.class, rollOutListener);
        if (!hasSubscriptions(StockGraphRollOutEvent.class)) {
            component.removeStockGraphRollOutListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addStockGraphRollOverListener(Consumer<StockGraphRollOverEvent> rollOverListener) {
        if (!hasSubscriptions(StockGraphRollOverEvent.class)) {
            component.addStockGraphRollOverListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockGraphRollOverEvent.class, rollOverListener);
    }

    @Override
    public void removeStockGraphRollOverListener(Consumer<StockGraphRollOverEvent> rollOverListener) {
        unsubscribe(StockGraphRollOverEvent.class, rollOverListener);
        if (!hasSubscriptions(StockGraphRollOverEvent.class)) {
            component.removeStockGraphRollOverListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addStockGraphItemClickListener(Consumer<StockGraphItemClickEvent> clickListener) {
        if (!hasSubscriptions(StockGraphItemClickEvent.class)) {
            component.addStockGraphItemClickListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockGraphItemClickEvent.class, clickListener);
    }

    @Override
    public void removeStockGraphItemClickListener(Consumer<StockGraphItemClickEvent> clickListener) {
        unsubscribe(StockGraphItemClickEvent.class, clickListener);
        if (!hasSubscriptions(StockGraphItemClickEvent.class)) {
            component.removeStockGraphItemClickListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addStockGraphItemRightClickListener(Consumer<StockGraphItemRightClickEvent> clickListener) {
        if (!hasSubscriptions(StockGraphItemRightClickEvent.class)) {
            component.addStockGraphItemRightClickListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockGraphItemRightClickEvent.class, clickListener);
    }

    @Override
    public void removeStockGraphItemRightClickListener(Consumer<StockGraphItemRightClickEvent> clickListener) {
        unsubscribe(StockGraphItemRightClickEvent.class, clickListener);
        if (!hasSubscriptions(StockGraphItemRightClickEvent.class)) {
            component.removeStockGraphItemRightClickListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addStockGraphItemRollOutListener(Consumer<StockGraphItemRollOutEvent> rollOutListener) {
        if (!hasSubscriptions(StockGraphItemRollOutEvent.class)) {
            component.addStockGraphItemRollOutListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockGraphItemRollOutEvent.class, rollOutListener);
    }

    @Override
    public void removeStockGraphItemRollOutListener(Consumer<StockGraphItemRollOutEvent> rollOutListener) {
        unsubscribe(StockGraphItemRollOutEvent.class, rollOutListener);
        if (!hasSubscriptions(StockGraphItemRollOutEvent.class)) {
            component.removeStockGraphItemRollOutListener(stockChartEventsForwarder);
        }
    }

    @Override
    public Subscription addStockGraphItemRollOverListener(Consumer<StockGraphItemRollOverEvent> rollOverListener) {
        if (!hasSubscriptions(StockGraphItemRollOverEvent.class)) {
            component.addStockGraphItemRollOverListener(stockChartEventsForwarder);
        }
        return getEventHub().subscribe(StockGraphItemRollOverEvent.class, rollOverListener);
    }

    @Override
    public void removeStockGraphItemRollOverListener(Consumer<StockGraphItemRollOverEvent> rollOverListener) {
        unsubscribe(StockGraphItemRollOverEvent.class, rollOverListener);
        if (!hasSubscriptions(StockGraphItemRollOverEvent.class)) {
            component.removeStockGraphItemRollOverListener(stockChartEventsForwarder);
        }
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

    protected StockPanel getStockPanelById(String id) {
        if (!StringUtils.isNotEmpty(id)
                || (getPanels() == null || getPanels().isEmpty())) {
            return null;
        }

        for (StockPanel stockPanel : getPanels()) {
            if (id.equals(stockPanel.getId())) {
                return stockPanel;
            }
        }
        return null;
    }

    protected StockGraph getStockGraphById(String graphId) {
        if (!StringUtils.isNotEmpty(graphId)
                || (getPanels() == null || getPanels().isEmpty())) {
            return null;
        }

        for (StockPanel stockPanel : getPanels()) {
            StockGraph graph = getStockGraphById(stockPanel, graphId);
            if (graph != null) {
                return graph;
            }
        }
        return null;
    }

    protected StockGraph getStockGraphById(StockPanel panel, String graphId) {
        if (panel == null || Strings.isNullOrEmpty(graphId)) {
            return null;
        }

        if (panel.getStockGraphs() == null || panel.getStockGraphs().isEmpty()) {
            return null;
        }

        for (StockGraph stockGraph : panel.getStockGraphs()) {
            if (graphId.equals(stockGraph.getId())) {
                return stockGraph;
            }
        }
        return null;
    }

    protected class StockChartEventsForwarder
            implements com.haulmont.charts.web.widgets.amcharts.events.StockChartClickListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockChartRightClickListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockEventClickListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockEventRollOutListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockEventRollOverListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockPanelZoomListener,
            com.haulmont.charts.web.widgets.amcharts.events.PeriodSelectorChangeListener,
            com.haulmont.charts.web.widgets.amcharts.events.DataSetSelectorCompareListener,
            com.haulmont.charts.web.widgets.amcharts.events.DataSetSelectorSelectListener,
            com.haulmont.charts.web.widgets.amcharts.events.DataSetSelectorUnCompareListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockGraphClickListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockGraphRollOutListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockGraphRollOverListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockGraphItemClickListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockGraphItemRightClickListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockGraphItemRollOutListener,
            com.haulmont.charts.web.widgets.amcharts.events.StockGraphItemRollOverListener {

        @Override
        public void onClick(com.haulmont.charts.web.widgets.amcharts.events.StockChartClickEvent e) {
            publish(StockChartClickEvent.class,
                    new StockChartClickEvent(WebStockChart.this, e.getX(), e.getY(), e.getAbsoluteX(),
                            e.getAbsoluteY()));
        }

        @Override
        public void onClick(com.haulmont.charts.web.widgets.amcharts.events.StockGraphClickEvent e) {
            StockPanel stockPanel = getStockPanelById(e.getPanelId());
            StockGraph stockGraph = getStockGraphById(stockPanel, e.getGraphId());

            publish(StockGraphClickEvent.class,
                    new StockGraphClickEvent(WebStockChart.this, stockPanel, e.getPanelId(), stockGraph,
                            e.getGraphId(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY()));
        }

        @Override
        public void onZoom(StockPanelZoomEvent e) {
            ZoomEvent cubaEvent = new ZoomEvent(WebStockChart.this, e.getStartDate(), e.getEndDate(),
                    DatePeriod.fromId(e.getPeriod()));
            publish(ZoomEvent.class, cubaEvent);
        }

        @Override
        public void onClick(com.haulmont.charts.web.widgets.amcharts.events.StockEventClickEvent e) {
            publish(StockEventClickEvent.class,
                    new StockEventClickEvent(WebStockChart.this, getStockGraphById(e.getGraphId()),
                            e.getGraphId(), e.getDate(), getStockEvent(e.getStockEventId())));
        }

        @Override
        public void onRollOut(com.haulmont.charts.web.widgets.amcharts.events.StockEventRollOutEvent e) {
            publish(StockEventRollOutEvent.class,
                    new StockEventRollOutEvent(WebStockChart.this, getStockGraphById(e.getGraphId()),
                            e.getGraphId(), e.getDate(), getStockEvent(e.getStockEventId())));
        }

        @Override
        public void onRollOut(com.haulmont.charts.web.widgets.amcharts.events.StockGraphRollOutEvent e) {
            StockPanel stockPanel = getStockPanelById(e.getPanelId());
            StockGraph stockGraph = getStockGraphById(stockPanel, e.getGraphId());

            publish(StockGraphRollOutEvent.class,
                    new StockGraphRollOutEvent(WebStockChart.this, stockPanel, e.getPanelId(), stockGraph,
                            e.getGraphId(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY()));
        }

        @Override
        public void onRollOver(com.haulmont.charts.web.widgets.amcharts.events.StockEventRollOverEvent e) {
            publish(StockEventRollOverEvent.class,
                    new StockEventRollOverEvent(WebStockChart.this, getStockGraphById(e.getGraphId()),
                            e.getGraphId(), e.getDate(), getStockEvent(e.getStockEventId())));
        }

        @Override
        public void onRollOver(com.haulmont.charts.web.widgets.amcharts.events.StockGraphRollOverEvent e) {
            StockPanel stockPanel = getStockPanelById(e.getPanelId());
            StockGraph stockGraph = getStockGraphById(stockPanel, e.getGraphId());

            publish(StockGraphRollOverEvent.class,
                    new StockGraphRollOverEvent(WebStockChart.this, stockPanel, e.getPanelId(), stockGraph,
                            e.getGraphId(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY()));
        }

        @Override
        public void onChange(com.haulmont.charts.web.widgets.amcharts.events.PeriodSelectorChangeEvent e) {
            publish(PeriodSelectorChangeEvent.class,
                    new PeriodSelectorChangeEvent(WebStockChart.this,
                            e.getStartDate(), e.getEndDate(), PeriodType.fromId(e.getPredefinedPeriod()),
                            e.getCount(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY()));
        }

        @Override
        public void onClick(com.haulmont.charts.web.widgets.amcharts.events.StockChartRightClickEvent e) {
            publish(StockChartRightClickEvent.class,
                    new StockChartRightClickEvent(WebStockChart.this, e.getX(), e.getY(), e.getAbsoluteX(),
                            e.getAbsoluteY()));
        }

        @Override
        public void onClick(com.haulmont.charts.web.widgets.amcharts.events.StockGraphItemClickEvent e) {
            StockPanel stockPanel = getStockPanelById(e.getPanelId());
            StockGraph stockGraph = getStockGraphById(stockPanel, e.getGraphId());

            publish(StockGraphItemClickEvent.class,
                    new StockGraphItemClickEvent(WebStockChart.this, stockPanel,
                            e.getPanelId(), stockGraph, e.getGraphId(), e.getDataItem(), e.getItemIndex(),
                            e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY()));
        }

        @Override
        public void onSelect(com.haulmont.charts.web.widgets.amcharts.events.DataSetSelectorSelectEvent e) {
            publish(DataSetSelectorSelectEvent.class,
                    new DataSetSelectorSelectEvent(WebStockChart.this, e.getDataSetId()));
        }

        @Override
        public void onRollOut(com.haulmont.charts.web.widgets.amcharts.events.StockGraphItemRollOutEvent e) {
            StockPanel stockPanel = getStockPanelById(e.getPanelId());
            StockGraph stockGraph = getStockGraphById(stockPanel, e.getGraphId());

            publish(StockGraphItemRollOutEvent.class,
                    new StockGraphItemRollOutEvent(WebStockChart.this, stockPanel, e.getPanelId(), stockGraph,
                            e.getGraphId(), e.getDataItem(), e.getItemIndex(), e.getX(), e.getY(), e.getAbsoluteX(),
                            e.getAbsoluteY()));
        }

        @Override
        public void onCompare(com.haulmont.charts.web.widgets.amcharts.events.DataSetSelectorCompareEvent e) {
            publish(DataSetSelectorCompareEvent.class,
                    new DataSetSelectorCompareEvent(WebStockChart.this, e.getDataSetId()));
        }

        @Override
        public void onRollOver(com.haulmont.charts.web.widgets.amcharts.events.StockGraphItemRollOverEvent e) {
            StockPanel stockPanel = getStockPanelById(e.getPanelId());
            StockGraph stockGraph = getStockGraphById(stockPanel, e.getGraphId());

            publish(StockGraphItemRollOverEvent.class,
                    new StockGraphItemRollOverEvent(WebStockChart.this, stockPanel,
                            e.getPanelId(), stockGraph, e.getGraphId(), e.getDataItem(), e.getItemIndex(),
                            e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY()));
        }

        @Override
        public void onUnCompare(com.haulmont.charts.web.widgets.amcharts.events.DataSetSelectorUnCompareEvent e) {
            publish(DataSetSelectorUnCompareEvent.class,
                    new DataSetSelectorUnCompareEvent(WebStockChart.this, e.getDataSetId()));
        }

        @Override
        public void onClick(com.haulmont.charts.web.widgets.amcharts.events.StockGraphItemRightClickEvent e) {
            StockPanel stockPanel = getStockPanelById(e.getPanelId());
            StockGraph stockGraph = getStockGraphById(stockPanel, e.getGraphId());

            publish(StockGraphItemRightClickEvent.class,
                    new StockGraphItemRightClickEvent(WebStockChart.this, stockPanel,
                            e.getPanelId(), stockGraph, e.getGraphId(), e.getDataItem(), e.getItemIndex(),
                            e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY()));
        }
    }
}