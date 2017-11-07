/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui;

import com.haulmont.charts.gui.components.charts.*;
import com.haulmont.charts.gui.components.map.GoogleMapViewer;
import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.xml.layout.loaders.charts.*;
import com.haulmont.charts.gui.xml.layout.loaders.map.MapViewerLoader;
import com.haulmont.charts.gui.xml.layout.loaders.pivottable.PivotTableLoader;
import com.haulmont.charts.web.gui.components.charts.amcharts.*;
import com.haulmont.charts.web.gui.components.map.google.WebGoogleMapViewer;
import com.haulmont.charts.web.gui.components.pivottable.WebPivotTable;
import com.haulmont.cuba.gui.ComponentPalette;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Charts palette.
 *
 * @deprecated Now components are configured using "charts-web-components.xml" configuration.
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

        loaders.put(MapViewer.NAME, MapViewerLoader.class);

        loaders.put(PivotTable.NAME, PivotTableLoader.class);

        return loaders;
    }

    @Override
    public Map<String, Class<? extends Component>> getComponents() {
        Map<String, Class<? extends Component>> components = new HashMap<>();

        components.put(PieChart.NAME, WebPieChart.class);
        components.put(FunnelChart.NAME, WebFunnelChart.class);
        components.put(AngularGaugeChart.NAME, WebAngularGaugeChart.class);
        components.put(RadarChart.NAME, WebRadarChart.class);
        components.put(SerialChart.NAME, WebSerialChart.class);
        components.put(GanttChart.NAME, WebGanttChart.class);
        components.put(XYChart.NAME, WebXYChart.class);

        components.put(StockChart.NAME, WebStockChart.class);

        components.put(GoogleMapViewer.NAME, WebGoogleMapViewer.class); // for backward compatibility only
        components.put(MapViewer.NAME, WebGoogleMapViewer.class); // for backward compatibility only

        components.put(PivotTable.NAME, WebPivotTable.class);

        return components;
    }
}