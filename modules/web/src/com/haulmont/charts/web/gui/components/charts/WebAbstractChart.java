/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.web.gui.components.charts;

import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.web.toolkit.ui.charts.ChartComponent;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;

public abstract class WebAbstractChart<T extends ChartComponent>
        extends WebAbstractComponent<T>
        implements Chart {

    @Override
    public String getCaption() {
        return component.getCaption();
    }

    @Override
    public void setCaption(String caption) {
        component.setCaption(caption);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String description) {
    }

    @Override
    public void setExpandable(boolean expandable) {
        //ignore
    }

    @Override
    public boolean isExpandable() {
        return false;
    }

    @Override
    public void setWidth(String width) {
        try {
            component.setChartWidth(Integer.parseInt(width));
        } catch (NumberFormatException e) {
            //do nothing
        }
    }

    @Override
    public void setHeight(String height) {
        try {
            component.setChartHeight(Integer.parseInt(height));
        } catch (NumberFormatException e) {
            //do nothing
        }
    }
}