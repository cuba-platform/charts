/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.events.rightclick;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.overlays.GoogleMapPolygon;

/**
 * Interface for listeners notified after polygon right click.
 */
public interface PolygonRightClickListener {
    /**
     * Called after polygon right click.
     *
     * @param polygon GoogleMapPolygon that was right clicked
     */
    void polygonRightClicked(GoogleMapPolygon polygon);
}