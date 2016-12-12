/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractSerialChart;
import com.haulmont.charts.gui.amcharts.model.charts.GanttChart;
import com.haulmont.charts.gui.amcharts.model.charts.RectangularChart;
import com.haulmont.charts.gui.data.EntityDataProvider;
import com.haulmont.charts.gui.amcharts.model.gson.ChartJsonSerializationContext;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.web.gui.ChartLocaleHelper;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsIntegration;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;
import com.haulmont.charts.web.toolkit.ui.amcharts.events.*;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.FormatStrings;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.impl.CollectionDsHelper;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import com.vaadin.server.ClientConnector;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Nullable;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.*;

public class WebChart extends WebAbstractComponent<CubaAmchartsScene> implements Chart {

    protected boolean byDate = false;

    protected Messages messages = AppBeans.get(Messages.class);

    protected Metadata metadata = AppBeans.get(Metadata.class);

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
        component.addAttachListener(new ClientConnector.AttachListener() {
            @Override
            public void attach(ClientConnector.AttachEvent event) {
                if (datasource != null) {
                    CollectionDsHelper.autoRefreshInvalid(datasource, true);
                }
            }
        });
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
        if (chart.getDataProvider() == null && datasource != null) {
            chart.setDataProvider(new EntityDataProvider(datasource));
        }

        component.drawChart(chart);

