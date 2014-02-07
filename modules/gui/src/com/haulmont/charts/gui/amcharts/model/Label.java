/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public class Label extends AbstractConfigurationObject {

    private static final long serialVersionUID = 3973480345155361978L;

    private Integer x;

    private Integer y;

    private String text;

    private Align align;

    private Integer size;

    private Color color;

    private Double alpha;

    private Integer rotation;

    private Boolean bold;

    private String url;

    public Align getAlign() {
        return align;
    }

    public Label setAlign(Align align) {
        this.align = align;
        return this;
    }

    public Double getAlpha() {
        return alpha;
    }

    public Label setAlpha(Double alpha) {
        this.alpha = alpha;
        return this;
    }

    public Boolean getBold() {
        return bold;
    }

    public Label setBold(Boolean bold) {
        this.bold = bold;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Label setColor(Color color) {
        this.color = color;
        return this;
    }

    public Integer getRotation() {
        return rotation;
    }

    public Label setRotation(Integer rotation) {
        this.rotation = rotation;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public Label setSize(Integer size) {
        this.size = size;
        return this;
    }

    public String getText() {
        return text;
    }

    public Label setText(String text) {
        this.text = text;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Label setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getX() {
        return x;
    }

    public Label setX(Integer x) {
        this.x = x;
        return this;
    }

    public Integer getY() {
        return y;
    }

    public Label setY(Integer y) {
        this.y = y;
        return this;
    }
}