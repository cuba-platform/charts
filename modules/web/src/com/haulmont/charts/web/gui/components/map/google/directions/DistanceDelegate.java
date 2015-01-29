/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;


import com.haulmont.charts.gui.map.model.directions.Distance;

/**
 * @author korotkov
 * @version $Id$
 */
public class DistanceDelegate implements Distance {

    private com.vaadin.tapio.googlemaps.client.services.Distance distance;

    public DistanceDelegate(com.vaadin.tapio.googlemaps.client.services.Distance distance) {
        this.distance = distance;
    }

    public com.vaadin.tapio.googlemaps.client.services.Distance getDistance() {
        return distance;
    }

    public void setDistance(com.vaadin.tapio.googlemaps.client.services.Distance distance) {
        this.distance = distance;
    }

    @Override
    public String getText() {
        return distance.getText();
    }

    @Override
    public void setText(String text) {
        distance.setText(text);
    }

    @Override
    public int getValue() {
        return distance.getValue();
    }

    @Override
    public void setValue(int value) {
        distance.setValue(value);
    }
}
