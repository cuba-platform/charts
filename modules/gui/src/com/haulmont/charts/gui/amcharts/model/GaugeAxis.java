/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of GaugeAxis JS Object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/GaugeAxis">http://docs.amcharts.com/3/javascriptcharts/GaugeAxis</a>
 *
 * @author artamonov
 * @version $Id$
 */
public class GaugeAxis extends AbstractConfigurationObject {

    private static final long serialVersionUID = -27560253244597238L;

    private Double axisAlpha;

    private Color axisColor;

    private Integer axisThickness;

    private Double bandAlpha;

    private Double bandOutlineAlpha;

    private Color bandOutlineColor;

    private Integer bandOutlineThickness;

    private List<GaugeBand> bands;

    private String bottomText;

    private Boolean bottomTextBold;

    private Color bottomTextColor;

    private Integer bottomTextFontSize;

    private Integer bottomTextYOffset;

    private String centerX;

    private String centerY;

    private Integer endAngle;

    private Double endValue;

    private Integer gridCount;

    private Boolean gridInside;

    private String id;

    private Boolean inside;

    private Double labelFrequency;

    private JsFunction labelFunction;

    private Integer labelOffset;

    private Boolean labelsEnabled;

    private Integer minorTickInterval;

    private Integer minorTickLength;

    private String radius;

    private Boolean showFirstLabel;

    private Boolean showLastLabel;

    private Integer startAngle;

    private Double startValue;

    private Double tickAlpha;

    private Color tickColor;

    private Integer tickLength;

    private Integer tickThickness;

    private String topText;

    private Boolean topTextBold;

    private Color topTextColor;

    private Integer topTextFontSize;

    private Integer topTextYOffset;

    private String unit;

    private UnitPosition unitPosition;

    private Boolean usePrefixes;

    private Integer valueInterval;

    public Double getAxisAlpha() {
        return axisAlpha;
    }

    public GaugeAxis setAxisAlpha(Double axisAlpha) {
        this.axisAlpha = axisAlpha;
        return this;
    }

    public Color getAxisColor() {
        return axisColor;
    }

    public GaugeAxis setAxisColor(Color axisColor) {
        this.axisColor = axisColor;
        return this;
    }

    public Integer getAxisThickness() {
        return axisThickness;
    }

    public GaugeAxis setAxisThickness(Integer axisThickness) {
        this.axisThickness = axisThickness;
        return this;
    }

    public Double getBandAlpha() {
        return bandAlpha;
    }

    public GaugeAxis setBandAlpha(Double bandAlpha) {
        this.bandAlpha = bandAlpha;
        return this;
    }

    public Double getBandOutlineAlpha() {
        return bandOutlineAlpha;
    }

    public GaugeAxis setBandOutlineAlpha(Double bandOutlineAlpha) {
        this.bandOutlineAlpha = bandOutlineAlpha;
        return this;
    }

    public Color getBandOutlineColor() {
        return bandOutlineColor;
    }

    public GaugeAxis setBandOutlineColor(Color bandOutlineColor) {
        this.bandOutlineColor = bandOutlineColor;
        return this;
    }

    public Integer getBandOutlineThickness() {
        return bandOutlineThickness;
    }

    public GaugeAxis setBandOutlineThickness(Integer bandOutlineThickness) {
        this.bandOutlineThickness = bandOutlineThickness;
        return this;
    }

    public String getBottomText() {
        return bottomText;
    }

    public GaugeAxis setBottomText(String bottomText) {
        this.bottomText = bottomText;
        return this;
    }

    public Boolean getBottomTextBold() {
        return bottomTextBold;
    }

    public GaugeAxis setBottomTextBold(Boolean bottomTextBold) {
        this.bottomTextBold = bottomTextBold;
        return this;
    }

    public Color getBottomTextColor() {
        return bottomTextColor;
    }

    public GaugeAxis setBottomTextColor(Color bottomTextColor) {
        this.bottomTextColor = bottomTextColor;
        return this;
    }

    public Integer getBottomTextFontSize() {
        return bottomTextFontSize;
    }

    public GaugeAxis setBottomTextFontSize(Integer bottomTextFontSize) {
        this.bottomTextFontSize = bottomTextFontSize;
        return this;
    }

    public Integer getBottomTextYOffset() {
        return bottomTextYOffset;
    }

    public GaugeAxis setBottomTextYOffset(Integer bottomTextYOffset) {
        this.bottomTextYOffset = bottomTextYOffset;
        return this;
    }

    public String getCenterX() {
        return centerX;
    }

    public GaugeAxis setCenterX(String centerX) {
        this.centerX = centerX;
        return this;
    }

    public String getCenterY() {
        return centerY;
    }

    public GaugeAxis setCenterY(String centerY) {
        this.centerY = centerY;
        return this;
    }

    public Integer getEndAngle() {
        return endAngle;
    }

    public GaugeAxis setEndAngle(Integer endAngle) {
        this.endAngle = endAngle;
        return this;
    }

    public Double getEndValue() {
        return endValue;
    }

    public GaugeAxis setEndValue(Double endValue) {
        this.endValue = endValue;
        return this;
    }

    public Boolean getGridInside() {
        return gridInside;
    }

    public GaugeAxis setGridInside(Boolean gridInside) {
        this.gridInside = gridInside;
        return this;
    }

    public Boolean getInside() {
        return inside;
    }

