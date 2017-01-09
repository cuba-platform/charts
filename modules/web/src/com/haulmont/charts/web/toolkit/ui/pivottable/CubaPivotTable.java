/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.pivottable;

import com.google.gson.*;
import com.haulmont.charts.gui.pivottable.model.AbstractPivotObject;
import com.haulmont.charts.gui.pivottable.model.PivotTableModel;
import com.haulmont.charts.web.toolkit.ui.client.pivottable.CubaPivotTableSceneState;
import com.haulmont.charts.web.toolkit.ui.client.pivottable.CubaPivotTableServerRpc;
import com.haulmont.charts.web.toolkit.ui.pivottable.events.RefreshEvent;
import com.haulmont.charts.web.toolkit.ui.pivottable.events.RefreshListener;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractComponent;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.vaadin.util.ReflectTools.findMethod;

@JavaScript({
        "vaadin://resources/jquery/jquery-ui.min.js",
        "vaadin://resources/pivottable/pivot.min.js",
        "vaadin://resources/pivottable/tips_data.min.js",
        "vaadin://resources/pivottable/plugins/d3/d3.min.js",
        "vaadin://resources/pivottable/plugins/c3/c3.min.js",
        "vaadin://resources/pivottable/c3_renderers.min.js",
        "vaadin://resources/pivottable/d3_renderers.min.js",
        "vaadin://resources/pivottable/export_renderers.min.js"
})
@StyleSheet({
        "vaadin://resources/pivottable/pivot.min.css",
        "vaadin://resources/pivottable/plugins/c3/c3.min.css"
})
public class CubaPivotTable extends AbstractComponent {
    private static final long serialVersionUID = 3250758720037122580L;

    private final Logger log = LoggerFactory.getLogger(CubaPivotTable.class);

    protected static final Method refreshMethod =
            findMethod(RefreshListener.class, "onRefresh", RefreshEvent.class);

    protected boolean dirty = false;

    protected PivotTableModel pivotTable;

    protected Locale locale;

    public CubaPivotTable() {
        pivotTable = new PivotTableModel();
        registerRpc(new CubaPivotTableServerRpcImpl(), CubaPivotTableServerRpc.class);
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

    protected class CubaPivotTableServerRpcImpl implements CubaPivotTableServerRpc {

        private static final long serialVersionUID = 4789102026045383363L;

        @Override
        public void onRefresh() {
            fireEvent(new RefreshEvent(CubaPivotTable.this));
        }
    }
}
