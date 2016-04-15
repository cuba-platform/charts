/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of AxisBase JS Object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AxisBase">http://docs.amcharts.com/3/javascriptcharts/AxisBase</a>
 *
 */
@SuppressWarnings("unchecked")
public abstract class AbstractAxis<T extends AbstractAxis> extends AbstractChartObject {

    private static final long serialVersionUID = -3780316839158653495L;

    private Boolean autoGridCount;

    private Integer autoRotateAngle;

    private Integer autoRotateCount;

    private Double axisAlpha;

    private Color axisColor;

    private Integer axisThickness;

    private Balloon balloon;

    private Boolean boldLabels;

    private Boolean boldPeriodBeginning;

    private Boolean centerLabelOnFullPeriod;

    private Boolean centerLabels;

    private Color color;

    private Integer dashLength;

    private List<DateFormat> dateFormats;

    private Double fillAlpha;

    private Color fillColor;

    private DayOfWeek firstDayOfWeek;

    private Integer fontSize;

    private Double gridAlpha;

    private Color gridColor;

    private Integer gridCount;

    private Integer gridThickness;

    private List<Guide> guides;

    private Boolean ignoreAxisWidth;

    private Boolean inside;

    private Double labelFrequency;

    private Integer labelOffset;

    private Integer labelRotation;

    private Boolean labelsEnabled;

    private Boolean markPeriodChange;

    private Integer minHorizontalGap;

    private Double minorGridAlpha;

    private Boolean minorGridEnabled;

    private Integer minorTickLength;

    private Integer minVerticalGap;

    private Integer offset;

    private Position position;

    private Boolean showFirstLabel;

    private Boolean showLastLabel;

    private Integer tickLength;

    private String title;

    private Boolean titleBold;

    private Color titleColor;

    private Integer titleFontSize;

    private Integer titleRotation;

    public Boolean getAutoGridCount() {
        return autoGridCount;
    }

    public T setAutoGridCount(Boolean autoGridCount) {
        this.autoGridCount = autoGridCount;
        return (T) this;
    }

    public Double getAxisAlpha() {
        return axisAlpha;
    }

    public T setAxisAlpha(Double axisAlpha) {
        this.axisAlpha = axisAlpha;
        return (T) this;
    }

    public Color getAxisColor() {
        return axisColor;
    }

    public T setAxisColor(Color axisColor) {
        this.axisColor = axisColor;
        return (T) this;
    }

    public Integer getAxisThickness() {
        return axisThickness;
    }

    public T setAxisThickness(Integer axisThickness) {
        this.axisThickness = axisThickness;
        return (T) this;
    }

    public Color getColor() {
        return color;
    }

    public T setColor(Color color) {
        this.color = color;
        return (T) this;
    }

    public Integer getDashLength() {
        return dashLength;
    }

