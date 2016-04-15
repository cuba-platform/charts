/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of AmBalloon JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmBalloon">http://docs.amcharts.com/3/javascriptcharts/AmBalloon</a>
 *
 */
public class Balloon extends AbstractChartObject {

    private static final long serialVersionUID = -4143720120608274912L;

    private Boolean adjustBorderColor;

    private Double animationDuration;

    private Double borderAlpha;

    private Color borderColor;

    private Integer borderThickness;

    private Color color;

    private Integer cornerRadius;

    private Boolean disableMouseEvents;

    private Boolean drop;

    private Boolean enabled;

    private Double fadeOutDuration;

    private Double fillAlpha;

    private Color fillColor;

    private Boolean fixedPosition;

    private Integer fontSize;

    private Integer horizontalPadding;

    private Integer maxWidth;

    private Integer offsetX;

    private Integer offsetY;

    private PointerOrientation pointerOrientation;

    private Integer pointerWidth;

    private Double shadowAlpha;

    private Color shadowColor;

    private Boolean showBullet;

    private Align textAlign;

    private Integer verticalPadding;

    public Boolean getAdjustBorderColor() {
        return adjustBorderColor;
    }

    public Balloon setAdjustBorderColor(Boolean adjustBorderColor) {
        this.adjustBorderColor = adjustBorderColor;
        return this;
    }

    public Double getAnimationDuration() {
        return animationDuration;
    }

    public Balloon setAnimationDuration(Double animationDuration) {
        this.animationDuration = animationDuration;
        return this;
    }

    public Double getBorderAlpha() {
        return borderAlpha;
    }

    public Balloon setBorderAlpha(Double borderAlpha) {
        this.borderAlpha = borderAlpha;
        return this;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public Balloon setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public Integer getBorderThickness() {
        return borderThickness;
    }

    public Balloon setBorderThickness(Integer borderThickness) {
        this.borderThickness = borderThickness;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Balloon setColor(Color color) {
        this.color = color;
        return this;
    }

    public Integer getCornerRadius() {
        return cornerRadius;
    }

    public Balloon setCornerRadius(Integer cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    public Double getFadeOutDuration() {
        return fadeOutDuration;
    }

    public Balloon setFadeOutDuration(Double fadeOutDuration) {
        this.fadeOutDuration = fadeOutDuration;
        return this;
    }

    public Double getFillAlpha() {
        return fillAlpha;
    }

    public Balloon setFillAlpha(Double fillAlpha) {
        this.fillAlpha = fillAlpha;
        return this;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public Balloon setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    public Boolean getFixedPosition() {
        return fixedPosition;
    }

    public Balloon setFixedPosition(Boolean fixedPosition) {
        this.fixedPosition = fixedPosition;
        return this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public Balloon setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public Integer getHorizontalPadding() {
        return horizontalPadding;
    }

    public Balloon setHorizontalPadding(Integer horizontalPadding) {
        this.horizontalPadding = horizontalPadding;
        return this;
    }

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public Balloon setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    public Integer getOffsetX() {
        return offsetX;
    }

    public Balloon setOffsetX(Integer offsetX) {
        this.offsetX = offsetX;
        return this;
    }

    public Integer getOffsetY() {
        return offsetY;
    }

    public Balloon setOffsetY(Integer offsetY) {
        this.offsetY = offsetY;
        return this;
    }

    public Integer getPointerWidth() {
        return pointerWidth;
    }

    public Balloon setPointerWidth(Integer pointerWidth) {
        this.pointerWidth = pointerWidth;
        return this;
    }

    public Double getShadowAlpha() {
        return shadowAlpha;
    }

    public Balloon setShadowAlpha(Double shadowAlpha) {
        this.shadowAlpha = shadowAlpha;
        return this;
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public Balloon setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        return this;
    }

    public Boolean getShowBullet() {
        return showBullet;
    }

    public Balloon setShowBullet(Boolean showBullet) {
        this.showBullet = showBullet;
        return this;
    }

    public Align getTextAlign() {
        return textAlign;
    }

    public Balloon setTextAlign(Align textAlign) {
        this.textAlign = textAlign;
        return this;
    }

    public Integer getVerticalPadding() {
        return verticalPadding;
    }

    public Balloon setVerticalPadding(Integer verticalPadding) {
        this.verticalPadding = verticalPadding;
        return this;
    }

    public Boolean getDisableMouseEvents() {
        return disableMouseEvents;
    }

    public Balloon setDisableMouseEvents(Boolean disableMouseEvents) {
        this.disableMouseEvents = disableMouseEvents;
        return this;
    }

    public Boolean getDrop() {
        return drop;
    }

    public Balloon setDrop(Boolean drop) {
        this.drop = drop;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Balloon setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public PointerOrientation getPointerOrientation() {
        return pointerOrientation;
    }

    public Balloon setPointerOrientation(PointerOrientation pointerOrientation) {
        this.pointerOrientation = pointerOrientation;
        return this;
    }
}