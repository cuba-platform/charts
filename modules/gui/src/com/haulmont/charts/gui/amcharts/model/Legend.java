/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of AmLegend JS Object.
 *
 * @author artamonov
 * @version $Id$
 */
public class Legend extends AbstractConfigurationObject implements HasMargins<Legend> {

    private static final long serialVersionUID = -8561508956306637129L;

    private Align align;

    private Boolean autoMargins;

    private Double backgroundAlpha;

    private Color backgroundColor;

    private Double borderAlpha;

    private Color borderColor;

    private Integer bottom;

    private Color color;

    private List<LegendItem> data;

    private String divId;

    private Boolean enabled;

    private Boolean equalWidths;

    private Integer fontSize;

    private Integer horizontalGap;

    private String labelText;

    private Integer labelWidth;

    private Integer left;

    private Integer marginBottom;

    private Integer marginLeft;

    private Integer marginRight;

    private Integer marginTop;

    private Double markerBorderAlpha;

    private Color markerBorderColor;

    private Integer markerBorderThickness;

    private Color markerDisabledColor;

    private Integer markerLabelGap;

    private Integer markerSize;

    private MarkerType markerType;

    private Integer maxColumns;

    private String periodValueText;

    private LegendPosition position;

    private Boolean reversedOrder;

    private Integer right;

    private Color rollOverColor;

    private Double rollOverGraphAlpha;

    private Boolean showEntries;

    private Integer spacing;

    private Boolean switchable;

    private Color switchColor;

    private LegendSwitch switchType;

    private Boolean textClickEnabled;

    private Integer top;

    private Boolean useGraphSettings;

    private Boolean useMarkerColorForLabels;

    private Boolean useMarkerColorForValues;

    private ValueAlign valueAlign;

    private JsFunction valueFunction;

    private String valueText;

    private Integer valueWidth;

    private Integer verticalGap;

    private Integer width;

    public Align getAlign() {
        return align;
    }

    public Legend setAlign(Align align) {
        this.align = align;
        return this;
    }

    public Boolean getAutoMargins() {
        return autoMargins;
    }

    public Legend setAutoMargins(Boolean autoMargins) {
        this.autoMargins = autoMargins;
        return this;
    }

