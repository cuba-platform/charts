/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.GradientType;
import com.haulmont.charts.gui.model.JsFunction;

public interface PieChartModel<T extends PieChartModel> extends SlicedChartModel<T> {
    /**
     * @return angle
     */
    Integer getAngle();

    /**
     * Sets pie lean angle (for 3D effect). Valid range is 0 - 90.
     *
     * @param angle the angle
     */
    T setAngle(Integer angle);

    /**
     * @return balloon text
     */
    String getBalloonText();

    /**
     * Sets balloon text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]]. Also can
     * be used fields in the chart such as titleField, valueField etc. Fields that not used in the chart can be added
     * by using additionalFields. HTML tags can also be used.
     *
     * @param balloonText balloon text string
     */
    T setBalloonText(String balloonText);

    /**
     * @return depth of the pie
     */
    Integer getDepth3D();

    /**
     * Sets depth of the pie (for 3D effect).
     *
     * @param depth3D the depth 3D
     */
    T setDepth3D(Integer depth3D);

    /**
     * @return inner radius of the pie
     */
    String getInnerRadius();

    /**
     * Sets inner radius of the pie, in pixels or percents.
     *
     * @param innerRadius inner radius in pixels or percents
     */
    T setInnerRadius(String innerRadius);

    /**
     * @return distance between the label and the slice, in pixels
     */
    Integer getLabelRadius();

    /**
     * Sets the distance between the label and the slice, in pixels. You can use negative values to put the label on
     * the slice.
     *
     * @param labelRadius distance between the label and the slice, in pixels
     */
    T setLabelRadius(Integer labelRadius);

    /**
     * @return label radius field
     */
    String getLabelRadiusField();

    /**
     * Sets name of the field from data provider which specifies the length of a tick. Note, the chart will not try to
     * arrange labels automatically if this property is set.
     *
     * @param labelRadiusField label radius field string
     */
    T setLabelRadiusField(String labelRadiusField);

    /**
     * @return label text
     */
    String getLabelText();

    /**
     * Sets label text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]]. Also can
     * be used fields in the chart such as titleField, valueField etc. Fields that not used in the chart can be added
     * by using additionalFields.
     *
     * @param labelText label text string
     */
    T setLabelText(String labelText);

    /**
     * @return minimum radius
     */
    Integer getMinRadius();

    /**
     * Sets minimum radius of the pie, in pixels.
     *
     * @param minRadius the minimum radius
     */
    T setMinRadius(Integer minRadius);

    /**
     * @return opacity for a slices
     */
    Double getPieAlpha();

    /**
     * Sets opacity for a slices.
     *
     * @param pieAlpha the pie alpha
     */
    T setPieAlpha(Double pieAlpha);

    /**
     * @return X position of a pie center
     */
    String getPieX();

    /**
     * Sets X position of a pie center, in pixels or in percents.
     *
     * @param pieX X position of a pie center
     */
    T setPieX(String pieX);

    /**
     * @return Y position of a pie center
     */
    String getPieY();

    /**
     * Sets Y position of a pie center, in pixels or in percents.
     *
     * @param pieY Y position of a pie center
     */
    T setPieY(String pieY);

    /**
     * @return pull out radius
     */
    String getPullOutRadius();

    /**
     * 	Sets pull out radius, in pixels or percents
     *
     * @param pullOutRadius pull out radius
     */
    T setPullOutRadius(String pullOutRadius);

    /**
     * @return radius
     */
    String getRadius();

    /**
     * Sets radius of a pie, in pixels or percents. By default, radius is calculated automatically.
     *
     * @param radius the radius of a pie
     */
    T setRadius(String radius);

    /**
     * @return angle of the first slice
     */
    Integer getStartAngle();

    /**
     * Sets angle of the first slice, in degrees. This will work properly only if depth3D is set to 0. If depth3D is
     * greater than 0, then there can be two angles only: 90 and 270. Value range is 0-360.
     *
     * @param startAngle angle of the first slice in degree
     */
    T setStartAngle(Integer startAngle);

    /**
     * @return start radius
     */
    String getStartRadius();

    /**
     * Sets radius of the positions from which the slices will fly in.
     *
     * @param startRadius the start radius
     */
    T setStartRadius(String startRadius);

    /**
     * @return true if adjust precision is enabled
     */
    Boolean getAdjustPrecision();

    /**
     * Set this to true, when percent of a sum of all slices is not equal to 100%, number of decimals will be
     * increased so that sum would become 100%. It can happen because of a rounding.
     *
     * @param adjustPrecision adjust precision option
     */
    T setAdjustPrecision(Boolean adjustPrecision);

    /**
     * @return function
     */
    JsFunction getBalloonFunction();

    /**
     * Sets the function, the graph will call it and pass GraphDataItem object to it. This function should return a
     * string which will be displayed in a balloon.
     *
     * @param balloonFunction the balloon function
     */
    T setBalloonFunction(JsFunction balloonFunction);

    /**
     * @return gradient type
     */
    GradientType getGradientType();

    /**
     * Sets type of gradient. Use gradientRatio to create gradients.
     *
     * @param gradientType the gradient type
     */
    T setGradientType(GradientType gradientType);
}