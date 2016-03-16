/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of PanelsSettings JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/PanelsSettings">http://docs.amcharts.com/3/javascriptstockchart/PanelsSettings</a>
 *
 */
public class PanelsSettings extends AbstractChartObject
        implements HasMargins<PanelsSettings>, HasStartEffect<PanelsSettings> {

    private static final long serialVersionUID = -4296426800291941801L;
    
    private Integer angel;

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

    private Integer startDuration;

    private AnimationEffect startEffect;

    private String thousandsSeparator;

    private Boolean usePrefixes;

    public Integer getAngel() {
        return angel;
    }

    public PanelsSettings setAngel(Integer angel) {
        this.angel = angel;
        return this;
    }

    public Double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    public PanelsSettings setBackgroundAlpha(Double backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public PanelsSettings setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Integer getColumnSpacing() {
        return columnSpacing;
    }

    public PanelsSettings setColumnSpacing(Integer columnSpacing) {
        this.columnSpacing = columnSpacing;
        return this;
    }

    public Integer getColumnWidth() {
        return columnWidth;
    }

    public PanelsSettings setColumnWidth(Integer columnWidth) {
        this.columnWidth = columnWidth;
        return this;
    }

    public CreditsPosition getCreditsPosition() {
        return creditsPosition;
    }

    public PanelsSettings setCreditsPosition(CreditsPosition creditsPosition) {
        this.creditsPosition = creditsPosition;
        return this;
    }

    public String getDecimalSeparator() {
        return decimalSeparator;
    }

    public PanelsSettings setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
        return this;
    }

    public Integer getDepth3D() {
        return depth3D;
    }

    public PanelsSettings setDepth3D(Integer depth3D) {
        this.depth3D = depth3D;
        return this;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public PanelsSettings setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

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

    public Long getMaxSelectedTime() {
        return maxSelectedTime;
    }

    public PanelsSettings setMaxSelectedTime(Long maxSelectedTime) {
        this.maxSelectedTime = maxSelectedTime;
        return this;
    }

    public Long getMinSelectedTime() {
        return minSelectedTime;
    }

    public PanelsSettings setMinSelectedTime(Long minSelectedTime) {
        this.minSelectedTime = minSelectedTime;
        return this;
    }

    public Integer getPanelSpacing() {
        return panelSpacing;
    }

    public PanelsSettings setPanelSpacing(Integer panelSpacing) {
        this.panelSpacing = panelSpacing;
        return this;
    }

    public Boolean getPanEventsEnabled() {
        return panEventsEnabled;
    }

    public PanelsSettings setPanEventsEnabled(Boolean panEventsEnabled) {
        this.panEventsEnabled = panEventsEnabled;
        return this;
    }

    public Double getPercentPrecision() {
        return percentPrecision;
    }

    public PanelsSettings setPercentPrecision(Double percentPrecision) {
        this.percentPrecision = percentPrecision;
        return this;
    }

    public Double getPlotAreaBorderAlpha() {
        return plotAreaBorderAlpha;
    }

    public PanelsSettings setPlotAreaBorderAlpha(Double plotAreaBorderAlpha) {
        this.plotAreaBorderAlpha = plotAreaBorderAlpha;
        return this;
    }

    public Color getPlotAreaBorderColor() {
        return plotAreaBorderColor;
    }

    public PanelsSettings setPlotAreaBorderColor(Color plotAreaBorderColor) {
        this.plotAreaBorderColor = plotAreaBorderColor;
        return this;
    }

    public Double getPlotAreaFillAlphas() {
        return plotAreaFillAlphas;
    }

    public PanelsSettings setPlotAreaFillAlphas(Double plotAreaFillAlphas) {
        this.plotAreaFillAlphas = plotAreaFillAlphas;
        return this;
    }

    public List<Color> getPlotAreaFillColors() {
        return plotAreaFillColors;
    }

    public PanelsSettings setPlotAreaFillColors(List<Color> plotAreaFillColors) {
        this.plotAreaFillColors = plotAreaFillColors;
        return this;
    }

    public PanelsSettings addPlotAreaFillColors(Color... plotAreaFillColors) {
        if (plotAreaFillColors != null) {
            if (this.plotAreaFillColors == null) {
                this.plotAreaFillColors = new ArrayList<>();
            }
            this.plotAreaFillColors.addAll(Arrays.asList(plotAreaFillColors));
        }
        return this;
    }

    public Double getPrecision() {
        return precision;
    }

    public PanelsSettings setPrecision(Double precision) {
        this.precision = precision;
        return this;
    }

    public List<BigNumberPrefix> getPrefixesOfBigNumbers() {
        return prefixesOfBigNumbers;
    }

    public PanelsSettings setPrefixesOfBigNumbers(List<BigNumberPrefix> prefixesOfBigNumbers) {
        this.prefixesOfBigNumbers = prefixesOfBigNumbers;
        return this;
    }

    public List<SmallNumberPrefix> getPrefixesOfSmallNumbers() {
        return prefixesOfSmallNumbers;
    }

    public PanelsSettings setPrefixesOfSmallNumbers(List<SmallNumberPrefix> prefixesOfSmallNumbers) {
        this.prefixesOfSmallNumbers = prefixesOfSmallNumbers;
        return this;
    }

    public RecalculateToPercents getRecalculateToPercents() {
        return recalculateToPercents;
    }

    public PanelsSettings setRecalculateToPercents(RecalculateToPercents recalculateToPercents) {
        this.recalculateToPercents = recalculateToPercents;
        return this;
    }

    public Boolean getSequencedAnimation() {
        return sequencedAnimation;
    }

    public PanelsSettings setSequencedAnimation(Boolean sequencedAnimation) {
        this.sequencedAnimation = sequencedAnimation;
        return this;
    }

    public Double getStartAlpha() {
        return startAlpha;
    }

    public PanelsSettings setStartAlpha(Double startAlpha) {
        this.startAlpha = startAlpha;
        return this;
    }

    @Override
    public Integer getStartDuration() {
        return startDuration;
    }

    @Override
    public PanelsSettings setStartDuration(Integer startDuration) {
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

    public String getThousandsSeparator() {
        return thousandsSeparator;
    }

    public PanelsSettings setThousandsSeparator(String thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
        return this;
    }

    public Boolean getUsePrefixes() {
        return usePrefixes;
    }

    public PanelsSettings setUsePrefixes(Boolean usePrefixes) {
        this.usePrefixes = usePrefixes;
        return this;
    }
}
