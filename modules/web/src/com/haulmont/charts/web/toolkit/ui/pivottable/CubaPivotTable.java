/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.pivottable;

import com.google.gson.*;
import com.haulmont.charts.gui.pivottable.model.*;
import com.haulmont.charts.web.toolkit.ui.client.pivottable.CubaPivotTableSceneState;
import com.haulmont.charts.web.toolkit.ui.client.pivottable.CubaPivotTableServerRpc;
import com.haulmont.charts.web.toolkit.ui.pivottable.events.CellClickEvent;
import com.haulmont.charts.web.toolkit.ui.pivottable.events.CellClickListener;
import com.haulmont.charts.web.toolkit.ui.pivottable.events.RefreshEvent;
import com.haulmont.charts.web.toolkit.ui.pivottable.events.RefreshListener;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.web.widgets.WebJarResource;
import com.vaadin.ui.AbstractComponent;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.vaadin.util.ReflectTools.findMethod;

@WebJarResource({
        "jquery-ui:jquery-ui.min.js",
        "pivottable:pivot.min.js",
        "pivottable:tips_data.min.js",
        "pivottable:plugins/d3/d3.min.js",
        "pivottable:plugins/c3/c3.min.js",
        "pivottable:c3_renderers.min.js",
        "pivottable:d3_renderers.min.js",
        "pivottable:export_renderers.min.js",
        "pivottable:pivot.min.css",
        "pivottable:plugins/c3/c3.min.css"
})
public class CubaPivotTable extends AbstractComponent {
    private static final long serialVersionUID = 3250758720037122580L;

    private static final Logger log = LoggerFactory.getLogger(CubaPivotTable.class);

    protected static final Method refreshMethod =
            findMethod(RefreshListener.class, "onRefresh", RefreshEvent.class);

    protected static final Method cellClickMethod =
            findMethod(CellClickListener.class, "onCellClick", CellClickEvent.class);

    protected boolean dirty = false;

    protected PivotTableModel pivotTable;

    protected Locale locale;

    public CubaPivotTable() {
        pivotTable = new PivotTableModel();
        registerRpc(new CubaPivotTableServerRpcImpl(), CubaPivotTableServerRpc.class);

        addRefreshListener(event -> {
            pivotTable.setRows(event.getRows());
            pivotTable.setCols(event.getCols());

            if (pivotTable.getRenderers() == null) {
                pivotTable.setRenderers(new Renderers());
            }
            pivotTable.getRenderers().setDefaultRenderer(event.getRenderer());

            pivotTable.setInclusions(event.getInclusions());
            pivotTable.setExclusions(event.getExclusions());

            pivotTable.setColumnOrder(event.getColumnOrder());
            pivotTable.setRowOrder(event.getRowOrder());

            Aggregation aggregation = event.getAggregation();
            boolean hasMode = aggregation != null && !Boolean.TRUE.equals(aggregation.getCustom());
            if (pivotTable.getAggregations() == null) {
                pivotTable.setAggregations(new Aggregations());
            }
            pivotTable.getAggregations().setDefaultAggregation(hasMode ? aggregation.getMode() : null);
            if (aggregation != null && Boolean.TRUE.equals(aggregation.getCustom())) {
                // Due to impossibility to set a custom aggregation as the default
                // we need to set a custom aggregation as the first one and clear
                // the default aggregation value, so it will be set as the default by pivot.js
                pivotTable.getAggregations().getAggregations().remove(aggregation);
                pivotTable.getAggregations().getAggregations().add(0, aggregation);
            }

            pivotTable.setAggregationProperties(event.getAggregationProperties());
        });
    }

    @Override
    protected CubaPivotTableSceneState getState() {
        return (CubaPivotTableSceneState) super.getState();
    }

    @Override
    protected CubaPivotTableSceneState getState(boolean markAsDirty) {
        return (CubaPivotTableSceneState) super.getState(markAsDirty);
    }

    public PivotTableModel getPivotTable() {
        return pivotTable;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setJson(String json) {
        if (!StringUtils.equals(getJson(), json)) {
            if (json != null) {
                try {
                    JsonParser parser = new JsonParser();
                    parser.parse(json);
                } catch (JsonSyntaxException e) {
                    throw new IllegalStateException("Unable to parse JSON chart configuration");
                }
            }

            getState().json = json;
            forceStateChange();
        }
    }

    public String getJson() {
        return getState(false).json;
    }

    public void repaint() {
        forceStateChange();
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);

        if (initial || isDirty()) {
            if (pivotTable != null) {
                // Full repaint

                String dataJsonSting = pivotTable.dataToString();
                log.trace("pivotTable data JSON:\n{}", dataJsonSting);
                getState().data = dataJsonSting;

                String optionsJsonString = pivotTable.toString();
                log.trace("pivotTable options JSON:\n{}", optionsJsonString);
                getState().options = optionsJsonString;
            }

            dirty = false;
        }
    }

