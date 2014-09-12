/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.map.model.GeoPoint;

/**
 * Listener to be fired once when map initialization is finished: tiles are loaded up, coordinates of center
 * and borders are known etc.
 *
 * @author korotkov
 * @version $Id$
 */
public interface MapInitListener {
    void init(GeoPoint center, int zoom, GeoPoint boundNE, GeoPoint boundSW);
}
