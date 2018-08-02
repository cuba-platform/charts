/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.rpcs.rightclick;

import com.vaadin.shared.communication.ServerRpc;

public interface CircleRightClickedRpc extends ServerRpc {

    void circleRightClicked(long circleId);
}