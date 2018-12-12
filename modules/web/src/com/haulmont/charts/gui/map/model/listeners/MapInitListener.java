/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.function.Consumer;

/**
 * Listener to be fired once when map initialization is finished: tiles are loaded up, coordinates of center
 * and borders are known etc.
 *
 * @deprecated Use {@link MapViewer#addMapInitListener(Consumer)} instead.
 */
@Deprecated
public interface MapInitListener extends Consumer<MapViewer.MapInitEvent> {
    void init(GeoPoint center, int zoom, GeoPoint boundNE, GeoPoint boundSW);

    @Override
    default void accept(MapViewer.MapInitEvent event) {
        init(event.getCenter(), event.getZoom(), event.getBoundNE(), event.getBoundSW());
    }
}
