/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.rightclick;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Circle;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addCircleRightClickListener(Consumer)} instead.
 */
@Deprecated
public interface CircleRightClickListener extends Consumer<MapViewer.CircleRightClickEvent> {
    class CircleRightClickEvent {
        protected Circle circle;

        public CircleRightClickEvent(Circle circle) {
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }

    void onRightClick(CircleRightClickEvent event);

    @Override
    default void accept(MapViewer.CircleRightClickEvent event) {
        onRightClick(new CircleRightClickEvent(event.getCircle()));
    }
}