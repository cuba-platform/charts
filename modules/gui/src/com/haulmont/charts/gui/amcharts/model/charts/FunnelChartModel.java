/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.FunnelValueRepresentation;
import com.haulmont.charts.gui.amcharts.model.LabelPosition;

public interface FunnelChartModel<T extends FunnelChartModel> extends SlicedChartModel<T> {
    /**
     * @return balloon text
     */
    String getBalloonText();

    /**
     * Sets balloon text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]]. Also can
     * be used fields in the chart such as titleField, valueField etc. Fields that not used in the chart can be added
     * by using additionalFields. HTML tags can also be used. If not set the default value is
     * "[[title]]:[[value]]\n[[description]]".
     *
     * @param balloonText balloon text string
     */
    T setBalloonText(String balloonText);

    /**
     * @return width of a base (first slice) of a chart
     */
    String getBaseWidth();

    /**
     * Sets width of a base (first slice) of a chart. 100% means it will occupy all available space. If not set the
     * default value is 100%.
     *
     * @param baseWidth the base width
     */
    T setBaseWidth(String baseWidth);

    /**
     * @return label position
     */
    LabelPosition getLabelPosition();

    /**
     * Specifies where labels should be placed. Allowed values are left, center, right. If you set left or right, you
     * should increase left or right margin in order labels to be visible. If not set the default value is CENTER.
     *
     * @param labelPosition the label position
     */
    T setLabelPosition(LabelPosition labelPosition);

    /**
     * @return label text
     */
    String getLabelText();

    /**
     * Sets label text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]]. Also can
     * be used fields in the chart such as titleField, valueField etc. Fields that not used in the chart can be added
     * by using additionalFields. If not set the default value is "[[title]]: [[value]]".
     *
     * @param labelText label text string
     */
    T setLabelText(String labelText);

    /**
     * @return height of a funnel neck
     */
    String getNeckHeight();

    /**
     * Sets height of a funnel neck. If default value, zero is used, the funnel won't have neck at all, which will make
     * it look like pyramid. If not set the default value is "0".
     *
     * @param neckHeight the neck height
     */
    T setNeckHeight(String neckHeight);

    /**
     * @return width of a funnel neck
     */
    String getNeckWidth();

    /**
     * Sets width of a funnel neck. If default value, zero is used, the funnel won't have neck at all, which will make
     * it look like pyramid. If not set the default value is "0".
     *
     * @param neckWidth the neck width
     */
    T setNeckWidth(String neckWidth);

    /**
     * @return pull distance
     */
    String getPullDistance();

    /**
     * Sets the distance by which slice should be pulled when user clicks on it. If not set the default value is 30.
     *
     * @param pullDistance the pull distance
     */
    T setPullDistance(String pullDistance);

    /**
     * @return initial X coordinate of slices
     */
    Integer getStartX();

    /**
     * Sets initial X coordinate of slices. They will animate to the final X position from this one. If not set the
     * default value is 0.
     *
     * @param startX the start X
     */
    T setStartX(Integer startX);

    /**
     * @return initial Y coordinate of slices
     */
    Integer getStartY();

    /**
     * Sets initial y coordinate of slices. They will animate to the final y position from this one. If not set the
     * default value is 0.
     *
     * @param startY the start Y
     */
    T setStartY(Integer startY);

    /**
     * @return value represents
     */
    FunnelValueRepresentation getValueRepresents();

    /**
     * Sets the value represents. By default, the height of a slice represents it's value. Set this property to "area"
     * if you want the area of a slice to represent value. If not set the default value is HEIGHT.
     *
     * @param valueRepresents the value represents
     */
    T setValueRepresents(FunnelValueRepresentation valueRepresents);

    /**
     * @return true if rotate is enabled
     */
    Boolean getRotate();

    /**
     * If rotate is set to true, the funnel will be rotated and will became a pyramid. If not set the default value
     * is false.
     *
     * @param rotate rotate option
     */
    T setRotate(Boolean rotate);

    /**
     * @return the angle of the 3D part of the chart
     */
    Integer getAngle();

    /**
     * Sets the angle of the 3D part of the chart. This creates a 3D effect (if the depth3D is greater than 0). If
     * not set the default value is 0.
     *
     * @param angle the angle
     */
    T setAngle(Integer angle);

    /**
     * @return the depth of funnel/pyramid
     */
    Integer getDepth3D();

    /**
     * Sets the depth of funnel/pyramid. Set angle to greater than 0 value in order this to work. Note,
     * neckHeight/neckWidth will become 0 if you set these properties to bigger than 0 values.
     *
     * @param depth3D the depth 3D
     */
    T setDepth3D(Integer depth3D);
}