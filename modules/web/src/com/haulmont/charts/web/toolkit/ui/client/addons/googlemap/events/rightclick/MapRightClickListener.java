/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.events.rightclick;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.LatLon;

/**
 * Interface for listeners notified after map right click.
 */
public interface MapRightClickListener {
    /**
     * Called after map right click.
     *
     * @param position position that was right clicked
     */
    void mapRightClicked(LatLon position);
}