/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.List;

public interface StockChartModel<T extends StockChartModel> extends HasColors<T> {
    /**
     * @return true if addClassNames option is enabled
     */
    Boolean getAddClassNames();

    /**
     * Set addClassNames to true, if class names should be added to chart elements.
     *
     * @param addClassNames add class names option
     */
    T setAddClassNames(Boolean addClassNames);

    /**
     * @return export menu
     */
    Export getExport();

    /**
     * Sets the export menu.
     *
     * @param export export menu
     */
    T setExport(Export export);

    /**
     * @return true if animation was already played
     */
    Boolean getAnimationPlayed();

    /**
     * Specifies if animation was already played. Animation is only played once, when chart is rendered for the first
     * time. If you want the animation to be repeated, set this property to false.
     *
     * @param animationPlayed animation played option
     */
    T setAnimationPlayed(Boolean animationPlayed);

    /**
     * @return true if autoResize is enabled
     */
    Boolean getAutoResize();

    /**
     * Set autoResize to true if you want chart to resize itself whenever its parent container size changes. If not
     * set the default value is true.
     *
     * @param autoResize auto resize option
     */
    T setAutoResize(Boolean autoResize);

    /**
     * @return balloon
     */
    Balloon getBalloon();

    /**
     * Sets the balloon.
     *
     * @param balloon the balloon
     */
    T setBalloon(Balloon balloon);

    /**
     * @return category axis settings
     */
    CategoryAxesSettings getCategoryAxesSettings();

    /**
     * Sets settings for category axes.
     *
     * @param categoryAxesSettings category axis settings
     */
    T setCategoryAxesSettings(CategoryAxesSettings categoryAxesSettings);

    /**
     * @return chart cursor settings
     */
    ChartCursorSettings getChartCursorSettings();

    /**
     * Sets chart cursor settings.
     *
     * @param chartCursorSettings chart cursor settings
     */
    T setChartCursorSettings(ChartCursorSettings chartCursorSettings);

    ChartScrollbarSettings getChartScrollbarSettings();

    /**
     * Sets chart scrollbar settings.
     *
     * @param chartScrollbarSettings chart scrollbar settings
     */
    T setChartScrollbarSettings(ChartScrollbarSettings chartScrollbarSettings);

    /**
     * @return class name prefix
     */
    String getClassNamePrefix();

    /**
     * Sets the class name prefix. This prefix is added to all class names which are added to all visual elements of
     * a chart in case addClassNames is set to true. If not set the default value is false. If not set the default
     * value is "amcharts".
     *
     * @param classNamePrefix class name prefix string
     */
    T setClassNamePrefix(String classNamePrefix);

    /**
     * @return list of compared data sets
     */
    List<String> getComparedDataSets();

    /**
     * Sets the list of of data sets selected for comparing.
     *
     * @param comparedDataSets compared data sets
     */
    T setComparedDataSets(List<String> comparedDataSets);

    /**
     * Adds compared data sets.
     *
     * @param comparedDataSets compared data sets
     */
    T addComparedDataSets(String... comparedDataSets);

    /**
     * @return data date format
     */
    String getDataDateFormat();

    /**
     * Sets data date format. Please note, that two-digit years "YY" is NOT supported in this setting.
     *
     * @param dataDateFormat data date format string
     */
    T setDataDateFormat(String dataDateFormat);

    /**
     * Gets data set by id.
     *
     * @param id id of dataSet
     * @return data set
     */
    DataSet getDataSet(String id);

    /**
     * @return list of data sets
     */
    List<DataSet> getDataSets();

    /**
     * Sets the list of data sets.
     *
     * @param dataSets list of data sets
     */
    T setDataSets(List<DataSet> dataSets);

    /**
     * Adds data sets.
     *
     * @param dataSets data sets
     */
    T addDataSets(DataSet... dataSets);

    /**
     * @return data set selector
     */
    DataSetSelector getDataSetSelector();

    /**
     * Sets data set selector. You can add it if you have more than one data set and want users to be able to
     * select/compare them.
     *
     * @param dataSetSelector data set selector
     */
    T setDataSetSelector(DataSetSelector dataSetSelector);

    /**
     * @return true if chart always displays full first and last data item when data is grouped to a longer period if
     * the chart is zoomed from the beginning or end of the data
     */
    Boolean getExtendToFullPeriod();

    /**
     * Specifies if the chart should always display full first and last data item when data is grouped to a longer
     * period if the chart is zoomed from the beginning or end of the data. If not set the default value is true.
     *
     * @param extendToFullPeriod extend to full period option
     */
    T setExtendToFullPeriod(Boolean extendToFullPeriod);

    /**
     * @return first day of week
     */
    Integer getFirstDayOfWeek();

    /**
     * Sets day week starts. 0 - Sunday, 1 - Monday etc. If not set the default value is 1.
     *
     * @param firstDayOfWeek first day of week
     */
    T setFirstDayOfWeek(Integer firstDayOfWeek);

