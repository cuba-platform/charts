/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import com.haulmont.charts.gui.model.JsFunction;

public class HeatmapRendererOptions extends AbstractPivotObject {

    private static final long serialVersionUID = 4082501420650191687L;

    private JsFunction colorScaleGeneratorFunction;

    /**
     * @return a function that is used in color scale generator of heatmap renderer
     */
    public JsFunction getColorScaleGeneratorFunction() {
        return colorScaleGeneratorFunction;
    }

    /**
     * Sets a function that is used in color scale generator of heatmap renderer.
     *
     * @param colorScaleGeneratorFunction a function that is used in color scale generator of heatmap renderer
     * @return a refrence to this object
     */
    public HeatmapRendererOptions setColorScaleGeneratorFunction(JsFunction colorScaleGeneratorFunction) {
        this.colorScaleGeneratorFunction = colorScaleGeneratorFunction;
        return this;
    }
}
