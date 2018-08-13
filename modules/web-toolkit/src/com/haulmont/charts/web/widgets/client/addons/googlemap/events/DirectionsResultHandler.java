/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.events;

import com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsResult;
import com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsStatus;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public interface DirectionsResultHandler {
    void handle(long requestId, DirectionsResult result, DirectionsStatus status);
}