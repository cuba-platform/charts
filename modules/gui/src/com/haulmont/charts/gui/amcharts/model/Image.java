/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author gorelov
 * @version $Id$
 */
public class Image extends AbstractChartObject {

    private static final long serialVersionUID = -1259965238248274458L;
    
    private Color balloonColor;
    private String balloonText;
    private Color color;
    private Integer height;
    private Integer offsetX;
    private Integer offsetY;
    private Color outlineColor;
    private Integer rotation;
    private String svgPath;
    private String url;
    private Integer width;

    public Color getBalloonColor() {
        return balloonColor;
    }

    public Image setBalloonColor(Color balloonColor) {
        this.balloonColor = balloonColor;
        return this;
    }

    public String getBalloonText() {
        return balloonText;
    }

    public Image setBalloonText(String balloonText) {
        this.balloonText = balloonText;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Image setColor(Color color) {
        this.color = color;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Image setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getOffsetX() {
        return offsetX;
    }

    public Image setOffsetX(Integer offsetX) {
        this.offsetX = offsetX;
        return this;
    }

    public Integer getOffsetY() {
        return offsetY;
    }

    public Image setOffsetY(Integer offsetY) {
        this.offsetY = offsetY;
        return this;
    }

    public Color getOutlineColor() {
        return outlineColor;
    }

    public Image setOutlineColor(Color outlineColor) {
        this.outlineColor = outlineColor;
        return this;
    }

    public Integer getRotation() {
        return rotation;
    }

    public Image setRotation(Integer rotation) {
        this.rotation = rotation;
        return this;
    }

    public String getSvgPath() {
        return svgPath;
    }

    public Image setSvgPath(String svgPath) {
        this.svgPath = svgPath;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Image setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Image setWidth(Integer width) {
        this.width = width;
        return this;
    }
}
