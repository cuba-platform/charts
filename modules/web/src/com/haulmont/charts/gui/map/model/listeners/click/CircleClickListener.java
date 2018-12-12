/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.click;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Circle;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addCircleClickListener(Consumer)} instead.
 */
@Deprecated
public interface CircleClickListener extends Consumer<MapViewer.CircleClickEvent> {
    class CircleClickEvent {
        private Circle circle;

        public CircleClickEvent(Circle circle) {
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }

    void onClick(CircleClickEvent event);

    @Override
    default void accept(MapViewer.CircleClickEvent event) {
        onClick(new CircleClickEvent(event.getCircle()));
    }
}