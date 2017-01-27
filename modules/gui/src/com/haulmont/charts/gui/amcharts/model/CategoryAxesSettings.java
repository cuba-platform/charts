/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of CategoryAxesSettings JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/CategoryAxesSettings">http://docs.amcharts.com/3/javascriptstockchart/CategoryAxesSettings</a>
 */
public class CategoryAxesSettings extends AbstractChartObject {

    private static final long serialVersionUID = -4456035547141357578L;

    private Boolean alwaysGroup;

    private Boolean autoGridCount;

    private Double axisAlpha;

    private Color axisColor;

    private Integer axisHeight;

    private Integer axisThickness;

    private Boolean boldLabels;

    private Boolean boldPeriodBeginning;

    private Color color;

    private Integer dashLength;

    private List<DateFormat> dateFormats;

    private Boolean equalSpacing;

    private Double fillAlpha;

    private Color fillColor;

    private Integer fontSize;

    private Double gridAlpha;

    private Color gridColor;

    private Integer gridCount;

    private Integer gridThickness;

    private List<String> groupToPeriods;

    private Boolean inside;

    private Integer labelOffset;

    private Integer labelRotation;

    private Boolean labelsEnabled;

    private Boolean markPeriodChange;

    private Integer maxSeries;

    private Integer minHorizontalGap;

    private Double minorGridAlpha;

    private Boolean minorGridEnabled;

    private String minPeriod;

    private CategoryAxesPosition position;

    private Boolean startOnAxis;

    private Integer tickLength;

    private Boolean twoLineMode;

    public Boolean getAlwaysGroup() {
        return alwaysGroup;
    }

    public CategoryAxesSettings setAlwaysGroup(Boolean alwaysGroup) {
        this.alwaysGroup = alwaysGroup;
        return this;
    }

    public Boolean getAutoGridCount() {
        return autoGridCount;
    }

    public CategoryAxesSettings setAutoGridCount(Boolean autoGridCount) {
        this.autoGridCount = autoGridCount;
        return this;
    }

    public Double getAxisAlpha() {
        return axisAlpha;
    }

    public CategoryAxesSettings setAxisAlpha(Double axisAlpha) {
        this.axisAlpha = axisAlpha;
        return this;
    }

    public Color getAxisColor() {
        return axisColor;
    }

    public CategoryAxesSettings setAxisColor(Color axisColor) {
        this.axisColor = axisColor;
        return this;
    }

    public Integer getAxisHeight() {
        return axisHeight;
    }

    public CategoryAxesSettings setAxisHeight(Integer axisHeight) {
        this.axisHeight = axisHeight;
        return this;
    }

    public Integer getAxisThickness() {
        return axisThickness;
    }

    public CategoryAxesSettings setAxisThickness(Integer axisThickness) {
        this.axisThickness = axisThickness;
        return this;
    }

    public Boolean getBoldPeriodBeginning() {
        return boldPeriodBeginning;
    }

    public CategoryAxesSettings setBoldPeriodBeginning(Boolean boldPeriodBeginning) {
        this.boldPeriodBeginning = boldPeriodBeginning;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public CategoryAxesSettings setColor(Color color) {
        this.color = color;
        return this;
    }

    public Integer getDashLength() {
        return dashLength;
    }

    public CategoryAxesSettings setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
        return this;
    }

    public List<DateFormat> getDateFormats() {
        return dateFormats;
    }

    public CategoryAxesSettings setDateFormats(List<DateFormat> dateFormats) {
        this.dateFormats = dateFormats;
        return this;
    }

    public CategoryAxesSettings addDateFormats(DateFormat... dateFormats) {
        if (dateFormats != null) {
            if (this.dateFormats == null) {
                this.dateFormats = new ArrayList<>();
            }
            this.dateFormats.addAll(Arrays.asList(dateFormats));
        }
        return this;
    }

    public Boolean getEqualSpacing() {
        return equalSpacing;
    }

    public CategoryAxesSettings setEqualSpacing(Boolean equalSpacing) {
        this.equalSpacing = equalSpacing;
        return this;
    }

    public Double getFillAlpha() {
        return fillAlpha;
    }

