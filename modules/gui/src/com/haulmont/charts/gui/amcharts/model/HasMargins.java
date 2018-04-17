/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.components.charts.RadarChart;
import com.haulmont.charts.gui.components.charts.RectangularChart;
import com.haulmont.charts.gui.components.charts.SlicedChart;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.components.charts.XYChart;

public interface HasMargins<T> {

    /**
     * @return top spacing
     */
    Integer getMarginTop();

    /**
     * Sets top spacing. If not set the default value is 10.
     * <p>
     * If is used for {@link Legend Legend} the default value is 0.
     * <p>
     * If is used for {@link RadarChart} the default value is 0.
     * <p>
     * If is used for chart based on {@link RectangularChart}
     * (GanttChart, SerialChart, XYChart) the default value is 20.
     * <p>
     * If is used for chart based on {@link SlicedChart} the default value is 10.
     * <p>
     * If is used for {@link PanelsSettings} the default value is 0.
     *
     * @param marginTop top spacing
     */
    T setMarginTop(Integer marginTop);

    /**
     * @return bottom spacing
     */
    Integer getMarginBottom();

    /**
     * Sets bottom spacing. If not set the default value is 10.
     * <p>
     * If is used for {@link Legend Legend} default value is 0.
     * <p>
     * If is used for {@link RadarChart} the default value is 0.
     * <p>
     * If is used for chart based on {@link RectangularChart}
     * (GanttChart, SerialChart, XYChart) the default value is 20.
     * <p>
     * If is used for chart based on {@link SlicedChart} (FunnelChart, PieChart) the default value is 10.
     * <p>
     * If is used for {@link PanelsSettings} the default value is 0.
     *
     * @param marginBottom bottom spacing
     */
    T setMarginBottom(Integer marginBottom);

    /**
     * @return left-hand spacing
     */
    Integer getMarginLeft();

    /**
     * Sets left-hand spacing.
     * <p>
     * marginLeft will be ignored if chart is {@link SerialChart} or {@link XYChart} and {@link Legend#autoMargins}
     * is true.
     * <p>
     * If is used for {@link Legend Legend} the default value is 20.
     * <p>
     * If is used for {@link RadarChart} the default value is 0.
     * <p>
     * If is used for chart based on {@link RectangularChart} (GanttChart, SerialChart, XYChart) the default value is
     * 20.
     * <p>
     * If is used for chart based on {@link SlicedChart} the default value is 0.
     * <p>
     * If is used for {@link PanelsSettings} the default value is 0.
     *
     * @param marginLeft left-hand spacing
     */
    T setMarginLeft(Integer marginLeft);

    /**
     * @return right-hand spacing
     */
    Integer getMarginRight();

    /**
     * Sets right-hand spacing.
     * <p>
     * marginRight will be ignored if chart is {@link SerialChart} or {@link XYChart} and {@link Legend#autoMargins}
     * is true.
     * <p>
     * If is used for {@link Legend Legend} the default value is 20.
     * <p>
     * If is used for {@link RadarChart} the default value is 0.
     * <p>
     * If is used for chart based on {@link RectangularChart} (GanttChart, SerialChart, XYChart) the default value is
     * 20.
     * <p>
     * If is used for chart based on {@link SlicedChart} (FunnelChart, PieChart) the default value is 0.
     * <p>
     * If is used for {@link PanelsSettings} the default value is 0.
     *
     * @param marginRight right-hand spacing
     */
    T setMarginRight(Integer marginRight);
}