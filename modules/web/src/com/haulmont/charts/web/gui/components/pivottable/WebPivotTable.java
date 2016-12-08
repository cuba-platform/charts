/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.pivottable;

import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.pivottable.model.*;
import com.haulmont.charts.gui.pivottable.model.data.EntityPivotDataProvider;
import com.haulmont.charts.gui.pivottable.model.data.PivotDataItem;
import com.haulmont.charts.gui.pivottable.model.data.PivotDataProvider;
import com.haulmont.charts.web.gui.PivotTableLocaleHelper;
import com.haulmont.charts.web.toolkit.ui.pivottable.CubaPivotTableScene;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.impl.CollectionDsHelper;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import org.apache.commons.lang.ObjectUtils;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@SuppressWarnings("WeakerAccess")
public class WebPivotTable extends WebAbstractComponent<CubaPivotTableScene> implements PivotTable {

    protected Messages messages = AppBeans.get(Messages.class);

    protected Metadata metadata = AppBeans.get(Metadata.class);

    protected UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);

    protected CollectionDatasource datasource;

    protected com.haulmont.charts.web.toolkit.ui.pivottable.events.RefreshListener refreshHandler;

    public WebPivotTable() {
        component = new CubaPivotTableSceneExt();
        initLocale();
    }

    private void initLocale() {
        Locale locale = userSessionSource.getLocale();

        if (!ObjectUtils.equals(userSessionSource.getLocale(), component.getLocale())) {
            String localeString = messages.getTools().localeToString(locale);
            component.setPivotTableMessages(localeString, PivotTableLocaleHelper.getPivotTableLocaleMap(locale));

            component.setLocale(locale);
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

        if (component.getPivotTable() != null) {
            component.getPivotTable().setDataProvider(new EntityPivotDataProvider(datasource));
        }
    }

    @Override
    public void repaint() {
        component.drawPivotTable();
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
    public PivotDataProvider getDataProvider() {
        return component.getPivotTable().getDataProvider();
    }

    @Override
    public void setDataProvider(PivotDataProvider dataProvider) {
        component.getPivotTable().setDataProvider(dataProvider);
    }

    @Override
    public void addData(PivotDataItem... dataItems) {
        component.getPivotTable().addData(dataItems);
    }

    @Override
    public PivotJsFunction getFilterFunction() {
        return component.getPivotTable().getFilterFunction();
    }

    @Override
    public void setFilterFunction(PivotJsFunction filter) {
        component.getPivotTable().setFilterFunction(filter);
    }

    @Override
    public PivotJsFunction getSortersFunction() {
        return component.getPivotTable().getSortersFunction();
    }

    @Override
    public void setSortersFunction(PivotJsFunction sorters) {
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
    public void setNativeJson(String json) {
        component.setJson(json);
    }

    @Override
    public String getNativeJson() {
        return component.getJson();
    }

    @Override
    public void addRefreshListener(RefreshListener refreshListener) {
        if (refreshHandler == null) {
            refreshHandler = e -> {
                RefreshEvent event = new RefreshEvent(WebPivotTable.this);
                getEventRouter().fireEvent(RefreshListener.class, RefreshListener::onRefresh, event);
            };
            component.addRefreshListener(refreshHandler);
        }
        getEventRouter().addListener(RefreshListener.class, refreshListener);
    }

    @Override
    public void removeRefreshListener(RefreshListener refreshListener) {
        getEventRouter().removeListener(RefreshListener.class, refreshListener);
    }

    protected class CubaPivotTableSceneExt extends CubaPivotTableScene {

        private static final long serialVersionUID = 4458537600231552573L;

        @Override
        protected void setupDefaults(PivotTableModel pivotTable) {
            super.setupDefaults(pivotTable);

            pivotTable.setLocaleCode(messages.getTools().localeToString(userSessionSource.getLocale()));
        }
    }
}
