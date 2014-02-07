/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public class ExportMenuItemStyle extends AbstractConfigurationObject {

    private static final long serialVersionUID = -6355378969970590428L;

    private Color backgroundColor;

    private Color rollOverBackgroundColor;

    private Color color;

    private Color rollOverColor;

    private String paddingTop;

    private String paddingRight;

    private String paddingBottom;

    private String paddingLeft;

    private String marginTop;

    private String marginRight;

    private String marginBottom;

    private String marginLeft;

    private Align textAlign;

    private String textDecoration;

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public ExportMenuItemStyle setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public ExportMenuItemStyle setColor(Color color) {
        this.color = color;
        return this;
    }

    public String getMarginBottom() {
        return marginBottom;
    }

    public ExportMenuItemStyle setMarginBottom(String marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public String getMarginLeft() {
        return marginLeft;
    }

    public ExportMenuItemStyle setMarginLeft(String marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public String getMarginRight() {
        return marginRight;
    }

    public ExportMenuItemStyle setMarginRight(String marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    public String getMarginTop() {
        return marginTop;
    }

    public ExportMenuItemStyle setMarginTop(String marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public String getPaddingBottom() {
        return paddingBottom;
    }

    public ExportMenuItemStyle setPaddingBottom(String paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    public String getPaddingLeft() {
        return paddingLeft;
    }

    public ExportMenuItemStyle setPaddingLeft(String paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public String getPaddingRight() {
        return paddingRight;
    }

    public ExportMenuItemStyle setPaddingRight(String paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public String getPaddingTop() {
        return paddingTop;
    }

    public ExportMenuItemStyle setPaddingTop(String paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    public Color getRollOverBackgroundColor() {
        return rollOverBackgroundColor;
    }

    public ExportMenuItemStyle setRollOverBackgroundColor(Color rollOverBackgroundColor) {
        this.rollOverBackgroundColor = rollOverBackgroundColor;
        return this;
    }

    public Color getRollOverColor() {
        return rollOverColor;
    }

    public ExportMenuItemStyle setRollOverColor(Color rollOverColor) {
        this.rollOverColor = rollOverColor;
        return this;
    }

    public Align getTextAlign() {
        return textAlign;
    }

    public ExportMenuItemStyle setTextAlign(Align textAlign) {
        this.textAlign = textAlign;
        return this;
    }

    public String getTextDecoration() {
        return textDecoration;
    }

    public ExportMenuItemStyle setTextDecoration(String textDecoration) {
        this.textDecoration = textDecoration;
        return this;
    }
}