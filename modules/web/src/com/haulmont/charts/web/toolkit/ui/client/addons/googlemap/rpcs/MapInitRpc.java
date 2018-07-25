/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.rpcs;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.LatLon;
import com.vaadin.shared.communication.ServerRpc;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public interface MapInitRpc extends ServerRpc {
    public void init(LatLon center, int zoom, LatLon boundsNE, LatLon boundsSW);
}