        if (component.getChart() != null &&
                component.getChart().getResponsive() != null &&
                BooleanUtils.isTrue(component.getChart().getResponsive().isEnabled())) {
            component.activateResponsivePlugin();
        }
    }

    @Override
    public void setDatasource(CollectionDatasource datasource) {
        this.datasource = datasource;

        if (datasource == null) {
            component.getChart().setDataProvider(null);
        } else {
            CollectionDsHelper.autoRefreshInvalid(datasource, true);
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

    @Override
    public void zoomOut() {
        component.zoomOut();
    }

    @Override
    public void zoomToIndexes(int start, int end) {
        component.zoomToIndexes(start, end);
    }

    @Override
    public void zoomToDates(Date start, Date end) {
        component.zoomToDates(start, end);
    }

    @Override
    public void zoomOutValueAxes() {
        component.zoomOutValueAxes();
    }

    @Override
    public void zoomOutValueAxis(String id) {
        component.zoomOutValueAxis(id);
    }

    @Override
    public void zoomOutValueAxis(int index) {
        component.zoomOutValueAxis(index);
    }

    @Override
    public void zoomValueAxisToValues(String id, Object startValue, Object endValue) {
        component.zoomValueAxisToValues(id, startValue, endValue);
    }

    @Override
    public void zoomValueAxisToValues(int index, Object startValue, Object endValue) {
        component.zoomValueAxisToValues(index, startValue, endValue);
    }

    protected Entity getEventItem(String itemIdString) {
        if (datasource != null && StringUtils.isNotEmpty(itemIdString)) {
            if (component.getChart() instanceof GanttChart) {
                return getGanttChartEventItem(itemIdString);
            } else {
                //noinspection unchecked
                return datasource.getItem(getItemId(datasource, itemIdString));
            }
        }
        return null;
    }

    protected Entity getGanttChartEventItem(String itemIdString) {
        GanttChart ganttChart = (GanttChart) component.getChart();

        String[] ids = itemIdString.split(":");
        if (ids.length != 2) {
            return null;
        }

        Object categoryId = getItemId(datasource, ids[0]);
        if (categoryId == null) {
            return null;
        }

        //noinspection unchecked
        Entity category = datasource.getItem(categoryId);
        if (category == null) {
            return null;
        }

        Collection segments = category.getValue(ganttChart.getSegmentsField());
        if (segments == null) {
            return null;
        }

        Object segmentId = getItemId(segments, ids[1]);
        if (segmentId == null) {
            return null;
        }

        for (Object segment : segments) {
            if (segment instanceof Entity && segmentId.equals(((Entity) segment).getId())) {
                return (Entity) segment;
            }
        }

        return null;
    }

    @Nullable
    protected Object getItemId(CollectionDatasource datasource, String itemIdString) {
        if (metadata.getTools().isTransient(datasource.getMetaClass())) {
            return UuidProvider.fromString(itemIdString);
        }
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

    @Nullable
    protected Object getItemId(Collection items, String itemIdString) {
        if (CollectionUtils.isNotEmpty(items)) {
            Object obj = items.iterator().next();
            if (obj instanceof Entity) {
                Entity entity = (Entity) obj;
                MetaClass metaClass = metadata.getClassNN(entity.getClass());
                if (metadata.getTools().isTransient(metaClass)) {
                    return UuidProvider.fromString(itemIdString);
                }
                MetaProperty pkProp = metadata.getTools().getPrimaryKeyProperty(metaClass);
                if (pkProp != null) {
                    Datatype<Object> datatype = pkProp.getRange().asDatatype();
                    try {
                        return datatype.parse(itemIdString);
                    } catch (ParseException e) {
                        throw new RuntimeException("Error parsing item ID", e);
                    }
                }
            }
        }
        return null;
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
            component.addChartRightClickListener(rightClickHandler);
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
                            e.getItemIndex(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

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
                            e.getItemIndex(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());

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

    @Override
    public void setResponsive(boolean responsive) {
        if (component.getChart() == null) {
            throw new IllegalStateException("Chart configuration is not set");
        }

        component.activateResponsivePlugin();
        if (component.getChart().getResponsive() == null) {
            component.getChart().setResponsive(new Responsive());
        }

        component.getChart().getResponsive().setEnabled(responsive);
    }

    @Override
    public boolean isResponsive() {
        if (component.getChart() == null) {
            throw new IllegalStateException("Chart configuration is not set");
        }

        if (component.getChart().getResponsive() == null ||
                component.getChart().getResponsive().isEnabled() == null) {
            return false;
        }
        return component.getChart().getResponsive().isEnabled();
    }

    @Override
    public void setNativeJson(String json) {
        component.setJson(json);
    }

    @Override
    public String getNativeJson() {
        return component.getJson();
    }

    protected class CubaAmchartsSceneExt extends CubaAmchartsScene {

        private static final long serialVersionUID = 4357940484867437795L;

        @Override
        protected void setupDefaults(AbstractChart chart) {
            super.setupDefaults(chart);

            setupChartLocale(chart);

            if (chart instanceof RectangularChart) {
                setupRectangularChartDefaults((RectangularChart) chart);
            }
            if (chart instanceof AbstractSerialChart) {
                setupSerialChartDefaults((AbstractSerialChart) chart);
            }
        }

        protected void setupChartLocale(AbstractChart chart) {
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
                DecimalFormatSymbols formatSymbols = formatStrings.getFormatSymbols();

                if (chart.getPrecision() == null) {
                    chart.setPrecision(-1);
                }

                if (chart.getPercentPrecision() == null) {
                    chart.setPercentPrecision(2);
                }

                if (chart.getDecimalSeparator() == null) {
                    chart.setDecimalSeparator(Character.toString(formatSymbols.getDecimalSeparator()));
                }

                if (chart.getThousandsSeparator() == null) {
                    chart.setThousandsSeparator(Character.toString(formatSymbols.getGroupingSeparator()));
                }
            }

            // number prefixes
            if (BooleanUtils.isTrue(chart.getUsePrefixes())) {
                if (chart.getPrefixesOfBigNumbers() == null) {
                    List<BigNumberPrefix> prefixes = new LinkedList<>();
                    for (BigNumberPower power : BigNumberPower.values()) {
                        prefixes.add(new BigNumberPrefix(power,
                                messages.getMainMessage("amcharts.bigNumberPower." + power.name())));
                    }
                    chart.setPrefixesOfBigNumbers(prefixes);
                }
                if (chart.getPrefixesOfSmallNumbers() == null) {
                    List<SmallNumberPrefix> prefixes = new LinkedList<>();
                    for (SmallNumberPower power : SmallNumberPower.values()) {
                        prefixes.add(new SmallNumberPrefix(power,
                                messages.getMainMessage("amcharts.smallNumberPower." + power.name())));
                    }
                    chart.setPrefixesOfSmallNumbers(prefixes);
                }
            }
        }

        protected void setupRectangularChartDefaults(RectangularChart chart) {
            if (chart.getZoomOutText() == null) {
                chart.setZoomOutText(messages.getMainMessage("amcharts.zoomOutText"));
            }

            Cursor cursor = chart.getChartCursor();
            if (cursor != null) {
                if (StringUtils.isEmpty(cursor.getCategoryBalloonDateFormat())) {
                    String format = messages.getMainMessage("amcharts.rectangualrChart.categoryBalloonDateFormat");
                    cursor.setCategoryBalloonDateFormat(format);
                }
            }
        }

        protected void setupSerialChartDefaults(AbstractSerialChart chart) {
            boolean byDate = WebChart.this.byDate;

            if (datasource != null && StringUtils.isNotEmpty(chart.getCategoryField())) {
                MetaProperty property = datasource.getMetaClass().getProperty(chart.getCategoryField());
                if (property == null) {
                    throw new DevelopmentException(
                            String.format("Unable to find metaproperty '%s' for class '%s'", chart.getCategoryField(), datasource.getMetaClass()));
                }
                if (Date.class.isAssignableFrom(property.getJavaType())) {
                    byDate = true;
                }
            }

            CategoryAxis categoryAxis = chart.getCategoryAxis();
            if (categoryAxis == null) {
                categoryAxis = new CategoryAxis();
                chart.setCategoryAxis(categoryAxis);
            }

            if (byDate) {
                if (categoryAxis.getParseDates() == null) {
                    categoryAxis.setParseDates(true);
                }
            }

            String firstDayOfWeek = messages.getMainMessage("amcharts.firstDayOfWeek");
            if (categoryAxis.getFirstDayOfWeek() == null) {
                categoryAxis.setFirstDayOfWeek(DayOfWeek.valueOf(firstDayOfWeek));
            }

            if (StringUtils.isEmpty(chart.getDataDateFormat())) {
                chart.setDataDateFormat(ChartJsonSerializationContext.DEFAULT_JS_DATE_FORMAT);
            }

            if (StringUtils.isEmpty(chart.getBalloonDateFormat())) {
                String format = messages.getMainMessage("amcharts.serialChart.balloonDateFormat");
                chart.setBalloonDateFormat(format);
            }
        }
    }
}