/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.pivottable;

import com.google.gson.Gson;
import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotData;
import com.haulmont.charts.gui.pivottable.model.Renderer;
import com.haulmont.charts.web.toolkit.ui.client.pivottable.extension.CubaPivotTableExtensionServerRpc;
import com.vaadin.server.AbstractExtension;

public class CubaPivotTableExtension extends AbstractExtension {

    protected CubaPivotTable pivotTable;

    protected String pivotDataJSON = null;

    protected Renderer currentRenderer;

    protected Gson gson = new Gson();

    public CubaPivotTableExtension(PivotTable pivotTable) {
        this.pivotTable = pivotTable.unwrap(CubaPivotTable.class);

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