/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.data.Container;

import java.util.*;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public abstract class XYChartComponent extends ChartComponent implements VXYChart {

    private static final long serialVersionUID = -7433062042194011796L;

    protected Collection<VXYChartRow> rows = new ArrayList<VXYChartRow>();

    protected AxisType argumentAxisType = AxisType.NUMBER;
    protected AxisType valueAxisType = AxisType.NUMBER;

    public Collection<VXYChartRow> getRows() {
        return rows;
    }

    public void addRow(VXYChartRow row) {
        rows.add(row);
        row.addListener((Container.ItemSetChangeListener)this);
        row.addListener((Container.PropertySetChangeListener)this);
        requestRepaint();
    }

    public AxisType getArgumentAxisType() {
        return argumentAxisType;
    }

    public void setArgumentAxisType(AxisType axisType) {
        this.argumentAxisType = axisType;
    }

    public AxisType getValueAxisType() {
        return valueAxisType;
    }

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
}
