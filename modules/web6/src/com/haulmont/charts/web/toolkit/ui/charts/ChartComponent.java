/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.AbstractComponent;

public abstract class ChartComponent extends AbstractComponent implements WChart {
    private static final long serialVersionUID = 8749174467182489471L;

    protected int chartWidth = 400;
    protected int chartHeight = 300;

    protected ChartComponent() {
        setWidth(chartWidth + "px");
        setHeight(chartHeight + "px");
    }

    @Override
    public int getChartWidth() {
        return chartWidth;
    }

    @Override
    public void setChartWidth(int chartWidth) {
        this.chartWidth = chartWidth;
        setWidth(chartWidth + "px");
    }

    @Override
    public int getChartHeight() {
        return chartHeight;
    }

    @Override
    public void setChartHeight(int chartHeight) {
        this.chartHeight = chartHeight;
        setHeight(chartHeight + "px");
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        target.addAttribute("cwidth", chartWidth);
        target.addAttribute("cheight", chartHeight);
    }
}