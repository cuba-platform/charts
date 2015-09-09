/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.Date;

/**
 * See documentation for properties of Guide JS Object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/Guide">http://docs.amcharts.com/3/javascriptcharts/Guide</a>
 *
 * @author artamonov
 * @version $Id$
 */
public class Guide extends AbstractChartObject {

    private static final long serialVersionUID = -6465377479319328449L;

    private Boolean above;

    private Integer angle;

    private Color balloonColor;

    private String balloonText;

    private Boolean boldLabel;

    private String category;

    private Color color;

    private Integer dashLength;

    private Date date;

    private Boolean expand;

    private Double fillAlpha;

    private Color fillColor;

    private Integer fontSize;

    private String id;

    private Boolean inside;

    private String label;

    private Integer labelRotation;

    private Double lineAlpha;

    private Color lineColor;

    private Integer lineThickness;

    private Position position;

    private Integer tickLength;

    private Integer toAngle;

    private String toCategory;

    private Date toDate;

    private Double toValue;

    private Double value;

    private String valueAxis;

    public Boolean getAbove() {
        return above;
    }

    public Guide setAbove(Boolean above) {
        this.above = above;
        return this;
    }

    public Integer getAngle() {
        return angle;
    }

    public Guide setAngle(Integer angle) {
        this.angle = angle;
        return this;
    }

    public Color getBalloonColor() {
        return balloonColor;
    }

    public Guide setBalloonColor(Color balloonColor) {
        this.balloonColor = balloonColor;
        return this;
    }

    public String getBalloonText() {
        return balloonText;
    }

    public Guide setBalloonText(String balloonText) {
        this.balloonText = balloonText;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Guide setCategory(String category) {
        this.category = category;
        return this;
    }

    public Integer getDashLength() {
        return dashLength;
    }

    public Guide setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Guide setDate(Date date) {
        this.date = date;
        return this;
    }

    public Double getFillAlpha() {
        return fillAlpha;
    }

    public Guide setFillAlpha(Double fillAlpha) {
        this.fillAlpha = fillAlpha;
        return this;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public Guide setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public Guide setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public Boolean getInside() {
        return inside;
    }

    public Guide setInside(Boolean inside) {
        this.inside = inside;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Guide setLabel(String label) {
        this.label = label;
        return this;
    }

    public Integer getLabelRotation() {
        return labelRotation;
    }

    public Guide setLabelRotation(Integer labelRotation) {
        this.labelRotation = labelRotation;
        return this;
    }

    public Double getLineAlpha() {
        return lineAlpha;
    }

    public Guide setLineAlpha(Double lineAlpha) {
        this.lineAlpha = lineAlpha;
        return this;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public Guide setLineColor(Color lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    public Integer getLineThickness() {
        return lineThickness;
    }

    public Guide setLineThickness(Integer lineThickness) {
        this.lineThickness = lineThickness;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public Guide setPosition(Position position) {
        this.position = position;
        return this;
    }

    public Integer getTickLength() {
        return tickLength;
    }

    public Guide setTickLength(Integer tickLength) {
        this.tickLength = tickLength;
        return this;
    }

    public Integer getToAngle() {
        return toAngle;
    }

    public Guide setToAngle(Integer toAngle) {
        this.toAngle = toAngle;
        return this;
    }

    public String getToCategory() {
        return toCategory;
    }

    public Guide setToCategory(String toCategory) {
        this.toCategory = toCategory;
        return this;
    }

    public Date getToDate() {
        return toDate;
    }

    public Guide setToDate(Date toDate) {
        this.toDate = toDate;
        return this;
    }

    public Double getToValue() {
        return toValue;
    }

    public Guide setToValue(Double toValue) {
        this.toValue = toValue;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Guide setValue(Double value) {
        this.value = value;
        return this;
    }

    public Boolean getBoldLabel() {
        return boldLabel;
    }

    public Guide setBoldLabel(Boolean boldLabel) {
        this.boldLabel = boldLabel;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Guide setColor(Color color) {
        this.color = color;
        return this;
    }

    public Boolean getExpand() {
        return expand;
    }

    public Guide setExpand(Boolean expand) {
        this.expand = expand;
        return this;
    }

    public String getId() {
        return id;
    }

    public Guide setId(String id) {
        this.id = id;
        return this;
    }

    public String getValueAxis() {
        return valueAxis;
    }

    public Guide setValueAxis(String valueAxis) {
        this.valueAxis = valueAxis;
        return this;
    }
}