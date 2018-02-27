/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of StockEventsSettings JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/StockEventsSettings">http://docs.amcharts.com/3/javascriptstockchart/StockEventsSettings</a>
 */
public class StockEventsSettings extends AbstractChartObject {

    private static final long serialVersionUID = 6413770909562353029L;
    
    private Double backgroundAlpha;

    private Color backgroundColor;

    private Color balloonColor;

    private Double borderAlpha;

    private Color borderColor;

    private Color rollOverColor;

    private String showAt;

    private StockEventType type;

    /**
     * @return opacity of bullet background
     */
    public Double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    /**
     * Sets opacity of bullet background.
     *
     * @param backgroundAlpha opacity
     */
    public StockEventsSettings setBackgroundAlpha(Double backgroundAlpha) {
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
     * Sets color of bullet background.
     *
     * @param backgroundColor color
     */
    public StockEventsSettings setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * @return color for a roll-over balloon
     */
    public Color getBalloonColor() {
        return balloonColor;
    }

    /**
     * Sets color for a roll-over balloon.
     *
     * @param balloonColor balloon color
     */
    public StockEventsSettings setBalloonColor(Color balloonColor) {
        this.balloonColor = balloonColor;
        return this;
    }

    /**
     * @return opacity of bullet border
     */
    public Double getBorderAlpha() {
        return borderAlpha;
    }

    /**
     * Sets opacity of bullet border.
     *
     * @param borderAlpha opacity
     */
    public StockEventsSettings setBorderAlpha(Double borderAlpha) {
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
     * Sets bullet border color.
     *
     * @param borderColor color
     */
    public StockEventsSettings setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * @return roll-over background color
     */
    public Color getRollOverColor() {
        return rollOverColor;
    }

    /**
     * Sets roll-over background color.
     *
     * @param rollOverColor color
     */
    public StockEventsSettings setRollOverColor(Color rollOverColor) {
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
    public StockEventsSettings setShowAt(String showAt) {
        this.showAt = showAt;
        return this;
    }

    /**
     * @return type of bullet
     */
    public StockEventType getType() {
        return type;
    }

    /**
     * Sets type of bullet.
     *
     * @param type type
     */
    public StockEventsSettings setType(StockEventType type) {
        this.type = type;
        return this;
    }
}
