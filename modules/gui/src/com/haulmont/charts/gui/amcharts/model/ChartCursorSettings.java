/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of ChartCursorSettings JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/ChartCursorSettings">http://docs.amcharts.com/3/javascriptstockchart/ChartCursorSettings</a>
 *
 */
public class ChartCursorSettings extends AbstractChartObject {

    private static final long serialVersionUID = 3106275318894887204L;

    private BalloonPointerOrientation balloonPointerOrientation;

    private Boolean bulletsEnabled;

    private Integer bulletSize;

    private Double categoryBalloonAlpha;

    private Color categoryBalloonColor;

    private List<DateFormat> categoryBalloonDateFormats;

    private Boolean categoryBalloonEnabled;

    private String categoryBalloonText;

    private Double cursorAlpha;

    private Color cursorColor;

    private CursorPosition cursorPosition;

    private Boolean enabled;

    private Boolean fullWidth;

    private Double graphBulletSize;

    private Boolean leaveAfterTouch;

    private Boolean leaveCursor;

    private Boolean onePanelOnly;

    private Boolean pan;

    private Boolean valueBalloonsEnabled;

    private Double valueLineAlpha;

    private Boolean valueLineBalloonEnabled;

    private Boolean valueLineEnabled;

    private Boolean zoomable;

    public BalloonPointerOrientation getBalloonPointerOrientation() {
        return balloonPointerOrientation;
    }

    public ChartCursorSettings setBalloonPointerOrientation(BalloonPointerOrientation balloonPointerOrientation) {
        this.balloonPointerOrientation = balloonPointerOrientation;
        return this;
    }

    public Boolean getBulletsEnabled() {
        return bulletsEnabled;
    }

    public ChartCursorSettings setBulletsEnabled(Boolean bulletsEnabled) {
        this.bulletsEnabled = bulletsEnabled;
        return this;
    }

    public Integer getBulletSize() {
        return bulletSize;
    }

    public ChartCursorSettings setBulletSize(Integer bulletSize) {
        this.bulletSize = bulletSize;
        return this;
    }

    public Double getCategoryBalloonAlpha() {
        return categoryBalloonAlpha;
    }

    public ChartCursorSettings setCategoryBalloonAlpha(Double categoryBalloonAlpha) {
        this.categoryBalloonAlpha = categoryBalloonAlpha;
        return this;
    }

    public Color getCategoryBalloonColor() {
        return categoryBalloonColor;
    }

    public ChartCursorSettings setCategoryBalloonColor(Color categoryBalloonColor) {
        this.categoryBalloonColor = categoryBalloonColor;
        return this;
    }

    public List<DateFormat> getCategoryBalloonDateFormats() {
        return categoryBalloonDateFormats;
    }

    public ChartCursorSettings setCategoryBalloonDateFormats(List<DateFormat> categoryBalloonDateFormats) {
        this.categoryBalloonDateFormats = categoryBalloonDateFormats;
        return this;
    }

    public ChartCursorSettings addCategoryBalloonDateFormats(DateFormat... categoryBalloonDateFormats) {
        if (categoryBalloonDateFormats != null) {
            if (this.categoryBalloonDateFormats == null) {
                this.categoryBalloonDateFormats = new ArrayList<>();
            }
            this.categoryBalloonDateFormats.addAll(Arrays.asList(categoryBalloonDateFormats));
        }
        return this;
    }

    public Boolean getCategoryBalloonEnabled() {
        return categoryBalloonEnabled;
    }

    public ChartCursorSettings setCategoryBalloonEnabled(Boolean categoryBalloonEnabled) {
        this.categoryBalloonEnabled = categoryBalloonEnabled;
        return this;
    }

    public String getCategoryBalloonText() {
        return categoryBalloonText;
    }

    public ChartCursorSettings setCategoryBalloonText(String categoryBalloonText) {
        this.categoryBalloonText = categoryBalloonText;
        return this;
    }

    public Double getCursorAlpha() {
        return cursorAlpha;
    }

    public ChartCursorSettings setCursorAlpha(Double cursorAlpha) {
        this.cursorAlpha = cursorAlpha;
        return this;
    }

    public Color getCursorColor() {
        return cursorColor;
    }

    public ChartCursorSettings setCursorColor(Color cursorColor) {
        this.cursorColor = cursorColor;
        return this;
    }

    public CursorPosition getCursorPosition() {
        return cursorPosition;
    }

    public ChartCursorSettings setCursorPosition(CursorPosition cursorPosition) {
        this.cursorPosition = cursorPosition;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public ChartCursorSettings setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getFullWidth() {
        return fullWidth;
    }

    public ChartCursorSettings setFullWidth(Boolean fullWidth) {
        this.fullWidth = fullWidth;
        return this;
    }

    public Double getGraphBulletSize() {
        return graphBulletSize;
    }

    public ChartCursorSettings setGraphBulletSize(Double graphBulletSize) {
        this.graphBulletSize = graphBulletSize;
        return this;
    }

    public Boolean getLeaveAfterTouch() {
        return leaveAfterTouch;
    }

    public ChartCursorSettings setLeaveAfterTouch(Boolean leaveAfterTouch) {
        this.leaveAfterTouch = leaveAfterTouch;
        return this;
    }

    public Boolean getLeaveCursor() {
        return leaveCursor;
    }

    public ChartCursorSettings setLeaveCursor(Boolean leaveCursor) {
        this.leaveCursor = leaveCursor;
        return this;
    }

    public Boolean getOnePanelOnly() {
        return onePanelOnly;
    }

    public ChartCursorSettings setOnePanelOnly(Boolean onePanelOnly) {
        this.onePanelOnly = onePanelOnly;
        return this;
    }

    public Boolean getPan() {
        return pan;
    }

    public ChartCursorSettings setPan(Boolean pan) {
        this.pan = pan;
        return this;
    }

    public Boolean getValueBalloonsEnabled() {
        return valueBalloonsEnabled;
    }

    public ChartCursorSettings setValueBalloonsEnabled(Boolean valueBalloonsEnabled) {
        this.valueBalloonsEnabled = valueBalloonsEnabled;
        return this;
    }

    public Double getValueLineAlpha() {
        return valueLineAlpha;
    }

    public ChartCursorSettings setValueLineAlpha(Double valueLineAlpha) {
        this.valueLineAlpha = valueLineAlpha;
        return this;
    }

    public Boolean getValueLineBalloonEnabled() {
        return valueLineBalloonEnabled;
    }

    public ChartCursorSettings setValueLineBalloonEnabled(Boolean valueLineBalloonEnabled) {
        this.valueLineBalloonEnabled = valueLineBalloonEnabled;
        return this;
    }

    public Boolean getValueLineEnabled() {
        return valueLineEnabled;
    }

    public ChartCursorSettings setValueLineEnabled(Boolean valueLineEnabled) {
        this.valueLineEnabled = valueLineEnabled;
        return this;
    }

    public Boolean getZoomable() {
        return zoomable;
    }

    public ChartCursorSettings setZoomable(Boolean zoomable) {
        this.zoomable = zoomable;
        return this;
    }
}
