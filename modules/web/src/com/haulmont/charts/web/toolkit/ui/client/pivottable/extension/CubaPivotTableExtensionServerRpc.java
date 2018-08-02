/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable.extension;

import com.vaadin.shared.communication.ServerRpc;

public interface CubaPivotTableExtensionServerRpc extends ServerRpc {

    void updatePivotDataJSON(String json);
}