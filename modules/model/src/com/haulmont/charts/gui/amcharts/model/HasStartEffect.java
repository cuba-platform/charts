/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.amcharts.model.charts.AngularGaugeChart;
import com.haulmont.charts.gui.amcharts.model.charts.CoordinateChartModel;
import com.haulmont.charts.gui.amcharts.model.charts.SlicedChart;

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