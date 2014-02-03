/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.components.charts.BaseGanttChart;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.gui.xml.layout.loaders.ComponentLoader;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 * @author gorodnov
 * @version $Id$
 */
public abstract class AbstractGanttChartLoader extends ComponentLoader {
    public AbstractGanttChartLoader(Context context) {
        super(context);
    }

    @Override
    public BaseGanttChart loadComponent(ComponentsFactory factory, Element element, Component parent) {

        String vendor = element.attributeValue("vendor");
        BaseGanttChart component = factory.createComponent(element.getName() + "@" + vendor);

        assignXmlDescriptor(component, element);
        loadId(component, element);

        loadVisible(component, element);

        loadCaption(component, element);

        loadHeight(component, element);
        loadWidth(component, element);

        if (component instanceof BaseGanttChart.HasLegend)
            loadLegend((BaseGanttChart.HasLegend) component, element);

        assignFrame(component);

        return component;
    }

    @Override
    protected void loadWidth(Component component, Element element, String defaultValue) {
        final String width = element.attributeValue("width");
        if (!StringUtils.isBlank(width)) {
            if (StringUtils.isNumeric(width)) {
                component.setWidth(width);
            } else {
                throw new IllegalArgumentException("'width' attribute must contains numeric values only");
            }
        }
    }

    @Override
    protected void loadHeight(Component component, Element element, String defaultValue) {
        final String height = element.attributeValue("height");
        if (!StringUtils.isBlank(height)) {
            if (StringUtils.isNumeric(height)) {
                component.setHeight(height);
            } else {
                throw new IllegalArgumentException("'height' attribute must contains numeric values only");
            }
        }
    }

    protected void loadLegend(BaseGanttChart.HasLegend component, Element element) {
        String legend = element.attributeValue("legend");
        if (!StringUtils.isEmpty(legend) && isBoolean(legend)) {
            component.setHasLegend(Boolean.valueOf(legend));
        }
    }
}