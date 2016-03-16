/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of LegendSettings JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/LegendSettings">http://docs.amcharts.com/3/javascriptstockchart/LegendSettings</a>
 *
 */
public class LegendSettings extends AbstractChartObject {

    private static final long serialVersionUID = 7958786618547667346L;

    private Align align;

    private Boolean equalWidths;

    private Integer horizontalGap;

    private String labelText;

    private Integer marginBottom;

    private Integer marginTop;

    private Double markerBorderAlpha;

    private Color markerBorderColor;

    private Integer markerBorderThickness;

    private Color markerDisabledColor;

    private Integer markerLabelGap;

    private Integer markerSize;

    private MarkerType markerType;

    private Boolean reversedOrder;

    private Color rollOverColor;

    private Double rollOverGraphAlpha;

    private Boolean switchable;

    private Color switchColor;

    private SwitchType switchType;

    private Boolean textClickEnabled;

    private Boolean useMarkerColorForLabels;

    private String valueTextComparing;

    private String valueTextRegular;

    private Integer valueWidth;

    private Integer verticalGap;

    public Align getAlign() {
        return align;
    }

    public LegendSettings setAlign(Align align) {
        this.align = align;
        return this;
    }

    public Boolean getEqualWidths() {
        return equalWidths;
    }

    public LegendSettings setEqualWidths(Boolean equalWidths) {
        this.equalWidths = equalWidths;
        return this;
    }

    public Integer getHorizontalGap() {
        return horizontalGap;
    }

    public LegendSettings setHorizontalGap(Integer horizontalGap) {
        this.horizontalGap = horizontalGap;
        return this;
    }

    public String getLabelText() {
        return labelText;
    }

    public LegendSettings setLabelText(String labelText) {
        this.labelText = labelText;
        return this;
    }

    public Integer getMarginBottom() {
        return marginBottom;
    }

    public LegendSettings setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public Integer getMarginTop() {
        return marginTop;
    }

    public LegendSettings setMarginTop(Integer marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public Double getMarkerBorderAlpha() {
        return markerBorderAlpha;
    }

    public LegendSettings setMarkerBorderAlpha(Double markerBorderAlpha) {
        this.markerBorderAlpha = markerBorderAlpha;
        return this;
    }

    public Color getMarkerBorderColor() {
        return markerBorderColor;
    }

    public LegendSettings setMarkerBorderColor(Color markerBorderColor) {
        this.markerBorderColor = markerBorderColor;
        return this;
    }

    public Integer getMarkerBorderThickness() {
        return markerBorderThickness;
    }

    public LegendSettings setMarkerBorderThickness(Integer markerBorderThickness) {
        this.markerBorderThickness = markerBorderThickness;
        return this;
    }

    public Color getMarkerDisabledColor() {
        return markerDisabledColor;
    }

    public LegendSettings setMarkerDisabledColor(Color markerDisabledColor) {
        this.markerDisabledColor = markerDisabledColor;
        return this;
    }

    public Integer getMarkerLabelGap() {
        return markerLabelGap;
    }

    public LegendSettings setMarkerLabelGap(Integer markerLabelGap) {
        this.markerLabelGap = markerLabelGap;
        return this;
    }

    public Integer getMarkerSize() {
        return markerSize;
    }

    public LegendSettings setMarkerSize(Integer markerSize) {
        this.markerSize = markerSize;
        return this;
    }

    public MarkerType getMarkerType() {
        return markerType;
    }

    public LegendSettings setMarkerType(MarkerType markerType) {
        this.markerType = markerType;
        return this;
    }

    public Boolean getReversedOrder() {
        return reversedOrder;
    }

    public LegendSettings setReversedOrder(Boolean reversedOrder) {
        this.reversedOrder = reversedOrder;
        return this;
    }

    public Color getRollOverColor() {
        return rollOverColor;
    }

    public LegendSettings setRollOverColor(Color rollOverColor) {
        this.rollOverColor = rollOverColor;
        return this;
    }

    public Double getRollOverGraphAlpha() {
        return rollOverGraphAlpha;
    }

    public LegendSettings setRollOverGraphAlpha(Double rollOverGraphAlpha) {
        this.rollOverGraphAlpha = rollOverGraphAlpha;
        return this;
    }

    public Boolean getSwitchable() {
        return switchable;
    }

    public LegendSettings setSwitchable(Boolean switchable) {
        this.switchable = switchable;
        return this;
    }

    public Color getSwitchColor() {
        return switchColor;
    }

    public LegendSettings setSwitchColor(Color switchColor) {
        this.switchColor = switchColor;
        return this;
    }

    public SwitchType getSwitchType() {
        return switchType;
    }

    public LegendSettings setSwitchType(SwitchType switchType) {
        this.switchType = switchType;
        return this;
    }

    public Boolean getTextClickEnabled() {
        return textClickEnabled;
    }

    public LegendSettings setTextClickEnabled(Boolean textClickEnabled) {
        this.textClickEnabled = textClickEnabled;
        return this;
    }

    public Boolean getUseMarkerColorForLabels() {
        return useMarkerColorForLabels;
    }

    public LegendSettings setUseMarkerColorForLabels(Boolean useMarkerColorForLabels) {
        this.useMarkerColorForLabels = useMarkerColorForLabels;
        return this;
    }

    public String getValueTextComparing() {
        return valueTextComparing;
    }

    public LegendSettings setValueTextComparing(String valueTextComparing) {
        this.valueTextComparing = valueTextComparing;
        return this;
    }

    public String getValueTextRegular() {
        return valueTextRegular;
    }

    public LegendSettings setValueTextRegular(String valueTextRegular) {
        this.valueTextRegular = valueTextRegular;
        return this;
    }

    public Integer getValueWidth() {
        return valueWidth;
    }

    public LegendSettings setValueWidth(Integer valueWidth) {
        this.valueWidth = valueWidth;
        return this;
    }

    public Integer getVerticalGap() {
        return verticalGap;
    }

    public LegendSettings setVerticalGap(Integer verticalGap) {
        this.verticalGap = verticalGap;
        return this;
    }
}
