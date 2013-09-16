/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.cuba.gui.components.Component;
import com.haulmont.charts.gui.components.charts.BarChart;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.dom4j.Element;

public class BarChartLoader extends AbstractCategoryChartLoader {
    private static final long serialVersionUID = -8059950271995313942L;

    public BarChartLoader(Context context) {
        super(context);
    }

    @Override
    public BarChart loadComponent(ComponentsFactory factory, Element element, Component parent) {
        BarChart component = (BarChart) super.loadComponent(factory, element, parent);

        load3D(component, element);
        loadOrientation(component, element);
        loadAxisLabels(component, element);
        loadValueAxisType(component, element);

        return component;
    }
}