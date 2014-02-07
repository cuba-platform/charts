/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of ChartCursor JS Object.
 *
 * @author artamonov
 * @version $Id$
 */
public class Cursor extends AbstractConfigurationObject {

    private static final long serialVersionUID = 4196605135301917493L;

    private Double animationDuration;

    private Boolean bulletsEnabled;

    private Integer bulletSize;

    private Double categoryBalloonAlpha;

    private Color categoryBalloonColor;

    private String categoryBalloonDateFormat;

    private Boolean categoryBalloonEnabled;

    private JsFunction categoryBalloonFunction;

    private Color color;

    private Double cursorAlpha;

    private Color cursorColor;

    private CursorPosition cursorPosition;

    private Boolean enabled;

    private Double graphBulletSize;

    private Boolean oneBalloonOnly;

    private Boolean pan;

    private Double selectionAlpha;

    private Boolean selectWithoutZooming;

    private Boolean showNextAvailable;

    private Boolean valueBalloonsEnabled;

    private Boolean zoomable;

    public Double getAnimationDuration() {
        return animationDuration;
    }

    public Cursor setAnimationDuration(Double animationDuration) {
        this.animationDuration = animationDuration;
        return this;
    }

    public Boolean getBulletsEnabled() {
        return bulletsEnabled;
    }

    public Cursor setBulletsEnabled(Boolean bulletsEnabled) {
        this.bulletsEnabled = bulletsEnabled;
        return this;
    }

    public Integer getBulletSize() {
        return bulletSize;
    }

    public Cursor setBulletSize(Integer bulletSize) {
        this.bulletSize = bulletSize;
        return this;
    }

    public Double getCategoryBalloonAlpha() {
        return categoryBalloonAlpha;
    }

    public Cursor setCategoryBalloonAlpha(Double categoryBalloonAlpha) {
        this.categoryBalloonAlpha = categoryBalloonAlpha;
        return this;
    }

    public Color getCategoryBalloonColor() {
        return categoryBalloonColor;
    }

    public Cursor setCategoryBalloonColor(Color categoryBalloonColor) {
        this.categoryBalloonColor = categoryBalloonColor;
        return this;
    }

    public String getCategoryBalloonDateFormat() {
        return categoryBalloonDateFormat;
    }

    public Cursor setCategoryBalloonDateFormat(String categoryBalloonDateFormat) {
        this.categoryBalloonDateFormat = categoryBalloonDateFormat;
        return this;
    }

    public Boolean getCategoryBalloonEnabled() {
        return categoryBalloonEnabled;
    }

    public Cursor setCategoryBalloonEnabled(Boolean categoryBalloonEnabled) {
        this.categoryBalloonEnabled = categoryBalloonEnabled;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Cursor setColor(Color color) {
        this.color = color;
        return this;
    }

    public Double getCursorAlpha() {
        return cursorAlpha;
    }

    public Cursor setCursorAlpha(Double cursorAlpha) {
        this.cursorAlpha = cursorAlpha;
        return this;
    }

    public Color getCursorColor() {
        return cursorColor;
    }

    public Cursor setCursorColor(Color cursorColor) {
        this.cursorColor = cursorColor;
        return this;
    }

    public CursorPosition getCursorPosition() {
        return cursorPosition;
    }

    public Cursor setCursorPosition(CursorPosition cursorPosition) {
        this.cursorPosition = cursorPosition;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Cursor setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Double getGraphBulletSize() {
        return graphBulletSize;
    }

    public Cursor setGraphBulletSize(Double graphBulletSize) {
        this.graphBulletSize = graphBulletSize;
        return this;
    }

    public Boolean getOneBalloonOnly() {
        return oneBalloonOnly;
    }

    public Cursor setOneBalloonOnly(Boolean oneBalloonOnly) {
        this.oneBalloonOnly = oneBalloonOnly;
        return this;
    }

    public Boolean getPan() {
        return pan;
    }

    public Cursor setPan(Boolean pan) {
        this.pan = pan;
        return this;
    }

    public Double getSelectionAlpha() {
        return selectionAlpha;
    }

    public Cursor setSelectionAlpha(Double selectionAlpha) {
        this.selectionAlpha = selectionAlpha;
        return this;
    }

    public Boolean getSelectWithoutZooming() {
        return selectWithoutZooming;
    }

    public Cursor setSelectWithoutZooming(Boolean selectWithoutZooming) {
        this.selectWithoutZooming = selectWithoutZooming;
        return this;
    }

    public Boolean getShowNextAvailable() {
        return showNextAvailable;
    }

    public Cursor setShowNextAvailable(Boolean showNextAvailable) {
        this.showNextAvailable = showNextAvailable;
        return this;
    }

    public Boolean getValueBalloonsEnabled() {
        return valueBalloonsEnabled;
    }

    public Cursor setValueBalloonsEnabled(Boolean valueBalloonsEnabled) {
        this.valueBalloonsEnabled = valueBalloonsEnabled;
        return this;
    }

    public Boolean getZoomable() {
        return zoomable;
    }

    public Cursor setZoomable(Boolean zoomable) {
        this.zoomable = zoomable;
        return this;
    }

    public JsFunction getCategoryBalloonFunction() {
        return categoryBalloonFunction;
    }

    public Cursor setCategoryBalloonFunction(JsFunction categoryBalloonFunction) {
        this.categoryBalloonFunction = categoryBalloonFunction;
        return this;
    }
}