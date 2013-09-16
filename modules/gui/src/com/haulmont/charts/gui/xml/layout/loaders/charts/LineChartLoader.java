/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.components.charts.LineChart;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.dom4j.Element;

public class LineChartLoader extends AbstractCategoryChartLoader {

    public LineChartLoader(Context context) {
        super(context);
    }

    @Override
    public LineChart loadComponent(ComponentsFactory factory, Element element, Component parent) {
        LineChart component = (LineChart) super.loadComponent(factory, element, parent);

        loadOrientation(component, element);
        loadAxisLabels(component, element);
        loadValueAxisType(component, element);

        return component; 
    }
}
