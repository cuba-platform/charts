/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of Title JS Object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/Title">http://docs.amcharts.com/3/javascriptcharts/Title</a>
 */
public class Title extends AbstractChartObject {

    private static final long serialVersionUID = -2398460960797730153L;

    private Double alpha;

    private Boolean bold;

    private Color color;

    private String id;

    private Integer size;

    private Integer tabIndex;

    private String text;

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

    public String getId() {
        return id;
    }

    public Title setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getTabIndex() {
        return tabIndex;
    }

    public Title setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
        return this;
    }
}