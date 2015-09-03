/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of ChartCursor JS Object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/ChartCursor">http://docs.amcharts.com/3/javascriptcharts/ChartCursor</a>
 *
 * @author artamonov
 * @version $Id$
 */
public class Cursor extends AbstractConfigurationObject {

    private static final long serialVersionUID = 4196605135301917493L;

    private Integer adjustment;

    private Double animationDuration;

    private Boolean avoidBalloonOverlapping;

    private String balloonPointerOrientation;

    private Boolean bulletsEnabled;

    private Integer bulletSize;

    private Double categoryBalloonAlpha;

    private Color categoryBalloonColor;

    private String categoryBalloonDateFormat;

    private Boolean categoryBalloonEnabled;

    private JsFunction categoryBalloonFunction;

    private String categoryBalloonText;

    private Color color;

    private Double cursorAlpha;

    private Color cursorColor;

    private CursorPosition cursorPosition;

    private Boolean enabled;

    private Boolean fullWidth;

    private Double graphBulletAlpha;

    private Double graphBulletSize;

    private Boolean leaveAfterTouch;

    private Boolean leaveCursor;

    private Boolean oneBalloonOnly;

    private Boolean pan;

    private Double selectionAlpha;

    private Boolean selectWithoutZooming;

    private Boolean showNextAvailable;

    private Boolean valueBalloonsEnabled;

    private Double valueLineAlpha;

    private String valueLineAxis;

    private Boolean valueLineBalloonEnabled;

    private Boolean valueLineEnabled;

    private Boolean zoomable;
    
    private Boolean zooming;

    public Integer getAdjustment() {
        return adjustment;
    }

    public Cursor setAdjustment(Integer adjustment) {
        this.adjustment = adjustment;
        return this;
    }

    public Boolean getAvoidBalloonOverlapping() {
        return avoidBalloonOverlapping;
    }

    public Cursor setAvoidBalloonOverlapping(Boolean avoidBalloonOverlapping) {
        this.avoidBalloonOverlapping = avoidBalloonOverlapping;
        return this;
    }

    public String getBalloonPointerOrientation() {
        return balloonPointerOrientation;
    }

    public Cursor setBalloonPointerOrientation(String balloonPointerOrientation) {
        this.balloonPointerOrientation = balloonPointerOrientation;
        return this;
    }

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

    public Boolean getFullWidth() {
        return fullWidth;
    }

    public Cursor setFullWidth(Boolean fullWidth) {
        this.fullWidth = fullWidth;
        return this;
    }

    public Double getGraphBulletAlpha() {
        return graphBulletAlpha;
    }

    public Cursor setGraphBulletAlpha(Double graphBulletAlpha) {
        this.graphBulletAlpha = graphBulletAlpha;
        return this;
    }

    public Double getValueLineAlpha() {
        return valueLineAlpha;
    }

    public Cursor setValueLineAlpha(Double valueLineAlpha) {
        this.valueLineAlpha = valueLineAlpha;
        return this;
    }

    public String getValueLineAxis() {
        return valueLineAxis;
    }

    public Cursor setValueLineAxis(String valueLineAxis) {
        this.valueLineAxis = valueLineAxis;
        return this;
    }

    public Boolean getValueLineBalloonEnabled() {
        return valueLineBalloonEnabled;
    }

    public Cursor setValueLineBalloonEnabled(Boolean valueLineBalloonEnabled) {
        this.valueLineBalloonEnabled = valueLineBalloonEnabled;
        return this;
    }

    public Boolean getValueLineEnabled() {
        return valueLineEnabled;
    }

    public Cursor setValueLineEnabled(Boolean valueLineEnabled) {
        this.valueLineEnabled = valueLineEnabled;
        return this;
    }

    public String getCategoryBalloonText() {
        return categoryBalloonText;
    }

    public Cursor setCategoryBalloonText(String categoryBalloonText) {
        this.categoryBalloonText = categoryBalloonText;
        return this;
    }

    public Boolean getLeaveAfterTouch() {
        return leaveAfterTouch;
    }

    public Cursor setLeaveAfterTouch(Boolean leaveAfterTouch) {
        this.leaveAfterTouch = leaveAfterTouch;
        return this;
    }

    public Boolean getLeaveCursor() {
        return leaveCursor;
    }

    public Cursor setLeaveCursor(Boolean leaveCursor) {
        this.leaveCursor = leaveCursor;
        return this;
    }

    public Boolean getZooming() {
        return zooming;
    }

    public Cursor setZooming(Boolean zooming) {
        this.zooming = zooming;
        return this;
    }
}