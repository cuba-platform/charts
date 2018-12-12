/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.listeners.doubleclick;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.Circle;

import java.util.function.Consumer;

/**
 * @deprecated Use {@link MapViewer#addCircleDoubleClickListener(Consumer)} instead.
 */
@Deprecated
public interface CircleDoubleClickListener extends Consumer<MapViewer.CircleDoubleClickEvent> {
    class CircleDoubleClickEvent {
        private Circle circle;

        public CircleDoubleClickEvent(Circle circle) {
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }

    void onDoubleClick(CircleDoubleClickEvent event);

    @Override
    default void accept(MapViewer.CircleDoubleClickEvent event) {
        onDoubleClick(new CircleDoubleClickEvent(event.getCircle()));
    }
}