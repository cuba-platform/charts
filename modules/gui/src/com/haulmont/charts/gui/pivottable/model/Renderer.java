/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import com.haulmont.charts.gui.model.JsonEnum;

import javax.annotation.Nullable;

/**
 * An enum with predefined renderers.
 */
public enum Renderer implements JsonEnum {
    // standard
    TABLE("table"),
    TABLE_BAR_CHART("tableBarchart"),
    HEATMAP("heatmap"),
    ROW_HEATMAP("rowHeatmap"),
    COL_HEATMAP("colHeatmap"),
    // c3
    LINE_CHART("lineChart"),
    BAR_CHART("barChart"),
    STACKED_BAR_CHART("stackedBarChart"),
    AREA_CHART("areaChart"),
    SCATTER_CHART("scatterChart"),
    // d3
    TREEMAP("treemap"),
    // export
    TSV_EXPORT("TSVExport");

    private String id;

    Renderer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Renderer fromId(String id) {
        for (Renderer renderer : values()) {
            if (renderer.getId().equals(id)) {
                return renderer;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id;
    }
}
