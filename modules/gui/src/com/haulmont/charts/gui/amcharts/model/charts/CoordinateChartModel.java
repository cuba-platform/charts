/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.List;

public interface CoordinateChartModel<T extends CoordinateChartModel> extends ChartModel<T>, HasStartEffect<T>,
                                                                              HasColors<T> {
    List<Graph> getGraphs();
    T setGraphs(List<Graph> graphs);
    T addGraphs(Graph... graphs);

    List<ValueAxis> getValueAxes();
    T setValueAxes(List<ValueAxis> valueAxes);
    T addValueAxes(ValueAxis... valueAxes);

    List<Guide> getGuides();
    T setGuides(List<Guide> guides);
    T addGuides(Guide... guides);

    Boolean getGridAboveGraphs();
    T setGridAboveGraphs(Boolean gridAboveGraphs);

    Boolean getSequencedAnimation();
    T setSequencedAnimation(Boolean sequencedAnimation);

    Double getStartAlpha();
    T setStartAlpha(Double startAlpha);

    String getUrlTarget();
    T setUrlTarget(String urlTarget);
}