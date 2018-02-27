/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsFunction;

import java.util.Date;
import java.util.Map;

/**
 * See documentation for properties of ValueAxis JS Object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/ValueAxis">http://docs.amcharts.com/3/javascriptcharts/ValueAxis</a>
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

    /**
     * @return the distance from axis to the axis title (category)
     */
    public Integer getAxisTitleOffset() {
        return axisTitleOffset;
    }

    /**
     * Sets the distance from axis to the axis title (category). Work with radar chart only.
     *
     * @param axisTitleOffset axis title offset
     */
    public ValueAxis setAxisTitleOffset(Integer axisTitleOffset) {
        this.axisTitleOffset = axisTitleOffset;
        return this;
    }

    /**
     * @return the base value of the axis
     */
    public Double getBaseValue() {
        return baseValue;
    }

    /**
     * Sets the base value of the axis.
     *
     * @param baseValue base value
     */
    public ValueAxis setBaseValue(Double baseValue) {
        this.baseValue = baseValue;
        return this;
    }

    /**
     * @return the duration unit
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Set the duration unit if your values represents time units, and you want value axis labels to be formatted as
     * duration. Possible values are: "ss", "mm", "hh" and "DD".
     *
     * @param duration duration
     */
    public ValueAxis setDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    /**
     * @return duration units map
     */
    public Map<Duration, String> getDurationUnits() {
        return durationUnits;
    }

    /**
     * If duration property is set, you can specify what string should be displayed next to day, hour, minute and
     * second. I.e. pairs like: "DD": "d.", "hh": ":", "mm": ":", "ss": " "
     *
     * @param durationUnits duration units map
     */
    public ValueAxis setDurationUnits(Map<Duration, String> durationUnits) {
        this.durationUnits = durationUnits;
        return this;
    }

    /**
     * @return grid type
     */
    public GridType getGridType() {
        return gridType;
    }

    /**
     * Sets grid type. Possible values are: "polygons" and "circles". Set "circles" for polar charts. Work with radar
     * chart only.
     *
     * @param gridType grid type
     */
    public ValueAxis setGridType(GridType gridType) {
        this.gridType = gridType;
        return this;
    }

    /**
     * @return unique id of value axis
     */
    public String getId() {
        return id;
    }

    /**
     * Sets unique id of value axis. It is not required to set it, unless you need to tell the graph which exact value
     * axis it should use.
     *
     * @param id id
     */
    public ValueAxis setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return true the guide values are included when calculating minimum and maximum of the axis
     */
    public Boolean getIncludeGuidesInMinMax() {
        return includeGuidesInMinMax;
    }

    /**
     * Set includeGuidesInMinMax to true the guide values should be included when calculating minimum and maximum of
     * the axis.
     *
     * @param includeGuidesInMinMax includeGuidesInMinMax option
     */
    public ValueAxis setIncludeGuidesInMinMax(Boolean includeGuidesInMinMax) {
        this.includeGuidesInMinMax = includeGuidesInMinMax;
        return this;
    }

    /**
     * @return true if the axis includes hidden graphs when calculating minimum and maximum values
     */
    public Boolean getIncludeHidden() {
        return includeHidden;
    }

    /**
     * Sets includeHidden to true if the axis should include hidden graphs when calculating minimum and maximum values.
     *
     * @param includeHidden includeHidden option
     */
    public ValueAxis setIncludeHidden(Boolean includeHidden) {
        this.includeHidden = includeHidden;
        return this;
    }

    /**
     * @return true if values on the axis are only integers
     */
    public Boolean getIntegersOnly() {
        return integersOnly;
    }

    /**
     * Set integersOnly to true if values on the axis can only be integers.
     *
     * @param integersOnly integersOnly option
     */
    public ValueAxis setIntegersOnly(Boolean integersOnly) {
        this.integersOnly = integersOnly;
        return this;
    }

    /**
     * @return true if this value axis scale is logarithmic
     */
    public Boolean getLogarithmic() {
        return logarithmic;
    }

    /**
     * Set logarithmic to true if this value axis scale should be logarithmic.
     *
     * @param logarithmic logarithmic option
     */
    public ValueAxis setLogarithmic(Boolean logarithmic) {
        this.logarithmic = logarithmic;
        return this;
    }

    /**
     * @return maximum value
     */
    public Double getMaximum() {
        return maximum;
    }

    /**
     * Set maximum value if you don't want maximum value to be calculated by the chart. This value might still be
     * adjusted so that it would be possible to draw grid at rounded intervals.
     *
     * @param maximum maximum value
     */
    public ValueAxis setMaximum(Double maximum) {
        this.maximum = maximum;
        return this;
    }

    /**
     * @return minimum value
     */
    public Double getMinimum() {
        return minimum;
    }

    /**
     * Set minimum value if you don't want minimum value to be calculated by the chart. This value might still be
     * adjusted so that it would be possible to draw grid at rounded intervals.
     *
     * @param minimum minimum value
     */
    public ValueAxis setMinimum(Double minimum) {
        this.minimum = minimum;
        return this;
    }

    /**
     * @return minimum and maximum multiplier
     */
    public Double getMinMaxMultiplier() {
        return minMaxMultiplier;
    }

    /**
     * Sets minimum and maximum multiplier. If set value axis scale (min and max numbers) will be multiplied by it.
     * I.e. if set to 1.2 the scope of values will increase by 20%.
     *
     * @param minMaxMultiplier minimum and maximum multiplier
     */
    public ValueAxis setMinMaxMultiplier(Double minMaxMultiplier) {
        this.minMaxMultiplier = minMaxMultiplier;
        return this;
    }

    /**
     * @return precision (number of decimals) of values
     */
    public Integer getPrecision() {
        return precision;
    }

    /**
     * Sets precision (number of decimals) of values.
     *
     * @param precision precision
     */
    public ValueAxis setPrecision(Integer precision) {
        this.precision = precision;
        return this;
    }

    /**
     * @return true if categories (axes titles) are displayed near axes
     */
    public Boolean getRadarCategoriesEnabled() {
        return radarCategoriesEnabled;
    }

    /**
     * Set radarCategoriesEnabled to false if categories (axes titles) shouldn't be displayed near axes.
     *
     * @param radarCategoriesEnabled radarCategoriesEnabled option
     */
    public ValueAxis setRadarCategoriesEnabled(Boolean radarCategoriesEnabled) {
        this.radarCategoriesEnabled = radarCategoriesEnabled;
        return this;
    }

    /**
     * @return true if graphs values are recalculated to percents
     */
    public Boolean getRecalculateToPercents() {
        return recalculateToPercents;
    }

    /**
     * Set recalculateToPercents to true, if graphs values should be recalculated to percents. Note, that this
     * setting will work only on serial chart (and stock), not on any other charts that are using {@link ValueAxis},
     * like XY chart.
     *
     * @param recalculateToPercents recalculateToPercents option
     */
    public ValueAxis setRecalculateToPercents(Boolean recalculateToPercents) {
        this.recalculateToPercents = recalculateToPercents;
        return this;
    }

    /**
     * @return true if value axis is reversed
     */
    public Boolean getReversed() {
        return reversed;
    }

    /**
     * Set reversed to true if value axis should be reversed (smaller values on top).
     *
     * @param reversed reversed option
     */
    public ValueAxis setReversed(Boolean reversed) {
        this.reversed = reversed;
        return this;
    }

    /**
     * @return stacking mode of the axis
     */
    public StackType getStackType() {
        return stackType;
    }

    /**
     * Sets	stacking mode of the axis. Possible values are: "none", "regular", "100%", "3d". Note, only graphs of one
     * type will be stacked.
     *
     * @param stackType stack type
     */
    public ValueAxis setStackType(StackType stackType) {
        this.stackType = stackType;
        return this;
    }

    /**
     * @return synchronization multiplier
     */
    public Double getSynchronizationMultiplier() {
        return synchronizationMultiplier;
    }

    /**
     * Set the synchronization multiplier, in case you synchronize one value axis with another.
     *
     * @param synchronizationMultiplier synchronization multiplier
     */
    public ValueAxis setSynchronizationMultiplier(Double synchronizationMultiplier) {
        this.synchronizationMultiplier = synchronizationMultiplier;
        return this;
    }

    /**
     * @return total text
     */
    public String getTotalText() {
        return totalText;
    }

    /**
     * Sets total text. If this value axis is stacked and has columns, setting to "[[total]]" will make it to
     * display total value above the most-top column.
     *
     * @param totalText total text
     */
    public ValueAxis setTotalText(String totalText) {
        this.totalText = totalText;
        return this;
    }

    /**
     * @return color of total text
     */
    public Color getTotalTextColor() {
        return totalTextColor;
    }

    /**
     * Sets color of total text.
     *
     * @param totalTextColor color
     */
    public ValueAxis setTotalTextColor(Color totalTextColor) {
        this.totalTextColor = totalTextColor;
        return this;
    }

    /**
     * @return unit which is added to the value label
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets unit which will be added to the value label.
     *
     * @param unit unit
     */
    public ValueAxis setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * @return position of the unit
     */
    public UnitPosition getUnitPosition() {
        return unitPosition;
    }

    /**
     * Sets position of the unit. Possible values are "left" and "right".
     *
     * @param unitPosition unit position
     */
    public ValueAxis setUnitPosition(UnitPosition unitPosition) {
        this.unitPosition = unitPosition;
        return this;
    }

    /**
     * @return true if prefixes are used for big and small numbers
     */
    public Boolean getUsePrefixes() {
        return usePrefixes;
    }

    /**
     * Set usePrefixes to true, if prefixes should be used for big and small numbers. You can set list of prefixes
     * directly to the chart via
     * {@link com.haulmont.charts.gui.amcharts.model.charts.AbstractChart#prefixesOfSmallNumbers prefixesOfSmallNumbers}
     * and
     * {@link com.haulmont.charts.gui.amcharts.model.charts.AbstractChart#prefixesOfBigNumbers prefixesOfBigNumbers}.
     *
     * @param usePrefixes usePrefixes option
     */
    public ValueAxis setUsePrefixes(Boolean usePrefixes) {
        this.usePrefixes = usePrefixes;
        return this;
    }

    /**
     * @return true if values are formatted using scientific notation (5e+8, 5e-8...)
     */
    public Boolean getUseScientificNotation() {
        return useScientificNotation;
    }

    /**
     * Set useScientificNotation to true if values should always be formatted using scientific notation (5e+8, 5e-8...).
     * Otherwise only values bigger then 1e+21 and smaller then 1e-7 will be displayed in scientific notation.
     *
     * @param useScientificNotation useScientificNotation option
     */
    public ValueAxis setUseScientificNotation(Boolean useScientificNotation) {
        this.useScientificNotation = useScientificNotation;
        return this;
    }

    /**
     * @return synchronized value axis id
     */
    public String getSynchronizeWith() {
        return synchronizeWith;
    }

    /**
     * One value axis can be synchronized with another value axis. You can use id of the axis here. You should set
     * synchronizationMultiplier in order for this to work.
     *
     * @param synchronizeWith id of the axis
     */
    public ValueAxis setSynchronizeWith(String synchronizeWith) {
        this.synchronizeWith = synchronizeWith;
        return this;
    }

    /**
     * @return distance from data point to total text
     */
    public Integer getTotalTextOffset() {
        return totalTextOffset;
    }

    /**
     * Sets distance from data point to total text.
     *
     * @param totalTextOffset total text offset
     */
    public ValueAxis setTotalTextOffset(Integer totalTextOffset) {
        this.totalTextOffset = totalTextOffset;
        return this;
    }

    /**
     * @return treatZeroAs value
     */
    public Double getTreatZeroAs() {
        return treatZeroAs;
    }

    /**
     * This allows you to have logarithmic value axis and have zero values in the data. You must set it to greater
     * than 0 value in order to work.
     *
     * @param treatZeroAs treatZeroAs value
     */
    public ValueAxis setTreatZeroAs(Double treatZeroAs) {
        this.treatZeroAs = treatZeroAs;
        return this;
    }

    /**
     * @return true if minimum and maximum of value axis doesn't change while zooming/scrolling
     */
    public Boolean getIncludeAllValues() {
        return includeAllValues;
    }

    /**
     * Set includeAllValues to true if minimum and maximum of value axis shouldn't change while zooming/scrolling.
     *
     * @param includeAllValues includeAllValues option
     */
    public ValueAxis setIncludeAllValues(Boolean includeAllValues) {
        this.includeAllValues = includeAllValues;
        return this;
    }

    /**
     * @return JS function to format value axis labels
     */
    public JsFunction getLabelFunction() {
        return labelFunction;
    }

    /**
     * Sets JS function to format value axis labels. This function is called and these parameters are
     * passed: labelFunction(value, valueText, valueAxis); Where value is numeric value, valueText is formatted
     * string and valueAxis is a reference to valueAxis object. If axis type is "date", labelFunction will pass
     * different arguments: labelFunction(valueText, date, valueAxis). Your function should return string.
     *
     * @param labelFunction JS function
     */
    public ValueAxis setLabelFunction(JsFunction labelFunction) {
        this.labelFunction = labelFunction;
        return this;
    }

    /**
     * @return maximum date of the axis
     */
    public Date getMaximumDate() {
        return maximumDate;
    }

    /**
     * Sets maximum date of the axis, if your value axis is date-based.
     *
     * @param maximumDate maximum date
     */
    public ValueAxis setMaximumDate(Date maximumDate) {
        this.maximumDate = maximumDate;
        return this;
    }

    /**
     * @return minimum date of the axis
     */
    public Date getMinimumDate() {
        return minimumDate;
    }

    /**
     * Sets minimum date of the axis, if your value axis is date-based.
     *
     * @param minimumDate minimum date
     */
    public ValueAxis setMinimumDate(Date minimumDate) {
        this.minimumDate = minimumDate;
        return this;
    }

    /**
     * @return point position
     */
    public PointPosition getPointPosition() {
        return pointPosition;
    }

    /**
     * Sets point position. If you set it to “middle”, labels and data points will be placed in the middle between
     * axes. Works with radar charts only.
     *
     * @param pointPosition point position
     */
    public ValueAxis setPointPosition(PointPosition pointPosition) {
        this.pointPosition = pointPosition;
        return this;
    }

    /**
     * @return true if the chart doesn't adjust minimum and maximum of value axis
     */
    public Boolean getStrictMinMax() {
        return strictMinMax;
    }

    /**
     * If you set minimum and maximum for your axis, chart adjusts them so that grid would start and end on the
     * beginning and end of plot area and grid would be at equal intervals. If you set strictMinMax to true, the
     * chart will not adjust minimum and maximum of value axis.
     *
     * @param strictMinMax strictMinMax option
     */
    public ValueAxis setStrictMinMax(Boolean strictMinMax) {
        this.strictMinMax = strictMinMax;
        return this;
    }

    /**
     * @return type of value axis
     */
    public ValueAxisType getType() {
        return type;
    }

    /**
     * Sets type of value axis. If your values in data provider are dates and you want this axis to show dates
     * instead of numbers, set it to "date".
     *
     * @param type type
     */
    public ValueAxis setType(ValueAxisType type) {
        this.type = type;
        return this;
    }

    /**
     * @return opacity of a zero grid line
     */
    public Double getZeroGridAlpha() {
        return zeroGridAlpha;
    }

    /**
     * Sets opacity of a zero grid line. By default it is equal to 2 x gridAlpha.
     *
     * @param zeroGridAlpha opacity
     */
    public ValueAxis setZeroGridAlpha(Double zeroGridAlpha) {
        this.zeroGridAlpha = zeroGridAlpha;
        return this;
    }

    /**
     * @return axis frequency
     */
    public Double getAxisFrequency() {
        return axisFrequency;
    }

    /**
     * Sets axis frequency. If you have a big number of axes, this property will help you to show every X axis only.
     * Works with radar chart only.
     *
     * @param axisFrequency axis frequency
     */
    public ValueAxis setAxisFrequency(Double axisFrequency) {
        this.axisFrequency = axisFrequency;
        return this;
    }

    /**
     * @return JS function to format balloon text of the axis
     */
    public JsFunction getBalloonTextFunction() {
        return balloonTextFunction;
    }

    /**
     * Sets JS function to format balloon text of the axis. This function is called and balloon text or date
     * (if axis is date-based) is passed as an argument. It should return string which will be displayed in the balloon.
     *
     * @param balloonTextFunction JS function
     */
    public ValueAxis setBalloonTextFunction(JsFunction balloonTextFunction) {
        this.balloonTextFunction = balloonTextFunction;
        return this;
    }
}