/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.List;

public interface StockChartModel<T extends StockChartModel> extends HasColors<T> {
    Boolean getAddClassNames();
    T setAddClassNames(Boolean addClassNames);

    Export getExport();
    T setExport(Export export);

    Boolean getAnimationPlayed();
    T setAnimationPlayed(Boolean animationPlayed);

    Boolean getAutoResize();
    T setAutoResize(Boolean autoResize);

    Balloon getBalloon();
    T setBalloon(Balloon balloon);

    CategoryAxesSettings getCategoryAxesSettings();
    T setCategoryAxesSettings(CategoryAxesSettings categoryAxesSettings);

    ChartCursorSettings getChartCursorSettings();
    T setChartCursorSettings(ChartCursorSettings chartCursorSettings);

    ChartScrollbarSettings getChartScrollbarSettings();
    T setChartScrollbarSettings(ChartScrollbarSettings chartScrollbarSettings);

    String getClassNamePrefix();
    T setClassNamePrefix(String classNamePrefix);

    List<String> getComparedDataSets();
    T setComparedDataSets(List<String> comparedDataSets);
    T addComparedDataSets(String... comparedDataSets);

    String getDataDateFormat();
    T setDataDateFormat(String dataDateFormat);

    DataSet getDataSet(String id);
    List<DataSet> getDataSets();
    T setDataSets(List<DataSet> dataSets);
    T addDataSets(DataSet... dataSets);

    DataSetSelector getDataSetSelector();
    T setDataSetSelector(DataSetSelector dataSetSelector);

    Boolean getExtendToFullPeriod();
    T setExtendToFullPeriod(Boolean extendToFullPeriod);

    Integer getFirstDayOfWeek();
    T setFirstDayOfWeek(Integer firstDayOfWeek);

    Boolean getGlueToTheEnd();
    T setGlueToTheEnd(Boolean glueToTheEnd);

    String getLanguage();
    T setLanguage(String language);

    LegendSettings getLegendSettings();
    T setLegendSettings(LegendSettings legendSettings);

    String getMainDataSet();
    T setMainDataSet(String mainDataSet);

    Boolean getMouseWheelScrollEnabled();
    T setMouseWheelScrollEnabled(Boolean mouseWheelScrollEnabled);

    List<StockPanel> getPanels();
    T setPanels(List<StockPanel> panels);
    T addPanels(StockPanel... panels);

    PanelsSettings getPanelsSettings();
    T setPanelsSettings(PanelsSettings panelsSettings);

    String getPath();
    T setPath(String path);

    String getPathToImages();
    T setPathToImages(String pathToImages);

    PeriodSelector getPeriodSelector();
    T setPeriodSelector(PeriodSelector periodSelector);

    StockEventsSettings getStockEventsSettings();
    T setStockEventsSettings(StockEventsSettings stockEventsSettings);

    ChartTheme getTheme();
    T setTheme(ChartTheme theme);

    ValueAxesSettings getValueAxesSettings();
    T setValueAxesSettings(ValueAxesSettings valueAxesSettings);

    Boolean getZoomOutOnDataSetChange();
    T setZoomOutOnDataSetChange(Boolean zoomOutOnDataSetChange);

    List<String> getAdditionalFields();
    T setAdditionalFields(List<String> additionalFields);

    Integer getProcessTimeout();
    T setProcessTimeout(Integer processTimeout);
}