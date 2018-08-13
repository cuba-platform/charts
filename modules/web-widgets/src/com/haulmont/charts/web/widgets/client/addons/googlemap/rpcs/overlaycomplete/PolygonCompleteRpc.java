/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.overlaycomplete;

import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapPolygon;
import com.vaadin.shared.communication.ServerRpc;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public interface PolygonCompleteRpc extends ServerRpc {
    void polygonComplete(GoogleMapPolygon polygon);
}