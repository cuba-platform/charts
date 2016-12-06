/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui;

import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.gui.components.charts.StockChart;
import com.haulmont.charts.gui.components.map.GoogleMapViewer;
import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.xml.layout.loaders.charts.*;
import com.haulmont.charts.gui.xml.layout.loaders.map.MapViewerLoader;
import com.haulmont.charts.gui.xml.layout.loaders.pivottable.PivotTableLoader;
import com.haulmont.charts.web.gui.components.charts.amcharts.WebChart;
import com.haulmont.charts.web.gui.components.charts.amcharts.WebStockChart;
import com.haulmont.charts.web.gui.components.map.google.WebGoogleMapViewer;
import com.haulmont.charts.web.gui.components.pivottable.WebPivotTable;
import com.haulmont.cuba.gui.ComponentPalette;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Charts palette
 */
@Deprecated
public class ChartComponentPalette implements ComponentPalette {
    @Override
    public Map<String, Class<? extends ComponentLoader>> getLoaders() {

        Map<String, Class<? extends ComponentLoader>> loaders = new HashMap<>();

        loaders.put("gaugeChart", AngularGaugeChartLoader.class);
        loaders.put("funnelChart", FunnelChartLoader.class);
        loaders.put("pieChart", PieChartLoader.class);
        loaders.put("radarChart", RadarChartLoader.class);
        loaders.put("serialChart", SerialChartLoader.class);
        loaders.put("ganttChart", GanttChartLoader.class);
        loaders.put("xyChart", XYChartLoader.class);
        loaders.put("stockChart", StockChartLoader.class);

        loaders.put(MapViewer.TAG_NAME, MapViewerLoader.class);

        loaders.put(PivotTable.NAME, PivotTableLoader.class);

        return loaders;
    }

    @Override
    public Map<String, Class<? extends Component>> getComponents() {
        Map<String, Class<? extends Component>> components = new HashMap<>();

        components.put(Chart.NAME, WebChart.class);
        components.put(StockChart.NAME, WebStockChart.class);

        components.put(GoogleMapViewer.NAME, WebGoogleMapViewer.class);

        components.put(PivotTable.NAME, WebPivotTable.class);

        return components;
    }
}