    /**
     * @return true if the scope of the data view is set to the end after data update
     */
    Boolean getGlueToTheEnd();

    /**
     * Set glueToTheEnd to true if the scope of the data view should be set to the end after data update. If not set
     * the default value is false.
     *
     * @param glueToTheEnd glue to the end option
     */
    T setGlueToTheEnd(Boolean glueToTheEnd);

    /**
     * @return language
     */
    String getLanguage();

    /**
     * Sets language of default. Note, you should include language js file from amcharts/lang and then use variable
     * name used in this file, like <code>setLanguage("de")</code>.
     *
     * @param language language string
     */
    T setLanguage(String language);

    /**
     * @return legend settings
     */
    LegendSettings getLegendSettings();

    /**
     * Sets legend settings.
     *
     * @param legendSettings legend settings
     */
    T setLegendSettings(LegendSettings legendSettings);

    /**
     * @return main data set
     */
    String getMainDataSet();

    /**
     * Sets data set as main.
     *
     * @param mainDataSet main data set
     */
    T setMainDataSet(String mainDataSet);

    /**
     * @return true if scrolling of a chart with mouse wheel is enabled
     */
    Boolean getMouseWheelScrollEnabled();

    /**
     * Set mouseWheelScrollEnabled to true you wont to scroll chart with mouse wheel. If not set the default value is
     * false.
     *
     * @param mouseWheelScrollEnabled mouse wheel scroll option
     */
    T setMouseWheelScrollEnabled(Boolean mouseWheelScrollEnabled);

    /**
     * @return list of stock panels
     */
    List<StockPanel> getPanels();

    /**
     * Sets list of stock panels.
     *
     * @param panels list of stock panels
     */
    T setPanels(List<StockPanel> panels);

    /**
     * Adds stock panels.
     *
     * @param panels stock panels
     */
    T addPanels(StockPanel... panels);

    /**
     * @return panel settings
     */
    PanelsSettings getPanelsSettings();

    /**
     * Sets settings for stock panels.
     *
     * @param panelsSettings panel settings
     */
    T setPanelsSettings(PanelsSettings panelsSettings);

    /**
     * @return path
     */
    String getPath();

    /**
     * Specifies absolute or relative path to amCharts files.
     *
     * @param path the path string
     */
    T setPath(String path);

    String getPathToImages();

    /**
     * Specifies path to the folder where images like resize grips, lens and similar are.
     *
     * @param pathToImages path to images
     */
    T setPathToImages(String pathToImages);

    /**
     * @return period selector
     */
    PeriodSelector getPeriodSelector();

    /**
     * Sets period selector. You can add it if you want user's to be able to enter date ranges or zoom chart with
     * predefined period buttons.
     *
     * @param periodSelector period selector
     */
    T setPeriodSelector(PeriodSelector periodSelector);

    /**
     * @return stock events settings
     */
    StockEventsSettings getStockEventsSettings();

    /**
     * Sets settings for stock events.
     *
     * @param stockEventsSettings stock events settings
     */
    T setStockEventsSettings(StockEventsSettings stockEventsSettings);

    /**
     * @return theme of a chart
     */
    ChartTheme getTheme();

    /**
     * Sets theme of a chart.
     *
     * @param theme the theme
     */
    T setTheme(ChartTheme theme);

    /**
     * @return value axes settings
     */
    ValueAxesSettings getValueAxesSettings();

    /**
     * Sets settings for value axes.
     *
     * @param valueAxesSettings value axes settings
     */
    T setValueAxesSettings(ValueAxesSettings valueAxesSettings);

    /**
     * @return true if chart zoom-out when main data set is changed
     */
    Boolean getZoomOutOnDataSetChange();

    /**
     * Specifies whether the chart should zoom-out when main data set is changed. If not set the default value is false.
     *
     * @param zoomOutOnDataSetChange zoom out on data set change option
     */
    T setZoomOutOnDataSetChange(Boolean zoomOutOnDataSetChange);

    /**
     * @return list of additional fields
     */
    List<String> getAdditionalFields();

    /**
     * Sets list of additional fields. Fields from your data provider that should be used directly in the chart
     * configuration.
     *
     * @param additionalFields list of additional fields
     */
    T setAdditionalFields(List<String> additionalFields);

    /**
     * @return process timeout
     */
    Integer getProcessTimeout();

    /**
     * Sets the process timeout. If you set it to 1 millisecond or some bigger value, chart will be built in chunks
     * instead of all at once. This is useful if you work with a lot of data and the initial build of the chart takes
     * a lot of time, which freezes the whole web application by not allowing other processes to do their job while
     * the chart is busy. If not set the default value is 0.
     *
     * @param processTimeout process timeout
     */
    T setProcessTimeout(Integer processTimeout);
}