    protected void forceStateChange() {
        this.dirty = true;
        getState(true);
    }

    public void addRefreshListener(RefreshListener listener) {
        addListener(CubaPivotTableSceneState.REFRESH_EVENT, RefreshEvent.class, listener, refreshMethod);
    }

    public void removeRefreshListener(RefreshListener listener) {
        removeListener(CubaPivotTableSceneState.REFRESH_EVENT, RefreshEvent.class, listener);
    }

    public void addCellClickListener(CellClickListener listener) {
        addListener(CubaPivotTableSceneState.CELL_CLICK_EVENT, CellClickEvent.class, listener, cellClickMethod);
    }

    public void removeCellClickListener(CellClickListener listener) {
        removeListener(CubaPivotTableSceneState.CELL_CLICK_EVENT, CellClickEvent.class, listener);
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public void setLocale(Locale locale) {
        this.locale = locale;
        Messages messages = AppBeans.get(Messages.class);
        pivotTable.setLocaleCode(messages.getTools().localeToString(locale));
    }

    protected JsonObject convertMapToJsonObject(Map<String, String> localeMap) {
        JsonObject jsonLocaleMap = new JsonObject();
        for (Map.Entry<String, String> localeEntry : localeMap.entrySet()) {
            jsonLocaleMap.addProperty(localeEntry.getKey(), localeEntry.getValue());
        }

        return jsonLocaleMap;
    }

    public void setPivotTableMessages(String localeCode, Map<String, Object> localeMap) {
        if (getState(false).localeMap == null) {
            getState().localeMap = new HashMap<>();
        }

        JsonObject jsonLocaleMap = new JsonObject();
        for (Map.Entry<String, Object> localeEntry : localeMap.entrySet()) {
            JsonElement element;
            if (localeEntry.getValue() instanceof Map) {
                //noinspection unchecked
                element = convertMapToJsonObject((Map<String, String>) localeEntry.getValue());
            } else {
                element = new JsonPrimitive((String) localeEntry.getValue());
            }
            jsonLocaleMap.add(localeEntry.getKey(), element);
        }

        getState().localeMap.put(localeCode, AbstractPivotObject.getSharedGson().toJson(localeMap));
    }

    public String getEmptyDataMessage() {
        return getState(false).emptyDataMessage;
    }

    public void setEmptyDataMessage(String emptyDataMessage) {
        getState().emptyDataMessage = emptyDataMessage;
    }

    protected class CubaPivotTableServerRpcImpl implements CubaPivotTableServerRpc {

        private static final long serialVersionUID = 4789102026045383363L;

        @Override
        public void onCellClick(Double value, Map<String, String> filters) {
            fireEvent(new CellClickEvent(CubaPivotTable.this, value, filters));
        }

        @Override
        public void onRefresh(List<String> rows, List<String> cols, String rendererId,
                              String aggregationId, List<String> aggregationProperties,
                              Map<String, List<String>> inclusions, Map<String, List<String>> exclusions,
                              String colOrderId, String rowOrderId) {
            if (!pivotTable.getEditable()) {
                return;
            }

            Renderer renderer = Renderer.fromId(rendererId);
            Aggregation aggregation = findAggregation(aggregationId);

            ColumnOrder columnOrder = ColumnOrder.fromId(colOrderId);
            RowOrder rowOrder = RowOrder.fromId(rowOrderId);

            fireEvent(new RefreshEvent(CubaPivotTable.this,
                    rows, cols, renderer,
                    aggregation, aggregationProperties,
                    inclusions, exclusions, columnOrder, rowOrder));
        }

        @Nullable
        private Aggregation findAggregation(String aggregationId) {
            if (pivotTable.getAggregations() != null
                    && pivotTable.getAggregations().getAggregations() != null) {
                for (Aggregation aggregation : pivotTable.getAggregations().getAggregations()) {
                    if (aggregation.getId().equals(aggregationId)) {
                        return aggregation;
                    }
                }
            } else {
                AggregationMode mode = AggregationMode.fromId(aggregationId);
                return new Aggregation().setMode(mode);
            }
            return null;
        }
    }
}
