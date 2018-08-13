/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
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
