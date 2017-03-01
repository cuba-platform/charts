/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.List;

public interface RectangularChartModel<T extends RectangularChartModel> extends CoordinateChartModel<T>, HasMargins<T> {
    Cursor getChartCursor();
    T setChartCursor(Cursor chartCursor);

    Scrollbar getChartScrollbar();
    T setChartScrollbar(Scrollbar chartScrollbar);

    List<TrendLine> getTrendLines();
    T setTrendLines(List<TrendLine> trendLines);
    T addTrendLines(TrendLine... trendLines);

    Integer getAngle();
    T setAngle(Integer angle);

    Integer getAutoMarginOffset();
    T setAutoMarginOffset(Integer autoMarginOffset);

    Boolean getAutoMargins();
    T setAutoMargins(Boolean autoMargins);

    Integer getDepth3D();
    T setDepth3D(Integer depth3D);

    Boolean getMarginsUpdated();
    T setMarginsUpdated(Boolean marginsUpdated);

    Double getPlotAreaBorderAlpha();
    T setPlotAreaBorderAlpha(Double plotAreaBorderAlpha);

    Color getPlotAreaBorderColor();
    T setPlotAreaBorderColor(Color plotAreaBorderColor);

    Double getPlotAreaFillAlphas();
    T setPlotAreaFillAlphas(Double plotAreaFillAlphas);

    Color getPlotAreaFillColors();
    T setPlotAreaFillColors(Color plotAreaFillColors);

    Integer getPlotAreaGradientAngle();
    T setPlotAreaGradientAngle(Integer plotAreaGradientAngle);

    Double getZoomOutButtonAlpha();
    T setZoomOutButtonAlpha(Double zoomOutButtonAlpha);

    Color getZoomOutButtonColor();
    T setZoomOutButtonColor(Color zoomOutButtonColor);

    String getZoomOutButtonImage();
    T setZoomOutButtonImage(String zoomOutButtonImage);

    Integer getZoomOutButtonImageSize();
    T setZoomOutButtonImageSize(Integer zoomOutButtonImageSize);

    Integer getZoomOutButtonPadding();
    T setZoomOutButtonPadding(Integer zoomOutButtonPadding);

    Double getZoomOutButtonRollOverAlpha();
    T setZoomOutButtonRollOverAlpha(Double zoomOutButtonRollOverAlpha);

    String getZoomOutText();
    T setZoomOutText(String zoomOutText);

    Integer getMaxZoomFactor();
    T setMaxZoomFactor(Integer maxZoomFactor);

    Integer getMinMarginBottom();
    T setMinMarginBottom(Integer minMarginBottom);

    Integer getMinMarginLeft();
    T setMinMarginLeft(Integer minMarginLeft);

    Integer getMinMarginRight();
    T setMinMarginRight(Integer minMarginRight);

    Integer getMinMarginTop();
    T setMinMarginTop(Integer minMarginTop);

    Integer getZoomOutButtonTabIndex();
    T setZoomOutButtonTabIndex(Integer zoomOutButtonTabIndex);
}