/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public class Title extends AbstractConfigurationObject {

    private static final long serialVersionUID = -2398460960797730153L;

    private String text;

    private Integer size;

    private Color color;

    private Double alpha;

    private Boolean bold;

    public Double getAlpha() {
        return alpha;
    }

    public Title setAlpha(Double alpha) {
        this.alpha = alpha;
        return this;
    }

    public Boolean getBold() {
        return bold;
    }

    public Title setBold(Boolean bold) {
        this.bold = bold;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Title setColor(Color color) {
        this.color = color;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public Title setSize(Integer size) {
        this.size = size;
        return this;
    }

    public String getText() {
        return text;
    }

    public Title setText(String text) {
        this.text = text;
        return this;
    }
}