/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.GradientType;
import com.haulmont.charts.gui.model.JsFunction;

public interface PieChartModel<T extends PieChartModel> extends SlicedChartModel<T> {
    Integer getAngle();
    T setAngle(Integer angle);

    String getBalloonText();
    T setBalloonText(String balloonText);

    Integer getDepth3D();
    T setDepth3D(Integer depth3D);

    String getInnerRadius();
    T setInnerRadius(String innerRadius);

    Integer getLabelRadius();
    T setLabelRadius(Integer labelRadius);

    String getLabelRadiusField();
    T setLabelRadiusField(String labelRadiusField);

    String getLabelText();
    T setLabelText(String labelText);

    Integer getMinRadius();
    T setMinRadius(Integer minRadius);

    Double getPieAlpha();
    T setPieAlpha(Double pieAlpha);

    String getPieX();
    T setPieX(String pieX);

    String getPieY();
    T setPieY(String pieY);

    String getPullOutRadius();
    T setPullOutRadius(String pullOutRadius);

    String getRadius();
    T setRadius(String radius);

    Integer getStartAngle();
    T setStartAngle(Integer startAngle);

    String getStartRadius();
    T setStartRadius(String startRadius);

    Boolean getAdjustPrecision();
    T setAdjustPrecision(Boolean adjustPrecision);

    JsFunction getBalloonFunction();
    T setBalloonFunction(JsFunction balloonFunction);

    GradientType getGradientType();
    T setGradientType(GradientType gradientType);
}