    public Double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    public Legend setBackgroundAlpha(Double backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Legend setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Double getBorderAlpha() {
        return borderAlpha;
    }

    public Legend setBorderAlpha(Double borderAlpha) {
        this.borderAlpha = borderAlpha;
        return this;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public Legend setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public Integer getBottom() {
        return bottom;
    }

    public Legend setBottom(Integer bottom) {
        this.bottom = bottom;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Legend setColor(Color color) {
        this.color = color;
        return this;
    }

    public List<LegendItem> getData() {
        return data;
    }

    public Legend setData(List<LegendItem> data) {
        this.data = data;
        return this;
    }

    public Legend addItems(LegendItem... items) {
        if (items != null) {
            if (this.data == null) {
                this.data = new ArrayList<>();
            }
            this.data.addAll(Arrays.asList(items));
        }
        return this;
    }

    public Boolean getEqualWidths() {
        return equalWidths;
    }

    public Legend setEqualWidths(Boolean equalWidths) {
        this.equalWidths = equalWidths;
        return this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public Legend setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public Integer getHorizontalGap() {
        return horizontalGap;
    }

    public Legend setHorizontalGap(Integer horizontalGap) {
        this.horizontalGap = horizontalGap;
        return this;
    }

    public String getLabelText() {
        return labelText;
    }

    public Legend setLabelText(String labelText) {
        this.labelText = labelText;
        return this;
    }

    public Integer getLeft() {
        return left;
    }

    public Legend setLeft(Integer left) {
        this.left = left;
        return this;
    }

    @Override
    public Integer getMarginBottom() {
        return marginBottom;
    }

    @Override
    public Legend setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    @Override
    public Integer getMarginLeft() {
        return marginLeft;
    }

    @Override
    public Legend setMarginLeft(Integer marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    @Override
    public Integer getMarginRight() {
        return marginRight;
    }

    @Override
    public Legend setMarginRight(Integer marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    @Override
    public Integer getMarginTop() {
        return marginTop;
    }

    @Override
    public Legend setMarginTop(Integer marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public Double getMarkerBorderAlpha() {
        return markerBorderAlpha;
    }

    public Legend setMarkerBorderAlpha(Double markerBorderAlpha) {
        this.markerBorderAlpha = markerBorderAlpha;
        return this;
    }

    public Color getMarkerBorderColor() {
        return markerBorderColor;
    }

    public Legend setMarkerBorderColor(Color markerBorderColor) {
        this.markerBorderColor = markerBorderColor;
        return this;
    }

    public Integer getMarkerBorderThickness() {
        return markerBorderThickness;
    }

    public Legend setMarkerBorderThickness(Integer markerBorderThickness) {
        this.markerBorderThickness = markerBorderThickness;
        return this;
    }

    public Color getMarkerDisabledColor() {
        return markerDisabledColor;
    }

    public Legend setMarkerDisabledColor(Color markerDisabledColor) {
        this.markerDisabledColor = markerDisabledColor;
        return this;
    }

    public Integer getMarkerLabelGap() {
        return markerLabelGap;
    }

    public Legend setMarkerLabelGap(Integer markerLabelGap) {
        this.markerLabelGap = markerLabelGap;
        return this;
    }

    public Integer getMarkerSize() {
        return markerSize;
    }

    public Legend setMarkerSize(Integer markerSize) {
        this.markerSize = markerSize;
        return this;
    }

    public MarkerType getMarkerType() {
        return markerType;
    }

    public Legend setMarkerType(MarkerType markerType) {
        this.markerType = markerType;
        return this;
    }

    public Integer getMaxColumns() {
        return maxColumns;
    }

    public Legend setMaxColumns(Integer maxColumns) {
        this.maxColumns = maxColumns;
        return this;
    }

    public String getPeriodValueText() {
        return periodValueText;
    }

    public Legend setPeriodValueText(String periodValueText) {
        this.periodValueText = periodValueText;
        return this;
    }

    public LegendPosition getPosition() {
        return position;
    }

    public Legend setPosition(LegendPosition position) {
        this.position = position;
        return this;
    }

    public Boolean getReversedOrder() {
        return reversedOrder;
    }

    public Legend setReversedOrder(Boolean reversedOrder) {
        this.reversedOrder = reversedOrder;
        return this;
    }

    public Integer getRight() {
        return right;
    }

    public Legend setRight(Integer right) {
        this.right = right;
        return this;
    }

    public Color getRollOverColor() {
        return rollOverColor;
    }

    public Legend setRollOverColor(Color rollOverColor) {
        this.rollOverColor = rollOverColor;
        return this;
    }

    public Double getRollOverGraphAlpha() {
        return rollOverGraphAlpha;
    }

    public Legend setRollOverGraphAlpha(Double rollOverGraphAlpha) {
        this.rollOverGraphAlpha = rollOverGraphAlpha;
        return this;
    }

    public Boolean getShowEntries() {
        return showEntries;
    }

    public Legend setShowEntries(Boolean showEntries) {
        this.showEntries = showEntries;
        return this;
    }

    public Integer getSpacing() {
        return spacing;
    }

    public Legend setSpacing(Integer spacing) {
        this.spacing = spacing;
        return this;
    }

    public Boolean getSwitchable() {
        return switchable;
    }

    public Legend setSwitchable(Boolean switchable) {
        this.switchable = switchable;
        return this;
    }

    public Color getSwitchColor() {
        return switchColor;
    }

    public Legend setSwitchColor(Color switchColor) {
        this.switchColor = switchColor;
        return this;
    }

    public LegendSwitch getSwitchType() {
        return switchType;
    }

    public Legend setSwitchType(LegendSwitch switchType) {
        this.switchType = switchType;
        return this;
    }

    public Boolean getTextClickEnabled() {
        return textClickEnabled;
    }

    public Legend setTextClickEnabled(Boolean textClickEnabled) {
        this.textClickEnabled = textClickEnabled;
        return this;
    }

    public Integer getTop() {
        return top;
    }

    public Legend setTop(Integer top) {
        this.top = top;
        return this;
    }

    public Boolean getUseGraphSettings() {
        return useGraphSettings;
    }

    public Legend setUseGraphSettings(Boolean useGraphSettings) {
        this.useGraphSettings = useGraphSettings;
        return this;
    }

    public Boolean getUseMarkerColorForLabels() {
        return useMarkerColorForLabels;
    }

    public Legend setUseMarkerColorForLabels(Boolean useMarkerColorForLabels) {
        this.useMarkerColorForLabels = useMarkerColorForLabels;
        return this;
    }

    public Boolean getUseMarkerColorForValues() {
        return useMarkerColorForValues;
    }

    public Legend setUseMarkerColorForValues(Boolean useMarkerColorForValues) {
        this.useMarkerColorForValues = useMarkerColorForValues;
        return this;
    }

    public ValueAlign getValueAlign() {
        return valueAlign;
    }

    public Legend setValueAlign(ValueAlign valueAlign) {
        this.valueAlign = valueAlign;
        return this;
    }

    public String getValueText() {
        return valueText;
    }

    public Legend setValueText(String valueText) {
        this.valueText = valueText;
        return this;
    }

    public Integer getValueWidth() {
        return valueWidth;
    }

    public Legend setValueWidth(Integer valueWidth) {
        this.valueWidth = valueWidth;
        return this;
    }

    public Integer getVerticalGap() {
        return verticalGap;
    }

    public Legend setVerticalGap(Integer verticalGap) {
        this.verticalGap = verticalGap;
        return this;
    }

    public String getDivId() {
        return divId;
    }

    public Legend setDivId(String divId) {
        this.divId = divId;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Legend setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Integer getLabelWidth() {
        return labelWidth;
    }

    public Legend setLabelWidth(Integer labelWidth) {
        this.labelWidth = labelWidth;
        return this;
    }

    public JsFunction getValueFunction() {
        return valueFunction;
    }

    public Legend setValueFunction(JsFunction valueFunction) {
        this.valueFunction = valueFunction;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Legend setWidth(Integer width) {
        this.width = width;
        return this;
    }
}