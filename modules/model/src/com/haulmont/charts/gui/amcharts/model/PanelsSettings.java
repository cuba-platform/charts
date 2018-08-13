/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.amcharts.model.charts.StockPanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Defines set of properties for all StockPanels. If there is no default value specified, default value of
 * {@link StockPanel} class will be used.
 * <br>
 * See documentation for properties of PanelsSettings JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/PanelsSettings">http://docs.amcharts.com/3/javascriptstockchart/PanelsSettings</a>
 */
public class PanelsSettings extends AbstractChartObject implements HasMargins<PanelsSettings>,
        HasStartEffect<PanelsSettings> {

    private static final long serialVersionUID = -4296426800291941801L;

    private Integer angle;

    private Double backgroundAlpha;

    private Color backgroundColor;

    private Integer columnSpacing;

    private Integer columnWidth;

    private CreditsPosition creditsPosition;

    private String decimalSeparator;

    private Integer depth3D;

    private String fontFamily;

    private Integer fontSize;

    private Integer marginBottom;

    private Integer marginLeft;

    private Integer marginRight;

    private Integer marginTop;

    private Long maxSelectedTime;

    private Long minSelectedTime;

    private Integer panelSpacing;

    private Boolean panEventsEnabled;

    private Double percentPrecision;

    private Double plotAreaBorderAlpha;

    private Color plotAreaBorderColor;

    private Double plotAreaFillAlphas;

    private List<Color> plotAreaFillColors;

    private Double precision;

    private List<BigNumberPrefix> prefixesOfBigNumbers;

    private List<SmallNumberPrefix> prefixesOfSmallNumbers;

    private RecalculateToPercents recalculateToPercents;

    private Boolean sequencedAnimation;

    private Double startAlpha;

    private Double startDuration;

    private AnimationEffect startEffect;

    private String thousandsSeparator;

    private Boolean usePrefixes;

    private Boolean zoomOutAxes;

    /**
     * @return angle of the 3D part of plot area
     */
    public Integer getAngle() {
        return angle;
    }

    /**
     * Sets the angle of the 3D part of plot area. This creates a 3D effect (if the depth3D is greater than 0).
     *
     * @param angle angle
     */
    public PanelsSettings setAngle(Integer angle) {
        this.angle = angle;
        return this;
    }

    /**
     * @return opacity of panel background
     */
    public Double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    /**
     * Sets opacity of panel background. Possible values are 1 and 0. Values like 0.5 will not make it half-transparent.
     * If not set the default value is 0.
     *
     * @param backgroundAlpha opacity
     */
    public PanelsSettings setBackgroundAlpha(Double backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
        return this;
    }

    /**
     * @return background color of panels
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets background color of panels. Set backgroundAlpha to greater than 0 value in order to make background visible.
     * If not set the default value is #FFFFFF.
     *
     * @param backgroundColor color
     */
    public PanelsSettings setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * @return gap in pixels between two columns of the same category
     */
    public Integer getColumnSpacing() {
        return columnSpacing;
    }

    /**
     * Sets the gap in pixels between two columns of the same category.
     *
     * @param columnSpacing column spacing
     */
    public PanelsSettings setColumnSpacing(Integer columnSpacing) {
        this.columnSpacing = columnSpacing;
        return this;
    }

    /**
     * @return relative width of columns
     */
    public Integer getColumnWidth() {
        return columnWidth;
    }

    /**
     * Sets relative width of columns. Valid values 0 - 1.
     *
     * @param columnWidth column relative width
     */
    public PanelsSettings setColumnWidth(Integer columnWidth) {
        this.columnWidth = columnWidth;
        return this;
    }

    /**
     * @return credits position
     */
    public CreditsPosition getCreditsPosition() {
        return creditsPosition;
    }

    /**
     * Sets position of amCharts link (free version only). Possible values are: top-left. top-right, bottom-left,
     * bottom-right. You can adjust the position of amcharts link so that it would not overlap with contents of your
     * chart. If not set the default value is TOP_RIGHT.
     *
     * @param creditsPosition credits position
     */
    public PanelsSettings setCreditsPosition(CreditsPosition creditsPosition) {
        this.creditsPosition = creditsPosition;
        return this;
    }

    /**
     * @return separator of decimal values
     */
    public String getDecimalSeparator() {
        return decimalSeparator;
    }

    /**
     * Sets	separator of decimal values.
     *
     * @param decimalSeparator decimal separator
     */
    public PanelsSettings setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
        return this;
    }

    /**
     * @return depth of the 3D part of plot area
     */
    public Integer getDepth3D() {
        return depth3D;
    }

    /**
     * Sets the depth of the 3D part of plot area. This creates a 3D effect (if the angle is greater than 0).
     *
     * @param depth3D depth 3D
     */
    public PanelsSettings setDepth3D(Integer depth3D) {
        this.depth3D = depth3D;
        return this;
    }

    /**
     * @return font family
     */
    public String getFontFamily() {
        return fontFamily;
    }

    /**
     * Sets font family.
     *
     * @param fontFamily font family
     */
    public PanelsSettings setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    /**
     * @return font size
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * Sets font size.
     *
     * @param fontSize font size
     */
    public PanelsSettings setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    @Override
    public Integer getMarginBottom() {
        return marginBottom;
    }

    @Override
    public PanelsSettings setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    @Override
    public Integer getMarginLeft() {
        return marginLeft;
    }

    @Override
    public PanelsSettings setMarginLeft(Integer marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    @Override
    public Integer getMarginRight() {
        return marginRight;
    }

    @Override
    public PanelsSettings setMarginRight(Integer marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    @Override
    public Integer getMarginTop() {
        return marginTop;
    }

    @Override
    public PanelsSettings setMarginTop(Integer marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * @return the longest time span allowed to select (in milliseconds)
     */
    public Long getMaxSelectedTime() {
        return maxSelectedTime;
    }

    /**
     * Sets the longest time span allowed to select (in milliseconds). For example, 259200000 will limit selection to 3
     * days. Works if {@link CategoryAxesSettings#equalSpacing} is set to false.
     *
     * @param maxSelectedTime maximum selected time
     */
    public PanelsSettings setMaxSelectedTime(Long maxSelectedTime) {
        this.maxSelectedTime = maxSelectedTime;
        return this;
    }

    /**
     * @return the shortest time span allowed to select (in milliseconds)
     */
    public Long getMinSelectedTime() {
        return minSelectedTime;
    }

    /**
     * Sets the shortest time span allowed to select (in milliseconds). For example, 1000 will limit selection to 1
     * second. Works if {@link CategoryAxesSettings#equalSpacing} is set to false. If not set the default value is 0.
     *
     * @param minSelectedTime minimum selected time
     */
    public PanelsSettings setMinSelectedTime(Long minSelectedTime) {
        this.minSelectedTime = minSelectedTime;
        return this;
    }

    /**
     * @return gap between panels
     */
    public Integer getPanelSpacing() {
        return panelSpacing;
    }

    /**
     * Sets gap between panels. If not set the default value is 8.
     *
     * @param panelSpacing panel spacing
     */
    public PanelsSettings setPanelSpacing(Integer panelSpacing) {
        this.panelSpacing = panelSpacing;
        return this;
    }

    /**
     * @return true if panEventsEnabled is enabled
     */
    public Boolean getPanEventsEnabled() {
        return panEventsEnabled;
    }

    /**
     * This setting affects touch-screen devices only. If a chart is on a page, and panEventsEnabled are set to true,
     * the page won't move if the user touches the chart first. If a chart is big enough and occupies all the screen
     * of your touch device, the user won’t be able to move the page at all. That's why the default value is false.
     * If you think that selecting or or panning the chart is a primary purpose of your chart users, you should set
     * panEventsEnabled to true. If not set the default value is false.
     *
     * @param panEventsEnabled panEventsEnabled option
     */
    public PanelsSettings setPanEventsEnabled(Boolean panEventsEnabled) {
        this.panEventsEnabled = panEventsEnabled;
        return this;
    }

    /**
     * @return precision of percent values
     */
    public Double getPercentPrecision() {
        return percentPrecision;
    }

    /**
     * Sets precision of percent values.
     *
     * @param percentPrecision percent precision
     */
    public PanelsSettings setPercentPrecision(Double percentPrecision) {
        this.percentPrecision = percentPrecision;
        return this;
    }

    /**
     * @return the opacity of plot area's border
     */
    public Double getPlotAreaBorderAlpha() {
        return plotAreaBorderAlpha;
    }

    /**
     * Sets the opacity of plot area's border.
     *
     * @param plotAreaBorderAlpha opacity
     */
    public PanelsSettings setPlotAreaBorderAlpha(Double plotAreaBorderAlpha) {
        this.plotAreaBorderAlpha = plotAreaBorderAlpha;
        return this;
    }

    /**
     * @return the color of the plot area's border.
     */
    public Color getPlotAreaBorderColor() {
        return plotAreaBorderColor;
    }

    /**
     * Sets the color of the plot area's border.
     *
     * @param plotAreaBorderColor color
     */
    public PanelsSettings setPlotAreaBorderColor(Color plotAreaBorderColor) {
        this.plotAreaBorderColor = plotAreaBorderColor;
        return this;
    }

    /**
     * @return opacity of plot area fill
     */
    public Double getPlotAreaFillAlphas() {
        return plotAreaFillAlphas;
    }

    /**
     * Sets opacity of plot area fill.
     *
     * @param plotAreaFillAlphas opacity
     */
    public PanelsSettings setPlotAreaFillAlphas(Double plotAreaFillAlphas) {
        this.plotAreaFillAlphas = plotAreaFillAlphas;
        return this;
    }

    /**
     * @return list of colors
     */
    public List<Color> getPlotAreaFillColors() {
        return plotAreaFillColors;
    }

    /**
     * Sets list of the colors used to tint the background gradient fill of the plot area.
     *
     * @param plotAreaFillColors list of colors
     */
    public PanelsSettings setPlotAreaFillColors(List<Color> plotAreaFillColors) {
        this.plotAreaFillColors = plotAreaFillColors;
        return this;
    }

    /**
     * Adds colors.
     *
     * @param plotAreaFillColors colors
     */
    public PanelsSettings addPlotAreaFillColors(Color... plotAreaFillColors) {
        if (plotAreaFillColors != null) {
            if (this.plotAreaFillColors == null) {
                this.plotAreaFillColors = new ArrayList<>();
            }
            this.plotAreaFillColors.addAll(Arrays.asList(plotAreaFillColors));
        }
        return this;
    }

    /**
     * @return precision of values
     */
    public Double getPrecision() {
        return precision;
    }

    /**
     * Sets precision of values. -1 means values will not be rounded and shown as they are.
     *
     * @param precision precision
     */
    public PanelsSettings setPrecision(Double precision) {
        this.precision = precision;
        return this;
    }

    /**
     * @return list of big number prefixes
     */
    public List<BigNumberPrefix> getPrefixesOfBigNumbers() {
        return prefixesOfBigNumbers;
    }

    /**
     * Sets list of big number prefixes. Prefixes which are used to make big numbers shorter: 2M instead of 2000000,
     * etc. Prefixes are used on value axes and in the legend. To enable prefixes, set usePrefixes property to true.
     * If not set the default value is
     * <pre>{@code
     * [{number:1e+3,  prefix:"k"},
     *  {number:1e+6,  prefix:"M"},
     *  {number:1e+9,  prefix:"G"},
     *  {number:1e+12, prefix:"T"},
     *  {number:1e+15, prefix:"P"},
     *  {number:1e+18, prefix:"E"},
     *  {number:1e+21, prefix:"Z"},
     *  {number:1e+24, prefix:"Y"}]}
     * </pre>
     *
     * @param prefixesOfBigNumbers list of big number prefixes
     */
    public PanelsSettings setPrefixesOfBigNumbers(List<BigNumberPrefix> prefixesOfBigNumbers) {
        this.prefixesOfBigNumbers = prefixesOfBigNumbers;
        return this;
    }

    /**
     * @return list of small number prefixes
     */
    public List<SmallNumberPrefix> getPrefixesOfSmallNumbers() {
        return prefixesOfSmallNumbers;
    }

    /**
     * Sets prefixes which are used to make small numbers shorter: 2μ instead of 0.000002, etc. Prefixes are used on
     * value axes and in the legend. To enable prefixes, set usePrefixes property to true. If not set the default
     * value is
     * <pre>{@code
     * [{number:1e-24, prefix:"y"},
     *  {number:1e-21, prefix:"z"},
     *  {number:1e-18, prefix:"a"},
     *  {number:1e-15, prefix:"f"},
     *  {number:1e-12, prefix:"p"},
     *  {number:1e-9,  prefix:"n"},
     *  {number:1e-6,  prefix:"μ"},
     *  {number:1e-3,  prefix:"m"}]}
     * </pre>
     *
     * @param prefixesOfSmallNumbers list of small number prefixes
     */
    public PanelsSettings setPrefixesOfSmallNumbers(List<SmallNumberPrefix> prefixesOfSmallNumbers) {
        this.prefixesOfSmallNumbers = prefixesOfSmallNumbers;
        return this;
    }

    /**
     * @return recalculate to percents
     */
    public RecalculateToPercents getRecalculateToPercents() {
        return recalculateToPercents;
    }

    /**
     * Specifies when values should be recalculated to percents. Possible values are: "never", "always", "whenComparing".
     * If not set the default value is "whenComparing".
     *
     * @param recalculateToPercents recalculate to percents
     */
    public PanelsSettings setRecalculateToPercents(RecalculateToPercents recalculateToPercents) {
        this.recalculateToPercents = recalculateToPercents;
        return this;
    }

    /**
     * @return true if in the animation all objects appear at once
     */
    public Boolean getSequencedAnimation() {
        return sequencedAnimation;
    }

    /**
     * Set sequencedAnimation to true if in the animation all objects should appear at once.
     *
     * @param sequencedAnimation sequencedAnimation option
     */
    public PanelsSettings setSequencedAnimation(Boolean sequencedAnimation) {
        this.sequencedAnimation = sequencedAnimation;
        return this;
    }

    /**
     * @return initial opacity of the column/line
     */
    public Double getStartAlpha() {
        return startAlpha;
    }

    /**
     * Sets the initial opacity of the column/line. If you set startDuration to a value higher than 0, the
     * columns/lines will fade in from startAlpha.
     *
     * @param startAlpha initial opacity
     */
    public PanelsSettings setStartAlpha(Double startAlpha) {
        this.startAlpha = startAlpha;
        return this;
    }

    @Override
    public Double getStartDuration() {
        return startDuration;
    }

    @Override
    public PanelsSettings setStartDuration(Double startDuration) {
        this.startDuration = startDuration;
        return this;
    }

    @Override
    public AnimationEffect getStartEffect() {
        return startEffect;
    }

    @Override
    public PanelsSettings setStartEffect(AnimationEffect startEffect) {
        this.startEffect = startEffect;
        return this;
    }

    /**
     * @return separator of thousand values
     */
    public String getThousandsSeparator() {
        return thousandsSeparator;
    }

    /**
     * Sets separator of thousand values.
     *
     * @param thousandsSeparator thousands separator
     */
    public PanelsSettings setThousandsSeparator(String thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
        return this;
    }

    /**
     * @return true if prefixes is used for big and small numbers
     */
    public Boolean getUsePrefixes() {
        return usePrefixes;
    }

    /**
     * Set usePrefixes to true if prefixes should be used for big and small numbers.
     *
     * @param usePrefixes usePrefixes option
     */
    public PanelsSettings setUsePrefixes(Boolean usePrefixes) {
        this.usePrefixes = usePrefixes;
        return this;
    }

    /**
     * @return true if zoomOutAxes is enabled
     */
    public Boolean getZoomOutAxes() {
        return zoomOutAxes;
    }

    /**
     * Set zoomOutAxes to false if zoomed-in value axes shouldn't be zoomed-out when user changes selected period with
     * {@link PeriodSelector}. If not set the default value is true.
     *
     * @param zoomOutAxes zoomOutAxes option
     */
    public PanelsSettings setZoomOutAxes(Boolean zoomOutAxes) {
        this.zoomOutAxes = zoomOutAxes;
        return this;
    }
}
