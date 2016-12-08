/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of AmLegend JS Object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmLegend">http://docs.amcharts.com/3/javascriptcharts/AmLegend</a>
 *
 */
@SuppressWarnings("unchecked")
public class AbstractLegend<T extends AbstractLegend> extends AbstractChartObject implements HasMargins<AbstractLegend> {

    private static final long serialVersionUID = -8561508956306637129L;

    private String accessibleLabel;

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

    private Boolean forceWidth;

    private Integer gradientRotation;

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

    private Integer tabIndex;

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

    public T setAlign(Align align) {
        this.align = align;
        return (T) this;
    }

    public Boolean getAutoMargins() {
        return autoMargins;
    }

    public T setAutoMargins(Boolean autoMargins) {
        this.autoMargins = autoMargins;
        return (T) this;
    }

    public Double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    public T setBackgroundAlpha(Double backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
        return (T) this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public T setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return (T) this;
    }

    public Double getBorderAlpha() {
        return borderAlpha;
    }

    public T setBorderAlpha(Double borderAlpha) {
        this.borderAlpha = borderAlpha;
        return (T) this;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public T setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return (T) this;
    }

    public Integer getBottom() {
        return bottom;
    }

    public T setBottom(Integer bottom) {
        this.bottom = bottom;
        return (T) this;
    }

    public Color getColor() {
        return color;
    }

    public T setColor(Color color) {
        this.color = color;
        return (T) this;
    }

    public List<LegendItem> getData() {
        return data;
    }

    public T setData(List<LegendItem> data) {
        this.data = data;
        return (T) this;
    }

    public T addItems(LegendItem... items) {
        if (items != null) {
            if (this.data == null) {
                this.data = new ArrayList<>();
            }
            this.data.addAll(Arrays.asList(items));
        }
        return (T) this;
    }

    public Boolean getEqualWidths() {
        return equalWidths;
    }

    public T setEqualWidths(Boolean equalWidths) {
        this.equalWidths = equalWidths;
        return (T) this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public T setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return (T) this;
    }

    public Integer getHorizontalGap() {
        return horizontalGap;
    }

    public T setHorizontalGap(Integer horizontalGap) {
        this.horizontalGap = horizontalGap;
        return (T) this;
    }

    public String getLabelText() {
        return labelText;
    }

    public T setLabelText(String labelText) {
        this.labelText = labelText;
        return (T) this;
    }

    public Integer getLeft() {
        return left;
    }

    public T setLeft(Integer left) {
        this.left = left;
        return (T) this;
    }

    @Override
    public Integer getMarginBottom() {
        return marginBottom;
    }

