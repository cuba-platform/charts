/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * Creates a label on the chart which can be placed anywhere, multiple can be assigned.
 * <br>
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

    /**
     * @return align
     */
    public Align getAlign() {
        return align;
    }

    /**
     * Sets align to the label. If not set the default value is LEFT.
     *
     * @param align align
     */
    public Label setAlign(Align align) {
        this.align = align;
        return this;
    }

    /**
     * @return opacity of the label
     */
    public Double getAlpha() {
        return alpha;
    }

    /**
     * Sets opacity of the label. If not set the default value is 1.
     *
     * @param alpha opacity
     */
    public Label setAlpha(Double alpha) {
        this.alpha = alpha;
        return this;
    }

    /**
     * @return true if label is bold
     */
    public Boolean getBold() {
        return bold;
    }

    /**
     * Set bold to true if label should be bold. If not set the default value is false.
     *
     * @param bold bold option
     */
    public Label setBold(Boolean bold) {
        this.bold = bold;
        return this;
    }

    /**
     * @return color of a label
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color of a label.
     *
     * @param color color
     */
    public Label setColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * @return rotation angle
     */
    public Integer getRotation() {
        return rotation;
    }

    /**
     * Sets rotation angle. If not set the default value is 0.
     *
     * @param rotation angle
     */
    public Label setRotation(Integer rotation) {
        this.rotation = rotation;
        return this;
    }

    /**
     * @return text size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Sets text size.
     *
     * @param size size
     */
    public Label setSize(Integer size) {
        this.size = size;
        return this;
    }

    /**
     * @return text of the label
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text of the label.
     *
     * @param text text
     */
    public Label setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @return the URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL which will be access if user clicks on a label.
     *
     * @param url the URL
     */
    public Label setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the X position of the label.
     *
     * @return string with double or double with "%"
     */
    public String getX() {
        return x;
    }

    /**
     * Sets the X position of the label. You can set x coordinate in percentage or in pixels format.
     * For instance, 50% - position with percentage, 50 - position in pixels.
     *
     * @param x double or double with "%"
     */
    public Label setX(String x) {
        checkCorrectInputFormat(x);

        this.x = x;
        return this;
    }

    /**
     * Gets the Y position of the label.
     *
     * @return string with double or double with "%"
     */
    public String getY() {
        return y;
    }

    /**
     * Sets the Y position of the label. You can set x coordinate in percentage or in pixels format.
     * For instance, 50% - position with percentage, 50 - position in pixels.
     *
     * @param y double or double with "%"
     */
    public Label setY(String y) {
        checkCorrectInputFormat(y);

        this.y = y;
        return this;
    }

    /**
     * @return unique id of the label
     */
    public String getId() {
        return id;
    }

    /**
     * Sets unique id of the label.
     *
     * @param id id
     */
    public Label setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return tab index
     */
    public Integer getTabIndex() {
        return tabIndex;
    }

    /**
     * Sets tab index. In case you set it to some number, the chart will set focus on the label when user clicks tab
     * key. When a focus is set, screen readers like NVDA screen reader will read the title. Note, not all browsers
     * and readers support this.
     *
     * @param tabIndex tab index
     */
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