    public T setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
        return (T) this;
    }

    public Double getFillAlpha() {
        return fillAlpha;
    }

    public T setFillAlpha(Double fillAlpha) {
        this.fillAlpha = fillAlpha;
        return (T) this;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public T setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        return (T) this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public T setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return (T) this;
    }

    public Double getGridAlpha() {
        return gridAlpha;
    }

    public T setGridAlpha(Double gridAlpha) {
        this.gridAlpha = gridAlpha;
        return (T) this;
    }

    public Color getGridColor() {
        return gridColor;
    }

    public T setGridColor(Color gridColor) {
        this.gridColor = gridColor;
        return (T) this;
    }

    public Integer getGridCount() {
        return gridCount;
    }

    public T setGridCount(Integer gridCount) {
        this.gridCount = gridCount;
        return (T) this;
    }

    public Integer getGridThickness() {
        return gridThickness;
    }

    public T setGridThickness(Integer gridThickness) {
        this.gridThickness = gridThickness;
        return (T) this;
    }

    public List<Guide> getGuides() {
        return guides;
    }

    public T setGuides(List<Guide> guides) {
        this.guides = guides;
        return (T) this;
    }

    public T addGuides(Guide... guides) {
        if (guides != null) {
            if (this.guides == null) {
                this.guides = new ArrayList<>();
            }
            this.guides.addAll(Arrays.asList(guides));
        }
        return (T) this;
    }

    public Boolean getIgnoreAxisWidth() {
        return ignoreAxisWidth;
    }

    public T setIgnoreAxisWidth(Boolean ignoreAxisWidth) {
        this.ignoreAxisWidth = ignoreAxisWidth;
        return (T) this;
    }

    public Boolean getInside() {
        return inside;
    }

    public T setInside(Boolean inside) {
        this.inside = inside;
        return (T) this;
    }

    public Double getLabelFrequency() {
        return labelFrequency;
    }

    public T setLabelFrequency(Double labelFrequency) {
        this.labelFrequency = labelFrequency;
        return (T) this;
    }

    public Integer getLabelRotation() {
        return labelRotation;
    }

    public T setLabelRotation(Integer labelRotation) {
        this.labelRotation = labelRotation;
        return (T) this;
    }

    public Boolean getLabelsEnabled() {
        return labelsEnabled;
    }

    public T setLabelsEnabled(Boolean labelsEnabled) {
        this.labelsEnabled = labelsEnabled;
        return (T) this;
    }

    public Integer getMinHorizontalGap() {
        return minHorizontalGap;
    }

    public T setMinHorizontalGap(Integer minHorizontalGap) {
        this.minHorizontalGap = minHorizontalGap;
        return (T) this;
    }

    public Double getMinorGridAlpha() {
        return minorGridAlpha;
    }

    public T setMinorGridAlpha(Double minorGridAlpha) {
        this.minorGridAlpha = minorGridAlpha;
        return (T) this;
    }

    public Boolean getMinorGridEnabled() {
        return minorGridEnabled;
    }

    public T setMinorGridEnabled(Boolean minorGridEnabled) {
        this.minorGridEnabled = minorGridEnabled;
        return (T) this;
    }

    public Integer getMinVerticalGap() {
        return minVerticalGap;
    }

    public T setMinVerticalGap(Integer minVerticalGap) {
        this.minVerticalGap = minVerticalGap;
        return (T) this;
    }

    public Integer getOffset() {
        return offset;
    }

    public T setOffset(Integer offset) {
        this.offset = offset;
        return (T) this;
    }

    public Position getPosition() {
        return position;
    }

    public T setPosition(Position position) {
        this.position = position;
        return (T) this;
    }

    public Boolean getShowFirstLabel() {
        return showFirstLabel;
    }

    public T setShowFirstLabel(Boolean showFirstLabel) {
        this.showFirstLabel = showFirstLabel;
        return (T) this;
    }

    public Boolean getShowLastLabel() {
        return showLastLabel;
    }

    public T setShowLastLabel(Boolean showLastLabel) {
        this.showLastLabel = showLastLabel;
        return (T) this;
    }

    public Integer getTickLength() {
        return tickLength;
    }

    public T setTickLength(Integer tickLength) {
        this.tickLength = tickLength;
        return (T) this;
    }

    public String getTitle() {
        return title;
    }

    public T setTitle(String title) {
        this.title = title;
        return (T) this;
    }

    public Boolean getTitleBold() {
        return titleBold;
    }

    public T setTitleBold(Boolean titleBold) {
        this.titleBold = titleBold;
        return (T) this;
    }

    public Color getTitleColor() {
        return titleColor;
    }

    public T setTitleColor(Color titleColor) {
        this.titleColor = titleColor;
        return (T) this;
    }

    public Integer getTitleFontSize() {
        return titleFontSize;
    }

    public T setTitleFontSize(Integer titleFontSize) {
        this.titleFontSize = titleFontSize;
        return (T) this;
    }

    public Boolean getBoldLabels() {
        return boldLabels;
    }

    public T setBoldLabels(Boolean boldLabels) {
        this.boldLabels = boldLabels;
        return (T) this;
    }

    public Integer getAutoRotateAngle() {
        return autoRotateAngle;
    }

    public T setAutoRotateAngle(Integer autoRotateAngle) {
        this.autoRotateAngle = autoRotateAngle;
        return (T) this;
    }

    public Integer getAutoRotateCount() {
        return autoRotateCount;
    }

    public T setAutoRotateCount(Integer autoRotateCount) {
        this.autoRotateCount = autoRotateCount;
        return (T) this;
    }

    public Boolean getCenterLabels() {
        return centerLabels;
    }

    public T setCenterLabels(Boolean centerLabels) {
        this.centerLabels = centerLabels;
        return (T) this;
    }

    public List<DateFormat> getDateFormats() {
        return dateFormats;
    }

    public T setDateFormats(List<DateFormat> dateFormats) {
        this.dateFormats = dateFormats;
        return (T) this;
    }

    public T addDateFormats(DateFormat... dateFormats) {
        if (dateFormats != null) {
            if (this.dateFormats == null) {
                this.dateFormats = new ArrayList<>();
            }
            this.dateFormats.addAll(Arrays.asList(dateFormats));
        }
        return (T) this;
    }

    public Integer getMinorTickLength() {
        return minorTickLength;
    }

    public T setMinorTickLength(Integer minorTickLength) {
        this.minorTickLength = minorTickLength;
        return (T) this;
    }

    public Integer getTitleRotation() {
        return titleRotation;
    }

    public T setTitleRotation(Integer titleRotation) {
        this.titleRotation = titleRotation;
        return (T) this;
    }

    public Balloon getBalloon() {
        return balloon;
    }

    public T setBalloon(Balloon balloon) {
        this.balloon = balloon;
        return (T) this;
    }

    public Boolean getBoldPeriodBeginning() {
        return boldPeriodBeginning;
    }

    public T setBoldPeriodBeginning(Boolean boldPeriodBeginning) {
        this.boldPeriodBeginning = boldPeriodBeginning;
        return (T) this;
    }

    public Boolean getCenterLabelOnFullPeriod() {
        return centerLabelOnFullPeriod;
    }

    public T setCenterLabelOnFullPeriod(Boolean centerLabelOnFullPeriod) {
        this.centerLabelOnFullPeriod = centerLabelOnFullPeriod;
        return (T) this;
    }

    public DayOfWeek getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public T setFirstDayOfWeek(DayOfWeek firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
        return (T) this;
    }

    public Integer getLabelOffset() {
        return labelOffset;
    }

    public T setLabelOffset(Integer labelOffset) {
        this.labelOffset = labelOffset;
        return (T) this;
    }

    public Boolean getMarkPeriodChange() {
        return markPeriodChange;
    }

    public T setMarkPeriodChange(Boolean markPeriodChange) {
        this.markPeriodChange = markPeriodChange;
        return (T) this;
    }
}