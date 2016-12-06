/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

public class HeatmapRendererOptions extends AbstractPivotObject {

    private PivotJsFunction colorScaleGeneratorFunction;

    public PivotJsFunction getColorScaleGeneratorFunction() {
        return colorScaleGeneratorFunction;
    }

    public HeatmapRendererOptions setColorScaleGeneratorFunction(PivotJsFunction colorScaleGeneratorFunction) {
        this.colorScaleGeneratorFunction = colorScaleGeneratorFunction;
        return this;
    }
}
