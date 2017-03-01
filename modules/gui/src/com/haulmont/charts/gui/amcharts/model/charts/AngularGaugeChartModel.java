/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.List;

public interface AngularGaugeChartModel<T extends AngularGaugeChartModel> extends ChartModel<T>,
                                                                                  HasMargins<T>, HasStartEffect<T> {

    Boolean getAdjustSize();
    T setAdjustSize(Boolean adjustSize);

    List<GaugeArrow> getArrows();
    T setArrows(List<GaugeArrow> arrows);
    T addArrows(GaugeArrow... arrows);

    List<GaugeAxis> getAxes();
    T setAxes(List<GaugeAxis> axes);
    T addAxes(GaugeAxis... axes);

    Boolean getClockWiseOnly();
    T setClockWiseOnly(Boolean clockWiseOnly);

    Double getFaceAlpha();
    T setFaceAlpha(Double faceAlpha);

    Double getFaceBorderAlpha();
    T setFaceBorderAlpha(Double faceBorderAlpha);

    Color getFaceBorderColor();
    T setFaceBorderColor(Color faceBorderColor);

    Integer getFaceBorderWidth();
    T setFaceBorderWidth(Integer faceBorderWidth);

    Color getFaceColor();
    T setFaceColor(Color faceColor);

    Pattern getFacePattern();
    T setFacePattern(Pattern facePattern);

    String getGaugeX();
    T setGaugeX(String gaugeX);

    String getGaugeY();
    T setGaugeY(String gaugeY);

    Integer getMinRadius();
    T setMinRadius(Integer minRadius);
}