/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

public interface HasStartEffect<T> {

    /**
     * @return animation effect
     */
    AnimationEffect getStartEffect();

    /**
     * Sets animation effect. If you use
     * {@link com.haulmont.charts.gui.components.charts.AngularGaugeChart AngularGaugeChart} animation effect will be
     * applied for the arrow.
     *
     * @param startEffect the start effect
     */
    T setStartEffect(AnimationEffect startEffect);

    /**
     * @return duration of the animation, in seconds
     */
    Double getStartDuration();

    /**
     * Sets duration of the animation, in seconds
     *
     * @param startDuration the start duration
     */
    T setStartDuration(Double startDuration);
}