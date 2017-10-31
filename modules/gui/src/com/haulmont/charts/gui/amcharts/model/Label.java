/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of Label JS Object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/Label">http://docs.amcharts.com/3/javascriptcharts/Label</a>
 */
public class Label extends AbstractChartObject {

    private static final long serialVersionUID = 3973480345155361978L;

    private Align align;

    private Double alpha;

    private Boolean bold;

    private Color color;

    private String id;

    private Integer rotation;

    private Integer size;

    private Integer tabIndex;

    private String text;

    private String url;

    private String x;

    private String y;

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

    /**
     * Gets the x position of the label.
     *
     * @return String with double or double with "%".
     */
    public String getX() {
        return x;
    }

    /**
     * Sets the x position of the label. You can set x coordinate in percentage or in pixels format.
     * For instance, 50% - position with percentage, 50 - position in pixels.
     *
     * @param x double or double with "%".
     * @return
     */
    public Label setX(String x) {
        checkCorrectInputFormat(x);

        this.x = x;
        return this;
    }

    /**
     * Gets the y position of the label.
     *
     * @return String with double or double with "%".
     */
    public String getY() {
        return y;
    }

    /**
     * Sets the x position of the label. You can set x coordinate in percentage or in pixels format.
     * For instance, 50% - position with percentage, 50 - position in pixels.
     *
     * @param y double or double with "%".
     * @return
     */
    public Label setY(String y) {
        checkCorrectInputFormat(y);

        this.y = y;
        return this;
    }

    public String getId() {
        return id;
    }

    public Label setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getTabIndex() {
        return tabIndex;
    }

    public Label setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
        return this;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    protected void checkCorrectInputFormat(String value) {
        if (value == null) {
            return;
        }

        if (value.endsWith("%")) {
            value = value.substring(0, value.length() - 1);
        }
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("Can not set '%s' value. " +
                    "Try to set numbers or percentage values.", value));
        }
    }
}