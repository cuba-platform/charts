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

    /**
     * @return opacity of a title
     */
    public Double getAlpha() {
        return alpha;
    }

    /**
     * Sets opacity of a title.
     *
     * @param alpha opacity
     */
    public Title setAlpha(Double alpha) {
        this.alpha = alpha;
        return this;
    }

    /**
     * @return true if title is bold
     */
    public Boolean getBold() {
        return bold;
    }

    /**
     * Set bold to false if title shouldn't be bold.
     *
     * @param bold bold option
     */
    public Title setBold(Boolean bold) {
        this.bold = bold;
        return this;
    }

    /**
     * @return text color of a title
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets text color of a title.
     *
     * @param color color
     */
    public Title setColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * @return text size of a title
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Sets text size of a title.
     *
     * @param size text size
     */
    public Title setSize(Integer size) {
        this.size = size;
        return this;
    }

    /**
     * @return text of a title
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text of a title.
     *
     * @param text text
     */
    public Title setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @return unique id of a title
     */
    public String getId() {
        return id;
    }

    /**
     * Sets unique id of a title.
     *
     * @param id id
     */
    public Title setId(String id) {
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
     * In case you set it to some number, the chart will set focus on the title when user clicks tab key. When a
     * focus is set, screen readers like NVDA screen reader will read the title. Note, not all browsers and readers
     * support this.
     *
     * @param tabIndex tab index
     */
    public Title setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
        return this;
    }
}