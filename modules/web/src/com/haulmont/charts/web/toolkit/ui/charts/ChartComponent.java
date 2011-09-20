/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.charts.web.toolkit.ui.charts;

import com.haulmont.charts.web.controllers.ChartRenderingController;
import com.haulmont.cuba.web.controllers.ControllerUtils;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.AbstractComponent;

public abstract class ChartComponent extends AbstractComponent implements VChart {
    private static final long serialVersionUID = 8749174467182489471L;

    protected boolean hasLegend = false;

    protected int chartWidth = 400;
    protected int chartHeight = 300;

    protected ChartComponent() {
        setWidth(chartWidth + "px");
        setHeight(chartHeight + "px");
    }

    public boolean getHasLegend() {
        return hasLegend;
    }

    public void setHasLegend(boolean hasLegend) {
        this.hasLegend = hasLegend;
        requestRepaint();
    }

    public int getChartWidth() {
        return chartWidth;
    }

    public void setChartWidth(int chartWidth) {
        this.chartWidth = chartWidth;
        setWidth(chartWidth + "px");
    }

    public int getChartHeight() {
        return chartHeight;
    }

    public void setChartHeight(int chartHeight) {
        this.chartHeight = chartHeight;
        setHeight(chartHeight + "px");
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        if (hasLegend) {
            target.addAttribute("legend", true);
        }
        target.addAttribute("cwidth", chartWidth);
        target.addAttribute("cheight", chartHeight);
    }
}