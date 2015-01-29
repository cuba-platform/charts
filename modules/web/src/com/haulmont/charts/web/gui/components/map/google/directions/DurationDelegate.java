/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.charts.gui.map.model.directions.Duration;

/**
 * @author korotkov
 * @version $Id$
 */
public class DurationDelegate implements Duration {

    private com.vaadin.tapio.googlemaps.client.services.Duration duration;

    public DurationDelegate(com.vaadin.tapio.googlemaps.client.services.Duration duration) {
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
}
