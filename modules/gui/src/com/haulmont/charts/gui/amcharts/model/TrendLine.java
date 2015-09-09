/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.Date;

/**
 * See documentation for properties of TrendLine JS Object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/TrendLine">http://docs.amcharts.com/3/javascriptcharts/TrendLine</a>
 *
 * @author artamonov
 * @version $Id$
 */
public class TrendLine extends AbstractChartObject {

    private static final long serialVersionUID = -6846712713867338160L;

    private Integer dashLength;

    private String finalCategory;

    private Date finalDate;

    private Image finalImage;

    private Double finalValue;

    private Double finalXValue;

    private String id;

    private String initialCategory;

    private Date initialDate;

    private Image initialImage;

    private Double initialValue;

    private Double initialXValue;

    private Boolean isProtected;

    private Double lineAlpha;

    private Color lineColor;

    private Integer lineThickness;

    private String valueAxis;

    private String valueAxisX;

    public Integer getDashLength() {
        return dashLength;
    }

    public TrendLine setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
        return this;
    }

    public String getFinalCategory() {
        return finalCategory;
    }

    public TrendLine setFinalCategory(String finalCategory) {
        this.finalCategory = finalCategory;
        return this;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public TrendLine setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
        return this;
    }

    public Double getFinalValue() {
        return finalValue;
    }

    public TrendLine setFinalValue(Double finalValue) {
        this.finalValue = finalValue;
        return this;
    }

    public Double getFinalXValue() {
        return finalXValue;
    }

    public TrendLine setFinalXValue(Double finalXValue) {
        this.finalXValue = finalXValue;
        return this;
    }

    public String getInitialCategory() {
        return initialCategory;
    }

    public TrendLine setInitialCategory(String initialCategory) {
        this.initialCategory = initialCategory;
        return this;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public TrendLine setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
        return this;
    }

    public Double getInitialValue() {
        return initialValue;
    }

    public TrendLine setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
        return this;
    }

    public Double getInitialXValue() {
        return initialXValue;
    }

    public TrendLine setInitialXValue(Double initialXValue) {
        this.initialXValue = initialXValue;
        return this;
    }

    public Boolean getProtected() {
        return isProtected;
    }

    public TrendLine setProtected(Boolean aProtected) {
        isProtected = aProtected;
        return this;
    }

    public Double getLineAlpha() {
        return lineAlpha;
    }

    public TrendLine setLineAlpha(Double lineAlpha) {
        this.lineAlpha = lineAlpha;
        return this;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public TrendLine setLineColor(Color lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    public Integer getLineThickness() {
        return lineThickness;
    }

    public TrendLine setLineThickness(Integer lineThickness) {
        this.lineThickness = lineThickness;
        return this;
    }

    public String getValueAxis() {
        return valueAxis;
    }

    public TrendLine setValueAxis(String valueAxis) {
        this.valueAxis = valueAxis;
        return this;
    }

    public String getValueAxisX() {
        return valueAxisX;
    }

    public TrendLine setValueAxisX(String valueAxisX) {
        this.valueAxisX = valueAxisX;
        return this;
    }

    public String getId() {
        return id;
    }

    public TrendLine setId(String id) {
        this.id = id;
        return this;
    }

    public Image getFinalImage() {
        return finalImage;
    }

    public TrendLine setFinalImage(Image finalImage) {
        this.finalImage = finalImage;
        return this;
    }

    public Image getInitialImage() {
        return initialImage;
    }

    public TrendLine setInitialImage(Image initialImage) {
        this.initialImage = initialImage;
        return this;
    }
}