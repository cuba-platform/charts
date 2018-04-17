/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.components.charts.AngularGaugeChart;
import com.haulmont.charts.gui.amcharts.model.charts.CoordinateChartModel;
import com.haulmont.charts.gui.components.charts.SlicedChart;

public interface HasStartEffect<T> {

    /**
     * @return animation effect
     */
    AnimationEffect getStartEffect();

    /**
     * Sets animation effect.
     * <p>
     * If you use {@link AngularGaugeChart} animation effect will be applied for the arrow. If not set the default
     * value is EASE_IN_SINE.
     * <p>
     * If you use charts based on {@link CoordinateChartModel} (GanttChart, RadarChart, SerialChart, XYChart) default
     * value is ELASTIC.
     * <p>
     * If you use chart based on {@link SlicedChart} default value is BOUNCE.
     *
     * @param startEffect the start effect
     */
    T setStartEffect(AnimationEffect startEffect);

    /**
     * @return duration of the animation, in seconds
     */
    Double getStartDuration();

    /**
     * Sets duration of the animation, in seconds.
     * <p>
     * If you use {@link AngularGaugeChart} default value is 1.
     * <p>
     * If you use charts based on {@link CoordinateChartModel} (GanttChart, RadarChart, SerialChart, XYChart) default
     * value is 0.
     * <p>
     * If you use chart based on {@link SlicedChart} default value is 1.
     *
     * @param startDuration the start duration
     */
    T setStartDuration(Double startDuration);
}