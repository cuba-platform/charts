/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of AmRectangularChart JS object.
 *
 * @author artamonov
 * @version $Id$
 */
@SuppressWarnings("unchecked")
public abstract class RectangularChart<T extends RectangularChart> extends CoordinateChart<T> implements HasMargins<T> {

    private Integer angle;

    private Integer autoMarginOffset;

    private Boolean autoMargins;

    private Cursor chartCursor;

    private Scrollbar chartScrollbar;

    private Integer depth3D;

    private Integer marginBottom;

    private Integer marginLeft;

    private Integer marginRight;

    private Integer marginTop;

    private Boolean marginsUpdated;

    private Double plotAreaBorderAlpha;

    private Color plotAreaBorderColor;

    private Double plotAreaFillAlphas;

    private Color plotAreaFillColors;

    private Integer plotAreaGradientAngle;

    private List<TrendLine> trendLines;

    private Double zoomOutButtonAlpha;

    private Color zoomOutButtonColor;

    private String zoomOutButtonImage;

    private Integer zoomOutButtonImageSize;

    private Integer zoomOutButtonPadding;

    private Double zoomOutButtonRollOverAlpha;

    private String zoomOutText;

    public RectangularChart(ChartType type) {
        super(type);
    }

    public Cursor getChartCursor() {
        return chartCursor;
    }

    public T setChartCursor(Cursor chartCursor) {
        this.chartCursor = chartCursor;
        return (T) this;
    }

    public Scrollbar getChartScrollbar() {
        return chartScrollbar;
    }

    public T setChartScrollbar(Scrollbar chartScrollbar) {
        this.chartScrollbar = chartScrollbar;
        return (T) this;
    }

    public List<TrendLine> getTrendLines() {
        return trendLines;
    }

    public T setTrendLines(List<TrendLine> trendLines) {
        this.trendLines = trendLines;
        return (T) this;
    }

    public T addTrendLines(TrendLine... trendLines) {
        if (trendLines != null) {
            if (this.trendLines == null) {
                this.trendLines = new ArrayList<>();
            }
            this.trendLines.addAll(Arrays.asList(trendLines));
        }
        return (T) this;
    }

    public Integer getAngle() {
        return angle;
    }

    public T setAngle(Integer angle) {
        this.angle = angle;
        return (T) this;
    }

    public Integer getAutoMarginOffset() {
        return autoMarginOffset;
    }

    public T setAutoMarginOffset(Integer autoMarginOffset) {
        this.autoMarginOffset = autoMarginOffset;
        return (T) this;
    }

    public Boolean getAutoMargins() {
        return autoMargins;
    }

    public T setAutoMargins(Boolean autoMargins) {
        this.autoMargins = autoMargins;
        return (T) this;
    }

    public Integer getDepth3D() {
        return depth3D;
    }

    public T setDepth3D(Integer depth3D) {
        this.depth3D = depth3D;
        return (T) this;
    }

    @Override
    public Integer getMarginBottom() {
        return marginBottom;
    }

    @Override
    public T setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
        return (T) this;
    }

    @Override
    public Integer getMarginLeft() {
        return marginLeft;
    }

    @Override
    public T setMarginLeft(Integer marginLeft) {
        this.marginLeft = marginLeft;
        return (T) this;
    }

    @Override
    public Integer getMarginRight() {
        return marginRight;
    }

    @Override
    public T setMarginRight(Integer marginRight) {
        this.marginRight = marginRight;
        return (T) this;
    }

    @Override
    public Integer getMarginTop() {
        return marginTop;
    }

    @Override
    public T setMarginTop(Integer marginTop) {
        this.marginTop = marginTop;
        return (T) this;
    }

    public Boolean getMarginsUpdated() {
        return marginsUpdated;
    }

    public T setMarginsUpdated(Boolean marginsUpdated) {
        this.marginsUpdated = marginsUpdated;
        return (T) this;
    }

    public Double getPlotAreaBorderAlpha() {
        return plotAreaBorderAlpha;
    }

    public T setPlotAreaBorderAlpha(Double plotAreaBorderAlpha) {
        this.plotAreaBorderAlpha = plotAreaBorderAlpha;
        return (T) this;
    }

    public Color getPlotAreaBorderColor() {
        return plotAreaBorderColor;
    }

    public T setPlotAreaBorderColor(Color plotAreaBorderColor) {
        this.plotAreaBorderColor = plotAreaBorderColor;
        return (T) this;
    }

    public Double getPlotAreaFillAlphas() {
        return plotAreaFillAlphas;
    }

    public T setPlotAreaFillAlphas(Double plotAreaFillAlphas) {
        this.plotAreaFillAlphas = plotAreaFillAlphas;
        return (T) this;
    }

    public Color getPlotAreaFillColors() {
        return plotAreaFillColors;
    }

    public T setPlotAreaFillColors(Color plotAreaFillColors) {
        this.plotAreaFillColors = plotAreaFillColors;
        return (T) this;
    }

    public Integer getPlotAreaGradientAngle() {
        return plotAreaGradientAngle;
    }

    public T setPlotAreaGradientAngle(Integer plotAreaGradientAngle) {
        this.plotAreaGradientAngle = plotAreaGradientAngle;
        return (T) this;
    }

    public Double getZoomOutButtonAlpha() {
        return zoomOutButtonAlpha;
    }

    public T setZoomOutButtonAlpha(Double zoomOutButtonAlpha) {
        this.zoomOutButtonAlpha = zoomOutButtonAlpha;
        return (T) this;
    }

    public Color getZoomOutButtonColor() {
        return zoomOutButtonColor;
    }

    public T setZoomOutButtonColor(Color zoomOutButtonColor) {
        this.zoomOutButtonColor = zoomOutButtonColor;
        return (T) this;
    }

    public String getZoomOutButtonImage() {
        return zoomOutButtonImage;
    }

    public T setZoomOutButtonImage(String zoomOutButtonImage) {
        this.zoomOutButtonImage = zoomOutButtonImage;
        return (T) this;
    }

    public Integer getZoomOutButtonImageSize() {
        return zoomOutButtonImageSize;
    }

    public T setZoomOutButtonImageSize(Integer zoomOutButtonImageSize) {
        this.zoomOutButtonImageSize = zoomOutButtonImageSize;
        return (T) this;
    }

    public Integer getZoomOutButtonPadding() {
        return zoomOutButtonPadding;
    }

    public T setZoomOutButtonPadding(Integer zoomOutButtonPadding) {
        this.zoomOutButtonPadding = zoomOutButtonPadding;
        return (T) this;
    }

    public Double getZoomOutButtonRollOverAlpha() {
        return zoomOutButtonRollOverAlpha;
    }

    public T setZoomOutButtonRollOverAlpha(Double zoomOutButtonRollOverAlpha) {
        this.zoomOutButtonRollOverAlpha = zoomOutButtonRollOverAlpha;
        return (T) this;
    }

    public String getZoomOutText() {
        return zoomOutText;
    }

    public T setZoomOutText(String zoomOutText) {
        this.zoomOutText = zoomOutText;
        return (T) this;
    }
}