/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of AmBalloon JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmBalloon">http://docs.amcharts.com/3/javascriptcharts/AmBalloon</a>
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

    /**
     * @return true if border color will be changed when user rolls-over the slice, graph, etc instead of background
     * color
     */
    public Boolean getAdjustBorderColor() {
        return adjustBorderColor;
    }

    /**
     * Set adjustBorderColor to true if you want that the border color will be changed when user rolls-over the
     * slice, graph, etc instead of background color
     *
     * @param adjustBorderColor adjust border color option
     */
    public Balloon setAdjustBorderColor(Boolean adjustBorderColor) {
        this.adjustBorderColor = adjustBorderColor;
        return this;
    }

    /**
     * @return animation duration in seconds
     */
    public Double getAnimationDuration() {
        return animationDuration;
    }

    /**
     * Sets duration of balloon movement from previous point to current point, in seconds.
     *
     * @param animationDuration animation duration in seconds
     */
    public Balloon setAnimationDuration(Double animationDuration) {
        this.animationDuration = animationDuration;
        return this;
    }

    /**
     * @return border opacity
     */
    public Double getBorderAlpha() {
        return borderAlpha;
    }

    /**
     * Sets balloon border opacity. Value range is 0 - 1.
     *
     * @param borderAlpha border opacity
     */
    public Balloon setBorderAlpha(Double borderAlpha) {
        this.borderAlpha = borderAlpha;
        return this;
    }

    /**
     * @return border color
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * Sets balloon border color. Will only be used of adjustBorderColor is false.
     *
     * @param borderColor border color
     */
    public Balloon setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * @return border thickness
     */
    public Integer getBorderThickness() {
        return borderThickness;
    }

    /**
     * Sets balloon border thickness.
     *
     * @param borderThickness border thickness
     */
    public Balloon setBorderThickness(Integer borderThickness) {
        this.borderThickness = borderThickness;
        return this;
    }

    /**
     * @return color of text
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color of text in the balloon.
     *
     * @param color color of the text
     */
    public Balloon setColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * @return balloon corner radius
     */
    public Integer getCornerRadius() {
        return cornerRadius;
    }

    /**
     * Sets balloon corner radius.
     *
     * @param cornerRadius corner radius
     */
    public Balloon setCornerRadius(Integer cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    /**
     * @return duration of a fade out animation, in seconds
     */
    public Double getFadeOutDuration() {
        return fadeOutDuration;
    }

    /**
     * Sets duration of a fade out animation, in seconds.
     *
     * @param fadeOutDuration duration in seconds
     */
    public Balloon setFadeOutDuration(Double fadeOutDuration) {
        this.fadeOutDuration = fadeOutDuration;
        return this;
    }

    /**
     * @return background opacity
     */
    public Double getFillAlpha() {
        return fillAlpha;
    }

    /**
     * Sets balloon background opacity.
     *
     * @param fillAlpha background opacity
     */
    public Balloon setFillAlpha(Double fillAlpha) {
        this.fillAlpha = fillAlpha;
        return this;
    }

    /**
     * @return background color
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Sets balloon background color. Usually balloon background color is set by the chart. Only if adjustBorderColor
     * is true this color will be used.
     *
     * @param fillColor background color
     */
    public Balloon setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    /**
     * @return true if balloon stays in fixed position; false if follows mouse when hovering the slice/column/bullet
     */
    public Boolean getFixedPosition() {
        return fixedPosition;
    }

    /**
     * Specifies if balloon should follow mouse when hovering the slice/column/bullet or stay in fixed position
     * (this does not affect balloon behavior if ChartCursor is used).
     *
     * @param fixedPosition fixed position option
     */
    public Balloon setFixedPosition(Boolean fixedPosition) {
        this.fixedPosition = fixedPosition;
        return this;
    }

    /**
     * @return size of text in the balloon
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * Sets size of text in the balloon. Chart's fontSize is used by default.
     *
     * @param fontSize font size
     */
    public Balloon setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * @return horizontal padding
     */
    public Integer getHorizontalPadding() {
        return horizontalPadding;
    }

    /**
     * Sets horizontal padding of the balloon.
     *
     * @param horizontalPadding horizontal padding
     */
    public Balloon setHorizontalPadding(Integer horizontalPadding) {
        this.horizontalPadding = horizontalPadding;
        return this;
    }

    /**
     * @return maximum width
     */
    public Integer getMaxWidth() {
        return maxWidth;
    }

    /**
     * Sets maximum width of a balloon.
     *
     * @param maxWidth maximum width
     */
    public Balloon setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    /**
     * @return horizontal distance from mouse pointer to balloon pointer
     */
    public Integer getOffsetX() {
        return offsetX;
    }

    /**
     * Sets horizontal distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon might
     * flicker, as mouse might lose focus on hovered object. Note, this setting is ignored unless fixedPosition is set
     * to false or Chart Cursor is enabled.
     *
     * @param offsetX horizontal distance from mouse pointer to balloon pointer
     */
    public Balloon setOffsetX(Integer offsetX) {
        this.offsetX = offsetX;
        return this;
    }

    /**
     * @return vertical distance from mouse pointer to balloon pointer
     */
    public Integer getOffsetY() {
        return offsetY;
    }

    /**
     * Sets vertical distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon might
     * flicker, as mouse might lose focus on hovered object. Note, this setting is ignored unless fixedPosition is set
     * to false or Chart Cursor is enabled.
     *
     * @param offsetY vertical distance from mouse pointer to balloon pointer
     */
    public Balloon setOffsetY(Integer offsetY) {
        this.offsetY = offsetY;
        return this;
    }

    /**
     * @return pointer width
     */
    public Integer getPointerWidth() {
        return pointerWidth;
    }

    /**
     * Specifies direction of a pointer. Works only if balloon drop set to true.
     *
     * @param pointerWidth pointer width
     */
    public Balloon setPointerWidth(Integer pointerWidth) {
        this.pointerWidth = pointerWidth;
        return this;
    }

    /**
     * @return opacity of a shadow
     */
    public Double getShadowAlpha() {
        return shadowAlpha;
    }

    /**
     * Sets opacity of a shadow.
     *
     * @param shadowAlpha opacity of a shadow
     */
    public Balloon setShadowAlpha(Double shadowAlpha) {
        this.shadowAlpha = shadowAlpha;
        return this;
    }

    /**
     * @return shadow color
     */
    public Color getShadowColor() {
        return shadowColor;
    }

    /**
     * Sets color of a shadow.
     *
     * @param shadowColor shadow color
     */
    public Balloon setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        return this;
    }

    /**
     * @return true if showBullet is enabled
     */
    public Boolean getShowBullet() {
        return showBullet;
    }

    /**
     * If cornerRadius of a balloon is greater than 0, showBullet is set to true for value balloons when {@link Cursor}
     * is used. If you don't want the bullet near the balloon, set it to false
     *
     * @param showBullet show bullet option
     */
    public Balloon setShowBullet(Boolean showBullet) {
        this.showBullet = showBullet;
        return this;
    }

    /**
     * @return text alignment
     */
    public Align getTextAlign() {
        return textAlign;
    }

    /**
     * Sets text alignment, possible values "left", "middle" and "right".
     *
     * @param textAlign text alignment
     */
    public Balloon setTextAlign(Align textAlign) {
        this.textAlign = textAlign;
        return this;
    }

    /**
     * @return vertical padding
     */
    public Integer getVerticalPadding() {
        return verticalPadding;
    }

    /**
     * Sets vertical padding of the balloon.
     *
     * @param verticalPadding vertical padding
     */
    public Balloon setVerticalPadding(Integer verticalPadding) {
        this.verticalPadding = verticalPadding;
        return this;
    }

    /**
     * @return true if links in the balloon text is not clickable
     */
    public Boolean getDisableMouseEvents() {
        return disableMouseEvents;
    }

    /**
     * Set disableMouseEvents to false if your balloon has links and you want those links to be clickable.
     *
     * @param disableMouseEvents disable mouse eventes option
     */
    public Balloon setDisableMouseEvents(Boolean disableMouseEvents) {
        this.disableMouseEvents = disableMouseEvents;
        return this;
    }

    /**
     * @return true if drop is enabled
     */
    public Boolean getDrop() {
        return drop;
    }

    /**
     * Allows having drop-shaped balloons. Note, these balloons will not check for overlapping with other balloons,
     * or if they go outside plot area. It also does not change pointer orientation automatically based on its
     * vertical position like regular balloons do. You can use pointerOrientation property if you want it to point to
     * different direction. Not supported by IE8.
     *
     * @param drop drop option
     */
    public Balloon setDrop(Boolean drop) {
        this.drop = drop;
        return this;
    }

    /**
     * @return true if balloons are enabled for certain value axes
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Set enabled to false if you want to disable balloons for certain value axes.
     *
     * @param enabled enabled option
     */
    public Balloon setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * @return pointer orientation
     */
    public PointerOrientation getPointerOrientation() {
        return pointerOrientation;
    }

    /**
     * Specifies direction of a pointer. Works only if balloon drop set to true.
     *
     * @param pointerOrientation pointer orientation
     */
    public Balloon setPointerOrientation(PointerOrientation pointerOrientation) {
        this.pointerOrientation = pointerOrientation;
        return this;
    }
}