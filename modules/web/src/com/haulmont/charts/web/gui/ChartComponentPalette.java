/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.gui;

import com.haulmont.charts.gui.components.charts.*;
import com.haulmont.charts.gui.xml.layout.loaders.charts.BarChartLoader;
import com.haulmont.charts.gui.xml.layout.loaders.charts.LineChartLoader;
import com.haulmont.charts.gui.xml.layout.loaders.charts.PieChartLoader;
import com.haulmont.charts.gui.xml.layout.loaders.charts.XYLineChartLoader;
import com.haulmont.charts.web.gui.components.charts.WebXYChartRow;
import com.haulmont.charts.web.gui.components.charts.jfree.WebJFreeBarChart;
import com.haulmont.charts.web.gui.components.charts.jfree.WebJFreeLineChart;
import com.haulmont.charts.web.gui.components.charts.jfree.WebJFreePieChart;
import com.haulmont.charts.web.gui.components.charts.jfree.WebJFreeXYLineChart;
import com.haulmont.charts.web.toolkit.ui.charts.jfree.JFreeChart;
import com.haulmont.cuba.gui.ComponentPalette;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Charts palette
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public class ChartComponentPalette implements ComponentPalette {
    @Override
    public Map<String, Class<? extends ComponentLoader>> getLoaders() {

        Map<String, Class<? extends ComponentLoader>> loaders = new HashMap<String, Class<? extends ComponentLoader>>();

        loaders.put("pieChart", PieChartLoader.class);
        loaders.put("barChart", BarChartLoader.class);
        loaders.put("lineChart", LineChartLoader.class);
        loaders.put("xyLineChart", XYLineChartLoader.class);

        return loaders;
    }

    @Override
    public Map<String, Class<? extends Component>> getComponents() {

        Map<String, Class<? extends Component>> components = new HashMap<String, Class<? extends Component>>();

        components.put(PieChart.NAME + "@" + JFreeChart.VENDOR, WebJFreePieChart.class);
        components.put(BarChart.NAME + "@" + JFreeChart.VENDOR, WebJFreeBarChart.class);
        components.put(LineChart.NAME + "@" + JFreeChart.VENDOR, WebJFreeLineChart.class);
        components.put(XYLineChart.NAME + "@" + JFreeChart.VENDOR, WebJFreeXYLineChart.class);
        components.put(XYChartRow.NAME, WebXYChartRow.class);

        return components;
    }
}