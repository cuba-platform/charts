/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.events.overlaycomplete;

import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapPolygon;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)

 */
public interface PolygonCompleteListener {
    void polygonComplete(GoogleMapPolygon polygon);
}
