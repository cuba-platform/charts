/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.pivottable.extension;

import com.haulmont.charts.web.widgets.client.pivottable.CubaPivotTableSceneWidget;
import com.haulmont.charts.web.widgets.pivottable.CubaPivotTableExtension;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

@Connect(CubaPivotTableExtension.class)
public class CubaPivotTableExtensionConnector extends AbstractExtensionConnector {

    @Override
    protected void extend(ServerConnector target) {
        final CubaPivotTableSceneWidget pivotWidget = (CubaPivotTableSceneWidget) ((ComponentConnector) target).getWidget();

        CubaPivotTableExtensionJsOverlay jsOverlay = new CubaPivotTableExtensionJsOverlay(pivotWidget.getElement());

        pivotWidget.setRefreshHandler(jsRefreshEvent -> {
            String json = jsOverlay.getPivotDataJSON();
            getRpcProxy(CubaPivotTableExtensionServerRpc.class).updatePivotDataJSON(json);

            if (jsRefreshEvent != null) {
                getRpcProxy(CubaPivotTableExtensionServerRpc.class).updateCurrentRenderer(jsRefreshEvent.getRenderer());
            }
        });
    }
}