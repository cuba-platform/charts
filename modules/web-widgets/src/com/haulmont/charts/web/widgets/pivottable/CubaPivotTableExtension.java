/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.pivottable;

import com.google.gson.Gson;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotData;
import com.haulmont.charts.gui.pivottable.model.Renderer;
import com.haulmont.charts.web.widgets.client.pivottable.extension.CubaPivotTableExtensionServerRpc;
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

    public Renderer getCurrentRenderer() {
        return currentRenderer;
    }
}