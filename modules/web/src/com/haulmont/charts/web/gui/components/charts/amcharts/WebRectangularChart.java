/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.Color;
import com.haulmont.charts.gui.amcharts.model.Cursor;
import com.haulmont.charts.gui.amcharts.model.Scrollbar;
import com.haulmont.charts.gui.amcharts.model.TrendLine;
import com.haulmont.charts.gui.components.charts.RectangularChart;
import org.apache.commons.lang.StringUtils;

import java.util.List;

@SuppressWarnings("unchecked")
public abstract class WebRectangularChart<T extends RectangularChart,
        M extends com.haulmont.charts.gui.amcharts.model.charts.RectangularChart> extends WebCoordinateChart<T, M>
        implements RectangularChart<T> {

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.CursorPeriodSelectListener periodSelectHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.CursorZoomListener cursorZoomHandler;

    @Override
    protected void setupDefaults(M chart) {
        super.setupDefaults(chart);

        setupRectangularChartDefaults(chart);
    }

    protected void setupRectangularChartDefaults(com.haulmont.charts.gui.amcharts.model.charts.RectangularChart chart) {
        chart.setZoomOutText(messages.getMainMessage("amcharts.zoomOutText"));
    }

    @Override
    public Cursor getChartCursor() {
        return getModel().getChartCursor();
    }

    @Override
    public T setChartCursor(Cursor chartCursor) {
        if (chartCursor != null) {
            if (StringUtils.isEmpty(chartCursor.getCategoryBalloonDateFormat())) {
                String format = messages.getMainMessage("amcharts.rectangularChart.categoryBalloonDateFormat");
                chartCursor.setCategoryBalloonDateFormat(format);
            }
        }

        getModel().setChartCursor(chartCursor);
        return (T) this;
    }

    @Override
    public Scrollbar getChartScrollbar() {
        return getModel().getChartScrollbar();
    }

    @Override
    public T setChartScrollbar(Scrollbar chartScrollbar) {
        getModel().setChartScrollbar(chartScrollbar);
        return (T) this;
    }

    @Override
    public List<TrendLine> getTrendLines() {
        return getModel().getTrendLines();
    }

    @Override
    public T setTrendLines(List list) {
        getModel().setTrendLines(list);
        return (T) this;
    }

    @Override
    public T addTrendLines(TrendLine... trendLines) {
        getModel().addTrendLines(trendLines);
        return (T) this;
    }

    @Override
    public Integer getAngle() {
        return getModel().getAngle();
    }

    @Override
    public T setAngle(Integer angle) {
        getModel().setAngle(angle);
        return (T) this;
    }

    @Override
    public Integer getAutoMarginOffset() {
        return getModel().getAutoMarginOffset();
    }

    @Override
    public T setAutoMarginOffset(Integer autoMarginOffset) {
        getModel().setAutoMarginOffset(autoMarginOffset);
        return (T) this;
    }

    @Override
    public Boolean getAutoMargins() {
        return getModel().getAutoMargins();
    }

    @Override
    public T setAutoMargins(Boolean autoMargins) {
        getModel().setAutoMargins(autoMargins);
        return (T) this;
    }

    @Override
    public Integer getDepth3D() {
        return getModel().getDepth3D();
    }

    @Override
    public T setDepth3D(Integer depth3D) {
        getModel().setDepth3D(depth3D);
        return (T) this;
    }

    @Override
    public Integer getMarginBottom() {
        return getModel().getMarginBottom();
    }

    @Override
    public T setMarginBottom(Integer marginBottom) {
        getModel().setMarginBottom(marginBottom);
        return (T) this;
    }

    @Override
    public Integer getMarginLeft() {
        return getModel().getMarginLeft();
    }

    @Override
    public T setMarginLeft(Integer marginLeft) {
        getModel().setMarginLeft(marginLeft);
        return (T) this;
    }

    @Override
    public Integer getMarginRight() {
        return getModel().getMarginRight();
    }

    @Override
    public T setMarginRight(Integer marginRight) {
        getModel().setMarginRight(marginRight);
        return (T) this;
    }

    @Override
    public Integer getMarginTop() {
        return getModel().getMarginTop();
    }

    @Override
    public T setMarginTop(Integer marginTop) {
        getModel().setMarginTop(marginTop);
        return (T) this;
    }

    @Override
    public Boolean getMarginsUpdated() {
        return getModel().getMarginsUpdated();
    }

    @Override
    public T setMarginsUpdated(Boolean marginsUpdated) {
        getModel().setMarginsUpdated(marginsUpdated);
        return (T) this;
    }

    @Override
    public Double getPlotAreaBorderAlpha() {
        return getModel().getPlotAreaBorderAlpha();
    }

    @Override
    public T setPlotAreaBorderAlpha(Double plotAreaBorderAlpha) {
        getModel().setPlotAreaBorderAlpha(plotAreaBorderAlpha);
        return (T) this;
    }

    @Override
    public Color getPlotAreaBorderColor() {
        return getModel().getPlotAreaBorderColor();
    }

    @Override
    public T setPlotAreaBorderColor(Color plotAreaBorderColor) {
        getModel().setPlotAreaBorderColor(plotAreaBorderColor);
        return (T) this;
    }

    @Override
    public Double getPlotAreaFillAlphas() {
        return getModel().getPlotAreaFillAlphas();
    }

    @Override
    public T setPlotAreaFillAlphas(Double plotAreaFillAlphas) {
        getModel().setPlotAreaFillAlphas(plotAreaFillAlphas);
        return (T) this;
    }

    @Override
    public List<Color> getPlotAreaFillColors() {
        return getModel().getPlotAreaFillColors();
    }

    @Override
    public T setPlotAreaFillColors(List<Color> plotAreaFillColors) {
        getModel().setPlotAreaFillColors(plotAreaFillColors);
        return (T) this;
    }

    @Override
    public Integer getPlotAreaGradientAngle() {
        return getModel().getPlotAreaGradientAngle();
    }

    @Override
    public T setPlotAreaGradientAngle(Integer plotAreaGradientAngle) {
        getModel().setPlotAreaGradientAngle(plotAreaGradientAngle);
        return (T) this;
    }

    @Override
    public Double getZoomOutButtonAlpha() {
        return getModel().getZoomOutButtonAlpha();
    }

    @Override
    public T setZoomOutButtonAlpha(Double zoomOutButtonAlpha) {
        getModel().setZoomOutButtonAlpha(zoomOutButtonAlpha);
        return (T) this;
    }

    @Override
    public Color getZoomOutButtonColor() {
        return getModel().getZoomOutButtonColor();
    }

    @Override
    public T setZoomOutButtonColor(Color zoomOutButtonColor) {
        getModel().setZoomOutButtonColor(zoomOutButtonColor);
        return (T) this;
    }

    @Override
    public String getZoomOutButtonImage() {
        return getModel().getZoomOutButtonImage();
    }

    @Override
    public T setZoomOutButtonImage(String zoomOutButtonImage) {
        getModel().setZoomOutButtonImage(zoomOutButtonImage);
        return (T) this;
    }

    @Override
    public Integer getZoomOutButtonImageSize() {
        return getModel().getZoomOutButtonImageSize();
    }

    @Override
    public T setZoomOutButtonImageSize(Integer zoomOutButtonImageSize) {
        getModel().setZoomOutButtonImageSize(zoomOutButtonImageSize);
        return (T) this;
    }

    @Override
    public Integer getZoomOutButtonPadding() {
        return getModel().getZoomOutButtonPadding();
    }

    @Override
    public T setZoomOutButtonPadding(Integer zoomOutButtonPadding) {
        getModel().setZoomOutButtonPadding(zoomOutButtonPadding);
        return (T) this;
    }

    @Override
    public Double getZoomOutButtonRollOverAlpha() {
        return getModel().getZoomOutButtonRollOverAlpha();
    }

    @Override
    public T setZoomOutButtonRollOverAlpha(Double zoomOutButtonRollOverAlpha) {
        getModel().setZoomOutButtonRollOverAlpha(zoomOutButtonRollOverAlpha);
        return (T) this;
    }

    @Override
    public String getZoomOutText() {
        return getModel().getZoomOutText();
    }

    @Override
    public T setZoomOutText(String zoomOutText) {
        getModel().setZoomOutText(zoomOutText);
        return (T) this;
    }

    @Override
    public Integer getMaxZoomFactor() {
        return getModel().getMaxZoomFactor();
    }

    @Override
    public T setMaxZoomFactor(Integer maxZoomFactor) {
        getModel().setMaxZoomFactor(maxZoomFactor);
        return (T) this;
    }

    @Override
    public Integer getMinMarginBottom() {
        return getModel().getMinMarginBottom();
    }

    @Override
    public T setMinMarginBottom(Integer minMarginBottom) {
        getModel().setMinMarginBottom(minMarginBottom);
        return (T) this;
    }

    @Override
    public Integer getMinMarginLeft() {
        return getModel().getMinMarginLeft();
    }

    @Override
    public T setMinMarginLeft(Integer minMarginLeft) {
        getModel().setMinMarginLeft(minMarginLeft);
        return (T) this;
    }

    @Override
    public Integer getMinMarginRight() {
        return getModel().getMinMarginRight();
    }

    @Override
    public T setMinMarginRight(Integer minMarginRight) {
        getModel().setMinMarginRight(minMarginRight);
        return (T) this;
    }

    @Override
    public Integer getMinMarginTop() {
        return getModel().getMinMarginTop();
    }

    @Override
    public T setMinMarginTop(Integer minMarginTop) {
        getModel().setMinMarginTop(minMarginTop);
        return (T) this;
    }

    @Override
    public Integer getZoomOutButtonTabIndex() {
        return getModel().getZoomOutButtonTabIndex();
    }

    @Override
    public T setZoomOutButtonTabIndex(Integer zoomOutButtonTabIndex) {
        getModel().setZoomOutButtonTabIndex(zoomOutButtonTabIndex);
        return (T) this;
    }

    @Override
    public void addCursorPeriodSelectListener(CursorPeriodSelectListener listener) {
        getEventRouter().addListener(CursorPeriodSelectListener.class, listener);
        if (periodSelectHandler == null) {
            periodSelectHandler = e -> {
                CursorPeriodSelectEvent event = new CursorPeriodSelectEvent(e.getStart(), e.getEnd());
                getEventRouter().fireEvent(CursorPeriodSelectListener.class, CursorPeriodSelectListener::onSelect, event);
            };
            component.addCursorPeriodSelectListener(periodSelectHandler);
        }
    }

    @Override
    public void removeCursorPeriodSelectListener(CursorPeriodSelectListener listener) {
        getEventRouter().removeListener(CursorPeriodSelectListener.class, listener);
        if (periodSelectHandler != null && !getEventRouter().hasListeners(CursorPeriodSelectListener.class)) {
            component.removeCursorPeriodSelectListener(periodSelectHandler);
            periodSelectHandler = null;
        }
    }

    @Override
    public void addCursorZoomListener(CursorZoomListener listener) {
        getEventRouter().addListener(CursorZoomListener.class, listener);
        if (cursorZoomHandler == null) {
            cursorZoomHandler = e -> {
                CursorZoomEvent event = new CursorZoomEvent(e.getStart(), e.getEnd());
                getEventRouter().fireEvent(CursorZoomListener.class, CursorZoomListener::onZoom, event);
            };
            component.addCursorZoomListener(cursorZoomHandler);
        }
    }

    @Override
    public void removeCursorZoomListener(CursorZoomListener listener) {
        getEventRouter().removeListener(CursorZoomListener.class, listener);
        if (cursorZoomHandler != null && !getEventRouter().hasListeners(CursorZoomListener.class)) {
            component.removeCursorZoomListener(cursorZoomHandler);
            cursorZoomHandler = null;
        }
    }
}