/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.components.charts.XYLineChart;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.dom4j.Element;

/**
 * @author zagumennikov
 * @version $Id$
 */
public class XYLineChartLoader extends AbstractXYChartLoader {

    public XYLineChartLoader(Context context) {
        super(context);
    }

    @Override
    public XYLineChart loadComponent(ComponentsFactory factory, Element element, Component parent) {
        XYLineChart component = (XYLineChart) super.loadComponent(factory, element, parent);

        loadOrientation(component, element);
        loadAxisLabels(component, element);

        return component;
    }
}