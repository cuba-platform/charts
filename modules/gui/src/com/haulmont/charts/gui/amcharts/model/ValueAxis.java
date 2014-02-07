/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.Map;

/**
 * See documentation for properties of ValueAxis JS Object.
 *
 * @author artamonov
 * @version $Id$
 */
public class ValueAxis extends AbstractAxis<ValueAxis> {

    private static final long serialVersionUID = -8718385614937510600L;

    private Integer axisTitleOffset;

    private Double baseValue;

    private Duration duration;

    private Map<Duration, String> durationUnits;

    private GridType gridType;

    private String id;

    private Boolean includeGuidesInMinMax;

    private Boolean includeHidden;

    private Boolean integersOnly;

    private JsFunction labelFunction;

    private Boolean logarithmic;

    private Double maximum;

    private Double minimum;

    private Double minMaxMultiplier;

    private Integer precision;

    private Boolean radarCategoriesEnabled;

    private Boolean recalculateToPercents;

    private Boolean reversed;

    private StackType stackType;

    private Double synchronizationMultiplier;

    private String synchronizeWith;

    private String totalText;

    private Color totalTextColor;

    private String unit;

    private UnitPosition unitPosition;

    private Boolean usePrefixes;

    private Boolean useScientificNotation;

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

    public JsFunction getLabelFunction() {
        return labelFunction;
    }

    public ValueAxis setLabelFunction(JsFunction labelFunction) {
        this.labelFunction = labelFunction;
        return this;
    }

    public String getSynchronizeWith() {
        return synchronizeWith;
    }

    public ValueAxis setSynchronizeWith(String synchronizeWith) {
        this.synchronizeWith = synchronizeWith;
        return this;
    }
}