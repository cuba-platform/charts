/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

public interface HasMargins<T> {

    /**
     * @return top spacing between chart and container
     */
    Integer getMarginTop();

    /**
     * Sets top spacing between chart and container.
     *
     * @param marginTop top spacing
     */
    T setMarginTop(Integer marginTop);

    /**
     * @return bottom spacing between chart and container
     */
    Integer getMarginBottom();

    /**
     * Sets bottom spacing between chart and container.
     *
     * @param marginBottom bottom spacing
     */
    T setMarginBottom(Integer marginBottom);

    /**
     * @return left-hand spacing between chart and container
     */
    Integer getMarginLeft();

    /**
     * Sets left-hand spacing between chart and container. marginLeft will be ignored if chart is
     * {@link com.haulmont.charts.gui.components.charts.SerialChart SerialChart} or
     * {@link com.haulmont.charts.gui.components.charts.XYChart XYCHart} and {@link Legend#autoMargins} is true.
     *
     * @param marginLeft left-hand spacing
     */
    T setMarginLeft(Integer marginLeft);

    /**
     * @return right-hand spacing between chart and container
     */
    Integer getMarginRight();

    /**
     * Sets right-hand spacing between chart and container. marginRight will be ignored if chart is
     * {@link com.haulmont.charts.gui.components.charts.SerialChart SerialChart} or
     * {@link com.haulmont.charts.gui.components.charts.XYChart XYCHart} and autoMargins property of the legend is true.
     *
     * @param marginRight right-hand spacing
     */
    T setMarginRight(Integer marginRight);
}