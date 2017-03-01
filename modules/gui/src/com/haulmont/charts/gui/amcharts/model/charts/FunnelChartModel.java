/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.FunnelValueRepresentation;
import com.haulmont.charts.gui.amcharts.model.LabelPosition;

public interface FunnelChartModel<T extends FunnelChartModel> extends SlicedChartModel<T> {
    String getBalloonText();
    T setBalloonText(String balloonText);

    String getBaseWidth();
    T setBaseWidth(String baseWidth);

    LabelPosition getLabelPosition();
    T setLabelPosition(LabelPosition labelPosition);

    String getLabelText();
    T setLabelText(String labelText);

    String getNeckHeight();
    T setNeckHeight(String neckHeight);

    String getNeckWidth();
    T setNeckWidth(String neckWidth);

    String getPullDistance();
    T setPullDistance(String pullDistance);

    Integer getStartX();
    T setStartX(Integer startX);

    Integer getStartY();
    T setStartY(Integer startY);

    FunnelValueRepresentation getValueRepresents();
    T setValueRepresents(FunnelValueRepresentation valueRepresents);

    Boolean getRotate();
    T setRotate(Boolean rotate);

    Integer getAngle();
    T setAngle(Integer angle);

    Integer getDepth3D();
    T setDepth3D(Integer depth3D);
}