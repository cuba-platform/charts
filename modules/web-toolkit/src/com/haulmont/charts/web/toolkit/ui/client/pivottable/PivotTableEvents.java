/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable;

import com.haulmont.charts.web.toolkit.ui.client.pivottable.events.JsRefreshEvent;

import java.util.function.Consumer;

public class PivotTableEvents {

    private Consumer<JsRefreshEvent> refreshHandler;

    public Consumer<JsRefreshEvent> getRefreshHandler() {
        return refreshHandler;
    }

    public void setRefreshHandler(Consumer<JsRefreshEvent> refreshHandler) {
        this.refreshHandler = refreshHandler;
    }
}
