/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.amcharts.model.charts.RectangularChart;
import com.haulmont.charts.gui.amcharts.model.charts.SerialChart;
import com.haulmont.charts.gui.amcharts.model.data.DataItem;
import com.haulmont.charts.gui.amcharts.model.data.DataProvider;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsIntegration;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;
import com.haulmont.charts.web.toolkit.ui.amcharts.events.*;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.FormatStrings;
import com.haulmont.chile.core.datatypes.impl.EnumClass;
import com.haulmont.chile.core.model.Instance;
import com.haulmont.chile.core.model.utils.InstanceUtils;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import java.text.DecimalFormatSymbols;
import java.util.*;

/**
 * @author artamonov
 * @version $Id$
 */
public class WebChart extends WebAbstractComponent<CubaAmchartsScene> implements Chart {

    public static final String AMCHARTS_MESSAGE_PACK = "com.haulmont.charts.gui.amcharts";

    public static final String DEFAULT_JS_DATE_FORMAT = "YYYY-MM-DD JJ:NN:SS:QQQ";

    protected boolean byDate = false;

    protected Messages messages = AppBeans.get(Messages.class);

    protected UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);

    protected CollectionDatasource datasource;

    protected List<AxisZoomListener> axisZoomListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.AxisZoomListener axisZoomHandler;

    protected List<ChartClickListener> clickListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.ChartClickListener clickHandler;

    protected List<ChartClickListener> rightClickListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.ChartRightClickListener rightClickHandler;

    protected List<CursorPeriodSelectListener> periodSelectListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.CursorPeriodSelectListener periodSelectHandler;

    protected List<CursorZoomListener> cursorZoomListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.CursorZoomListener cursorZoomHandler;

    protected List<GraphClickListener> graphClickListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphClickListener graphClickHandler;

    protected List<GraphItemClickListener> graphItemClickListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphItemClickListener graphItemClickHandler;

    protected List<GraphItemClickListener> graphItemRightClickListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphItemRightClickListener graphItemRightClickHandler;

    protected List<LegendItemHideListener> legendItemHideListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendItemHideListener legendItemHideHandler;

    protected List<LegendItemShowListener> legendItemShowListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendItemShowListener legendItemShowHadnler;

    protected List<LegendItemClickListener> legendLabelClickListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendLabelClickListener legendLabelClickHandler;

    protected List<LegendItemClickListener> legendMarkerClickListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendMarkerClickListener legendMarkerClickHandler;

    protected List<SliceClickListener> sliceClickListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SliceClickListener sliceClickHandler;

    protected List<SliceClickListener> sliceRightClickListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SliceRightClickListener sliceRigthClickHandler;

    protected List<SlicePullInListener> slicePullInListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SlicePullInListener slicePullInHandler;

    protected List<SlicePullOutListener> slicePullOutListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SlicePullOutListener slicePullOutHandler;

    protected List<ZoomListener> zoomListeners;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.ZoomListener zoomHandler;

    public WebChart() {
        initLocale();

        component = new CubaAmchartsSceneExt();
    }

    protected void initLocale() {
        CubaAmchartsIntegration amchartsIntegration = CubaAmchartsIntegration.get();
        if (amchartsIntegration.getSettings() == null
                || !ObjectUtils.equals(userSessionSource.getLocale(), amchartsIntegration.getLocale())) {

            Settings settings = new Settings();

            // day of week
            List<String> dayNames = new LinkedList<>();
            List<String> shortDayNames = new LinkedList<>();
            for (DayOfWeek day : DayOfWeek.values()) {
                dayNames.add(messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.dayNames." + day.name()));
                shortDayNames.add(messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.shortDayNames." + day.name()));
            }
            settings.setDayNames(dayNames);
            settings.setShortDayNames(shortDayNames);

            // months
            List<String> monthNames = new LinkedList<>();
            List<String> shortMonthNames = new LinkedList<>();
            for (Month m : Month.values()) {
                monthNames.add(messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.monthNames." + m.name()));
                shortMonthNames.add(messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.shortMonthNames." + m.name()));
            }
            settings.setMonthNames(monthNames);
            settings.setShortMonthNames(shortMonthNames);

            amchartsIntegration.setSettings(settings);
            amchartsIntegration.setLocale(userSessionSource.getLocale());
        }
    }

    @Override
    public boolean isByDate() {
        return byDate;
    }

    @Override
    public void setByDate(boolean byDate) {
        this.byDate = byDate;
    }

    @Override
    public AbstractChart getConfiguration() {
        return component.getChart();
    }

    @Override
    public void setConfiguration(AbstractChart chart) {
        component.drawChart(chart);

        if (chart.getDataProvider() == null && datasource != null) {
            chart.setDataProvider(new EntityDataProvider(datasource));
        }
    }

    @Override
    public void setDatasource(CollectionDatasource datasource) {
        this.datasource = datasource;

        if (datasource == null) {
            component.getChart().setDataProvider(null);
        }
        if (component.getChart() != null) {
            component.getChart().setDataProvider(new EntityDataProvider(datasource));
        }
    }

    @Override
    public CollectionDatasource getDatasource() {
        return datasource;
    }

    @Override
    public void repaint() {
        component.drawChart();
    }

    protected Entity getEventItem(String itemIdString) {
        Entity item = null;

        if (StringUtils.isNotEmpty(itemIdString)) {
            UUID itemId = UUID.fromString(itemIdString);
            //noinspection unchecked
            item = datasource.getItem(itemId);
        }
        return item;
    }

    @Override
    public void addAxisZoomListener(AxisZoomListener zoomListener) {
        if (axisZoomListeners == null) {
            axisZoomListeners = new LinkedList<>();
            axisZoomHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.AxisZoomListener() {
                @Override
                public void onZoom(com.haulmont.charts.web.toolkit.ui.amcharts.events.AxisZoomEvent e) {
                    AxisZoomEvent cubaEvent = new AxisZoomEvent(e.getAxisId(), e.getStartValue(), e.getEndValue());
                    for (AxisZoomListener listener : new ArrayList<>(axisZoomListeners)) {
                        listener.onZoom(cubaEvent);
                    }
                }
            };
            component.addAxisZoomListener(axisZoomHandler);
        }
        if (!axisZoomListeners.contains(zoomListener)) {
            axisZoomListeners.add(zoomListener);
        }
    }

    @Override
    public void removeAxisZoomListener(AxisZoomListener zoomListener) {
        if (axisZoomListeners != null) {
            axisZoomListeners.remove(zoomListener);
            if (axisZoomListeners.isEmpty()) {
                component.removeAxisZoomListener(axisZoomHandler);
                axisZoomHandler = null;
                axisZoomListeners = null;
            }
        }
    }

    @Override
    public void addClickListener(ChartClickListener clickListener) {
        if (clickListeners == null) {
            clickListeners = new LinkedList<>();
            clickHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.ChartClickListener() {
                @Override
                public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.ChartClickEvent e) {
                    ChartClickEvent cubaEvent = new ChartClickEvent(
                            e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY(), e.getXAxis(), e.getYAxis());

                    for (ChartClickListener listener : new ArrayList<>(clickListeners)) {
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
    public void removeClickListener(ChartClickListener clickListener) {
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
    public void addRightClickListener(ChartClickListener clickListener) {
        if (rightClickListeners == null) {
            rightClickListeners = new LinkedList<>();
            rightClickHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.ChartRightClickListener() {
                @Override
                public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.ChartRightClickEvent e) {
                    ChartClickEvent cubaEvent = new ChartClickEvent(
                            e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY(), e.getXAxis(), e.getYAxis());

                    for (ChartClickListener listener : new ArrayList<>(rightClickListeners)) {
                        listener.onClick(cubaEvent);
                    }
                }
            };
        }
        if (!rightClickListeners.contains(clickListener)) {
            rightClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeRightClickListener(ChartClickListener clickListener) {
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
    public void addCursorPeriodSelectListener(CursorPeriodSelectListener selectListener) {
        if (periodSelectListeners == null) {
            periodSelectListeners = new LinkedList<>();
            periodSelectHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.CursorPeriodSelectListener() {
                @Override
                public void onSelect(com.haulmont.charts.web.toolkit.ui.amcharts.events.CursorPeriodSelectEvent event) {
                    CursorPeriodSelectEvent cubaEvent = new CursorPeriodSelectEvent(event.getStart(), event.getEnd());
                    for (CursorPeriodSelectListener listener : new ArrayList<>(periodSelectListeners)) {
                        listener.onSelect(cubaEvent);
                    }
                }
            };
            component.addCursorPeriodSelectListener(periodSelectHandler);
        }
        if (!periodSelectListeners.contains(selectListener)) {
            periodSelectListeners.add(selectListener);
        }
    }

    @Override
    public void removeCursorPeriodSelectListener(CursorPeriodSelectListener selectListener) {
        if (periodSelectListeners != null) {
            periodSelectListeners.remove(selectListener);
            if (periodSelectListeners.isEmpty()) {
                component.removeCursorPeriodSelectListener(periodSelectHandler);
                periodSelectHandler = null;
                periodSelectListeners = null;
            }
        }
    }

    @Override
    public void addCursorZoomListener(CursorZoomListener zoomListener) {
        if (cursorZoomListeners == null) {
            cursorZoomListeners = new LinkedList<>();
            cursorZoomHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.CursorZoomListener() {
                @Override
                public void onZoom(com.haulmont.charts.web.toolkit.ui.amcharts.events.CursorZoomEvent event) {
                    CursorZoomEvent cubaEvent = new CursorZoomEvent(event.getStart(), event.getEnd());
                    for (CursorZoomListener listener : new ArrayList<>(cursorZoomListeners)) {
                        listener.onZoom(cubaEvent);
                    }
                }
            };
            component.addCursorZoomListener(cursorZoomHandler);
        }
        if (!cursorZoomListeners.contains(zoomListener)) {
            cursorZoomListeners.add(zoomListener);
        }
    }

    @Override
    public void removeCursorZoomListener(CursorZoomListener zoomListener) {
        if (cursorZoomListeners != null) {
            cursorZoomListeners.remove(zoomListener);
            if (cursorZoomListeners.isEmpty()) {
                component.removeCursorZoomListener(cursorZoomHandler);
                cursorZoomHandler = null;
                cursorZoomListeners = null;
            }
        }
    }

    @Override
    public void addGraphClickListener(GraphClickListener clickListener) {
        if (graphClickListeners == null) {
            graphClickListeners = new LinkedList<>();
            graphClickHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphClickListener() {
                @Override
                public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphClickEvent e) {
                    GraphClickEvent cubaEvent = new GraphClickEvent(
                            e.getGraphId(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                    for (GraphClickListener listener : new ArrayList<>(graphClickListeners)) {
                        listener.onClick(cubaEvent);
                    }
                }
            };
            component.addGraphClickListener(graphClickHandler);
        }
        if (!graphClickListeners.contains(clickListener)) {
            graphClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeGraphClickListener(GraphClickListener clickListener) {
        if (graphClickListeners != null) {
            graphClickListeners.remove(clickListener);
            if (graphClickListeners.isEmpty()) {
                component.removeGraphClickListener(graphClickHandler);
                graphClickHandler = null;
                graphClickListeners = null;
            }
        }
    }

    @Override
    public void addGraphItemClickListener(GraphItemClickListener clickListener) {
        if (graphItemClickListeners == null) {
            graphItemClickListeners = new LinkedList<>();
            graphItemClickHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphItemClickListener() {
                @Override
                public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphItemClickEvent e) {

                    GraphItemClickEvent cubaEvent = new GraphItemClickEvent(
                            e.getGraphId(), getEventItem(e.getItemId()),
                            e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                    for (GraphItemClickListener listener : new ArrayList<>(graphItemClickListeners)) {
                        listener.onClick(cubaEvent);
                    }
                }
            };
            component.addGraphItemClickListener(graphItemClickHandler);
        }
        if (!graphItemClickListeners.contains(clickListener)) {
            graphItemClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeGraphItemClickListener(GraphItemClickListener clickListener) {
        if (graphItemClickListeners != null) {
            graphItemClickListeners.remove(clickListener);
            if (graphItemClickListeners.isEmpty()) {
                component.removeGraphItemClickListener(graphItemClickHandler);
                graphItemClickHandler = null;
                graphItemClickListeners = null;
            }
        }
    }

    @Override
    public void addGraphItemRightClickListener(GraphItemClickListener clickListener) {
        if (graphItemRightClickListeners == null) {
            graphItemRightClickListeners = new LinkedList<>();
            graphItemRightClickHandler = new GraphItemRightClickListener() {
                @Override
                public void onClick(GraphItemRightClickEvent e) {
                    GraphItemClickEvent cubaEvent = new GraphItemClickEvent(
                            e.getGraphId(), getEventItem(e.getItemId()),
                            e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

                    for (GraphItemClickListener listener : new ArrayList<>(graphItemRightClickListeners)) {
                        listener.onClick(cubaEvent);
                    }
                }
            };
            component.addGraphItemRightClickListener(graphItemRightClickHandler);
        }
        if (!graphItemRightClickListeners.contains(clickListener)) {
            graphItemRightClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeGraphItemRightClickListener(GraphItemClickListener clickListener) {
        if (graphItemRightClickListeners != null) {
            graphItemRightClickListeners.remove(clickListener);
            if (graphItemRightClickListeners.isEmpty()) {
                component.removeGraphItemRightClickListener(graphItemRightClickHandler);
                graphItemRightClickHandler = null;
                graphItemRightClickListeners = null;
            }
        }
    }

    @Override
    public void addLegendItemHideListener(LegendItemHideListener itemHideListener) {
        if (legendItemHideListeners == null) {
            legendItemHideListeners = new LinkedList<>();
            legendItemHideHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendItemHideListener() {
                @Override
                public void onHide(com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendItemHideEvent e) {
                    LegendItemHideEvent cubaEvent = new LegendItemHideEvent(getEventItem(e.getItemId()));

                    for (LegendItemHideListener listener : new ArrayList<>(legendItemHideListeners)) {
                        listener.onHide(cubaEvent);
                    }
                }
            };
            component.addLegendItemHideListener(legendItemHideHandler);
        }
        if (!legendItemHideListeners.contains(itemHideListener)) {
            legendItemHideListeners.add(itemHideListener);
        }
    }

    @Override
    public void removeLegendItemHideListener(LegendItemHideListener itemHideListener) {
        if (legendItemHideListeners != null) {
            legendItemHideListeners.remove(itemHideListener);
            if (legendItemHideListeners.isEmpty()) {
                component.removeLegendItemHideListener(legendItemHideHandler);
                legendItemHideHandler = null;
                legendItemHideListeners = null;
            }
        }
    }

    @Override
    public void addLegendItemShowListener(LegendItemShowListener itemShowListener) {
        if (legendItemShowListeners == null) {
            legendItemShowListeners = new LinkedList<>();
            legendItemShowHadnler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendItemShowListener() {
                @Override
                public void onShow(com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendItemShowEvent e) {
                    LegendItemShowEvent cubaEvent = new LegendItemShowEvent(getEventItem(e.getItemId()));

                    for (LegendItemShowListener listener : new ArrayList<>(legendItemShowListeners)) {
                        listener.onShow(cubaEvent);
                    }
                }
            };
            component.addLegendItemShowListener(legendItemShowHadnler);
        }
        if (!legendItemShowListeners.contains(itemShowListener)) {
            legendItemShowListeners.add(itemShowListener);
        }
    }

    @Override
    public void removeLegendItemShowListener(LegendItemShowListener itemShowListener) {
        if (legendItemShowListeners != null) {
            legendItemShowListeners.remove(itemShowListener);
            if (legendItemShowListeners.isEmpty()) {
                component.removeLegendItemShowListener(legendItemShowHadnler);
                legendItemShowHadnler = null;
                legendItemShowListeners = null;
            }
        }
    }

    @Override
    public void addLegendLabelClickListener(LegendItemClickListener clickListener) {
        if (legendLabelClickListeners == null) {
            legendLabelClickListeners = new LinkedList<>();
            legendLabelClickHandler = new LegendLabelClickListener() {
                @Override
                public void onClick(LegendLabelClickEvent e) {
                    LegendItemClickEvent cubaEvent = new LegendItemClickEvent(getEventItem(e.getItemId()));

                    for (LegendItemClickListener listener : new ArrayList<>(legendLabelClickListeners)) {
                        listener.onClick(cubaEvent);
                    }
                }
            };
            component.addLegendLabelClickListener(legendLabelClickHandler);
        }
        if (!legendLabelClickListeners.contains(clickListener)) {
            legendLabelClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeLegendLabelClickListener(LegendItemClickListener clickListener) {
        if (legendLabelClickListeners != null) {
            legendLabelClickListeners.remove(clickListener);
            if (legendLabelClickListeners.isEmpty()) {
                component.removeLegendLabelClickListener(legendLabelClickHandler);
                legendLabelClickHandler = null;
                legendLabelClickListeners = null;
            }
        }
    }

    @Override
    public void addLegendMarkerClickListener(LegendItemClickListener clickListener) {
        if (legendMarkerClickListeners == null) {
            legendMarkerClickListeners = new LinkedList<>();
            legendMarkerClickHandler = new LegendMarkerClickListener() {
                @Override
                public void onClick(LegendMarkerClickEvent e) {
                    LegendItemClickEvent cubaEvent = new LegendItemClickEvent(getEventItem(e.getItemId()));

                    for (LegendItemClickListener listener : new ArrayList<>(legendMarkerClickListeners)) {
                        listener.onClick(cubaEvent);
                    }
                }
            };
            component.addLegendMarkerClickListener(legendMarkerClickHandler);
        }
        if (!legendMarkerClickListeners.contains(clickListener)) {
            legendMarkerClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeLegendMarkerClickListener(LegendItemClickListener clickListener) {
        if (legendMarkerClickListeners != null) {
            legendMarkerClickListeners.remove(clickListener);
            if (legendMarkerClickListeners.isEmpty()) {
                component.removeLegendMarkerClickListener(legendMarkerClickHandler);
                legendMarkerClickHandler = null;
                legendMarkerClickListeners = null;
            }
        }
    }

    @Override
    public void addSliceClickListener(SliceClickListener clickListener) {
        if (sliceClickListeners == null) {
            sliceClickListeners = new LinkedList<>();
            sliceClickHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.SliceClickListener() {
                @Override
                public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.SliceClickEvent e) {
                    SliceClickEvent cubaEvent = new SliceClickEvent(
                            getEventItem(e.getSliceId()), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
                    for (SliceClickListener listener : new ArrayList<>(sliceClickListeners)) {
                        listener.onClick(cubaEvent);
                    }
                }
            };
            component.addSliceClickListener(sliceClickHandler);
        }
        if (!sliceClickListeners.contains(clickListener)) {
            sliceClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeSliceClickListener(SliceClickListener clickListener) {
        if (sliceClickListeners != null) {
            sliceClickListeners.remove(clickListener);
            if (sliceClickListeners.isEmpty()) {
                component.removeSliceClickListener(sliceClickHandler);
                sliceClickHandler = null;
                sliceClickListeners = null;
            }
        }
    }

    @Override
    public void addSliceRightClickListener(SliceClickListener clickListener) {
        if (sliceRightClickListeners == null) {
            sliceRightClickListeners = new LinkedList<>();
            sliceRigthClickHandler = new SliceRightClickListener() {
                @Override
                public void onClick(SliceRightClickEvent e) {
                    SliceClickEvent cubaEvent = new SliceClickEvent(
                            getEventItem(e.getSliceId()), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
                    for (SliceClickListener listener : new ArrayList<>(sliceRightClickListeners)) {
                        listener.onClick(cubaEvent);
                    }
                }
            };
            component.addSliceRightClickListener(sliceRigthClickHandler);
        }
        if (!sliceRightClickListeners.contains(clickListener)) {
            sliceRightClickListeners.add(clickListener);
        }
    }

    @Override
    public void removeSliceRightClickListener(SliceClickListener clickListener) {
        if (sliceRightClickListeners != null) {
            sliceRightClickListeners.remove(clickListener);
            if (sliceRightClickListeners.isEmpty()) {
                component.removeSliceRightClickListener(sliceRigthClickHandler);
                sliceRigthClickHandler = null;
                sliceRightClickListeners = null;
            }
        }
    }

    @Override
    public void addSlicePullInListener(SlicePullInListener pullInListener) {
        if (slicePullInListeners == null) {
            slicePullInListeners = new LinkedList<>();
            slicePullInHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.SlicePullInListener() {
                @Override
                public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.SlicePullInEvent e) {
                    SlicePullInEvent cubaEvent = new SlicePullInEvent(getEventItem(e.getSliceId()));
                    for (SlicePullInListener listener : new ArrayList<>(slicePullInListeners)) {
                        listener.onPullIn(cubaEvent);
                    }
                }
            };
            component.addSlicePullInListener(slicePullInHandler);
        }
        if (!slicePullInListeners.contains(pullInListener)) {
            slicePullInListeners.add(pullInListener);
        }
    }

    @Override
    public void removeSlicePullInListener(SlicePullInListener pullInListener) {
        if (slicePullInListeners != null) {
            slicePullInListeners.remove(pullInListener);
            if (slicePullInListeners.isEmpty()) {
                component.removeSlicePullInListener(slicePullInHandler);
                slicePullInHandler = null;
                slicePullInListeners = null;
            }
        }
    }

    @Override
    public void addSlicePullOutListener(SlicePullOutListener pullOutListener) {
        if (slicePullOutListeners == null) {
            slicePullOutListeners = new LinkedList<>();
            slicePullOutHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.SlicePullOutListener() {
                @Override
                public void onClick(com.haulmont.charts.web.toolkit.ui.amcharts.events.SlicePullOutEvent e) {
                    SlicePullOutEvent cubaEvent = new SlicePullOutEvent(getEventItem(e.getSliceId()));
                    for (SlicePullOutListener listener : new ArrayList<>(slicePullOutListeners)) {
                        listener.onPullOut(cubaEvent);
                    }
                }
            };
            component.addSlicePullOutListener(slicePullOutHandler);
        }
        if (!slicePullOutListeners.contains(pullOutListener)) {
            slicePullOutListeners.add(pullOutListener);
        }
    }

    @Override
    public void removeSlicePullOutListener(SlicePullOutListener pullOutListener) {
        if (slicePullOutListeners != null) {
            slicePullOutListeners.remove(pullOutListener);
            if (slicePullOutListeners.isEmpty()) {
                component.removeSlicePullOutListener(slicePullOutHandler);
                slicePullOutHandler = null;
                slicePullOutListeners = null;
            }
        }
    }

    @Override
    public void addZoomListener(ZoomListener zoomListener) {
        if (zoomListeners == null) {
            zoomListeners = new LinkedList<>();
            zoomHandler = new com.haulmont.charts.web.toolkit.ui.amcharts.events.ZoomListener() {
                @Override
                public void onZoom(com.haulmont.charts.web.toolkit.ui.amcharts.events.ZoomEvent e) {
                    ZoomEvent cubaEvent = new ZoomEvent(
                            e.getStartIndex(), e.getEndIndex(), e.getStartDate(), e.getEndDate(),
                            e.getStartValue(), e.getEndValue());
                    for (ZoomListener listener : new ArrayList<>(zoomListeners)) {
                        listener.onZoom(cubaEvent);
                    }
                }
            };
            component.addZoomListener(zoomHandler);
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
                component.removeZoomListener(zoomHandler);
                zoomHandler = null;
                zoomListeners = null;
            }
        }
    }

    protected class CubaAmchartsSceneExt extends CubaAmchartsScene {

        @Override
        protected void setupDefaults(AbstractChart chart) {
            super.setupDefaults(chart);

            setupChartLocale(chart);

            if (chart instanceof RectangularChart) {
                setupRectangularChartDefaults((RectangularChart) chart);
            }
            if (chart instanceof SerialChart) {
                setupSerialChartDefaults((SerialChart) chart);
            }
        }

        protected void setupChartLocale(AbstractChart chart) {
            // number formatting
            FormatStrings formatStrings = Datatypes.getFormatStrings(userSessionSource.getLocale());
            if (formatStrings != null) {
                DecimalFormatSymbols formatSymbols = formatStrings.getFormatSymbols();

                if (chart.getNumberFormatter() == null) {
                    chart.setNumberFormatter(new NumberFormatter()
                            .setPrecision(-1)
                            .setDecimalSeparator(Character.toString(formatSymbols.getDecimalSeparator()))
                            .setThousandsSeparator(Character.toString(formatSymbols.getGroupingSeparator())));
                }
                if (chart.getPercentFormatter() == null) {
                    chart.setPercentFormatter(new NumberFormatter()
                            .setPrecision(2)
                            .setDecimalSeparator(Character.toString(formatSymbols.getDecimalSeparator()))
                            .setThousandsSeparator(Character.toString(formatSymbols.getGroupingSeparator())));
                }
            }

            // number prefixes
            if (BooleanUtils.isTrue(chart.getUsePrefixes())) {
                if (chart.getPrefixesOfBigNumbers() == null) {
                    List<BigNumberPrefix> prefixes = new LinkedList<>();
                    for (BigNumberPower power : BigNumberPower.values()) {
                        prefixes.add(new BigNumberPrefix(power,
                                messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.bigNumberPower." + power.name())));
                    }
                    chart.setPrefixesOfBigNumbers(prefixes);
                }
                if (chart.getPrefixesOfSmallNumbers() == null) {
                    List<SmallNumberPrefix> prefixes = new LinkedList<>();
                    for (SmallNumberPower power : SmallNumberPower.values()) {
                        prefixes.add(new SmallNumberPrefix(power,
                                messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.smallNumberPower." + power.name())));
                    }
                    chart.setPrefixesOfSmallNumbers(prefixes);
                }
            }
        }

        protected void setupRectangularChartDefaults(RectangularChart chart) {
            if (chart.getZoomOutText() == null) {
                chart.setZoomOutText(messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.zoomOutText"));
            }

            Cursor cursor = chart.getChartCursor();
            if (cursor != null) {
                if (StringUtils.isEmpty(cursor.getCategoryBalloonDateFormat())) {
                    String format = messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.rectangualrChart.categoryBalloonDateFormat");
                    cursor.setCategoryBalloonDateFormat(format);
                }
            }
        }

        protected void setupSerialChartDefaults(SerialChart chart) {
            if (byDate) {
                CategoryAxis categoryAxis = chart.getCategoryAxis();
                if (categoryAxis == null) {
                    categoryAxis = new CategoryAxis();
                    chart.setCategoryAxis(categoryAxis);
                }

                String firstDayOfWeek = messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.firstDayOfWeek");
                if (categoryAxis.getFirstDayOfWeek() == null) {
                    categoryAxis.setFirstDayOfWeek(DayOfWeek.valueOf(firstDayOfWeek));
                }

                if (categoryAxis.getParseDates() == null) {
                    categoryAxis.setParseDates(true);
                }

                if (StringUtils.isEmpty(chart.getDataDateFormat())) {
                    chart.setDataDateFormat(DEFAULT_JS_DATE_FORMAT);
                }
            }

            if (StringUtils.isEmpty(chart.getBalloonDateFormat())) {
                String format = messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.serialChart.balloonDateFormat");
                chart.setBalloonDateFormat(format);
            }
        }
    }

    protected static class EntityDataProvider implements DataProvider {

        protected final CollectionDatasource datasource;
        protected List<String> properties = new ArrayList<>();

        public EntityDataProvider(CollectionDatasource datasource) {
            this.datasource = datasource;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void bindToChart(AbstractChart chart) {
            properties.clear();
            properties.add("id");
            properties.addAll(chart.getWiredFields());
        }

        @Override
        public List<DataItem> getItems() {
            List<DataItem> items = new ArrayList<>();

            for (Object entityItem : datasource.getItems()) {
                Entity entity = (Entity) entityItem;

                items.add(new EntityDataItem(this, entity));
            }
            return items;
        }

        @Override
        public void addItem(DataItem item) {
        }

        @Override
        public void addItems(Collection<DataItem> items) {
        }

        @Override
        public boolean contains(DataItem item) {
            return false;
        }

        @Override
        public void updateItem(DataItem item) {
        }

        @Override
        public void removeItem(DataItem item) {
        }

        @Override
        public String getDateFormat() {
            return DEFAULT_DATE_FORMAT;
        }

        public Collection<String> getProperties() {
            return properties;
        }
    }

    protected static class EntityDataItem implements DataItem {

        protected Messages messages = AppBeans.get(Messages.NAME);
        protected final EntityDataProvider dataProvider;
        protected final Entity item;

        public EntityDataItem(EntityDataProvider dataProvider, Entity item) {
            this.dataProvider = dataProvider;
            this.item = item;
        }

        @Override
        public Collection<String> getProperties() {
            return dataProvider.getProperties();
        }

        @Override
        public Object getValue(String property) {
            Object value = item.getValue(property);
            if (value instanceof Entity) {
                return InstanceUtils.getInstanceName((Instance) value);
            }
            if (value instanceof EnumClass) {
                return messages.getMessage((Enum) value);
            }
            return value;
        }
    }
}