    public CategoryAxesSettings setFillAlpha(Double fillAlpha) {
        this.fillAlpha = fillAlpha;
        return this;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public CategoryAxesSettings setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public CategoryAxesSettings setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public Double getGridAlpha() {
        return gridAlpha;
    }

    public CategoryAxesSettings setGridAlpha(Double gridAlpha) {
        this.gridAlpha = gridAlpha;
        return this;
    }

    public Color getGridColor() {
        return gridColor;
    }

    public CategoryAxesSettings setGridColor(Color gridColor) {
        this.gridColor = gridColor;
        return this;
    }

    public Integer getGridCount() {
        return gridCount;
    }

    public CategoryAxesSettings setGridCount(Integer gridCount) {
        this.gridCount = gridCount;
        return this;
    }

    public Integer getGridThickness() {
        return gridThickness;
    }

    public CategoryAxesSettings setGridThickness(Integer gridThickness) {
        this.gridThickness = gridThickness;
        return this;
    }

    public List<String> getGroupToPeriods() {
        return groupToPeriods;
    }

    public CategoryAxesSettings setGroupToPeriods(List<String> groupToPeriods) {
        this.groupToPeriods = groupToPeriods;
        return this;
    }

    public CategoryAxesSettings addGroupToPeriods(String... groupToPeriods) {
        if (groupToPeriods != null) {
            if (this.groupToPeriods == null) {
                this.groupToPeriods = new ArrayList<>();
            }
            this.groupToPeriods.addAll(Arrays.asList(groupToPeriods));
        }
        return this;
    }

    public Boolean getInside() {
        return inside;
    }

    public CategoryAxesSettings setInside(Boolean inside) {
        this.inside = inside;
        return this;
    }

    public Integer getLabelOffset() {
        return labelOffset;
    }

    public CategoryAxesSettings setLabelOffset(Integer labelOffset) {
        this.labelOffset = labelOffset;
        return this;
    }

    public Integer getLabelRotation() {
        return labelRotation;
    }

    public CategoryAxesSettings setLabelRotation(Integer labelRotation) {
        this.labelRotation = labelRotation;
        return this;
    }

    public Boolean getLabelsEnabled() {
        return labelsEnabled;
    }

    public CategoryAxesSettings setLabelsEnabled(Boolean labelsEnabled) {
        this.labelsEnabled = labelsEnabled;
        return this;
    }

    public Boolean getMarkPeriodChange() {
        return markPeriodChange;
    }

    public CategoryAxesSettings setMarkPeriodChange(Boolean markPeriodChange) {
        this.markPeriodChange = markPeriodChange;
        return this;
    }

    public Integer getMaxSeries() {
        return maxSeries;
    }

    public CategoryAxesSettings setMaxSeries(Integer maxSeries) {
        this.maxSeries = maxSeries;
        return this;
    }

    public Integer getMinHorizontalGap() {
        return minHorizontalGap;
    }

    public CategoryAxesSettings setMinHorizontalGap(Integer minHorizontalGap) {
        this.minHorizontalGap = minHorizontalGap;
        return this;
    }

    public String getMinPeriod() {
        return minPeriod;
    }

    public CategoryAxesSettings setMinPeriod(String minPeriod) {
        this.minPeriod = minPeriod;
        return this;
    }

    public CategoryAxesPosition getPosition() {
        return position;
    }

    public CategoryAxesSettings setPosition(CategoryAxesPosition position) {
        this.position = position;
        return this;
    }

    public Boolean getStartOnAxis() {
        return startOnAxis;
    }

    public CategoryAxesSettings setStartOnAxis(Boolean startOnAxis) {
        this.startOnAxis = startOnAxis;
        return this;
    }

    public Integer getTickLength() {
        return tickLength;
    }

    public CategoryAxesSettings setTickLength(Integer tickLength) {
        this.tickLength = tickLength;
        return this;
    }

    public Boolean getTwoLineMode() {
        return twoLineMode;
    }

    public CategoryAxesSettings setTwoLineMode(Boolean twoLineMode) {
        this.twoLineMode = twoLineMode;
        return this;
    }

    public Boolean getBoldLabels() {
        return boldLabels;
    }

    public CategoryAxesSettings setBoldLabels(Boolean boldLabels) {
        this.boldLabels = boldLabels;
        return this;
    }

    public Double getMinorGridAlpha() {
        return minorGridAlpha;
    }

    public CategoryAxesSettings setMinorGridAlpha(Double minorGridAlpha) {
        this.minorGridAlpha = minorGridAlpha;
        return this;
    }

    public Boolean getMinorGridEnabled() {
        return minorGridEnabled;
    }

    public CategoryAxesSettings setMinorGridEnabled(Boolean minorGridEnabled) {
        this.minorGridEnabled = minorGridEnabled;
        return this;
    }
}
