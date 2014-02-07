/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;

/**
 * See documentation for properties of AmXYChart JS object.
 *
 * @author artamonov
 * @version $Id$
 */
public class XYChart extends RectangularChart<XYChart> {

    private static final long serialVersionUID = 3259485360498054262L;

    private Boolean hideXScrollbar;

    private Boolean hideYScrollbar;

    private Integer maxZoomFactor;

    public XYChart() {
        super(ChartType.XY);
    }

    public Boolean getHideXScrollbar() {
        return hideXScrollbar;
    }

    public XYChart setHideXScrollbar(Boolean hideXScrollbar) {
        this.hideXScrollbar = hideXScrollbar;
        return this;
    }

    public Boolean getHideYScrollbar() {
        return hideYScrollbar;
    }

    public XYChart setHideYScrollbar(Boolean hideYScrollbar) {
        this.hideYScrollbar = hideYScrollbar;
        return this;
    }

    public Integer getMaxZoomFactor() {
        return maxZoomFactor;
    }

    public XYChart setMaxZoomFactor(Integer maxZoomFactor) {
        this.maxZoomFactor = maxZoomFactor;
        return this;
    }
}