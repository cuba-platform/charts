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
            JsPivotExtensionOptions options = JsPivotExtensionOptions.get();
            options.setDateTimeParseFormat(options, getState().dateTimeParseFormat);
            options.setDateParseFormat(options, getState().dateParseFormat);
            options.setTimeParseFormat(options, getState().timeParseFormat);

            String json = jsOverlay.convertPivotTableToJson(options);
            getRpcProxy(CubaPivotTableExtensionServerRpc.class).updatePivotDataJSON(json);

            if (jsRefreshEvent != null) {
                getRpcProxy(CubaPivotTableExtensionServerRpc.class).updateCurrentRenderer(jsRefreshEvent.getRenderer());
            }
        });
    }

    @Override
    public CubaPivotTableExtensionState getState() {
        return (CubaPivotTableExtensionState) super.getState();
    }
}