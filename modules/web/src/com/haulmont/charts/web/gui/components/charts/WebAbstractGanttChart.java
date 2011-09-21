/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.gui.components.charts;

import com.haulmont.charts.gui.components.charts.GanttChart;
import com.haulmont.charts.web.toolkit.ui.charts.GanttChartComponent;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public abstract class WebAbstractGanttChart<T extends GanttChartComponent>
        extends WebAbstractComponent<T>
        implements GanttChart {

    private String caption;

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String description) {
    }
}