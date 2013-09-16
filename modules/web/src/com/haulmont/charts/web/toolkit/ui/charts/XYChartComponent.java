/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.data.Container;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public abstract class XYChartComponent extends ChartComponent implements WXYChart {

    private static final long serialVersionUID = -7433062042194011796L;

    protected Collection<WXYChartRow> rows = new ArrayList<>();

    protected AxisType argumentAxisType = AxisType.NUMBER;
    protected AxisType valueAxisType = AxisType.NUMBER;

    protected boolean hasLegend = false;

    @Override
    public Collection<WXYChartRow> getRows() {
        return rows;
    }

    @Override
    public void addRow(WXYChartRow row) {
        rows.add(row);
        row.addListener((Container.ItemSetChangeListener)this);
        row.addListener((Container.PropertySetChangeListener)this);
        requestRepaint();
    }

    @Override
    public AxisType getArgumentAxisType() {
        return argumentAxisType;
    }

    @Override
    public void setArgumentAxisType(AxisType axisType) {
        this.argumentAxisType = axisType;
    }

    @Override
    public AxisType getValueAxisType() {
        return valueAxisType;
    }

    @Override
    public void setValueAxisType(AxisType valueAxisType) {
        this.valueAxisType = valueAxisType;
    }

    @Override
    public void containerItemSetChange(Container.ItemSetChangeEvent event) {
        requestRepaint();
    }

    @Override
    public void containerPropertySetChange(Container.PropertySetChangeEvent event) {
        requestRepaint();
    }

    @Override
    public boolean getHasLegend() {
        return hasLegend;
    }

    @Override
    public void setHasLegend(boolean hasLegend) {
        this.hasLegend = hasLegend;
    }
/*  vaadin7
    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        if (hasLegend) {
            target.addAttribute("legend", true);
        }
    }*/
}