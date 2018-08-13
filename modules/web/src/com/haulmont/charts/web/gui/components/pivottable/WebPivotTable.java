/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.pivottable;

import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.data.EntityDataProvider;
import com.haulmont.charts.gui.model.JsFunction;
import com.haulmont.charts.gui.pivottable.model.*;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.web.gui.PivotTableLocaleHelper;
import com.haulmont.charts.web.gui.serialization.CubaPivotTableSerializer;
import com.haulmont.charts.web.widgets.pivottable.CubaPivotTable;
import com.haulmont.charts.web.widgets.pivottable.serialization.PivotTableSerializer;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.impl.CollectionDsHelper;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import org.springframework.beans.factory.InitializingBean;

import javax.inject.Inject;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class WebPivotTable extends WebAbstractComponent<CubaPivotTable> implements PivotTable, InitializingBean {

    protected CollectionDatasource datasource;

    protected com.haulmont.charts.web.widgets.pivottable.events.RefreshListener refreshHandler;
    protected com.haulmont.charts.web.widgets.pivottable.events.CellClickListener cellClickHandler;

    protected Messages messages;

    public WebPivotTable() {
        component = createComponent();
    }

    protected CubaPivotTable createComponent() {
        return new CubaPivotTable(createPivotTableSerializer());
    }

    protected PivotTableSerializer createPivotTableSerializer() {
        return AppBeans.getPrototype(CubaPivotTableSerializer.NAME);
    }

    @Inject
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initLocale();
    }

    protected void initLocale() {
        UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);
        Locale locale = userSessionSource.getLocale();
        String localeString = messages.getTools().localeToString(locale);

        if (!Objects.equals(localeString, component.getLocaleString())) {
            component.setPivotTableMessages(localeString, PivotTableLocaleHelper.getPivotTableLocaleMap(locale));
            component.setLocaleString(localeString);
            component.setEmptyDataMessage(messages.getMainMessage("pivottable.emptyDataMessage", locale));
        }
    }

    @Override
    public CollectionDatasource getDatasource() {
        return datasource;
    }

    @Override
    public void setDatasource(CollectionDatasource datasource) {
        this.datasource = datasource;

        if (datasource == null) {
            component.getPivotTable().setDataProvider(null);
        } else {
            CollectionDsHelper.autoRefreshInvalid(datasource, true);
        }

        setDataProvider(new EntityDataProvider(datasource));
    }

    @Override
    public void repaint() {
        component.repaint();
    }

    @Override
    public boolean isEditable() {
        return component.getPivotTable().getEditable();
    }

    @Override
    public void setEditable(boolean editable) {
        component.getPivotTable().setEditable(editable);
    }

    @Override
    public Map<String, String> getProperties() {
        return component.getPivotTable().getProperties();
    }

    @Override
    public void setProperties(Map<String, String> properties) {
        component.getPivotTable().setProperties(properties);
    }

    @Override
    public void addProperties(Map<String, String> properties) {
        component.getPivotTable().addProperties(properties);
    }

    @Override
    public void addProperty(String property, String value) {
        component.getPivotTable().addProperty(property, value);
    }

    @Override
    public List<String> getRows() {
        return component.getPivotTable().getRows();
    }

    @Override
    public void setRows(List<String> rows) {
        component.getPivotTable().setRows(rows);
    }

    @Override
    public void addRows(String... rows) {
        component.getPivotTable().addRows(rows);
    }

    @Override
    public List<String> getColumns() {
        return component.getPivotTable().getCols();
    }

    @Override
    public void setColumns(List<String> cols) {
        component.getPivotTable().setCols(cols);
    }

    @Override
    public void addColumns(String... cols) {
        component.getPivotTable().addCols(cols);
    }

    @Override
    public Aggregation getAggregation() {
        return component.getPivotTable().getAggregation();
    }

    @Override
    public void setAggregation(Aggregation aggregation) {
        component.getPivotTable().setAggregation(aggregation);
    }

    @Override
    public Renderer getRenderer() {
        return component.getPivotTable().getRenderer();
    }

    @Override
    public void setRenderer(Renderer renderer) {
        component.getPivotTable().setRenderer(renderer);
    }

    @Override
    public List<String> getAggregationProperties() {
        return component.getPivotTable().getAggregationProperties();
    }

    @Override
    public void setAggregationProperties(List<String> aggregationProperties) {
        component.getPivotTable().setAggregationProperties(aggregationProperties);
    }

    @Override
    public void addAggregationProperties(String... aggregationProperties) {
        component.getPivotTable().addAggregationProperties(aggregationProperties);
    }

    @Override
    public Aggregations getAggregations() {
        return component.getPivotTable().getAggregations();
    }

    @Override
    public void setAggregations(Aggregations aggregations) {
        component.getPivotTable().setAggregations(aggregations);
    }

    @Override
    public Renderers getRenderers() {
        return component.getPivotTable().getRenderers();
    }

    @Override
    public void setRenderers(Renderers renderers) {
        component.getPivotTable().setRenderers(renderers);
    }

    @Override
    public List<String> getHiddenProperties() {
        return component.getPivotTable().getHiddenProperties();
    }

    @Override
    public void setHiddenProperties(List<String> hiddenProperties) {
        component.getPivotTable().setHiddenProperties(hiddenProperties);
    }

    @Override
    public void addHiddenProperties(String... hiddenProperties) {
        component.getPivotTable().addHiddenProperties(hiddenProperties);
    }

    @Override
    public List<String> getHiddenFromAggregations() {
        return component.getPivotTable().getHiddenFromAggregations();
    }

    @Override
    public void setHiddenFromAggregations(List<String> hiddenFromAggregations) {
        component.getPivotTable().setHiddenFromAggregations(hiddenFromAggregations);
    }

    @Override
    public void addHiddenFromAggregations(String... hiddenFromAggregations) {
        component.getPivotTable().addHiddenFromAggregations(hiddenFromAggregations);
    }

    @Override
    public List<String> getHiddenFromDragDrop() {
        return component.getPivotTable().getHiddenFromDragDrop();
    }

    @Override
    public void setHiddenFromDragDrop(List<String> hiddenFromDragDrop) {
        component.getPivotTable().setHiddenFromDragDrop(hiddenFromDragDrop);
    }

    @Override
    public void addHiddenFromDragDrop(String... hiddenFromDragDrop) {
        component.getPivotTable().addHiddenFromDragDrop(hiddenFromDragDrop);
    }

    @Override
    public ColumnOrder getColumnOrder() {
        return component.getPivotTable().getColumnOrder();
    }

    @Override
    public void setColumnOrder(ColumnOrder columnOrder) {
        component.getPivotTable().setColumnOrder(columnOrder);
    }

    @Override
    public RowOrder getRowOrder() {
        return component.getPivotTable().getRowOrder();
    }

    @Override
    public void setRowOrder(RowOrder rowOrder) {
        component.getPivotTable().setRowOrder(rowOrder);
    }

    @Override
    public Integer getMenuLimit() {
        return component.getPivotTable().getMenuLimit();
    }

    @Override
    public void setMenuLimit(Integer menuLimit) {
        component.getPivotTable().setMenuLimit(menuLimit);
    }

    @Override
    public Boolean getAutoSortUnusedProperties() {
        return component.getPivotTable().getAutoSortUnusedProperties();
    }

    @Override
    public void setAutoSortUnusedProperties(Boolean autoSortUnusedProperties) {
        component.getPivotTable().setAutoSortUnusedProperties(autoSortUnusedProperties);
    }

    @Override
    public UnusedPropertiesVertical getUnusedPropertiesVertical() {
        return component.getPivotTable().getUnusedPropertiesVertical();
    }

    @Override
    public void setUnusedPropertiesVertical(UnusedPropertiesVertical unusedPropertiesVertical) {
        component.getPivotTable().setUnusedPropertiesVertical(unusedPropertiesVertical);
    }

    @Override
    public DataProvider getDataProvider() {
        return component.getPivotTable().getDataProvider();
    }

    @Override
    public void setDataProvider(DataProvider dataProvider) {
        component.getPivotTable().setDataProvider(dataProvider);
        dataProvider.addChangeListener(e -> {
            if (!isEditable()) {
                repaint();
            }
        });
    }

    @Override
    public void addData(DataItem... dataItems) {
        component.getPivotTable().addData(dataItems);
    }

    @Override
    public JsFunction getFilterFunction() {
        return component.getPivotTable().getFilterFunction();
    }

    @Override
    public void setFilterFunction(JsFunction filter) {
        component.getPivotTable().setFilterFunction(filter);
    }

    @Override
    public JsFunction getSortersFunction() {
        return component.getPivotTable().getSortersFunction();
    }

    @Override
    public void setSortersFunction(JsFunction sorters) {
        component.getPivotTable().setSortersFunction(sorters);
    }

    @Override
    public RendererOptions getRendererOptions() {
        return component.getPivotTable().getRendererOptions();
    }

    @Override
    public void setRendererOptions(RendererOptions rendererOptions) {
        component.getPivotTable().setRendererOptions(rendererOptions);
    }

    @Override
    public Map<String, List<String>> getInclusions() {
        return component.getPivotTable().getInclusions();
    }

    @Override
    public void setInclusions(Map<String, List<String>> inclusions) {
        component.getPivotTable().setInclusions(inclusions);
    }

    @Override
    public void setInclusions(String property, List<String> inclusions) {
        component.getPivotTable().setInclusions(property, inclusions);
    }

    @Override
    public void addInclusions(String property, String... inclusions) {
        component.getPivotTable().addInclusions(property, inclusions);
    }

    @Override
    public Map<String, List<String>> getExclusions() {
        return component.getPivotTable().getExclusions();
    }

    @Override
    public void setExclusions(Map<String, List<String>> exclusions) {
        component.getPivotTable().setExclusions(exclusions);
    }

    @Override
    public void setExclusions(String property, List<String> exclusions) {
        component.getPivotTable().setExclusions(property, exclusions);
    }

    @Override
    public void addExclusions(String property, String... exclusions) {
        component.getPivotTable().addExclusions(property, exclusions);
    }

    @Override
    public DerivedProperties getDerivedProperties() {
        return component.getPivotTable().getDerivedProperties();
    }

    @Override
    public void setDerivedProperties(DerivedProperties derivedProperties) {
        component.getPivotTable().setDerivedProperties(derivedProperties);
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
    public String getEmptyDataMessage() {
        return component.getEmptyDataMessage();
    }

    @Override
    public void setEmptyDataMessage(String emptyDataMessage) {
        component.setEmptyDataMessage(emptyDataMessage);
    }

    @Override
    public void addRefreshListener(RefreshListener refreshListener) {
        getEventRouter().addListener(RefreshListener.class, refreshListener);
        if (refreshHandler == null) {
            refreshHandler = e -> {
                RefreshEvent event = new RefreshEvent(WebPivotTable.this,
                        e.getRows(), e.getCols(), e.getRenderer(),
                        e.getAggregation(), e.getAggregationProperties(),
                        e.getInclusions(), e.getExclusions(),
                        e.getColumnOrder(), e.getRowOrder());

                getEventRouter().fireEvent(RefreshListener.class, RefreshListener::onRefresh, event);
            };
            component.addRefreshListener(refreshHandler);
        }
    }

    @Override
    public void removeRefreshListener(RefreshListener refreshListener) {
        getEventRouter().removeListener(RefreshListener.class, refreshListener);
        if (refreshHandler != null && !getEventRouter().hasListeners(RefreshListener.class)) {
            component.removeRefreshListener(refreshHandler);
            refreshHandler = null;
        }
    }

    @Override
    public void addCellClickListener(CellClickListener listener) {
        getEventRouter().addListener(CellClickListener.class, listener);
        if (cellClickHandler == null) {
            cellClickHandler = e -> {
                CellClickEvent event = new CellClickEvent(WebPivotTable.this, e.getValue(), e.getFilters());
                getEventRouter().fireEvent(CellClickListener.class, CellClickListener::onCellClick, event);
            };
            component.addCellClickListener(cellClickHandler);
        }
    }

    @Override
    public void removeCellClickListener(CellClickListener listener) {
        getEventRouter().removeListener(CellClickListener.class, listener);
        if (cellClickHandler != null && !getEventRouter().hasListeners(CellClickListener.class)) {
            component.removeCellClickListener(cellClickHandler);
            cellClickHandler = null;
        }
    }
}