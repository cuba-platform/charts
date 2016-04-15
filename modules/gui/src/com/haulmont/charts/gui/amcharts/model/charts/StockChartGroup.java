/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.gson.ChartJsonSerializationContext;
import com.haulmont.charts.gui.amcharts.model.gson.DataProviderSerializer;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * See documentation for properties of AmStockChart JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/AmStockChart">http://docs.amcharts.com/3/javascriptstockchart/AmStockChart</a>
 *
 */
public class StockChartGroup extends ChartModel
        implements HasColors<StockChartGroup>, DataSet.DataProviderChangeListener {

    private static final long serialVersionUID = -8514686195948609709L;

    @Expose(serialize = false, deserialize = false)
    private List<DataSetDataProviderChangeListener> dataSetDataProviderChangeListeners;
    @Expose(serialize = false, deserialize = false)
    private List<DataSetsChangeListener> dataSetsChangeListeners;

    private Boolean addClassNames;

    private Export export;

    private Boolean animationPlayed;

    private Boolean autoResize;

    private Balloon balloon;

    private CategoryAxesSettings categoryAxesSettings;

    private ChartCursorSettings chartCursorSettings;

    private ChartScrollbarSettings chartScrollbarSettings;

    private String classNamePrefix;

    private List<Color> colors;

    private List<String> comparedDataSets;

    private String dataDateFormat;

    private List<DataSet> dataSets;

    private DataSetSelector dataSetSelector;

    private Boolean extendToFullPeriod;

    private Integer firstDayOfWeek;

    private Boolean glueToTheEnd;

    private String language;

    private LegendSettings legendSettings;

    private String mainDataSet;

    private Boolean mouseWheelScrollEnabled;

    private List<StockPanel> panels;

    private PanelsSettings panelsSettings;

    private String path = "VAADIN/resources/amcharts/";

    private String pathToImages;

    private PeriodSelector periodSelector;

    private Integer processTimeout;

    private StockEventsSettings stockEventsSettings;

    private ChartTheme theme;

    private ChartType type = ChartType.STOCK;

    private ValueAxesSettings valueAxesSettings;

    private Boolean zoomOutOnDataSetChange;

    @Expose(serialize = false, deserialize = false)
    private List<String> additionalFields;

    public Boolean getAddClassNames() {
        return addClassNames;
    }

    public StockChartGroup setAddClassNames(Boolean addClassNames) {
        this.addClassNames = addClassNames;
        return this;
    }

    public Export getExport() {
        return export;
    }

    public StockChartGroup setExport(Export export) {
        this.export = export;
        return this;
    }

    public Boolean getAnimationPlayed() {
        return animationPlayed;
    }

    public StockChartGroup setAnimationPlayed(Boolean animationPlayed) {
        this.animationPlayed = animationPlayed;
        return this;
    }

    public Boolean getAutoResize() {
        return autoResize;
    }

    public StockChartGroup setAutoResize(Boolean autoResize) {
        this.autoResize = autoResize;
        return this;
    }

    public Balloon getBalloon() {
        return balloon;
    }

    public StockChartGroup setBalloon(Balloon balloon) {
        this.balloon = balloon;
        return this;
    }

    public CategoryAxesSettings getCategoryAxesSettings() {
        return categoryAxesSettings;
    }

    public StockChartGroup setCategoryAxesSettings(CategoryAxesSettings categoryAxesSettings) {
        this.categoryAxesSettings = categoryAxesSettings;
        return this;
    }

    public ChartCursorSettings getChartCursorSettings() {
        return chartCursorSettings;
    }

    public StockChartGroup setChartCursorSettings(ChartCursorSettings chartCursorSettings) {
        this.chartCursorSettings = chartCursorSettings;
        return this;
    }

    public ChartScrollbarSettings getChartScrollbarSettings() {
        return chartScrollbarSettings;
    }

    public StockChartGroup setChartScrollbarSettings(ChartScrollbarSettings chartScrollbarSettings) {
        this.chartScrollbarSettings = chartScrollbarSettings;
        return this;
    }

    public String getClassNamePrefix() {
        return classNamePrefix;
    }

    public StockChartGroup setClassNamePrefix(String classNamePrefix) {
        this.classNamePrefix = classNamePrefix;
        return this;
    }

    @Override
    public List<Color> getColors() {
        return colors;
    }

    @Override
    public StockChartGroup setColors(List<Color> colors) {
        this.colors = colors;
        return this;
    }

    public List<String> getComparedDataSets() {
        return comparedDataSets;
    }

    public StockChartGroup setComparedDataSets(List<String> comparedDataSets) {
        this.comparedDataSets = comparedDataSets;
        return this;
    }

    public StockChartGroup addComparedDataSets(String... comparedDataSets) {
        if (comparedDataSets != null) {
            if (this.comparedDataSets == null) {
                this.comparedDataSets = new ArrayList<>();
            }
            this.comparedDataSets.addAll(Arrays.asList(comparedDataSets));
        }
        return this;
    }

    public String getDataDateFormat() {
        return dataDateFormat;
    }

    public StockChartGroup setDataDateFormat(String dataDateFormat) {
        this.dataDateFormat = dataDateFormat;
        return this;
    }

    public List<DataSet> getDataSets() {
        return dataSets;
    }

    public StockChartGroup setDataSets(List<DataSet> dataSets) {
        if (CollectionUtils.isNotEmpty(this.dataSets)) {
            for (DataSet dataSet : this.dataSets) {
                dataSet.removeDataProviderChangeListener(this);
            }
        }

        if (CollectionUtils.isNotEmpty(dataSets)) {
            for (DataSet dataSet : dataSets) {
                dataSet.addDataProviderChangeListener(this);
            }
        }

        this.dataSets = dataSets;
        fireDataSetsChanged(dataSets, Operation.SET);
        return this;
    }

    public StockChartGroup addDataSets(DataSet... dataSets) {
        if (dataSets != null) {
            if (this.dataSets == null) {
                this.dataSets = new ArrayList<>();
            }
            List<DataSet> dataSetList = Arrays.asList(dataSets);
            for (DataSet dataSet : dataSetList) {
                dataSet.addDataProviderChangeListener(this);
            }
            this.dataSets.addAll(Arrays.asList(dataSets));
            fireDataSetsChanged(dataSetList, Operation.ADD);
        }
        return this;
    }

    protected void fireDataSetsChanged(List<DataSet> dataSets, Operation operation) {
        if (CollectionUtils.isNotEmpty(dataSetsChangeListeners)) {
            DataSetsChangeEvent event = new DataSetsChangeEvent(
                    dataSets != null ? new ArrayList<>(dataSets) : Collections.emptyList(),
                    operation);
            for (DataSetsChangeListener listener : new ArrayList<>(dataSetsChangeListeners)) {
                listener.dataSetsChanged(event);
            }
        }
    }

    public DataSetSelector getDataSetSelector() {
        return dataSetSelector;
    }

    public StockChartGroup setDataSetSelector(DataSetSelector dataSetSelector) {
        this.dataSetSelector = dataSetSelector;
        return this;
    }

    public Boolean getExtendToFullPeriod() {
        return extendToFullPeriod;
    }

    public StockChartGroup setExtendToFullPeriod(Boolean extendToFullPeriod) {
        this.extendToFullPeriod = extendToFullPeriod;
        return this;
    }

    public Integer getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public StockChartGroup setFirstDayOfWeek(Integer firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
        return this;
    }

    public Boolean getGlueToTheEnd() {
        return glueToTheEnd;
    }

    public StockChartGroup setGlueToTheEnd(Boolean glueToTheEnd) {
        this.glueToTheEnd = glueToTheEnd;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public StockChartGroup setLanguage(String language) {
        this.language = language;
        return this;
    }

    public LegendSettings getLegendSettings() {
        return legendSettings;
    }

    public StockChartGroup setLegendSettings(LegendSettings legendSettings) {
        this.legendSettings = legendSettings;
        return this;
    }

    public String getMainDataSet() {
        return mainDataSet;
    }

    public StockChartGroup setMainDataSet(String mainDataSet) {
        this.mainDataSet = mainDataSet;
        return this;
    }

    public Boolean getMouseWheelScrollEnabled() {
        return mouseWheelScrollEnabled;
    }

    public StockChartGroup setMouseWheelScrollEnabled(Boolean mouseWheelScrollEnabled) {
        this.mouseWheelScrollEnabled = mouseWheelScrollEnabled;
        return this;
    }

    public List<StockPanel> getPanels() {
        return panels;
    }

    public StockChartGroup setPanels(List<StockPanel> panels) {
        this.panels = panels;
        return this;
    }

    public StockChartGroup addPanels(StockPanel... panels) {
        if (panels != null) {
            if (this.panels == null) {
                this.panels = new ArrayList<>();
            }
            this.panels.addAll(Arrays.asList(panels));
        }
        return this;
    }

    public PanelsSettings getPanelsSettings() {
        return panelsSettings;
    }

    public StockChartGroup setPanelsSettings(PanelsSettings panelsSettings) {
        this.panelsSettings = panelsSettings;
        return this;
    }

    public String getPath() {
        return path;
    }

    public StockChartGroup setPath(String path) {
        this.path = path;
        return this;
    }

    public String getPathToImages() {
        return pathToImages;
    }

    public StockChartGroup setPathToImages(String pathToImages) {
        this.pathToImages = pathToImages;
        return this;
    }

    public PeriodSelector getPeriodSelector() {
        return periodSelector;
    }

    public StockChartGroup setPeriodSelector(PeriodSelector periodSelector) {
        this.periodSelector = periodSelector;
        return this;
    }

    public StockEventsSettings getStockEventsSettings() {
        return stockEventsSettings;
    }

    public StockChartGroup setStockEventsSettings(StockEventsSettings stockEventsSettings) {
        this.stockEventsSettings = stockEventsSettings;
        return this;
    }

    public ChartTheme getTheme() {
        return theme;
    }

    public StockChartGroup setTheme(ChartTheme theme) {
        this.theme = theme;
        return this;
    }

    public ValueAxesSettings getValueAxesSettings() {
        return valueAxesSettings;
    }

    public StockChartGroup setValueAxesSettings(ValueAxesSettings valueAxesSettings) {
        this.valueAxesSettings = valueAxesSettings;
        return this;
    }

    public Boolean getZoomOutOnDataSetChange() {
        return zoomOutOnDataSetChange;
    }

    public StockChartGroup setZoomOutOnDataSetChange(Boolean zoomOutOnDataSetChange) {
        this.zoomOutOnDataSetChange = zoomOutOnDataSetChange;
        return this;
    }

    public DataSet getDataSet(String id) {
        for (DataSet dataSet : dataSets) {
            if (id.equals(dataSet.getId())) {
                return dataSet;
            }
        }
        return null;
    }

    public ChartType getType() {
        return type;
    }

    public List<String> getAdditionalFields() {
        return additionalFields;
    }

    public StockChartGroup setAdditionalFields(List<String> additionalFields) {
        this.additionalFields = additionalFields;
        return this;
    }

    public Integer getProcessTimeout() {
        return processTimeout;
    }

    public StockChartGroup setProcessTimeout(Integer processTimeout) {
        this.processTimeout = processTimeout;
        return this;
    }

    @Override
    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(getAdditionalFields())) {
            wiredFields.addAll(getAdditionalFields());
        }
        if (CollectionUtils.isNotEmpty(panels)) {
            for (StockPanel panel : panels) {
                wiredFields.addAll(panel.getWiredFields());
            }
        }
        if (CollectionUtils.isNotEmpty(dataSets)) {
            for (DataSet dataSet : dataSets) {
                if (dataSet.getDataProvider() != null) {
                    wiredFields.addAll(dataSet.getWiredFields());
                }
            }
        }
        return wiredFields;
    }

    @Override
    public String toString() {
        JsonElement jsonTree = chartGson.toJsonTree(this);

        if (CollectionUtils.isNotEmpty(dataSets)) {
            DataProviderSerializer serializer = new DataProviderSerializer();
            ChartJsonSerializationContext context = new ChartJsonSerializationContext(this);

            JsonArray jsonDataSets = (JsonArray) jsonTree.getAsJsonObject().get("dataSets");
            for (JsonElement dataSetElement : jsonDataSets) {
                JsonObject dataSetObject = (JsonObject) dataSetElement;
                String id = dataSetObject.get("id").getAsString();
                DataSet dataSet = getDataSet(id);
                if (dataSet != null && dataSet.getDataProvider() != null) {
                    JsonElement dataProviderElement = serializer.serialize(dataSet.getDataProvider(),
                            dataSet.getDataProvider().getClass(), context);
                    dataSetObject.add("dataProvider", dataProviderElement);
                }
            }
        }

        return chartGson.toJson(jsonTree);
    }

    @Override
    public void onChange(DataSet.DataProviderChangeEvent event) {
        if (CollectionUtils.isNotEmpty(dataSetDataProviderChangeListeners)) {
            DataSetDataProviderChangeEvent e = new DataSetDataProviderChangeEvent(event.getDataSet());
            for (DataSetDataProviderChangeListener listener : new ArrayList<>(dataSetDataProviderChangeListeners)) {
                listener.onChange(e);
            }
        }
    }

    public void addDataSetDataProviderChangeListener(DataSetDataProviderChangeListener listener) {
        if (dataSetDataProviderChangeListeners == null) {
            dataSetDataProviderChangeListeners = new ArrayList<>();
        }
        dataSetDataProviderChangeListeners.add(listener);
    }

    public void removeDataSetDataProviderChangeListener(DataSetDataProviderChangeListener listener) {
        if (dataSetDataProviderChangeListeners != null) {
            dataSetDataProviderChangeListeners.remove(listener);
        }
    }

    public void addDataSetsChangeListener(DataSetsChangeListener listener) {
        if (dataSetsChangeListeners == null) {
            dataSetsChangeListeners = new ArrayList<>();
        }
        dataSetsChangeListeners.add(listener);
    }

    public void removeDataSetsChangeListener(DataSetsChangeListener listener) {
        if (dataSetsChangeListeners != null) {
            dataSetsChangeListeners.remove(listener);
        }
    }

    public interface DataSetDataProviderChangeListener {
        void onChange(DataSetDataProviderChangeEvent event);
    }

    public class DataSetDataProviderChangeEvent {
        private final DataSet dataSet;

        public DataSetDataProviderChangeEvent(DataSet dataSet) {
            this.dataSet = dataSet;
        }

        public DataSet getDataSet() {
            return dataSet;
        }
    }

    public interface DataSetsChangeListener {
        void dataSetsChanged(DataSetsChangeEvent event);
    }

    public enum Operation {
        ADD,
        REMOVE,
        SET
    }

    public static class DataSetsChangeEvent {
        private final List<DataSet> dataSets;
        private final Operation operation;

        public DataSetsChangeEvent(List<DataSet> dataSets, Operation operation) {
            this.dataSets = dataSets;
            this.operation = operation;
        }

        public Operation getOperation() {
            return operation;
        }

        public List<DataSet> getDataSets() {
            return dataSets;
        }
    }
}
