/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.amcharts.model.charts.StockChartModel;

import java.util.Date;
import java.util.UUID;

/**
 * StockEvent is object which holds information about event (bullet). Values from {@link StockEventsSettings} will be
 * used if not set. Stock event bullet's size depends on it's {@link StockGraph#fontSize}. When user rolls-over,
 * clicks or rolls-out of the event bullet, {@link StockChartModel} dispatches events.
 * <br>
 * See documentation for properties of StockEvent JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/StockEvent">http://docs.amcharts.com/3/javascriptstockchart/StockEvent</a>
 */
public class StockEvent extends AbstractChartObject {

    private static final long serialVersionUID = -145705259976870942L;

    private UUID id;

    private Double backgroundAlpha;

    private Color backgroundColor;

    private Double borderAlpha;

    private Color borderColor;

    private Color color;

    private Date date;

    private String description;

    private Integer fontSize;

    private String graph;

    private Color rollOverColor;

    private String showAt;

    private Boolean showBullet;

    private Boolean showOnAxis;

    private String text;

    private StockEventType type;

    private String url;

    private String urlTarget;

    private Double value;

    public StockEvent() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    /**
     * @return opacity of bullet background
     */
    public Double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    /**
     * Sets opacity of bullet background. If not set the default value is 1.
     *
     * @param backgroundAlpha opacity
     */
    public StockEvent setBackgroundAlpha(Double backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
        return this;
    }

    /**
     * @return color of bullet background
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets color of bullet background. If not set the default value is #DADADA.
     *
     * @param backgroundColor color
     */
    public StockEvent setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * @return opacity of bullet border
     */
    public Double getBorderAlpha() {
        return borderAlpha;
    }

    /**
     * Sets opacity of bullet border. If not set the default value is 1.
     *
     * @param borderAlpha opacity
     */
    public StockEvent setBorderAlpha(Double borderAlpha) {
        this.borderAlpha = borderAlpha;
        return this;
    }

    /**
     * @return bullet border color
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * Sets bullet border color. If not set the default value is #888888.
     *
     * @param borderColor color
     */
    public StockEvent setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * @return color of the event text
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color of the event text. If not set the default value is #000000.
     *
     * @param color color
     */
    public StockEvent setColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * @return date of an event
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date of an event.
     *
     * @param date date
     */
    public StockEvent setDate(Date date) {
        this.date = date;
        return this;
    }

    /**
     * @return description that is shown in a balloon when user rolls over mouse cursor over event icon
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a description that will be shown in a balloon when user rolls over mouse cursor over event icon.
     *
     * @param description description
     */
    public StockEvent setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * @return font size of a event bullet
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * Sets font size of a event bullet. Will use graph's or chart font size if not set.
     *
     * @param fontSize font size
     */
    public StockEvent setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * @return id of the graph on which event is displayed
     */
    public String getGraph() {
        return graph;
    }

    /**
     * Sets id of the graph on which event will be displayed.
     *
     * @param graph graph id
     */
    public StockEvent setGraph(String graph) {
        this.graph = graph;
        return this;
    }

    /**
     * @return roll-over background color
     */
    public Color getRollOverColor() {
        return rollOverColor;
    }

    /**
     * Sets roll-over background color. If not set the default value is #CC0000.
     *
     * @param rollOverColor color
     */
    public StockEvent setRollOverColor(Color rollOverColor) {
        this.rollOverColor = rollOverColor;
        return this;
    }

    /**
     * @return showAt string
     */
    public String getShowAt() {
        return showAt;
    }

    /**
     * Allows placing event bullets at "open", "close", "low", "high" values.
     *
     * @param showAt showAt string
     */
    public StockEvent setShowAt(String showAt) {
        this.showAt = showAt;
        return this;
    }

    /**
     * @return true if the data point displays both event and regular (if set) bullets
     */
    public Boolean getShowBullet() {
        return showBullet;
    }

    /**
     * Set showBullet to true if the data point should display both event and regular (if set) bullets. If not set
     * the default value is false.
     *
     * @param showBullet showBullet option
     */
    public StockEvent setShowBullet(Boolean showBullet) {
        this.showBullet = showBullet;
        return this;
    }

    /**
     * @return true if the event is displayed on the category axis
     */
    public Boolean getShowOnAxis() {
        return showOnAxis;
    }

    /**
     * Set showOnAxis to true if the event should be displayed on the category axis. If not set the default value is
     * false.
     *
     * @param showOnAxis showOnAxis option
     */
    public StockEvent setShowOnAxis(Boolean showOnAxis) {
        this.showOnAxis = showOnAxis;
        return this;
    }

    /**
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets letter which will be displayed on the event. Not all types can display letters. "text" type can display
     * longer texts.
     *
     * @param text text
     */
    public StockEvent setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @return type of bullet
     */
    public StockEventType getType() {
        return type;
    }

    /**
     * Sets type of bullet. If not set the default value is SIGN.
     *
     * @param type type
     */
    public StockEvent setType(StockEventType type) {
        this.type = type;
        return this;
    }

    /**
     * @return the URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL to go to when user clicks the event.
     *
     * @param url the URL
     */
    public StockEvent setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * @return target of URL
     */
    public String getUrlTarget() {
        return urlTarget;
    }

    /**
     * Sets target of URL, "_blank" for example.
     *
     * @param urlTarget URL target
     */
    public StockEvent setUrlTarget(String urlTarget) {
        this.urlTarget = urlTarget;
        return this;
    }

    /**
     * @return specified value
     */
    public Double getValue() {
        return value;
    }

    /**
     * Allows placing event bullets at specified value.
     *
     * @param value value
     */
    public StockEvent setValue(Double value) {
        this.value = value;
        return this;
    }
}
