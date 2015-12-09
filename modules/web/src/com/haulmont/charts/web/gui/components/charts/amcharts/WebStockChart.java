/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;
import com.haulmont.charts.gui.amcharts.model.charts.StockPanel;
import com.haulmont.charts.gui.amcharts.model.data.DataProvider;
import com.haulmont.charts.gui.amcharts.model.data.EntityDataProvider;
import com.haulmont.charts.gui.components.charts.StockChart;
import com.haulmont.charts.web.gui.ChartLocaleHelper;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmStockChartScene;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsIntegration;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.FormatStrings;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.impl.CollectionDsHelper;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import java.text.DecimalFormatSymbols;
import java.util.*;

/**
 * @author gorelov
 * @version $Id$
 */
public class WebStockChart extends WebAbstractComponent<CubaAmStockChartScene> implements StockChart {

    public static final String DEFAULT_JS_DATE_FORMAT = "YYYY-MM-DD JJ:NN:SS:QQQ";

    protected Messages messages = AppBeans.get(Messages.class);

    protected UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);

    protected List<StockChartClickListener> clickListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockChartClickListener clickHandler;

    protected List<StockChartClickListener> rightClickListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockChartRightClickListener rightClickHandler;

    protected List<StockEventClickListener> stockEventClickListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockEventClickListener stockEventClickHandler;

    protected List<StockEventRollOutListener> stockEventRollOutListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockEventRollOutListener stockEventRollOutHandler;

    protected List<StockEventRollOverListener> stockEventRollOverListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockEventRollOverListener stockEventRollOverHandler;

    protected List<ZoomListener> zoomListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockPanelZoomListener stockPanelZoomHandler;

    protected List<PeriodSelectorChangeListener> periodSelectorChangeListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.PeriodSelectorChangeListener periodSelectorChangeHandler;

    protected List<DataSetSelectorCompareListener> dataSetSelectorCompareListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.DataSetSelectorCompareListener dataSetSelectorCompareHandler;

    protected List<DataSetSelectorSelectListener> dataSetSelectorSelectListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.DataSetSelectorSelectListener dataSetSelectorSelectHandler;

    protected List<DataSetSelectorUnCompareListener> dataSetSelectorUnCompareListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.DataSetSelectorUnCompareListener dataSetSelectorUnCompareHandler;

    protected List<StockGraphClickListener> stockGraphClickListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphClickListener stockGraphClickHandler;

    protected List<StockGraphRollOutListener> stockGraphRollOutListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphRollOutListener stockGraphRollOutHandler;

    protected List<StockGraphRollOverListener> stockGraphRollOverListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphRollOverListener stockGraphRollOverHandler;

    protected List<StockGraphItemClickListener> stockGraphItemClickListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemClickListener stockGraphItemClickHandler;

    protected List<StockGraphItemClickListener> stockGraphItemRightClickListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemRightClickListener stockGraphItemRightClickHandler;

    protected List<StockGraphItemRollOutListener> stockGraphItemRollOutListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemRollOutListener stockGraphItemRollOutHandler;

    protected List<StockGraphItemRollOverListener> stockGraphItemRollOverListeners;
    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.StockGraphItemRollOverListener stockGraphItemRollOverHandler;

    public WebStockChart() {
        initLocale();

        component = new CubaAmStockChartSceneExt();
    }

    protected void initLocale() {
        CubaAmchartsIntegration amchartsIntegration = CubaAmchartsIntegration.get();
        if (amchartsIntegration.getSettings() == null
                || !ObjectUtils.equals(userSessionSource.getLocale(), amchartsIntegration.getLocale())) {

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

    @Override
    public StockChartGroup getConfiguration() {
        return component.getChart();
    }

    @Override
    public void setConfiguration(StockChartGroup chart) {
        component.drawChart(chart);
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
                    throw new IllegalArgumentException(""); // TODO: gg, exception text
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
            UUID itemId = UUID.fromString(itemIdString);
            for (DataSet dataSet : component.getChart().getDataSets()) {
                CollectionDatasource ds = getDataSetDatasource(dataSet.getId());
                if (ds != null) {
                    //noinspection unchecked
                    Entity item = ds.getItem(itemId);
                    if (item != null) {
                        return item;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void addClickListener(StockChartClickListener clickListener) {
        if (clickListeners == null) {
            clickListeners = new LinkedList<>();
            clickHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.StockChartClickListener() {
                @Override
                public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockChartClickEvent e) {
                    StockChartClickEvent cubaEvent = new StockChartClickEvent(
                            e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                    for (StockChartClickListener listener : new ArrayList<>(clickListeners)) {
                        listener.onClick(cubaEvent);
                    }
                }
            };
            component.addChartClickListener(clickHandler);
        }
        if (!clickListeners.contains(clickListener)) {
            clickListeners.add(clickListener);
        }
    }

    @Override
    public void removeClickListener(StockChartClickListener clickListener) {
        if (clickListeners != null) {
            clickListeners.remove(clickListener);
            if (clickListeners.isEmpty()) {
                component.removeChartClickListener(clickHandler);
                clickHandler = null;
                clickListeners = null;
            }
        }
    }

    @Override
    public void addRightClickListener(StockChartClickListener clickListener) {
        if (rightClickListeners == null) {
            rightClickListeners = new LinkedList<>();
            rightClickHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.StockChartRightClickListener() {
                @Override
                public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.StockChartRightClickEvent e) {
                    StockChartClickEvent cubaEvent = new StockChartClickEvent(
                            e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                    for (StockChartClickListener listener : new ArrayList<>(rightClickListeners)) {
                        listener.onClick(cubaEvent);
                    }
                }
            };
            component.addChartRightClickListener(rightClickHandler);
        }
        if (!rightClickListeners.contains(clickListener)) {
            rightClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeRightClickListener(StockChartClickListener clickListener) {
        if (rightClickListeners != null) {
            rightClickListeners.remove(clickListener);
            if (rightClickListeners.isEmpty()) {
                component.removeChartRightClickListener(rightClickHandler);
                rightClickHandler = null;
                rightClickListeners = null;
            }
        }
    }

    @Override
    public void addStockEventClickListener(StockEventClickListener clickListener) {
        if (stockEventClickListeners == null) {
            stockEventClickListeners = new LinkedList<>();
            stockEventClickHandler = e -> {
                StockEventClickEvent cubaEvent = new StockEventClickEvent(e.getGraphId(), e.getDate(),
                        getStockEvent(e.getStockEventId()));

                for (StockEventClickListener listener : new ArrayList<>(stockEventClickListeners)) {
                    listener.onClick(cubaEvent);
                }
            };
            component.addStockEventClickListener(stockEventClickHandler);
        }
        if (!stockEventClickListeners.contains(clickListener)) {
            stockEventClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeStockEventClickListener(StockEventClickListener clickListener) {
        if (stockEventClickListeners != null) {
            stockEventClickListeners.remove(clickListener);
            if (stockEventClickListeners.isEmpty()) {
                component.removeStockEventClickListener(stockEventClickHandler);
                stockEventClickHandler = null;
                stockEventClickListeners = null;
            }
        }
    }

    @Override
    public void addStockEventRollOutListener(StockEventRollOutListener rollOutListener) {
        if (stockEventRollOutListeners == null) {
            stockEventRollOutListeners = new LinkedList<>();
            stockEventRollOutHandler = e -> {
                StockEventRollOutEvent cubaEvent = new StockEventRollOutEvent(e.getGraphId(), e.getDate(),
                        getStockEvent(e.getStockEventId()));

                for (StockEventRollOutListener listener : new ArrayList<>(stockEventRollOutListeners)) {
                    listener.onRollOut(cubaEvent);
                }
            };
            component.addStockEventRollOutListener(stockEventRollOutHandler);
        }
        if (!stockEventRollOutListeners.contains(rollOutListener)) {
            stockEventRollOutListeners.add(rollOutListener);
        }
    }

    @Override
    public void removeStockEventRollOutListener(StockEventRollOutListener rollOutListener) {
        if (stockEventRollOutListeners != null) {
            stockEventRollOutListeners.remove(rollOutListener);
            if (stockEventRollOutListeners.isEmpty()) {
                component.removeStockEventRollOutListener(stockEventRollOutHandler);
                stockEventRollOutHandler = null;
                stockEventRollOutListeners = null;
            }
        }
    }

    @Override
    public void addStockEventRollOverListener(StockEventRollOverListener rollOverListener) {
        if (stockEventRollOverListeners == null) {
            stockEventRollOverListeners = new LinkedList<>();
            stockEventRollOverHandler = e -> {
                StockEventRollOverEvent cubaEvent = new StockEventRollOverEvent(e.getGraphId(), e.getDate(),
                        getStockEvent(e.getStockEventId()));

                for (StockEventRollOverListener listener : new ArrayList<>(stockEventRollOverListeners)) {
                    listener.onRollOver(cubaEvent);
                }
            };
            component.addStockEventRollOverListener(stockEventRollOverHandler);
        }
        if (!stockEventRollOverListeners.contains(rollOverListener)) {
            stockEventRollOverListeners.add(rollOverListener);
        }
    }

    @Override
    public void removeStockEventRollOverListener(StockEventRollOverListener rollOverListener) {
        if (stockEventRollOverListeners != null) {
            stockEventRollOverListeners.remove(rollOverListener);
            if (stockEventRollOverListeners.isEmpty()) {
                component.removeStockEventRollOverListener(stockEventRollOverHandler);
                stockEventRollOverHandler = null;
                stockEventRollOverListeners = null;
            }
        }
    }

    @Override
    public void addZoomListener(ZoomListener zoomListener) {
        if (zoomListeners == null) {
            zoomListeners = new LinkedList<>();
            stockPanelZoomHandler = e -> {
                ZoomEvent cubaEvent = new ZoomEvent(e.getStartDate(), e.getEndDate(), DatePeriod.fromId(e.getPeriod()));

                for (ZoomListener listener : new ArrayList<>(zoomListeners)) {
                    listener.onZoom(cubaEvent);
                }
            };
            component.addStockPanelZoomListener(stockPanelZoomHandler);
        }
        if (!zoomListeners.contains(zoomListener)) {
            zoomListeners.add(zoomListener);
        }
    }

    @Override
    public void removeZoomListener(ZoomListener zoomListener) {
        if (zoomListeners != null) {
            zoomListeners.remove(zoomListener);
            if (zoomListeners.isEmpty()) {
                component.removeStockPanelZoomListener(stockPanelZoomHandler);
                stockPanelZoomHandler = null;
                zoomListeners = null;
            }
        }
    }

    @Override
    public void addPeriodSelectorChangeListener(PeriodSelectorChangeListener changeListener) {
        if (periodSelectorChangeListeners == null) {
            periodSelectorChangeListeners = new LinkedList<>();
            periodSelectorChangeHandler = e -> {
                PeriodSelectorChangeEvent cubaEvent = new PeriodSelectorChangeEvent(e.getStartDate(), e.getEndDate(),
                        PeriodType.fromId(e.getPredefinedPeriod()), e.getCount(),
                        e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                for (PeriodSelectorChangeListener listener : new ArrayList<>(periodSelectorChangeListeners)) {
                    listener.onChange(cubaEvent);
                }
            };
            component.addPeriodSelectorChangeListener(periodSelectorChangeHandler);
        }
        if (!periodSelectorChangeListeners.contains(changeListener)) {
            periodSelectorChangeListeners.add(changeListener);
        }
    }

    @Override
    public void removePeriodSelectorChangeListener(PeriodSelectorChangeListener changeListener) {
        if (periodSelectorChangeListeners != null) {
            periodSelectorChangeListeners.remove(changeListener);
            if (periodSelectorChangeListeners.isEmpty()) {
                component.removePeriodSelectorChangeListener(periodSelectorChangeHandler);
                periodSelectorChangeHandler = null;
                periodSelectorChangeListeners = null;
            }
        }
    }

    @Override
    public void addDataSetSelectorCompareListener(DataSetSelectorCompareListener compareListener) {
        if (dataSetSelectorCompareListeners == null) {
            dataSetSelectorCompareListeners = new LinkedList<>();
            dataSetSelectorCompareHandler = e -> {
                DataSetSelectorCompareEvent cubaEvent = new DataSetSelectorCompareEvent(e.getDataSetId());

                for (DataSetSelectorCompareListener listener : dataSetSelectorCompareListeners) {
                    listener.onCompare(cubaEvent);
                }
            };
            component.addDataSetSelectorCompareListener(dataSetSelectorCompareHandler);
        }
        if (!dataSetSelectorCompareListeners.contains(compareListener)) {
            dataSetSelectorCompareListeners.add(compareListener);
        }
    }

    @Override
    public void removeDataSetSelectorCompareListener(DataSetSelectorCompareListener compareListener) {
        if (dataSetSelectorCompareListeners != null) {
            dataSetSelectorCompareListeners.remove(compareListener);
            if (dataSetSelectorCompareListeners.isEmpty()) {
                component.removeDataSetSelectorCompareListener(dataSetSelectorCompareHandler);
                dataSetSelectorCompareHandler = null;
                dataSetSelectorCompareListeners = null;
            }
        }
    }

    @Override
    public void addDataSetSelectorSelectListener(DataSetSelectorSelectListener selectListener) {
        if (dataSetSelectorSelectListeners == null) {
            dataSetSelectorSelectListeners = new LinkedList<>();
            dataSetSelectorSelectHandler = e -> {
                DataSetSelectorSelectEvent cubaEvent = new DataSetSelectorSelectEvent(e.getDataSetId());

                for (DataSetSelectorSelectListener listener : dataSetSelectorSelectListeners) {
                    listener.onSelect(cubaEvent);
                }
            };
            component.addDataSetSelectorSelectListener(dataSetSelectorSelectHandler);
        }
        if (!dataSetSelectorSelectListeners.contains(selectListener)) {
            dataSetSelectorSelectListeners.add(selectListener);
        }
    }

    @Override
    public void removeDataSetSelectorSelectListener(DataSetSelectorSelectListener selectListener) {
        if (dataSetSelectorSelectListeners != null) {
            dataSetSelectorSelectListeners.remove(selectListener);
            if (dataSetSelectorSelectListeners.isEmpty()) {
                component.removeDataSetSelectorSelectListener(dataSetSelectorSelectHandler);
                dataSetSelectorSelectHandler = null;
                dataSetSelectorSelectListeners = null;
            }
        }
    }

    @Override
    public void addDataSetSelectorUnCompareListener(DataSetSelectorUnCompareListener unCompareListener) {
        if (dataSetSelectorUnCompareListeners == null) {
            dataSetSelectorUnCompareListeners = new LinkedList<>();
            dataSetSelectorUnCompareHandler = e -> {
                DataSetSelectorUnCompareEvent cubaEvent = new DataSetSelectorUnCompareEvent(e.getDataSetId());

                for (DataSetSelectorUnCompareListener listener : dataSetSelectorUnCompareListeners) {
                    listener.onUnCompare(cubaEvent);
                }
            };
            component.addDataSetSelectorUnCompareListener(dataSetSelectorUnCompareHandler);
        }
        if (!dataSetSelectorUnCompareListeners.contains(unCompareListener)) {
            dataSetSelectorUnCompareListeners.add(unCompareListener);
        }
    }

    @Override
    public void removeDataSetSelectorUnCompareListener(DataSetSelectorUnCompareListener unCompareListener) {
        if (dataSetSelectorUnCompareListeners != null) {
            dataSetSelectorUnCompareListeners.remove(unCompareListener);
            if (dataSetSelectorUnCompareListeners.isEmpty()) {
                component.removeDataSetSelectorUnCompareListener(dataSetSelectorUnCompareHandler);
                dataSetSelectorUnCompareHandler = null;
                dataSetSelectorUnCompareListeners = null;
            }
        }
    }

    @Override
    public void addStockGraphClickListener(StockGraphClickListener clickListener) {
        if (stockGraphClickListeners == null) {
            stockGraphClickListeners = new LinkedList<>();
            stockGraphClickHandler = e -> {
                StockGraphClickEvent cubaEvent = new StockGraphClickEvent(e.getPanelId(), e.getGraphId(),
                        e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                for (StockGraphClickListener listener : new ArrayList<>(stockGraphClickListeners)) {
                    listener.onClick(cubaEvent);
                }
            };
            component.addStockGraphClickListener(stockGraphClickHandler);
        }
        if (!stockGraphClickListeners.contains(clickListener)) {
            stockGraphClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeStockGraphClickListener(StockGraphClickListener clickListener) {
        if (stockGraphClickListeners != null) {
            stockGraphClickListeners.remove(clickListener);
            if (stockGraphClickListeners.isEmpty()) {
                component.removeStockGraphClickListener(stockGraphClickHandler);
                stockGraphClickHandler = null;
                stockGraphClickListeners = null;
            }
        }
    }

    @Override
    public void addStockGraphRollOutListener(StockGraphRollOutListener rollOutListener) {
        if (stockGraphRollOutListeners == null) {
            stockGraphRollOutListeners = new LinkedList<>();
            stockGraphRollOutHandler = e -> {
                StockGraphRollOutEvent cubaEvent = new StockGraphRollOutEvent(e.getPanelId(), e.getGraphId(),
                        e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                for (StockGraphRollOutListener listener : new ArrayList<>(stockGraphRollOutListeners)) {
                    listener.onRollOut(cubaEvent);
                }
            };
            component.addStockGraphRollOutListener(stockGraphRollOutHandler);
        }
        if (!stockGraphRollOutListeners.contains(rollOutListener)) {
            stockGraphRollOutListeners.add(rollOutListener);
        }
    }

    @Override
    public void removeStockGraphRollOutListener(StockGraphRollOutListener rollOutListener) {
        if (stockGraphRollOutListeners != null) {
            stockGraphRollOutListeners.remove(rollOutListener);
            if (stockGraphRollOutListeners.isEmpty()) {
                component.removeStockGraphRollOutListener(stockGraphRollOutHandler);
                stockGraphRollOutHandler = null;
                stockGraphRollOutListeners = null;
            }
        }
    }

    @Override
    public void addStockGraphRollOverListener(StockGraphRollOverListener rollOverListener) {
        if (stockGraphRollOverListeners == null) {
            stockGraphRollOverListeners = new LinkedList<>();
            stockGraphRollOverHandler = e -> {
                StockGraphRollOverEvent cubaEvent = new StockGraphRollOverEvent(e.getPanelId(), e.getGraphId(),
                        e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                for (StockGraphRollOverListener listener : new ArrayList<>(stockGraphRollOverListeners)) {
                    listener.onRollOver(cubaEvent);
                }
            };
            component.addStockGraphRollOverListener(stockGraphRollOverHandler);
        }
        if (!stockGraphRollOverListeners.contains(rollOverListener)) {
            stockGraphRollOverListeners.add(rollOverListener);
        }
    }

    @Override
    public void removeStockGraphRollOverListener(StockGraphRollOverListener rollOverListener) {
        if (stockGraphRollOverListeners != null) {
            stockGraphRollOverListeners.remove(rollOverListener);
            if (stockGraphRollOverListeners.isEmpty()) {
                component.removeStockGraphRollOverListener(stockGraphRollOverHandler);
                stockGraphRollOverHandler = null;
                stockGraphRollOverListeners = null;
            }
        }
    }

    @Override
    public void addStockGraphItemClickListener(StockGraphItemClickListener clickListener) {
        if (stockGraphItemClickListeners == null) {
            stockGraphItemClickListeners = new LinkedList<>();
            stockGraphItemClickHandler = e -> {
                StockGraphItemClickEvent cubaEvent = new StockGraphItemClickEvent(e.getPanelId(), e.getGraphId(),
                        getEventItem(e.getItemId()), e.getItemIndex(),
                        e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                for (StockGraphItemClickListener listener : new ArrayList<>(stockGraphItemClickListeners)) {
                    listener.onClick(cubaEvent);
                }
            };
            component.addStockGraphItemClickListener(stockGraphItemClickHandler);
        }
        if (!stockGraphItemClickListeners.contains(clickListener)) {
            stockGraphItemClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeStockGraphItemClickListener(StockGraphItemClickListener clickListener) {
        if (stockGraphItemClickListeners != null) {
            stockGraphItemClickListeners.remove(clickListener);
            if (stockGraphItemClickListeners.isEmpty()) {
                component.removeStockGraphItemClickListener(stockGraphItemClickHandler);
                stockGraphItemClickHandler = null;
                stockGraphItemClickListeners = null;
            }
        }
    }

    @Override
    public void addStockGraphItemRightClickListener(StockGraphItemClickListener clickListener) {
        if (stockGraphItemRightClickListeners == null) {
            stockGraphItemRightClickListeners = new LinkedList<>();
            stockGraphItemRightClickHandler = e -> {
                StockGraphItemClickEvent cubaEvent = new StockGraphItemClickEvent(e.getPanelId(), e.getGraphId(),
                        getEventItem(e.getItemId()), e.getItemIndex(),
                        e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                for (StockGraphItemClickListener listener : new ArrayList<>(stockGraphItemRightClickListeners)) {
                    listener.onClick(cubaEvent);
                }
            };
            component.addStockGraphItemRightClickListener(stockGraphItemRightClickHandler);
        }
        if (!stockGraphItemRightClickListeners.contains(clickListener)) {
            stockGraphItemRightClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeStockGraphItemRightClickListener(StockGraphItemClickListener clickListener) {
        if (stockGraphItemRightClickListeners != null) {
            stockGraphItemRightClickListeners.remove(clickListener);
            if (stockGraphItemRightClickListeners.isEmpty()) {
                component.removeStockGraphItemRightClickListener(stockGraphItemRightClickHandler);
                stockGraphItemRightClickHandler = null;
                stockGraphItemRightClickListeners = null;
            }
        }
    }

    @Override
    public void addStockGraphItemRollOutListener(StockGraphItemRollOutListener rollOutListener) {
        if (stockGraphItemRollOutListeners == null) {
            stockGraphItemRollOutListeners = new LinkedList<>();
            stockGraphItemRollOutHandler = e -> {
                StockGraphItemRollOutEvent cubaEvent = new StockGraphItemRollOutEvent(e.getPanelId(), e.getGraphId(),
                        getEventItem(e.getItemId()), e.getItemIndex(),
                        e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                for (StockGraphItemRollOutListener listener : new ArrayList<>(stockGraphItemRollOutListeners)) {
                    listener.onRollOut(cubaEvent);
                }
            };
            component.addStockGraphItemRollOutListener(stockGraphItemRollOutHandler);
        }
        if (!stockGraphItemRollOutListeners.contains(rollOutListener)) {
            stockGraphItemRollOutListeners.add(rollOutListener);
        }
    }

    @Override
    public void removeStockGraphItemRollOutListener(StockGraphItemRollOutListener rollOutListener) {
        if (stockGraphItemRollOutListeners != null) {
            stockGraphItemRollOutListeners.remove(rollOutListener);
            if (stockGraphItemRollOutListeners.isEmpty()) {
                component.removeStockGraphItemRollOutListener(stockGraphItemRollOutHandler);
                stockGraphItemRollOutHandler = null;
                stockGraphItemRollOutListeners = null;
            }
        }
    }

    @Override
    public void addStockGraphItemRollOverListener(StockGraphItemRollOverListener rollOverListener) {
        if (stockGraphItemRollOverListeners == null) {
            stockGraphItemRollOverListeners = new LinkedList<>();
            stockGraphItemRollOverHandler = e -> {
                StockGraphItemRollOverEvent cubaEvent = new StockGraphItemRollOverEvent(e.getPanelId(), e.getGraphId(),
                        getEventItem(e.getItemId()), e.getItemIndex(),
                        e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                for (StockGraphItemRollOverListener listener : new ArrayList<>(stockGraphItemRollOverListeners)) {
                    listener.onRollOver(cubaEvent);
                }
            };
            component.addStockGraphItemRollOverListener(stockGraphItemRollOverHandler);
        }
        if (!stockGraphItemRollOverListeners.contains(rollOverListener)) {
            stockGraphItemRollOverListeners.add(rollOverListener);
        }
    }

    @Override
    public void removeStockGraphItemRollOverListener(StockGraphItemRollOverListener rollOverListener) {
        if (stockGraphItemRollOverListeners != null) {
            stockGraphItemRollOverListeners.remove(rollOverListener);
            if (stockGraphItemRollOverListeners.isEmpty()) {
                component.removeStockGraphItemRollOverListener(stockGraphItemRollOverHandler);
                stockGraphItemRollOverHandler = null;
                stockGraphItemRollOverListeners = null;
            }
        }
    }

    protected class CubaAmStockChartSceneExt extends CubaAmStockChartScene {
        private static final long serialVersionUID = 3782372417182270572L;

        @Override
        protected void setupDefaults(StockChartGroup chart) {
            super.setupDefaults(chart);

            setupChartLocale(chart);

            if (StringUtils.isEmpty(chart.getDataDateFormat())) {
                chart.setDataDateFormat(DEFAULT_JS_DATE_FORMAT);
            }
        }

        protected void setupChartLocale(StockChartGroup chart) {
            // language
            if (StringUtils.isEmpty(chart.getLanguage())) {
                chart.setLanguage(messages.getTools().localeToString(userSessionSource.getLocale()));
            }

            // export
            if (chart.getExport() != null && chart.getExport().getDateFormat() == null) {
                chart.getExport().setDateFormat(messages.getMainMessage("amcharts.export.dateFormat"));
            }

            // number formatting
            FormatStrings formatStrings = Datatypes.getFormatStrings(userSessionSource.getLocale());
            if (formatStrings != null) {
                List<StockPanel> panels = chart.getPanels();
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

            PanelsSettings panelsSettings = chart.getPanelsSettings();
            if (panelsSettings != null) {

                // number prefixes
                if (BooleanUtils.isTrue(panelsSettings.getUsePrefixes())) {
                    if (panelsSettings.getPrefixesOfBigNumbers() == null) {
                        List<BigNumberPrefix> prefixes = new LinkedList<>();
                        for (BigNumberPower power : BigNumberPower.values()) {
                            prefixes.add(new BigNumberPrefix(power,
                                    messages.getMainMessage("amcharts.bigNumberPower." + power.name())));
                        }
                        panelsSettings.setPrefixesOfBigNumbers(prefixes);
                    }
                    if (panelsSettings.getPrefixesOfSmallNumbers() == null) {
                        List<SmallNumberPrefix> prefixes = new LinkedList<>();
                        for (SmallNumberPower power : SmallNumberPower.values()) {
                            prefixes.add(new SmallNumberPrefix(power,
                                    messages.getMainMessage("amcharts.smallNumberPower." + power.name())));
                        }
                        panelsSettings.setPrefixesOfSmallNumbers(prefixes);
                    }
                }
            }
        }
    }
}
