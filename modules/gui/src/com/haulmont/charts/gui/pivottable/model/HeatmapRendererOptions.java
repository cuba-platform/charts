/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import com.haulmont.charts.gui.model.JsFunction;

public class HeatmapRendererOptions extends AbstractPivotObject {

    private static final long serialVersionUID = 4082501420650191687L;

    private JsFunction colorScaleGeneratorFunction;

    public JsFunction getColorScaleGeneratorFunction() {
        return colorScaleGeneratorFunction;
    }

    public HeatmapRendererOptions setColorScaleGeneratorFunction(JsFunction colorScaleGeneratorFunction) {
        this.colorScaleGeneratorFunction = colorScaleGeneratorFunction;
        return this;
    }
}
