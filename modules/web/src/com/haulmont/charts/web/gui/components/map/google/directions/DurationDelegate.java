/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.directions.Duration;

/**
 */
public class DurationDelegate implements Duration {

    private com.vaadin.tapio.googlemaps.client.services.Duration duration;

    public static DurationDelegate fromDuration(com.vaadin.tapio.googlemaps.client.services.Duration duration) {
        return duration != null ? new DurationDelegate(duration) : null;
    }

    public DurationDelegate(com.vaadin.tapio.googlemaps.client.services.Duration duration) {
        Preconditions.checkNotNullArgument(duration);
        this.duration = duration;
    }

    public com.vaadin.tapio.googlemaps.client.services.Duration getDuration() {
        return duration;
    }

    public void setDuration(com.vaadin.tapio.googlemaps.client.services.Duration duration) {
        this.duration = duration;
    }

    @Override
    public String getText() {
        return duration.getText();
    }

    @Override
    public void setText(String text) {
        duration.setText(text);
    }

    @Override
    public int getValue() {
        return duration.getValue();
    }

    @Override
    public void setValue(int value) {
        duration.setValue(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DurationDelegate that = (DurationDelegate) o;

        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return duration != null ? duration.hashCode() : 0;
    }
}
