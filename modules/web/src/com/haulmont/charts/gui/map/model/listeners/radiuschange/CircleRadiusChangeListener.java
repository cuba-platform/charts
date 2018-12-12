/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.radiuschange;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Circle;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addCircleRadiusChangeListener(Consumer)} instead.
 */
@Deprecated
public interface CircleRadiusChangeListener extends Consumer<MapViewer.CircleRadiusChangeEvent> {

    class CircleRadiusChangeEvent {

        private Circle circle;
        private double oldRadius;

        public CircleRadiusChangeEvent(Circle circle, double oldRadius) {
            this.circle = circle;
            this.oldRadius = oldRadius;
        }

        public Circle getCircle() {
            return circle;
        }

        public double getOldRadius() {
            return oldRadius;
        }
    }

    void onRadiusChange(CircleRadiusChangeEvent event);

    @Override
    default void accept(MapViewer.CircleRadiusChangeEvent event) {
        onRadiusChange(new CircleRadiusChangeEvent(event.getCircle(), event.getOldRadius()));
    }
}