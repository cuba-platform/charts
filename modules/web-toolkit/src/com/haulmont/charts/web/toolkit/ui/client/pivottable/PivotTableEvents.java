/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable;

import com.haulmont.charts.web.toolkit.ui.client.pivottable.events.RefreshHandler;

public class PivotTableEvents {

    private RefreshHandler refreshHandler;

    public RefreshHandler getRefreshHandler() {
        return refreshHandler;
    }

    public void setRefreshHandler(RefreshHandler refreshHandler) {
        this.refreshHandler = refreshHandler;
    }
}
