/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.pivottable;

import com.haulmont.charts.web.widgets.client.pivottable.events.JsCellClickEvent;
import com.haulmont.charts.web.widgets.client.pivottable.events.JsRefreshEvent;

import java.util.function.Consumer;

public class PivotTableEvents {

    private Consumer<JsRefreshEvent> refreshHandler;
    private Consumer<JsCellClickEvent> cellClickHandler;

    public Consumer<JsRefreshEvent> getRefreshHandler() {
        return refreshHandler;
    }

    public void setRefreshHandler(Consumer<JsRefreshEvent> refreshHandler) {
        this.refreshHandler = refreshHandler;
    }

    public Consumer<JsCellClickEvent> getCellClickHandler() {
        return cellClickHandler;
    }

    public void setCellClickHandler(Consumer<JsCellClickEvent> cellClickHandler) {
        this.cellClickHandler = cellClickHandler;
    }
}
