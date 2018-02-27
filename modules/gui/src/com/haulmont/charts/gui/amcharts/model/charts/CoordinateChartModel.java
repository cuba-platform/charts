/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.List;

public interface CoordinateChartModel<T extends CoordinateChartModel> extends ChartModel<T>, HasStartEffect<T>,
                                                                              HasColors<T> {
    /**
     * @return list of graphs
     */
    List<Graph> getGraphs();

    /**
     * Sets the list of graphs belonging to this chart.
     *
     * @param graphs list of graphs
     */
    T setGraphs(List<Graph> graphs);

    /**
     * Adds graphs to the chart.
     *
     * @param graphs graphs
     */
    T addGraphs(Graph... graphs);

    /**
     * @return list of ValueAxis
     */
    List<ValueAxis> getValueAxes();

    /**
     * Sets list of ValueAxis. Chart creates one value axis automatically.
     *
     * @param valueAxes list of ValueAxis
     */
    T setValueAxes(List<ValueAxis> valueAxes);

    /**
     * Adds ValueAxes.
     *
     * @param valueAxes the value axes
     */
    T addValueAxes(ValueAxis... valueAxes);

    /**
     * @return list of guides
     */
    List<Guide> getGuides();

    /**
     * Sets list of guides. Instead of adding guides to the axes, you can push all of them to this list. In case guide
     * has category or date defined, it will automatically will be assigned to the category axis. Otherwise to first
     * value axis, unless you specify a different valueAxis for the guide.
     *
     * @param guides list of guides
     */
    T setGuides(List<Guide> guides);

    /**
     * Adds guides.
     *
     * @param guides the guides
     */
    T addGuides(Guide... guides);

    /**
     * @return true if grid should be drawn above the graphs or below
     */
    Boolean getGridAboveGraphs();

    /**
     * Set grid above graphs to true if grid should be drawn above the graphs or below. Will not work
     * properly with 3D charts.
     *
     * @param gridAboveGraphs grid above graphs option
     */
    T setGridAboveGraphs(Boolean gridAboveGraphs);

    /**
     * @return true if the animation should be sequenced, false if all objects should appear at once
     */
    Boolean getSequencedAnimation();

    /**
     * Specifies whether the animation should be sequenced or all objects should appear at once.
     *
     * @param sequencedAnimation sequenced animation option
     */
    T setSequencedAnimation(Boolean sequencedAnimation);

    /**
     * @return initial opacity of the column/line
     */
    Double getStartAlpha();

    /**
     * Sets the initial opacity of the column/line. If you set startDuration to a value higher than 0, the
     * columns/lines will fade in from startAlpha. Value range is 0 - 1.
     *
     * @param startAlpha - the start alpha
     */
    T setStartAlpha(Double startAlpha);

    /**
     * @return target of URL
     */
    String getUrlTarget();

    /**
     * Sets target of URL.
     *
     * @param urlTarget the URL target string
     */
    T setUrlTarget(String urlTarget);
}