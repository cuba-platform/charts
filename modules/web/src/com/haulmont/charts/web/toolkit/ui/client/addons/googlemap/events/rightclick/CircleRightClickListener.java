/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.events.rightclick;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.overlays.GoogleMapCircle;

/**
 * Interface for listeners notified after circle right click.
 */
public interface CircleRightClickListener {
    /**
     * Called after circle right click.
     *
     * @param circle GoogleMapCircle that was right clicked
     */
    void circleRightClicked(GoogleMapCircle circle);
}