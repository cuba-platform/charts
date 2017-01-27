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

    public Double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    public StockEventsSettings setBackgroundAlpha(Double backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public StockEventsSettings setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Color getBalloonColor() {
        return balloonColor;
    }

    public StockEventsSettings setBalloonColor(Color balloonColor) {
        this.balloonColor = balloonColor;
        return this;
    }

    public Double getBorderAlpha() {
        return borderAlpha;
    }

    public StockEventsSettings setBorderAlpha(Double borderAlpha) {
        this.borderAlpha = borderAlpha;
        return this;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public StockEventsSettings setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public Color getRollOverColor() {
        return rollOverColor;
    }

    public StockEventsSettings setRollOverColor(Color rollOverColor) {
        this.rollOverColor = rollOverColor;
        return this;
    }

    public String getShowAt() {
        return showAt;
    }

    public StockEventsSettings setShowAt(String showAt) {
        this.showAt = showAt;
        return this;
    }

    public StockEventType getType() {
        return type;
    }

    public StockEventsSettings setType(StockEventType type) {
        this.type = type;
        return this;
    }
}
