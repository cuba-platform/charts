/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.overlaycomplete;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Circle;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addCircleCompleteListener(Consumer)} instead.
 */
@Deprecated
public interface CircleCompleteListener extends Consumer<MapViewer.CircleCompleteEvent> {
    class CircleCompleteEvent {
        private Circle circle;

        public CircleCompleteEvent(Circle circle) {
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }

    void onCircleComplete(CircleCompleteEvent event);

    @Override
    default void accept(MapViewer.CircleCompleteEvent event) {
        onCircleComplete(new CircleCompleteEvent(event.getCircle()));
    }
}