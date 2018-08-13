/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.pivottable;

import com.vaadin.shared.communication.ServerRpc;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public interface CubaPivotTableServerRpc extends ServerRpc {

    void onCellClick(@Nullable Double value, Map<String, String> filters);

    void onRefresh(List<String> rows, List<String> cols, String renderer,
                   String aggregation, List<String> aggregationProperties,
                   Map<String, List<String>> inclusions, Map<String, List<String>> exclusions,
                   String colOrderId, String rowOrderId);
}
