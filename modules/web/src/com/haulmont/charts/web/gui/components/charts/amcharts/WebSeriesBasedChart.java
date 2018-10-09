/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.CategoryAxis;
import com.haulmont.charts.gui.amcharts.model.DayOfWeek;
import com.haulmont.charts.gui.amcharts.model.Scrollbar;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractSerialChart;
import com.haulmont.charts.gui.data.HasMetaClass;
import com.haulmont.charts.web.widgets.amcharts.serialization.ChartJsonSerializationContext;
import com.haulmont.charts.gui.components.charts.SeriesBasedChart;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.core.global.DevelopmentException;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@SuppressWarnings("unchecked")
public abstract class WebSeriesBasedChart<T extends SeriesBasedChart, M extends AbstractSerialChart> extends WebRectangularChart<T, M>
        implements SeriesBasedChart<T> {

    protected com.haulmont.charts.web.widgets.amcharts.events.ZoomListener zoomHandler;

    protected com.haulmont.charts.web.widgets.amcharts.events.CategoryItemClickListener categoryItemClickHandler;

    @Override
    protected void setupDefaults(M chart) {
        super.setupDefaults(chart);

        setupSerialChartDefaults(chart);
    }

    protected void setupSerialChartDefaults(AbstractSerialChart chart) {
        chart.setDataDateFormat(ChartJsonSerializationContext.DEFAULT_JS_DATE_FORMAT);

        String format = messages.getMainMessage("amcharts.serialChart.balloonDateFormat");
        chart.setBalloonDateFormat(format);
    }

    @Override
    public void setDatasource(CollectionDatasource datasource) {
        super.setDatasource(datasource);

        detectDateBasedCategoryAxis();
    }

    protected void detectDateBasedCategoryAxis() {
        MetaClass metaClass = getDataProvider() instanceof HasMetaClass ?
                ((HasMetaClass) getDataProvider()).getMetaClass() : null;

        if (metaClass != null
                && StringUtils.isNotEmpty(getCategoryField())
                && getCategoryAxis() != null
                && getCategoryAxis().getParseDates() == null) {
            MetaProperty property = metaClass.getProperty(getCategoryField());
            if (property == null) {
                throw new DevelopmentException(
                        String.format("Unable to find metaproperty '%s' for class '%s'", getCategoryField(), metaClass));
            }
            if (Date.class.isAssignableFrom(property.getJavaType())) {
                getCategoryAxis().setParseDates(true);
            }
        }
    }

    @Override
    public CategoryAxis getCategoryAxis() {
        return getModel().getCategoryAxis();
    }

    @Override
    public T setCategoryAxis(CategoryAxis categoryAxis) {
        if (categoryAxis != null && categoryAxis.getFirstDayOfWeek() == null) {
            String firstDayOfWeek = messages.getMainMessage("amcharts.firstDayOfWeek");
            categoryAxis.setFirstDayOfWeek(DayOfWeek.valueOf(firstDayOfWeek));
        }

        getModel().setCategoryAxis(categoryAxis);
        detectDateBasedCategoryAxis();
        return (T) this;
    }

    @Override
    public String getCategoryField() {
        return getModel().getCategoryField();
    }

    @Override
    public T setCategoryField(String categoryField) {
        getModel().setCategoryField(categoryField);
        detectDateBasedCategoryAxis();
        return (T) this;
    }

    @Override
    public String getBalloonDateFormat() {
        return getModel().getBalloonDateFormat();
    }

    @Override
    public T setBalloonDateFormat(String balloonDateFormat) {
        getModel().setBalloonDateFormat(balloonDateFormat);
        return (T) this;
    }

    @Override
    public Integer getColumnSpacing3D() {
        return getModel().getColumnSpacing3D();
    }

    @Override
    public T setColumnSpacing3D(Integer columnSpacing3D) {
        getModel().setColumnSpacing3D(columnSpacing3D);
        return (T) this;
    }

    @Override
    public Integer getColumnSpacing() {
        return getModel().getColumnSpacing();
    }

    @Override
    public T setColumnSpacing(Integer columnSpacing) {
        getModel().setColumnSpacing(columnSpacing);
        return (T) this;
    }

    @Override
    public Double getColumnWidth() {
        return getModel().getColumnWidth();
    }

    @Override
    public T setColumnWidth(Double columnWidth) {
        getModel().setColumnWidth(columnWidth);
        return (T) this;
    }

    @Override
    public String getDataDateFormat() {
        return getModel().getDataDateFormat();
    }

    @Override
    public T setDataDateFormat(String dataDateFormat) {
        getModel().setDataDateFormat(dataDateFormat);
        return (T) this;
    }

    @Override
    public Integer getMaxSelectedSeries() {
        return getModel().getMaxSelectedSeries();
    }

    @Override
    public T setMaxSelectedSeries(Integer maxSelectedSeries) {
        getModel().setMaxSelectedSeries(maxSelectedSeries);
        return (T) this;
    }

    @Override
    public Long getMaxSelectedTime() {
        return getModel().getMaxSelectedTime();
    }

    @Override
    public T setMaxSelectedTime(Long maxSelectedTime) {
        getModel().setMaxSelectedTime(maxSelectedTime);
        return (T) this;
    }

    @Override
    public Long getMinSelectedTime() {
        return getModel().getMinSelectedTime();
    }

    @Override
    public T setMinSelectedTime(Long minSelectedTime) {
        getModel().setMinSelectedTime(minSelectedTime);
        return (T) this;
    }

    @Override
    public Boolean getMouseWheelScrollEnabled() {
        return getModel().getMouseWheelScrollEnabled();
    }

    @Override
    public T setMouseWheelScrollEnabled(Boolean mouseWheelScrollEnabled) {
        getModel().setMouseWheelScrollEnabled(mouseWheelScrollEnabled);
        return (T) this;
    }

    @Override
    public Boolean getRotate() {
        return getModel().getRotate();
    }

    @Override
    public T setRotate(Boolean rotate) {
        getModel().setRotate(rotate);
        return (T) this;
    }

    @Override
    public Boolean getZoomOutOnDataUpdate() {
        return getModel().getZoomOutOnDataUpdate();
    }

    @Override
    public T setZoomOutOnDataUpdate(Boolean zoomOutOnDataUpdate) {
        getModel().setZoomOutOnDataUpdate(zoomOutOnDataUpdate);
        return (T) this;
    }

    @Override
    public Boolean getMouseWheelZoomEnabled() {
        return getModel().getMouseWheelZoomEnabled();
    }

    @Override
    public T setMouseWheelZoomEnabled(Boolean mouseWheelZoomEnabled) {
        getModel().setMouseWheelZoomEnabled(mouseWheelZoomEnabled);
        return (T) this;
    }

    @Override
    public Scrollbar getValueScrollbar() {
        return getModel().getValueScrollbar();
    }

    @Override
    public T setValueScrollbar(Scrollbar valueScrollbar) {
        getModel().setValueScrollbar(valueScrollbar);
        return (T) this;
    }

    @Override
    public Boolean getSynchronizeGrid() {
        return getModel().getSynchronizeGrid();
    }

    @Override
    public T setSynchronizeGrid(Boolean synchronizeGrid) {
        getModel().setSynchronizeGrid(synchronizeGrid);
        return (T) this;
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
    public void addCategoryItemClickListener(CategoryItemClickListener listener) {
        getEventRouter().addListener(CategoryItemClickListener.class, listener);
        if (categoryItemClickHandler == null) {
            categoryItemClickHandler = e -> {
                CategoryItemClickEvent event = new CategoryItemClickEvent(e.getValue(), e.getX(), e.getY(),
                        e.getOffsetX(), e.getOffsetY(), e.getXAxis(), e.getYAxis());
                getEventRouter().fireEvent(CategoryItemClickListener.class, CategoryItemClickListener::onClick, event);
            };
            component.addCategoryItemClickListener(categoryItemClickHandler);
        }
    }

    @Override
    public void removeCategoryItemClickListener(CategoryItemClickListener listener) {
        getEventRouter().removeListener(CategoryItemClickListener.class, listener);
        if (categoryItemClickHandler != null && !getEventRouter().hasListeners(CategoryItemClickListener.class)) {
            component.removeCategoryItemClickListener(categoryItemClickHandler);
            categoryItemClickHandler = null;
        }
    }
}