/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;
import com.haulmont.charts.gui.amcharts.model.FunnelValueRepresentation;
import com.haulmont.charts.gui.amcharts.model.LabelPosition;

/**
 * See documentation for properties of AmFunnelChart JS object.
 *
 * @author artamonov
 * @version $Id$
 */
public class FunnelChart extends SlicedChart<FunnelChart> {

    private static final long serialVersionUID = -8733320599720737456L;

    private String balloonText;

    private String baseWidth;

    private LabelPosition labelPosition;

    private String labelText;

    private String neckHeight;

    private String neckWidth;

    private String pullDistance;

    private Boolean rotate;

    private Integer startX;

    private Integer startY;

    private FunnelValueRepresentation valueRepresents;

    public FunnelChart() {
        super(ChartType.FUNNEL);
    }

    public String getBalloonText() {
        return balloonText;
    }

    public FunnelChart setBalloonText(String balloonText) {
        this.balloonText = balloonText;
        return this;
    }

    public String getBaseWidth() {
        return baseWidth;
    }

    public FunnelChart setBaseWidth(String baseWidth) {
        this.baseWidth = baseWidth;
        return this;
    }

    public LabelPosition getLabelPosition() {
        return labelPosition;
    }

    public FunnelChart setLabelPosition(LabelPosition labelPosition) {
        this.labelPosition = labelPosition;
        return this;
    }

    public String getLabelText() {
        return labelText;
    }

    public FunnelChart setLabelText(String labelText) {
        this.labelText = labelText;
        return this;
    }

    public String getNeckHeight() {
        return neckHeight;
    }

    public FunnelChart setNeckHeight(String neckHeight) {
        this.neckHeight = neckHeight;
        return this;
    }

    public String getNeckWidth() {
        return neckWidth;
    }

    public FunnelChart setNeckWidth(String neckWidth) {
        this.neckWidth = neckWidth;
        return this;
    }

    public String getPullDistance() {
        return pullDistance;
    }

    public FunnelChart setPullDistance(String pullDistance) {
        this.pullDistance = pullDistance;
        return this;
    }

    public Integer getStartX() {
        return startX;
    }

    public FunnelChart setStartX(Integer startX) {
        this.startX = startX;
        return this;
    }

    public Integer getStartY() {
        return startY;
    }

    public FunnelChart setStartY(Integer startY) {
        this.startY = startY;
        return this;
    }

    public FunnelValueRepresentation getValueRepresents() {
        return valueRepresents;
    }

    public FunnelChart setValueRepresents(FunnelValueRepresentation valueRepresents) {
        this.valueRepresents = valueRepresents;
        return this;
    }

    public Boolean getRotate() {
        return rotate;
    }

    public FunnelChart setRotate(Boolean rotate) {
        this.rotate = rotate;
        return this;
    }
}