/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public class LegendItem extends AbstractConfigurationObject {

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