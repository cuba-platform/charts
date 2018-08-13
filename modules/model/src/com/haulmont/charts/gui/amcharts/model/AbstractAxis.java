/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Base class for {@link ValueAxis} and {@link CategoryAxis}.
 * <br>
 * See documentation for properties of AxisBase JS Object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AxisBase">http://docs.amcharts.com/3/javascriptcharts/AxisBase</a>
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

    private Boolean centerRotatedLabels;

    /**
     * @return true if number of gridCount is specified automatically, according to the axis size
     */
    public Boolean getAutoGridCount() {
        return autoGridCount;
    }

    /**
     * Set autoGridCount to false if you don't want that the number of gridCount will be specified automatically,
     * according to the axis size. If not set the default value is true.
     *
     * @param autoGridCount auto grid count option
     */
    public T setAutoGridCount(Boolean autoGridCount) {
        this.autoGridCount = autoGridCount;
        return (T) this;
    }

    /**
     * @return axis opacity
     */
    public Double getAxisAlpha() {
        return axisAlpha;
    }

    /**
     * Sets axis opacity. Value range is 0 - 1. If not set the default value is 1.
     *
     * @param axisAlpha axis opacity
     */
    public T setAxisAlpha(Double axisAlpha) {
        this.axisAlpha = axisAlpha;
        return (T) this;
    }

    /**
     * @return axis color
     */
    public Color getAxisColor() {
        return axisColor;
    }

    /**
     * Sets axis color. If not set the default value is #000000.
     *
     * @param axisColor axis color
     */
    public T setAxisColor(Color axisColor) {
        this.axisColor = axisColor;
        return (T) this;
    }

    /**
     * @return thickness of the axis
     */
    public Integer getAxisThickness() {
        return axisThickness;
    }

    /**
     * Sets thickness of the axis. If not set the default value is 1.
     *
     * @param axisThickness thickness of the axis
     */
    public T setAxisThickness(Integer axisThickness) {
        this.axisThickness = axisThickness;
        return (T) this;
    }

    /**
     * @return color of axis value labels
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color of axis value labels. Will use chart's color if not set.
     *
     * @param color color of axis value labels
     */
    public T setColor(Color color) {
        this.color = color;
        return (T) this;
    }

    /**
     * @return length of a dash
     */
    public Integer getDashLength() {
        return dashLength;
    }

    /**
     * Sets length of a dash. 0 means line is not dashed. If not set the default value is 0.
     *
     * @param dashLength length of a dash
     */
    public T setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
        return (T) this;
    }

    /**
     * @return fill opacity
     */
    public Double getFillAlpha() {
        return fillAlpha;
    }

    /**
     * Sets fill opacity. Every second space between grid lines can be filled with color. Set fillAlpha to a value
     * greater than 0 to see the fills.
     *
     * @param fillAlpha fill opacity
     */
    public T setFillAlpha(Double fillAlpha) {
        this.fillAlpha = fillAlpha;
        return (T) this;
    }

    /**
     * @return fill color
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Set fill color. Every second space between grid lines can be filled with color. Set fillAlpha to a value greater
     * than 0 to see the fills. If not set the default value is #FFFFFF.
     *
     * @param fillColor fill color
     */
    public T setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        return (T) this;
    }

    /**
     * @return size of value labels text
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * Sets size of value labels text. Will use chart's fontSize if not set.
     *
     * @param fontSize size of value labels text
     */
    public T setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return (T) this;
    }

    /**
     * @return opacity of grid lines
     */
    public Double getGridAlpha() {
        return gridAlpha;
    }

    /**
     * Sets opacity of grid lines. If not set the default value is 0.15.
     *
     * @param gridAlpha opacity of grid lines
     */
    public T setGridAlpha(Double gridAlpha) {
        this.gridAlpha = gridAlpha;
        return (T) this;
    }

    /**
     * @return color of grid lines
     */
    public Color getGridColor() {
        return gridColor;
    }

    /**
     * Sets color of grid lines. If not set the default value is #000000
     *
     * @param gridColor color of grid lines
     */
    public T setGridColor(Color gridColor) {
        this.gridColor = gridColor;
        return (T) this;
    }

    /**
     * @return number of grid lines
     */
    public Integer getGridCount() {
        return gridCount;
    }

    /**
     * Sets number of grid lines. In case this is value axis, or your categoryAxis parses dates, the number is
     * approximate. The default value is 5. If you set autoGridCount to true, gridCount is ignored. If not set the
     * default value is 5.
     *
     * @param gridCount grid count
     */
    public T setGridCount(Integer gridCount) {
        this.gridCount = gridCount;
        return (T) this;
    }

    /**
     * @return thickness of grid lines
     */
    public Integer getGridThickness() {
        return gridThickness;
    }

    /**
     * Sets thickness of grid lines. If not set the default value is 1.
     *
     * @param gridThickness thickness of grid lines
     */
    public T setGridThickness(Integer gridThickness) {
        this.gridThickness = gridThickness;
        return (T) this;
    }

    /**
     * @return list of guides
     */
    public List<Guide> getGuides() {
        return guides;
    }

    /**
     * Sets list of guides belonging to this axis
     *
     * @param guides list of guides
     */
    public T setGuides(List<Guide> guides) {
        this.guides = guides;
        return (T) this;
    }

    /**
     * Adds guides.
     *
     * @param guides guides
     */
    public T addGuides(Guide... guides) {
        if (guides != null) {
            if (this.guides == null) {
                this.guides = new ArrayList<>();
            }
            this.guides.addAll(Arrays.asList(guides));
        }
        return (T) this;
    }

    /**
     * @return true if the axis isn't be measured when calculating margin.
     */
    public Boolean getIgnoreAxisWidth() {
        return ignoreAxisWidth;
    }

    /**
     * Set ignoreAxisWidth to true if autoMargins of a chart is set to true, but you want this axis not to be
     * measured when calculating margin. If not set the default value is false.
     *
     * @param ignoreAxisWidth ignoreAxisWidth option
     */
    public T setIgnoreAxisWidth(Boolean ignoreAxisWidth) {
        this.ignoreAxisWidth = ignoreAxisWidth;
        return (T) this;
    }

    /**
     * @return true if values placed inside of plot area
     */
    public Boolean getInside() {
        return inside;
    }

    /**
     * Set inside to true if values should be placed inside of plot area. If not set the default value is false.
     *
     * @param inside inside option
     */
    public T setInside(Boolean inside) {
        this.inside = inside;
        return (T) this;
    }

    /**
     * @return frequency at which labels should be placed
     */
    public Double getLabelFrequency() {
        return labelFrequency;
    }

    /**
     * Sets frequency at which labels should be placed. Doesn't work for CategoryAxis if parseDates is set to true.
     * If not set the default value is 1.
     *
     * @param labelFrequency frequency at which labels should be placed
     */
    public T setLabelFrequency(Double labelFrequency) {
        this.labelFrequency = labelFrequency;
        return (T) this;
    }

    /**
     * @return rotation angle of a label
     */
    public Integer getLabelRotation() {
        return labelRotation;
    }

    /**
     * Sets rotation angle of a label. Only horizontal axis values can be rotated. If you set this for vertical axis,
     * the setting will be ignored. Possible values from -90 to 90. If not set the default value is 0.
     *
     * @param labelRotation rotation angle of a label
     */
    public T setLabelRotation(Integer labelRotation) {
        this.labelRotation = labelRotation;
        return (T) this;
    }

    /**
     * @return true if axis displays category axis labels and value axis values.
     */
    public Boolean getLabelsEnabled() {
        return labelsEnabled;
    }

    /**
     * Set labelsEnabled to false if you don't wont to display category axis labels and value axis values. If not set
     * the default value is true.
     *
     * @param labelsEnabled labelsEnabled option
     */
    public T setLabelsEnabled(Boolean labelsEnabled) {
        this.labelsEnabled = labelsEnabled;
        return (T) this;
    }

    /**
     * @return minimum cell width required for one span between grid lines
     */
    public Integer getMinHorizontalGap() {
        return minHorizontalGap;
    }

    /**
     * Sets minimum cell width required for one span between grid lines. minHorizontalGap is used when calculating grid
     * count (when autoGridCount is true). If not set the default value is 75.
     *
     * @param minHorizontalGap minimum cell width required for one span between grid lines
     */
    public T setMinHorizontalGap(Integer minHorizontalGap) {
        this.minHorizontalGap = minHorizontalGap;
        return (T) this;
    }

    /**
     * @return opacity of minor grid
     */
    public Double getMinorGridAlpha() {
        return minorGridAlpha;
    }

    /**
     * Sets opacity of minor grid. In order minor to be visible, you should set minorGridEnabled to true. If not set
     * the default value is 0.07.
     *
     * @param minorGridAlpha opacity of minor grid
     */
    public T setMinorGridAlpha(Double minorGridAlpha) {
        this.minorGridAlpha = minorGridAlpha;
        return (T) this;
    }

    /**
     * @return true if minor grid is displayed
     */
    public Boolean getMinorGridEnabled() {
        return minorGridEnabled;
    }

    /**
     * Set minorGridEnabled to true if minor grid should be displayed. Note, if equalSpacing is set to true, this
     * setting will be ignored. If not set the default value is false.
     *
     * @param minorGridEnabled minorGridEnabled option
     */
    public T setMinorGridEnabled(Boolean minorGridEnabled) {
        this.minorGridEnabled = minorGridEnabled;
        return (T) this;
    }

    /**
     * @return minimum cell height required for one span between grid lines
     */
    public Integer getMinVerticalGap() {
        return minVerticalGap;
    }

    /**
     * Sets minimum cell height required for one span between grid lines. minVerticalGap is used when calculating grid
     * count (when autoGridCount is set to true). If not set the default value is 35.
     *
     * @param minVerticalGap minimum cell height required for one span between grid lines
     */
    public T setMinVerticalGap(Integer minVerticalGap) {
        this.minVerticalGap = minVerticalGap;
        return (T) this;
    }

    /**
     * @return the distance of the axis to the plot area, in pixels
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets the distance of the axis to the plot area, in pixels. Negative values can also be used. If not set the
     * default value is 0.
     *
     * @param offset the distance of the axis to the plot area, in pixels
     */
    public T setOffset(Integer offset) {
        this.offset = offset;
        return (T) this;
    }

    /**
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets position. Possible values are: "top", "bottom", "left", "right". If axis is vertical, default position is
     * "left". If axis is horizontal, default position is "bottom". If not set the default value is BOTTOM.
     *
     * @param position position
     */
    public T setPosition(Position position) {
        this.position = position;
        return (T) this;
    }

    /**
     * @return true if first axis label is shown
     */
    public Boolean getShowFirstLabel() {
        return showFirstLabel;
    }

    /**
     * Set showFirstLabel to false if you don't want to show first axis label. This works properly only
     * on {@link ValueAxis}. With {@link CategoryAxis} it wont work 100%, it depends on the period, zooming, etc.
     * There is no guaranteed way to force category axis to show or hide first label. If not set the default value is
     * true.
     *
     * @param showFirstLabel showFirstLabel option
     */
    public T setShowFirstLabel(Boolean showFirstLabel) {
        this.showFirstLabel = showFirstLabel;
        return (T) this;
    }

    /**
     * @return true if last axis label is shown
     */
    public Boolean getShowLastLabel() {
        return showLastLabel;
    }

    /**
     * Set showFirstLabel to false if you don't want to show last axis label. This works properly
     * only on {@link ValueAxis}. With {@link CategoryAxis} it wont work 100%, it depends on the period, zooming, etc.
     * There is no guaranteed way to force category axis to show or hide last label. If not set the default value is
     * true.
     *
     * @param showLastLabel showLastLabel option
     */
    public T setShowLastLabel(Boolean showLastLabel) {
        this.showLastLabel = showLastLabel;
        return (T) this;
    }

    /**
     * @return length of the tick marks
     */
    public Integer getTickLength() {
        return tickLength;
    }

    /**
     * Sets length of the tick marks. If not set the default value is 5.
     *
     * @param tickLength length of the tick marks
     */
    public T setTickLength(Integer tickLength) {
        this.tickLength = tickLength;
        return (T) this;
    }

    /**
     * @return title of the axis
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title of the axis.
     *
     * @param title title of the axis
     */
    public T setTitle(String title) {
        this.title = title;
        return (T) this;
    }

    /**
     * @return true if title is bold
     */
    public Boolean getTitleBold() {
        return titleBold;
    }

    /**
     * Set titleBold to false if title shouldn't be bold. If not set the default value is true.
     *
     * @param titleBold titleBold option
     */
    public T setTitleBold(Boolean titleBold) {
        this.titleBold = titleBold;
        return (T) this;
    }

    /**
     * @return color of axis title
     */
    public Color getTitleColor() {
        return titleColor;
    }

    /**
     * Sets color of axis title. Will use text color of chart if not set any.
     *
     * @param titleColor color of axis title
     */
    public T setTitleColor(Color titleColor) {
        this.titleColor = titleColor;
        return (T) this;
    }

    /**
     * @return font size of axis title
     */
    public Integer getTitleFontSize() {
        return titleFontSize;
    }

    /**
     * Sets font size of axis title. Will use font size of chart plus two pixels if not set any.
     *
     * @param titleFontSize font size of axis title
     */
    public T setTitleFontSize(Integer titleFontSize) {
        this.titleFontSize = titleFontSize;
        return (T) this;
    }

    /**
     * @return true if axis labels are bold.
     */
    public Boolean getBoldLabels() {
        return boldLabels;
    }

    /**
     * Set boldLabels to true if axis labels should be bold. If not set the default value is false.
     *
     * @param boldLabels bold labels option
     */
    public T setBoldLabels(Boolean boldLabels) {
        this.boldLabels = boldLabels;
        return (T) this;
    }

    /**
     * @return angle of label rotation
     */
    public Integer getAutoRotateAngle() {
        return autoRotateAngle;
    }

    /**
     * Sets angle of label rotation, if the number of series exceeds autoRotateCount. Works on horizontal axis only.
     * It is not recommended to use it with charts with zoom/scroll features, as chart adjusts margin only based on
     * initial render.
     *
     * @param autoRotateAngle angle of label rotation
     */
    public T setAutoRotateAngle(Integer autoRotateAngle) {
        this.autoRotateAngle = autoRotateAngle;
        return (T) this;
    }

    /**
     * @return auto rotate count
     */
    public Integer getAutoRotateCount() {
        return autoRotateCount;
    }

    /**
     * Sets auto rotate count. If the number of category axis items will exceed the autoRotateCount, the labels will
     * be rotated by autoRotateAngle degree. Works on horizontal axis only. Not recommended with scrollable/zoomable
     * charts.
     *
     * @param autoRotateCount auto rotate count
     */
    public T setAutoRotateCount(Integer autoRotateCount) {
        this.autoRotateCount = autoRotateCount;
        return (T) this;
    }

    /**
     * @return true if labels of the date-based axis is centered
     */
    public Boolean getCenterLabels() {
        return centerLabels;
    }

    /**
     * Set centerLabels to true if you want to center labels of the date-based axis (in case it's category axis,
     * equalSpacing must be false). If not set the default value is false.
     *
     * @param centerLabels center labels option
     */
    public T setCenterLabels(Boolean centerLabels) {
        this.centerLabels = centerLabels;
        return (T) this;
    }

    /**
     * @return list of date formats of different periods
     */
    public List<DateFormat> getDateFormats() {
        return dateFormats;
    }

    /**
     * Sets list of date formats of different periods. Possible period values: fff - milliseconds, ss - seconds, mm -
     * minutes, hh - hours, DD - days, MM - months, WW - weeks, YYYY - years. If not set the default value is
     *
     * <pre>{@code
     *  [{"period":"fff",  "format":"JJ:NN:SS"},
     *   {"period":"ss",   "format":"JJ:NN:SS"},
     *   {"period":"mm",   "format":"JJ:NN"},
     *   {"period":"hh",   "format":"JJ:NN"},
     *   {"period":"DD",   "format":"MMM DD"},
     *   {"period":"WW",   "format":"MMM DD"},
     *   {"period":"MM",   "format":"MMM"},
     *   {"period":"YYYY", "format":"YYYY"}]
     * }
     * </pre>
     *
     * @param dateFormats list of date formats
     */
    public T setDateFormats(List<DateFormat> dateFormats) {
        this.dateFormats = dateFormats;
        return (T) this;
    }

    /**
     * Adds date formats.
     *
     * @param dateFormats date formats
     */
    public T addDateFormats(DateFormat... dateFormats) {
        if (dateFormats != null) {
            if (this.dateFormats == null) {
                this.dateFormats = new ArrayList<>();
            }
            this.dateFormats.addAll(Arrays.asList(dateFormats));
        }
        return (T) this;
    }

    /**
     * @return length of minor grid tick
     */
    public Integer getMinorTickLength() {
        return minorTickLength;
    }

    /**
     * Sets length of minor grid tick. If not set the default value is 0.
     *
     * @param minorTickLength length of minor grid tick
     */
    public T setMinorTickLength(Integer minorTickLength) {
        this.minorTickLength = minorTickLength;
        return (T) this;
    }

    /**
     * @return rotation of axis title
     */
    public Integer getTitleRotation() {
        return titleRotation;
    }

    /**
     * Sets rotation of axis title. Useful if you want to make vertical axis title to be shown from top to down.
     *
     * @param titleRotation rotation of axis title
     */
    public T setTitleRotation(Integer titleRotation) {
        this.titleRotation = titleRotation;
        return (T) this;
    }

    /**
     * @return balloon
     */
    public Balloon getBalloon() {
        return balloon;
    }

    /**
     * Sets balloon to the axis.
     *
     * @param balloon balloon
     */
    public T setBalloon(Balloon balloon) {
        this.balloon = balloon;
        return (T) this;
    }

    /**
     * @return true if chart highlights the beginning of the periods in bold
     */
    public Boolean getBoldPeriodBeginning() {
        return boldPeriodBeginning;
    }

    /**
     * Set boldPeriodBeginning to false if you want chart will not try to highlight the beginning of
     * the periods, like month, in bold. If not set the default value is true.
     *
     * @param boldPeriodBeginning boldPeriodBeginning option
     */
    public T setBoldPeriodBeginning(Boolean boldPeriodBeginning) {
        this.boldPeriodBeginning = boldPeriodBeginning;
        return (T) this;
    }

    /**
     * @return true if labels centered between grid lines
     */
    public Boolean getCenterLabelOnFullPeriod() {
        return centerLabelOnFullPeriod;
    }

    /**
     * Set centerLabelOnFullPeriod to false if you want labels never to be centered between grid lines.
     * This setting works only when parseDates is set to true and equalSpacing is set to false. If not set the
     * default value is true.
     *
     * @param centerLabelOnFullPeriod centerLabelOnFullPeriod option
     */
    public T setCenterLabelOnFullPeriod(Boolean centerLabelOnFullPeriod) {
        this.centerLabelOnFullPeriod = centerLabelOnFullPeriod;
        return (T) this;
    }

    /**
     * @return first day of the week
     */
    public DayOfWeek getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    /**
     * Sets first day of the week. 0 is Sunday, 1 is Monday, etc. If not set the default value is 1.
     *
     * @param firstDayOfWeek first day of the week
     */
    public T setFirstDayOfWeek(DayOfWeek firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
        return (T) this;
    }

    /**
     * @return offset of axes labels
     */
    public Integer getLabelOffset() {
        return labelOffset;
    }

    /**
     * Sets offset of axes labels. Works both with {@link CategoryAxis} and {@link ValueAxis}. If not set the default
     * value is 0.
     *
     * @param labelOffset offset of axes labels
     */
    public T setLabelOffset(Integer labelOffset) {
        this.labelOffset = labelOffset;
        return (T) this;
    }

    /**
     * @return true if the start of longer periods uses a different date
     */
    public Boolean getMarkPeriodChange() {
        return markPeriodChange;
    }

    /**
     * Set markPeriodChange to false if the start of longer periods shouldn't use a different date format and
     * shouldn't be bold. If not set the default value is true.
     *
     * @param markPeriodChange markPeriodChange option
     */
    public T setMarkPeriodChange(Boolean markPeriodChange) {
        this.markPeriodChange = markPeriodChange;
        return (T) this;
    }

    /**
     * @return true if rotated labels are force-centered
     */
    public Boolean getCenterRotatedLabels() {
        return centerRotatedLabels;
    }

    /**
     * In case you have rotated labels on horizontal axis, you can force-center them using this property. If not set
     * the default value is false.
     *
     * @param centerRotatedLabels centerRotatedLabels option
     */
    public void setCenterRotatedLabels(Boolean centerRotatedLabels) {
        this.centerRotatedLabels = centerRotatedLabels;
    }
}