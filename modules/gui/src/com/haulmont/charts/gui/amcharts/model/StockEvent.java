/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.cuba.core.global.UuidProvider;

import java.util.Date;
import java.util.UUID;

/**
 * See documentation for properties of StockEvent JS object. <br/>
 * <p>
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/StockEvent">http://docs.amcharts.com/3/javascriptstockchart/StockEvent</a>
 *
 * @author gorelov
 * @version $Id$
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
        id = UuidProvider.createUuid();
    }

    public UUID getId() {
        return id;
    }

    public Double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    public StockEvent setBackgroundAlpha(Double backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public StockEvent setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Double getBorderAlpha() {
        return borderAlpha;
    }

    public StockEvent setBorderAlpha(Double borderAlpha) {
        this.borderAlpha = borderAlpha;
        return this;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public StockEvent setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public StockEvent setColor(Color color) {
        this.color = color;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public StockEvent setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StockEvent setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public StockEvent setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public String getGraph() {
        return graph;
    }

    public StockEvent setGraph(String graph) {
        this.graph = graph;
        return this;
    }

    public Color getRollOverColor() {
        return rollOverColor;
    }

    public StockEvent setRollOverColor(Color rollOverColor) {
        this.rollOverColor = rollOverColor;
        return this;
    }

    public String getShowAt() {
        return showAt;
    }

    public StockEvent setShowAt(String showAt) {
        this.showAt = showAt;
        return this;
    }

    public Boolean getShowBullet() {
        return showBullet;
    }

    public StockEvent setShowBullet(Boolean showBullet) {
        this.showBullet = showBullet;
        return this;
    }

    public Boolean getShowOnAxis() {
        return showOnAxis;
    }

    public StockEvent setShowOnAxis(Boolean showOnAxis) {
        this.showOnAxis = showOnAxis;
        return this;
    }

    public String getText() {
        return text;
    }

    public StockEvent setText(String text) {
        this.text = text;
        return this;
    }

    public StockEventType getType() {
        return type;
    }

    public StockEvent setType(StockEventType type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public StockEvent setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUrlTarget() {
        return urlTarget;
    }

    public StockEvent setUrlTarget(String urlTarget) {
        this.urlTarget = urlTarget;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public StockEvent setValue(Double value) {
        this.value = value;
        return this;
    }
}
