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
import com.haulmont.charts.gui.amcharts.model.gson.ChartJsonSerializationContext;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.gui.data.EntityDataProvider;
import com.haulmont.charts.web.gui.ChartLocaleHelper;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsIntegration;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;
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

    protected CollectionDatasource datasource;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.AxisZoomListener axisZoomHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.ChartClickListener clickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.ChartRightClickListener rightClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.CursorPeriodSelectListener periodSelectHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.CursorZoomListener cursorZoomHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphClickListener graphClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphItemClickListener graphItemClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphItemRightClickListener graphItemRightClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendItemHideListener legendItemHideHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendItemShowListener legendItemShowHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendLabelClickListener legendLabelClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.LegendMarkerClickListener legendMarkerClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SliceClickListener sliceClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SliceRightClickListener sliceRightClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SlicePullInListener slicePullInHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SlicePullOutListener slicePullOutHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.ZoomListener zoomHandler;

    public WebChart() {
        initLocale();

        component = new CubaAmchartsSceneExt();
        component.addAttachListener(event -> {
            if (datasource != null) {
                CollectionDsHelper.autoRefreshInvalid(datasource, true);
            }
        });
    }

    protected void initLocale() {
        UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);
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
        Metadata metadata = AppBeans.get(Metadata.class);
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

                Metadata metadata = AppBeans.get(Metadata.class);
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
    public void addAxisZoomListener(AxisZoomListener listener) {
        getEventRouter().addListener(AxisZoomListener.class, listener);
        if (axisZoomHandler == null) {
            axisZoomHandler = e -> {
                AxisZoomEvent event = new AxisZoomEvent(e.getAxisId(), e.getStartValue(), e.getEndValue());
                getEventRouter().fireEvent(AxisZoomListener.class, AxisZoomListener::onZoom, event);
            };
            component.addAxisZoomListener(axisZoomHandler);
        }
    }

    @Override
    public void removeAxisZoomListener(AxisZoomListener listener) {
        getEventRouter().removeListener(AxisZoomListener.class, listener);
        if (axisZoomHandler != null && !getEventRouter().hasListeners(AxisZoomListener.class)) {
            component.removeAxisZoomListener(axisZoomHandler);
            axisZoomHandler = null;
        }
    }

    @Override
    public void addClickListener(ChartClickListener listener) {
        getEventRouter().addListener(ChartClickListener.class, listener);
        if (clickHandler == null) {
            clickHandler = e -> {
                ChartClickEvent event = new ChartClickEvent(e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY(),
                        e.getXAxis(), e.getYAxis());
                getEventRouter().fireEvent(ChartClickListener.class, ChartClickListener::onClick, event);
            };
            component.addChartClickListener(clickHandler);
        }
    }

    @Override
    public void removeClickListener(ChartClickListener listener) {
        getEventRouter().removeListener(ChartClickListener.class, listener);
        if (clickHandler != null && !getEventRouter().hasListeners(ChartClickListener.class)) {
            component.removeChartClickListener(clickHandler);
            clickHandler = null;
        }
    }

    @Override
    public void addRightClickListener(ChartRightClickListener listener) {
        getEventRouter().addListener(ChartRightClickListener.class, listener);
        rightClickHandler = e -> {
            ChartRightClickEvent event = new ChartRightClickEvent(e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY(),
                    e.getXAxis(), e.getYAxis());
            getEventRouter().fireEvent(ChartRightClickListener.class, ChartRightClickListener::onRightClick, event);
        };
        component.addChartRightClickListener(rightClickHandler);
    }

    @Override
    public void removeRightClickListener(ChartRightClickListener listener) {
        getEventRouter().removeListener(ChartRightClickListener.class, listener);
        if (rightClickHandler != null && !getEventRouter().hasListeners(ChartRightClickListener.class)) {
            component.removeChartRightClickListener(rightClickHandler);
            rightClickHandler = null;
        }
    }

    @Override
    public void addCursorPeriodSelectListener(CursorPeriodSelectListener listener) {
        getEventRouter().addListener(CursorPeriodSelectListener.class, listener);
        if (periodSelectHandler == null) {
            periodSelectHandler = e -> {
                CursorPeriodSelectEvent event = new CursorPeriodSelectEvent(e.getStart(), e.getEnd());
                getEventRouter().fireEvent(CursorPeriodSelectListener.class, CursorPeriodSelectListener::onSelect, event);
            };
            component.addCursorPeriodSelectListener(periodSelectHandler);
        }
    }

    @Override
    public void removeCursorPeriodSelectListener(CursorPeriodSelectListener listener) {
        getEventRouter().removeListener(CursorPeriodSelectListener.class, listener);
        if (periodSelectHandler != null && !getEventRouter().hasListeners(CursorPeriodSelectListener.class)) {
            component.removeCursorPeriodSelectListener(periodSelectHandler);
            periodSelectHandler = null;
        }
    }

    @Override
    public void addCursorZoomListener(CursorZoomListener listener) {
        getEventRouter().addListener(CursorZoomListener.class, listener);
        if (cursorZoomHandler == null) {
            cursorZoomHandler = e -> {
                CursorZoomEvent event = new CursorZoomEvent(e.getStart(), e.getEnd());
                getEventRouter().fireEvent(CursorZoomListener.class, CursorZoomListener::onZoom, event);
            };
            component.addCursorZoomListener(cursorZoomHandler);
        }
    }

    @Override
    public void removeCursorZoomListener(CursorZoomListener listener) {
        getEventRouter().removeListener(CursorZoomListener.class, listener);
        if (cursorZoomHandler != null && !getEventRouter().hasListeners(CursorZoomListener.class)) {
            component.removeCursorZoomListener(cursorZoomHandler);
            cursorZoomHandler = null;
        }
    }

    @Override
    public void addGraphClickListener(GraphClickListener listener) {
        getEventRouter().addListener(GraphClickListener.class, listener);
        if (graphClickHandler == null) {
            graphClickHandler = e -> {
                GraphClickEvent event = new GraphClickEvent(e.getGraphId(), e.getX(), e.getY(),
                        e.getAbsoluteX(), e.getAbsoluteY());
                getEventRouter().fireEvent(GraphClickListener.class, GraphClickListener::onClick, event);
            };
            component.addGraphClickListener(graphClickHandler);
        }
    }

    @Override
    public void removeGraphClickListener(GraphClickListener listener) {
        getEventRouter().removeListener(GraphClickListener.class, listener);
        if (graphClickHandler != null && !getEventRouter().hasListeners(GraphClickListener.class)) {
            component.removeGraphClickListener(graphClickHandler);
            graphClickHandler = null;
        }
    }

    @Override
    public void addGraphItemClickListener(GraphItemClickListener listener) {
        getEventRouter().addListener(GraphItemClickListener.class, listener);
        if (graphItemClickHandler == null) {
            graphItemClickHandler = e -> {
                GraphItemClickEvent event = new GraphItemClickEvent(e.getGraphId(), getEventItem(e.getItemId()),
                        e.getItemIndex(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
                getEventRouter().fireEvent(GraphItemClickListener.class, GraphItemClickListener::onClick, event);
            };
            component.addGraphItemClickListener(graphItemClickHandler);
        }
    }

    @Override
    public void removeGraphItemClickListener(GraphItemClickListener listener) {
        getEventRouter().removeListener(GraphItemClickListener.class, listener);
        if (graphItemClickHandler != null && !getEventRouter().hasListeners(GraphItemClickListener.class)) {
            component.removeGraphItemClickListener(graphItemClickHandler);
            graphItemClickHandler = null;
        }
    }

    @Override
    public void addGraphItemRightClickListener(GraphItemRightClickListener listener) {
        getEventRouter().addListener(GraphItemRightClickListener.class, listener);
        if (graphItemRightClickHandler == null) {
            graphItemRightClickHandler = e -> {
                GraphItemRightClickEvent event = new GraphItemRightClickEvent(e.getGraphId(), getEventItem(e.getItemId()),
                        e.getItemIndex(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
                getEventRouter().fireEvent(GraphItemRightClickListener.class, GraphItemRightClickListener::onRightClick, event);
            };
            component.addGraphItemRightClickListener(graphItemRightClickHandler);
        }
    }

    @Override
    public void removeGraphItemRightClickListener(GraphItemRightClickListener listener) {
        getEventRouter().removeListener(GraphItemRightClickListener.class, listener);
        if (graphItemRightClickHandler != null && !getEventRouter().hasListeners(GraphItemRightClickListener.class)) {
            component.removeGraphItemRightClickListener(graphItemRightClickHandler);
            graphItemRightClickHandler = null;
        }
    }

    @Override
    public void addLegendItemHideListener(LegendItemHideListener listener) {
        getEventRouter().addListener(LegendItemHideListener.class, listener);
        if (legendItemHideHandler == null) {
            legendItemHideHandler = e -> {
                LegendItemHideEvent event = new LegendItemHideEvent(getEventItem(e.getItemId()));
                getEventRouter().fireEvent(LegendItemHideListener.class, LegendItemHideListener::onHide, event);
            };
            component.addLegendItemHideListener(legendItemHideHandler);
        }
    }

    @Override
    public void removeLegendItemHideListener(LegendItemHideListener listener) {
        getEventRouter().removeListener(LegendItemHideListener.class, listener);
        if (legendItemHideHandler != null && !getEventRouter().hasListeners(LegendItemHideListener.class)) {
            component.removeLegendItemHideListener(legendItemHideHandler);
            legendItemHideHandler = null;
        }
    }

    @Override
    public void addLegendItemShowListener(LegendItemShowListener listener) {
        getEventRouter().addListener(LegendItemShowListener.class, listener);
        if (legendItemShowHandler == null) {
            legendItemShowHandler = e -> {
                LegendItemShowEvent event = new LegendItemShowEvent(getEventItem(e.getItemId()));
                getEventRouter().fireEvent(LegendItemShowListener.class, LegendItemShowListener::onShow, event);
            };
            component.addLegendItemShowListener(legendItemShowHandler);
        }
    }

    @Override
    public void removeLegendItemShowListener(LegendItemShowListener listener) {
        getEventRouter().removeListener(LegendItemShowListener.class, listener);
        if (legendItemShowHandler != null && !getEventRouter().hasListeners(LegendItemShowListener.class)) {
            component.removeLegendItemShowListener(legendItemShowHandler);
            legendItemShowHandler = null;
        }
    }

    @Override
    public void addLegendLabelClickListener(LegendItemClickListener listener) {
        getEventRouter().addListener(LegendItemClickListener.class, listener);
        if (legendLabelClickHandler == null) {
            legendLabelClickHandler = e -> {
                LegendItemClickEvent event = new LegendItemClickEvent(getEventItem(e.getItemId()));
                getEventRouter().fireEvent(LegendItemClickListener.class, LegendItemClickListener::onClick, event);
            };
            component.addLegendLabelClickListener(legendLabelClickHandler);
        }
    }

    @Override
    public void removeLegendLabelClickListener(LegendItemClickListener listener) {
        getEventRouter().removeListener(LegendItemClickListener.class, listener);
        if (legendLabelClickHandler != null && !getEventRouter().hasListeners(LegendItemClickListener.class)) {
            component.removeLegendLabelClickListener(legendLabelClickHandler);
            legendLabelClickHandler = null;
        }
    }

    @Override
    public void addLegendMarkerClickListener(LegendMarkerClickListener listener) {
        getEventRouter().addListener(LegendMarkerClickListener.class, listener);
        if (legendMarkerClickHandler == null) {
            legendMarkerClickHandler = e -> {
                LegendMarkerClickEvent event = new LegendMarkerClickEvent(getEventItem(e.getItemId()));
                getEventRouter().fireEvent(LegendMarkerClickListener.class, LegendMarkerClickListener::onMarkerClick, event);
            };
            component.addLegendMarkerClickListener(legendMarkerClickHandler);
        }
    }

    @Override
    public void removeLegendMarkerClickListener(LegendMarkerClickListener listener) {
        getEventRouter().removeListener(LegendMarkerClickListener.class, listener);
        if (legendMarkerClickHandler != null && !getEventRouter().hasListeners(LegendMarkerClickListener.class)) {
            component.removeLegendMarkerClickListener(legendMarkerClickHandler);
            legendMarkerClickHandler = null;
        }
    }

    @Override
    public void addSliceClickListener(SliceClickListener listener) {
        getEventRouter().addListener(SliceClickListener.class, listener);
        if (sliceClickHandler == null) {
            sliceClickHandler = e -> {
                SliceClickEvent event = new SliceClickEvent(getEventItem(e.getSliceId()), e.getX(), e.getY(),
                        e.getAbsoluteX(), e.getAbsoluteY());
                getEventRouter().fireEvent(SliceClickListener.class, SliceClickListener::onClick, event);
            };
            component.addSliceClickListener(sliceClickHandler);
        }
    }

    @Override
    public void removeSliceClickListener(SliceClickListener listener) {
        getEventRouter().removeListener(SliceClickListener.class, listener);
        if (sliceClickHandler != null && !getEventRouter().hasListeners(SliceClickListener.class)) {
            component.removeSliceClickListener(sliceClickHandler);
            sliceClickHandler = null;
        }
    }

    @Override
    public void addSliceRightClickListener(SliceRightClickListener listener) {
        getEventRouter().addListener(SliceRightClickListener.class, listener);
        if (sliceRightClickHandler == null) {
            sliceRightClickHandler = e -> {
                SliceRightClickEvent event = new SliceRightClickEvent(getEventItem(e.getSliceId()), e.getX(), e.getY(),
                        e.getAbsoluteX(), e.getAbsoluteY());
                getEventRouter().fireEvent(SliceRightClickListener.class, SliceRightClickListener::onRightClick, event);
            };
            component.addSliceRightClickListener(sliceRightClickHandler);
        }
    }

    @Override
    public void removeSliceRightClickListener(SliceRightClickListener listener) {
        getEventRouter().removeListener(SliceRightClickListener.class, listener);
        if (sliceRightClickHandler != null && !getEventRouter().hasListeners(SliceRightClickListener.class)) {
            component.removeSliceRightClickListener(sliceRightClickHandler);
            sliceRightClickHandler = null;
        }
    }

    @Override
    public void addSlicePullInListener(SlicePullInListener listener) {
        getEventRouter().addListener(SlicePullInListener.class, listener);
        if (slicePullInHandler == null) {
            slicePullInHandler = e -> {
                SlicePullInEvent event = new SlicePullInEvent(getEventItem(e.getSliceId()));
                getEventRouter().fireEvent(SlicePullInListener.class, SlicePullInListener::onPullIn, event);
            };
            component.addSlicePullInListener(slicePullInHandler);
        }
    }

    @Override
    public void removeSlicePullInListener(SlicePullInListener listener) {
        getEventRouter().removeListener(SlicePullInListener.class, listener);
        if (slicePullInHandler != null && !getEventRouter().hasListeners(SlicePullInListener.class)) {
            component.removeSlicePullInListener(slicePullInHandler);
            slicePullInHandler = null;
        }
    }

    @Override
    public void addSlicePullOutListener(SlicePullOutListener listener) {
        getEventRouter().addListener(SlicePullOutListener.class, listener);
        if (slicePullOutHandler == null) {
            slicePullOutHandler = e -> {
                SlicePullOutEvent event = new SlicePullOutEvent(getEventItem(e.getSliceId()));
                getEventRouter().fireEvent(SlicePullOutListener.class, SlicePullOutListener::onPullOut, event);
            };
            component.addSlicePullOutListener(slicePullOutHandler);
        }
    }

    @Override
    public void removeSlicePullOutListener(SlicePullOutListener listener) {
        getEventRouter().removeListener(SlicePullOutListener.class, listener);
        if (slicePullOutHandler != null && !getEventRouter().hasListeners(SlicePullOutListener.class)) {
            component.removeSlicePullOutListener(slicePullOutHandler);
            slicePullOutHandler = null;
        }
    }

    @Override
    public void addZoomListener(ZoomListener listener) {
        getEventRouter().addListener(ZoomListener.class, listener);
        if (zoomHandler == null) {
            zoomHandler = e -> {
                ZoomEvent event = new ZoomEvent(e.getStartIndex(), e.getEndIndex(), e.getStartDate(), e.getEndDate(),
                        e.getStartValue(), e.getEndValue());
                getEventRouter().fireEvent(ZoomListener.class, ZoomListener::onZoom, event);
            };
            component.addZoomListener(zoomHandler);
        }
    }

    @Override
    public void removeZoomListener(ZoomListener listener) {
        getEventRouter().removeListener(ZoomListener.class, listener);
        if (zoomHandler != null && !getEventRouter().hasListeners(ZoomListener.class)) {
            component.removeZoomListener(zoomHandler);
            zoomHandler = null;
        }
    }

    @Override
    public void setResponsive(boolean responsive) {
        super.setResponsive(responsive);

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
        return super.isResponsive();
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
            UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);
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
                    String format = messages.getMainMessage("amcharts.rectangularChart.categoryBalloonDateFormat");
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