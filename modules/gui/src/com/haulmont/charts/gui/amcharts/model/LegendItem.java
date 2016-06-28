/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

public class LegendItem extends AbstractChartObject {

    private static final long serialVersionUID = 8563526782768492986L;

    private String title;

    private Color color;

    private MarkerType markerType;

    public Color getColor() {
        return color;
    }

    public LegendItem setColor(Color color) {
        this.color = color;
        return this;
    }

    public MarkerType getMarkerType() {
        return markerType;
    }

    public LegendItem setMarkerType(MarkerType markerType) {
        this.markerType = markerType;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public LegendItem setTitle(String title) {
        this.title = title;
        return this;
    }
}