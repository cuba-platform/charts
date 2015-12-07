/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of ValueAxesSettings JS object. <br/>
 * <p>
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/ValueAxesSettings">http://docs.amcharts.com/3/javascriptstockchart/ValueAxesSettings</a>
 *
 * @author gorelov
 * @version $Id$
 */
public class ValueAxesSettings extends AbstractChartObject {

    private static final long serialVersionUID = 5770922216765077570L;

    private Boolean autoGridCount;

    private Double axisAlpha;

    private Color axisColor;

    private Integer axisThickness;

    private Color color;

    private Integer dashLength;

    private Double fillAlpha;

    private Color fillColor;

    private Double gridAlpha;

    private Color gridColor;

    private Integer gridThickness;

    private Boolean includeGuidesInMinMax;

    private Boolean includeHidden;

    private Boolean inside;

    private Boolean integersOnly;

    private Double labelFrequency;

    private Integer labelOffset;

    private Boolean labelsEnabled;

    private Boolean logarithmic;

    private Double maximum;

    private Double minimum;

    private Double minMaxMultiplier;

    private Integer offset;

    private ValueAxisPosition position;

    private Boolean reversed;

    private Boolean showFirstLabel;

    private Boolean showLastLabel;

    private StackType stackType;

    private Integer tickLength;

    private String unit;

    private UnitPosition unitPosition;

    public Boolean getAutoGridCount() {
        return autoGridCount;
    }

    public ValueAxesSettings setAutoGridCount(Boolean autoGridCount) {
        this.autoGridCount = autoGridCount;
        return this;
    }

    public Double getAxisAlpha() {
        return axisAlpha;
    }

    public ValueAxesSettings setAxisAlpha(Double axisAlpha) {
        this.axisAlpha = axisAlpha;
        return this;
    }

    public Color getAxisColor() {
        return axisColor;
    }

    public ValueAxesSettings setAxisColor(Color axisColor) {
        this.axisColor = axisColor;
        return this;
    }

    public Integer getAxisThickness() {
        return axisThickness;
    }

    public ValueAxesSettings setAxisThickness(Integer axisThickness) {
        this.axisThickness = axisThickness;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public ValueAxesSettings setColor(Color color) {
        this.color = color;
        return this;
    }

    public Integer getDashLength() {
        return dashLength;
    }

    public ValueAxesSettings setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
        return this;
    }

    public Double getFillAlpha() {
        return fillAlpha;
    }

    public ValueAxesSettings setFillAlpha(Double fillAlpha) {
        this.fillAlpha = fillAlpha;
        return this;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public ValueAxesSettings setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    public Double getGridAlpha() {
        return gridAlpha;
    }

    public ValueAxesSettings setGridAlpha(Double gridAlpha) {
        this.gridAlpha = gridAlpha;
        return this;
    }

    public Color getGridColor() {
        return gridColor;
    }

    public ValueAxesSettings setGridColor(Color gridColor) {
        this.gridColor = gridColor;
        return this;
    }

    public Integer getGridThickness() {
        return gridThickness;
    }

    public ValueAxesSettings setGridThickness(Integer gridThickness) {
        this.gridThickness = gridThickness;
        return this;
    }

    public Boolean getIncludeGuidesInMinMax() {
        return includeGuidesInMinMax;
    }

    public ValueAxesSettings setIncludeGuidesInMinMax(Boolean includeGuidesInMinMax) {
        this.includeGuidesInMinMax = includeGuidesInMinMax;
        return this;
    }

    public Boolean getIncludeHidden() {
        return includeHidden;
    }

    public ValueAxesSettings setIncludeHidden(Boolean includeHidden) {
        this.includeHidden = includeHidden;
        return this;
    }

    public Boolean getInside() {
        return inside;
    }

    public ValueAxesSettings setInside(Boolean inside) {
        this.inside = inside;
        return this;
    }

    public Boolean getIntegersOnly() {
        return integersOnly;
    }

    public ValueAxesSettings setIntegersOnly(Boolean integersOnly) {
        this.integersOnly = integersOnly;
        return this;
    }

    public Double getLabelFrequency() {
        return labelFrequency;
    }

    public ValueAxesSettings setLabelFrequency(Double labelFrequency) {
        this.labelFrequency = labelFrequency;
        return this;
    }

    public Integer getLabelOffset() {
        return labelOffset;
    }

    public ValueAxesSettings setLabelOffset(Integer labelOffset) {
        this.labelOffset = labelOffset;
        return this;
    }

    public Boolean getLabelsEnabled() {
        return labelsEnabled;
    }

    public ValueAxesSettings setLabelsEnabled(Boolean labelsEnabled) {
        this.labelsEnabled = labelsEnabled;
        return this;
    }

    public Boolean getLogarithmic() {
        return logarithmic;
    }

    public ValueAxesSettings setLogarithmic(Boolean logarithmic) {
        this.logarithmic = logarithmic;
        return this;
    }

    public Double getMaximum() {
        return maximum;
    }

    public ValueAxesSettings setMaximum(Double maximum) {
        this.maximum = maximum;
        return this;
    }

    public Double getMinimum() {
        return minimum;
    }

    public ValueAxesSettings setMinimum(Double minimum) {
        this.minimum = minimum;
        return this;
    }

    public Double getMinMaxMultiplier() {
        return minMaxMultiplier;
    }

    public ValueAxesSettings setMinMaxMultiplier(Double minMaxMultiplier) {
        this.minMaxMultiplier = minMaxMultiplier;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public ValueAxesSettings setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ValueAxisPosition getPosition() {
        return position;
    }

    public ValueAxesSettings setPosition(ValueAxisPosition position) {
        this.position = position;
        return this;
    }

    public Boolean getReversed() {
        return reversed;
    }

    public ValueAxesSettings setReversed(Boolean reversed) {
        this.reversed = reversed;
        return this;
    }

    public Boolean getShowFirstLabel() {
        return showFirstLabel;
    }

    public ValueAxesSettings setShowFirstLabel(Boolean showFirstLabel) {
        this.showFirstLabel = showFirstLabel;
        return this;
    }

    public Boolean getShowLastLabel() {
        return showLastLabel;
    }

    public ValueAxesSettings setShowLastLabel(Boolean showLastLabel) {
        this.showLastLabel = showLastLabel;
        return this;
    }

    public StackType getStackType() {
        return stackType;
    }

    public ValueAxesSettings setStackType(StackType stackType) {
        this.stackType = stackType;
        return this;
    }

    public Integer getTickLength() {
        return tickLength;
    }

    public ValueAxesSettings setTickLength(Integer tickLength) {
        this.tickLength = tickLength;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public ValueAxesSettings setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public UnitPosition getUnitPosition() {
        return unitPosition;
    }

    public ValueAxesSettings setUnitPosition(UnitPosition unitPosition) {
        this.unitPosition = unitPosition;
        return this;
    }
}
