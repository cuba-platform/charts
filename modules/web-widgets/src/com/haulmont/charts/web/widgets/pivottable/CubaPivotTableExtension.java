/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.web.widgets.pivottable;

import com.google.gson.Gson;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotData;
import com.haulmont.charts.gui.pivottable.model.Renderer;
import com.haulmont.charts.web.widgets.client.pivottable.extension.CubaPivotTableExtensionServerRpc;
import com.haulmont.charts.web.widgets.client.pivottable.extension.CubaPivotTableExtensionState;
import com.vaadin.server.AbstractExtension;

public class CubaPivotTableExtension extends AbstractExtension {

    public static final Gson gson = new Gson();

    protected CubaPivotTable pivotTable;

    protected String pivotDataJSON = null;

    protected Renderer currentRenderer;

    public CubaPivotTableExtension(CubaPivotTable pivotTable) {
        this.pivotTable = pivotTable;

        extend(this.pivotTable);

        CubaPivotTableExtensionServerRpc serverRpc = new CubaPivotTableExtensionServerRpc() {
            @Override
            public void updatePivotDataJSON(String json) {
                pivotDataJSON = json;
            }

            @Override
            public void updateCurrentRenderer(String renderer) {
                currentRenderer = Renderer.fromId(renderer);
            }
        };

        registerRpc(serverRpc);
    }

    public String getPivotDataJSON() {
        return pivotDataJSON;
    }

    public PivotData getPivotData() {
        return gson.fromJson(pivotDataJSON, PivotData.class);
    }

    @Override
    protected CubaPivotTableExtensionState getState() {
        return (CubaPivotTableExtensionState) super.getState();
    }

    @Override
    protected CubaPivotTableExtensionState getState(boolean markAsDirty) {
        return (CubaPivotTableExtensionState) super.getState(markAsDirty);
    }

    public Renderer getCurrentRenderer() {
        return currentRenderer;
    }

    public String getDateTimeParseFormat() {
        return getState(false).dateTimeParseFormat;
    }

    public void setDateTimeParseFormat(String dateTimeParseFormat) {
        getState().dateTimeParseFormat = dateTimeParseFormat;
    }

    public String getDateParseFormat() {
        return getState(false).dateParseFormat;
    }

    public String setDateParseFormat(String dateParseFormat) {
        return getState().dateParseFormat = dateParseFormat;
    }

    public String getTimeParseFormat() {
        return getState(false).timeParseFormat;
    }

    public String setTimeParseFormat(String timeParseFormat) {
        return getState().timeParseFormat = timeParseFormat;
    }
}