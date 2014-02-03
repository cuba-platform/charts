/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui;

import com.haulmont.charts.gui.components.charts.GanttChart;
import com.haulmont.charts.gui.xml.layout.loaders.charts.GanttChartLoader;
import com.haulmont.charts.web.gui.components.charts.jsgantt.WebJSGanttChart;
import com.haulmont.charts.web.toolkit.ui.gantt.JSGanttChart;
import com.haulmont.cuba.gui.ComponentPalette;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Charts palette
 *
 * @author artamonov
 * @version $Id$
 */
public class ChartComponentPalette implements ComponentPalette {
    @Override
    public Map<String, Class<? extends ComponentLoader>> getLoaders() {

        Map<String, Class<? extends ComponentLoader>> loaders = new HashMap<>();

        loaders.put("ganttChart", GanttChartLoader.class);

        return loaders;
    }

    @Override
    public Map<String, Class<? extends Component>> getComponents() {
        Map<String, Class<? extends Component>> components = new HashMap<>();

        components.put(GanttChart.NAME  + "@" + JSGanttChart.VENDOR, WebJSGanttChart.class);

        return components;
    }
}