    @Override
    public T setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
        return (T) this;
    }

    @Override
    public Integer getMarginLeft() {
        return marginLeft;
    }

    @Override
    public T setMarginLeft(Integer marginLeft) {
        this.marginLeft = marginLeft;
        return (T) this;
    }

    @Override
    public Integer getMarginRight() {
        return marginRight;
    }

    @Override
    public T setMarginRight(Integer marginRight) {
        this.marginRight = marginRight;
        return (T) this;
    }

    @Override
    public Integer getMarginTop() {
        return marginTop;
    }

    @Override
    public T setMarginTop(Integer marginTop) {
        this.marginTop = marginTop;
        return (T) this;
    }

    public Double getMarkerBorderAlpha() {
        return markerBorderAlpha;
    }

    public T setMarkerBorderAlpha(Double markerBorderAlpha) {
        this.markerBorderAlpha = markerBorderAlpha;
        return (T) this;
    }

    public Color getMarkerBorderColor() {
        return markerBorderColor;
    }

    public T setMarkerBorderColor(Color markerBorderColor) {
        this.markerBorderColor = markerBorderColor;
        return (T) this;
    }

    public Integer getMarkerBorderThickness() {
        return markerBorderThickness;
    }

    public T setMarkerBorderThickness(Integer markerBorderThickness) {
        this.markerBorderThickness = markerBorderThickness;
        return (T) this;
    }

    public Color getMarkerDisabledColor() {
        return markerDisabledColor;
    }

    public T setMarkerDisabledColor(Color markerDisabledColor) {
        this.markerDisabledColor = markerDisabledColor;
        return (T) this;
    }

    public Integer getMarkerLabelGap() {
        return markerLabelGap;
    }

    public T setMarkerLabelGap(Integer markerLabelGap) {
        this.markerLabelGap = markerLabelGap;
        return (T) this;
    }

    public Integer getMarkerSize() {
        return markerSize;
    }

    public T setMarkerSize(Integer markerSize) {
        this.markerSize = markerSize;
        return (T) this;
    }

    public MarkerType getMarkerType() {
        return markerType;
    }

    public T setMarkerType(MarkerType markerType) {
        this.markerType = markerType;
        return (T) this;
    }

    public Integer getMaxColumns() {
        return maxColumns;
    }

    public T setMaxColumns(Integer maxColumns) {
        this.maxColumns = maxColumns;
        return (T) this;
    }

    public String getPeriodValueText() {
        return periodValueText;
    }

    public T setPeriodValueText(String periodValueText) {
        this.periodValueText = periodValueText;
        return (T) this;
    }

    public LegendPosition getPosition() {
        return position;
    }

    public T setPosition(LegendPosition position) {
        this.position = position;
        return (T) this;
    }

    public Boolean getReversedOrder() {
        return reversedOrder;
    }

    public T setReversedOrder(Boolean reversedOrder) {
        this.reversedOrder = reversedOrder;
        return (T) this;
    }

    public Integer getRight() {
        return right;
    }

    public T setRight(Integer right) {
        this.right = right;
        return (T) this;
    }

    public Color getRollOverColor() {
        return rollOverColor;
    }

    public T setRollOverColor(Color rollOverColor) {
        this.rollOverColor = rollOverColor;
        return (T) this;
    }

    public Double getRollOverGraphAlpha() {
        return rollOverGraphAlpha;
    }

    public T setRollOverGraphAlpha(Double rollOverGraphAlpha) {
        this.rollOverGraphAlpha = rollOverGraphAlpha;
        return (T) this;
    }

    public Boolean getShowEntries() {
        return showEntries;
    }

    public T setShowEntries(Boolean showEntries) {
        this.showEntries = showEntries;
        return (T) this;
    }

    public Integer getSpacing() {
        return spacing;
    }

    public T setSpacing(Integer spacing) {
        this.spacing = spacing;
        return (T) this;
    }

    public Boolean getSwitchable() {
        return switchable;
    }

    public T setSwitchable(Boolean switchable) {
        this.switchable = switchable;
        return (T) this;
    }

    public Color getSwitchColor() {
        return switchColor;
    }

    public T setSwitchColor(Color switchColor) {
        this.switchColor = switchColor;
        return (T) this;
    }

    public LegendSwitch getSwitchType() {
        return switchType;
    }

    public T setSwitchType(LegendSwitch switchType) {
        this.switchType = switchType;
        return (T) this;
    }

    public Boolean getTextClickEnabled() {
        return textClickEnabled;
    }

    public T setTextClickEnabled(Boolean textClickEnabled) {
        this.textClickEnabled = textClickEnabled;
        return (T) this;
    }

    public Integer getTop() {
        return top;
    }

    public T setTop(Integer top) {
        this.top = top;
        return (T) this;
    }

    public Boolean getUseGraphSettings() {
        return useGraphSettings;
    }

    public T setUseGraphSettings(Boolean useGraphSettings) {
        this.useGraphSettings = useGraphSettings;
        return (T) this;
    }

    public Boolean getUseMarkerColorForLabels() {
        return useMarkerColorForLabels;
    }

    public T setUseMarkerColorForLabels(Boolean useMarkerColorForLabels) {
        this.useMarkerColorForLabels = useMarkerColorForLabels;
        return (T) this;
    }

    public Boolean getUseMarkerColorForValues() {
        return useMarkerColorForValues;
    }

    public T setUseMarkerColorForValues(Boolean useMarkerColorForValues) {
        this.useMarkerColorForValues = useMarkerColorForValues;
        return (T) this;
    }

    public ValueAlign getValueAlign() {
        return valueAlign;
    }

    public T setValueAlign(ValueAlign valueAlign) {
        this.valueAlign = valueAlign;
        return (T) this;
    }

    public String getValueText() {
        return valueText;
    }

    public T setValueText(String valueText) {
        this.valueText = valueText;
        return (T) this;
    }

    public Integer getValueWidth() {
        return valueWidth;
    }

    public T setValueWidth(Integer valueWidth) {
        this.valueWidth = valueWidth;
        return (T) this;
    }

    public Integer getVerticalGap() {
        return verticalGap;
    }

    public T setVerticalGap(Integer verticalGap) {
        this.verticalGap = verticalGap;
        return (T) this;
    }

    public String getDivId() {
        return divId;
    }

    public T setDivId(String divId) {
        this.divId = divId;
        return (T) this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public T setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (T) this;
    }

    public Integer getLabelWidth() {
        return labelWidth;
    }

    public T setLabelWidth(Integer labelWidth) {
        this.labelWidth = labelWidth;
        return (T) this;
    }

    public JsFunction getValueFunction() {
        return valueFunction;
    }

    public T setValueFunction(JsFunction valueFunction) {
        this.valueFunction = valueFunction;
        return (T) this;
    }

    public Integer getWidth() {
        return width;
    }

    public T setWidth(Integer width) {
        this.width = width;
        return (T) this;
    }

    public Boolean getForceWidth() {
        return forceWidth;
    }

    public T setForceWidth(Boolean forceWidth) {
        this.forceWidth = forceWidth;
        return (T) this;
    }

    public Integer getGradientRotation() {
        return gradientRotation;
    }

    public T setGradientRotation(Integer gradientRotation) {
        this.gradientRotation = gradientRotation;
        return (T) this;
    }

    public Integer getTabIndex() {
        return tabIndex;
    }

    public T setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
        return (T) this;
    }

    public String getAccessibleLabel() {
        return accessibleLabel;
    }

    public T setAccessibleLabel(String accessibleLabel) {
        this.accessibleLabel = accessibleLabel;
        return (T) this;
    }
}