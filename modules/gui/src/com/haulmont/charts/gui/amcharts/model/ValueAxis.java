/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsFunction;

import java.util.Date;
import java.util.Map;

/**
 * See documentation for properties of ValueAxis JS Object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/ValueAxis">http://docs.amcharts.com/3/javascriptcharts/ValueAxis</a>
 *
 */
public class ValueAxis extends AbstractAxis<ValueAxis> {

    private static final long serialVersionUID = -8718385614937510600L;

    private Double axisFrequency;

    private Integer axisTitleOffset;

    private JsFunction balloonTextFunction;

    private Double baseValue;

    private Duration duration;

    private Map<Duration, String> durationUnits;

    private GridType gridType;

    private String id;

    private Boolean includeAllValues;

    private Boolean includeGuidesInMinMax;

    private Boolean includeHidden;

    private Boolean integersOnly;

    private JsFunction labelFunction;

    private Boolean logarithmic;

    private Double maximum;

    private Date maximumDate;

    private Double minimum;

    private Date minimumDate;

    private Double minMaxMultiplier;

    private PointPosition pointPosition;

    private Integer precision;

    private Boolean radarCategoriesEnabled;

    private Boolean recalculateToPercents;

    private Boolean reversed;

    private StackType stackType;

    private Boolean strictMinMax;

    private Double synchronizationMultiplier;

    private String synchronizeWith;

    private String totalText;

    private Color totalTextColor;

    private Integer totalTextOffset;

    private Double treatZeroAs;

    private ValueAxisType type;

    private String unit;

    private UnitPosition unitPosition;

    private Boolean usePrefixes;

    private Boolean useScientificNotation;

    private Double zeroGridAlpha;

    public Integer getAxisTitleOffset() {
        return axisTitleOffset;
    }

    public ValueAxis setAxisTitleOffset(Integer axisTitleOffset) {
        this.axisTitleOffset = axisTitleOffset;
        return this;
    }

    public Double getBaseValue() {
        return baseValue;
    }

    public ValueAxis setBaseValue(Double baseValue) {
        this.baseValue = baseValue;
        return this;
    }

    public Duration getDuration() {
        return duration;
    }

    public ValueAxis setDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    public Map<Duration, String> getDurationUnits() {
        return durationUnits;
    }

    public ValueAxis setDurationUnits(Map<Duration, String> durationUnits) {
        this.durationUnits = durationUnits;
        return this;
    }

    public GridType getGridType() {
        return gridType;
    }

    public ValueAxis setGridType(GridType gridType) {
        this.gridType = gridType;
        return this;
    }

    public String getId() {
        return id;
    }

    public ValueAxis setId(String id) {
        this.id = id;
        return this;
    }

    public Boolean getIncludeGuidesInMinMax() {
        return includeGuidesInMinMax;
    }

    public ValueAxis setIncludeGuidesInMinMax(Boolean includeGuidesInMinMax) {
        this.includeGuidesInMinMax = includeGuidesInMinMax;
        return this;
    }

    public Boolean getIncludeHidden() {
        return includeHidden;
    }

    public ValueAxis setIncludeHidden(Boolean includeHidden) {
        this.includeHidden = includeHidden;
        return this;
    }

    public Boolean getIntegersOnly() {
        return integersOnly;
    }

    public ValueAxis setIntegersOnly(Boolean integersOnly) {
        this.integersOnly = integersOnly;
        return this;
    }

    public Boolean getLogarithmic() {
        return logarithmic;
    }

    public ValueAxis setLogarithmic(Boolean logarithmic) {
        this.logarithmic = logarithmic;
        return this;
    }

    public Double getMaximum() {
        return maximum;
    }

    public ValueAxis setMaximum(Double maximum) {
        this.maximum = maximum;
        return this;
    }

    public Double getMinimum() {
        return minimum;
    }

    public ValueAxis setMinimum(Double minimum) {
        this.minimum = minimum;
        return this;
    }

    public Double getMinMaxMultiplier() {
        return minMaxMultiplier;
    }

    public ValueAxis setMinMaxMultiplier(Double minMaxMultiplier) {
        this.minMaxMultiplier = minMaxMultiplier;
        return this;
    }

    public Integer getPrecision() {
        return precision;
    }

    public ValueAxis setPrecision(Integer precision) {
        this.precision = precision;
        return this;
    }

    public Boolean getRadarCategoriesEnabled() {
        return radarCategoriesEnabled;
    }

    public ValueAxis setRadarCategoriesEnabled(Boolean radarCategoriesEnabled) {
        this.radarCategoriesEnabled = radarCategoriesEnabled;
        return this;
    }

