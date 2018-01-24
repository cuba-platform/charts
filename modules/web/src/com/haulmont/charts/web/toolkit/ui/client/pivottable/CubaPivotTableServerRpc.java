/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable;

import com.vaadin.shared.communication.ServerRpc;

public interface CubaPivotTableServerRpc extends ServerRpc {
    void onRefresh(String[] rows, String[] cols, String renderer,
                   String aggregation, String[] aggregationProperties);
}
