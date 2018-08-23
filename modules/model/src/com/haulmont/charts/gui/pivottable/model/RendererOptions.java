/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

public class RendererOptions extends AbstractPivotObject {

    private static final long serialVersionUID = -1633377582757582532L;

    private HeatmapRendererOptions heatmap;

    private C3RendererOptions c3;

    /**
     * @return options which will be applied to heatmap renderers
     */
    public HeatmapRendererOptions getHeatmap() {
        return heatmap;
    }

    /**
     * Sets options which will be applied to heatmap renderers:
     * <ul>
     * <li>{@link Renderer#HEATMAP}</li>
     * <li>{@link Renderer#COL_HEATMAP}</li>
     * <li>{@link Renderer#ROW_HEATMAP}</li>
     * </ul>
     *
     * @param heatmap options which will be applied to heatmap renderers
     * @return a reference to this object
     */
    public RendererOptions setHeatmap(HeatmapRendererOptions heatmap) {
        this.heatmap = heatmap;
        return this;
    }

    /**
     * @return options which will be applied to chart renderers
     */
    public C3RendererOptions getC3() {
        return c3;
    }

    /**
     * Sets options which will be applied to chart renderers:
     * <ul>
     * <li>{@link Renderer#AREA_CHART}</li>
     * <li>{@link Renderer#BAR_CHART}</li>
     * <li>{@link Renderer#LINE_CHART}</li>
     * <li>{@link Renderer#STACKED_BAR_CHART}</li>
     * <li>{@link Renderer#SCATTER_CHART}</li>
     * </ul>
     *
     * @param c3 options which will be applied to chart renderers
     * @return a reference to this object
     */
    public RendererOptions setC3(C3RendererOptions c3) {
        this.c3 = c3;
        return this;
    }
}
