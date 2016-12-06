/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

public class RendererOptions extends AbstractPivotObject {

    private static final long serialVersionUID = -1633377582757582532L;

    /**
     * Options which will be applied to heatmap renderers:
     * <ul>
     *     <li>{@link Renderer#HEATMAP}</li>
     *     <li>{@link Renderer#COL_HEATMAP}</li>
     *     <li>{@link Renderer#ROW_HEATMAP}</li>
     * </ul>
     */
    private HeatmapRendererOptions heatmap;

    /**
     * Options which will be applied to chart renderers:
     * <ul>
     *     <li>{@link Renderer#AREA_CHART}</li>
     *     <li>{@link Renderer#BAR_CHART}</li>
     *     <li>{@link Renderer#LINE_CHART}</li>
     *     <li>{@link Renderer#STACKED_BAR_CHART}</li>
     *     <li>{@link Renderer#SCATTER_CHART}</li>
     * </ul>
     */
    private C3RendererOptions c3;

    public HeatmapRendererOptions getHeatmap() {
        return heatmap;
    }

    public RendererOptions setHeatmap(HeatmapRendererOptions heatmap) {
        this.heatmap = heatmap;
        return this;
    }

    public C3RendererOptions getC3() {
        return c3;
    }

    public RendererOptions setC3(C3RendererOptions c3) {
        this.c3 = c3;
        return this;
    }
}
