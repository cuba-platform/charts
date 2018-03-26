/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable;

import com.vaadin.shared.communication.ServerRpc;

import java.util.List;
import java.util.Map;

public interface CubaPivotTableServerRpc extends ServerRpc {
    void onRefresh(List<String> rows, List<String> cols, String renderer,
                   String aggregation, List<String> aggregationProperties,
                   Map<String, List<String>> inclusions, Map<String, List<String>> exclusions,
                   String colOrderId, String rowOrderId);
}
