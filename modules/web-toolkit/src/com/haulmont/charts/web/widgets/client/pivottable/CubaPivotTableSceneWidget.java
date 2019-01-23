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

package com.haulmont.charts.web.widgets.client.pivottable;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Widget;
import com.haulmont.charts.web.widgets.client.pivottable.events.JsRefreshEvent;

import java.util.function.Consumer;

public class CubaPivotTableSceneWidget extends Widget implements HasEnabled {

    protected static final String EMPTY_DATA_STYLE = "empty";

    protected CubaPivotTableJsOverlay jsOverlay;
    protected boolean enabled = true;

    protected Consumer<JsRefreshEvent> refreshHandler;
    protected Consumer<JsRefreshEvent> refreshHandlerSubscriber;

    public CubaPivotTableSceneWidget() {
        setElement(Document.get().createDivElement());
        setStyleName("c-pivot-table");
    }

    public void init(PivotTableConfig config, PivotTableEvents events) {

        refreshHandler = jsRefreshEvent -> {
            if (refreshHandlerSubscriber != null) {
                refreshHandlerSubscriber.accept(jsRefreshEvent);
            }
        };
        // it is important to do this order of handlers,
        // first handler for extension that should be before original component's handler
        refreshHandler = refreshHandler.andThen(events.getRefreshHandler());

        jsOverlay = CubaPivotTableJsOverlay.makePivot(getElement(), config,
                refreshHandler, events.getCellClickHandler(), enabled);
        setShowEmptyDataMessage(!config.hasData());

        // as non editable pivotTable doesn't send refresh event, we send it manually
        if (refreshHandlerSubscriber != null && !isEditable(config)) {
            refreshHandlerSubscriber.accept(null);
        }
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    protected void setShowEmptyDataMessage(boolean showEmptyDataMessage) {
        if (showEmptyDataMessage) {
            addStyleDependentName(EMPTY_DATA_STYLE);
        } else {
            removeStyleDependentName(EMPTY_DATA_STYLE);
        }
    }

    public void setRefreshHandler(Consumer<JsRefreshEvent> handler) {
        refreshHandlerSubscriber = handler;
    }

    protected native boolean isEditable(PivotTableConfig config) /*-{
        return config.options.editable;
    }-*/;
}
