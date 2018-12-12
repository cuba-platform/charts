/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.centerchange;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Circle;
import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addCircleCenterChangeListener(Consumer)} instead.
 */
@Deprecated
public interface CircleCenterChangeListener extends Consumer<MapViewer.CircleCenterChangeEvent> {

    class CircleCenterChangeEvent {
        private Circle circle;
        private GeoPoint oldCenter;

        public CircleCenterChangeEvent(Circle circle, GeoPoint oldCenter) {
            this.circle = circle;
            this.oldCenter = oldCenter;
        }

        public Circle getCircle() {
            return circle;
        }

        public GeoPoint getOldCenter() {
            return oldCenter;
        }
    }

    void onCenterChange(CircleCenterChangeEvent event);

    @Override
    default void accept(MapViewer.CircleCenterChangeEvent mapEvent) {
        onCenterChange(new CircleCenterChangeEvent(mapEvent.getCircle(), mapEvent.getOldCenter()));
    }
}