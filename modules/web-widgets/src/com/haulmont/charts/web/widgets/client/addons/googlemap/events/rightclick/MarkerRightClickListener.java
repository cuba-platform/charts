/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.events.rightclick;

import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapMarker;

/**
 * Interface for listeners notified after marker right click.
 */
public interface MarkerRightClickListener {
    /**
     * Called after marker right click.
     *
     * @param marker GoogleMapMarker that was right clicked
     */
    void markerRightClicked(GoogleMapMarker marker);
}