    public GaugeAxis setInside(Boolean inside) {
        this.inside = inside;
        return this;
    }

    public Double getLabelFrequency() {
        return labelFrequency;
    }

    public GaugeAxis setLabelFrequency(Double labelFrequency) {
        this.labelFrequency = labelFrequency;
        return this;
    }

    public Integer getLabelOffset() {
        return labelOffset;
    }

    public GaugeAxis setLabelOffset(Integer labelOffset) {
        this.labelOffset = labelOffset;
        return this;
    }

    public Integer getMinorTickInterval() {
        return minorTickInterval;
    }

    public GaugeAxis setMinorTickInterval(Integer minorTickInterval) {
        this.minorTickInterval = minorTickInterval;
        return this;
    }

    public Integer getMinorTickLength() {
        return minorTickLength;
    }

    public GaugeAxis setMinorTickLength(Integer minorTickLength) {
        this.minorTickLength = minorTickLength;
        return this;
    }

    public String getRadius() {
        return radius;
    }

    public GaugeAxis setRadius(String radius) {
        this.radius = radius;
        return this;
    }

    public Boolean getShowFirstLabel() {
        return showFirstLabel;
    }

    public GaugeAxis setShowFirstLabel(Boolean showFirstLabel) {
        this.showFirstLabel = showFirstLabel;
        return this;
    }

    public Boolean getShowLastLabel() {
        return showLastLabel;
    }

    public GaugeAxis setShowLastLabel(Boolean showLastLabel) {
        this.showLastLabel = showLastLabel;
        return this;
    }

    public Integer getStartAngle() {
        return startAngle;
    }

    public GaugeAxis setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
        return this;
    }

    public Double getStartValue() {
        return startValue;
    }

    public GaugeAxis setStartValue(Double startValue) {
        this.startValue = startValue;
        return this;
    }

    public Double getTickAlpha() {
        return tickAlpha;
    }

    public GaugeAxis setTickAlpha(Double tickAlpha) {
        this.tickAlpha = tickAlpha;
        return this;
    }

    public Color getTickColor() {
        return tickColor;
    }

    public GaugeAxis setTickColor(Color tickColor) {
        this.tickColor = tickColor;
        return this;
    }

    public Integer getTickLength() {
        return tickLength;
    }

    public GaugeAxis setTickLength(Integer tickLength) {
        this.tickLength = tickLength;
        return this;
    }

    public Integer getTickThickness() {
        return tickThickness;
    }

    public GaugeAxis setTickThickness(Integer tickThickness) {
        this.tickThickness = tickThickness;
        return this;
    }

    public String getTopText() {
        return topText;
    }

    public GaugeAxis setTopText(String topText) {
        this.topText = topText;
        return this;
    }

    public Boolean getTopTextBold() {
        return topTextBold;
    }

    public GaugeAxis setTopTextBold(Boolean topTextBold) {
        this.topTextBold = topTextBold;
        return this;
    }

    public Color getTopTextColor() {
        return topTextColor;
    }

    public GaugeAxis setTopTextColor(Color topTextColor) {
        this.topTextColor = topTextColor;
        return this;
    }

    public Integer getTopTextFontSize() {
        return topTextFontSize;
    }

    public GaugeAxis setTopTextFontSize(Integer topTextFontSize) {
        this.topTextFontSize = topTextFontSize;
        return this;
    }

    public Integer getTopTextYOffset() {
        return topTextYOffset;
    }

    public GaugeAxis setTopTextYOffset(Integer topTextYOffset) {
        this.topTextYOffset = topTextYOffset;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public GaugeAxis setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public UnitPosition getUnitPosition() {
        return unitPosition;
    }

    public GaugeAxis setUnitPosition(UnitPosition unitPosition) {
        this.unitPosition = unitPosition;
        return this;
    }

    public Integer getValueInterval() {
        return valueInterval;
    }

    public GaugeAxis setValueInterval(Integer valueInterval) {
        this.valueInterval = valueInterval;
        return this;
    }

    public List<GaugeBand> getBands() {
        return bands;
    }

    public GaugeAxis setBands(List<GaugeBand> bands) {
        this.bands = bands;
        return this;
    }

    public GaugeAxis addBands(GaugeBand... bands) {
        if (bands != null) {
            if (this.bands == null) {
                this.bands = new ArrayList<>();
            }
            this.bands.addAll(Arrays.asList(bands));
        }
        return this;
    }

    public Integer getGridCount() {
        return gridCount;
    }

    public GaugeAxis setGridCount(Integer gridCount) {
        this.gridCount = gridCount;
        return this;
    }

    public String getId() {
        return id;
    }

    public GaugeAxis setId(String id) {
        this.id = id;
        return this;
    }

    public Boolean getLabelsEnabled() {
        return labelsEnabled;
    }

    public GaugeAxis setLabelsEnabled(Boolean labelsEnabled) {
        this.labelsEnabled = labelsEnabled;
        return this;
    }

    public Boolean getUsePrefixes() {
        return usePrefixes;
    }

    public GaugeAxis setUsePrefixes(Boolean usePrefixes) {
        this.usePrefixes = usePrefixes;
        return this;
    }

    public JsFunction getLabelFunction() {
        return labelFunction;
    }

    public GaugeAxis setLabelFunction(JsFunction labelFunction) {
        this.labelFunction = labelFunction;
        return this;
    }
}