    public Boolean getRecalculateToPercents() {
        return recalculateToPercents;
    }

    public ValueAxis setRecalculateToPercents(Boolean recalculateToPercents) {
        this.recalculateToPercents = recalculateToPercents;
        return this;
    }

    public Boolean getReversed() {
        return reversed;
    }

    public ValueAxis setReversed(Boolean reversed) {
        this.reversed = reversed;
        return this;
    }

    public StackType getStackType() {
        return stackType;
    }

    public ValueAxis setStackType(StackType stackType) {
        this.stackType = stackType;
        return this;
    }

    public Double getSynchronizationMultiplier() {
        return synchronizationMultiplier;
    }

    public ValueAxis setSynchronizationMultiplier(Double synchronizationMultiplier) {
        this.synchronizationMultiplier = synchronizationMultiplier;
        return this;
    }

    public String getTotalText() {
        return totalText;
    }

    public ValueAxis setTotalText(String totalText) {
        this.totalText = totalText;
        return this;
    }

    public Color getTotalTextColor() {
        return totalTextColor;
    }

    public ValueAxis setTotalTextColor(Color totalTextColor) {
        this.totalTextColor = totalTextColor;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public ValueAxis setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public UnitPosition getUnitPosition() {
        return unitPosition;
    }

    public ValueAxis setUnitPosition(UnitPosition unitPosition) {
        this.unitPosition = unitPosition;
        return this;
    }

    public Boolean getUsePrefixes() {
        return usePrefixes;
    }

    public ValueAxis setUsePrefixes(Boolean usePrefixes) {
        this.usePrefixes = usePrefixes;
        return this;
    }

    public Boolean getUseScientificNotation() {
        return useScientificNotation;
    }

    public ValueAxis setUseScientificNotation(Boolean useScientificNotation) {
        this.useScientificNotation = useScientificNotation;
        return this;
    }

    public String getSynchronizeWith() {
        return synchronizeWith;
    }

    public ValueAxis setSynchronizeWith(String synchronizeWith) {
        this.synchronizeWith = synchronizeWith;
        return this;
    }

    public Integer getTotalTextOffset() {
        return totalTextOffset;
    }

    public ValueAxis setTotalTextOffset(Integer totalTextOffset) {
        this.totalTextOffset = totalTextOffset;
        return this;
    }

    public Double getTreatZeroAs() {
        return treatZeroAs;
    }

    public ValueAxis setTreatZeroAs(Double treatZeroAs) {
        this.treatZeroAs = treatZeroAs;
        return this;
    }

    public Boolean getIncludeAllValues() {
        return includeAllValues;
    }

    public ValueAxis setIncludeAllValues(Boolean includeAllValues) {
        this.includeAllValues = includeAllValues;
        return this;
    }

    public JsFunction getLabelFunction() {
        return labelFunction;
    }

    public ValueAxis setLabelFunction(JsFunction labelFunction) {
        this.labelFunction = labelFunction;
        return this;
    }

    public Date getMaximumDate() {
        return maximumDate;
    }

    public ValueAxis setMaximumDate(Date maximumDate) {
        this.maximumDate = maximumDate;
        return this;
    }

    public Date getMinimumDate() {
        return minimumDate;
    }

    public ValueAxis setMinimumDate(Date minimumDate) {
        this.minimumDate = minimumDate;
        return this;
    }

    public PointPosition getPointPosition() {
        return pointPosition;
    }

    public ValueAxis setPointPosition(PointPosition pointPosition) {
        this.pointPosition = pointPosition;
        return this;
    }

    public Boolean getStrictMinMax() {
        return strictMinMax;
    }

    public ValueAxis setStrictMinMax(Boolean strictMinMax) {
        this.strictMinMax = strictMinMax;
        return this;
    }

    public ValueAxisType getType() {
        return type;
    }

    public ValueAxis setType(ValueAxisType type) {
        this.type = type;
        return this;
    }

    public Double getZeroGridAlpha() {
        return zeroGridAlpha;
    }

    public ValueAxis setZeroGridAlpha(Double zeroGridAlpha) {
        this.zeroGridAlpha = zeroGridAlpha;
        return this;
    }

    public Double getAxisFrequency() {
        return axisFrequency;
    }

    public ValueAxis setAxisFrequency(Double axisFrequency) {
        this.axisFrequency = axisFrequency;
        return this;
    }

    public JsFunction getBalloonTextFunction() {
        return balloonTextFunction;
    }

    public ValueAxis setBalloonTextFunction(JsFunction balloonTextFunction) {
        this.balloonTextFunction = balloonTextFunction;
        return this;
    }
}