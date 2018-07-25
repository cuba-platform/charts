/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.rpcs;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services.DirectionsResult;
import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services.DirectionsStatus;
import com.vaadin.shared.communication.ServerRpc;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public interface HandleDirectionsResultRpc extends ServerRpc {
    void handle(DirectionsResult result, DirectionsStatus status, long directionsRequestId);
}